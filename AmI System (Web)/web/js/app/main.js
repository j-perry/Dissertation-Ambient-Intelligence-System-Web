/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 * 
 * Desciption: The main JavaScript file for our Ambient Intelligence web application.
 *             All code has been written with reusability in mind.
 *             
 */

// when the view has loaded
jQuery(document).ready(function() {
        
    /*      Paths (views)
    *******************************/ 
    var index = "http://tomcat.inf.susx.ac.uk:8080/jp373/";
    var overview = "http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=overview";
    var temperature = "http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=temperature";
    var movement = "http://tomcat.inf.susx.ac.uk:8080/jp373/View?type=movement";
    
    // for local development
//    var index = "http://localhost:8080/AmI_System__Web_/";
//    var overview = "http://localhost:8080/AmI_System__Web_/View?type=overview";
//    var temperature = "http://localhost:8080/AmI_System__Web_/View?type=temperature";
//    var movement = "http://localhost:8080/AmI_System__Web_/View?type=movement";
    
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
        case movement:
            init_movement();
            break;
        default:
            break;
    }       
});

/**
 * Initialises JavaScript content for the index view
 */
function init_index() {
    require(['../jp373/js/app/views/Index'], function(index) {
//    require(['http://localhost:8080/AmI_System__Web_/js/app/views/Index.js'], function(index) {
        index.setupAll();
    });
}

/**
 * Initialises JavaScript content for the overview view
 */
function init_overview() {
    require(['../jp373/js/app/views/Overview'], function(overview) {
//    require(['http://localhost:8080/AmI_System__Web_/js/app/views/Overview.js'], function(overview) {
        overview.display();
        overview.tabify();
    });
}

/**
 * Initialises JavaScript content for the temperature view
 */
function init_temperature() {
    require(['../jp373/js/app/views/Temperature'], function(temperature) {
//    require(['http://localhost:8080/AmI_System__Web_/js/app/views/Temperature.js'], function(temperature) {
        temperature.tabify();
        temperature.displayOverview();
//        temperature.displayWeekdays();
//        temperature.displayWeekdaySaturday();
        temperature.displayWeekdaySunday();
        
    });
}

/**
 * Initialises JavaScript content for the movement view
 */
function init_movement() {
    require(['../jp373/js/app/views/Movement'], function(movement) {
//    require(['http://localhost:8080/AmI_System__Web_/js/app/views/Movement.js'], function(movement) {
        movement.tabify();
        movement.displayOverview();
        movement.displayWeekdays();
    });
}