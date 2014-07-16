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
            
            <t:footer>
                <jsp:attribute name="footer" />
            </t:footer>
            
        </div>
        
    </body>
</html>