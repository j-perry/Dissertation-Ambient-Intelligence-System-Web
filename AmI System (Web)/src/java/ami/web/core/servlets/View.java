/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.servlets;

// local libraries
import ami.web.core.db.*;
import ami.web.core.intelligence.ExperienceBank;
import ami.web.core.models.client.DataBase;
import ami.web.core.servlets.modules.*;

// Java APIs
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Jonathan Perry
 */
@WebServlet(name = "Navigation", urlPatterns = {"/Navigation"})
public class View extends HttpServlet {

    private InitialContextTable initialContextTable;
    private MonitoringContextTable monitoringContextTable;
    private OverallContextTable overallContextTable;
    private String path;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Navigation</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Navigation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        initialContextTable = new InitialContextTable();
        monitoringContextTable = new MonitoringContextTable();

        overallContextTable = new OverallContextTable();

        String type = request.getParameter("type");
        String viewUrl = type + ".jsp";
        

        /**
         * Get the required content from the database
         */
        // overview.jsp view
        if (type.equals("overview")) {
            path = getServletContext().getRealPath("/");

            // open our database connections
            initialContextTable.open();
            monitoringContextTable.open();

            // if the MonitoringContext table is not empty...
            if (monitoringContextTable.isEmpty() == false) {

                overallContextTable.open();

                // for performance purposes...
                if (overallContextTable.maxLimit() == true) {
                    overallContextTable.deleteTable();
                    System.out.println("DELETED TABLE");
                }
                
                overallContextTable.close();

                ExperienceBank exBank = new ExperienceBank();

                System.out.println();
                System.out.println("--------------------------------");
                System.out.println();
                System.out.println("monitoringContextTable.isEmpty() == false");
                System.out.println();
                System.out.println("--------------------------------");

                // retrieve all entries from both table InitialContext and MonitoringContext
                ArrayList<DataBase> initialContext = initialContextTable.retrieveSample();
                ArrayList<DataBase> monitoringContext = monitoringContextTable.retrieveAll();

                initialContextTable.close();
                monitoringContextTable.close();

                // create a balanced context, created by entry results stored in both tables
                ArrayList<DataBase> overallContext = exBank.create(initialContext, monitoringContext);
                
                System.out.println("overallContext size: " + overallContext.size());

                // generate a system overview based on the InitialContext table
                getSystemHistory(path);

                // create overview data based on our overall context
                SystemOverview systemOverview = new SystemOverview(overallContext);

                // sort the temperature and ultrasonic (movement)values from our 
                // overallContext collection not from the database
                systemOverview.getTemperatureData();
                systemOverview.getMovementData();

                // serialize our data to JSON
                systemOverview.serializeDataToJson(path);

                // write an updated contextual model based on weekday values (values
                // similar to those found in table MonitoringContext)
                //
                // only perform this operation here
                try {
                    overallContextTable.open();
                    overallContextTable.insert(overallContext);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    overallContextTable.close();
                }

            } // else if there aren't any entries in table MonitoringContext
            else {

                // get the system overview from the database and serialise it to JSON
                getSystemOverview(path);
            }
        } // temperature.jsp view
        else if (type.equals("temperature")) {
            path = getServletContext().getRealPath("/");
            
            monitoringContextTable.open();
            ArrayList<DataBase> overallContext = monitoringContextTable.retrieveOverviewByName(type);
            monitoringContextTable.close();
            
            // create overview data based on our overall context
            SystemOverview systemOverview = new SystemOverview(overallContext);
            systemOverview.getTemperatureData();
            
            // serialize our temperature overview data to JSON
            systemOverview.serializeDataToJson(path);
            
            // create "temperature" data based on our overall context
            TemperatureView temperatureView = new TemperatureView(overallContext);
            temperatureView.getSaturday();
            temperatureView.getSunday();
            temperatureView.getMonday();
            temperatureView.getTuesday();
            temperatureView.getWednesday();
            temperatureView.getThursday();
            temperatureView.getFriday();
            
            // serialize our weekly data to JSON
            temperatureView.serializeDataToJSON(path);

            // movement.jsp view
        } else if (type.equals("movement")) {
            path = getServletContext().getRealPath("/");

            monitoringContextTable.open();
            ArrayList<DataBase> overallContext = monitoringContextTable.retrieveOverviewByName(type);
            monitoringContextTable.close();
            
            // create overview data based on our overall context
            SystemOverview systemOverview = new SystemOverview(overallContext);
            systemOverview.getMovementData();
            
            // serialize our temperature overview data to JSON
            systemOverview.serializeDataToJson(path);
            
            // create "temperature" data based on our overall context
            MovementView movementView = new MovementView(overallContext);
            movementView.getSaturday();
            movementView.getSunday();
            movementView.getMonday();
            movementView.getTuesday();
            movementView.getWednesday();
            movementView.getThursday();
            movementView.getFriday();
            
            // serialize our weekly data to JSON
            movementView.serializeDataToJSON(path);
            
        }

        // set the first letter to uppercase
        type = type.substring(0, 1).toUpperCase() + type.substring(1);

        // populate and send a HTTP request object with header info
        request.setAttribute("type", type);
        RequestDispatcher view = request.getRequestDispatcher(viewUrl);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * Generates an overview of the system's history
     *
     * @param path Servlet path
     */
    private void getSystemHistory(String path) {
        SystemHistory history = new SystemHistory();
        history.getData();
        history.serializeDataToJson(path);
    }

    /**
     * Generates an overview of the system's contextual data (e.g., room
     * temperature, movement, etc)
     *
     * @param path Servlet path
     */
    private void getSystemOverview(String path) {
        SystemOverview overview = new SystemOverview();

        overview.getTemperatureData();
        overview.getMovementData();

        overview.serializeDataToJson(path);
    }

}
