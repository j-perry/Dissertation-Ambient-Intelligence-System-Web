


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
            System.out.println("Driver cannot be found");
        }
        
        System.out.println("> Driver has been found");
    }

    /**
     * 
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
     * 
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
     * 
     * @return 
     */
    public ArrayList<DataBase> retrieveOverview() {
       ArrayList<DataBase> entries = new ArrayList<DataBase>();       
       DataBase dataBase = new DataBase();
              
       return entries;
    }
    
    /**
     * 
     */
    public ClientInfo getClientInfo() {
       ClientInfo clientInfo = new ClientInfo();
       
       return clientInfo;
    }
                
}
