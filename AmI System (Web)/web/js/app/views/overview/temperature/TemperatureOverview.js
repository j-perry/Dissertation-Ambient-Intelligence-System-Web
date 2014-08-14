


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
            
            // render chart
            var ctx = document.getElementById("temperatureOverview").getContext("2d");
            var myLineChart = new Chart(ctx).Line(data, {
                bezierCurve: false,
                scaleShowGridLines: false,
                scaleGridLineColor: "rgba(0,0,0, 1)"
            });
    
        };
        
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new TemperatureOverview();
});