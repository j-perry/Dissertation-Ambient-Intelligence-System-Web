/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ami.web.core.db;

import java.sql.SQLException;

/**
 *
 * @author Jonathan Perry
 */
public interface IDatabase {    
    
    public final static String driver = "com.mysql.jdbc.Driver";
    
    // DO NOT CHANGE CONSTANT VALUE!!!
    public final static String dbUrl = "jdbc:mysql://mysql.student.sussex.ac.uk/jp373";
    public final static String username = "jp373";
    public final static String password = "ripe-faraway-tomato";

    /**
     * 
     */
    public void open();
    
    /**
     * 
     */
    public void close();
    
}
