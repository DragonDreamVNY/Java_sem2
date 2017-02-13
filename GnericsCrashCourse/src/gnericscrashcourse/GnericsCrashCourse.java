/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnericscrashcourse;

import java.util.ArrayList;
import java.lang.String;
/**
 *
 * @author DragonDream
 */
public class GnericsCrashCourse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // List should most of the time store the same items of same type
        ArrayList<String> List = new ArrayList();
        
        List.add("Alan");
        
        List.add("Ryan");
        /*
        for (String value : List){
            System.out.println(value);
        }
        */
        
        
        for (Object obj : List){
            
            String s = String.copyValueOf(String) obj;
            System.out.println("length is " + s.length());
        
        }
        
    }//end main
    
}//end class
