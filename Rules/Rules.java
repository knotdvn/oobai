/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oobai.Rules;

import java.util.Random;
import oobai.Oob.Oob;
import oobai.Stats.StatMaster;

/**
 *
 * @author DvN
 */

//A rules object contains a listing of
//all of the ACTIONS in rule form
//which determing what an Oob will do
//given a situation
public class Rules {
    public StatMaster statMaster = null;
    public int nRules = 2; //how many rules are there right now 0
    public Random rndG = new Random(141990);//My Sisters birthday
    
    
    
    //this function takes an Integer and calls its
    //[IF] counterpart, if true, it returns the Action #
    //if false it returns -1
    public boolean call_Applicable(Oob oob, int ruleX){
        boolean fired = false;
        
        switch(ruleX){
            case 0: fired = ifHungryANDHasFood(oob)  ; break;
            
            case 1: fired = ifLowFood(oob); break;
                
            default: fired = false; break;
                
        }//end switch
        
        
       
        return fired;
    }//end call applicable
    
    //this function takes an Integer and runs its
    //[THEN] counterpart, 
    public void run_Action(Oob oob, int ruleX){
        
         switch(ruleX){
            case 0: thenEat(oob)  ; break;
              
            case 1: thenFindFood(oob); break;
                
            default: ; break;
                
        }//end switch
        
       
    }//end method run Action
    
    //---------------------------------------------------
    //Rule 1----------------------------------------------
    
    //if hungryhasfood
    private Boolean ifHungryANDHasFood(Oob oob){
        if(oob.nutrition<50 && oob.foodAmt > 0){
            return true;
        }else{
            return false;
        }
        
    }//end ifHungry
    
    private void thenEat(Oob oob){
        
        //if you have little food, eat it all, now have none
        if(oob.foodAmt< 5){
            oob.nutrition = oob.nutrition + oob.foodAmt;
            oob.foodAmt = 0;
            
        }else{
            //eat 10, gain 10 nutrition
            oob.nutrition = oob.nutrition + 5;
            oob.foodAmt = oob.foodAmt -5;
        }//end else littl/lot food
        
        statMaster.log("Oob: " + oob.name + " has eaten!");
        
    }//end thenEat

 //Rule1----------------------------------------------------------------
 //---------------------------------------------------------------------
 
    
 //---------------------------------------------------------------------
//Rule2----------------------------------------------------------------
    
    private boolean ifLowFood(Oob oob) {
        if(oob.foodAmt < 50){
            return true;
        }else{
            return false;
        } //end if else
    }//end ifLowFood
    
    
    private void thenFindFood(Oob oob) {
        
        //The Oobs finding skill determines if they foraged for food
        //did the Oob find food ?
        if(oob.finding >= rndG.nextInt(99)){
            oob.foodAmt =oob.foodAmt + 10;
            statMaster.log("Oob: " + oob.name + " has found food!");
        }
        
    }//end then find food
    
    
    
  //Rule2----------------------------------------------------------------
 //---------------------------------------------------------------------   
    
    
}//end class Rules
