/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
var path = '../jp373/js/app/views/Movement';
//var path = 'http://localhost:8080/AmI_System__Web_/js/app/views/Movement.js';

define(path, function(movement) {
    function Movement() {

        /**
         * Initialise tabs in view
         */
        this.tabify = function() {
            $('#tabs').tabify();
        };

        /**
         * Displays an overview of the room movement (re-used from Overview.js)
         */
        this.displayOverview = function() {
            require(['../jp373/js/app/views/movement/MovementOverview'], function(movementOverview) {
//            require(['http://localhost:8080/AmI_System__Web_/js/app/views/movement/MovementOverview.js'], function(movementOverview) {
                movementOverview.display();
            });
        };

        /*
         * Displays weekdays
         */
        this.displayWeekdays = function() {
            console.log("displayWeekdays()");
            
            require(['../jp373/js/app/views/movement/Weekdays'], function(movementWeekdays) {
//            require(['http://localhost:8080/AmI_System__Web_/js/app/views/movement/Weekdays.js'], function(movementWeekdays) {
                movementWeekdays.displaySaturday();
                movementWeekdays.displaySunday();
                movementWeekdays.displayMonday();
                movementWeekdays.displayTuesday();
                movementWeekdays.displayWednesday();
                movementWeekdays.displayThursday();
                movementWeekdays.displayFriday();
            });
        };

    }

    // returning an instanceof this object is essential, otherwise it'll
    // display a TypeError message
    return new Movement();
});