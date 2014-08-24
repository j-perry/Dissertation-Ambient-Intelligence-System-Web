/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.servlets.modules;

// local libraries
import ami.web.core.db.*;
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

    private MonitoringContextTable monitoringTable;
    private FileWriter fWriter;

    // overall context
    private ArrayList<DataBase> overallContext;

    // To store data from database
    private ArrayList<DataBase> temperatureData;
    private ArrayList<DataBase> ultrasonicData;
    private ArrayList<DataBase> microphoneData;

    // JSON
    private JSONObject overviewTemp;
    private JSONObject overviewDistance;

    // For JSON binding
    private final String hostname_one = "agent_one";
    private final String hostname_two = "agent_two";
    private final String pi_one = "raspberry-pi-1";
    private final String pi_two = "raspberry-pi-2";

    public SystemOverview() {
        monitoringTable = new MonitoringContextTable();
        fWriter = null;
        temperatureData = new ArrayList<DataBase>();
        ultrasonicData = new ArrayList<DataBase>();
        microphoneData = new ArrayList<DataBase>();
    }

    public SystemOverview(ArrayList<DataBase> overallContext) {
        monitoringTable = new MonitoringContextTable();
        fWriter = null;
        temperatureData = new ArrayList<DataBase>();
        ultrasonicData = new ArrayList<DataBase>();
        microphoneData = new ArrayList<DataBase>();
        this.overallContext = overallContext;
    }

    /**
     * Retrieves temperature data from INITIAL MONITORING TABLE
     *
     * We'll need to change this to the general table later!!!
     */
    public void getTemperatureData() {
        String temp_field = "temperature";

        // get data from initial context table
        if (overallContext.isEmpty()) {
            monitoringTable.open();
            temperatureData = monitoringTable.retrieveOverviewByContext(temp_field);
            monitoringTable.close();
        } else {
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
            temperatureData = monitoringTable.retrieveOverviewByContext(movement_field);
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
     * Retrieves microphone data from INITIAL MONITORING TABLE
     *
     * We'll need to change this to the general table later!!!
     */
    public void getMicrophoneData() {
        String microphone_field = "microphone";

        // get data from initial context table
        if (overallContext.isEmpty()) {
            monitoringTable.open();
            temperatureData = monitoringTable.retrieveOverviewByContext(microphone_field);
            monitoringTable.close();
        } else {
            // get microhpone values from all the values in overallContext 
            for (DataBase entry : overallContext) {
                // if entry type is "microphone"
                if(entry.getType().equals(microphone_field)) {
                    // store it
                    microphoneData.add(entry);
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
//        else {
//            // write temperature overview data to a JSON file            
//            String temperature_overview_file = "temperature_overview.json";
//
//            String fWriterPathTemperature = path;
//            // temporary
////            fWriterPathTemperature += "js/json/logs/";
//            fWriterPathTemperature += "http://localhost:8080/AmI_System__Web_/js/json/logs/";
//            fWriterPathTemperature += temperature_overview_file;
//
//            try {
//                fWriter = new FileWriter(fWriterPathTemperature);
//                fWriter.write(temperatureOverview.toJSONString());
//                fWriter.flush();
//                fWriter.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }

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
        
        /*
         *      Microphone
         */
        if (microphoneData.isEmpty()) {
            String context = "Microphone";
            microphoneOverview = super.parseOverallContext(microphoneData, context);

            // write temperature overview data to a JSON file            
            String temperature_overview_file = "microphone_overview.json";

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