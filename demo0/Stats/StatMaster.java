/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oobai.demo0.Stats;

import java.util.ArrayList;

/**
 *
 * @author DvN
 */

//this holds our data!
public class StatMaster {
    ArrayList<String> logItems = new ArrayList<String>();
    String testKey = "No Key Given";
    
    //this tracks stats for rules being fired
    public int[] rules = null;
    public int nRules = 0;//number of rules
    
    
    
    public void initialize_Stat_Master(String key){
        testKey = key;
        logItems.add(testKey);
    }//end initialize
    
    public void log(String include){
        logItems.add(include);
        
    }//end include
    
    public void print_log(){
         System.out.println("\n-----------------");
         System.out.println("-Log-------------");
       if(logItems.isEmpty()){
          
           System.out.println("Log is Empty");
        
       }else{
           
           while(! logItems.isEmpty()){
               System.out.println(logItems.get(0));
               logItems.remove(0);
           }
       }//end else full empty log
           System.out.println("-----------------");
        
        
    }//

    //this creates the array of rules for stat purposes
	public void synchRuleStats(int nR) {
	nRules = nR;
	
		rules = new int[nRules];
		
	}//end function synch rule stats
    
	
	
	
	
    
}//end class StatMaster
