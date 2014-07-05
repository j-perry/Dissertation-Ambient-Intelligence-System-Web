

/* 
 * The main JavaScript file for our Ambient Intelligence web application.
 * All code has been written with reusability in mind.
 */

// when the view has loaded
jQuery(document).ready(function() {

    var path = "http://tomcat.inf.susx.ac.uk:8080/jp373/js/overview_temperature.json";
    var values = "";

    // get JSON values
    $.getJSON(path, function(data) {

        for(var i in data.overviewtemperature) {
                values += data.overviewtemperature[i] + ", ";
        }
        
        // remove the comma on the end of the variable
        values = values.substr(0, values.length -2); 
                
        console.log(values);
        document.getElementById("test").innerHTML = values;
        
    });

});