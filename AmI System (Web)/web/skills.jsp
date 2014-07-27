<%-- 
    Document   : skills
    Created on : 27-Jul-2014, 20:23:18
    Author     : Jonathan Perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Skills</title>
        
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
        
    </body>
</html>
