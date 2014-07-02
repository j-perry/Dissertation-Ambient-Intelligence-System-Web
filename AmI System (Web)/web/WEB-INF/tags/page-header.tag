<%-- 
    Document   : page-header
    Created on : 02-Jul-2014, 10:11:30
    Author     : Jonathan Perry
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="header" fragment="true" %>

<%-- any content can be specified here e.g.: --%>
<div id="page-header">

    <h1><%= request.getAttribute("type").toString()%></h1>

</div>