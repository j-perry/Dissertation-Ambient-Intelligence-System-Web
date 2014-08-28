/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.servlets.modules;

// local libraries
import ami.web.core.db.InitialContextTable;
import ami.web.core.db.OverallContextTable;
import ami.web.core.models.client.DataBase;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.simple.JSONObject;

/**
 * Computes and generates data for the movement view
 * @author Jonathan Perry
 */
public class MovementView extends ContextView {
    
    private final String field = "movement";
        
    private ArrayList<DataBase> overallContext;
    
    private ArrayList<DataBase> saturdayData;
    private ArrayList<DataBase> sundayData;
    private ArrayList<DataBase> mondayData;
    private ArrayList<DataBase> tuesdayData;
    private ArrayList<DataBase> wednesdayData;
    private ArrayList<DataBase> thursdayData;
    private ArrayList<DataBase> fridayData;
        
    private FileWriter fWriter;
    
    private InitialContextTable initialContextTable;
    private OverallContextTable overallContextTable;
    
    public MovementView() {
        saturdayData = new ArrayList<DataBase>();
        sundayData = new ArrayList<DataBase>();
        mondayData = new ArrayList<DataBase>();
        tuesdayData = new ArrayList<DataBase>();
        wednesdayData = new ArrayList<DataBase>();
        thursdayData = new ArrayList<DataBase>();
        fridayData = new ArrayList<DataBase>();
        
        overallContext = new ArrayList<DataBase>();
        
        initialContextTable = new InitialContextTable();
        overallContextTable = new OverallContextTable();
        fWriter = null;
    }
    
    public MovementView(ArrayList<DataBase> overallContext) {
        saturdayData = new ArrayList<DataBase>();
        sundayData = new ArrayList<DataBase>();
        mondayData = new ArrayList<DataBase>();
        tuesdayData = new ArrayList<DataBase>();
        wednesdayData = new ArrayList<DataBase>();
        thursdayData = new ArrayList<DataBase>();
        fridayData = new ArrayList<DataBase>();
        fWriter = null;
        
        initialContextTable = new InitialContextTable();
        overallContextTable = new OverallContextTable();
        
        this.overallContext = overallContext;
    }
    
