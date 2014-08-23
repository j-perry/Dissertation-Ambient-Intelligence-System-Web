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
import java.io.*;
import java.text.*;
import java.util.*;

// third party libraries (json)
import org.json.simple.*;

/**
 *
 * @author Jonathan Perry
 */
public class SystemOverview {

    private MonitoringTable monitoringTable;
    private FileWriter fWriter;
    
    // To store data from database
    private ArrayList<DataBase> temperatureData;
    private ArrayList<DataBase> ultrasonicData;
    private ArrayList<DataBase> microphoneData;
<<<<<<< HEAD
=======
    
>>>>>>> sprint_two
    // JSON
    private JSONObject overviewTemp;
    private JSONObject overviewDistance;
    
    // For JSON binding
    private final String hostname_heading = "Agents";
    private final String hostname_one = "agent_one";
    private final String hostname_two = "agent_two";
    private final String pi_one = "raspberry-pi-1";
    private final String pi_two = "raspberry-pi-2";
    
    public SystemOverview() {
        monitoringTable = new MonitoringTable();
        fWriter = null;
        temperatureData = new ArrayList<DataBase>();
        ultrasonicData = new ArrayList<DataBase>();
        microphoneData = new ArrayList<DataBase>();
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
     * Retrieves ultra sonic transceiver data from INITIAL MONITORING TABLE
     *
     * We'll need to change this to the general table later!!!
     */
    public void getMovementData() {
        String movement_field = "movement";
        
        monitoringTable.open();
        temperatureData = monitoringTable.retrieveOverviewByContext(movement_field);
        monitoringTable.close();
    }
    
    /**
     * Retrieves microphone data from INITIAL MONITORING TABLE
     *
     * We'll need to change this to the general table later!!!
     */
    public void getMicrophoneData() {
        String microphone_field = "microphone";
        
        monitoringTable.open();
        temperatureData = monitoringTable.retrieveOverviewByContext(microphone_field);
        monitoringTable.close();
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
            temperatureOverview = parseContext(temperatureData, context);

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
        if(ultrasonicData.isEmpty() ) {
            String context = "Movement";
            ultrasonicOverview = parseContext(ultrasonicData, context);
            
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
        if(microphoneData.isEmpty() ) {
            String context = "Microphone";
            microphoneOverview = parseContext(microphoneData, context);
            
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
        
        // Stacks - Agent 1
        Stack<Integer> agent_one_context_value_monday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_tuesday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_wednesday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_thursday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_friday = new Stack<Integer>();


        // Stacks - Agent 2
        Stack<Integer> agent_two_context_value_monday = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_tuesday = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_wednesday = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_thursday = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_friday = new Stack<Integer>();


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
        //          "Agent-One": {
        //              "Monday": {
        //                  "27"
        //              ],
        //          "Agent-Two": "Values",
        //              "Monday": [
        //                  "27"
        //              ],
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
                    case Calendar.MONDAY:
                        if (agent_one_context_value_monday.isEmpty()) {
                            agent_one_context_value_monday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_monday.push((d.getValue() + agent_two_context_value_monday.peek()));
                        }
                        break;
                    // Tuesday
                    case Calendar.TUESDAY:
                        if (agent_one_context_value_tuesday.isEmpty()) {
                            agent_one_context_value_tuesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_tuesday.push((d.getValue() + agent_one_context_value_tuesday.peek()));
                        }
                        break;
                    // Wednesday
                    case Calendar.WEDNESDAY:
                        if (agent_one_context_value_wednesday.isEmpty()) {
                            agent_one_context_value_wednesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_wednesday.push((d.getValue() + agent_one_context_value_wednesday.peek()));
                        }
                        break;
                    // Thursday
                    case Calendar.THURSDAY:
                        if (agent_one_context_value_thursday.isEmpty()) {
                            agent_one_context_value_thursday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_thursday.push((d.getValue() + agent_one_context_value_thursday.peek()));
                        }
                        break;
                    // Friday
                    case Calendar.FRIDAY:
                        if (agent_one_context_value_friday.isEmpty()) {
                            agent_one_context_value_friday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_friday.push((d.getValue() + agent_one_context_value_friday.peek()));
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
                    case Calendar.MONDAY:
                        if (agent_two_context_value_monday.isEmpty()) {
                            agent_two_context_value_monday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_monday.push((d.getValue() + agent_two_context_value_monday.peek()));
                        }
                        break;
                    // Tuesday
                    case Calendar.TUESDAY:
                        if (agent_two_context_value_tuesday.isEmpty()) {
                            agent_two_context_value_tuesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_tuesday.push((d.getValue() + agent_two_context_value_tuesday.peek()));
                        }
                        break;
                    // Wednesday 
                    case Calendar.WEDNESDAY:
                        if (agent_two_context_value_wednesday.isEmpty()) {
                            agent_two_context_value_wednesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_wednesday.push((d.getValue() + agent_two_context_value_wednesday.peek()));
                        }
                        break;
                    // Thursday
                    case Calendar.THURSDAY:
                        if (agent_two_context_value_thursday.isEmpty()) {
                            agent_two_context_value_thursday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_thursday.push((d.getValue() + agent_two_context_value_thursday.peek()));
                        }
                        break;
                    // Friday
                    case Calendar.FRIDAY:
                        if (agent_two_context_value_friday.isEmpty()) {
                            agent_two_context_value_friday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_friday.push((d.getValue() + agent_two_context_value_friday.peek()));
                        }
                        break;
                    default:
                        break;
                }
            }
        }


        /*
         *      Bind our data together
         */
        JSONObject root = new JSONObject();
        JSONObject agent_one = new JSONObject();
        JSONObject agent_two = new JSONObject();

        JSONArray agent_one_mon_arr = new JSONArray();
        JSONArray agent_one_tues_arr = new JSONArray();
        JSONArray agent_one_wed_arr = new JSONArray();
        JSONArray agent_one_thur_arr = new JSONArray();
        JSONArray agent_one_fri_arr = new JSONArray();

        JSONArray agent_two_mon_arr = new JSONArray();
        JSONArray agent_two_tues_arr = new JSONArray();
        JSONArray agent_two_wed_arr = new JSONArray();
        JSONArray agent_two_thurs_arr = new JSONArray();
        JSONArray agent_two_fri_arr = new JSONArray();


        /*
         *  bind our data
         */

        // agent one
        // monday (entry point)
        // average each stack (Monday to Tuesday)...
        if (!agent_one_context_value_monday.isEmpty()) {
            agent_one.put(MONDAY, agent_one_mon_arr);  // "Monday", arr
            agent_one_mon_arr.add(agent_one_context_value_monday.pop());
        } else {
            agent_one.put(MONDAY, agent_one_mon_arr);
            agent_one_mon_arr.add(0);
        }

        // tuesday
        if (!agent_one_context_value_tuesday.isEmpty()) {
            agent_one.put(TUESDAY, agent_one_tues_arr);
            agent_one_tues_arr.add(agent_one_context_value_tuesday.pop());
        } else {
            agent_one.put(TUESDAY, agent_one_tues_arr);
            agent_one_tues_arr.add(0);
        }

        // wednesday
        if (!agent_one_context_value_wednesday.isEmpty()) {
            agent_one.put(WEDNESDAY, agent_one_wed_arr);
            agent_one_wed_arr.add(agent_one_context_value_wednesday.pop());
        } else {
            agent_one.put(WEDNESDAY, agent_one_wed_arr);
            agent_one_wed_arr.add(0);
        }

        // thursday
        if (!agent_one_context_value_thursday.isEmpty()) {
            agent_one.put(THURSDAY, agent_one_thur_arr);
            agent_one_thur_arr.add(agent_one_context_value_thursday.pop());
        } else {
            agent_one.put(THURSDAY, agent_one_thur_arr);
            agent_one_thur_arr.add(0);
        }

        // friday
        if (!agent_one_context_value_friday.isEmpty()) {
            agent_one.put(FRIDAY, agent_one_fri_arr);
            agent_one_fri_arr.add(agent_one_context_value_friday.pop());
        } else {
            agent_one.put(FRIDAY, agent_one_fri_arr);
            agent_one_fri_arr.add(0);
        }


        // REPEAT...        
        // agent two
        // monday (entry point)
        if (!agent_two_context_value_monday.isEmpty()) {
            agent_two.put(MONDAY, agent_two_mon_arr);  // "Monday", arr
            agent_two_mon_arr.add((agent_two_context_value_monday.pop() / agent_two_context_value_monday.size()));
        } else {
            agent_two.put(MONDAY, agent_two_mon_arr);  // "Monday", arr
            agent_two_mon_arr.add(0);
        }

        // tuesday
        if (!agent_two_context_value_tuesday.isEmpty()) {
            agent_two.put(TUESDAY, agent_two_mon_arr);  // "Monday", arr
            agent_two_tues_arr.add((agent_two_context_value_tuesday.pop() / agent_two_context_value_tuesday.size()));
        } else {
            agent_two.put(TUESDAY, agent_two_tues_arr);  // "Monday", arr
            agent_two_tues_arr.add(0);
        }

        // wednesday
        if (!agent_two_context_value_wednesday.isEmpty()) {
            agent_two.put(WEDNESDAY, agent_two_wed_arr);
            agent_two_wed_arr.add(agent_two_context_value_wednesday.pop());
        } else {
            agent_two.put(WEDNESDAY, agent_two_wed_arr);
            agent_two_wed_arr.add(0);
        }

        // thursday
        if (!agent_two_context_value_thursday.isEmpty()) {
            agent_two.put(THURSDAY, agent_two_thurs_arr);
            agent_two_thurs_arr.add(agent_two_context_value_thursday.pop());
        } else {
            agent_two.put(THURSDAY, agent_two_thurs_arr);
            agent_two_thurs_arr.add(0);
        }

        // friday
        if (!agent_two_context_value_friday.isEmpty()) {
            agent_two.put(FRIDAY, agent_two_fri_arr);
            agent_two_fri_arr.add(agent_two_context_value_friday.pop());
        } else {
            agent_two.put(FRIDAY, agent_two_fri_arr);
            agent_two_fri_arr.add(0);
        }

        // bind our arrays together        
        root.put(hostname_one, agent_one);      // Hostname-1
        root.put(hostname_two, agent_two);      // Hostname-2
        
        return root;
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