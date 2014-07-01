<%-- 
    Document   : temperature
    Created on : 30-Jun-2014, 11:06:16
    Author     : Jonathan Perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<% String record = (String) request.getAttribute("test"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- insert template ? -->
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body id="wrapper">
        <t:menu>
            <jsp:attribute name="menu" />
        </t:menu>

        <h1><%= record %></h1>      
        
    </body>
</html>