/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.db;

// local libraries
import static ami.web.core.db.IDatabase.dbUrl;
import static ami.web.core.db.IDatabase.password;
import static ami.web.core.db.IDatabase.username;
import ami.web.core.models.client.DataBase;

// Java APIs
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
public class OverallContextTable implements IDatabase {
    
    private String query;

    private Statement qryStatement;
    private PreparedStatement prepQuery;
    private ResultSet resultSet;
    private Connection conn;
    
    private final String tableName = "OverallContext";
    
    public OverallContextTable() {
        // register the driver
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Opens a new database connection
     */
    @Override
    public void open() {
        try {
            // https://mysql.student.sussex.ac.uk/phpmyadmin/
            conn = DriverManager.getConnection(dbUrl, username, password);
                        
            // create the table if necessary
            createTable();
            System.out.println("MySQL CONNECTON FOUND");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Creates a table if it doesn't exist
     */
    private void createTable() {
        query = "CREATE TABLE IF NOT EXISTS " + tableName + " " +
                "( " +
                "  Id             INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                "  SessionId      INTEGER, " + 
                "  Hostname       VARCHAR(30), " +
                "  Hour           INTEGER, " + 
                "  Minute         INTEGER, " + 
                "  Day            VARCHAR(20), " +
                "  Month          VARCHAR(20), " +
                "  Year           INTEGER, " +
                "  Value          INTEGER, " + 
                "  Context        VARCHAR(20), " + 
                "  LinguisticType VARCHAR(30) " + 
                ")";
        
        int status = 0;
         
        try {
            qryStatement = conn.createStatement();
            status = qryStatement.executeUpdate(query);
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * 
     * @param overallContext
     * @return 
     */
    public int update(ArrayList<DataBase> overallContext) {
        int result = 0;
        
        return result;
    }
    
}
