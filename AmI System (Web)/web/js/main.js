

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
            values += data.value[i] + ", ";
        }

        // remove the comma on the end of the variable
        values = values.substr(0, values.length - 2);

        // date
        for (var i in data.date) {
            date += data.date[i] + ", ";
        }
        
        date = date.substr(0, date.length - 2);

        // time
        for (var i in data.time) {
            time += data.time[i] + ", ";
        }
        
        time = time.substr(0, time.length - 2);

        console.log(values);
        document.getElementById("test").innerHTML = values;

    });

});