


package ami.web.core.db;

import static ami.web.core.db.IDatabase.dbUrl;
import static ami.web.core.db.IDatabase.driver;
import static ami.web.core.db.IDatabase.password;
import static ami.web.core.db.IDatabase.username;
import ami.web.core.models.Temperature;

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
public class TemperatureTable implements IDatabase {
    
    private Statement qryStatement;
    private PreparedStatement prepQuery;
    private ResultSet resultSet;
    private Connection conn;
    
    public TemperatureTable() {
        // register the driver
        try {
            Class.forName(driver);
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Gets the temperatures from the database table
     * @return 
     */
    public ArrayList<Temperature> getResults() {
        ArrayList<Temperature> results = new ArrayList();
        String qryResults = "SELECT * " +
                            "FROM temperature";
        ResultSet rs = null;
        Temperature temp = new Temperature();
        
        try {
            qryStatement = conn.createStatement();
            rs = qryStatement.executeQuery(qryResults);
            
            while(rs.next() ) {
                // go through each column
                temp.setValue(rs.getInt("Value"));
                temp.setDate(rs.getString("Date"));
                temp.setTime(rs.getString("Time"));
                
                results.add(temp);
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
                        
        return results;
    }

    @Override
    public void open() {
        try {
            // https://mysql.student.sussex.ac.uk/phpmyadmin/
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("> Connection has been found");
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            conn.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
