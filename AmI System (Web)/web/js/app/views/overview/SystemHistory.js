


var path = "../jp373/js/app/views/overview/SystemHistory";

define(path, function(systemHistory) {
    function SystemHistory() {
        
        /**
         * 
         */
        this.display = function() {            
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/overview.json";
            
            // get JSON values
            $.getJSON(path, function(data) {                
                document.getElementById("hours-accumulated").innerHTML = data.hours + " hours";
                document.getElementById("minutes-accumulated").innerHTML = data.minutes + " minutes";
                document.getElementById("number-agents").innerHTML = data.hostname + " devices";
                
                if(data.noSensors === 1) {
                    document.getElementById("number-sensors").innerHTML = data.noSensors + " sensor";
                } else {
                    document.getElementById("number-sensors").innerHTML = data.noSensors + " sensors";
                }
                
                
            });
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.hoursAccumulated = function() {
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.minutesAccumulated = function() {
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.numberOfEmployeesIdentified = function() {
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.numberOfRoomsIdentified = function() {
            
        };
        
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new SystemHistory();
});