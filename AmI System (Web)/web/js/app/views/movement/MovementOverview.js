/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
var path = '../jp373/js/app/views/movement/MovementOverview';
//var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/movement/MovementOverview.js';

define(path, function(movementOverview) {
    function MovementOverview() {
        
        // Measured in cm. This is the max distance the ultra sonic transceiver can reach
        var LIMIT = 150;
        
        /**
         * Display an overview of movement data collected from both agents
         */
        this.display = function() {
            // temporary
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/movement_overview.json";
//            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/movement_overview.json";
            
            // get JSON values
            $.getJSON(path, function(data) {
                
                var hostname_one = "Agent 1";
                var hostname_two = "Agent 2";
                                
                
                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////
                
                var hostname_one_saturday;
                var hostname_one_sunday;
                var hostname_one_monday;
                var hostname_one_tuesday;
                var hostname_one_wednesday;
                var hostname_one_thursday;
                var hostname_one_friday;
                
                // saturday - friday
                if(data.agent_one["saturday"][0] > LIMIT) {
                    hostname_one_saturday = LIMIT;
                } else {
                    hostname_one_saturday = data.agent_one["saturday"][0];
                }
                
                if(data.agent_one["sunday"][0] > LIMIT) {
                    hostname_one_sunday = LIMIT;
                } else {
                    hostname_one_sunday = data.agent_one["sunday"][0];
                }
                
                if(data.agent_one["monday"][0] > LIMIT) {
                    hostname_one_monday = LIMIT;
                } else {
                    hostname_one_monday = data.agent_one["monday"][0];
                }
                
                if(data.agent_one["tuesday"][0] > LIMIT) {
                    hostname_one_tuesday = LIMIT;
                } else {
                    hostname_one_tuesday = data.agent_one["tuesday"][0];
                }
                
                if(data.agent_one["wednesday"][0] > LIMIT) {
                    hostname_one_wednesday = LIMIT;
                } else {
                    hostname_one_wednesday = data.agent_one["wednesday"][0];
                }
                
                if(data.agent_one["thursday"][0] > LIMIT) {
                    hostname_one_thursday = LIMIT;
                } else {
                    hostname_one_thursday = data.agent_one["thursday"][0];
                }
                
                if(data.agent_one["friday"][0] > LIMIT) {
                    hostname_one_friday = LIMIT;
                } else {
                    hostname_one_friday = data.agent_one["friday"][0];
                }
                
                
                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////
                
                
                // saturday - friday
                var hostname_two_saturday;
                var hostname_two_sunday;
                var hostname_two_monday;
                var hostname_two_tuesday;
                var hostname_two_wednesday;
                var hostname_two_thursday;
                var hostname_two_friday;
                
                // saturday - friday
                if(data.agent_two["saturday"][0] > LIMIT) {
                    hostname_two_saturday = LIMIT;
                } else {
                    hostname_two_saturday = data.agent_two["saturday"][0];
                    console.log("hostname_two_saturday: " + hostname_two_saturday);
                }
                
                if(data.agent_two["sunday"][0] > LIMIT) {
                    hostname_two_sunday = LIMIT;
                } else {
                    hostname_two_sunday = data.agent_two["sunday"][0];
                }
                
                if(data.agent_two["monday"][0] > LIMIT) {
                    hostname_two_monday = LIMIT;
                } else {
                    hostname_two_monday = data.agent_two["monday"][0];
                }
                
                if(data.agent_two["tuesday"][0] > LIMIT) {
                    hostname_two_tuesday = LIMIT;
                } else {
                    hostname_two_tuesday = data.agent_two["tuesday"][0];
                }
                
                if(data.agent_two["wednesday"][0] > LIMIT) {
                    hostname_two_wednesday = LIMIT;
                } else {
                    hostname_two_wednesday = data.agent_two["wednesday"][0];
                }
                
                if(data.agent_two["thursday"][0] > LIMIT) {
                    hostname_two_thursday = LIMIT;
                } else {
                    hostname_two_thursday = data.agent_two["thursday"][0];
                }
                
                if(data.agent_two["friday"][0] > LIMIT) {
                    hostname_two_friday = LIMIT;
                } else {
                    hostname_two_friday = data.agent_two["friday"][0];
                }
                

                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                var hours = new Array();
                hours.push("Saturday");
                hours.push("Sunday");
                hours.push("Monday");
                hours.push("Tuesday");
                hours.push("Wednesday");
                hours.push("Thursday");
                hours.push("Friday");
                
                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6] ],
                    datasets: [
                        {
                            label: hostname_one,
                            fillColor: "rgba(52, 152, 219,1)",
                            strokeColor: "rgba(52, 152, 219,1)",
                            pointColor: "rgba(52, 152, 219,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [hostname_one_saturday, 
                                   hostname_one_sunday, 
                                   hostname_one_monday, 
                                   hostname_one_tuesday, 
                                   hostname_one_wednesday, 
                                   hostname_one_thursday,
                                   hostname_one_friday] // 9, 10, 11am; 12, 1, 2, 3, 4pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.9)",
                            strokeColor: "rgba(242,38,19, 0.9)",
                            pointColor: "rgba(242,38,19,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [hostname_two_saturday, 
                                   hostname_two_sunday, 
                                   hostname_two_monday, 
                                   hostname_two_tuesday, 
                                   hostname_two_wednesday, 
                                   hostname_two_thursday,
                                   hostname_two_friday] // 9, 10, 11am; 12, 1, 2, 3, 4pm
                        }
                    ]
                };

                // render chart
                var ctx = document.getElementById("movementOverview").getContext("2d");
                var myLineChart = new Chart(ctx).Line(data, {
                    bezierCurve: false,
                    scaleShowGridLines: false,
                    scaleGridLineColor: "rgba(0,0,0, 1)"
                });
                
            });
            
        };
        
    };
    
    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new MovementOverview();
});