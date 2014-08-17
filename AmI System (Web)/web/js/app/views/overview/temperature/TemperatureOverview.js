/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
var path = "../jp373/js/app/views/overview/temperature/TemperatureOverview";

define(path, function(temperatureOverview) {
    function TemperatureOverview() {
        
        /**
         * Display an overview of temperature data collected from both agents
         */
        this.display = function() {
            var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/json/logs/temperature_overview.json";

            // get JSON values
            $.getJSON(path, function(data) {
                
                // for our data to go into
                var hostname_one_data = new Array();
                var hostname_two_data = new Array();


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 1
                //
                //////////////////////////////////////////////////////////////

                // hostname 1
                var hostname_one = data.hostname_one;

                // monday -> friday
                var hostname_one_monday = new Array();
                var hostname_one_tuesday = new Array();
                var hostname_one_wednesday = new Array();
                var hostname_one_thursday = new Array();
                var hostname_one_friday = new Array();

                // monday
                for (var i in data.hostname_one.monday.value) {
                    hostname_one_monday.push(data.hostname_one.monday.value[i] + ", ");
                }

                // tuesday
                for (var i in data.hostname_one.tuesday.value) {
                    hostname_one_tuesday.push(data.hostname_one.tuesday.value[i] + ", ");
                }

                // wednesday
                for (var i in data.hostname_one.wednesday.value) {
                    hostname_one_wednesday.push(data.hostname_one.wednesday.value[i] + ", ");
                }

                // thursday
                for (var i in data.hostname_one.thursday.value) {
                    hostname_one_thursday.push(data.hostname_one.thursday.value[i] + ", ");
                }

                // friday
                for (var i in data.hostname_one.friday.value) {
                    hostname_one_friday.push(data.hostname_one.friday.value[i] + ", ");
                }


                ///////////////////////////////////////////////////////////////
                //
                //          HOST NAME 2
                //
                //////////////////////////////////////////////////////////////

                // hostname 2
                var hostname_two = data.hostname_two;

                // monday -> friday
                var hostname_two_monday = new Array();
                var hostname_two_tuesday = new Array();
                var hostname_two_wednesday = new Array();
                var hostname_two_thursday = new Array();
                var hostname_two_friday = new Array();
                
                
                /**
                 * Compute our averages here
                 */

                // monday
                for (var i in data.hostname_two.monday.value) {
                    hostname_two_monday.push(data.hostname_two.monday.value[i] + ", ");
                }

                // tuesday
                for (var i in data.hostname_two.tuesday.value) {
                    hostname_two_tuesday.push(data.hostname_two.tuesday.value[i] + ", ");
                }

                // wednesday
                for (var i in data.hostname_two.wednesday.value) {
                    hostname_two_wednesday.push(data.hostname_two.wednesday.value[i] + ", ");
                }

                // thursday
                for (var i in data.hostname_two.thursday.value) {
                    hostname_two_thursday.push(data.hostname_two.thursday.value[i] + ", ");
                }

                // friday
                for (var i in data.hostname_two.friday.value) {
                    hostname_two_friday.push(data.hostname_two.friday.value[i] + ", ");
                }



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
                
                var data = {
                    labels: [hours[0], hours[1], hours[2], hours[3], hours[4]],
                    datasets: [
                        {
                            label: hostname_one,
                            fillColor: "rgba(52, 152, 219,1)",
                            strokeColor: "rgba(52, 152, 219,1)",
                            pointColor: "rgba(52, 152, 219,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(220,220,220,1)",
                            data: [9, 10, 11, 12, 1, 2, 3, 4, 5] // 9, 10, 11am; 12, 1, 2, 3, 4, 5pm
                        },
                        {
                            label: hostname_two,
                            fillColor: "rgba(242,38,19, 0.9)",
                            strokeColor: "rgba(242,38,19, 0.9)",
                            pointColor: "rgba(242,38,19,1)",
                            pointStrokeColor: "#fff",
                            pointHighlightFill: "#fff",
                            pointHighlightStroke: "rgba(151,187,205,1)",
                            data: [9, 10, 11, 12, 1, 2, 3, 4, 5] // 9, 10, 11am; 12, 1, 2, 3, 4, 5pm
                        }
                    ]
                };
                
                // render chart
                var ctx = document.getElementById("temperatureOverview").getContext("2d");
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
    return new TemperatureOverview();
});