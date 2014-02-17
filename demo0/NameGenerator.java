/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oobai.demo0;

import java.util.Random;



/**
 *
 * @author Deven Pitcher
 */
public class NameGenerator {

    private String alphabet = "abcdefghijklmnoprstuvwxyz";
    private String vowels = "aeiouy";
    private String consonants = "bcdfghjklmnpqurstvwxz";

     //chance that names breakdown like this 
    private String specialEndingLetters = "ck rm lm zz ch ll tt rn nt st th ms ns ts lp";


    public String createName(){
       
        Random gen = new Random();
        Boolean isVowel = false;

       int x = gen.nextInt(25);
     

       String name = "" + alphabet.charAt(x);
       name = name.toUpperCase();

       

       if(name.charAt(0) == 'A'){
           isVowel = true;
       }

       if(name.charAt(0) == 'E'){
           isVowel = true;
       }

       if(name.charAt(0) == 'I'){
           isVowel = true;
       }

        if(name.charAt(0) == 'O'){
           isVowel = true;
       }


       if(name.charAt(0) == 'U'){
           isVowel = true;
       }

     
       if(name.charAt(0) == 'Y'){
           isVowel = true;
       }



       int nameLength = gen.nextInt(4) + 3;

       while(nameLength > 0){
           if(isVowel){
               //then it needs a consonant
              int rc = gen.nextInt(21);
               name = name + consonants.charAt(rc);
                isVowel = false;
                 } else{
                 //else it needs a vowel


               int rv = gen.nextInt(6);
                name = name + vowels.charAt(rv);
                isVowel = true;
               

           }//end is vowel else
           

           nameLength--;
           if(nameLength < 3 && isVowel){
               int endX = gen.nextInt(5);
               if(endX <2){
                   
                   int plz = gen.nextInt(15) * 3;
                   name = name + specialEndingLetters.charAt(plz) + specialEndingLetters.charAt(plz+1);
                   nameLength = 0;
               }
               
           }//end if special ending
           
       }//end name length

      




      return name;
    }//end get name





}
