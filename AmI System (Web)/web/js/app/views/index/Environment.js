/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var path = "../jp373/js/app/views/index/Environment";

define(path, function(environment) {
    function Environment() {
        
        /**
         * 
         */
        this.display = function() {
            var target = "";
            var html = "";
            
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.numberOfAgentsDeployed = function() {
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.numberOfSensorsDeployed = function() {
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.numberOfIdentifiedContexts = function() {
            
        };
        
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Environment();
});