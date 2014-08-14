package ami.web.core.servlets;

import ami.web.core.models.Temperature;
import ami.web.core.db.TemperatureTable;
import ami.web.core.servlets.modules.SystemHistory;
import ami.web.core.servlets.modules.SystemOverview;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.*;

/**
 *
 * @author Jonathan Perry
 */
@WebServlet(name = "Navigation", urlPatterns = {"/Navigation"})
public class View extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
     * Handles the HTTP
     * <code>GET</code> method.
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

        String type = request.getParameter("type");
        String viewUrl = type + ".jsp";
        String msg = null;
        JSONObject jsonObj = new JSONObject();
        FileWriter fWriter = null;



        /**
         * Get the required content from the database
         */
        if (type.equals("overview")) {
            String path = getServletContext().getRealPath("/");
            
            // get the system history from the database and serialise it to JSON
            getSystemHistory(path);
            
            getSystemOverview(path);

            TemperatureTable dbTemp = new TemperatureTable();
            dbTemp.open();
            List<Temperature> results = dbTemp.getResults();
            JSONArray values = new JSONArray();
            JSONArray dates = new JSONArray();
            JSONArray times = new JSONArray();
            
            // value
            for (Temperature result : results) {
                values.add(result.getValue());
            }

            jsonObj.put("value", values);

            // date
            for (Temperature result : results) {
                dates.add(result.getDate());
            }

            jsonObj.put("date", dates);

            // time
            for (Temperature result : results) {
                times.add(result.getTime());
            }

            jsonObj.put("time", times);

            // create the path for which we need to save our JSON data structure to
            // for parsing using JavaScript
            String filename = "overview_temperature.json";

            String fWriterPath = getServletContext().getRealPath("/");
            fWriterPath += "js/";
            fWriterPath += filename;

            try {
                fWriter = new FileWriter(fWriterPath);
                fWriter.write(jsonObj.toJSONString());
                fWriter.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                fWriter.close();
            }
        } else if (type.equals("skills")) {
            type = "Skills";
        }

        // set the first letter to uppercase
        type = type.substring(0, 1).toUpperCase() + type.substring(1);

        // populate and send a HTTP request object with header info
        request.setAttribute("type", type);
        RequestDispatcher view = request.getRequestDispatcher(viewUrl);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
     * 
     * @param path Servlet path
     */
    private void getSystemHistory(String path) {
        SystemHistory history = new SystemHistory();
        history.getData();
        history.serializeDataToJson(path);
    }
    
    /**
     * 
     * @param path 
     */
    private void getSystemOverview(String path) {
        SystemOverview overview = new SystemOverview();
        overview.getData();
        overview.serializeDataToJson(path);
    }
}