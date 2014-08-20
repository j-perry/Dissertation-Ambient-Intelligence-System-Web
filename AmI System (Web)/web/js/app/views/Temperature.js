/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
//var path = '../jp373/js/app/views/Temperature';
var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/Temperature.js';

define(path, function(temperature) {
    function Temperature() {
        
        /**
         * Initialise tabs in view
         */
        this.tabify = function() {
            $('#tabs').tabify();
        };
        
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Temperature();
});