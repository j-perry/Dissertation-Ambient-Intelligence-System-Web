/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
//var path = '../jp373/js/app/views/movement/Weekdays.js';
var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/movement/Weekdays.js';

define(path, function(movement) {
    function Weekdays() {
        
        /**
         * Displays Monday's data
         */
        this.displayMonday = function() {
            
        };
        
        /**
         * Displays Tuesday's data
         */
        this.displayTuesday = function() {
            
        };
        
        /**
         * Displays Wednesday's data
         */
        this.displayWednesday = function() {
            
        };
        
        /**
         * Displays Thursdays's data
         */
        this.displayThursday = function() {
            
        };
        
        /**
         * Displays Friday's data
         */
        this.displayFriday = function() {
            
        };
        
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Weekdays();
});