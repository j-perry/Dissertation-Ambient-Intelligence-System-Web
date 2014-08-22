/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/movement/MovementOverview.js';

define(path, function(movementOverview) {
    function MovementOverview() {
        
        /**
         * Display an overview of movement data collected from both agents
         */
        this.display = function() {
            // temporary
//            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/movement_overview.json";
            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/movement_overview.json";
            
            // get JSON values
            $.getJSON(path, function(data) {
                
                var hostname_one = "Agent 1";
                var hostname_two = "Agent 2"; 
                
                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////
                
                
                // monday - friday
                var hostname_one_monday = data.agent_one["monday"][0];
                var hostname_one_tuesday = data.agent_one["tuesday"][0];
                var hostname_one_wednesday = data.agent_one["wednesday"][0];
                var hostname_one_thursday = data.agent_one["thursday"][0];
                var hostname_one_friday = data.agent_one["friday"][0];


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////
                
                
                // monday - friday
                var hostname_two_monday = data.agent_two["monday"][0];
                var hostname_two_tuesday = data.agent_two["tuesday"][0];
                var hostname_two_wednesday = data.agent_two["wednesday"][0];
                var hostname_two_thursday = data.agent_two["thursday"][0];
                var hostname_two_friday = data.agent_two["friday"][0];
                

                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                var hours = new Array();
                hours.push("Monday");
                hours.push("Tuesday");
                hours.push("Wednesday");
                hours.push("Thursday");
                hours.push("Friday");
                
                
                
            });
            
        };
        
    }
});