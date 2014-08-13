


package ami.web.core.models.client;

import java.util.ArrayList;

/**
 * Stores info from client
 * @author Jonathan Perry
 */
public class ClientInfo {
    
    private ArrayList<String> macAddrs;
    private int hours;
    private int minutes;
    private int noIndividualSensors;
    private int noSensors;
    
    public ClientInfo() {
        
    }
    
    public void setMacAddrs(String macAddr) {
        this.macAddrs.add(macAddr);
    }
    
    public ArrayList<String> getMacAddrs() {
        return macAddrs;
    }
    
    public int getNoMacAddrs() {
        return macAddrs.size();
    }
    
    public void setAccumulatedHours(int hours) {
        this.hours = hours;
    }
    
    public int getAccumulatedHours() {
        return hours;
    }
    
    public void setAccumulatedMinutes(int minutes) {
        this.minutes = minutes;
    }
    
    public int getAccumulatedMinutes() {
        return minutes;
    }
    
    public void setNoIndividualSensors(int noIndividualSensors) {
        this.noIndividualSensors = noIndividualSensors;
    }
    
    public int getNoIndividualSensors() {
        return noIndividualSensors;
    }
    
    public void setNoSensors(int noSensors) {
        this.noSensors = noSensors;
    }
    
    public int getNoSensors() {
        return noSensors;
    }
    
}
