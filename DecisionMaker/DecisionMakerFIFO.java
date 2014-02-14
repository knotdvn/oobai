/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oobai.DecisionMaker;

import java.util.ArrayList;
import oobai.Oob.Oob;
import oobai.Rules.Rules;
import oobai.Stats.StatMaster;

/**
 *
 * @author DvN
 */

//this is basically a SCHEDULER
//It is propogated with a list of items
//then it has to determine which items get executed.
public class DecisionMakerFIFO {
    //this one is a FIFO
    
    //actions are added
    public ArrayList<Integer> applicableActions = new ArrayList();//
    
    //rule list
    public Rules ruler = null;
    
    //StatMaster
    public StatMaster statMaster = null;
    
    
    
    public void make_Think_Run(Oob oob){
        //while not empty
        boolean executeP = !(applicableActions.isEmpty());
        
        while(executeP){
            //grab the last added = size -1
            int ruleX =  ( applicableActions.get( applicableActions.size() - 1) ) ;
            
            ruler.run_Action(oob, ruleX);
            executeP = false;
            
            
            
        }//end make_think_run
       
        
        
        
        
    }//end method make_Think_Run
    
    
}//end class DecisionMaker
