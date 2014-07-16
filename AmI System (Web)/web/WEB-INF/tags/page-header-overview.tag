<%-- 
    Document   : page-header
    Created on : 02-Jul-2014, 10:11:30
    Author     : Jonathan Perry
--%>

<%@tag description="Overview header tag" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="overview-header" fragment="true" %>

<%-- any content can be specified here e.g.: --%>
<div id="page-header">

    <h1><%= request.getAttribute("type").toString()%></h1>

</div>