/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
requirejs.config({
    baseUrl: 'js/',
    paths: {
        app: '../app'
    }
});

// application logic is loaded here
// NB: keep the path it is currently set at
requirejs(['../js/app/main']);