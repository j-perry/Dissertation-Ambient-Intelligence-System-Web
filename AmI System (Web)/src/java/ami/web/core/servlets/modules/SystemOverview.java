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
import java.util.ArrayList;
import java.util.Calendar;
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
//            temperatureOverview = parseContext(temperatureData);
            temperatureOverview.put("Temperature", "Is Not Empty");
            
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
        else {
            temperatureOverview.put("Temperature", "Is Empty");
            
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
    public JSONObject parseContext(ArrayList<DataBase> data) {
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
        
        
        JSONObject agentResult = new JSONObject();
        

        // Stacks - Agent 1
        Stack<Integer> agent_one_context_monday = new Stack<Integer>();
        Stack<Integer> agent_one_context_tuesday = new Stack<Integer>();
        Stack<Integer> agent_one_context_wednesday = new Stack<Integer>();
        Stack<Integer> agent_one_context_thursday = new Stack<Integer>();
        Stack<Integer> agent_one_context_friday = new Stack<Integer>();
        
        
        // Stacks - Agent 2
        Stack<Integer> agent_two_context_monday = new Stack<Integer>();
        Stack<Integer> agent_two_context_tuesday = new Stack<Integer>();
        Stack<Integer> agent_two_context_wednesday = new Stack<Integer>();
        Stack<Integer> agent_two_context_thursday = new Stack<Integer>();
        Stack<Integer> agent_two_context_friday = new Stack<Integer>();
        
        
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
        //          "Agents": {
        //              "Agent-One": {
        //                  "Monday": "27",
        //                  "Tuesday": "28",
        //                  "Wednesday": "27",
        //                  "Thursday": "28",
        //                  "Friday": "28"
        //              },
        //              "Agent-Two": {
        //                  "Monday": "30",
        //                  "Tuesday": "28",
        //                  "Wednesday": "28",
        //                  "Thursday": "31",
        //                  "Friday": "30"
        //              }
        //      }
        //
        
        
        /**
         *     Sort each contextual type.
         * 
         *     Ensure each set of (potentially) retrieved data is not empty, otherwise 
         *     they will output null files.
         */
        for (DataBase d : temperatureData) {

            // if agent one
            if (d.getHostname().equals(pi_one)) {

                // look up what day in the week the corresponding date returns
                int dayOfTheWeek = findDayInWeek(d.getYear(), d.getMonth(), d.getDay());

                // Codes - Calendar.DAY_OF_WEEK:
                // https://community.oracle.com/thread/2094650?tstart=90840
                switch (dayOfTheWeek) {
                    // Monday
                    case MONDAY_ID:
                        if (agent_one_context_monday.isEmpty()) {
                            agent_one_context_monday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_monday.push(d.getValue() + agent_one_context_monday.pop());
                        }
                        break;
                    // Tuesday
                    case TUESDAY_ID:
                        if (agent_one_context_tuesday.isEmpty()) {
                            agent_one_context_tuesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_tuesday.push(d.getValue() + agent_one_context_tuesday.pop());
                        }
                        break;
                    // Wednesday
                    case WEDNESDAY_ID:
                        if (agent_one_context_wednesday.isEmpty()) {
                            agent_one_context_wednesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_wednesday.push(d.getValue() + agent_one_context_wednesday.pop());
                        }
                        break;
                    // Thursday
                    case THURSDAY_ID:
                        if (agent_one_context_thursday.isEmpty()) {
                            agent_one_context_thursday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_thursday.push(d.getValue() + agent_one_context_thursday.pop());
                        }
                        break;
                    // Friday
                    case FRIDAY_ID:
                        if (agent_one_context_friday.isEmpty()) {
                            agent_one_context_friday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_friday.push(d.getValue() + agent_one_context_friday.pop());
                        }
                        break;
                    default:
                        d.getValue();
                        break;
                }

                // average each stack (Monday to Friday)
                agent_one_context_monday.push(agent_one_context_monday.pop() / WORKDAY_HOURS);
                agent_one_context_tuesday.push(agent_one_context_tuesday.pop() / WORKDAY_HOURS);
                agent_one_context_wednesday.push(agent_one_context_wednesday.pop() / WORKDAY_HOURS);
                agent_one_context_thursday.push(agent_one_context_thursday.pop() / WORKDAY_HOURS);
                agent_one_context_friday.push(agent_one_context_friday.pop() / WORKDAY_HOURS);

            } // else if it is agent two
            else if (d.getHostname().equals(pi_two)) {

                // look up what day in the week the corresponding date returns
                int dayOfTheWeek = findDayInWeek(d.getYear(), d.getMonth(), d.getDay());

                // weekday codes: https://community.oracle.com/thread/2094650?tstart=90840
                switch (dayOfTheWeek) {
                    // Monday
                    case MONDAY_ID:
                        if (agent_two_context_monday.isEmpty()) {
                            agent_two_context_monday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_monday.push(d.getValue() + agent_two_context_monday.pop());
                        }
                        break;
                    // Tuesday
                    case TUESDAY_ID:
                        if (agent_two_context_tuesday.isEmpty()) {
                            agent_two_context_tuesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_tuesday.push(d.getValue() + agent_two_context_tuesday.pop());
                        }
                        break;
                    // Wednesday
                    case WEDNESDAY_ID:
                        if (agent_two_context_wednesday.isEmpty()) {
                            agent_two_context_wednesday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_wednesday.push(d.getValue() + agent_two_context_wednesday.pop());
                        }
                        break;
                    // Thursday
                    case THURSDAY_ID:
                        if (agent_two_context_thursday.isEmpty()) {
                            agent_two_context_thursday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_thursday.push(d.getValue() + agent_two_context_thursday.pop());
                        }
                        break;
                    // Friday
                    case FRIDAY_ID:
                        if (agent_two_context_friday.isEmpty()) {
                            agent_two_context_friday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_friday.push(d.getValue() + agent_two_context_friday.pop());
                        }
                        break;
                    default:
                        d.getValue();
                        break;
                }

                // average each stack (Monday to Friday)
                agent_two_context_monday.push(agent_two_context_monday.pop() / WORKDAY_HOURS);
                agent_two_context_tuesday.push(agent_two_context_tuesday.pop() / WORKDAY_HOURS);
                agent_two_context_wednesday.push(agent_two_context_wednesday.pop() / WORKDAY_HOURS);
                agent_two_context_thursday.push(agent_two_context_thursday.pop() / WORKDAY_HOURS);
                agent_two_context_friday.push(agent_two_context_friday.pop() / WORKDAY_HOURS);


                /*
                 *      Bind our data together
                 */        
                JSONArray agents_arr = new JSONArray();
                JSONArray agent_one_arr = new JSONArray();
                JSONArray agent_two_arr = new JSONArray();
                
                // agent one
                JSONObject agent_one_monday = null,
                           agent_one_tuesday = null,
                           agent_one_wednesday = null,
                           agent_one_thursday = null,
                           agent_one_friday = new JSONObject();
                
                // agent two
                JSONObject agent_two_monday = null,
                           agent_two_tuesday = null,
                           agent_two_wednesday = null,
                           agent_two_thursday = null,
                           agent_two_friday = new JSONObject();
                
                
                // initialise agent one (with computed data)
                agent_one_monday.put(MONDAY, agent_one_context_monday.pop() );
                agent_one_tuesday.put(TUESDAY, agent_one_context_tuesday.pop() );
                agent_one_wednesday.put(WEDNESDAY, agent_one_context_wednesday.pop() );
                agent_one_thursday.put(THURSDAY, agent_one_context_thursday.pop() );
                agent_one_friday.put(FRIDAY, agent_one_context_friday.pop() );
                
                
                // initialise agent two (with computed data)
                agent_two_monday.put(MONDAY, agent_two_context_monday.pop() );
                agent_two_tuesday.put(TUESDAY, agent_two_context_tuesday.pop() );
                agent_two_wednesday.put(WEDNESDAY, agent_two_context_wednesday.pop() );
                agent_two_thursday.put(THURSDAY, agent_two_context_thursday.pop() );
                agent_two_friday.put(FRIDAY, agent_two_context_friday.pop() );
                
                
                /*
                 *  Bind each individual weekday to each agent with the data
                */
                
                
                // AM I USING THE RIGHT TYPE (JSONArray instead of JSONObject)???
                //
                // agent 1 ("Agent-One")
                agent_one_arr.add(agent_one_monday);
                agent_one_arr.add(agent_one_tuesday);
                agent_one_arr.add(agent_one_wednesday);
                agent_one_arr.add(agent_one_thursday);
                agent_one_arr.add(agent_one_friday);
                
                // agent 2 ("Agent-Two")
                agent_two_arr.add(agent_two_monday);
                agent_two_arr.add(agent_two_tuesday);
                agent_two_arr.add(agent_two_wednesday);
                agent_two_arr.add(agent_two_thursday);
                agent_two_arr.add(agent_two_friday);
                
                // bind agent 1 + 2 together
                agents_arr.add(agent_one_arr);
                agents_arr.add(agent_two_arr);
                
                // bind agent (1 + 2) to the root node ("Agents")                                
                agentResult.put(hostname_heading, agents_arr);
            }
        }

        return agentResult;
    }

    /**
     * Finds the day in the week
     */
    private int findDayInWeek(int year, String month, String day) {
        int dayInWeek = 0;

        // look up what day in the week (Monday, etc) this corresponds to in the calendar
        Calendar cal = Calendar.getInstance();

        // year, month, day
        cal.set(year, Integer.parseInt(month), Integer.parseInt(day));

        // parse the result
        dayInWeek = cal.get(Calendar.DAY_OF_WEEK);

        return dayInWeek;
    }
}