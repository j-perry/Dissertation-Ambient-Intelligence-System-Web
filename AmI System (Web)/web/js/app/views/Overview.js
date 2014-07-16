/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var path = '../jp373/js/app/views/Overview';

define(path, function(overview) {
    function Overview() {
        
        /**
         * 
         */
        this.tabify = function() {
            $('#hmmm').tabify();
        };
        
    }
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Overview();
});