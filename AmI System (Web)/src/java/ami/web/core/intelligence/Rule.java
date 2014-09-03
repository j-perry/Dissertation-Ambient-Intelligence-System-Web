/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.intelligence;

import java.util.Stack;

/**
 *
 * @author Jonathan Perry
 */
public class Rule {
    
    private Stack<Integer> average;
    
    public Rule() {
        average = new Stack<Integer>();
    }
    
    public void add(int avg) {
        average.add(avg);
    }
    
    public int get() {
        return average.peek();
    }
    
    public void remove() {
        average.remove(0);
    }
    
    public void update(int newAverage) {
        average.add(newAverage);
    }
    
}
