/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.db;

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
     * Opens a new database connection
     */
    public void open();
    
    /**
     * Closes the database connection
     */
    public void close();
    
}
