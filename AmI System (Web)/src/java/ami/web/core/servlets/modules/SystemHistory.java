


package ami.web.core.servlets.modules;

import ami.web.core.db.InitialTable;
import ami.web.core.db.SystemInfoTable;
import ami.web.core.models.client.ClientInfo;

/**
 *
 * @author Jonathan Perry
 */
public class SystemHistory {
        
    private ClientInfo clientInfo;
    private InitialTable initialTable;
    private SystemInfoTable systemInfoTable;
    
    public SystemHistory() {
        clientInfo = new ClientInfo();
        initialTable = new InitialTable();
        systemInfoTable = new SystemInfoTable();
        
        systemInfoTable.open();
        clientInfo = systemInfoTable.getClientInfo();
        systemInfoTable.close();
    }

    /**
     * 
     */
//    public void getAccumulatedHours() {
//        this.clientInfo.setAccumulatedHours(initialTable.getAccumulatedHours() );
//    }

    /**
     * 
     */
//    public void getAccumulatedMinutes() {
//        this.clientInfo.setAccumulatedMinutes(initialTable.getAccumulatedMinutes() );
//    }

    /**
     * 
     */
//    public void getHostnames() {
//        this.clientInfo.setMacAddrs(initialTable.getHostnames() );
//    }

    /**
     * 
     */
//    public void getNoSensors() {
//        this.clientInfo.getNoSensors(initialTable.getNoSensors() );
//    }

    /**
     * 
     */
//    public void getNoIndividualSensors() {
//        this.clientInfo.getNoIndividualSensors(initialTable.getIndividualSensors() );
//    }

    /**
     * 
     */
    public void serializeDataToJson() {
        // accumulated hours
        if(clientInfo.getAccumulatedHours() != 0) {
            
        } else {
            
        }
        
        // accumulated minutes
        if(clientInfo.getAccumulatedMinutes() != 0) {
            
        } else {
            
        }
        
        // hostnames
        if(clientInfo.getNoHostnames() != 0) {
            
        } else {
            
        }
        
//        // no individual sensors
//        if(clientInfo.getNoIndividualSensors() != 0) {
//            
//        } else {
//            
//        }
        
        // no sensors
        if(clientInfo.getNoSensors() != 0) {
            
        } else {
            
        }
        
    }
    
}
