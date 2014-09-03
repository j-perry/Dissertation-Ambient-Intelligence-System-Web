/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.servlets.modules;

// local libraries
import ami.web.core.models.client.DataBase;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Java APIs
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

// third party libraries
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Abstract class used to process common tasks
 * @author Jonathan Perry
 */
public abstract class ContextView {
        
    // For JSON binding
    private final String hostname_one = "agent_one";
    private final String hostname_two = "agent_two";
    private final String pi_one = "raspberry-pi-1";
    private final String pi_two = "raspberry-pi-2";
    
    public ContextView() {
        
    }
    
    /**
     * Returns a JSONObject with all sorted data bound
     *
     * @param data 
     * @param context
     * @return
     */
    public JSONObject parseOverallContext(ArrayList<DataBase> data, String context) {
        
        final String SATURDAY = "saturday";
        final String SUNDAY = "sunday";
        final String MONDAY = "monday";
        final String TUESDAY = "tuesday";
        final String WEDNESDAY = "wednesday";
        final String THURSDAY = "thursday";
        final String FRIDAY = "friday";

        final int SATURDAY_ID = Calendar.SATURDAY;
        final int SUNDAY_ID = Calendar.SUNDAY;
        final int MONDAY_ID = Calendar.MONDAY;
        final int TUESDAY_ID = Calendar.TUESDAY;
        final int WEDNESDAY_ID = Calendar.WEDNESDAY;
        final int THURSDAY_ID = Calendar.THURSDAY;
        final int FRIDAY_ID = Calendar.FRIDAY;

        // Stacks - Agent 1
        Stack<Integer> agent_one_context_value_saturday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_sunday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_monday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_tuesday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_wednesday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_thursday = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_friday = new Stack<Integer>();

        // Stacks - Agent 2
        Stack<Integer> agent_two_context_value_saturday = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_sunday = new Stack<Integer>();
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
        for (DataBase d : data) {

            // if agent one
            if (d.getHostname().equals(pi_one)) {

                // look up what day in the week the corresponding date returns
                int dayOfTheWeek = findDayInWeek(d.getYear(), d.getMonth(), d.getDay());

//                System.out.println("Agent 1 - TODAY IS: " + dayOfTheWeek);

                // Codes - Calendar.DAY_OF_WEEK:
                // https://community.oracle.com/thread/2094650?tstart=90840
                switch (dayOfTheWeek) {
                    // Saturday
                    case Calendar.SATURDAY:
                        if (agent_one_context_value_saturday.isEmpty()) {
                            agent_one_context_value_saturday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_saturday.push((d.getValue() + agent_one_context_value_saturday.peek() ));
                        }
                        break;
                    // Sunday
                    case Calendar.SUNDAY:
                        if (agent_one_context_value_sunday.isEmpty()) {
                            agent_one_context_value_sunday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_sunday.push((d.getValue() + agent_one_context_value_sunday.peek() ));
                        }
                        break;
                    // Monday
                    case Calendar.MONDAY:
                        if (agent_one_context_value_monday.isEmpty()) {
                            agent_one_context_value_monday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_one_context_value_monday.push((d.getValue() + agent_one_context_value_monday.peek()));
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
                            agent_one_context_value_friday.push((d.getValue() + agent_one_context_value_friday.peek() ));
                        }
                        break;
                    default:
                        break;
                }
            } else if (d.getHostname().equals(pi_two)) {
                // look up what day in the week the corresponding date returns
                int dayOfTheWeek = findDayInWeek(d.getYear(), d.getMonth(), d.getDay());

//                System.out.println("Agent 2 - TODAY IS: " + dayOfTheWeek);
                
                // Codes - Calendar.DAY_OF_WEEK:
                // https://community.oracle.com/thread/2094650?tstart=90840
                switch (dayOfTheWeek) {
                    // Saturday
                    case Calendar.SATURDAY:
                        if (agent_two_context_value_saturday.isEmpty()) {
                            agent_two_context_value_saturday.push(d.getValue());
                        } else {
                            // 24 + 25
//                            System.out.println("SATURDAY - AG2 - " + agent_two_context_value_saturday.peek() );
                            agent_two_context_value_saturday.push((d.getValue() + agent_two_context_value_saturday.peek() ));
                        }
                        break;
                    // Sunday
                    case Calendar.SUNDAY:
                        if (agent_two_context_value_sunday.isEmpty()) {
                            agent_two_context_value_sunday.push(d.getValue());
                        } else {
                            // 24 + 25
                            agent_two_context_value_sunday.push((d.getValue() + agent_two_context_value_sunday.peek() ));
                        }
                        break;
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
                            System.out.println(agent_two_context_value_thursday.peek() );
                            agent_two_context_value_thursday.push((d.getValue() + agent_two_context_value_thursday.peek()));
                        }
                        break;
                    // Friday
                    case Calendar.FRIDAY:
                        if (agent_two_context_value_friday.isEmpty()) {
                            agent_two_context_value_friday.push(d.getValue());
                        } else {
                            // 24 + 25
                            if(agent_two_context_value_friday.peek() >= 100000) {
                                System.out.println("FRIDAY - AG2 - " + agent_two_context_value_friday.peek() );
                            agent_two_context_value_friday.push((d.getValue() + agent_two_context_value_friday.peek() ));
                            }
                            
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

        
        JSONArray agent_one_sat_arr = new JSONArray();
        JSONArray agent_one_sun_arr = new JSONArray();
        JSONArray agent_one_mon_arr = new JSONArray();
        JSONArray agent_one_tues_arr = new JSONArray();
        JSONArray agent_one_wed_arr = new JSONArray();
        JSONArray agent_one_thur_arr = new JSONArray();
        JSONArray agent_one_fri_arr = new JSONArray();
        

        JSONArray agent_two_sat_arr = new JSONArray();
        JSONArray agent_two_sun_arr = new JSONArray();
        JSONArray agent_two_mon_arr = new JSONArray();
        JSONArray agent_two_tues_arr = new JSONArray();
        JSONArray agent_two_wed_arr = new JSONArray();
        JSONArray agent_two_thurs_arr = new JSONArray();
        JSONArray agent_two_fri_arr = new JSONArray();
        
        
        /*
         *  bind our data
         */
        final int MAX_HOURS = 8;
        
        // agent one
        // saturday (entry point)
        if (!agent_one_context_value_saturday.isEmpty()) {
            agent_one.put(SATURDAY, agent_one_sat_arr);  // "Monday", arr
            int result = (int) agent_one_context_value_saturday.pop() / agent_one_context_value_saturday.size();
            System.out.println("Agent 1 - Overview: Agent 1 - Saturday: " + result);
            agent_one_sat_arr.add(result);
        } else {
            agent_one.put(SATURDAY, agent_one_sat_arr);            
            System.out.println("Agent 1 - Saturday: " + 0);
            agent_one_sat_arr.add(0);
        }
        
        // sunday
        if (!agent_one_context_value_sunday.isEmpty()) {
            agent_one.put(SUNDAY, agent_one_sun_arr);  // "Monday", arr
            int result = (int) agent_one_context_value_sunday.pop() / agent_one_context_value_sunday.size();
            agent_one_sun_arr.add(result);
        } else {
            agent_one.put(SUNDAY, agent_one_sun_arr);
            agent_one_sun_arr.add(0);
        }
                
        // monday
        // average each stack (Monday to Tuesday)...
        if (!agent_one_context_value_monday.isEmpty()) {
            agent_one.put(MONDAY, agent_one_mon_arr);  // "Monday", arr
            int result = (int) agent_one_context_value_monday.pop() / agent_one_context_value_monday.size();
            agent_one_mon_arr.add(result);
        } else {
            agent_one.put(MONDAY, agent_one_mon_arr);
            agent_one_mon_arr.add(0);
        }

        // tuesday
        if (!agent_one_context_value_tuesday.isEmpty()) {
            agent_one.put(TUESDAY, agent_one_tues_arr);
            int result = (int) agent_one_context_value_tuesday.pop() / agent_one_context_value_tuesday.size();
            agent_one_tues_arr.add(result);
        } else {
            agent_one.put(TUESDAY, agent_one_tues_arr);
            agent_one_tues_arr.add(0);
        }

        // wednesday
        if (!agent_one_context_value_wednesday.isEmpty()) {
            agent_one.put(WEDNESDAY, agent_one_wed_arr);
            int result = (int) agent_one_context_value_wednesday.pop() / agent_one_context_value_wednesday.size();
            agent_one_wed_arr.add(result);
        } else {
            agent_one.put(WEDNESDAY, agent_one_wed_arr);
            agent_one_wed_arr.add(0);
        }

        // thursday
        if (!agent_one_context_value_thursday.isEmpty()) {
            agent_one.put(THURSDAY, agent_one_thur_arr);
            int result = (int) agent_one_context_value_thursday.pop() / agent_one_context_value_thursday.size();
            agent_one_thur_arr.add(result);
        } else {
            agent_one.put(THURSDAY, agent_one_thur_arr);
            agent_one_thur_arr.add(0);
        }

        // friday
        if (!agent_one_context_value_friday.isEmpty()) {
            agent_one.put(FRIDAY, agent_one_fri_arr);
            int result = (int) agent_one_context_value_friday.pop() / agent_one_context_value_friday.size();
            agent_one_fri_arr.add(result);
        } else {
            agent_one.put(FRIDAY, agent_one_fri_arr);
            agent_one_fri_arr.add(0);
        }

        
        // REPEAT...        
        // agent two
        // saturday (entry point)
        if (!agent_two_context_value_saturday.isEmpty()) {
            agent_two.put(SATURDAY, agent_two_sat_arr);  // "Monday", arr
            int result = (int) agent_two_context_value_saturday.pop() / agent_two_context_value_saturday.size();
            agent_two_sat_arr.add(result);
        } else {
            agent_two.put(SATURDAY, agent_two_sat_arr);
            agent_two_sat_arr.add(0);
        }
        
        // sunday
        if (!agent_two_context_value_sunday.isEmpty()) {
            agent_two.put(SUNDAY, agent_two_sun_arr);  // "Monday", arr
            int result = (int) agent_two_context_value_sunday.pop() / agent_two_context_value_sunday.size();
            agent_two_sun_arr.add(result);
        } else {
            agent_two.put(SUNDAY, agent_two_sun_arr);
            agent_two_sun_arr.add(0);
        }
        
        // monday
        if (!agent_two_context_value_monday.isEmpty()) {
            agent_two.put(MONDAY, agent_two_mon_arr);  // "Monday", arr
            int result = (int) agent_two_context_value_monday.pop() / agent_two_context_value_monday.size();
            agent_two_mon_arr.add(result);
        } else {
            agent_two.put(MONDAY, agent_two_mon_arr);  // "Monday", arr
            agent_two_mon_arr.add(0);
        }

        // tuesday
        if (!agent_two_context_value_tuesday.isEmpty()) {
            agent_two.put(TUESDAY, agent_two_mon_arr);  // "Monday", arr
            int result = (int) agent_two_context_value_tuesday.pop() / agent_two_context_value_tuesday.size();
            agent_two_tues_arr.add(result);
        } else {
            agent_two.put(TUESDAY, agent_two_tues_arr);  // "Monday", arr
            agent_two_tues_arr.add(0);
        }

        // wednesday
        if (!agent_two_context_value_wednesday.isEmpty()) {
            agent_two.put(WEDNESDAY, agent_two_wed_arr);
            int result = (int) agent_two_context_value_wednesday.pop() / agent_two_context_value_wednesday.size();
            agent_two_wed_arr.add(result);
        } else {
            agent_two.put(WEDNESDAY, agent_two_wed_arr);
            agent_two_wed_arr.add(0);
        }

        // thursday
        if (!agent_two_context_value_thursday.isEmpty()) {
            agent_two.put(THURSDAY, agent_two_thurs_arr);
            int result = (int) agent_two_context_value_thursday.pop() / agent_two_context_value_thursday.size();
            agent_two_thurs_arr.add(result);
        } else {
            agent_two.put(THURSDAY, agent_two_thurs_arr);
            agent_two_thurs_arr.add(0);
        }
        
        // friday
        if (!agent_two_context_value_friday.isEmpty()) {
            agent_two.put(FRIDAY, agent_two_fri_arr);
            int result = (int) agent_two_context_value_friday.pop() / agent_two_context_value_friday.size();
            agent_two_fri_arr.add(result);
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
     * Returns a JSONObject with all sorted data bound
     *
     * @param data
     * @param context
     * @return
     */
    public JSONObject parseWeekdayContext(ArrayList<DataBase> data, String context) {
        
        System.out.println("Weekday context size: " + data.size() );
        
        // hour IDs
        final String NINE = "nine";
        final String TEN = "ten";
        final String ELEVEN = "eleven";
        final String TWELVE = "twelve";
        final String THIRTEEN = "thirteen";
        final String FORTEEN = "forteen";
        final String FIFTEEN = "fifteen";
        final String SIXTEEN = "sixteen";
        
        // hour codes (9am - 5pm)
        final int NINE_ID = 9;
        final int TEN_ID = 10;
        final int ELEVEN_ID = 11;
        final int TWELVE_ID = 12;
        final int THIRTEEN_ID = 13;
        final int FORTEEN_ID = 14;
        final int FIFTEEN_ID = 15;
        final int SIXTEEN_ID = 16;
        
        // Stacks - Agent 1
        Stack<Integer> agent_one_context_value_nine = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_ten = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_eleven = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_twelve = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_thirteen = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_forteen = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_fifteen = new Stack<Integer>();
        Stack<Integer> agent_one_context_value_sixteen = new Stack<Integer>();

        // Stacks - Agent 2
        Stack<Integer> agent_two_context_value_nine = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_ten = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_eleven = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_twelve = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_thirteen = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_forteen = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_fifteen = new Stack<Integer>();
        Stack<Integer> agent_two_context_value_sixteen = new Stack<Integer>();

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
        //              "Nine": {
        //                  "27"
        //              ],
        //          "Agent-Two": "Values",
        //              "Ten": [
        //                  "27"
        //              ],
        //      }
        //
        
        for (DataBase d : data) {

            // if agent one
            if (d.getHostname().equals(pi_one)) {
                                
                // sort by hour (9am - 5pm)
                switch (d.getHour() ) {
                    // 9am
                    case 9:
                        if (agent_one_context_value_nine.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_one_context_value_nine.push(d.getValue());                                
                            }
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_one_context_value_nine.push((d.getValue() + agent_one_context_value_nine.peek()));
                            }                            
                        }
                        break;
                    // 10
                    case 10:
                        if (agent_one_context_value_ten.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_one_context_value_ten.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_one_context_value_ten.push((d.getValue() + agent_one_context_value_ten.peek()));
                            }                            
                        }
                        break;
                    // 11
                    case 11:
                        if (agent_one_context_value_eleven.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_one_context_value_eleven.push(d.getValue());
                            }
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_one_context_value_eleven.push((d.getValue() + agent_one_context_value_eleven.peek()));
                            }                            
                        }
                        break;
                    // 12pm
                    case 12:
                        if (agent_one_context_value_twelve.isEmpty()) {
                            if(d.getValue() < 500) {                                
                                agent_one_context_value_twelve.push(d.getValue());
                            }
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                int result = (int) d.getValue() + agent_one_context_value_twelve.peek();
                                System.out.println("12pm: " + result);
                                agent_one_context_value_twelve.push(result);
                            }                            
                        }
                        break;
                    // 13
                    case 13:
                        if (agent_one_context_value_thirteen.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_one_context_value_thirteen.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_one_context_value_thirteen.push((d.getValue() + agent_one_context_value_thirteen.peek()));
                            }                            
                        }
                        break;
                    case 14:
                        if (agent_one_context_value_forteen.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_one_context_value_forteen.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_one_context_value_forteen.push((d.getValue() + agent_one_context_value_forteen.peek()));
                            }                            
                        }
                        break;
                    case 15:
                        if (agent_one_context_value_fifteen.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_one_context_value_fifteen.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_one_context_value_fifteen.push((d.getValue() + agent_one_context_value_fifteen.peek()));
                            }                            
                        }
                        break;
                    case 16:
                        if (agent_one_context_value_sixteen.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_one_context_value_sixteen.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_one_context_value_sixteen.push((d.getValue() + agent_one_context_value_sixteen.peek()));
                            }                            
                        }
                        break;
                    default:
                        break;
                }
            } else if (d.getHostname().equals(pi_two)) {
                                
                // sort by hour (9am - 5pm)
                switch (d.getHour() ) {
                    // 9am
                    case 9:
                        if (agent_two_context_value_nine.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_two_context_value_nine.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_two_context_value_nine.push((d.getValue() + agent_two_context_value_nine.peek()));
                            }
                            
                        }
                        break;
                    // 10
                    case 10:
                        if (agent_two_context_value_ten.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_two_context_value_ten.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_two_context_value_ten.push((d.getValue() + agent_two_context_value_ten.peek()));
                            }                            
                        }
                        break;
                    // 11
                    case 11:
                        if (agent_two_context_value_eleven.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_two_context_value_eleven.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_two_context_value_eleven.push((d.getValue() + agent_two_context_value_eleven.peek()));
                            }                            
                        }
                        break;
                    // 12pm
                    case 12:
                        if (agent_two_context_value_twelve.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_two_context_value_twelve.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_two_context_value_twelve.push((d.getValue() + agent_two_context_value_twelve.peek()));
                            }                            
                        }
                        break;
                    // 13
                    case 13:
                        if (agent_two_context_value_thirteen.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_two_context_value_thirteen.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_two_context_value_thirteen.push((d.getValue() + agent_two_context_value_thirteen.peek()));
                            }                            
                        }
                        break;
                    case 14:
                        if (agent_two_context_value_forteen.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_two_context_value_forteen.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_two_context_value_forteen.push((d.getValue() + agent_two_context_value_forteen.peek()));
                            }                            
                        }
                        break;
                    case 15:
                        if (agent_two_context_value_fifteen.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_two_context_value_fifteen.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_two_context_value_fifteen.push((d.getValue() + agent_two_context_value_fifteen.peek()));
                            }                            
                        }
                        break;
                    case 16:
                        if (agent_two_context_value_sixteen.isEmpty()) {
                            if(d.getValue() < 500) {
                                agent_two_context_value_sixteen.push(d.getValue());
                            }                            
                        } else {
                            // 24 + 25
                            if(d.getValue() < 500) {
                                agent_two_context_value_sixteen.push((d.getValue() + agent_two_context_value_sixteen.peek()));
                            }                            
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
        
        // 9 - 5pm (both agents)
        // agent 1
        JSONArray agent_one_nine_arr = new JSONArray();
        JSONArray agent_one_ten_arr = new JSONArray();
        JSONArray agent_one_eleven_arr = new JSONArray();
        JSONArray agent_one_twelve_arr = new JSONArray();
        JSONArray agent_one_thirteen_arr = new JSONArray();
        JSONArray agent_one_forteen_arr = new JSONArray();
        JSONArray agent_one_fifteen_arr = new JSONArray();
        JSONArray agent_one_sixteen_arr = new JSONArray();
        
        // agent 2
        JSONArray agent_two_nine_arr = new JSONArray();
        JSONArray agent_two_ten_arr = new JSONArray();
        JSONArray agent_two_eleven_arr = new JSONArray();
        JSONArray agent_two_twelve_arr = new JSONArray();
        JSONArray agent_two_thirteen_arr = new JSONArray();
        JSONArray agent_two_forteen_arr = new JSONArray();
        JSONArray agent_two_fifteen_arr = new JSONArray();
        JSONArray agent_two_sixteen_arr = new JSONArray();


        /*
         *  bind our data
         */
        final int MINS = 60;
        
        // agent one
        // 9am (entry point)
        // average each stack (9 to 5pm)...
        if (!agent_one_context_value_nine.isEmpty()) {
            int result = (int) agent_one_context_value_nine.pop() / agent_one_context_value_nine.size();
            agent_one_nine_arr.add(result);
            agent_one.put(NINE, agent_one_nine_arr);  // "9", arr
        } else {
            agent_one_nine_arr.add(0);
            agent_one.put(NINE, agent_one_nine_arr);
        }
        
        // 10am
        if (!agent_one_context_value_ten.isEmpty()) {
            int result = (int) agent_one_context_value_ten.pop() / agent_one_context_value_ten.size();
            agent_one_ten_arr.add(result);
            agent_one.put(TEN, agent_one_ten_arr);
        } else {
            agent_one_ten_arr.add(0);
            agent_one.put(TEN, agent_one_ten_arr);
        }

        // 11am
        if (!agent_one_context_value_eleven.isEmpty()) {
            int result = (int) agent_one_context_value_eleven.pop() / agent_one_context_value_eleven.size();
            agent_one_eleven_arr.add(result);
            agent_one.put(ELEVEN, agent_one_eleven_arr);
        } else {
            agent_one_eleven_arr.add(0);
            agent_one.put(ELEVEN, agent_one_eleven_arr);
        }

        // 12pm
        if (!agent_one_context_value_twelve.isEmpty()) {
            int result = (int) agent_one_context_value_twelve.pop() / agent_one_context_value_twelve.size();
            System.out.println("agent_one_context_value_twelve result: " + result);
            agent_one_twelve_arr.add(result);
            agent_one.put(TWELVE, agent_one_twelve_arr);
        } else {
            agent_one_twelve_arr.add(0);
            agent_one.put(TWELVE, agent_one_twelve_arr);
        }

        // 13
        if (!agent_one_context_value_thirteen.isEmpty()) {
            int result = (int) agent_one_context_value_thirteen.pop() / agent_one_context_value_thirteen.size();
            agent_one_thirteen_arr.add(result);
            agent_one.put(THIRTEEN, agent_one_thirteen_arr);
        } else {
            agent_one.put(THIRTEEN, agent_one_thirteen_arr);
            agent_one_thirteen_arr.add(0);
        }
        
        // 14
        if (!agent_one_context_value_forteen.isEmpty()) {
            int result = (int) agent_one_context_value_forteen.pop() / agent_one_context_value_forteen.size();
            agent_one_forteen_arr.add(result);
            agent_one.put(FORTEEN, agent_one_forteen_arr);
        } else {
            agent_one_forteen_arr.add(0);
            agent_one.put(FORTEEN, agent_one_forteen_arr);
        }
        
        // 15
        if (!agent_one_context_value_fifteen.isEmpty()) {
            int result = (int) agent_one_context_value_fifteen.pop() / agent_one_context_value_fifteen.size();
            agent_one_fifteen_arr.add(result);
            agent_one.put(FIFTEEN, agent_one_fifteen_arr);
        } else {
            agent_one_fifteen_arr.add(0);
            agent_one.put(FIFTEEN, agent_one_fifteen_arr);
        }
        
        // 16
        if (!agent_one_context_value_sixteen.isEmpty()) {
            int result = (int) agent_one_context_value_sixteen.pop() / agent_one_context_value_sixteen.size();
            agent_one_sixteen_arr.add(result);
            agent_one.put(SIXTEEN, agent_one_sixteen_arr);
        } else {
            agent_one_sixteen_arr.add(0);
            agent_one.put(SIXTEEN, agent_one_sixteen_arr);
        }
                

        /*
        *   REPEAT, BUT FOR AGENT TWO...
        */
        
        // monday (entry point)
        // average each stack (9 to 5pm)...
        if (!agent_two_context_value_nine.isEmpty()) {
            int result = (int) agent_two_context_value_nine.pop() / agent_two_context_value_nine.size();
            agent_two_nine_arr.add(result);
            agent_two.put(NINE, agent_two_nine_arr);  // "9", arr
        } else {
            agent_two_nine_arr.add(0);
            agent_two.put(NINE, agent_two_nine_arr);
        }
        
        // 10am
        if (!agent_two_context_value_ten.isEmpty()) {
            int result = (int) agent_two_context_value_ten.pop() / agent_two_context_value_ten.size();
            agent_two_ten_arr.add(result);
            agent_two.put(TEN, agent_two_ten_arr);
        } else {
            agent_two_ten_arr.add(0);
            agent_two.put(TEN, agent_two_ten_arr);
        }

        // 11am
        if (!agent_two_context_value_eleven.isEmpty()) {
            int result = (int) agent_two_context_value_eleven.pop() / agent_two_context_value_eleven.size();
            agent_two_eleven_arr.add(result);
            agent_two.put(ELEVEN, agent_two_eleven_arr);
        } else {
            agent_two_eleven_arr.add(0);
            agent_two.put(ELEVEN, agent_two_eleven_arr);
        }

        // 12pm
        if (!agent_two_context_value_twelve.isEmpty()) {
            int result = (int) agent_two_context_value_twelve.pop() / agent_two_context_value_twelve.size();
            agent_two_twelve_arr.add(result);
            agent_two.put(TWELVE, agent_two_twelve_arr);
        } else {
            agent_two_twelve_arr.add(0);
            agent_two.put(TWELVE, agent_two_twelve_arr);
        }

        // 13
        if (!agent_two_context_value_thirteen.isEmpty()) {
            int result = (int) agent_two_context_value_thirteen.pop() / agent_two_context_value_thirteen.size();
            agent_two_thirteen_arr.add(result);
            agent_two.put(THIRTEEN, agent_two_thirteen_arr);
        } else {
            agent_two_thirteen_arr.add(0);
            agent_two.put(THIRTEEN, agent_two_thirteen_arr);
        }
        
        // 14
        if (!agent_two_context_value_forteen.isEmpty()) {
            int result = (int) agent_two_context_value_forteen.pop() / agent_two_context_value_forteen.size();
            agent_two_forteen_arr.add(agent_two_context_value_forteen.pop() / MINS);
            agent_two.put(FORTEEN, agent_two_forteen_arr);
        } else {
            agent_two_forteen_arr.add(0);
            agent_two.put(FORTEEN, agent_two_forteen_arr);
        }
        
        // 15
        if (!agent_two_context_value_fifteen.isEmpty()) {
            int result = (int) agent_two_context_value_fifteen.pop() / agent_two_context_value_fifteen.size();
            agent_two_fifteen_arr.add(result);
            agent_two.put(FIFTEEN, agent_two_fifteen_arr);
        } else {
            agent_two_fifteen_arr.add(0);
            agent_two.put(FIFTEEN, agent_two_fifteen_arr);
        }
        
        // 16
        if (!agent_two_context_value_sixteen.isEmpty()) {
            int result = (int) agent_two_context_value_sixteen.pop() / agent_two_context_value_sixteen.size();
            agent_two_sixteen_arr.add(result);
            agent_two.put(SIXTEEN, agent_two_sixteen_arr);
        } else {
            agent_two_sixteen_arr.add(0);
            agent_two.put(SIXTEEN, agent_two_sixteen_arr);
        }
                
//        System.out.println("agent_two: " + agent_two.toJSONString() );
        
        // bind our arrays together        
        root.put(hostname_one, agent_one);      // Hostname-1
        root.put(hostname_two, agent_two);      // Hostname-2
        
        System.out.println("root: " + root.toJSONString() );

        return root;
    }
    
    /**
     * Finds the day in the week
     * @param year
     * @param month
     * @param day
     * @return 
     */
    public int findDayInWeek(int year, String month, String day) {
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
        
        // find the day of the week 
        if(strDay.equals("Saturday")) {
            dayInWeek = Calendar.SATURDAY;
        } else if (strDay.equals("Sunday")) {
            dayInWeek = Calendar.SUNDAY;
        } else if (strDay.equals("Monday")) {
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