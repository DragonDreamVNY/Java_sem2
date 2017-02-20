import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ParsingWeather_LabExerciseSoln  {
  
  public static void main(String[] args) {
    // Declare file reader and writer streams
    FileReader frs = null;
    FileWriter fws = null;

    // Declare streamTokenizer
    StreamTokenizer in = null;

    // Declare a print stream
    PrintWriter out = null;

    // Four input file fields: county name, max temp, min temp and condition
    String cname = null;
    double max = 0;
    double min = 0;
    String condition = null;

    // Computed avg temp
    double avg = 0;

    try     {
        
      String output = "";
       
      // Create file input and output streams
      frs = new FileReader("weather.dat");
      fws = new FileWriter("averagetemps.dat");

      // Create a stream tokenizer wrapping file input stream
      in = new StreamTokenizer(frs);
      out = new PrintWriter(fws);
      
      //put col headers in output String
      output = "County\t" + "Average Daily Temp\t" + "Freeze Risk";
     
      // Read past col headings in weather.dat
      in.nextToken(); in.nextToken(); in.nextToken(); in.nextToken();

      //read first token proper
      in.nextToken();
	  
       // Process a record
      while (in.ttype != StreamTokenizer.TT_EOF)     {
        
         // Get county name
        if (in.ttype == StreamTokenizer.TT_WORD){
            cname = in.sval;
            System.out.println("\n" + cname);
        }
        else
          System.out.println("Bad file format");

        // Get min temp
        if (in.nextToken() == StreamTokenizer.TT_NUMBER){
          min = in.nval;
          System.out.print("\t" + min);
        }
        else
          System.out.println("Bad file format");

        // Get max temp
        if (in.nextToken() == StreamTokenizer.TT_NUMBER){
            max = in.nval;
            System.out.print("\t" + max);
        }
        else
          System.out.println("Bad file format");

        // Get condition
        if (in.nextToken() == StreamTokenizer.TT_WORD){
          condition = in.sval;
            System.out.print("\t" + condition);
        }
        else
          System.out.println("Bad file format");  

	//compute average
        avg = (min + max) /2;
        String frisk = null;
        
        //determine if the county is a freeze risk
        if (avg<=0)
        	frisk = "YES";
        else
        	frisk = "NO";
    
    	//append each countys details to output String
        output += "\n" + cname + "\t\t" + avg + "\t\t" + frisk;
      
	//read next token
        in.nextToken();
      }//end while
      
      //print contents of output String to file
      out.println(output);
      
      //create JTextArea and pass the output String to its constructor
      JTextArea jta = new JTextArea(output);
      
      //display message dialog which contains the text area
      JOptionPane.showMessageDialog(null, jta);
    
    }//end try
    
    catch (FileNotFoundException ex)   {
      System.out.println("File not found: weather.dat");
    }//end catch
    
    catch (IOException ex)   {
      System.out.println(ex.getMessage());
    }//end catch
    
    finally   {
      try     {
        if (frs != null) frs.close();
        if (fws != null) fws.close();
      }//end try
      
      catch (IOException ex)  {
        System.out.println(ex);
      }//end catch
      
    }//end finally
  
  }//end class
}