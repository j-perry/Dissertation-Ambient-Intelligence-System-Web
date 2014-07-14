<%-- 
    Document   : networked-devices
    Created on : 30-Jun-2014, 11:08:20
    Author     : Jonathan Perry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Motion</title>
        
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/context.css" />
                
        <script type="text/javascript" data-main="js/app.js" src="js/jquery/require.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        
    </head>
    
    <body id="wrapper">
        <t:menu>
            <jsp:attribute name="menu" />
        </t:menu>
        
        <div id="content-wrapper">
            
            <t:page-header>
                <jsp:attribute name="header" />
            </t:page-header>
            
        </div>
        
    </body>
</html>