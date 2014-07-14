/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var path = '../jp373/js/app/views/Index';

define(path, function(index) {
    function Index() {
                
        /**
         * 
         * @returns {undefined}
         */
        this.setupAll = function() {
            // display the clock (time)
            setInterval(function() {
                updateTime();
            }, 0);
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.updateTime = function() {
            require(['../jp373/js/app/Time'], function(time) {
                document.getElementById("clock-time").innerHTML = time.getFullGMT();
            });
        };
                
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Index();
 });