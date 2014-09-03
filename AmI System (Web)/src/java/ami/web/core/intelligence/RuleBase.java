/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.intelligence;

// local libaries
import ami.web.core.models.client.DataBase;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Java APIs
import java.util.*;

/**
 *
 * @author Jonathan Perry
 */
public class RuleBase {

    /*
     * Predefined fuzzy rules
     */
    // ... temperature
    private final int very_cold = 0;
    private final int moderately_cold = 10;
    private final int moderately_warm = 20;
    private final int moderately_hot = 30;
    private final int very_hot = 40;

    // 
    private final int away = 0;   // 0cm
    private final int present = 100; // 20cm ??? Can the device reach 20cm

    // this indicates the user is away from their desk. 
    private final int away_2 = 4000;

    private LinkedHashMap<Integer, String> tempRules;
    private LinkedHashMap<Integer, String> movementRules;

    private Rule tempRule;
    private Rule movementRule;

//    private ArrayList<DataBase> initialContext;
    private ArrayList<DataBase> overallContext;

    private Rule rule;

    // others to follow...
    public RuleBase() {
        // create our two dimensional array that will store our pre-defined fuzzy rules
        // start by creating rules for the temperature sensor
        this.tempRules = new LinkedHashMap<Integer, String>();
        this.movementRules = new LinkedHashMap<Integer, String>();

        tempRule = new Rule();
        movementRule = new Rule();

//        int i = 0;
//        
//        for(DataBase e : initialContext) {
//            System.out.println(e.getHostname() + ", " + i++);
//        }
        rule = new Rule();
        overallContext = new ArrayList<DataBase>();

        // look up table for temperature sensor
        // parameters: key, value
        this.tempRules.put(very_cold, "Very cold"); // 
        this.tempRules.put(moderately_cold, "Cold");
        this.tempRules.put(moderately_warm, "Warm");
        this.tempRules.put(moderately_hot, "Hot");
        this.tempRules.put(very_hot, "Very hot");

        this.movementRules.put(away, "Away");
        this.movementRules.put(present, "Present");
        this.movementRules.put(away_2, "Away");
    }

    /**
     * Looks up what position the linguistic type holds in our fuzzy sets for
     * each context.
     *
     * @param entry DataBase entry
     */
    public void lookup(DataBase entry) {
        String result = "";
        String type = "";
        Iterator it;

        // this is where we look up rules defined in our two dimensional matrix,
        // sorted by contextual type (i.e., temperature)
        //
        // we will need to update each Entry value being returned (if necessary)
        if (entry.getType().equals("temperature")) {

            System.out.println("lookup() - temperature");
            
            // temperature fuzzy set
            it = tempRules.entrySet().iterator();

            Map.Entry<Integer, String> currTempEntry;
            Map.Entry<Integer, String> prevTempEntry;

            // get the first entry
            currTempEntry = (Map.Entry) it.next();

            while (it.hasNext()) {
                // store the previous entry
                prevTempEntry = currTempEntry;

                // get the next entry
                currTempEntry = (Map.Entry) it.next();

                // if the movement entry is greater than the initial rule set by the initial context
                if (entry.getValue() > tempRule.get()) {
                    
                    // update the value and rule
                    int avg = (entry.getValue() + tempRule.get()) / 2;

                    tempRule.remove();
                    tempRule.update(avg);

                    // update the monitoring context table entry
                    entry.setValue(avg);

                    // if... then...
                    // away vs present, etc.
                    // if value is between 0 AND value is between 10
                    // assign it this linguistic type
                    if (entry.getValue() >= (int) prevTempEntry.getKey() && entry.getValue() <= (int) currTempEntry.getKey()) {
                        result = currTempEntry.getValue();
                        
                        // update the linguistic type
                        entry.setLinguisticType(type);
                    }
                } else {

                    // if... then...
                    // away vs present, etc.
                    // if value is between 0 AND value is between 10
                    // assign it this linguistic type
                    if (entry.getValue() >= (int) prevTempEntry.getKey() && entry.getValue() <= (int) currTempEntry.getKey()) {
                        result = currTempEntry.getValue();

                        // update the linguistic type
                        entry.setLinguisticType(type);
                    }
                }
            }

            // add the potentially updated "temperature" entry to the overall context list
            overallContext.add(entry);
        } else if (entry.getType().equals("movement")) {

            System.out.println("lookup() - movement");

            // ultrasonic fuzzy set
            it = movementRules.entrySet().iterator();

            Map.Entry<Integer, String> currTempEntry;
            Map.Entry<Integer, String> prevTempEntry;

            // get the first entry
            currTempEntry = (Map.Entry) it.next();
            while (it.hasNext()) {

                // store the previous entry
                prevTempEntry = currTempEntry;

                // get the next entry
                currTempEntry = (Map.Entry) it.next();

                // if the movement entry is greater than the initial rule set by the initial context
                if (entry.getValue() > movementRule.get()) {
                    // update the value
                    int avg = (entry.getValue() + movementRule.get()) / 2;

                    movementRule.remove();
                    movementRule.update(avg);

                    // update the monitoring context table entry
                    entry.setValue(avg);

                    // if... then...
                    // away vs present, etc.
                    // if value is between 0 AND value is between 10
                    // assign it this linguistic type
                    if (entry.getValue() >= (int) prevTempEntry.getKey() && entry.getValue() <= (int) currTempEntry.getKey()) {
                        result = currTempEntry.getValue();

                        // update the linguistic type
                        entry.setLinguisticType(type);
                    }
                } else {

                    // if... then...
                    // away vs present, etc.
                    // if value is between 0 AND value is between 10
                    // assign it this linguistic type
                    if (entry.getValue() >= (int) prevTempEntry.getKey() && entry.getValue() <= (int) currTempEntry.getKey()) {
                        result = currTempEntry.getValue();

                        // update the linguistic type
                        entry.setLinguisticType(type);
                    }
                }
            }

            // add the potentially updated "movement" entry to the overall context list
            overallContext.add(entry);
        }
    }

