/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oobai.Stats;

import java.util.ArrayList;

/**
 *
 * @author DvN
 */

//this holds our data!
public class StatMaster {
    ArrayList<String> logItems = new ArrayList();
    String testKey = "No Key Given";
    
    
    
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
    
    
}//end class StatMaster
