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
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/chart-js/Chart.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
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
                
                <!-- <div id="test"></div> -->
                
                <canvas id="myChart" width="800" height="400"></canvas>
                
            </div>
            
            <div class="section atmosphere">
                
                <h2>Atmosphere</h2>
                
                <canvas id="myChart2" width="800" height="400"></canvas>
                
            </div>
            
            <div class="section motion">
                
                <h2>Motion</h2>
                
                <canvas id="myChart3" width="800" height="400"></canvas>
                
            </div>
                                    
        </div>
        
        <t:footer>
            <jsp:attribute name="footer" />
        </t:footer>

    </body>
</html>