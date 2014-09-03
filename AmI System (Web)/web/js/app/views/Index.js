/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
var path = '../jp373/js/app/views/Index';
//var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/Index.js';

define(path, function(index) {
    function Index() {
        
        /**
         * Sets up all the methods in this class (is this good design practice?!)
         * @returns {undefined}
         */
        this.setupAll = function() {
            
            // welcome
            require(['../jp373/js/app/views/index/Welcome'], function(welcome) {
//            require(['http://localhost:8080/AmI_System__Web_/js/app/views/index/Welcome.js'], function(welcome) {
                welcome.checkServiceStatus();
            });
        };
             
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Index();    
});