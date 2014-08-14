


var path = "../jp373/js/app/views/overview/SystemHistory";

define(path, function(systemHistory) {
    function SystemHistory() {
        
        /**
         * Displays the system history
         */
        this.display = function() {            
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/overview.json";
            
            // get JSON values
            $.getJSON(path, function(data) {
                
                var hours = data.hours;
                var minutes = 0;
                var temp_minutes = data.minutes;
                
                // minutes
                while(temp_minutes > 60) {
                    hours++;
                    minutes += (60 - temp_minutes);
                    temp_minutes -= 60;
                }
                
                document.getElementById("minutes-accumulated").innerHTML = temp_minutes + " minutes";
                
                // hours
                if(hours === 1) {
                    document.getElementById("hours-accumulated").innerHTML = hours + " hour";
                } else {
                    document.getElementById("hours-accumulated").innerHTML = hours + " hours";
                }
                
                // no. host names
                if(data.noHostnames === 0) {
                    document.getElementById("number-agents").innerHTML = data.noHostnames + " device";
                } else {
                    document.getElementById("number-agents").innerHTML = data.noHostnames + " devices";
                }
                
                // no. sensors
                if(data.noSensors === 1) {
                    document.getElementById("number-sensors").innerHTML = data.noSensors + " sensor";
                } else {
                    document.getElementById("number-sensors").innerHTML = data.noSensors + " sensors";
                }
                
                // no of individual sensors (p/ agent)
                
            });
            
        };
        
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new SystemHistory();
});