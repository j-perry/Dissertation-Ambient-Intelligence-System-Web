/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 * 
 * Description: JavaScript code uses the RequireJS framework for dynamically loading 
 *              relevant classes.
 * 
 */
requirejs.config({
    baseUrl: '../js/',
    paths: {
        app: '/app',
        tabify: '/jquery/tabify/jquery.tabify.js'
    }
});

// application logic is loaded here
// NB: keep the path it is currently set at
requirejs(['../AmI_System__Web_/js/app/main']);
//requirejs(['../jp373/js/app/main']);