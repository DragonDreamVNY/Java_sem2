/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks_parsingexercise;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
/**
 *
 * @author Vincent Lee [DragonDream]
 * File Parsing Exercise
 */
public class Stocks_parsingExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Declare file reader and writer streams
        FileReader freadS = null;
        FileWriter fwriteS = null;
        
        // Declare streamTokenizer
        StreamTokenizer in = null;
        // Declare a print stream
        PrintWriter out = null;
        
        try{
            // Create file input and output streams
            freadS = new FileReader("stock.dat");
            fwriteS = new FileWriter("newstock.dat");

            // Create a stream tokenizer wrapping file input stream
            in = new StreamTokenizer(freadS);
            out = new PrintWriter(fwriteS);
            
            
             // Read past col headings.
            in.nextToken(); //Brand
            in.nextToken(); //Model
            in.nextToken(); //Colour
            in.nextToken(); //MegaPixel
            in.nextToken(); //Price
            
            //read first token of first row (Title)
            in.nextToken();
            
            //first print col heads to second file
            out.println("Brand \tModel \tColour \tMegaPixel \tOldPrice \tNewPrice");
            System.out.println("Brand \tModel \tColour \tMegaPixel \tOldPrice \tNewPrice");
            while (in.ttype != StreamTokenizer.TT_EOF) {
                
                //Brand
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    out.print(in.sval + "\t");
                    System.out.print(in.sval);
                } else {
                    System.out.println("Bad file structure - Brand");
                }
                
                //read next token (Model)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    out.print(in.sval + "\t\t");
                    System.out.print(in.sval + "\t");

                } else {
                    System.out.println("Bad file structure - Model");
                }
                
                //read next token (Colour)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    out.print(in.sval + "\t\t");
                    System.out.print(in.sval + "\t");

                } else {
                    System.out.println("Bad file structure - Colour");
                }
                
                //read next token (Megapixel)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_NUMBER) {

                    //read Megapixel from the file and cast it to an int
                    int mPixel = (int)in.nval;
                    
                    //convert the int to a string
                    String megaPixAsString = String.valueOf(mPixel);
                    out.print(megaPixAsString + "\t\t");
                    System.out.print(megaPixAsString + "\t");
                }//end if
                else {
                    System.out.println("Bad file structure - MegaPix");
                }
                   
                //read next token (Price)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_NUMBER) {

                    //read Price from the file and cast it to int
                    int oldPrice = (int)in.nval;
                    
                    //convert the int to a string
                    //String oldPriceAsString = String.valueOf(oldPrice);
                    out.print(oldPrice + "\t\t");
                    System.out.print(oldPrice + "\t");
                    
                    //--------------------
                    //***new Price***
                    
                    
                    int newPrice = 0;
                    
                    if( oldPrice < 99 ) { 
                        newPrice =  (int) ( oldPrice - (oldPrice*0.05) ); 
                    } // 5% discount 
                    
                    else if( (oldPrice >= 100)&&(oldPrice <= 199) ) { 
                       newPrice = (int)( oldPrice - (oldPrice*0.08) ); 
                    } // 8% discount
                    
                    else if( (oldPrice >= 200)&&(oldPrice  <= 299) ) { 
                       newPrice = (int)( oldPrice - (oldPrice*0.10) ); 
                    } // 10% discount
                    
                    else if( (oldPrice >= 300)&&(oldPrice  <= 449) ) { 
                       newPrice = (int)( oldPrice - (oldPrice*0.12) ); 
                    } // 12% discount
                    
                    else if(oldPrice > 450) { 
                        newPrice = (int)(oldPrice - (oldPrice*0.15)); 
                    } //15% discount
                    //String newPriceAsString = String.valueOf(newPrice);

                    out.print(newPrice + "\t\t");
                    System.out.print(newPrice + "\t");

                    
                    //***end new Price***
                    //--------------------
                    
                }//end if
                else {
                    System.out.println("Bad file structure - Price");
                }
                
                //skip a line in out file
                out.println();
                System.out.println("");
                
                //start of new row of tokens
                in.nextToken();
                
            }//end while !EOF
            
        }//end try
        
        catch(FileNotFoundException ex) {
            System.out.println("File not found: stock.dat");
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (freadS != null) {
                    freadS.close();
                }
                if (fwriteS != null) {
                    fwriteS.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
    }// end main
  
}//end Class
