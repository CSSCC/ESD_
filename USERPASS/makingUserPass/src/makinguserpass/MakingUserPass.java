/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makinguserpass;

/**
 *
 * @author t2-lings
 */
public class MakingUserPass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //****************MAKING USERNAME*******************
        
        //Initialising
        String testName = "Jelly Belly";
        char firstChar;
        String username = "";
        String[] str1 = new String[2];
        
        //Getting first char of first name
        firstChar = testName.charAt(0);
        username = username + firstChar;
        
        //Splitting Name to retrieve surname
        str1 = testName.split(" ");
        username = username + "-" + str1[(str1.length) - 1];
        
        //Changing username to lower case
        username = username.toLowerCase();
        
        //Outputting
        System.out.println(username);
        System.out.println("");
        
        //******************MAKING PASSWORD*********************
        
        //Initialising
        String testDOB = "02-12-1968";
        String pass = "";
        String[] str2 = new String[3];
        
        //Splitting into temporary String array
        str2 = testDOB.split("-");
        
        //Discarding the first to digits of year of birth
        String temp = "";                   
        temp = temp + str2[2].charAt(2) + str2[2].charAt(3);
        str2[2] = temp;
        
        //building password from temp array
        for(int i=0;i<str2.length;i++){     
            pass = pass + str2[i];
        }
        
        //output
        System.out.println(pass);           
        
    }
    
}
