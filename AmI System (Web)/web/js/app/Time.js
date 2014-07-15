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
            
            if(hour < 10) {
                hour = "0" + hour;
            }
            
            return hour;
        };

        /**
         * 
         * @returns {Integer}
         */
        this.getMinutes = function() {
            d = new Date();
            var mins = d.getMinutes();
            
            if(mins < 10) {
                mins = "0" + mins;
            }
            
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
                return "AM";
            }
            else {
                return "PM";
            }
        };

        /*
         * 
         * @returns {undefined}
         */
        this.day = function() {
            d = new Date();        
            var days = [ "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" ];
            
            // returns "Monday", "Thursday", etc.
            var day = days[d.getDay()];
            
            return day;
        };

        /**
         * 
         * @returns {String}
         */
        this.getFullGMT = function() {
            return this.getHour() + ":" +
                   this.getMinutes() + ":" +
                   this.getSeconds() + " " +
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
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Time();
});