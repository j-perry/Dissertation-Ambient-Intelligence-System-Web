/*
 * MSc Advanced Computer Science, University of Sussex
 * Jonathan Perry
 * Candidate No. 102235
 */
package ami.web.core.intelligence;

// local libraries
import ami.web.core.models.client.DataBase;
import java.util.ArrayList;

/**
 * 
 * @author Jonathan Perry
 */
public class ExperienceBank {
    
    private RuleBase ruleBase;
    private ArrayList<DataBase> initialContext;
    private ArrayList<DataBase> monitoringContext;
    
    public ExperienceBank() {
        initialContext = new ArrayList<DataBase>();
        monitoringContext = new ArrayList<DataBase>();
    }
    
    /**
     * Merges and creates a balanced contextual models, created by entry results stored in
     * tables InitialContext and MonitoringContext
     * @param initialContext
     * @param monitoringContext
     * @return 
     */
    public ArrayList<DataBase> create(ArrayList<DataBase> initialContext, ArrayList<DataBase> monitoringContext) {
        
        // we need to ensure that our search space is as coherant as possible to reduce
        // Big-O time analysis, since we are computing on a web based architecture
        //
        // We'll need to start by comparing values stored in our monitoring context against those
        // stored in our initial context
        // 
        // This will help us create a rule base, say, for instance, Friday and return
        // an overall context with data that is soundly accurate, with the ability to respond to events
        // that could have been regarded as uncertain or unjust (intelligence).
        ruleBase = new RuleBase();
        ruleBase.createRules(initialContext);
        
        // for each entry in our monitoring context
        // parse it to our rule base
        for(DataBase entry : monitoringContext) {
            ruleBase.lookup(entry);
        }
        
        // return a model of our final context
        ArrayList<DataBase> overallContext = ruleBase.overallContext();
        
        return overallContext;
    }    
}