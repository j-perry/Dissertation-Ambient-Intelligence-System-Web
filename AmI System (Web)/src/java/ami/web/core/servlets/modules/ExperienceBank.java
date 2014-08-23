/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.servlets.modules;

// libraries
import ami.web.core.models.client.DataBase;

// Java APIs
import java.util.ArrayList;

/**
 * 
 * @author Jonathan Perry
 */
public class ExperienceBank {
    
    private RuleBase ruleBank;
    
    public ExperienceBank() {
        ruleBank = new RuleBase();
    }
        
    /**
     * Merges and creates a balanced contexts, created by entry results stored in
     * tables InitialContextTable and MonitoringContextTable
     */
    public ArrayList<DataBase> merge(ArrayList<DataBase> initialContext, ArrayList<DataBase> monitoringContext) {
        ArrayList<DataBase> overallContext = new ArrayList<DataBase>();
        
        
        return overallContext;
    }
    
}
