/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.servlets.modules;

// libraries
import ami.web.core.db.*;
import ami.web.core.models.client.DataBase;

// Java APIs
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Stack;

// third party libraries
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Jonathan Perry
 */
public class SystemOverview1 {

    private MonitoringTable monitoringTable;
    private FileWriter fWriter;
    // To store data from database
    private ArrayList<DataBase> temperatureData;
    private ArrayList<DataBase> ultrasonicData;
    // JSON
    private JSONObject overviewTemp;
    private JSONObject overviewDistance;
    // For JSON binding
    private String hostname_heading = "Agents";
    private String hostname_one = "Agent-One";
    private String hostname_two = "Agent-Two";
    private String pi_one = "raspberry-pi-1";
    private String pi_two = "raspberry-pi-2";
    String value;

    public SystemOverview1() {
        monitoringTable = new MonitoringTable();
        temperatureData = new ArrayList<DataBase>();
        fWriter = null;
    }

    /**
     * Retrieves temperature data from INITIAL MONITORING TABLE
     *
     * We'll need to change this to the general table later!!!
     */
    public void getTemperatureData() {
        String temp_field = "temperature";

        monitoringTable.open();
        temperatureData = monitoringTable.retrieveOverviewByContext(temp_field);
        monitoringTable.close();

    }

