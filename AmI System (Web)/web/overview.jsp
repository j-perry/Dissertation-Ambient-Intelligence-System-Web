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
        <link rel="stylesheet" href="css/overview.css" />
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="js/chart-js/Chart.js"></script>
        <script src="js/jquery/tabify/jquery.tabify.js"></script>
        <script src="js/jquery/tabify/jquery.tabify.source.js"></script>
        
        <script type="text/javascript" data-main="js/app.js" src="js/jquery/require.js"></script>
    </head>
    
    <body id="wrapper">
        <t:menu>
            <jsp:attribute name="menu" />
        </t:menu>
        
        <div id="content-wrapper">
            
            <t:page-header>
                <jsp:attribute name="header" />
            </t:page-header>
            
            <div id="tabs-menu">
                
                <ul id="tabs">
                    <li class="active">
                        <!-- contains context data -->
                        <a href="#environment" id="cat-2">Environment</a>
                    </li>
                    
                    <li>
                        <a href="#history" id="cat-3">History</a>
                    </li>
                </ul>
                
            </div>
                        
            <!-- environment tab -->
            <div id="environment">

                <div class="section temperature">

                    <h2><a href="http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=temperature">Room Temperature</a></h2>

                    <canvas id="myChart" width="1100" height="400"></canvas>

                </div>

                <div class="section atmosphere">

                    <h2><a href="http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=atmosphere">Room Volume</a></h2>

                    <canvas id="myChart2" width="1100" height="400"></canvas>

                </div>

                <div class="section motion">

                    <h2><a href="http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=motion">Movement</a></h2>

                    <canvas id="myChart3" width="1100" height="400"></canvas>

                </div>

            </div>

            <!-- history tab -->
            <div id="history">

                <div id="sub-heading" class="size">
                    <p><u><span id="hours-accumulated"></span>49 hours</u> and <u><span id="minutes-accumulated"></span>52 minutes</u> have been accumulated.</p>
                    <p>The system has identified <u><span id="number-employees"></span>x3 employees</u> located in <u><span id="number-rooms"></span>x1 room</u>.</p>
                    
                    <p>There are currently <u><span id="number-agents"></span>x2 agents</u> and <u><span id="number-sensors"></span>x8 sensors</u> setup.</p>
                    <p>So far <u><span id="number-contexts"></span>x4 context</u> types are available for analysis.</p>
                </div>
            
            </div>
            
            <t:footer>
                <jsp:attribute name="footer" />
            </t:footer>   
            
        </div>

    </body>
</html>