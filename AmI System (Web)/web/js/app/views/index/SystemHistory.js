/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var path = "../jp373/js/app/views/index/SystemHistory";

define(path, function(systemHistory) {
    function SystemHistory() {
        
        /**
         * 
         */
        this.display = function() {
            var target = 'content-wrapper';            
            var html = "<div id='history'>" +
                           "<div id='sub-heading' class='size'>" +
                               "<h2>System history</h2>" +
                           "</div>" +
                           
                           "<div id='content' class='size'>" +
                               "<p><u><span id='hours-accumulated'></span>49 hours</u> and <u><span id='minutes-accumulated'></span>52 minutes</u> have been accumulated.</p>" +
                               "<p>The system has identified <u><span id='number-employees'></span>x3 employees</u> located in <u><span id='number-rooms'></span>x1 room</u>.</p>" +
                           "</div>" +
                       "</div>";
            
            document.getElementById(target).innerHTML = html;
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.hoursAccumulated = function() {
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.minutesAccumulated = function() {
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.numberOfEmployeesIdentified = function() {
            
        };
        
        /**
         * 
         * @returns {undefined}
         */
        this.numberOfRoomsIdentified = function() {
            
        };
        
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new SystemHistory();
});