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
        <title>Temperature</title>

        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/temperature.css" />

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
                        <a href="#overview" id="cat-overview">Overview</a>
                    </li>

                    <li>
                        <a href="#weekdays" id="cat-weekdays">Monday - Friday</a>
                    </li>

                </ul>

            </div>

            <!-- environment tab -->
            <div id="overview">
                <div class="section">
                    <canvas class="temperature-overview" id="temperatureOverview" width="1100" height="400"></canvas>
                </div>
            </div>

            <!-- environment tab -->
            <div id="weekdays">

                <div class="section monday">

                    <h2>Monday</h2>

                    <canvas id="temperatureMonday" width="1100" height="400"></canvas>


                </div>

                <div class="section tuesday">

                    <h2>Tuesday</h2>

                    <canvas id="temperatureTuesday" width="1100" height="400"></canvas>


                </div>

                <div class="section wednesday">

                    <h2>Wednesday</h2>

                    <canvas id="temperatureWednesday" width="1100" height="400"></canvas>


                </div>

                <div class="section thursday">

                    <h2>Thursday</h2>

                    <canvas id="temperatureThursday" width="1100" height="400"></canvas>


                </div>

                <div class="section friday">

                    <h2>Friday</h2>

                    <canvas id="temperatureFriday" width="1100" height="400"></canvas>

                </div>

            </div>


        </div>

        <t:footer>
            <jsp:attribute name="footer" />
        </t:footer>   

    </body>
</html>
