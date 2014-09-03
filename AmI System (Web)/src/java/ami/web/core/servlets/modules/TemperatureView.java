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
 * Computes and generates data for the temperature view
 * @author Jonathan Perry
 */
public class TemperatureView extends ContextView {
    
    private final String field = "temperature";
        
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
    
    public TemperatureView() {
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
    
    public TemperatureView(ArrayList<DataBase> overallContext) {
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
        
        System.out.println("getSaturday()");
        
        // if empty, get entries from InitialContext table
        if(overallContext.isEmpty()) {
            initialContextTable.open();
            ArrayList<DataBase> results = initialContextTable.retrieveOverviewByName(field);
            initialContextTable.close();
            
            for(DataBase entry : results) {
                // if the result is Monday                
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.SATURDAY) {
                    saturdayData.add(entry);
                }
            }
        } else {
            for(DataBase entry : overallContext) {
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.SATURDAY) {
                    saturdayData.add(entry);
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
                    sundayData.add(entry);
                }
            }
        } else {
            for(DataBase entry : overallContext) {
                if(super.findDayInWeek(entry.getYear(), entry.getMonth(), entry.getDay() ) == Calendar.SUNDAY) {
                    sundayData.add(entry);
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
            
            System.out.println("getFriday()");
            
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
     * Serialize our TemperatureView data to JSON
     * @param path 
     */
    public void serializeDataToJSON(String path) {
        
        // hours of data (potentially) to be serialized to JSON
        final String context = "Temperature";
        
        /*
        *   Saturday
        */
        if(!saturdayData.isEmpty() ) {
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            JSONObject temperatureSaturday = super.parseWeekdayContext(saturdayData, context);
            
            // write temperature overview data to a JSON file            
            String temperature_overview_file = "temperature_saturday.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(temperatureSaturday.toJSONString());
                fWriter.flush();
                fWriter.close();
                
                System.out.println("Saturday's data has been written to a JSON file");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        /*
        *   Sunday
        */
        if(!sundayData.isEmpty() ) {
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            JSONObject temperatureSunday = super.parseWeekdayContext(sundayData, context);
            
            // write temperature overview data to a JSON file            
            String temperature_overview_file = "temperature_sunday.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(temperatureSunday.toJSONString());
                fWriter.flush();
                fWriter.close();
                
                System.out.println("Sunday's data has been written");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Monday
        */
        if(!mondayData.isEmpty() ) {
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            JSONObject temperatureMonday = super.parseWeekdayContext(mondayData, context);
            
            // write temperature overview data to a JSON file            
            String temperature_overview_file = "temperature_monday.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(temperatureMonday.toJSONString());
                fWriter.flush();
                fWriter.close();
                
                System.out.println("Monday's data has been written");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Tuesday
        */
        if(!tuesdayData.isEmpty() ) {
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            JSONObject temperatureTuesday = super.parseWeekdayContext(tuesdayData, context);
            
            // write temperature overview data to a JSON file            
            String temperature_overview_file = "temperature_tuesday.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(temperatureTuesday.toJSONString());
                fWriter.flush();
                fWriter.close();
                
                System.out.println("Tuesday's data has been written");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Wednesday
        */
        if(!wednesdayData.isEmpty() ) {
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            JSONObject temperatureWednesday = super.parseWeekdayContext(wednesdayData, context);
            
            // write temperature overview data to a JSON file            
            String temperature_overview_file = "temperature_wednesday.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(temperatureWednesday.toJSONString());
                fWriter.flush();
                fWriter.close();
                
                System.out.println("Wednesday's data has been written");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Thursday
        */
        if(!thursdayData.isEmpty() ) {
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            JSONObject temperatureThursday = super.parseWeekdayContext(thursdayData, context);
            
            // write temperature overview data to a JSON file            
            String temperature_overview_file = "temperature_thursday.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(temperatureThursday.toJSONString());
                fWriter.flush();
                fWriter.close();
                
                System.out.println("Thursday's data has been written");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        /*
        *   Friday
        */
        if(!fridayData.isEmpty() ) {
            
            // parse monday's data and return a JSON representation of it
            // with data for each day averaged out
            JSONObject temperatureFriday = super.parseWeekdayContext(fridayData, context);
            
            // write temperature overview data to a JSON file            
            String temperature_overview_file = "temperature_friday.json";

            String fWriterPathTemperature = path;
            fWriterPathTemperature += "js/json/logs/";
            fWriterPathTemperature += temperature_overview_file;
            
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(temperatureFriday.toJSONString());
                fWriter.flush();
                fWriter.close();
                
                System.out.println("Friday's data has been written");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            System.out.println("fridayData JSON File written");
        }
        
    }
}