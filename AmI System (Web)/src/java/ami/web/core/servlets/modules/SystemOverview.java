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
public class SystemOverview {

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

    public SystemOverview() {
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
                    case MONDAY_ID:
                        if (agent_one_context_value_monday.isEmpty()) {
                            agent_one_context_value_monday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_monday.push((d.getValue() + agent_two_context_value_monday.peek()));
                        }
                        break;
                    // Tuesday
                    case TUESDAY_ID:
                        if (agent_one_context_value_tuesday.isEmpty()) {
                            agent_one_context_value_tuesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_tuesday.push((d.getValue() + agent_one_context_value_tuesday.peek()));
                        }
                        break;
                    // Wednesday
                    case WEDNESDAY_ID:
                        if (agent_one_context_value_wednesday.isEmpty()) {
                            agent_one_context_value_wednesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_wednesday.push((d.getValue() + agent_one_context_value_wednesday.peek()));
                        }
                        break;
                    // Thursday
                    case THURSDAY_ID:
                        if (agent_one_context_value_thursday.isEmpty()) {
                            agent_one_context_value_thursday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_thursday.push((d.getValue() + agent_one_context_value_thursday.peek()));
                        }
                        break;
                    // Friday
                    case FRIDAY_ID:
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
                    case MONDAY_ID:
                        if (agent_two_context_value_monday.isEmpty()) {
                            agent_two_context_value_monday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_monday.push((d.getValue() + agent_two_context_value_monday.peek()));
                        }
                        break;
                    // Tuesday
                    case TUESDAY_ID:
                        if (agent_two_context_value_tuesday.isEmpty()) {
                            agent_two_context_value_tuesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_tuesday.push((d.getValue() + agent_two_context_value_tuesday.peek()));
                        }
                        break;
                    // Wednesday 
                    case WEDNESDAY_ID:
                        if (agent_two_context_value_wednesday.isEmpty()) {
                            agent_two_context_value_wednesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_wednesday.push((d.getValue() + agent_two_context_value_wednesday.peek()));
                        }
                        break;
                    // Thursday
                    case THURSDAY_ID:
                        if (agent_two_context_value_thursday.isEmpty()) {
                            agent_two_context_value_thursday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_thursday.push((d.getValue() + agent_two_context_value_thursday.peek()));
                        }
                        break;
                    // Friday
                    case FRIDAY_ID:
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