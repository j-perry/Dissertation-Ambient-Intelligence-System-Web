/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function Time() {
    
    var d;
    
    /**
     * 
     * @returns {Integer}
     */
    this.getHour = function() {
        d = new Date();
        return d.getDay();
    };
    
    /**
     * 
     * @returns {Integer}
     */
    this.getMinutes = function() {
        d = new Date();
        return d.getMinutes();
    };
    
    /**
     * 
     * @returns {Integer}
     */
    this.getSeconds = function() {
        d = new Date();
        return d.getSeconds();
    };
    
    /**
     * 
     * @returns {String}
     */
    this.dayPeriod = function() {
        d = new Date();
        
        if(d.getHours() < 12) {
            return "AM";
        }
        else {
            return "PM";
        }
    };
    
    /**
     * 
     * @returns {String}
     */
    this.getFullGMT = function() {
        return new String(getHour() + ":" +
                          getMinutes() + ":" + 
                          getSeconds() +
                          dayPeriod() );
    };
    
    /**
     * 
     * @param {type} i
     * @returns {String}
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