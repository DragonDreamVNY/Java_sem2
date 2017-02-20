/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsing_ex01;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javafx.event.WeakEventHandler;
/**
 *
 * @author k00223361 Vincent Lee
 * Parsing Exercise 1 (homework) - Weather Data
 */
public class Parsing_ex01 {

    /**
     * @param args the command line arguments
     */
     /**Main method*/
    public static void main(String[] args) {
        //Declare File Reader and Writer streams
        FileReader fileReadStream = null;
        FileWriter fileWriteStream= null;
        
        //Declare Streamtokenizer (wrapper for Streams)
        StreamTokenizer inStream = null;
        
        //Declare Print Stream
        PrintWriter outStream = null;
        
        String columnHeaders = null;
        String county = null;
        double maxTemp = 0;
        double minTemp = 0;
        String weatherCondition = null;
        
        double avgTemp = 0;
        String freezeRisk = null;
        DecimalFormat decFormat = new DecimalFormat("#.0"); // to one decimal place
        
        try{
            // Create file input and output streams, wrap the objects with StreamTokenizer to break info into Tokens
            fileReadStream = new FileReader("weather.dat"); 
            fileWriteStream = new FileWriter("averagetemps.dat");
            
            // Create a stream tokenizer wrapping file input stream
            inStream = new StreamTokenizer(fileReadStream);
            outStream = new PrintWriter(fileWriteStream);
            
            // Read first token
            inStream.nextToken(); //read token County      		
            inStream.nextToken(); //read token Max
            inStream.nextToken(); //read token Min
            inStream.nextToken(); //read token Condition
            inStream.nextToken(); //read token first actual value from dataset I want...
            
            // output the Column Headers first before looping
            outStream.printf("%1$-15s %2$-20s %3$-15s", "County", "Average Daily Temp", "Freeze Risk");
            
            // Process a record //use loop for the series of records
            while (inStream.ttype != StreamTokenizer.TT_EOF) { //check type of the token and that it isn't End of File
                // Get county name
                if (inStream.ttype == StreamTokenizer.TT_WORD) //check token type of the current token.. is it a word?
                county = inStream.sval;  //sval is value of current token if it is a String and is a word
                else
                  System.out.println("Bad file word format");

                // Get maxTemp
                if (inStream.nextToken() == StreamTokenizer.TT_NUMBER) //read next token, which is the maxTemp for current county
                  maxTemp = inStream.nval;
                else
                  System.out.println("Bad file number format"); //if it isn't a number type token

                // Get minTemp
                if (inStream.nextToken() == StreamTokenizer.TT_NUMBER) //get min Temperature for this county
                  minTemp = inStream.nval; 
                else
                  System.out.println("Bad file num format");

                 // Get Weather Condition
                if (inStream.nextToken() == StreamTokenizer.TT_WORD) //get the weather condition 
                    weatherCondition = inStream.sval;
                else 
                    System.err.println("Bad file String format");
                
                //System.out.print("Average Temp: " + decFormat.format((maxTemp + minTemp)/2) + "\t6");

                avgTemp = Double.parseDouble(decFormat.format((maxTemp + minTemp)/2)); //get the average temp for this county
                
                if (avgTemp <= 0){ freezeRisk = "YES"; } 
                else { freezeRisk = "NO"; }
                
                outStream.printf("\n" + columnWidthFormatter(), county , avgTemp , freezeRisk); //PrintWriter object

                inStream.nextToken(); // NB read next token!
              }// end while
            
            
        }//end try
        catch (FileNotFoundException ex)   {
            System.out.println("File not found: in.dat");
        }
        catch (IOException ex)   {
            System.out.println(ex.getMessage());
        }
        finally { //goes with catch block, always execute regardless of exception or not
          try {
            if (fileReadStream != null) fileReadStream.close(); //close streams
            if (fileWriteStream != null) fileWriteStream.close();
            }
          catch (IOException ex)  {
            System.out.println(ex);
          }//end catch
        }//end finally
   
    }// end main
    
    public static String columnWidthFormatter(){ //static methods, there are only one copy
        String printFormatterHolder = "%1$-15s %2$-20.2f %3$-15s"; //three columns [ String, float, String ]
        return printFormatterHolder;
    }
    
}// end Class
