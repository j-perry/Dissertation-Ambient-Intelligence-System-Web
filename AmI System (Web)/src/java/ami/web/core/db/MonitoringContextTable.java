/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.db;

// libraries
import static ami.web.core.db.IDatabase.dbUrl;
import static ami.web.core.db.IDatabase.driver;
import static ami.web.core.db.IDatabase.password;
import static ami.web.core.db.IDatabase.username;
import ami.web.core.models.client.DataBase;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
public class MonitoringContextTable implements IDatabase {

    private String query;

    private Statement qryStatement;
    private PreparedStatement prepQuery;
    private ResultSet resultSet;
    private Connection conn;

    private final String tableName = "MonitoringContext";

    public MonitoringContextTable() {
        // register the driver
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
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
            System.out.println("MySQL CONNECTON FOUND");
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Checks to see whether the MonitoringContext table is empty
     *
     * @return whether the table is empty or not
     */
    public boolean isEmpty() {
        boolean isEmpty = false;
        query = "SELECT COUNT(*) "
                + "FROM " + tableName;
        ResultSet rs;

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);

            // check the table exists
            DatabaseMetaData dbm = conn.getMetaData();

            // check if "MonitoringContext" table is there
            ResultSet table = dbm.getTables(null, null, tableName, null);

            if (table.next()) {
                // Table exists
                qryStatement = conn.createStatement();
                rs = qryStatement.executeQuery(query);

                // go to the last row entry
                rs.last();
                int noRows = rs.getRow();

                // check whether the table is empty or now
                if (noRows > 0) {

                    System.out.println();
                    System.out.println("-------------------------------------------");
                    System.out.println("MonitoringContext is not empty");
                    System.out.println("-------------------------------------------");
                    System.out.println();

                    isEmpty = false;
                } else {
                    System.out.println();
                    System.out.println("-------------------------------------------");
                    System.out.println("MonitoringContext is empty");
                    System.out.println("-------------------------------------------");
                    System.out.println();
                    isEmpty = true;
                }
            } else {
                // Table does not exist
                System.out.println();
                System.out.println("-------------------------------------------");
                System.out.println("MonitoringContext does not empty");
                System.out.println("-------------------------------------------");
                System.out.println();
                
                isEmpty = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isEmpty;
    }

    /**
     * As the name implies
     *
     * @param field
     * @return
     */
    public ArrayList<DataBase> getFieldsByType(String field) {
        ArrayList<DataBase> entries = new ArrayList<DataBase>();
        DataBase dataBase = new DataBase();
        query = "SELECT * "
                + "FROM " + tableName + " "
                + "WHERE Context = '" + field + "'";

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            qryStatement = conn.createStatement();
            ResultSet rs = qryStatement.executeQuery(query);

            while (rs.next()) {
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

    /**
     * Retrieves raw data from the table
     *
     * @return
     */
    public ArrayList<DataBase> retrieveAll() {
        ArrayList<DataBase> entries = new ArrayList<DataBase>();
        DataBase dataBase = new DataBase();
        query = "SELECT * "
                + "FROM " + tableName;

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            qryStatement = conn.createStatement();
            ResultSet rs = qryStatement.executeQuery(query);

            while (rs.next()) {
                // session id
                dataBase.setSessionId(rs.getInt("SessionId"));

                // time
                dataBase.setHour(rs.getInt("Hour"));
                dataBase.setMinute(rs.getInt("Month"));

                // date
                dataBase.setDay(String.valueOf(rs.getInt("Day")));
                dataBase.setMonth(String.valueOf(rs.getInt("Month")));
                dataBase.setYear(rs.getInt("Year"));

                // general data
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

    /**
     * Retrieves raw data from the table by field
     *
     * @return
     */
    public ArrayList<DataBase> retrieveOverviewByName(String field) {
        ArrayList<DataBase> entries = new ArrayList<DataBase>();
        DataBase dataBase = new DataBase();
        query = "SELECT * "
                + "FROM " + tableName + " "
                + "WHERE Context= '" + field + "'";

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);

            // check the table exists
            DatabaseMetaData dbm = conn.getMetaData();

            // check if "MonitoringContext" table is there
            ResultSet table = dbm.getTables(null, null, tableName, null);

            // table exists
            if (table.next()) {
                qryStatement = conn.createStatement();
                ResultSet rs = qryStatement.executeQuery(query);

                System.out.println();
                System.out.println(tableName + "DOESN'T EXIST");
                System.out.println();

                while (rs.next()) {
                    dataBase.setSessionId(rs.getInt("SessionId"));
                    dataBase.setHostname(rs.getString("Hostname"));
                    dataBase.setHour(rs.getInt("Hour"));
                    dataBase.setMinute(rs.getInt("Minute"));
                    dataBase.setDay(rs.getString("Day"));
                    dataBase.setMonth(rs.getString("Month"));
                    dataBase.setYear(rs.getInt("Year"));
                    dataBase.setValue(rs.getInt("Value"));
                    dataBase.setType(rs.getString("Context"));
                    dataBase.setLinguisticType(rs.getString("LinguisticType"));

                    entries.add(dataBase);

                    rs.close();
                }
            } else {
                entries = null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return entries;
    }

}
