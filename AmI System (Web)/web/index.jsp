<%-- 
    Document   : index
    Created on : 02-Jun-2014, 15:28:52
    Author     : Jonathan Perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript" data-main="js/app.js" src="js/jquery/require.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/index.css" />
        <title>Ambient Intelligence System</title>
    </head>
    
    <body id="wrapper">
        <t:menu>
            <jsp:attribute name="menu" />
        </t:menu>
        
        <div id="content-wrapper">
            
            
            <!--            
            <div id="history">
                <div id="sub-heading" class="size">
                    <h2>System history</h2>
                </div>
                
                <div id="content" class="size">
                    <p><u><span id="hours-accumulated"></span>49 hours</u> and <u><span id="minutes-accumulated"></span>52 minutes</u> have been accumulated.</p>
                    <p>The system has identified <u><span id="number-employees"></span>x3 employees</u> located in <u><span id="number-rooms"></span>x1 room</u>.</p>
                </div>               
            </div>
            -->
            
            <div id="context">
                <div id="sub-heading" class="size">
                    <h2>The environment status...</h2>
                </div>
                
                <div id="content" class="size">
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