

/* 
 * The main JavaScript file for our Ambient Intelligence web application.
 * All code has been written with reusability in mind.
 */

// when the view has loaded
jQuery(document).ready(function() {

    var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/overview_temperature.json";
    var values = "";
    var date = "";
    var time = "";

    // get JSON values
    $.getJSON(path, function(data) {

        // values
        for (var i in data.value) {
            if(i == 20)
                break;
            else            
                values += data.value[i] + ", ";
        }

        // remove the comma on the end of the variable
        values = values.substr(0, values.length - 2);

        // date
        for (var i in data.date) {
            if(i == 20)
                break;
            else 
                date += data.date[i] + ", ";
        }
        
        date = date.substr(0, date.length - 2);

        // time
        for (var i in data.time) {
            if(i == 20)
                break;
            else
                time += data.time[i] + ", ";
        }
        
        time = time.substr(0, time.length - 2);

        console.log(values);
        //document.getElementById("test").innerHTML = values;
        
        var data = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(52, 152, 219,1)",
                    strokeColor: "rgba(52, 152, 219,1)",
                    pointColor: "rgba(52, 152, 219,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 80, 81, 56, 55, 40]
                },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(242,38,19, 0.9)",
                    strokeColor: "rgba(242,38,19, 0.9)",
                    pointColor: "rgba(242,38,19,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(151,187,205,1)",
                    data: [28, 48, 40, 19, 86, 27, 90]
                }
            ]
        };
        
        // chart
        var ctx = document.getElementById("myChart").getContext("2d");
        var myLineChart = new Chart(ctx).Line(data, {
            bezierCurve: false
        });

        var ctx = document.getElementById("myChart2").getContext("2d");
        var myLineChart = new Chart(ctx).Line(data, {
            bezierCurve: false
        });

        var ctx = document.getElementById("myChart3").getContext("2d");
        var myLineChart = new Chart(ctx).Line(data, {
            bezierCurve: false
        });
        
    });

});