    /**
     * Serialize all our data into a JSON structure
     *
     * @param path
     */
    public void serializeDataToJson(String path) {
        JSONObject temperatureOverview = new JSONObject();


        /*
         *      Temperature
         * 
         */
        if (!temperatureData.isEmpty()) {
            // parse temperature data and return a JSON representation of it
            // with data for each day averaged out
            temperatureOverview = parseContext(temperatureData, "Temperature");

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
        } else {
//            temperatureOverview.put("Temperature", "Is Empty");

            // write temperature overview data to a JSON file            
            String temperature_overview_file = "temperature_overview.json";

            String fWriterPathTemperature = path;
//            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += "http://localhost:8080/AmI_System__Web_/js/json/logs/";
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
//        // ultrasonic
//        else if(ultrasonicData.isEmpty() ) {
//            overviewDistance = parseContext(temperatureData);
//            
//            // write temperature overview data to a JSON file            
//            String temperature_overview_file = "ultrasonic_overview.json";
//
//            String fWriterPathTemperature = path;
//            fWriterPathTemperature += "js/json/logs/";
//            fWriterPathTemperature += temperature_overview_file;
//            
//            // write temperature overview data to file
//            try {
//                fWriter = new FileWriter(fWriterPathTemperature);
//                fWriter.write(temperatureOverview.toJSONString());
//                fWriter.flush();
//                fWriter.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }

    }

    /**
     * Returns a JSONObject with all sorted data bound
     *
     * @param d
     * @return
     */
    public JSONObject parseContext(ArrayList<DataBase> data, String context) {
        final int WORKDAY_HOURS = 8;

        final String MONDAY = "monday";
        final String TUESDAY = "tuesday";
        final String WEDNESDAY = "wednesday";
        final String THURSDAY = "thursday";
        final String FRIDAY = "friday";

        final int MONDAY_ID = 2;
        final int TUESDAY_ID = 3;
        final int WEDNESDAY_ID = 4;
        final int THURSDAY_ID = 5;
        final int FRIDAY_ID = 6;

        String contents = null;

        FileWriter fWriter;



        JSONObject agentResult = new JSONObject();


        // Stacks - Agent 1
        Stack<Integer> agent_one_context_value_monday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_tuesday = new Stack<Integer>();


        // Stacks - Agent 2
        Stack<Integer> agent_two_context_value_monday = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_tuesday = new Stack<Integer>();

        
        HashMap<String, Integer> agent_one_context_monday = new HashMap<String, Integer>();
        HashMap<String, Integer> agent_two_context_monday = new HashMap<String, Integer>();
        

        //
        //      JSON Data Structure
        //
        //      This is what our JSON data structure should look like regardless
        //      of what context of data we are parsing (i.e., temperature).
        //
        //----------------------------------------------------------------------------------
        //
        //      
        //      {
        //          "Agents", "Temperatures",
        //          "Temperature": {
        //              "Agent-One": "Values",
        //              "Monday": {
        //                  "27"
        //              },
        //              "Agent-Two": "Values",
        //              "Monday": {
        //                  "27"
        //              },
        //          }
        //      }
        //

        for (DataBase d : temperatureData) {

            // if agent one
            if (d.getHostname().equals(pi_one)) {

                // look up what day in the week the corresponding date returns
                int dayOfTheWeek = findDayInWeek(d.getYear(), d.getMonth(), d.getDay());
                
                System.out.println("Agent 1 - TODAY IS: " + dayOfTheWeek);

                // Codes - Calendar.DAY_OF_WEEK:
                // https://community.oracle.com/thread/2094650?tstart=90840
                switch (dayOfTheWeek) {
                    // Monday
                    case MONDAY_ID:
                        if (agent_one_context_value_monday.isEmpty()) {
                            agent_one_context_value_monday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_monday.push(d.getValue() + agent_two_context_value_monday.pop());
                        }
                        break;
                    default:
                        break;
                }
            } else if (d.getHostname().equals(pi_two)) {
                // look up what day in the week the corresponding date returns
                int dayOfTheWeek = findDayInWeek(d.getYear(), d.getMonth(), d.getDay());
                
                System.out.println("Agent 2 - TODAY IS: " + dayOfTheWeek);

                // Codes - Calendar.DAY_OF_WEEK:
                // https://community.oracle.com/thread/2094650?tstart=90840
                switch (dayOfTheWeek) {
                    // Monday
                    case MONDAY_ID:
                        if (agent_two_context_value_monday.isEmpty()) {
                            agent_two_context_value_monday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_monday.push(d.getValue() + agent_two_context_value_monday.pop());
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        
        
        // average each stack (Monday to Tuesday)
        // agent 1
        if (!agent_one_context_value_monday.isEmpty()) {
            agent_one_context_value_monday.push(agent_one_context_value_monday.pop() / WORKDAY_HOURS);
        }
        

        
        
        // average each stack (Monday to Tuesday)
        // agent 2
        if (!agent_two_context_value_monday.isEmpty()) {
            agent_two_context_value_monday.push(agent_two_context_value_monday.pop() / WORKDAY_HOURS);
        }
//


        /*
         *      Bind our data together
         */
        JSONObject root = new JSONObject();
        JSONObject subElement = new JSONObject();
        JSONArray mon_arr = new JSONArray();
        JSONArray tues_arr = new JSONArray();
        
//        JSONArray agents_arr = new JSONArray();
//        JSONArray agent_one_arr = new JSONArray();
//        JSONArray agent_two_arr = new JSONArray();
//        // agent one
//        JSONObject agent_one_monday = new JSONObject();//
//        // agent two
//        JSONObject agent_two_monday = new JSONObject();
        
        
        
        // agent 1 - add value to array
//        agent_one_arr.add(agent_one_context_value_monday.pop() );
        
        // bind our data
        root.put("Agents", context + "s");          // "Agents": "Temperatures"
        root.put(context, subElement);              // "Temperature", etc.
        subElement.put(hostname_two, "Values");     // "Agent-2": "Values",
        subElement.put(MONDAY, mon_arr);            // "Monday", arr
        mon_arr.add("23");                          // "23"
        //--------------
        subElement.put(TUESDAY, tues_arr);
        tues_arr.add("24");
        
        

//        // initialise agent one (with computed data)
//        // monday
//        if (!agent_one_context_value_monday.isEmpty()) {
//            agent_one_monday.put("Value", agent_one_context_value_monday.pop());
//        }
//
//
//        // initialise agent one (with computed data)
//        // monday
//        if (!agent_two_context_monday.isEmpty()) {
//            agent_two_monday.put("Value", agent_two_context_value_monday.pop());
//        }
//
//
//        /*
//         *  Bind each individual weekday to each agent with the data
//         */
//
//
//        // AM I USING THE RIGHT TYPE (JSONArray instead of JSONObject)???
//        //
//        // agent 1 ("Agent-One")
//        if (!agent_one_monday.isEmpty()) {
//            agent_one_arr.add(agent_one_monday);
//        }
//
//
//        // agent 2 ("Agent-Two")
//        if (!agent_two_monday.isEmpty()) {
//            agent_two_arr.add(agent_two_monday);
//        }
//
//
//        
//        // bind agent 1 + 2 together
//        if (!agents_arr.isEmpty()) {
//            agents_arr.add(agent_one_arr);
//        }
//
//        if (!agent_two_arr.isEmpty()) {
//            agents_arr.add(agent_two_arr);
//        }
//
//        if(!agent_two_context_monday.isEmpty()) {
//            agentResult.put(hostname_heading, "Hsfdgdgdjhgfdjkghdkfjgh");
//        }

        
        
//        return agentResult;
        return root;
        
        // bind agent (1 + 2) to the root node ("Agents") 
//                if(!agents_arr.isEmpty() ) {       

//                if(!agent_two_context_monday.isEmpty()) {
//        agentResult.put(hostname_heading, "Hsfdgdgdjhgfdjkghdkfjgh");
//                }
//                else {
//                    agentResult.put(hostname_heading, "EMPTY" );
//                }
    }

    /**
     * Finds the day in the week
     */
    private int findDayInWeek(int year, String month, String day) {
        int dayInWeek = 0;
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String strDay = null;

        try {
            d = df.parse(day + "/" + month + "/" + year);
            df.applyPattern("EEEE");
            strDay = df.format(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String sdjf = "dsfd";

        // find the day of the week 
        if (strDay.equals("Monday")) {
            dayInWeek = Calendar.MONDAY;
        } else if (strDay.equals("Tuesday")) {
            dayInWeek = Calendar.TUESDAY;
        } else if (strDay.equals("Wednesday")) {
            dayInWeek = Calendar.WEDNESDAY;
        } else if (strDay.equals("Thursday")) {
            dayInWeek = Calendar.THURSDAY;
        } else if (strDay.equals("Friday")) {
            dayInWeek = Calendar.FRIDAY;
        }

        return dayInWeek;
    }
}