    /**
     * Get data for Saturday from either overallContext OR from table InitialMonitoring
     */
    public void getSaturday() {
        
        // if empty, get entries from InitialContext table
        if(overallContext.isEmpty()) {
            initialContextTable.open();
            ArrayList<DataBase> results = initialContextTable.retrieveOverviewByName(field);
            initialContextTable.close();
            
            for(DataBase entry : results) {
                // if the result is Monday                
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.SATURDAY) {
                    mondayData.add(entry);
                }
            }
        } else {
            for(DataBase entry : overallContext) {
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.SATURDAY) {
                    mondayData.add(entry);
                }
            }
        }
    }
    
    /**
     * Get data for Sunday from either overallContext OR from table InitialMonitoring
     */
    public void getSunday() {
        
        // if empty, get entries from InitialContext table
        if(overallContext.isEmpty()) {
            initialContextTable.open();
            ArrayList<DataBase> results = initialContextTable.retrieveOverviewByName(field);
            initialContextTable.close();
            
            for(DataBase entry : results) {
                // if the result is Monday                
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.SUNDAY) {
                    mondayData.add(entry);
                }
            }
        } else {
            for(DataBase entry : overallContext) {
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.SUNDAY) {
                    mondayData.add(entry);
                }
            }
        }
    }

    /**
     * Get data for Monday from either overallContext OR from table InitialMonitoring
     */
    public void getMonday() {
        
        // if empty, get entries from InitialContext table
        if(overallContext.isEmpty()) {
            initialContextTable.open();
            ArrayList<DataBase> results = initialContextTable.retrieveOverviewByName(field);
            initialContextTable.close();
            
            for(DataBase entry : results) {
                // if the result is Monday                
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.MONDAY) {
                    mondayData.add(entry);
                }
            }
        } else {
            for(DataBase entry : overallContext) {
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.MONDAY) {
                    mondayData.add(entry);
                }
            }
        }
    }

    /**
     * Get data for Tuesday from either overallContext OR from table InitialMonitoring
     */
    public void getTuesday() {
        
        // if empty, get entries from InitialContext table
        if(overallContext.isEmpty()) {
            initialContextTable.open();
            ArrayList<DataBase> results = initialContextTable.retrieveOverviewByName(field);
            initialContextTable.close();
            
            for(DataBase entry : results) {
                // if the result is Tuesday
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.TUESDAY) {
                    tuesdayData.add(entry);
                }
            }
        } else {
            for(DataBase entry : overallContext) {
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.TUESDAY) {
                    tuesdayData.add(entry);
                }
            }
        }
    }
    
    /**
     * Get data for Wednesday from either overallContext OR from table InitialMonitoring
     */
    public void getWednesday() {

        // if empty, get entries from InitialContext table
        if(overallContext.isEmpty()) {
            initialContextTable.open();
            ArrayList<DataBase> results = initialContextTable.retrieveOverviewByName(field);
            initialContextTable.close();
            
            for(DataBase entry : results) {
                // if the result is Wednesday
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.WEDNESDAY) {
                    wednesdayData.add(entry);
                }
            }
        } else {
            for(DataBase entry : overallContext) {
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.WEDNESDAY) {
                    wednesdayData.add(entry);
                }
            }
        }
    }

    /**
     * Get data for Thursday from either overallContext OR from table InitialMonitoring
     */
    public void getThursday() {

        // if empty, get entries from InitialContext table
        if(overallContext.isEmpty()) {
            initialContextTable.open();
            ArrayList<DataBase> results = initialContextTable.retrieveOverviewByName(field);
            initialContextTable.close();
            
            for(DataBase entry : results) {
                // if the result is Thursday
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.THURSDAY) {
                    thursdayData.add(entry);
                }
            }
        } else {
            for(DataBase entry : overallContext) {
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.THURSDAY) {
                    thursdayData.add(entry);
                }
            }
        }
    }

    /**
     * Get data for Friday from either overallContext OR from table InitialMonitoring
     */
    public void getFriday() {

        // if empty, get entries from InitialContext table
        if(overallContext.isEmpty()) {
            initialContextTable.open();
            ArrayList<DataBase> results = initialContextTable.retrieveOverviewByName(field);
            initialContextTable.close();
            
            for(DataBase entry : results) {
                // if the result is Friday
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.FRIDAY) {
                    fridayData.add(entry);
                }
            }
        } else {
            for(DataBase entry : overallContext) {
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.FRIDAY) {
                    fridayData.add(entry);
                }
            }
        }
    }

    /**
     * 
     * @param path 
     */
    public void serializeDataToJSON(String path) {
        // hours of data (potentially) to be serialized to JSON
        JSONObject movementSaturday = new JSONObject();
        JSONObject movementSunday = new JSONObject();
        JSONObject movementMonday = new JSONObject();
        JSONObject movementTuesday = new JSONObject();
        JSONObject movementWednesday = new JSONObject();
        JSONObject movementThursday = new JSONObject();
        JSONObject movementFriday = new JSONObject();
        
        /*
        *   Saturday
        */
        if(!saturdayData.isEmpty() ) {
            String context = "Movement";
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            movementMonday = super.parseWeekdayContext(saturdayData, context);
            
            // write movement overview data to a JSON file            
            String movement_overview_file = "movement_saturday.json";

            String fWriterPathMovement = path;
            fWriterPathMovement += "js/json/logs/";
            fWriterPathMovement += movement_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathMovement);
                fWriter.write(movementMonday.toJSONString());
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        /*
        *   Sunday
        */
        if(!sundayData.isEmpty() ) {
            String context = "Movement";
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            movementMonday = super.parseWeekdayContext(sundayData, context);
            
            // write movement overview data to a JSON file            
            String movement_overview_file = "movement_sunday.json";

            String fWriterPathMovement = path;
            fWriterPathMovement += "js/json/logs/";
            fWriterPathMovement += movement_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathMovement);
                fWriter.write(movementMonday.toJSONString());
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Monday
        */
        if(!mondayData.isEmpty() ) {
            String context = "Movement";
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            movementMonday = super.parseWeekdayContext(mondayData, context);
            
            // write movement overview data to a JSON file            
            String movement_overview_file = "movement_monday.json";

            String fWriterPathMovement = path;
            fWriterPathMovement += "js/json/logs/";
            fWriterPathMovement += movement_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathMovement);
                fWriter.write(movementMonday.toJSONString());
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Tuesday
        */
        if(!tuesdayData.isEmpty() ) {
            String context = "Movement";
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            movementMonday = super.parseWeekdayContext(tuesdayData, context);
            
            // write movement overview data to a JSON file            
            String movement_overview_file = "movement_tuesday.json";

            String fWriterPathMovement = path;
            fWriterPathMovement += "js/json/logs/";
            fWriterPathMovement += movement_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathMovement);
                fWriter.write(movementMonday.toJSONString());
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Wednesday
        */
        if(!wednesdayData.isEmpty() ) {
            String context = "Movement";
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            movementMonday = super.parseWeekdayContext(wednesdayData, context);
            
            // write movement overview data to a JSON file            
            String movement_overview_file = "movement_wednesday.json";

            String fWriterPathMovement = path;
            fWriterPathMovement += "js/json/logs/";
            fWriterPathMovement += movement_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathMovement);
                fWriter.write(movementMonday.toJSONString());
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Thursday
        */
        if(!thursdayData.isEmpty() ) {
            String context = "Movement";
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            movementMonday = super.parseWeekdayContext(thursdayData, context);
            
            // write movement overview data to a JSON file            
            String movement_overview_file = "movement_thursday.json";

            String fWriterPathMovement = path;
            fWriterPathMovement += "js/json/logs/";
            fWriterPathMovement += movement_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathMovement);
                fWriter.write(movementMonday.toJSONString());
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Friday
        */
        if(!fridayData.isEmpty() ) {
            String context = "Movement";
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            movementMonday = super.parseWeekdayContext(fridayData, context);
            
            // write movement overview data to a JSON file            
            String movement_overview_file = "movement_friday.json";

            String fWriterPathMovement = path;
            fWriterPathMovement += "js/json/logs/";
            fWriterPathMovement += movement_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathMovement);
                fWriter.write(movementMonday.toJSONString());
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}