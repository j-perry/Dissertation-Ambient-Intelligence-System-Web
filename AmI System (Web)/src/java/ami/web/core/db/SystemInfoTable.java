/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.db;

import static ami.web.core.db.IDatabase.dbUrl;
import static ami.web.core.db.IDatabase.driver;
import static ami.web.core.db.IDatabase.password;
import static ami.web.core.db.IDatabase.username;
import ami.web.core.models.client.ClientInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Perry
 */
public class SystemInfoTable implements IDatabase {
    
    private String query;
    
    private Statement qryStatement;
    private PreparedStatement prepQuery;
    private ResultSet resultSet;
    private Connection conn;
    
    public SystemInfoTable() {
        // register the driver
        try {
            Class.forName(driver);
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Open a new JDBC connection
     */
    @Override
    public void open() {
        try {
            // https://mysql.student.sussex.ac.uk/phpmyadmin/
            conn = DriverManager.getConnection(dbUrl, username, password);
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Close the JDBC connection
     */
    @Override
    public void close() {
        try {
            conn.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Retrieves info about the clients connected to the system
     */
    public ClientInfo getClientInfo() {
       ClientInfo clientInfo = new ClientInfo();
       query = "SELECT * FROM SystemInfo";
       ArrayList<String> hostnames = new ArrayList<String>();
       
       try {
           conn = DriverManager.getConnection(dbUrl, username, password);            
           qryStatement = conn.createStatement();
           ResultSet rs = qryStatement.executeQuery(query);
           
           while(rs.next() ) {
               clientInfo.setAccumulatedHours(rs.getInt("Hours") );
               clientInfo.setAccumulatedMinutes(rs.getInt("Minutes") );               
               clientInfo.setHostnames(rs.getString("HostName") );               
               clientInfo.setNoSensors(rs.getInt("NoSensors") );
               clientInfo.setNoIndividualSensors(rs.getInt("NoSensors") );
           }
           
           rs.close();
       } catch(SQLException ex) {
           ex.printStackTrace();
       }
       
       return clientInfo;
    }
    
}