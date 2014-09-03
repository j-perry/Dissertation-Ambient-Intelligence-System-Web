/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.servlets.modules;

// local libraries
import ami.web.core.db.*;
import ami.web.core.intelligence.ExperienceBank;
import ami.web.core.models.client.DataBase;

// Java APIs
import java.io.*;
import java.util.*;

// third party libraries
import org.json.simple.*;

/**
 *
 * @author Jonathan Perry
 */
public class SystemOverview extends ContextView {

    private InitialContextTable initialTable;
    private MonitoringContextTable monitoringTable;
    private FileWriter fWriter;

    // overall context
    private ArrayList<DataBase> overallContext;

    // To store data from database
    private ArrayList<DataBase> temperatureData;
    private ArrayList<DataBase> movementData;

    // JSON
    private JSONObject overviewTemp;
    private JSONObject overviewDistance;
    

    public SystemOverview() {
        initialTable = new InitialContextTable();
        monitoringTable = new MonitoringContextTable();
        fWriter = null;
        temperatureData = new ArrayList<DataBase>();
        movementData = new ArrayList<DataBase>();
        
        overallContext = new ArrayList<DataBase>();
    }
    
    public SystemOverview(ArrayList<DataBase> overallContext) {
        initialTable = new InitialContextTable();
        monitoringTable = new MonitoringContextTable();
        fWriter = null;
        temperatureData = new ArrayList<DataBase>();
        movementData = new ArrayList<DataBase>();
        
        this.overallContext = overallContext;
    }

    /**
     * Retrieves temperature data from InitialContext table
     * 
     * ------
     * 
     * Retrieves overview of temperature data from InitialContext if MonitoringContext 
     * is empty. 
     * 
     * If MonitoringContext isn't empty, generate an updated model of both
     * tables (as depicted in View.java) and retrieve values based on the "temperature"
     * field type.
     * 
     * 
     * We'll need to change this to the general table later!!!
     */
    public void getTemperatureData() {
        final String temp_field = "temperature";
        
        if(!overallContext.isEmpty()) {
            System.out.println("overallContext IS NOT EMPTY");
            System.out.println("It's size is: " + overallContext.size() );
        }
        
        // get data from initial context table
        if (overallContext.isEmpty()) {
            
            System.out.println("getTemperatureData() - overallContext is empty");
            
            // check table MonitoringContext exists
            //
            // if it exists, get data from MonitoringContext
            // AND from InitialContext to create an updated model based on
            // our ExperienceBank
            if(monitoringTable.isEmpty() == false) {
                System.out.println("monitoringTable.isEmpty() == false");
                
                initialTable.open();
                monitoringTable.open();
                
                ArrayList<DataBase> initialTemperatureData = initialTable.retrieveOverviewByName(temp_field);
                ArrayList<DataBase> monitoringTemperatureData = monitoringTable.retrieveOverviewByName(temp_field);
                
                ExperienceBank exBank = new ExperienceBank();
                
                // create an updated model of data specifically for field "temperature"
                temperatureData = exBank.create(initialTemperatureData, monitoringTemperatureData);
                
                initialTable.close();
                monitoringTable.close();
            }
            else {
                System.out.println("monitoringTable.isEmpty() == true");
                
                // otherwise get data from InitialContext
                initialTable.open();
                temperatureData = initialTable.retrieveOverviewByName(temp_field);
                initialTable.close();
            }
        } else {
            
            System.out.println("getTemperatureData()");
            System.out.println("DETAILS...");
            
            // get temperature values from all the values in overallContext 
            for (DataBase entry : overallContext) {
                // if entry type is "temperature"
                if (entry.getType().equals(temp_field)) {
                    // store it
//                    System.out.println("TYPE: " + entry.getType() );
//                    System.out.println("HOSTNAME: " + entry.getHostname() );
                    temperatureData.add(entry);
                }
            }
            
            System.out.println("size(): " + temperatureData.size());
        }

    }
    
    /**
     * Retrieves ultra sonic transceiver data from INITIAL MONITORING TABLE
     *
     * We'll need to change this to the general table later!!!
     */
    public void getMovementData() {
        String movement_field = "movement";
        
        // get data from initial context table
        if (overallContext.isEmpty()) {
                        
            System.out.println("getMovementData() - overallContext is empty");
            
            // check table MonitoringContext exists
            //
            // if it exists, get data from MonitoringContext
            // AND from InitialContext to create an updated model based on
            // our ExperienceBank
            if(monitoringTable.isEmpty() == true) {
                initialTable.open();
                monitoringTable.open();
                
                ArrayList<DataBase> initialMovementData = initialTable.retrieveOverviewByName(movement_field);
                ArrayList<DataBase> monitoringMovementData = monitoringTable.retrieveOverviewByName(movement_field);
                
                ExperienceBank exBank = new ExperienceBank();
                
                // create an updated model of data specifically for field "movement"
                movementData = exBank.create(initialMovementData, monitoringMovementData);
                
                initialTable.close();
                monitoringTable.close();
            }
            else {
                // otherwise get data from InitialContext
                initialTable.open();
                movementData = initialTable.retrieveOverviewByName(movement_field);
                initialTable.close();
            }
        } else {
            
            System.out.println();
            System.out.println("getMovementData()");
            System.out.println();
            
            // get temperature values from all the values in overallContext 
            for (DataBase entry : overallContext) {
                // if entry type is "movement"
                if (entry.getType().equals(movement_field)) {
                    // distance limit (otherwise it won't show in the graph!)
                    if(entry.getValue() < 3000) {
                        // store it
                        movementData.add(entry);
                    } 
                    
                }
            }
        }
        
//        // get data from initial context table
//        if (overallContext.isEmpty()) {
//            monitoringTable.open();
//            temperatureData = monitoringTable.retrieveOverviewByName(movement_field);
//            monitoringTable.close();
//        } else {
//            // get ultrasonic values from all the values in overallContext 
//            for (DataBase entry : overallContext) {
//                // if entry type is "movement"
//                if (entry.getType().equals(movement_field)) {
//                    // store it
//                    ultrasonicData.add(entry);
//                }
//            }
//        }

    }

    /**
     * Serialize all our data into a JSON structure
     *
     * @param path
     */
    public void serializeDataToJson(String path) {
        
        /*
         *      Temperature
         */
        if (!temperatureData.isEmpty()) {
            String context = "Temperature";
            
//            for(DataBase e : temperatureData) {
//                System.out.println("TemperatureVal: " + e.getValue() );
//            }

            // parse temperature data and return a JSON representation of it
            // with data for each day averaged out
            JSONObject temperatureOverview = super.parseOverallContext(temperatureData, context);
            
            // write temperature overview data to a JSON file            
            String temperature_overview_file = "temperature_overview.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;

            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(temperatureOverview.toJSONString());
                fWriter.flush();
                fWriter.close();
                
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println();
                System.out.println("Temperature data JSON File written");
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        
        /*
         *      Ultrasonic
         */
        if (!movementData.isEmpty()) {
            String context = "Movement";
            
            System.out.println("movementData size: " + movementData.size() );
            
            JSONObject movementOverview = super.parseOverallContext(movementData, context);
            
            // write temperature overview data to a JSON file
            String temperature_overview_file = "movement_overview.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;

            // write temperature overview data to file
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(movementOverview.toJSONString());
                fWriter.flush();
                fWriter.close();
                
                
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println();
                System.out.println("Movement data JSON File written");
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}