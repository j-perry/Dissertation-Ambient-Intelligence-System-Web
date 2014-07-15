/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var path = "../jp373/js/app/views/index/Welcome";

define(path, function(welcome) {
    function Welcome() {
        
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
                
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Welcome();
});