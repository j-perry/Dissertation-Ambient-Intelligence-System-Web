


var path = "../jp373/js/app/views/index/Environment";

define(path, function(environment) {
    function Environment() {
        
        /**
         * 
         */
        this.displayTemperatureOverview = function() {
            // system history
            require(['../jp373/js/app/views/overview/temperature/TemperatureOverview'], function(temperatureOverview) {
                temperatureOverview.display();
            });
        };
                
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Environment();
});