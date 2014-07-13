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
                <h1>The time now is <u>18:45PM</u>. We'll get started at <u>9:00AM</u> and finish at <u>17:30PM</u>, tomorrow until Friday.</h1>
            </div>
            
            <div id="history" class="size">
                <h1>History</h1>
                <h1>So far <u>49 hours</u> and <u>52 minutes</u> has been accumulated.</h1>
                <h1>There are <u>x2 agents</u> and <u>x8 sensors</u> currently setup.</h1>
                <h1>The system has identified <u>x3 employers</u> located in <u>x1 room</u>.</h1>
            </div>
            
        </div>
        
    </body>
</html>