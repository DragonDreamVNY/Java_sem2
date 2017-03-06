/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsingtemplates;

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/**
 *
 * @author DragonDream
 */
public class ParsingTemplates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declare File Reader and Writer streams
        FileReader fileReadStr = null;
        FileWriter fileWriteStr = null;

        // Declare streamTokenizer
        StreamTokenizer inS = null;

        // Declare a print stream
        PrintWriter outS = null;

        // declare params here. Strings, doubles 
        String stringVar1 = null;
        String stringVar2 = null;
        int num1 = 0;
        int num2 = 0;
        
        //for output 
        String output = null;
        
        //two columns in output file [ String, float with two decimals ] '-'for left aligned
        String printFormatter = "%1$-15s %2$-20.2f"; 
        DecimalFormat decFormat = new DecimalFormat("#.##");
        decFormat.setRoundingMode(RoundingMode.CEILING);
        
        try {
            // Create file input and output streams
            fileReadStr = new FileReader("infile.text");       
            fileWriteStr = new FileWriter("outfile.text");

            // Create a stream tokenizer wrapping file input stream
            inS = new StreamTokenizer(fileReadStr); //wrap FileReader object with SteamTokenizer to break information into Tokens.
            outS = new PrintWriter(fileWriteStr); //wrap FileWriter object with PrintWriter object
            
            // skip past headers from inStream file...
            for (int i =0; i < 8; i++){ inS.nextToken();}
            
            // Read first token
            inS.nextToken(); //read token

            // output the Column Headers first before looping
            //outS.println("Location" + "\t" + "AveragePrice");
            // output the Column Headers first before looping
            outS.printf("%1$-15s %2$-20s %3$-15s", "County", "Average Daily Temp", "Freeze Risk");

          // Process a record //use loop for the series of records
          while (inS.ttype != StreamTokenizer.TT_EOF)     { //check type of the token and that it isn't End of File
            // Get first value
            if (inS.ttype == StreamTokenizer.TT_WORD)
              stringVar1 = inS.sval; 
            else
              System.out.println("Bad word file format - S1?");

            // Get second value
            if (inS.nextToken() == StreamTokenizer.TT_WORD) 
              stringVar2 = inS.sval;
            else
              System.out.println("Bad word file format - S2?");
            
            // Get price
            if (inS.nextToken() == StreamTokenizer.TT_NUMBER) //get the final score
                num1 = (int)inS.nval;
            else 
                System.err.println("Bad number file format - is it the Price?");


            inS.nextToken(); //very important, read next token!
          }// end while

            System.out.println(dublinAVGPrice);
            System.out.println("formatted: " + decFormat.format(dublinAVGPrice));


            //PrintWriter objects
            outS.println( "DUBLIN" + "\t" + decFormat.format(dublinAVGPrice) );
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found: make sure it is \'cars.dat\'");
        }
        catch (IOException ex)   {
            System.out.println(ex.getMessage());
        }
        finally  { 
            try  {
                if (fileReadStr != null) fileReadStr.close(); //close streams
                if (fileWriteStr != null) fileWriteStr.close();
            }
            catch (IOException ex)  {
            System.out.println(ex);
            }
        }

        
        
    }// end main
    
}// end Class
