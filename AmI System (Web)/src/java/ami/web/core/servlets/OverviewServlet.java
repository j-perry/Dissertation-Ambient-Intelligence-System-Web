/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ami.web.core.servlets;

import ami.web.core.db.*;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Overview", urlPatterns = {"/overview"})
public class OverviewServlet extends HttpServlet {

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
        Temperature dbTemp = new Temperature();
        dbTemp.open();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\" />");
            out.println("<title>Overview</title>");
        out.println("</head>");
        out.println("<body>");

        try {
            ArrayList<Integer> results = dbTemp.getResults();
            int value = 0;
            
            if(!results.isEmpty()) {
                for (Integer entry : results) {
                    value = entry.intValue();
                    out.println("<h3>DatabaseTest: " + value + "</h3>");
                }
            }
            else {
                out.println("<h1>DatabaseTest: " + "EMPTY" + "</h1>");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");
        
        // close the stream
        out.close();        
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
        processRequest(request, response);
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
        String records = "Hello World!";
        
        request.setAttribute("record", records);
        
        String url = "/overview.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
        processRequest(request, response);
    }
}