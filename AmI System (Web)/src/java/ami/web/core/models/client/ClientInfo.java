


package ami.web.core.models.client;

import java.util.ArrayList;

/**
 * Stores info from client devices
 * @author Jonathan Perry
 */
public class ClientInfo {
    
    private ArrayList<String> hostnames;
    private int hours;
    private int minutes;
    private int noIndividualSensors;
    private int noSensors;
    
    public ClientInfo() {
        
    }
    
    /**
     * Assign the MAC address for each client on the system
     * @param macAddr 
     */
    public void setHostnames(String hostnames) {
        if(!hostnames.contains(hostnames) ) {
            this.hostnames.add(hostnames);
        }
    }
    
    /**
     * Get each MAC address for each client connected to the system
     * @return 
     */
    public ArrayList<String> getHostnames() {
        return hostnames;
    }
    
    /**
     * Return the number of clients connected to the system
     * @return 
     */
    public int getNoHostnames() {
        return hostnames.size();
    }
    
    /**
     * Assign the number of accumulated hours logged by the system
     * @param hours 
     */
    public void setAccumulatedHours(int hours) {
        this.hours += hours;
    }
    
    /**
     * Return the number of accumulated hours logged by the system
     * @return 
     */
    public int getAccumulatedHours() {
        return hours;
    }
    
    /**
     * Assign the number of accumulated minutes logged by the system
     * @param minutes 
     */
    public void setAccumulatedMinutes(int minutes) {
        if(this.minutes < 59) {
            this.minutes += minutes;
        } else{
            this.hours++;
            this.minutes = (60 - minutes);
        }
    }
    
    /**
     * Return the number of accumulated minuted logged by the system
     * @return 
     */
    public int getAccumulatedMinutes() {
        return minutes;
    }
    
    /**
     * Assign the number of individual sensors for each client device
     * @param noIndividualSensors 
     */
    public void setNoIndividualSensors(int noIndividualSensors) {
        this.noIndividualSensors = (noIndividualSensors / 2);
    }
    
    /**
     * Return the number of individual sensors connected to each client device
     * @return 
     */
    public int getNoIndividualSensors() {
        return noIndividualSensors;
    }
    
    /**
     * Assign the total number of sensors connected to the system
     * @param noSensors 
     */
    public void setNoSensors(int noSensors) {
        this.noSensors = noSensors;
    }
    
    /**
     * Return the total number of sensors connected to the system
     * @return 
     */
    public int getNoSensors() {
        return noSensors;
    }
    
}