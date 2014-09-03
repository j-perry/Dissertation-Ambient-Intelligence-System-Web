/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
var path = '../jp373/js/app/views/movement/Weekdays';
//var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/movement/Weekdays.js';

define(path, function(movementWeekdays) {
    function Weekdays() {

        var hostname_one = "Agent 1";
        var hostname_two = "Agent 2";

        // Measured in cm. This is the max distance the ultra sonic transceiver can reach
        var LIMIT = 150;

        /**
         * Displays Saturday's data
         */
        this.displaySaturday = function() {
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/movement_saturday.json";
//            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/movement_saturday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////

                var hostname_one_nine;
                var hostname_one_ten;
                var hostname_one_eleven;
                var hostname_one_twelve;
                var hostname_one_thirteen;
                var hostname_one_forteen;
                var hostname_one_fifteen;
                var hostname_one_sixteen;

                if (data.agent_one["nine"][0] > LIMIT) {
                    hostname_one_nine = LIMIT;
                } else {
                    hostname_one_nine = data.agent_one["nine"][0];
                }

                if (data.agent_one["ten"][0] > LIMIT) {
                    hostname_one_ten = LIMIT;
                } else {
                    hostname_one_ten = data.agent_one["ten"][0];
                }

                if (data.agent_one["eleven"][0] > LIMIT) {
                    hostname_one_eleven = LIMIT;
                } else {
                    hostname_one_eleven = data.agent_one["eleven"][0];
                }

                if (data.agent_one["twelve"][0] > LIMIT) {
                    hostname_one_twelve = LIMIT;
                } else {
                    hostname_one_twelve = data.agent_one["twelve"][0];
                }

                if (data.agent_one["thirteen"][0] > LIMIT) {
                    hostname_one_thirteen = LIMIT;
                } else {
                    hostname_one_thirteen = data.agent_one["thirteen"][0];
                }

                if (data.agent_one["forteen"][0] > LIMIT) {
                    hostname_one_forteen = LIMIT;
                } else {
                    hostname_one_forteen = data.agent_one["forteen"][0];
                }

                if (data.agent_one["fifteen"][0] > LIMIT) {
                    hostname_one_fifteen = LIMIT;
                } else {
                    hostname_one_fifteen = data.agent_one["fifteen"][0];
                }

                if (data.agent_one["sixteen"][0] > LIMIT) {
                    hostname_one_sixteen = LIMIT;
                } else {
                    hostname_one_sixteen = data.agent_one["sixteen"][0];
                }


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine;
                var hostname_two_ten;
                var hostname_two_eleven;
                var hostname_two_twelve;
                var hostname_two_thirteen;
                var hostname_two_forteen;
                var hostname_two_fifteen;
                var hostname_two_sixteen;



                if (data.agent_two["nine"][0] > LIMIT) {
                    hostname_two_nine = LIMIT;
                } else {
                    hostname_two_nine = data.agent_two["nine"][0];
                }

                if (data.agent_two["ten"][0] > LIMIT) {
                    hostname_two_ten = LIMIT;
                } else {
                    hostname_two_ten = data.agent_two["ten"][0];
                }

                if (data.agent_two["eleven"][0] > LIMIT) {
                    hostname_two_eleven = LIMIT;
                } else {
                    hostname_two_eleven = data.agent_two["eleven"][0];
                }

                if (data.agent_two["twelve"][0] > LIMIT) {
                    hostname_two_twelve = LIMIT;
                } else {
                    hostname_two_twelve = data.agent_two["twelve"][0];
                }

                if (data.agent_two["thirteen"][0] > LIMIT) {
                    hostname_two_thirteen = LIMIT;
                } else {
                    hostname_two_thirteen = data.agent_two["thirteen"][0];
                }

                if (data.agent_two["forteen"][0] > LIMIT) {
                    hostname_two_forteen = LIMIT;
                } else {
                    hostname_two_forteen = data.agent_two["forteen"][0];
                }

                if (data.agent_two["fifteen"][0] > LIMIT) {
                    hostname_two_fifteen = LIMIT;
                } else {
                    hostname_two_fifteen = data.agent_two["fifteen"][0];
                }

                if (data.agent_two["sixteen"][0] > LIMIT) {
                    hostname_two_sixteen = LIMIT;
                } else {
                    hostname_two_sixteen = data.agent_two["sixteen"][0];
                }


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9am"); // [0]
                hours.push("10am"); // [1]
                hours.push("11am"); // [2]
                hours.push("12pm"); // [3]
                hours.push("1pm"); // [4]
                hours.push("2pm"); // [5]
                hours.push("3pm"); // [6]
                hours.push("4pm"); // [7]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7]],
                    datasets: [
                        {
                            label: hostname_one,
                            fillColor: "rgba(52, 152, 219,1)",
                            strokeColor: "rgba(52, 152, 219,1)",
                            pointColor: "rgba(52, 152, 219,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [hostname_one_nine,
                                hostname_one_ten,
                                hostname_one_eleven,
                                hostname_one_twelve,
                                hostname_one_thirteen,
                                hostname_one_forteen,
                                hostname_one_fifteen,
                                hostname_one_sixteen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.8)",
                            strokeColor: "rgba(242,38,19, 0.8)",
                            pointColor: "rgba(242,38,19,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [hostname_two_nine,
                                hostname_two_ten,
                                hostname_two_eleven,
                                hostname_two_twelve,
                                hostname_two_thirteen,
                                hostname_two_forteen,
                                hostname_two_fifteen,
                                hostname_two_sixteen] // 9am - 5pm
                        }
                    ]
                };

                // render chart
                var ctx = document.getElementById("movementSaturday").getContext("2d");
                var myLineChart = new Chart(ctx).Line(data, {
                    bezierCurve: false,
                    scaleShowGridLines: false,
                    scaleGridLineColor: "rgba(0,0,0, 1)"
                });

            });

        };

        /**
         * Displays Sunday's data
         */
        this.displaySunday = function() {
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/movement_sunday.json";
//            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/movement_sunday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////

                var hostname_one_nine;
                var hostname_one_ten;
                var hostname_one_eleven;
                var hostname_one_twelve;
                var hostname_one_thirteen;
                var hostname_one_forteen;
                var hostname_one_fifteen;
                var hostname_one_sixteen;

                if (data.agent_one["nine"][0] > LIMIT) {
                    hostname_one_nine = LIMIT;
                } else {
                    hostname_one_nine = data.agent_one["nine"][0];
                }

                if (data.agent_one["ten"][0] > LIMIT) {
                    hostname_one_ten = LIMIT;
                } else {
                    hostname_one_ten = data.agent_one["ten"][0];
                }

                if (data.agent_one["eleven"][0] > LIMIT) {
                    hostname_one_eleven = LIMIT;
                } else {
                    hostname_one_eleven = data.agent_one["eleven"][0];
                }

                if (data.agent_one["twelve"][0] > LIMIT) {
                    hostname_one_twelve = LIMIT;
                } else {
                    hostname_one_twelve = data.agent_one["twelve"][0];
                }

                if (data.agent_one["thirteen"][0] > LIMIT) {
                    hostname_one_thirteen = LIMIT;
                } else {
                    hostname_one_thirteen = data.agent_one["thirteen"][0];
                }

                if (data.agent_one["forteen"][0] > LIMIT) {
                    hostname_one_forteen = LIMIT;
                } else {
                    hostname_one_forteen = data.agent_one["forteen"][0];
                }

                if (data.agent_one["fifteen"][0] > LIMIT) {
                    hostname_one_fifteen = LIMIT;
                } else {
                    hostname_one_fifteen = data.agent_one["fifteen"][0];
                }

                if (data.agent_one["sixteen"][0] > LIMIT) {
                    hostname_one_sixteen = LIMIT;
                } else {
                    hostname_one_sixteen = data.agent_one["sixteen"][0];
                }


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine;
                var hostname_two_ten;
                var hostname_two_eleven;
                var hostname_two_twelve;
                var hostname_two_thirteen;
                var hostname_two_forteen;
                var hostname_two_fifteen;
                var hostname_two_sixteen;



                if (data.agent_two["nine"][0] > LIMIT) {
                    hostname_two_nine = LIMIT;
                } else {
                    hostname_two_nine = data.agent_two["nine"][0];
                }

                if (data.agent_two["ten"][0] > LIMIT) {
                    hostname_two_ten = LIMIT;
                } else {
                    hostname_two_ten = data.agent_two["ten"][0];
                }

                if (data.agent_two["eleven"][0] > LIMIT) {
                    hostname_two_eleven = LIMIT;
                } else {
                    hostname_two_eleven = data.agent_two["eleven"][0];
                }

                if (data.agent_two["twelve"][0] > LIMIT) {
                    hostname_two_twelve = LIMIT;
                } else {
                    hostname_two_twelve = data.agent_two["twelve"][0];
                }

                if (data.agent_two["thirteen"][0] > LIMIT) {
                    hostname_two_thirteen = LIMIT;
                } else {
                    hostname_two_thirteen = data.agent_two["thirteen"][0];
                }

                if (data.agent_two["forteen"][0] > LIMIT) {
                    hostname_two_forteen = LIMIT;
                } else {
                    hostname_two_forteen = data.agent_two["forteen"][0];
                }

                if (data.agent_two["fifteen"][0] > LIMIT) {
                    hostname_two_fifteen = LIMIT;
                } else {
                    hostname_two_fifteen = data.agent_two["fifteen"][0];
                }

                if (data.agent_two["sixteen"][0] > LIMIT) {
                    hostname_two_sixteen = LIMIT;
                } else {
                    hostname_two_sixteen = data.agent_two["sixteen"][0];
                }


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9am"); // [0]
                hours.push("10am"); // [1]
                hours.push("11am"); // [2]
                hours.push("12pm"); // [3]
                hours.push("1pm"); // [4]
                hours.push("2pm"); // [5]
                hours.push("3pm"); // [6]
                hours.push("4pm"); // [7]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7]],
                    datasets: [
                        {
                            label: hostname_one,
                            fillColor: "rgba(52, 152, 219,1)",
                            strokeColor: "rgba(52, 152, 219,1)",
                            pointColor: "rgba(52, 152, 219,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [hostname_one_nine,
                                hostname_one_ten,
                                hostname_one_eleven,
                                hostname_one_twelve,
                                hostname_one_thirteen,
                                hostname_one_forteen,
                                hostname_one_fifteen,
                                hostname_one_sixteen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.8)",
                            strokeColor: "rgba(242,38,19, 0.8)",
                            pointColor: "rgba(242,38,19,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [hostname_two_nine,
                                hostname_two_ten,
                                hostname_two_eleven,
                                hostname_two_twelve,
                                hostname_two_thirteen,
                                hostname_two_forteen,
                                hostname_two_fifteen,
                                hostname_two_sixteen] // 9am - 5pm
                        }
                    ]
                };

                // render chart
                var ctx = document.getElementById("movementSunday").getContext("2d");
                var myLineChart = new Chart(ctx).Line(data, {
                    bezierCurve: false,
                    scaleShowGridLines: false,
                    scaleGridLineColor: "rgba(0,0,0, 1)"
                });

            });

        };

        /**
         * Displays Monday's data
         */
        this.displayMonday = function() {
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/movement_monday.json";
//            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/movement_monday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////
                
                var hostname_one_nine;
                var hostname_one_ten;
                var hostname_one_eleven;
                var hostname_one_twelve;
                var hostname_one_thirteen;
                var hostname_one_forteen;
                var hostname_one_fifteen;
                var hostname_one_sixteen;
                
                if(data.agent_one["nine"][0] > LIMIT) {
                    hostname_one_nine = LIMIT;
                } else {
                    hostname_one_nine = data.agent_one["nine"][0];
                }
                
                if(data.agent_one["ten"][0] > LIMIT) {
                    hostname_one_ten = LIMIT;
                } else {
                    hostname_one_ten = data.agent_one["ten"][0];
                }
                
                if(data.agent_one["eleven"][0] > LIMIT) {
                    hostname_one_eleven = LIMIT;
                } else {
                    hostname_one_eleven = data.agent_one["eleven"][0];
                }
                
                if(data.agent_one["twelve"][0] > LIMIT) {
                    hostname_one_twelve = LIMIT;
                } else {
                    hostname_one_twelve = data.agent_one["twelve"][0];
                }
                
                if(data.agent_one["thirteen"][0] > LIMIT) {
                    hostname_one_thirteen = LIMIT;
                } else {
                    hostname_one_thirteen = data.agent_one["thirteen"][0];
                }
                
                if(data.agent_one["forteen"][0] > LIMIT) {
                    hostname_one_forteen = LIMIT;
                } else {
                    hostname_one_forteen = data.agent_one["forteen"][0];
                }
                                
                if(data.agent_one["fifteen"][0] > LIMIT) {
                    hostname_one_fifteen = LIMIT;
                } else {
                    hostname_one_fifteen = data.agent_one["fifteen"][0];
                }
                                
                if(data.agent_one["sixteen"][0] > LIMIT) {
                    hostname_one_sixteen = LIMIT;
                } else {
                    hostname_one_sixteen = data.agent_one["sixteen"][0];
                }
                

                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine;
                var hostname_two_ten;
                var hostname_two_eleven;
                var hostname_two_twelve;
                var hostname_two_thirteen;
                var hostname_two_forteen;
                var hostname_two_fifteen;
                var hostname_two_sixteen;
                
                
                
                if(data.agent_two["nine"][0] > LIMIT) {
                    hostname_two_nine = LIMIT;
                } else {
                    hostname_two_nine = data.agent_two["nine"][0];
                }
                
                if(data.agent_two["ten"][0] > LIMIT) {
                    hostname_two_ten = LIMIT;
                } else {
                    hostname_two_ten = data.agent_two["ten"][0];
                }
                
                if(data.agent_two["eleven"][0] > LIMIT) {
                    hostname_two_eleven = LIMIT;
                } else {
                    hostname_two_eleven = data.agent_two["eleven"][0];
                }
                
                if(data.agent_two["twelve"][0] > LIMIT) {
                    hostname_two_twelve = LIMIT;
                } else {
                    hostname_two_twelve = data.agent_two["twelve"][0];
                }
                
                if(data.agent_two["thirteen"][0] > LIMIT) {
                    hostname_two_thirteen = LIMIT;
                } else {
                    hostname_two_thirteen = data.agent_two["thirteen"][0];
                }
                
                if(data.agent_two["forteen"][0] > LIMIT) {
                    hostname_two_forteen = LIMIT;
                } else {
                    hostname_two_forteen = data.agent_two["forteen"][0];
                }
                                
                if(data.agent_two["fifteen"][0] > LIMIT) {
                    hostname_two_fifteen = LIMIT;
                } else {
                    hostname_two_fifteen = data.agent_two["fifteen"][0];
                }
                                
                if(data.agent_two["sixteen"][0] > LIMIT) {
                    hostname_two_sixteen = LIMIT;
                } else {
                    hostname_two_sixteen = data.agent_two["sixteen"][0];
                }


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9am"); // [0]
                hours.push("10am"); // [1]
                hours.push("11am"); // [2]
                hours.push("12pm"); // [3]
                hours.push("1pm"); // [4]
                hours.push("2pm"); // [5]
                hours.push("3pm"); // [6]
                hours.push("4pm"); // [7]
//                hours.push("17.00"); // [8]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7]],
                    datasets: [
                        {
                            label: hostname_one,
                            fillColor: "rgba(52, 152, 219,1)",
                            strokeColor: "rgba(52, 152, 219,1)",
                            pointColor: "rgba(52, 152, 219,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [hostname_one_nine,
                                hostname_one_ten,
                                hostname_one_eleven,
                                hostname_one_twelve,
                                hostname_one_thirteen,
                                hostname_one_forteen,
                                hostname_one_fifteen,
                                hostname_one_sixteen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.8)",
                            strokeColor: "rgba(242,38,19, 0.8)",
                            pointColor: "rgba(242,38,19,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [hostname_two_nine,
                                hostname_two_ten,
                                hostname_two_eleven,
                                hostname_two_twelve,
                                hostname_two_thirteen,
                                hostname_two_forteen,
                                hostname_two_fifteen,
                                hostname_two_sixteen] // 9am - 5pm
                        }
                    ]
                };

                // render chart
                var ctx = document.getElementById("movementMonday").getContext("2d");
                var myLineChart = new Chart(ctx).Line(data, {
                    bezierCurve: false,
                    scaleShowGridLines: false,
                    scaleGridLineColor: "rgba(0,0,0, 1)"
                });

            });

        };

        /**
         * Displays Tuesday's data
         */
        this.displayTuesday = function() {
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/movement_tuesday.json";
//            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/movement_tuesday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////
                
                var hostname_one_nine;
                var hostname_one_ten;
                var hostname_one_eleven;
                var hostname_one_twelve;
                var hostname_one_thirteen;
                var hostname_one_forteen;
                var hostname_one_fifteen;
                var hostname_one_sixteen;
                
                if(data.agent_one["nine"][0] > LIMIT) {
                    hostname_one_nine = LIMIT;
                } else {
                    hostname_one_nine = data.agent_one["nine"][0];
                }
                
                if(data.agent_one["ten"][0] > LIMIT) {
                    hostname_one_ten = LIMIT;
                } else {
                    hostname_one_ten = data.agent_one["ten"][0];
                }
                
                if(data.agent_one["eleven"][0] > LIMIT) {
                    hostname_one_eleven = LIMIT;
                } else {
                    hostname_one_eleven = data.agent_one["eleven"][0];
                }
                
                if(data.agent_one["twelve"][0] > LIMIT) {
                    hostname_one_twelve = LIMIT;
                } else {
                    hostname_one_twelve = data.agent_one["twelve"][0];
                }
                
                if(data.agent_one["thirteen"][0] > LIMIT) {
                    hostname_one_thirteen = LIMIT;
                } else {
                    hostname_one_thirteen = data.agent_one["thirteen"][0];
                }
                
                if(data.agent_one["forteen"][0] > LIMIT) {
                    hostname_one_forteen = LIMIT;
                } else {
                    hostname_one_forteen = data.agent_one["forteen"][0];
                }
                                
                if(data.agent_one["fifteen"][0] > LIMIT) {
                    hostname_one_fifteen = LIMIT;
                } else {
                    hostname_one_fifteen = data.agent_one["fifteen"][0];
                }
                                
                if(data.agent_one["sixteen"][0] > LIMIT) {
                    hostname_one_sixteen = LIMIT;
                } else {
                    hostname_one_sixteen = data.agent_one["sixteen"][0];
                }
                

                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine;
                var hostname_two_ten;
                var hostname_two_eleven;
                var hostname_two_twelve;
                var hostname_two_thirteen;
                var hostname_two_forteen;
                var hostname_two_fifteen;
                var hostname_two_sixteen;
                
                
                
                if(data.agent_two["nine"][0] > LIMIT) {
                    hostname_two_nine = LIMIT;
                } else {
                    hostname_two_nine = data.agent_two["nine"][0];
                }
                
                if(data.agent_two["ten"][0] > LIMIT) {
                    hostname_two_ten = LIMIT;
                } else {
                    hostname_two_ten = data.agent_two["ten"][0];
                }
                
                if(data.agent_two["eleven"][0] > LIMIT) {
                    hostname_two_eleven = LIMIT;
                } else {
                    hostname_two_eleven = data.agent_two["eleven"][0];
                }
                
                if(data.agent_two["twelve"][0] > LIMIT) {
                    hostname_two_twelve = LIMIT;
                } else {
                    hostname_two_twelve = data.agent_two["twelve"][0];
                }
                
                if(data.agent_two["thirteen"][0] > LIMIT) {
                    hostname_two_thirteen = LIMIT;
                } else {
                    hostname_two_thirteen = data.agent_two["thirteen"][0];
                }
                
                if(data.agent_two["forteen"][0] > LIMIT) {
                    hostname_two_forteen = LIMIT;
                } else {
                    hostname_two_forteen = data.agent_two["forteen"][0];
                }
                                
                if(data.agent_two["fifteen"][0] > LIMIT) {
                    hostname_two_fifteen = LIMIT;
                } else {
                    hostname_two_fifteen = data.agent_two["fifteen"][0];
                }
                                
                if(data.agent_two["sixteen"][0] > LIMIT) {
                    hostname_two_sixteen = LIMIT;
                } else {
                    hostname_two_sixteen = data.agent_two["sixteen"][0];
                }


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9am"); // [0]
                hours.push("10am"); // [1]
                hours.push("11am"); // [2]
                hours.push("12pm"); // [3]
                hours.push("1pm"); // [4]
                hours.push("2pm"); // [5]
                hours.push("3pm"); // [6]
                hours.push("4pm"); // [7]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7]],
                    datasets: [
                        {
                            label: hostname_one,
                            fillColor: "rgba(52, 152, 219,1)",
                            strokeColor: "rgba(52, 152, 219,1)",
                            pointColor: "rgba(52, 152, 219,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [hostname_one_nine,
                                hostname_one_ten,
                                hostname_one_eleven,
                                hostname_one_twelve,
                                hostname_one_thirteen,
                                hostname_one_forteen,
                                hostname_one_fifteen,
                                hostname_one_sixteen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.8)",
                            strokeColor: "rgba(242,38,19, 0.8)",
                            pointColor: "rgba(242,38,19,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [hostname_two_nine,
                                hostname_two_ten,
                                hostname_two_eleven,
                                hostname_two_twelve,
                                hostname_two_thirteen,
                                hostname_two_forteen,
                                hostname_two_fifteen,
                                hostname_two_sixteen] // 9am - 5pm
                        }
                    ]
                };

                // render chart
                var ctx = document.getElementById("movementTuesday").getContext("2d");
                var myLineChart = new Chart(ctx).Line(data, {
                    bezierCurve: false,
                    scaleShowGridLines: false,
                    scaleGridLineColor: "rgba(0,0,0, 1)"
                });

            });

        };

        /**
         * Displays Wednesday's data
         */
        this.displayWednesday = function() {
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/movement_wednesday.json";
//            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/movement_wednesday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////
                
                var hostname_one_nine;
                var hostname_one_ten;
                var hostname_one_eleven;
                var hostname_one_twelve;
                var hostname_one_thirteen;
                var hostname_one_forteen;
                var hostname_one_fifteen;
                var hostname_one_sixteen;
                
                if(data.agent_one["nine"][0] > LIMIT) {
                    hostname_one_nine = LIMIT;
                } else {
                    hostname_one_nine = data.agent_one["nine"][0];
                }
                
                if(data.agent_one["ten"][0] > LIMIT) {
                    hostname_one_ten = LIMIT;
                } else {
                    hostname_one_ten = data.agent_one["ten"][0];
                }
                
                if(data.agent_one["eleven"][0] > LIMIT) {
                    hostname_one_eleven = LIMIT;
                } else {
                    hostname_one_eleven = data.agent_one["eleven"][0];
                }
                
                if(data.agent_one["twelve"][0] > LIMIT) {
                    hostname_one_twelve = LIMIT;
                } else {
                    hostname_one_twelve = data.agent_one["twelve"][0];
                }
                
                if(data.agent_one["thirteen"][0] > LIMIT) {
                    hostname_one_thirteen = LIMIT;
                } else {
                    hostname_one_thirteen = data.agent_one["thirteen"][0];
                }
                
                if(data.agent_one["forteen"][0] > LIMIT) {
                    hostname_one_forteen = LIMIT;
                } else {
                    hostname_one_forteen = data.agent_one["forteen"][0];
                }
                                
                if(data.agent_one["fifteen"][0] > LIMIT) {
                    hostname_one_fifteen = LIMIT;
                } else {
                    hostname_one_fifteen = data.agent_one["fifteen"][0];
                }
                                
                if(data.agent_one["sixteen"][0] > LIMIT) {
                    hostname_one_sixteen = LIMIT;
                } else {
                    hostname_one_sixteen = data.agent_one["sixteen"][0];
                }
                

                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine;
                var hostname_two_ten;
                var hostname_two_eleven;
                var hostname_two_twelve;
                var hostname_two_thirteen;
                var hostname_two_forteen;
                var hostname_two_fifteen;
                var hostname_two_sixteen;
                
                
                
                if(data.agent_two["nine"][0] > LIMIT) {
                    hostname_two_nine = LIMIT;
                } else {
                    hostname_two_nine = data.agent_two["nine"][0];
                }
                
                if(data.agent_two["ten"][0] > LIMIT) {
                    hostname_two_ten = LIMIT;
                } else {
                    hostname_two_ten = data.agent_two["ten"][0];
                }
                
                if(data.agent_two["eleven"][0] > LIMIT) {
                    hostname_two_eleven = LIMIT;
                } else {
                    hostname_two_eleven = data.agent_two["eleven"][0];
                }
                
                if(data.agent_two["twelve"][0] > LIMIT) {
                    hostname_two_twelve = LIMIT;
                } else {
                    hostname_two_twelve = data.agent_two["twelve"][0];
                }
                
                if(data.agent_two["thirteen"][0] > LIMIT) {
                    hostname_two_thirteen = LIMIT;
                } else {
                    hostname_two_thirteen = data.agent_two["thirteen"][0];
                }
                
                if(data.agent_two["forteen"][0] > LIMIT) {
                    hostname_two_forteen = LIMIT;
                } else {
                    hostname_two_forteen = data.agent_two["forteen"][0];
                }
                                
                if(data.agent_two["fifteen"][0] > LIMIT) {
                    hostname_two_fifteen = LIMIT;
                } else {
                    hostname_two_fifteen = data.agent_two["fifteen"][0];
                }
                                
                if(data.agent_two["sixteen"][0] > LIMIT) {
                    hostname_two_sixteen = LIMIT;
                } else {
                    hostname_two_sixteen = data.agent_two["sixteen"][0];
                }


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9am"); // [0]
                hours.push("10am"); // [1]
                hours.push("11am"); // [2]
                hours.push("12pm"); // [3]
                hours.push("1pm"); // [4]
                hours.push("2pm"); // [5]
                hours.push("3pm"); // [6]
                hours.push("4pm"); // [7]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7]],
                    datasets: [
                        {
                            label: hostname_one,
                            fillColor: "rgba(52, 152, 219,1)",
                            strokeColor: "rgba(52, 152, 219,1)",
                            pointColor: "rgba(52, 152, 219,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [hostname_one_nine,
                                hostname_one_ten,
                                hostname_one_eleven,
                                hostname_one_twelve,
                                hostname_one_thirteen,
                                hostname_one_forteen,
                                hostname_one_fifteen,
                                hostname_one_sixteen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.8)",
                            strokeColor: "rgba(242,38,19, 0.8)",
                            pointColor: "rgba(242,38,19,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [hostname_two_nine,
                                hostname_two_ten,
                                hostname_two_eleven,
                                hostname_two_twelve,
                                hostname_two_thirteen,
                                hostname_two_forteen,
                                hostname_two_fifteen,
                                hostname_two_sixteen] // 9am - 5pm
                        }
                    ]
                };

                // render chart
                var ctx = document.getElementById("movementWednesday").getContext("2d");
                var myLineChart = new Chart(ctx).Line(data, {
                    bezierCurve: false,
                    scaleShowGridLines: false,
                    scaleGridLineColor: "rgba(0,0,0, 1)"
                });

            });

        };

        /**
         * Displays Thursdays's data
         */
        this.displayThursday = function() {
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/movement_thursday.json";
//            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/movement_thursday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////
                
                var hostname_one_nine;
                var hostname_one_ten;
                var hostname_one_eleven;
                var hostname_one_twelve;
                var hostname_one_thirteen;
                var hostname_one_forteen;
                var hostname_one_fifteen;
                var hostname_one_sixteen;
                
                if(data.agent_one["nine"][0] > LIMIT) {
                    hostname_one_nine = LIMIT;
                } else {
                    hostname_one_nine = data.agent_one["nine"][0];
                }
                
                if(data.agent_one["ten"][0] > LIMIT) {
                    hostname_one_ten = LIMIT;
                } else {
                    hostname_one_ten = data.agent_one["ten"][0];
                }
                
                if(data.agent_one["eleven"][0] > LIMIT) {
                    hostname_one_eleven = LIMIT;
                } else {
                    hostname_one_eleven = data.agent_one["eleven"][0];
                }
                
                if(data.agent_one["twelve"][0] > LIMIT) {
                    hostname_one_twelve = LIMIT;
                } else {
                    hostname_one_twelve = data.agent_one["twelve"][0];
                }
                
                if(data.agent_one["thirteen"][0] > LIMIT) {
                    hostname_one_thirteen = LIMIT;
                } else {
                    hostname_one_thirteen = data.agent_one["thirteen"][0];
                }
                
                if(data.agent_one["forteen"][0] > LIMIT) {
                    hostname_one_forteen = LIMIT;
                } else {
                    hostname_one_forteen = data.agent_one["forteen"][0];
                }
                                
                if(data.agent_one["fifteen"][0] > LIMIT) {
                    hostname_one_fifteen = LIMIT;
                } else {
                    hostname_one_fifteen = data.agent_one["fifteen"][0];
                }
                                
                if(data.agent_one["sixteen"][0] > LIMIT) {
                    hostname_one_sixteen = LIMIT;
                } else {
                    hostname_one_sixteen = data.agent_one["sixteen"][0];
                }
                

                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine;
                var hostname_two_ten;
                var hostname_two_eleven;
                var hostname_two_twelve;
                var hostname_two_thirteen;
                var hostname_two_forteen;
                var hostname_two_fifteen;
                var hostname_two_sixteen;
                
                
                
                if(data.agent_two["nine"][0] > LIMIT) {
                    hostname_two_nine = LIMIT;
                } else {
                    hostname_two_nine = data.agent_two["nine"][0];
                }
                
                if(data.agent_two["ten"][0] > LIMIT) {
                    hostname_two_ten = LIMIT;
                } else {
                    hostname_two_ten = data.agent_two["ten"][0];
                }
                
                if(data.agent_two["eleven"][0] > LIMIT) {
                    hostname_two_eleven = LIMIT;
                } else {
                    hostname_two_eleven = data.agent_two["eleven"][0];
                }
                
                if(data.agent_two["twelve"][0] > LIMIT) {
                    hostname_two_twelve = LIMIT;
                } else {
                    hostname_two_twelve = data.agent_two["twelve"][0];
                }
                
                if(data.agent_two["thirteen"][0] > LIMIT) {
                    hostname_two_thirteen = LIMIT;
                } else {
                    hostname_two_thirteen = data.agent_two["thirteen"][0];
                }
                
                if(data.agent_two["forteen"][0] > LIMIT) {
                    hostname_two_forteen = LIMIT;
                } else {
                    hostname_two_forteen = data.agent_two["forteen"][0];
                }
                                
                if(data.agent_two["fifteen"][0] > LIMIT) {
                    hostname_two_fifteen = LIMIT;
                } else {
                    hostname_two_fifteen = data.agent_two["fifteen"][0];
                }
                                
                if(data.agent_two["sixteen"][0] > LIMIT) {
                    hostname_two_sixteen = LIMIT;
                } else {
                    hostname_two_sixteen = data.agent_two["sixteen"][0];
                }
                

                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9am"); // [0]
                hours.push("10am"); // [1]
                hours.push("11am"); // [2]
                hours.push("12pm"); // [3]
                hours.push("1pm"); // [4]
                hours.push("2pm"); // [5]
                hours.push("3pm"); // [6]
                hours.push("4pm"); // [7]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7]],
                    datasets: [
                        {
                            label: hostname_one,
                            fillColor: "rgba(52, 152, 219,1)",
                            strokeColor: "rgba(52, 152, 219,1)",
                            pointColor: "rgba(52, 152, 219,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [hostname_one_nine,
                                hostname_one_ten,
                                hostname_one_eleven,
                                hostname_one_twelve,
                                hostname_one_thirteen,
                                hostname_one_forteen,
                                hostname_one_fifteen,
                                hostname_one_sixteen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.8)",
                            strokeColor: "rgba(242,38,19, 0.8)",
                            pointColor: "rgba(242,38,19,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [hostname_two_nine,
                                hostname_two_ten,
                                hostname_two_eleven,
                                hostname_two_twelve,
                                hostname_two_thirteen,
                                hostname_two_forteen,
                                hostname_two_fifteen,
                                hostname_two_sixteen] // 9am - 5pm
                        }
                    ]
                };

                // render chart
                var ctx = document.getElementById("movementThursday").getContext("2d");
                var myLineChart = new Chart(ctx).Line(data, {
                    bezierCurve: false,
                    scaleShowGridLines: false,
                    scaleGridLineColor: "rgba(0,0,0, 1)"
                });

            });

        };

        /**
         * Displays Friday's data
         */
        this.displayFriday = function() {
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/movement_friday.json";
//            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/movement_friday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////
                
                var hostname_one_nine;
                var hostname_one_ten;
                var hostname_one_eleven;
                var hostname_one_twelve;
                var hostname_one_thirteen;
                var hostname_one_forteen;
                var hostname_one_fifteen;
                var hostname_one_sixteen;
                
                if(data.agent_one["nine"][0] > LIMIT) {
                    hostname_one_nine = LIMIT;
                } else {
                    hostname_one_nine = data.agent_one["nine"][0];
                }
                
                if(data.agent_one["ten"][0] > LIMIT) {
                    hostname_one_ten = LIMIT;
                } else {
                    hostname_one_ten = data.agent_one["ten"][0];
                }
                
                if(data.agent_one["eleven"][0] > LIMIT) {
                    hostname_one_eleven = LIMIT;
                } else {
                    hostname_one_eleven = data.agent_one["eleven"][0];
                }
                
                if(data.agent_one["twelve"][0] > LIMIT) {
                    hostname_one_twelve = LIMIT;
                } else {
                    hostname_one_twelve = data.agent_one["twelve"][0];
                }
                
                if(data.agent_one["thirteen"][0] > LIMIT) {
                    hostname_one_thirteen = LIMIT;
                } else {
                    hostname_one_thirteen = data.agent_one["thirteen"][0];
                }
                
                if(data.agent_one["forteen"][0] > LIMIT) {
                    hostname_one_forteen = LIMIT;
                } else {
                    hostname_one_forteen = data.agent_one["forteen"][0];
                }
                                
                if(data.agent_one["fifteen"][0] > LIMIT) {
                    hostname_one_fifteen = LIMIT;
                } else {
                    hostname_one_fifteen = data.agent_one["fifteen"][0];
                }
                                
                if(data.agent_one["sixteen"][0] > LIMIT) {
                    hostname_one_sixteen = LIMIT;
                } else {
                    hostname_one_sixteen = data.agent_one["sixteen"][0];
                }
                

                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine;
                var hostname_two_ten;
                var hostname_two_eleven;
                var hostname_two_twelve;
                var hostname_two_thirteen;
                var hostname_two_forteen;
                var hostname_two_fifteen;
                var hostname_two_sixteen;
                
                
                
                if(data.agent_two["nine"][0] > LIMIT) {
                    hostname_two_nine = LIMIT;
                } else {
                    hostname_two_nine = data.agent_two["nine"][0];
                }
                
                if(data.agent_two["ten"][0] > LIMIT) {
                    hostname_two_ten = LIMIT;
                } else {
                    hostname_two_ten = data.agent_two["ten"][0];
                }
                
                if(data.agent_two["eleven"][0] > LIMIT) {
                    hostname_two_eleven = LIMIT;
                } else {
                    hostname_two_eleven = data.agent_two["eleven"][0];
                }
                
                if(data.agent_two["twelve"][0] > LIMIT) {
                    hostname_two_twelve = LIMIT;
                } else {
                    hostname_two_twelve = data.agent_two["twelve"][0];
                }
                
                if(data.agent_two["thirteen"][0] > LIMIT) {
                    hostname_two_thirteen = LIMIT;
                } else {
                    hostname_two_thirteen = data.agent_two["thirteen"][0];
                }
                
                if(data.agent_two["forteen"][0] > LIMIT) {
                    hostname_two_forteen = LIMIT;
                } else {
                    hostname_two_forteen = data.agent_two["forteen"][0];
                }
                                
                if(data.agent_two["fifteen"][0] > LIMIT) {
                    hostname_two_fifteen = LIMIT;
                } else {
                    hostname_two_fifteen = data.agent_two["fifteen"][0];
                }
                                
                if(data.agent_two["sixteen"][0] > LIMIT) {
                    hostname_two_sixteen = LIMIT;
                } else {
                    hostname_two_sixteen = data.agent_two["sixteen"][0];
                }


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9am"); // [0]
                hours.push("10am"); // [1]
                hours.push("11am"); // [2]
                hours.push("12pm"); // [3]
                hours.push("1pm"); // [4]
                hours.push("2pm"); // [5]
                hours.push("3pm"); // [6]
                hours.push("4pm"); // [7]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7]],
                    datasets: [
                        {
                            label: hostname_one,
                            fillColor: "rgba(52, 152, 219,1)",
                            strokeColor: "rgba(52, 152, 219,1)",
                            pointColor: "rgba(52, 152, 219,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [hostname_one_nine,
                                hostname_one_ten,
                                hostname_one_eleven,
                                hostname_one_twelve,
                                hostname_one_thirteen,
                                hostname_one_forteen,
                                hostname_one_fifteen,
                                hostname_one_sixteen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.8)",
                            strokeColor: "rgba(242,38,19, 0.8)",
                            pointColor: "rgba(242,38,19,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [hostname_two_nine,
                                hostname_two_ten,
                                hostname_two_eleven,
                                hostname_two_twelve,
                                hostname_two_thirteen,
                                hostname_two_forteen,
                                hostname_two_fifteen,
                                hostname_two_sixteen] // 9am - 5pm
                        }
                    ]
                };

                // render chart
                var ctx = document.getElementById("movementFriday").getContext("2d");
                var myLineChart = new Chart(ctx).Line(data, {
                    bezierCurve: false,
                    scaleShowGridLines: false,
                    scaleGridLineColor: "rgba(0,0,0, 1)"
                });
            });

        };

    }

    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Weekdays();
});