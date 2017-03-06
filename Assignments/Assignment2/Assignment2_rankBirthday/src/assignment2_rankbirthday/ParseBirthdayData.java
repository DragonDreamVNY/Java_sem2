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
 *
 * @author DragonDream
 */
public class ParseBirthdayData {
    
    public static void parseBirthdaysFromFile(){
        //Declare File Reader and Writer streams
        FileReader fileReadStr = null;
        //FileWriter fileWriteStr = null;

        // Declare streamTokenizer
        StreamTokenizer inS = null;

        // Declare a print stream
        //PrintWriter outS = null;

        // declare params here. Strings, doubles 
        int rankForEachDay[] = new int[366]; //2016 has 366 days
        
        int jan[]   = new int[31]; 
        int feb[]   = new int[29]; 
        int mar[]   = new int[31]; 
        int apr[]   = new int[30]; 
        int may[]   = new int[31]; 
        int jun[]  = new int[30]; 
        int jul[]   = new int[31]; 
        int aug[]   = new int[31]; 
        int sep[]   = new int[30]; 
        int oct[]   = new int[31]; 
        int nov[]   = new int[30]; 
        int dec[]   = new int[31]; 
        
        int rankNum = 0;
        
        //for output 
        String output = "";
        JTextArea outTextArea = new JTextArea();
        
        try {
            // Create file input and output streams
            fileReadStr = new FileReader("days.txt");       
            //fileWriteStr = new FileWriter("outfile.text");

            // Create a stream tokenizer wrapping file input stream
            inS = new StreamTokenizer(fileReadStr); //wrap FileReader object with SteamTokenizer to break information into Tokens.
            //outS = new PrintWriter(fileWriteStr); //wrap FileWriter object with PrintWriter object
            
            // skip past header dates '1-31' from inStream file...
            for ( int i =0; i < 31; i++ ){ inS.nextToken(); }
            
            inS.nextToken();//read 'Jan' in first column 
            //inS.nextToken(); //skip 'Jan' in first column 
            
          // use loop for the series of records
          while (inS.ttype != StreamTokenizer.TT_EOF) {
           
            // Read January tokens
            //-------------------
            for ( int day =0; day < 31; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the January bDay ranks
                    rankNum = (int)inS.nval; //the value of this token
                    System.out.print("Jan" + rankNum +" ");
                    output += rankNum + " ";
                    jan[day] = rankNum; //store rank for this day in Jan array
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                }
                else{ 
                    System.err.println("Bad number file format - is it January num?");
                }
            }
            System.out.print("\n\n");
            output += "\n\n";
            
            inS.nextToken(); //reads 'Feb' in first column, skips it in the first run of Feb forLoop
            //Read February tokens
            //-------------------
            for ( int day =0; day < 29; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the February bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" Feb " + rankNum +" ");
                    output += rankNum + " ";
                    feb[day] = rankNum; //store rank for this day in Feb Array
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016

                }
                else{ 
                    System.err.println("Bad number file format - is it Feb num?");
                }
            }
            System.out.print("\n\n");
            output+="\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'Mar' in first column, skips it in the first run of Mar forLoop
            //Read March tokens
            //-------------------
            for ( int day =0; day < 31; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the February bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" Mar " + rankNum +" ");
                    output += rankNum + " ";
                    mar[day] = rankNum; //store rank for this day in March
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                }
                else{ 
                    System.err.println("Bad number file format - is it Mar num?");
                }
            }
            System.out.print("\n\n");
            output+="\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'Apr' in first column
            //Read April tokens
            //-------------------
            for ( int day =0; day < 30; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the April bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" Apr " + rankNum +" ");
                    output += rankNum + " ";
                    apr[day] = rankNum; //store rank for this day in April
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                }
                else{ 
                    System.err.println("Bad number file format - is it Apr num?");
                }
            }
            System.out.print("\n\n");
            output+="\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'May' in first column
            //Read May tokens
            //-------------------
            for ( int day =0; day < 31; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the May bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" May " + rankNum +" ");
                    output += rankNum + " ";
                    may[day] = rankNum; //store rank for this day in May
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                }
                else{ 
                    System.err.println("Bad number file format - is it Apr num?");
                }
            }
            System.out.print("\n\n");
            output+="\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'June' in first column
            //Read June tokens
            //-------------------
            for ( int day =0; day < 30; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the June bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" June " + rankNum +" ");
                    output += rankNum + " ";
                    jun[day] = rankNum; //store rank for this day in June
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                }
                else{ 
                    System.err.println("Bad number file format - is it May num?");
                }
            }
            System.out.print("\n\n");
            output+="\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'Jul' in first column
            //Read July tokens
            //-------------------
            for ( int day =0; day < 31; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the April bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" Jul " + rankNum +" ");
                    output += rankNum + " ";
                    jul[day] = rankNum; //store rank for this day in July
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                }
                else{ 
                    System.err.println("Bad number file format - is it Jul num?");
                }
            }
            System.out.print("\n\n");
            output+="\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'Aug' in first column
            //Read August tokens
            //-------------------
            for ( int day =0; day < 31; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the August bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" Aug " + rankNum +" ");
                    output += rankNum + " ";
                    aug[day] = rankNum; //store rank for this day in August
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                    
                }
                else{ 
                    System.err.println("Bad number file format - is it Aug num?");
                }
            }
            System.out.print("\n\n");
            output+="\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'Sep' in first column
            //Read September tokens
            //-------------------
            for ( int day =0; day < 30; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the September bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" Sep " + rankNum +" ");
                    output += rankNum + " ";
                    sep[day] = rankNum; //store rank for this day in September
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                }
                else{ 
                    System.err.println("Bad number file format - is it Sep num?");
                }
            }
            System.out.print("\n\n");
            output+= "\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'Oct' in first column
            //Read October tokens
            //-------------------
            for ( int day =0; day < 31; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the April bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" Oct " + rankNum +" ");
                    output += rankNum + " ";
                    oct[day] = rankNum; //store rank for this day in October
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                }
                else{ 
                    System.err.println("Bad number file format - is it Oct num?");
                }
            }
            System.out.print("\n\n");
            output+= "\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'Nov' in first column
            //Read November tokens
            //-------------------
            for ( int day =0; day < 30; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the November bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" Nov " + rankNum +" ");
                    output += rankNum + " ";
                    nov[day] = rankNum; //store rank for this day in November
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                }
                else{ 
                    System.err.println("Bad number file format - is it Nov num?");
                }
            }
            System.out.print("\n\n");
            output+="\n\n";
            inS.nextToken(); 
            
            inS.nextToken(); //reads 'Dec' in first column
            //Read December tokens
            //-------------------
            for ( int day =0; day < 31; day++ ){ 
                if(inS.nextToken() == StreamTokenizer.TT_NUMBER){ //get the December bDay ranks
                    rankNum = (int)inS.nval;
                    System.out.print(" Dec " + rankNum +" ");
                    output += rankNum + " ";
                    dec[day] = rankNum; //store rank for this day in December
                    rankForEachDay[day] = rankNum; //store rank for this day in 2016
                    //at the end of December should have 366 values in the rankForEachDay array

                }
                else{ 
                    System.err.println("Bad number file format - is it Dec num?");
                }
            }
            System.out.print("\n\n");
            output+="\n\n";
            inS.nextToken(); 

            
          }// end while
          
          
            JOptionPane.showMessageDialog(null, output);
            

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found: make sure it is \'days.text\'");
        }
        catch (IOException ex)   {
            System.out.println(ex.getMessage());
        }
        finally  { 
            try  {
                if (fileReadStr != null) fileReadStr.close(); //close streams
                //if (fileWriteStr != null) fileWriteStr.close();
            }
            catch (IOException ex)  {
            System.out.println(ex);
            }
        }
    }
    
}
