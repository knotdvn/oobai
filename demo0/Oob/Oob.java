/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oobai.Oob;

import java.util.Random;

import oobai.DecisionMaker.DecisionMakerFIFO;
import oobai.Rules.Rules;
import oobai.Stats.StatMaster;

/**
 *
 * @author DvN
 */
public class Oob {
    //for stats
    public StatMaster statMaster = null;
    
    //Rule Object
    public Rules ruler = null;
    
    //Decision Maker
    public DecisionMakerFIFO dM = new DecisionMakerFIFO();
    
    //--------------------------------
    //Facticity For Oob Paramaters 
    //--------------------------------
    
    //Name
    public String name = "HisImage";
    public int age = 0;
    
    //food
    public int foodAmt = 0; //How much food they have
    public int nutrition = 0; // How healthy an oob is
    
    //fighting
    public int fight = 0;
    
    //social
    public int compel = 0; 
    
    //finding stuff
    public int finding = 0;
    
    //list of "sensors"
    //This list represents a T/F array whcih scans through 
    //the rules an Oob has access too.
   
    //sensors to applicability of rules
    public boolean[] sensor = null;
    
    
    //Targets
    public Oob target = null;
    
    Random rNg = new Random();
    
    //How do we Set Rules
    public void setRulesAllTrue(){
        sensor = new boolean[ruler.nRules];
        for(int i = 0; i < ruler.nRules; i++){
            sensor[i] = true;
            
            
            
        }//end for NRules
        
    }//end method setRules
    
    
    
    //How do we Set Rules Randomly
    //this ensure that not all oobs
    //have access to the same rules.
    public void setRulesAllRandom(){
        sensor = new boolean[ruler.nRules];
        
        int chance = 0;
        for(int i = 0; i < ruler.nRules; i++){
        	
        	chance = rNg.nextInt(10);
        	
        	if(chance<5){
        		sensor[i]=false;
        	}else{
        	
            sensor[i] = true;
            
        	}//end else rand choice
            
        }//end for NRules
        
    }//end method setRules
    
    
    //Oob system runs this method
    public void live_Breathe_Activate(){
        
        
        for(int i = 0; i < sensor.length;i++){
            
            //If we have sensor I
            if(sensor[i]){
                //if sensor reports TRUE
                if(ruler.call_Applicable(this, i)){
                    //Add Response to Decision Maker
                    dM.applicableActions.add(i);
                }//end is applicable true
            }//end is i true
        }//end for all sensore
        
        //Decision Maker has actions on it? ACT!!!
        dM.make_Think_Run(this);
        //check rule sensors
        //add to decision maker rack
        //call decision maker
        //exit
        
        
    }//end method Live Breathe Activate
    
    
    public void print_Oob(){
        System.out.println("\n-----------------");
        System.out.println(  "-Oob-------------");
        System.out.println("-Name: " + this.name);
        System.out.println("-Age: " + this.age);
        System.out.println("-Nutrition: " + this.nutrition);
        System.out.println("-Food Amount: " + this.foodAmt);
        System.out.println("-Fighting: " + this.fight);
        System.out.println("-Finding: " + this.finding);
        System.out.println("-Compel: " + this.compel);
        
        if(this.target ==  null){
            System.out.println("-Target: NULL");
        }else{
        System.out.println("-Target: " + this.target.name);
        }
        System.out.println(  "-----------------");
        
        
    }//end print Oob;
    
    
    public String toDNAString(){
    	String dna = "";
    	
    	dna = "()~~[ " + name + "::-Fight-<" + fight + ">-Compel-<" + compel + ">-Finding-<" + finding + ">-";
    	for (int i = 0; i< sensor.length  ; i++){
    	dna = dna + "R" + i + "-<" + sensor[i] + ">-";
    	}
    	dna = dna + "--]";
    	return dna;
    }//end toDNAString
    
}//end class Oob

