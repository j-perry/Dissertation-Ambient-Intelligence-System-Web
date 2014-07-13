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
                <h1>The time now is <u>18:45PM</u>.</h1>
                <h1>Tomorrow, we'll get started at <u>9:00AM</u> and finish at <u>17:30PM</u> until Friday.</h1>
                <h1>> Have a look at your progress...</h1>
            </div>
            
            <div id="history">
                <div id="sub-heading" class="size">
                    <h1>This is the history so far...</h1>
                </div>
                
                <div id="content" class="size">
                    <h1><u>49 hours</u> and <u>52 minutes</u> have been accumulated.</h1>
                    <h1>The system has identified <u>x3 employees</u> located in <u>x1 room</u>.</h1>
                </div>               
            </div>
            
            <div id="context">
                <div id="sub-heading" class="size">
                    <h1>The environment status...</h1>
                </div>
                
                <div id="content" class="size">
                    <h1>There are currently <u>x2 agents</u> and <u>x8 sensors</u> setup.</h1>
                    <h1>So far <u>x4 context</u> types are available for analysis.</h1>
                </div>
            </div>
            
            <t:footer>
                <jsp:attribute name="footer" />
            </t:footer>
            
        </div>
        
    </body>
</html>