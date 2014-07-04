<%-- 
    Document   : overview
    Created on : 30-Jun-2014, 12:25:31
    Author     : Jonathan Perry
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overview</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body id="wrapper">
        <t:menu>
            <jsp:attribute name="menu" />
        </t:menu>
        
        <div id="content-wrapper">
            
            <t:page-header>
                <jsp:attribute name="header" />
            </t:page-header>
            
            <div class="section temperature">
                
                <h2>Temperature</h2>
                
                <%
                    List<Integer> results = (List<Integer>) request.getAttribute("results");

                    for (Integer value : results) {
                %>
                <%= value.toString() + ", " %>
                <%
                    }
                %>
                
            </div>
            
            <div class="section atmosphere">
                
                <h2>Atmosphere</h2>
                
            </div>
            
            <div class="section motion">
                
                <h2>Motion</h2>
                
            </div>
                                    
        </div>
        
        <t:footer>
            <jsp:attribute name="footer" />
        </t:footer>

    </body>
</html>