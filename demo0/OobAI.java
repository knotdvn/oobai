/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oobai.demo0;

import oobai.demo0.Stats.StatMaster;



/**
 *AI Project Demo Sys Interface
 * @author DvN
 */
public class OobAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Load StatMaster
        StatMaster statMaster = new StatMaster();
        statMaster.initialize_Stat_Master("Debugging");
        
        
        System.out.println("Demo1");
        
        OobSystem oS = new OobSystem();
        oS.statMaster = statMaster;
 
        oS.initialize_System(10);
        oS.print_All_Living_Oobs();
        System.out.println("Turning Clock");
        oS.turn_Clock_X(5000);
        statMaster.print_log();
        
        
       
        
        
        
    }//end main method
}//end class OobAi
