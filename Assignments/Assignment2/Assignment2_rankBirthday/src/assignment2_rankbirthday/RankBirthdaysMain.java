/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_rankbirthday;

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 * Assignment 2
 * @author k00223361 Vincent Lee
 * helpers: BDayCheck - to validate dates, getDay and suffix for day
 *          ParseBirthDayData - reads 'days.text' as int tokens. 
 */
public class RankBirthdaysMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ParseBirthdayData.parseBirthdaysFromFile();
        String userInDayDD ="";
        String userInMonthMM ="";
        String dateString ="";
        
        while (! ( userInDayDD.equalsIgnoreCase("quit") )    ) {
            userInDayDD = JOptionPane.showInputDialog(null, "Please enter date in the form \'dd\' : ", "to Exit: type \'quit\'", JOptionPane.INFORMATION_MESSAGE );
            System.out.println("You entered: " +userInDayDD);

            userInMonthMM = JOptionPane.showInputDialog("Please enter date in the form \'mm\' : ");
            System.out.println("You entered: " +userInMonthMM);

            dateString = (userInDayDD+"/"+userInMonthMM);
            System.out.println("DateString DD/MM is : " + dateString);

            BDayCheck.isValidDate(dateString);
            System.out.println( "Date: " + dateString + " is valid? : " + BDayCheck.isValidDate(dateString) );
            
            if( BDayCheck.isValidDate(dateString) == true){
                //BDayCheck.getDayOfYear(dateString);
                System.out.println( "Day of Year: " + dateString + " " + BDayCheck.getDayOfYear(dateString) );
                JOptionPane.showMessageDialog(null, "Entered Date : " + dateString);
            }
            
            
            

        
            if (  (userInDayDD.equalsIgnoreCase("quit")) | (userInMonthMM.equalsIgnoreCase("quit")) )
            break;
        }
    }// end main
    
}//end class
