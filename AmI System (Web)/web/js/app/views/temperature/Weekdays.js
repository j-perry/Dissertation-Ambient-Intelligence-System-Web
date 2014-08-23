/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
//var path = '../jp373/js/app/views/temperature/Weekdays.js';
var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/temperature/Weekdays.js';

define(path, function(weekdays) {
    function Weekdays() {

        var hostname_one = "Agent 1";
        var hostname_two = "Agent 2";

        /**
         * Monday's data
         */
        this.displayMonday = function() {
//              var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/temperature_monday.json";
            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/temperature_monday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////

                var hostname_one_nine = data.agent_one["9.00"][0];
                var hostname_one_ten = data.agent_one["10.00"][0];
                var hostname_one_eleven = data.agent_one["11.00"][0];
                var hostname_one_twelve = data.agent_one["12.00"][0];
                var hostname_one_thirteen = data.agent_one["13.00"][0];
                var hostname_one_forteen = data.agent_one["14.00"][0];
                var hostname_one_fifteen = data.agent_one["15.00"][0];
                var hostname_one_sixteen = data.agent_one["16.00"][0];
                var hostname_one_seventeen = data.agent_one["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine = data.agent_two["9.00"][0];
                var hostname_two_ten = data.agent_two["10.00"][0];
                var hostname_two_eleven = data.agent_two["11.00"][0];
                var hostname_two_twelve = data.agent_two["12.00"][0];
                var hostname_two_thirteen = data.agent_two["13.00"][0];
                var hostname_two_forteen = data.agent_two["14.00"][0];
                var hostname_two_fifteen = data.agent_two["15.00"][0];
                var hostname_two_sixteen = data.agent_two["16.00"][0];
                var hostname_two_seventeen = data.agent_two["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9.00");     // [0]
                hours.push("10.00");    // [1]
                hours.push("11.00");    // [2]
                hours.push("12.00");    // [3]
                hours.push("13.00");    // [4]
                hours.push("14.00");    // [5]
                hours.push("15.00");    // [6]
                hours.push("16.00");    // [7]
                hours.push("17.00");    // [8]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7], hours[8]],
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
                                hostname_one_sixteen,
                                hostname_one_seventeen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.9)",
                            strokeColor: "rgba(242,38,19, 0.9)",
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
                                hostname_two_sixteen,
                                hostname_two_seventeen] // 9am - 5pm
                        }
                    ]
                };
                
                // render chart
                var ctx = document.getElementById("temperatureMonday").getContext("2d");
                var myLineChart = new Chart(ctx).Line(data, {
                    bezierCurve: false,
                    scaleShowGridLines: false,
                    scaleGridLineColor: "rgba(0,0,0, 1)"
                });

            });

        };

        /**
         * Tuesdays's data
         */
        this.displayTuesday = function() {
//            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/temperature_tuesday.json";
            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/temperature_tuesday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////

                var hostname_one_nine = data.agent_one["9.00"][0];
                var hostname_one_ten = data.agent_one["10.00"][0];
                var hostname_one_eleven = data.agent_one["11.00"][0];
                var hostname_one_twelve = data.agent_one["12.00"][0];
                var hostname_one_thirteen = data.agent_one["13.00"][0];
                var hostname_one_forteen = data.agent_one["14.00"][0];
                var hostname_one_fifteen = data.agent_one["15.00"][0];
                var hostname_one_sixteen = data.agent_one["16.00"][0];
                var hostname_one_seventeen = data.agent_one["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine = data.agent_two["9.00"][0];
                var hostname_two_ten = data.agent_two["10.00"][0];
                var hostname_two_eleven = data.agent_two["11.00"][0];
                var hostname_two_twelve = data.agent_two["12.00"][0];
                var hostname_two_thirteen = data.agent_two["13.00"][0];
                var hostname_two_forteen = data.agent_two["14.00"][0];
                var hostname_two_fifteen = data.agent_two["15.00"][0];
                var hostname_two_sixteen = data.agent_two["16.00"][0];
                var hostname_two_seventeen = data.agent_two["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9.00");     // [0]
                hours.push("10.00");    // [1]
                hours.push("11.00");    // [2]
                hours.push("12.00");    // [3]
                hours.push("13.00");    // [4]
                hours.push("14.00");    // [5]
                hours.push("15.00");    // [6]
                hours.push("16.00");    // [7]
                hours.push("17.00");    // [8]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7], hours[8]],
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
                                hostname_one_sixteen,
                                hostname_one_seventeen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.9)",
                            strokeColor: "rgba(242,38,19, 0.9)",
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
                                hostname_two_sixteen,
                                hostname_two_seventeen] // 9am - 5pm
                        }
                    ]
                };

            });

        };

        /**
         * Wednesday's data
         */
        this.displayWednesday = function() {
//            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/temperature_wednesday.json";
            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/temperature_wednesday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////

                var hostname_one_nine = data.agent_one["9.00"][0];
                var hostname_one_ten = data.agent_one["10.00"][0];
                var hostname_one_eleven = data.agent_one["11.00"][0];
                var hostname_one_twelve = data.agent_one["12.00"][0];
                var hostname_one_thirteen = data.agent_one["13.00"][0];
                var hostname_one_forteen = data.agent_one["14.00"][0];
                var hostname_one_fifteen = data.agent_one["15.00"][0];
                var hostname_one_sixteen = data.agent_one["16.00"][0];
                var hostname_one_seventeen = data.agent_one["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine = data.agent_two["9.00"][0];
                var hostname_two_ten = data.agent_two["10.00"][0];
                var hostname_two_eleven = data.agent_two["11.00"][0];
                var hostname_two_twelve = data.agent_two["12.00"][0];
                var hostname_two_thirteen = data.agent_two["13.00"][0];
                var hostname_two_forteen = data.agent_two["14.00"][0];
                var hostname_two_fifteen = data.agent_two["15.00"][0];
                var hostname_two_sixteen = data.agent_two["16.00"][0];
                var hostname_two_seventeen = data.agent_two["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9.00");     // [0]
                hours.push("10.00");    // [1]
                hours.push("11.00");    // [2]
                hours.push("12.00");    // [3]
                hours.push("13.00");    // [4]
                hours.push("14.00");    // [5]
                hours.push("15.00");    // [6]
                hours.push("16.00");    // [7]
                hours.push("17.00");    // [8]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7], hours[8]],
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
                                hostname_one_sixteen,
                                hostname_one_seventeen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.9)",
                            strokeColor: "rgba(242,38,19, 0.9)",
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
                                hostname_two_sixteen,
                                hostname_two_seventeen] // 9am - 5pm
                        }
                    ]
                };

            });

        };

        /**
         * Thursday's data
         */
        this.displayThursday = function() {
//            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/temperature_thursday.json";
            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/temperature_thursday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////

                var hostname_one_nine = data.agent_one["9.00"][0];
                var hostname_one_ten = data.agent_one["10.00"][0];
                var hostname_one_eleven = data.agent_one["11.00"][0];
                var hostname_one_twelve = data.agent_one["12.00"][0];
                var hostname_one_thirteen = data.agent_one["13.00"][0];
                var hostname_one_forteen = data.agent_one["14.00"][0];
                var hostname_one_fifteen = data.agent_one["15.00"][0];
                var hostname_one_sixteen = data.agent_one["16.00"][0];
                var hostname_one_seventeen = data.agent_one["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine = data.agent_two["9.00"][0];
                var hostname_two_ten = data.agent_two["10.00"][0];
                var hostname_two_eleven = data.agent_two["11.00"][0];
                var hostname_two_twelve = data.agent_two["12.00"][0];
                var hostname_two_thirteen = data.agent_two["13.00"][0];
                var hostname_two_forteen = data.agent_two["14.00"][0];
                var hostname_two_fifteen = data.agent_two["15.00"][0];
                var hostname_two_sixteen = data.agent_two["16.00"][0];
                var hostname_two_seventeen = data.agent_two["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9.00");     // [0]
                hours.push("10.00");    // [1]
                hours.push("11.00");    // [2]
                hours.push("12.00");    // [3]
                hours.push("13.00");    // [4]
                hours.push("14.00");    // [5]
                hours.push("15.00");    // [6]
                hours.push("16.00");    // [7]
                hours.push("17.00");    // [8]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7], hours[8]],
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
                                hostname_one_sixteen,
                                hostname_one_seventeen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.9)",
                            strokeColor: "rgba(242,38,19, 0.9)",
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
                                hostname_two_sixteen,
                                hostname_two_seventeen] // 9am - 5pm
                        }
                    ]
                };

            });


        };

        /**
         * Fridays's data
         */
        this.displayFriday = function() {
//            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/temperature_friday.json";
            var path = "http://localhost:8080/AmI_System__Web_/js/json/logs/temperature_friday.json";

            $.getJSON(path, function(data) {


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////

                var hostname_one_nine = data.agent_one["9.00"][0];
                var hostname_one_ten = data.agent_one["10.00"][0];
                var hostname_one_eleven = data.agent_one["11.00"][0];
                var hostname_one_twelve = data.agent_one["12.00"][0];
                var hostname_one_thirteen = data.agent_one["13.00"][0];
                var hostname_one_forteen = data.agent_one["14.00"][0];
                var hostname_one_fifteen = data.agent_one["15.00"][0];
                var hostname_one_sixteen = data.agent_one["16.00"][0];
                var hostname_one_seventeen = data.agent_one["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                var hostname_two_nine = data.agent_two["9.00"][0];
                var hostname_two_ten = data.agent_two["10.00"][0];
                var hostname_two_eleven = data.agent_two["11.00"][0];
                var hostname_two_twelve = data.agent_two["12.00"][0];
                var hostname_two_thirteen = data.agent_two["13.00"][0];
                var hostname_two_forteen = data.agent_two["14.00"][0];
                var hostname_two_fifteen = data.agent_two["15.00"][0];
                var hostname_two_sixteen = data.agent_two["16.00"][0];
                var hostname_two_seventeen = data.agent_two["17.00"][0];


                ///////////////////////////////////////////////////////////////
                //
                //      Populate our data
                //
                ///////////////////////////////////////////////////////////////

                // 9am - 5pm
                var hours = new Array();
                hours.push("9.00");     // [0]
                hours.push("10.00");    // [1]
                hours.push("11.00");    // [2]
                hours.push("12.00");    // [3]
                hours.push("13.00");    // [4]
                hours.push("14.00");    // [5]
                hours.push("15.00");    // [6]
                hours.push("16.00");    // [7]
                hours.push("17.00");    // [8]

                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6], hours[7], hours[8]],
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
                                hostname_one_sixteen,
                                hostname_one_seventeen] // 9am - 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.9)",
                            strokeColor: "rgba(242,38,19, 0.9)",
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
                                hostname_two_sixteen,
                                hostname_two_seventeen] // 9am - 5pm
                        }
                    ]
                };

            });

        };


    }

    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Weekdays();
});