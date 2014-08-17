


package ami.web.core.servlets.modules;

import ami.web.core.db.InitialTable;
import ami.web.core.models.client.DataBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Jonathan Perry
 */
public class SystemOverview {
    
    private InitialTable initialTable;
    private FileWriter fWriter;
    private ArrayList<DataBase> temperatureData;
    
    private JSONObject overview_temperature;
//    private JSONObject overview_motion;
    
    public SystemOverview() {     
        initialTable = new InitialTable();
        temperatureData = new ArrayList<DataBase>();
        fWriter = null;
    }
    
    /**
     * Retrieves temperature data from INITIAL MONITORING TABLE
     * 
     * We'll need to change this to the general table later!!!
     */
    public void getTemperatureData() {
        String field = "Temperature";
        
        initialTable.open();
        temperatureData = initialTable.retrieveOverviewByName(field);
        initialTable.close();
    }
    
    /**
     * 
     * @param path 
     */
    public void serializeDataToJson(String path) {
        String hostname_one = "Agent 1";
        String hostname_two = "Agent 2";
        
        // temperature
        overview_temperature = new JSONObject();
        JSONArray array = new JSONArray();
        JSONArray arr_hostname_one = new JSONArray();        
        JSONArray arr_hostname_two = new JSONArray();
        
        String temperature_overview_file = "temperature_overview.json";
        
        String fWriterPathTemperature = path;
        fWriterPathTemperature += "js/";
        fWriterPathTemperature += temperature_overview_file;
        
        // others...
        
        
        /*
         * temperature
         */
        if(!temperatureData.isEmpty() ) {
            for(DataBase d : temperatureData) {
                // hostname
                
                
                // bind them both together
                // don't worry it is reverse!
                overview_temperature.put(hostname_one, arr_hostname_one);
                overview_temperature.put(hostname_two, arr_hostname_two);
            }
            
            // write data to file
            try {
                fWriter = new FileWriter(fWriterPathTemperature);
                fWriter.write(overview_temperature.toJSONString() );
                fWriter.flush();
                fWriter.close();
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        
        // other contextual types...        
        
    }
    
}