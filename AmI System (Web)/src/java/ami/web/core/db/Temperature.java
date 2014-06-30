/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ami.web.core.db;

import static ami.web.core.db.IDatabase.dbUrl;
import static ami.web.core.db.IDatabase.driver;
import static ami.web.core.db.IDatabase.password;
import static ami.web.core.db.IDatabase.username;
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
public class Temperature implements IDatabase {
    
    private Statement qryStatement;
    private PreparedStatement prepQuery;
    private ResultSet resultSet;
    private Connection conn;
    
    public Temperature() {
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
     * Gets the temperatures from the database table
     * @return 
     */
    public ArrayList<Integer> getResults() {
        ArrayList<Integer> results = new ArrayList();
        String qryResults = "SELECT * " +
                            "FROM temperature";
        ResultSet rs = null;
        
        try {
            qryStatement = conn.createStatement();
            rs = qryStatement.executeQuery(qryResults);
            
            while(rs.next() ) {
                results.add(rs.getInt("Value") );
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
