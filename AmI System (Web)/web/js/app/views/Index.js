/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var path = '../jp373/js/app/views/Index';

define(path, function(index) {
    function Index() {
        
        /**
         * Sets up all the methods in this class (is this good design practice?!)
         * @returns {undefined}
         */
        this.setupAll = function() {
            
            // welcome
            require(['../jp373/js/app/views/index/Welcome'], function(welcome) {
                welcome.updateTime();
            });
            
            // system history
            require(['../jp373/js/app/views/index/SystemHistory'], function(systemHistory) {
                systemHistory.hoursAccumulated();
            });
            
            // environment
            require(['../jp373/js/app/views/index/Environment'], function(environment) {
                // TODO
            });
            
        };
        
        /**
         * Displays the current time (hour:minutes:seconds)
         * @returns {undefined}
         */
        this.updateTime = function() {
            // display the clock (time)
            setInterval(function() {
                require(['../jp373/js/app/Time'], function(time) {
                    document.getElementById("clock-time").innerHTML = time.getFullGMT();
                });
            }, 0);
        };
     
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Index();    
});