


var path = "../jp373/js/app/views/index/Environment/TemperatureOverview.js";

define(path, function(temperatureOverview) {
    function TemperatureOverview() {
        
        /**
         * 
         */
        this.display = function() {
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/temperature.json";
            
            // get JSON values
            $.getJSON(path, function(data) {
               
                
                
            });
        };
        
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new TemperatureOverview();
});