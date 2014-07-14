

/* 
 * The main JavaScript file for our Ambient Intelligence web application.
 * All code has been written with reusability in mind.
 */

// when the view has loaded
jQuery(document).ready(function() {
    
    /*      Paths (views)
    *******************************/ 
    var index = "http://tomcat.inf.susx.ac.uk:8080/jp373/";
    var overview = "http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=overview";
    var temperature = "http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=temperature";
    var atmosphere = "http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=atmosphere";
    var motion = "http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=motion";
    var light = "http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=light";
    
    // get the current URL
    var url = document.URL;
    
    console.log(url);
    
    // ok, to reduce latency and improve load times, we need to only load the data we need
    // we'll do this by validating which view we're on, and display the relevant content for it
    switch(url) {
        case index:
            init_index();
            break;
        case overview:
            init_overview();
            break;
        case temperature:
            init_temperature();
            break;
        case atmosphere:
            init_atmosphere();
            break;
        case motion:
            init_motion();
            break;
        case light:
            init_light();
            break;
        default:
            break;
    }       
});

/**
 * 
 * @returns {undefined}
 */
function init_index() {
    // display the clock (time)
    setInterval(function() {
        updateTime();
    }, 0);
}

/**
 * 
 * @returns {undefined}
 */
function init_overview() {
    displayLinecharts();
}

/**
 * 
 * @returns {undefined}
 */
function init_temperature() {
    
}

/**
 * 
 * @returns {undefined}
 */
function init_atmosphere() {
    
}

/**
 * 
 * @returns {undefined}
 */
function init_motion() {
    
}

/**
 * 
 * @returns {undefined}
 */
function init_light() {
    
}



/**
 * Displays the current time (hour:minutes:seconds)
 */
function updateTime() {
    require(['../jp373/js/app/Time'], function(time) {
        document.getElementById("clock-time").innerHTML = time.getFullGMT();
    });
}

/**
 * 
 */
function displayLinecharts() {
    var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/overview_temperature.json";
    var values = "";
    var date = "";
    var time = "";
    var weekdays = new Array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
    
    // get JSON values
    $.getJSON(path, function(data) {

        // values
        for (var i in data.value) {
            values += data.value[i] + ", ";
        }

        // remove the comma on the end of the variable
        values = values.substr(0, values.length - 2);

        // date
        for (var i in data.date) {
            if (i == 20)
                break;
            else
                date += data.date[i] + ", ";
        }

        date = date.substr(0, date.length - 2);

        // time
        for (var i in data.time) {
            if (i == 5)
                break;
            else
                time += "\"" + data.time[i] + "\"" + ", ";
        }

        time = time.substr(0, time.length - 2);
    });

    var data = {
        labels: [weekdays[0], weekdays[1], weekdays[2], weekdays[3], weekdays[4]],
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(52, 152, 219,1)",
                strokeColor: "rgba(52, 152, 219,1)",
                pointColor: "rgba(52, 152, 219,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: [29, 31, 29, 30, 31]
            },
            {
                label: "My Second dataset",
                fillColor: "rgba(242,38,19, 0.9)",
                strokeColor: "rgba(242,38,19, 0.9)",
                pointColor: "rgba(242,38,19,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(151,187,205,1)",
                data: [28, 27, 31, 29, 30]
            }
        ]
    };

    // chart
    var ctx = document.getElementById("myChart").getContext("2d");
    var myLineChart = new Chart(ctx).Line(data, {
        bezierCurve: false,
        scaleShowGridLines: false,
        scaleGridLineColor: "rgba(0,0,0, 1)"
    });

    var ctx = document.getElementById("myChart2").getContext("2d");
    var myLineChart = new Chart(ctx).Line(data, {
        bezierCurve: false,
        scaleShowGridLines: false,
        scaleGridLineColor: "rgba(0,0,0, 1)"
    });

    var ctx = document.getElementById("myChart3").getContext("2d");
    var myLineChart = new Chart(ctx).Line(data, {
        bezierCurve: false,
        scaleShowGridLines: false,
        scaleGridLineColor: "rgba(0,0,0, 1)"
    });

    var ctx = document.getElementById("myChart4").getContext("2d");
    var myLineChart = new Chart(ctx).Line(data, {
        bezierCurve: false,
        scaleShowGridLines: false,
        scaleGridLineColor: "rgba(0,0,0, 1)"
    });
}