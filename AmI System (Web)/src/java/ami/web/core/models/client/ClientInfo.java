/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.models.client;

import java.util.Stack;

/**
 * Stores info from client devices
 * @author Jonathan Perry
 */
public class ClientInfo {
    
    private Stack<String> hostnames;
    private int hours;
    private int minutes;
    private int noIndividualSensors;
    private int noSensors;
    
    public ClientInfo() {
        hostnames = new Stack<String>();
    }
    
    /**
     * Assign the host name for each client on the system
     * @param hostnames
     */
    public void setHostnames(String hostname) {
        if(hostnames.size() == 0) {
            hostnames.push(hostname);
        }
        
        if(!hostnames.contains(hostname)) {
            this.hostnames.add(hostname);            
        }
    }
    
    /**
     * Get each host name for each client connected to the system
     * @return 
     */
    public Stack<String> getHostnames() {
//    public String getHostname() {
        return hostnames;
//        return hostname;
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
        final int MAX_MINS = 60;
        
        if(this.minutes < 59) {
            this.minutes += minutes;
        } else{
            this.hours++;
            this.minutes = (MAX_MINS - minutes);
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