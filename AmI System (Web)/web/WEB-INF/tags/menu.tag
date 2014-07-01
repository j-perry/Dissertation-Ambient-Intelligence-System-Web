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
    
    <form action="View" method="get">
        <h3>AmI System</h3>
        <!-- Overview -->
        <button name="type"
                value="overview"
                type="submit"
                class="nav-btn">Overview</button>
        
        <!-- Temperature -->
        <button name="type"
                type="submit"
                value="temperature"
                class="nav-btn">Temperature</button>
        
        <!-- Atmosphere -->
        <button name="type"
                type="submit"
                value="atmosphere"
                class="nav-btn">Atmosphere</button>
        
        <!-- Networked Devices -->
        <button name="type"
                type="submit"
                value="networked_devices"
                class="nav-btn">Networked Devices</button>
    </form>
        
</div>