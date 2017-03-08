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
import java.util.List;
import java.util.StringTokenizer;
/**
 *
 * @author DragonDream
 */
public class MultiThread_LabExercise01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        if (args.length ==0 && args.length > 4)
            System.out.println("4 args must be passed in");
        else{
            System.out.println(args[0]); //queen.txt
            System.out.println(args[1]); //ecb.txt
            System.out.println(args[2]); //missing-flight.txt
            System.out.println(args[3]); //gardai.txt
        }
        
      
        
        int wordCount =0;
        String word = "and";
        
        for (String aLine : lines) {
            
            
        
    }// end Main
   
    private int readFileAsList(String inFile, String word) {
        String fileName = inFile;
        int wordCount =0;
        
        try {
            URI uri = this.getClass().getResource(fileName).toURI();
            List<String> lines = Files.readAllLines(Paths.get(uri),
            Charset.defaultCharset());

            for (String aline : lines) {
                System.out.println(aline);
                StringTokenizer st = new StringTokenizer(aLine);
        
            while (st.hasMoreTokens()){
                String s = st.nextToken();

                //use equalsIgnoreCase for whoe word search
                //use contains for hwhole and partial word search
                if(s.toLowerCase().contains(word)){
                    wordCount++;
                }  
            } //end while 
        }//end for
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  
}//end Class
