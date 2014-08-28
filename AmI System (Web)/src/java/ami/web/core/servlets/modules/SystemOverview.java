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
    private ArrayList<DataBase> ultrasonicData;

    // JSON
    private JSONObject overviewTemp;
    private JSONObject overviewDistance;
    

    public SystemOverview() {
        initialTable = new InitialContextTable();
        monitoringTable = new MonitoringContextTable();
        fWriter = null;
        temperatureData = new ArrayList<DataBase>();
        ultrasonicData = new ArrayList<DataBase>();
        
        overallContext = new ArrayList<DataBase>();
    }
    
    public SystemOverview(ArrayList<DataBase> overallContext) {
        initialTable = new InitialContextTable();
        monitoringTable = new MonitoringContextTable();
        fWriter = null;
        temperatureData = new ArrayList<DataBase>();
        ultrasonicData = new ArrayList<DataBase>();
        
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
        String temp_field = "temperature";
        
        // get data from initial context table
        if (overallContext.isEmpty()) {
            
            
            // check table MonitoringContext exists
            //
            // if it exists, get data from MonitoringContext
            // AND from InitialContext to create an updated model based on
            // our ExperienceBank
            if(monitoringTable.isEmpty() == true) {
                initialTable.open();
                monitoringTable.open();
                
                ArrayList<DataBase> initialTemperatureData = initialTable.retrieveOverviewByName(temp_field);
                ArrayList<DataBase> monitoringTemperatureData = monitoringTable.retrieveOverviewByName(temp_field);
                
                ExperienceBank exBank = new ExperienceBank();
                
                // create an updated model of data specifically for field "temperature"
                temperatureData = exBank.merge(initialTemperatureData, monitoringTemperatureData);
                
                initialTable.close();
                monitoringTable.close();
            }
            else {
                // otherwise get data from InitialContext
                initialTable.open();
                temperatureData = initialTable.retrieveOverviewByName(temp_field);
                initialTable.close();
            }
                        
            
//            monitoringTable.open();
//            temperatureData = monitoringTable.retrieveOverviewByContext(temp_field);
//            monitoringTable.close();
        } else {
            
            System.out.println();
            System.out.println("getTemperatureData()");
            System.out.println();
            
            // get temperature values from all the values in overallContext 
            for (DataBase entry : overallContext) {
                // if entry type is "temperature"
                if (entry.getType().equals(temp_field)) {
                    // store it
                    temperatureData.add(entry);
                }
            }
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
            monitoringTable.open();
            temperatureData = monitoringTable.retrieveOverviewByName(movement_field);
            monitoringTable.close();
        } else {
            // get ultrasonic values from all the values in overallContext 
            for (DataBase entry : overallContext) {
                // if entry type is "movement"
                if (entry.getType().equals(movement_field)) {
                    // store it
                    ultrasonicData.add(entry);
                }
            }
        }

    }

    /**
     * Serialize all our data into a JSON structure
     *
     * @param path
     */
    public void serializeDataToJson(String path) {
        JSONObject temperatureOverview = new JSONObject();
        JSONObject ultrasonicOverview = new JSONObject();
        JSONObject microphoneOverview = new JSONObject();


        /*
         *      Temperature
         */
        if (!temperatureData.isEmpty()) {
            String context = "Temperature";

            // parse temperature data and return a JSON representation of it
            // with data for each day averaged out
            temperatureOverview = super.parseOverallContext(temperatureData, context);
            
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
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        
        /*
         *      Ultrasonic
         */
        if (ultrasonicData.isEmpty()) {
            String context = "Movement";
            ultrasonicOverview = super.parseOverallContext(ultrasonicData, context);

            // write temperature overview data to a JSON file            
            String temperature_overview_file = "ultrasonic_overview.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;

            // write temperature overview data to file
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(temperatureOverview.toJSONString());
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}