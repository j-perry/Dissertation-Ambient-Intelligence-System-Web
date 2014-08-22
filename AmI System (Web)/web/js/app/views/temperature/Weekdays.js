/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
//var path = '../jp373/js/app/views/temperature/Weekdays.js';
var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/temperature/Weekdays.js';

define(path, function(weekdays) {
    function Weekdays() {
        
        /**
         * Monday's data
         */
        this.displayMonday = function() {
            
        };
        
        /**
         * Tuesdays's data
         */
        this.displayTuesday = function() {
            
        };
        
        /**
         * Wednesday's data
         */
        this.displayWednesday = function() {
            
        };
        
        /**
         * Thursday's data
         */
        this.displayThursday = function() {
            
        };
        
        /**
         * Fridays's data
         */
        this.displayFriday = function() {
            
        };
        
        
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Weekdays();
});