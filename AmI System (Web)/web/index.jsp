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
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/index.css" />
        <title>Ambient Intelligence System</title>
    </head>
    <body id="wrapper">
        <t:menu>
            <jsp:attribute name="menu" />
        </t:menu>
        
        <div id="content-wrapper">
            
            <div id="page-header">
                <h1>Welcome</h1>
            </div>
            
            <div id="status" class="size">
                <p>The time now is <u>18:45:29 PM</u>.</p>
                <p>Tomorrow, we'll get started at <u>9:00 AM</u> and finish at <u>17:30 PM</u> until Friday.</p>
                <p>> Until then, have a look at your progress...</p>
            </div>
            
            <div id="history">
                <div id="sub-heading" class="size">
                    <h2>System history</h2>
                </div>
                
                <div id="content" class="size">
                    <p><u>49 hours</u> and <u>52 minutes</u> have been accumulated.</p>
                    <p>The system has identified <u>x3 employees</u> located in <u>x1 room</u>.</p>
                </div>               
            </div>
            
            <div id="context">
                <div id="sub-heading" class="size">
                    <h2>The environment status...</h2>
                </div>
                
                <div id="content" class="size">
                    <p>There are currently <u>x2 agents</u> and <u>x8 sensors</u> setup.</p>
                    <p>So far <u>x4 context</u> types are available for analysis.</p>
                </div>
            </div>
            
            <t:footer>
                <jsp:attribute name="footer" />
            </t:footer>
            
        </div>
        
    </body>
</html>