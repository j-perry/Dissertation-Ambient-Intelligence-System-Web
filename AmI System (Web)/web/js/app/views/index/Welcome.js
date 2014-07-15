/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var path = "../jp373/js/app/views/index/Welcome";

define(path, function(welcome) {
    function Welcome() {
               
        /**
         * 
         * @returns {undefined}
         */
        this.checkServiceStatus = function() {
            // check if the current week day is between Monday and Friday
            require(['../jp373/js/app/Time'], function(time) {
               
                var day = time.day();
                var hour = time.getHour();
                var minute = time.getMinutes();
                var time = parseFloat(hour + "." + minute);
                
                console.log(time);
                
                if(day !== "Saturday" || day !== "Sunday") {
                    // check the current time is between 9am and 17:30pm
                    var status = "";                                 
                    var target = 'content-wrapper';
                    
                    if((time >= 9.30) && (time <= 17.30)) {                        
                        // display a particular banner/colour
                        status = "<div id='status' class='size'>" +
                                    "<h1>Welcome</h1>" +
                                    "<p>The time now is <u><span id='clock-time'></span></u>.</p>" +
                                    "<p>Tomorrow, we'll get started at <u>9:00 AM</u> and finish at <u>17:30 PM</u> until Friday.</p>" +
                                    "<p> Until then, have a look at your progress...</p>" +
                                 "</div>";
                        
                        document.getElementById(target).innerHTML = status;
                        this.updateTime();
                    }
                    else {                        
                        // display an out of hours banner
                        status = "<div id='status' class='size'>" +
                                    "<h1>Welcome</h1>" +
                                    "<p>The time now is <u><span id='clock-time'></span></u>.</p>" +
                                    "<p>Tomorrow, we'll get started at <u>9:00 AM</u> and finish at <u>17:30 PM</u> until Friday.</p>" +
                                    "<p> Until then, have a look at your progress...</p>" +
                                 "</div>";
                        
                        document.getElementById(target).innerHTML = status;
                        this.updateTime();
                    }
                }
            });
            
            this.updateTime();
        };
        
        /**
         * Displays the current time (hour:minutes:seconds)
         * @returns {undefined}
         */
        this.updateTime = function() {
            // display the clock (time)
            setInterval(function() {
                require(['../jp373/js/app/Time'], function(time) {
                    document.getElementById('clock-time').innerHTML = time.getFullGMT();
                });
            }, 0);
        };
        
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Welcome();
});