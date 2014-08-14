


var path = '../jp373/js/app/views/Overview';

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
                systemHistory.display();
            });
            
            // environment
            require(['../jp373/js/app/views/overview/Environment'], function(environment) {
                // display the temperature (overview)
                environment.displayTemperatureOverview();
                
                // ... others to follow
                
            });
            
        };
        
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Overview();
});