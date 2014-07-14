/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var path = '../jp373/js/app/Time';

define(path, function(time) {
    function Time() {

        var d;
        
        /**
         * 
         * @returns {Integer}
         */
        this.getHour = function() {
            d = new Date();
            var hour = d.getHours();
            return hour;
        };

        /**
         * 
         * @returns {Integer}
         */
        this.getMinutes = function() {
            d = new Date();
            var mins = d.getMinutes();
            return mins;
        };

        /**
         * 
         * @returns {Integer}
         */
        this.getSeconds = function() {
            d = new Date();
            var secs = d.getSeconds();
            
            if(secs < 10) {
                secs = "0" + secs;
            }
            
            return secs;
        };

        /**
         * 
         * @returns {String}
         */
        this.dayPeriod = function() {
            d = new Date();

            if (d.getHours() < 12) {
                return " AM";
            }
            else {
                return " PM";
            }
        };

        /**
         * 
         * @returns {String}
         */
        this.getFullGMT = function() {
            return this.getHour() + ":" +
                   this.getMinutes() + ":" +
                   this.getSeconds() +
                   this.dayPeriod();
        };

        /**
         * 
         * @param {type} i
         * @returns {String}
         */
        this.format = function(i) {
            if (i < 10) {
                return "0" + i;
            }
            else {
                return i;
            }
        };        
    }
    
    return new Time();
});