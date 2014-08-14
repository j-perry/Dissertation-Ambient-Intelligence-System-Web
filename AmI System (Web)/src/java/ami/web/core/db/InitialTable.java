


package ami.web.core.db;

import static ami.web.core.db.IDatabase.dbUrl;
import static ami.web.core.db.IDatabase.driver;
import static ami.web.core.db.IDatabase.password;
import static ami.web.core.db.IDatabase.username;
import ami.web.core.models.client.ClientInfo;
import ami.web.core.models.client.DataBase;

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
public class InitialTable implements IDatabase {
        
    private String query;
    
    private Statement qryStatement;
    private PreparedStatement prepQuery;
    private ResultSet resultSet;
    private Connection conn;
    
    public InitialTable() {
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
     * Retrieves raw data from the table
     * @return 
     */
    public ArrayList<DataBase> retrieveOverview() {
       ArrayList<DataBase> entries = new ArrayList<DataBase>();       
       DataBase dataBase = new DataBase();
       query = "SELECT * FROM Initial";
       
       try {
           conn = DriverManager.getConnection(dbUrl, username, password);            
           qryStatement = conn.createStatement();
           ResultSet rs = qryStatement.executeQuery(query);
           
           while(rs.next() ) {
               dataBase.setValue(rs.getInt("Value"));
               dataBase.setType(rs.getString("Type"));
               dataBase.setLinguisticType(rs.getString("LinguisticType"));
               
               entries.add(dataBase);
           }
           
           rs.close();
       } catch(SQLException ex) {
           ex.printStackTrace();
       }
              
       return entries;
    }
    
    /**
     * Retrieves info about the clients connected to the system
     */
    public ClientInfo getClientInfo() {
       ClientInfo clientInfo = new ClientInfo();
       query = "SELECT * FROM SystemInfo";
       
       try {
           conn = DriverManager.getConnection(dbUrl, username, password);            
           qryStatement = conn.createStatement();
           ResultSet rs = qryStatement.executeQuery(query);
           
           while(rs.next() ) {
               clientInfo.setAccumulatedHours(rs.getInt("Hours") );
               clientInfo.setAccumulatedMinutes(rs.getInt("Minutes") );
               clientInfo.setMacAddrs(rs.getString("MacAddr") );
               clientInfo.setNoSensors(rs.getInt("NoSensors") );
//               clientInfo.setNoIndividualSensors(rs.getInt("NoSensors") );
               
               rs.close();
           }
       } catch(SQLException ex) {
           ex.printStackTrace();
       }
       
       return clientInfo;
    }
                
}