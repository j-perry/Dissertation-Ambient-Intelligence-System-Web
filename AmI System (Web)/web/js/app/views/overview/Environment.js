/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
//var path = "../jp373/js/app/views/overview/Environment";
var path = "http://localhost:8080/AmI_System__Web_/js/app/views/overview/Environment.js";

define(path, function(environment) {
    function Environment() {
        
        /**
         * Displays an overview of the temperature for both agents in the form of a chart graph(?)
         */
        this.displayTemperatureOverview = function() {
//            // system history
            require(['http://localhost:8080/AmI_System__Web_/js/app/views/overview/temperature/TemperatureOverview.js'], function(temperatureOverview) {
////            require(['../jp373/js/app/views/overview/temperature/TemperatureOverview'], function(temperatureOverview) {
                temperatureOverview.display();
            });
        };
        
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Environment();
});