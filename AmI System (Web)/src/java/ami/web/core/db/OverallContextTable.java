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
    
    public boolean maxLimit() {
        boolean reachedLimit;
        final int max_entries = 3000;
        int no_entries = 0;
        
        System.out.println("maxLimit()");
        
        query = "SELECT * " +
                "FROM " + tableName;
        
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            qryStatement = conn.createStatement();
            ResultSet rs = qryStatement.executeQuery(query);
            while(rs.next()) {
                no_entries++;
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        if(no_entries > max_entries) {
            System.out.println("max reached");
            reachedLimit = true;
        } else {
            System.out.println("max not reached " + no_entries);
            reachedLimit = false;
        }
        
        return reachedLimit;
    }
    
    public void clean() {
        deleteTable();
    }
    
    public void deleteTable() {
        query = "DROP TABLE " + tableName;
        
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            qryStatement = conn.createStatement();
            qryStatement.executeUpdate(query);
            System.out.println("DELETED?");
        } catch(SQLException ex) {
            ex.printStackTrace();
        } 
    }

    /**
     * Creates a table if it doesn't exist
     */
    private void createTable() {
        query = "CREATE TABLE IF NOT EXISTS " + tableName + " "
                + "( "
                + "  Id             INTEGER AUTO_INCREMENT PRIMARY KEY, "
                + "  SessionId      INTEGER, "
                + "  Hostname       VARCHAR(30), "
                + "  Hour           INTEGER, "
                + "  Minute         INTEGER, "
                + "  Day            VARCHAR(20), "
                + "  Month          VARCHAR(20), "
                + "  Year           INTEGER, "
                + "  Value          INTEGER, "
                + "  Context        VARCHAR(20), "
                + "  LinguisticType VARCHAR(30) "
                + ")";
        
        int status = 0;
        
        try {
            qryStatement = conn.createStatement();
            status = qryStatement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Insert the OverallContextTable model
     *
     * @param overallContext
     * @return
     */
    public int insert(ArrayList<DataBase> overallContext) throws SQLException {
        int result = 0;
        PreparedStatement statement = null;
        // insert statement
            query = "INSERT INTO " + tableName + " " +
                    "( " +
                        "SessionId, " + 
                        "Hostname, " + 
                        "Hour, " + 
                        "Minute, " + 
                        "Day, " + 
                        "Month, " + 
                        "Year, " + 
                        "Value, " + 
                        "Context, " + 
                        "LinguisticType" +
                    ") " +                    
                    "VALUES " +
                    "( " +
                        "?, " +
                        "?," +
                    
                        "?, " +
                        "?, " +
                    
                        "?, " +
                        "?, " +
                        "?, " +
                    
                        "?, " +
                        "?, " +
                        "?" +
                    ");";
                
        
        // loop through each of the entries in overallContext
        // and write them to the table
        try {            
            statement = conn.prepareStatement(query);
            
            for (int i = 0; i < overallContext.size(); i++) {
                DataBase entry = overallContext.get(i);
                
                statement.setInt(1, entry.getSessionId() );
                statement.setString(2, entry.getHostname() );
                
                statement.setInt(3, entry.getHour() );
                statement.setInt(4, entry.getMinute() );
                
                statement.setString(5, entry.getDay());
                statement.setString(6, entry.getMonth());
                statement.setInt(7, entry.getYear());
                
                statement.setInt(8, entry.getValue());
                statement.setString(9, entry.getType());
                statement.setString(10, entry.getLinguisticType());
                statement.addBatch();
            }
            
            // write all values to the table
            statement.executeBatch();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
            } catch(SQLException ex) {
                ex.printStackTrace();
            }            
        }
        
        return result;
    }
    
    /**
     * 
     * @param field
     * @return 
     */
    public ArrayList<DataBase> retrieveOverviewByName(String field) {
        ArrayList<DataBase> entries = new ArrayList<DataBase>();
        DataBase dataBase = new DataBase();
        query = "SELECT * "
                + "FROM " + tableName + " "
                + "WHERE Context='" + field + "'";
        
        
                System.out.println("overallContextTable.retrieveOverviewByName(fieldType)");

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            qryStatement = conn.createStatement();
            ResultSet rs = qryStatement.executeQuery(query);

            while (rs.next()) {
                dataBase.setSessionId(rs.getInt("SessionId"));
                dataBase.setHostname(rs.getString("Hostname"));
                System.out.println("HOSTNAME: "+ rs.getString("Hostname"));

                dataBase.setHour(rs.getInt("Hour"));
                dataBase.setMinute(rs.getInt("Minute"));

                dataBase.setDay(rs.getString("Day"));
                dataBase.setMonth(rs.getString("Month"));
                dataBase.setYear(rs.getInt("Year"));

                dataBase.setValue(rs.getInt("Value"));
                dataBase.setType(rs.getString("Context"));
                dataBase.setLinguisticType(rs.getString("LinguisticType"));

                entries.add(dataBase);
            }

            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return entries;
    }
    
}