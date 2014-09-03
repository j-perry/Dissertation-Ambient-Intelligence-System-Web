/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
var path = '../jp373/js/app/views/Overview';
//var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/Overview.js';

define(path, function(overview) {
    function Overview() {
        
        /**
         * Initialise tabs in view
         */
        this.tabify = function() {
            $('#tabs').tabify();
        };
        
        /**
         * Display the overview of all sensor data gathered
         */
        this.display = function() {
            
            // system history
            require(['../jp373/js/app/views/overview/SystemHistory'], function(systemHistory) {
//            require(['http://localhost:8080/AmI_System__Web_/js/app/views/overview/SystemHistory.js'], function(systemHistory) {
                systemHistory.display();
            });
            
            // environment
            require(['../jp373/js/app/views/overview/Environment'], function(environment) {
//            require(['http://localhost:8080/AmI_System__Web_/js/app/views/overview/Environment.js'], function(environment) {
                environment.displayTemperatureOverview();
                environment.displayMovementOverview();
            });
            
        };
        
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Overview();
});