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
    
    <div id="app-title">
        <span><a href="http://tomcat.inf.susx.ac.uk:8080/jp373/">AmI System</a></span>       
    </div>
    
    <div id="nav">        
        <form action="View" method="get">
            
            <!-- Overview -->
            <button name="type"
                    value="overview"
                    type="submit"
                    class="nav-btn">Overview</button>
                    
            <!-- Skills -->
            <button name="type"
                    value="temperature"
                    type="submit"
                    class="nav-btn">Temperature</button>

        </form>
    </div>

</div>