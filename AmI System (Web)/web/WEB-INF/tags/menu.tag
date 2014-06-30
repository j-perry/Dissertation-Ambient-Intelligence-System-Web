<%-- 
    Document   : menu
    Created on : 30-Jun-2014, 11:44:56
    Author     : Jonathan Perry
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="menu" fragment="true" %>

<%-- any content can be specified here e.g.: --%>
<div id="menu">
    <jsp:invoke fragment="menu" />
    <ul>
        <li>AmI System</li>
        <li>Overview</li>
        <li>Temperature</li>
        <li>Atmosphere</li>
        <li>Networked Devices</li>
    </ul>
</div>