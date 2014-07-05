/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ami.web.core.servlets;

import ami.web.core.db.Temperature;
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
        List<Integer> results = null;
        String msg = null;        
        JSONObject jsonObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        FileWriter fWriter = null;
        
        /**
         * Get the required content from the database
         */
        if(type.equals("overview")) {
            Temperature dbTemp = new Temperature();
            dbTemp.open();
            results = dbTemp.getResults();
            
            for(int value : results) {
                jsonArray.add(value);
            }
                        
            jsonObj.put("overviewtemperature", jsonArray);
            
            // create the path for which we need to save our JSON data structure to
            // for parsing using JavaScript
            String filename = "overview_temperature.json";
            
            String fWriterPath = getServletContext().getRealPath("/");
            fWriterPath += "js/";
            fWriterPath += filename;
            
            try {
                fWriter = new FileWriter(fWriterPath);
                fWriter.write(jsonObj.toJSONString() );
                fWriter.flush();
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
            finally {                
                fWriter.close();
            }            
        }
        else if(type.equals("temperature")) {
            Temperature dbTemp = new Temperature();
            dbTemp.open();
            results = dbTemp.getResults();
        }
        else if(type.equals("atmosphere")) {
            
        }
        else if(type.equals("motion")) {
            
        }
        
        // set the first letter to uppercase
        type = type.substring(0, 1).toUpperCase() + type.substring(1);
        
        request.setAttribute("type", type);
//        request.setAttribute("results", results);
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
}