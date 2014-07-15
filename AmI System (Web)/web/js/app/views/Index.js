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
                welcome.checkServiceStatus();
            });
            
            // system history
            require(['../jp373/js/app/views/index/SystemHistory'], function(systemHistory) {
                systemHistory.display();
            });
            
            // environment
            require(['../jp373/js/app/views/index/Environment'], function(environment) {
                // TODO
            });
            
        };
             
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Index();    
});