    /**
     *
     * @param data our initial contextual set
     */
    public void createRules(ArrayList<DataBase> data) {
        ArrayList<DataBase> tempContext = new ArrayList<DataBase>();
        ArrayList<DataBase> movementContext = new ArrayList<DataBase>();
        DataBase firstEntry;
        
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("\tDATA SIZE - " + data.size());
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
        
        // get the first result from the set, to determine which day it was from
        firstEntry = data.get(0);
        
        // create a model for the day in the week
        //
        // first, figure out what day in the week our initial data is from
        int dayNo = findDayInWeek(firstEntry.getYear(), firstEntry.getMonth(), firstEntry.getDay());

        System.out.println("dayNo" + dayNo);
        
        // sort by context, according to which day in the week the initial context 
        // session occurred
        switch (dayNo) {
            case Calendar.SATURDAY:
                for (DataBase entry : data) {
                    // temperature
                    if (entry.getType().equals("temperature")) {
                        System.out.println("SATURDAY: " + entry.getHostname());
                        tempContext.add(entry);
                    } // movement
                    else if (entry.getType().equals("movement")) {
                        System.out.println("SATURDAY: " + entry.getHostname());
                        System.out.println(entry.getHostname());
                        movementContext.add(entry);
                    }
                }
                break;
            case Calendar.SUNDAY:
                for (DataBase entry : data) {
                    if (entry.getType().equals("temperature")) {
                        System.out.println("SUNDAY: " + entry.getHostname());
                        tempContext.add(entry);
                    } else if (entry.getType().equals("movement")) {
                        movementContext.add(entry);
                    }
                }
                break;
            case Calendar.MONDAY:
                for (DataBase entry : data) {
                    if (entry.getType().equals("temperature")) {
                        System.out.println("MONDAY: " + entry.getHostname());
                        tempContext.add(entry);
                    } else if (entry.getType().equals("movement")) {
                        movementContext.add(entry);
                    }
                }
                break;
            case Calendar.TUESDAY:
                for (DataBase entry : data) {
                    if (entry.getType().equals("temperature")) {
                        System.out.println("TUESDAY: " + entry.getHostname());
                        tempContext.add(entry);
                    } else if (entry.getType().equals("movement")) {
                        movementContext.add(entry);
                    }
                }
                break;
            case Calendar.WEDNESDAY:
                for (DataBase entry : data) {
                    if (entry.getType().equals("temperature")) {
                        System.out.println("WEDNESDAY: " + entry.getHostname());
                        tempContext.add(entry);
                    } else if (entry.getType().equals("movement")) {
                        movementContext.add(entry);
                    }
                }
                break;
            case Calendar.THURSDAY:
                for (DataBase entry : data) {
                    if (entry.getType().equals("temperature")) {
                        System.out.println("THURSDAY: " + entry.getHostname());
                        tempContext.add(entry);
                    } else if (entry.getType().equals("movement")) {
                        movementContext.add(entry);
                    }
                }
                break;
            case Calendar.FRIDAY:
                for (DataBase entry : data) {
                    if (entry.getType().equals("temperature")) {
                        tempContext.add(entry);
                    } else if (entry.getType().equals("movement")) {
                        movementContext.add(entry);
                    }
                }
                break;
            default:
                break;
        }

        // compute average for each context
        int temperatureAverage = 0;
        int movementAverage = 0;
                
        System.out.println("tempContext.size(): " + tempContext.size());
        System.out.println("movementContext.size(): " + movementContext.size());

        // temperature
        for (DataBase tempValue : tempContext) {
            temperatureAverage += tempValue.getValue();
        }
        
        temperatureAverage = temperatureAverage / tempContext.size();
        System.out.println("temperatureAverage: " + temperatureAverage);
        
        this.tempRule.add(temperatureAverage);


        // ... movement
        for (DataBase movementValue : movementContext) {
            if (movementValue.getValue() < 100) {
                movementAverage += movementValue.getValue();
            }
        }

        movementAverage = movementAverage / movementContext.size();
        System.out.println("movementAverage: " + movementAverage);

        // update (for the first time) our rule bases for each context
        this.movementRule.add(movementAverage);
    }

    /**
     * Returns the overall context after comparing the initial context against
     * the monitoring context, using a predefined model of linguistic types in a
     * fuzzy set environment.
     *
     * This helps to respond to changes (over time) using an approach that is
     * intelligent and sensitive to change.
     *
     * @return
     */
    public ArrayList<DataBase> overallContext() {
        for (DataBase e : overallContext) {
            System.out.println("overallContext(): " + e.getHostname());
        }

        return overallContext;
    }

    /**
     * Finds the day in the week
     *
     * @param year
     * @param month
     * @param day
     * @return
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

        // find the day of the week 
        if (strDay.equals("Saturday")) {
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
