package src;
// ParsingTextFile.java: Process text file using StreamTokenizer
// Example 4 in notes: Student Grades int/out to final grade

import java.io.*;

public class ParsingTextFile {
  /**Main method*/
  public static void main(String[] args) {
    // Declare file reader and writer streams
    FileReader frs = null;
    FileWriter fws = null;

    // Declare streamTokenizer
    StreamTokenizer in = null;

    // Declare a print stream
    PrintWriter out = null;

    // Four input file fields: student name, midterm1,
    // midterm2, and final exam score
    String sname = null;
    double midterm1 = 0;
    double midterm2 = 0;
    double finalScore = 0;

    // Computed total score, for writing to final file
    double total = 0;
    
    try     {
      // Create file input and output streams
      frs = new FileReader("in.dat");       
      fws = new FileWriter("out.dat");

      // Create a stream tokenizer wrapping file input stream
      in = new StreamTokenizer(frs); //wrap FileReader object with SteamTokenizer to break information into Tokens.
      out = new PrintWriter(fws); //wrap FileWriter object with PrintWriter object
      
      // Read first token
      in.nextToken(); //read token

      // Process a record //use loop for the series of records
      while (in.ttype != StreamTokenizer.TT_EOF)     { //check type of the token and that it isn't End of File
        // Get student name
        if (in.ttype == StreamTokenizer.TT_WORD) //check token type of the current token.. is it a word?
          sname = in.sval;  //sval is value of current token if it is a String and is a word
        else
          System.out.println("Bad file format");

        // Get midterm1
        if (in.nextToken() == StreamTokenizer.TT_NUMBER) //read next token, which is the grade for current person
          midterm1 = in.nval;
        else
          System.out.println("Bad file format"); //if it isn't a number type token

        // Get midterm2
        if (in.nextToken() == StreamTokenizer.TT_NUMBER) //get the last grade
          midterm2 = in.nval; 
        else
          System.out.println("Bad file format");

        // Get final score
        if (in.nextToken() == StreamTokenizer.TT_NUMBER) //get the final score
          finalScore = in.nval;
        else 
            System.err.println("Bad file format");
        
        total = midterm1*0.3 + midterm2*0.3 + finalScore*0.4;
        out.println(sname + " " + total); //PrintWriter object

        in.nextToken(); //very important, read next token!
      }// end while
    }
    catch (FileNotFoundException ex)   {
      System.out.println("File not found: in.dat");
    }
    catch (IOException ex)   {
      System.out.println(ex.getMessage());
    }
    finally  { //goes with catch block, always execute regardless of exception or not
      try  {
        if (frs != null) frs.close(); //close streams
        if (fws != null) fws.close();
      }
      catch (IOException ex)  {
        System.out.println(ex);
      }
    }
  }
}