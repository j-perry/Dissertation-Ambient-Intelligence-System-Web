


package ami.web.core.servlets.modules;

import ami.web.core.db.InitialTable;
import ami.web.core.db.SystemInfoTable;
import ami.web.core.models.client.ClientInfo;

import java.io.FileWriter;
import org.json.simple.JSONObject;

/**
 *
 * @author Jonathan Perry
 */
public class SystemOverview {
    
    private ClientInfo clientInfo;
    private InitialTable initialTable;
    private SystemInfoTable systemInfoTable;
    private JSONObject overview;
    private FileWriter fWriter;
    
    public SystemOverview() {
        
    }
    
    /**
     * 
     */
    public void getData() {
        
    }
    
    /**
     * 
     * @param path 
     */
    public void serializeDataToJson(String path) {
        
    }
    
}