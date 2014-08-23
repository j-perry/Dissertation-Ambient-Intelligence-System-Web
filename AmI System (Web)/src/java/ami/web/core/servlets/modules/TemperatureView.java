/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.servlets.modules;

// local libraries
import ami.web.core.models.client.DataBase;

// Java APIs
import java.util.ArrayList;

/**
 *
 * @author Jonathan Perry
 */
public class TemperatureView {
    
    private ArrayList<DataBase> overallContext;
    
    private ArrayList<DataBase> mondayData;
    private ArrayList<DataBase> tuesdayData;
    private ArrayList<DataBase> wednesdayData;
    private ArrayList<DataBase> thursdayData;
    private ArrayList<DataBase> fridayData;
    
    
    public TemperatureView() {
        mondayData = new ArrayList<DataBase>();
        tuesdayData = new ArrayList<DataBase>();
        wednesdayData = new ArrayList<DataBase>();
        thursdayData = new ArrayList<DataBase>();
        fridayData = new ArrayList<DataBase>();
    }
    
    public TemperatureView(ArrayList<DataBase> overallContext) {
        mondayData = new ArrayList<DataBase>();
        tuesdayData = new ArrayList<DataBase>();
        wednesdayData = new ArrayList<DataBase>();
        thursdayData = new ArrayList<DataBase>();
        fridayData = new ArrayList<DataBase>();
        
        this.overallContext = overallContext;
    }

    /**
     * Get data for Monday from either overallContext OR from table InitialMonitoring
     */
    public void getMonday() {
        if(overallContext.isEmpty()) {
            
        } else {
            for(DataBase entry : overallContext) {
                
            }
        }
    }

    /**
     * Get data for Tuesday from either overallContext OR from table InitialMonitoring
     */
    public void getTuesday() {

    }
    
    /**
     * Get data for Wednesday from either overallContext OR from table InitialMonitoring
     */
    public void getWednesday() {

    }

    /**
     * Get data for Thursday from either overallContext OR from table InitialMonitoring
     */
    public void getThursday() {

    }

    /**
     * Get data for Friday from either overallContext OR from table InitialMonitoring
     */
    public void getFriday() {

    }

    /**
     * 
     * @param path 
     */
    public void serializeDataToJSON(String path) {

    }
    
}
