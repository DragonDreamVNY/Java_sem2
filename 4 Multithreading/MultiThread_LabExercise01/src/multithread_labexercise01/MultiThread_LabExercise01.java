/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread_labexercise01;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
/**
 *
 * @author DragonDream
 */
public class MultiThread_LabExercise01 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // Create an instance of CustomThread
        CustomThread customThread = new CustomThread();
        
        // Create a thread
        Thread thread = new Thread(customThread);
        
        // Start a thread
        thread.start();
        
        if ( args.length == 0 && args.length > 4 )
            System.out.println("4 args must be passed in");
        else{
            System.out.println( args[0] ); //queen.txt
            System.out.println( args[1] ); //ecb.txt
            System.out.println( args[2] ); //missing-flight.txt
            System.out.println( args[3] ); //gardai.txt
        }
        
        //Path queen_path     = Paths.get("police.txt"); // creates a 'no such file exception'
        Path queen_path     = Paths.get(args[0]);
        Path ecb_path       = Paths.get(args[1]);
        Path missing_flight_path = Paths.get(args[2]);
        Path gardai_path    = Paths.get(args[3]);
        //Charset charset = Charset.forName("ISO-8859-1");
        //String word = "and";
        String word = JOptionPane.showInputDialog("enter a word to search text");
        
        System.out.println( readFileAsListWithWord(queen_path, word) + " in : " + "\'"+queen_path+"\'");
        System.out.println( readFileAsListWithWord(ecb_path, word) + " in : " + "\'"+ecb_path+"\'");
        System.out.println( readFileAsListWithWord(missing_flight_path, word)  + " in : " + "\'"+missing_flight_path+"\'");
        System.out.println( readFileAsListWithWord(gardai_path, word) + " in : " + "\'"+gardai_path+"\'" );
        
    }// end Main
    
  
        
    
    public static String readFileAsListWithWord(Path inFilePath, String word) {
        //Path fileName = inFilePath;
        String numberOfTimesWordsInText = "";
        int wordCount = 0;
        List<String> lines;
        try{
            //URI uri = this.getClass().getResource(fileName).toURI();
            //List<String> lines = Files.readAllLines(Paths.get(uri),
            lines = Files.readAllLines(inFilePath);
            Charset.defaultCharset();
            
            /*Alan's */       
            for (String aLine : lines) {
                StringTokenizer stoken = new StringTokenizer(aLine);
//                System.out.println(aLine);
                while (stoken.hasMoreTokens()) {
                    String s = stoken.nextToken();

                    //use equalsIgnoreCase for whole word
                    //use contains for whole and partial word
                    if (s.toLowerCase().contains(word)){
                        wordCount++;
                    }
                }//end while
            }//end for
            //System.out.println(" \'"+word+"\' appears " + wordCount + " times");
            numberOfTimesWordsInText = (" \'"+word+"\' appears " + wordCount + " times");
            /*-----------------*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfTimesWordsInText;
        
    }//end numberOfTimesWordsInText

  
}//end Class
