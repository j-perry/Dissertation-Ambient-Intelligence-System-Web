/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
var path = '../jp373/js/app/Time';
//var path = 'http://localhost:8080/AmI_System__Web_/js/app/Time.js';

define(path, function(time) {
    function Time() {

        var d;
        
        /**
         * Gets the current hour
         * @returns {Integer}
         */
        this.getHour = function() {
            d = new Date();
            var hour = this.format(d.getHours() );
            
            return hour;
        };

        /**
         * Gets the current minute in the hour
         * @returns {Integer}
         */
        this.getMinutes = function() {
            d = new Date();
            var mins = this.format(d.getMinutes() );
            
            return mins;
        };

        /**
         * Gets the current second in the minute
         * @returns {Integer}
         */
        this.getSeconds = function() {
            d = new Date();
            var secs = this.format(d.getSeconds() );
            
            return secs;
        };

        /**
         * Returns the day period (AM/PM)
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
         * Returns the current day in the week
         * @returns {String}
         */
        this.day = function() {
            d = new Date();        
            var days = [ "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" ];
            
            // returns "Monday", "Thursday", etc.
            var day = days[d.getDay()];
            
            return day;
        };

        /**
         * Returns the full clock time
         * @returns {String}
         */
        this.getFullGMT = function() {
            return this.getHour() + ":" +
                   this.getMinutes() + ":" +
                   this.getSeconds() + " " +
                   this.dayPeriod();
        };

        /**
         * Formats HH/mm/ss
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