package ami.web.core.servlets.modules;

import ami.web.core.db.InitialTable;
import ami.web.core.db.SystemInfoTable;
import ami.web.core.models.client.ClientInfo;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.*;

/**
 *
 * @author Jonathan Perry
 */
public class SystemHistory {

    private ClientInfo clientInfo;
    private InitialTable initialTable;
    private SystemInfoTable systemInfoTable;
    private JSONObject overview;
    private FileWriter fWriter;

    public SystemHistory() {
        clientInfo = new ClientInfo();
        initialTable = new InitialTable();
        systemInfoTable = new SystemInfoTable();
        fWriter = null;
    }

    /**
     *
     */
    public void getData() {
        systemInfoTable.open();
        clientInfo = systemInfoTable.getClientInfo();
        systemInfoTable.close();
    }

    /**
     *
     */
    public void serializeDataToJson(String path) {
        overview = new JSONObject();
        String KEY_HOURS = "hours";
        String KEY_MINUTES = "minutes";
        
        // create the path for which we need to save our JSON data structure to
        // for parsing using JavaScript
        String filename = "overview.json";
        
        String fWriterPath = path;
        fWriterPath += "js/";
        fWriterPath += filename;
        
        // accumulated hours
        if (clientInfo.getAccumulatedHours() != 0) {
            overview.put(KEY_HOURS, clientInfo.getAccumulatedHours());
        } else {
            overview.put(KEY_HOURS, (Integer) 0);
        }

        // accumulated minutes
        if (clientInfo.getAccumulatedMinutes() != 0) {
            overview.put(KEY_MINUTES, clientInfo.getAccumulatedMinutes());
        } else {
            overview.put(KEY_MINUTES, (Integer) 0);
        }
        
        // no. hostnames
        overview.put("noHostnames", clientInfo.getHostnames().size() );
        
        // no sensors
        if (clientInfo.getNoSensors() != 0) {
            overview.put("noSensors", clientInfo.getNoSensors());
        } else {
            overview.put("noSensors", (Integer) 0);
        }
                
//        // no. individual sensors
//        if(clientInfo.getNoIndividualSensors() != 0) {
//            
//        } else {
//            
//        }
        
        try {
            fWriter = new FileWriter(fWriterPath);
            fWriter.write(overview.toJSONString());
            fWriter.flush();
            fWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
