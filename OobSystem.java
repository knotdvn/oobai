/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oobai;

import oobai.Oob.Oob;
import java.util.ArrayList;
import java.util.Random;
import oobai.DecisionMaker.DecisionMakerFIFO;
import oobai.Rules.Rules;
import oobai.Stats.StatMaster;
/**
 *
 * @author DvN
 */
public class OobSystem {
    
    //The Oobs
    public ArrayList<Oob> allLivingOobs = new ArrayList();
    public ArrayList<Oob> allDeadOobs = new ArrayList();
    
    //Stat Master
    public StatMaster statMaster = null;
    
    public Rules ruler = new Rules();
    
    
    
    
    
    
    
    
    //just for this class
    Random rndG = new Random(721987); //my birthday
    NameGenerator nameG = new NameGenerator();
    
    
    //TIME
    //Term X, when to shut down
    public int termX = 0;
    public int clock = 0; //this goes from 0 to 365
    public Boolean clockON = false;
    
    public int years = 0; //this goes from 1 to 100
    public int century = 0;  //this goes from 1 to x
    
    
    
    //This runs first,
    //the paramter is the int N number of oobs to start with
    public void initialize_System(int nOobs){
        //give rules access to statMaster
        ruler.statMaster = statMaster;
        
        
        Oob theAncestor = null;
        
        
        //create nOobs number of Oobs
        for(int i = 0; i < nOobs; i++){
            theAncestor = new Oob();
            theAncestor.age = 0;
            theAncestor.name = nameG.createName();
            
            //intial Oobs are generated 
            //with random facticity 
            
            theAncestor.compel = rndG.nextInt(80) +20;
            theAncestor.fight = rndG.nextInt(80) + 20;
            theAncestor.finding = rndG.nextInt(80) + 20;
            theAncestor.foodAmt = rndG.nextInt(80) + 20;
            theAncestor.nutrition = rndG.nextInt(80) + 20;
            
            //Add Modules------------------------------------
            //Add Stat Module
            theAncestor.statMaster = statMaster;
            
            //add Rules Module
            theAncestor.ruler = ruler;
            theAncestor.setRulesAllTrue();
            
            //add Decision Making Module
            theAncestor.dM = new DecisionMakerFIFO();
            theAncestor.dM.ruler = ruler;
            theAncestor.dM.statMaster = statMaster;
            
            
            
            //add to List
            allLivingOobs.add(theAncestor);
          
            
            theAncestor = null;
            
            
            
        }//end for i to Noobs
        
        
    }//end method initialize System
    
    //set the terminating X
    public void set_Terminating_X(int x){
        termX = x;
    }//end terminating X 
    
    public void turn_Clock_X(int x){
        clockON = true;
        
        for(int i = 0; i <=x; i++){
            if(clockON){
           turn_Clock_One_Cycle(); 
            }//end clockON
            
        }//end for X cycles
        
    }//end method turn Clock X
    
    
    public void turn_Clock_One_Cycle(){
        Boolean ageUP = false;
        
        //increment the clock
        //lets keep time
        clock++;
          if(clock == 365){
                clock = 0;
                years++;
                ageUP = true;
                statMaster.log("-----------------------------");
                statMaster.log("Century: " + century + " Year: " + years + " Clock: " + clock);
                statMaster.log("-----------------------------");
            }//turn the clock
          if(years == 100){
              century++;
              years = 0;
              statMaster.log("-----------------------------");
                statMaster.log("Century: " + century + " Year: " + years + " Clock: " + clock);
                statMaster.log("-----------------------------");
          }
        
        //time keeping is done
        
        
         if(allLivingOobs.isEmpty()){
            System.out.println("\n--------------");
            System.out.println("-Oob System Run:");
            System.out.println("-NULL Oobs");
            System.out.println("--------------");
            clockON = false;
             System.out.println("No Oobs Alive, Clocking OFF");
         }else{
          
             
             //tout le monde est une victim
            Oob victim = null; 
            int oobSize = allLivingOobs.size();
           for(int i = 0; i < allLivingOobs.size(); i++){
            
            victim = allLivingOobs.get(i); //grab the victim
            //has it been a year? if so AGE!!
            if(ageUP){
              victim.age = victim.age + 1;     
          }//end ageUP
            
            //the RULES THAT GOVERN AN OOBS LIFE!!
            //if an Oob starts with nutrition 4 or lower he dies!
          if(victim.nutrition < 5){
              allDeadOobs.add(victim);
              allLivingOobs.remove(i);
              statMaster.log("Century: " + century + " Year: " + years + 
                      " Clock: " + clock + " Oob: " + victim.name + " has perished. -XXX");
              
              i--;//decrement the count so we don't miss an Oob
              oobSize--; //decrement the size so we don't out of bounds
          }else{  
            //If the Oob is not dead
              //his life is exhausted an amount
          victim.nutrition = victim.nutrition - 5;
          
          
          victim.live_Breathe_Activate();
            
          
          //replace the Oob with one we modified
          allLivingOobs.set(i, victim);
          }//end else not dead
          
          victim = null;
        }//for all Living Oobs
        }//end else empty
        
        ageUP = false;
    }//end turn clock one cycle
    
    
    
    
    public void print_All_Living_Oobs(){
        if(allLivingOobs.isEmpty()){
            System.out.println("\n--------------");
            System.out.println("-All Living Oobs:");
            System.out.println("-NULL");
            System.out.println("--------------");
        }else{
          
        for(int i = 0; i < allLivingOobs.size(); i++){
            
            allLivingOobs.get(i).print_Oob();
            
        }//for all Living Oobs
        }//end else empty
    }//end print all living oobs
    
    
    
    
}//end class OobSystem