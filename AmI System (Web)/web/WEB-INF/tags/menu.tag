<%-- 
    Document   : menu
    Created on : 30-Jun-2014, 11:44:56
    Author     : Jonathan Perry
--%>

<%@tag description="Menu to be implement in each JSP created." pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="menu" fragment="true" %>

<%-- Menu structure --%>
<div id="menu">
    <jsp:invoke fragment="menu" />
    
    <form action="navigation" method="post">
        <h3>AmI System</h3>
        <!-- Overview -->
        <button name="overview"
                type="submit"
                class="nav-btn">Overview</button>
        
        <!-- Temperature -->
        <button name="temperature"
                type="submit"
                value="Temperature"
                class="nav-btn">Temperature</button>
        
        <!-- Atmosphere -->
        <button name="atmosphere"
                type="submit"
                class="nav-btn">Atmosphere</button>
        
        <!-- Networked Devices -->
        <button name="networked_devices"
                type="submit"
                class="nav-btn">Networked Devices</button>
    </form>
    
    <!--
    <ul>
        <li>AmI System</li>
        <li><a href="overview">Overview</a></li>
        <li><a href="temperature">Temperature</a></li>
        <li><a href="atmosphere">Atmosphere</a></li>
        <li><a href="networked-devices">Networked Devices</a></li>
    </ul>
    -->
    
</div>