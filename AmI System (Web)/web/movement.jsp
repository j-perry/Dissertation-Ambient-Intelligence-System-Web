<%-- 
    Document   : temperature
    Created on : 13-Aug-2014, 14:40:55
    Author     : Jonathan Perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movement</title>

        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/overview.css" />
        <link rel="stylesheet" href="css/movement.css" />

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
                        <a href="#overview" id="cat-2">Overview</a>
                    </li>

                    <li>
                        <a href="#weekdays" id="cat-3">Monday - Friday</a>
                    </li>

                </ul>

            </div>

            <!-- environment tab -->
            <div id="overview">
                <div class="section">
                    <canvas class="movement-overview" id="movementOverview" width="1100" height="400"></canvas>
                </div>
            </div>

            <!-- environment tab -->
            <div id="weekdays">

                

            </div>


        </div>

        <t:footer>
            <jsp:attribute name="footer" />
        </t:footer>   

    </body>
</html>
