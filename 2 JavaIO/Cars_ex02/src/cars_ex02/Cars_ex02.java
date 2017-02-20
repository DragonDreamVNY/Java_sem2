/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars_ex02;
import java.io.*;
import java.text.DecimalFormat;
/**
 *
 * @author DragonDream
 */
public class Cars_ex02 {

    /**Main method*/
    public static void main(String[] args) {
        //Declare File Reader and Writer streams
        FileReader fileReadStream = null;
        FileWriter fileWriteStream= null;

        // Declare streamTokenizer
        StreamTokenizer inStream = null;

        // Declare a print stream
        PrintWriter outStream = null;

        // Eight input file fields: carReg, make, model, colour,
        // location, price, owners, mileage
        String carReg = null;
        String make = null;
        String model = null;
        String colour = null;
        String location = null;
        double price = 0;
        double owners = 0;
        double mileage = 0;

        //for output 
        String countyOutput = null;

        double dublinTotal = 0;
        int dublinCount = 0;

        double limerickTotal = 0;
        int limerickCount = 0;

        double corkTotal = 0;
        int corkCount = 0;

        double dublinAVGPrice = 0;
        double limerickAVGPrice = 0;
        double corkAVGPrice = 0;

        DecimalFormat decFormat = new DecimalFormat("#####.00");

        try {
            // Create file input and output streams
            fileReadStream = new FileReader("cars.dat");       
            fileWriteStream = new FileWriter("projections.dat");

            // Create a stream tokenizer wrapping file input stream
            inStream = new StreamTokenizer(fileReadStream); //wrap FileReader object with SteamTokenizer to break information into Tokens.
            outStream = new PrintWriter(fileWriteStream); //wrap FileWriter object with PrintWriter object

            // Read first token
            inStream.nextToken(); //read token

            // output the Column Headers first before looping
            outStream.println("Location" + "\t" + "AveragePrice");

          // Process a record //use loop for the series of records
          while (inStream.ttype != StreamTokenizer.TT_EOF)     { //check type of the token and that it isn't End of File
            // Get carReg
            if (inStream.ttype == StreamTokenizer.TT_WORD)
              carReg = inStream.sval; 
            else
              System.out.println("Bad word file format - is it a carReg?");

            // Get make
            if (inStream.nextToken() == StreamTokenizer.TT_WORD) 
              make = inStream.sval;
            else
              System.out.println("Bad word file format - is it the car Make?");

            // Get model
            if (inStream.nextToken() == StreamTokenizer.TT_WORD)
              model = inStream.sval; 
            else
              System.out.println("Bad word file format - is it the car Model?");

            // Get colour
            if (inStream.nextToken() == StreamTokenizer.TT_WORD)
              colour = inStream.sval; 
            else
              System.out.println("Bad word file format - is it the car Colour?");

            // Get location
            if (inStream.nextToken() == StreamTokenizer.TT_WORD)
              location = inStream.sval; 
            else
              System.out.println("Bad word file format - is it the location?");

            // Get price
            if (inStream.nextToken() == StreamTokenizer.TT_NUMBER) //get the final score
              price = inStream.nval;
            else 
                System.err.println("Bad number file format - is it the Price?");

            // Get owners
            if (inStream.nextToken() == StreamTokenizer.TT_NUMBER) //get the final score
              owners = inStream.nval;
            else 
                System.err.println("Bad number file format - is it the owner?");

            // Get mileage
            if (inStream.nextToken() == StreamTokenizer.TT_NUMBER) //get the final score
              mileage = inStream.nval;
            else 
                System.err.println("Bad number file format - is it the mileage?");

            if (location == "DUBLIN") { 
                dublinCount++; 
                dublinTotal += price;
            }

            //Thats Limerick City
            if (location == "LIMERICK") { 
                limerickCount++; 
                limerickTotal += price;
            }

            if (location == "CORK") { 
                corkCount++; 
                corkTotal += price;
            }

            inStream.nextToken(); //very important, read next token!
          }// end while
            dublinAVGPrice = ( dublinTotal/dublinCount );
            limerickAVGPrice = ( limerickTotal/limerickCount );
            corkAVGPrice = ( corkTotal/corkCount );

            System.out.println(dublinAVGPrice);
            System.out.println("formatted: " + decFormat.format(dublinAVGPrice));
            System.out.println("formatted: " + decFormat.format(limerickAVGPrice));
            System.out.println("formatted: " + decFormat.format(corkAVGPrice));

            //PrintWriter objects
            outStream.println( "DUBLIN" + "\t" + decFormat.format(dublinAVGPrice) );
            outStream.println( "LIMERICK" + "\t" + decFormat.format(limerickAVGPrice) ); 
            outStream.println( "CORK" + "\t" + decFormat.format(corkAVGPrice) );
        }
        catch (FileNotFoundException ex)   {
          System.out.println("File not found: make sure it is \'cars.dat\'");
        }
        catch (IOException ex)   {
          System.out.println(ex.getMessage());
        }
        finally  { //goes with catch block, always execute regardless of exception or not
          try  {
            if (fileReadStream != null) fileReadStream.close(); //close streams
            if (fileWriteStream != null) fileWriteStream.close();
          }
          catch (IOException ex)  {
            System.out.println(ex);
          }
        }
    }//end main
    
    public static String columnWidthFormatter(){
        String printFormatterHolder = "%1$-15s %2$-20.2f"; //two columns in output file [ String, float ]
        return printFormatterHolder;
    }
    
}//end class
