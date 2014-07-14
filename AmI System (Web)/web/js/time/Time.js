/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function Time() {
    
    var d;
    
    /**
     * 
     * @returns {undefined}
     */
    this.getHour = function() {
        d = new Date();
        return d.getDay();
    };
    
    /**
     * 
     * @returns {undefined}
     */
    this.getMinutes = function() {
        d = new Date();
        return d.getMinutes();
    };
    
    /**
     * 
     * @returns {undefined}
     */
    this.getSeconds = function() {
        d = new Date();
        return d.getSeconds();
    };
    
    /**
     * 
     * @returns {String}
     */
    this.getFullGMT = function() {
        return new String(getHour() + ":" +
                          getMinutes() + ":" + 
                          getSeconds() );
    };
    
    /**
     * 
     * @param {type} i
     * @returns {undefined}
     */
    this.format = function(i) {
        if(i < 10) {
            return "0" + i;
        }
        else {
            return i;
        }
    };
    
};