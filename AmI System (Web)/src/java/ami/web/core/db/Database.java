


package ami.web.core.db;

import java.sql.*;
import java.util.HashMap;

/**
 *
 * @author Jonathan Perry
 */
public class Database implements IDatabase {
        
    private String query;
    
    private Statement qryStatement;
    private PreparedStatement prepQuery;
    private ResultSet resultSet;
    private Connection conn;
        
    public Database() {        
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
     * @throws SQLException 
     */
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
    
    public int insert() {        
        // select statement
        query = "INSERT INTO test (Name)" +
                "VALUES ('Jonathan')";
                
        int status = 0;
        
        try {                                    
            qryStatement = conn.createStatement();
            status = qryStatement.executeUpdate(query);
            
            System.out.println("> Data has been written");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return status;
    }
    
    /**
     * 
     * @return 
     */
    public String getValues() {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        query = "SELECT * " +
                "FROM test";
        
        String name = null;
        
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("> Connection has been found");
            
            qryStatement = conn.createStatement();
            ResultSet rs = qryStatement.executeQuery(query);
            
            rs.next();
            name = rs.getString("Name");
                
            System.out.println("Name: " + name);
                        
            rs.close();            
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return name;
    }
        
}
