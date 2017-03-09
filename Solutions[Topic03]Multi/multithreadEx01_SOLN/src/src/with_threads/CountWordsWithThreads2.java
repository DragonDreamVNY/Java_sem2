package src.with_threads;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class CountWordsWithThreads2 {

    public static void main(String[] args) throws Exception {

        if (args.length==0) {
            System.out.println("ERROR: No files passed to the program");
            System.exit(0);
        }//end if
        
        String searchWord = "and";

        for (String aFile : args) {
            Thread t = new Thread(new CountSpecificWords2(aFile, searchWord)); //a runnable object called
            t.start();
        }//end for
    }//end main

}//end class CountWordsWithThreads2

class CountSpecificWords2 implements Runnable {

    String file;
    String word;

    public CountSpecificWords2(String file, String word) {

        this.file = file;
        this.word = word;
    }//end CountSpecificWords2 constructor

    @Override
    public void run() { //what the thread actually does
        
        List<String> lines = null;
        int wordCount = 0;
        
        try {
            
            Path path = Paths.get(file);
            
            lines = Files.readAllLines(path);
        
        }//end try
        
        catch (IOException ex) {
            System.out.println(ex);
        }//end catch
        
        
        for (String aLine: lines) {
            
            StringTokenizer st = new StringTokenizer(aLine); //breaks a String into individual words as tokens
            
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                
                //use equalsIgnoreCase for whole word search
                //use contains for whole and partial word search
                if (s.toLowerCase().contains(word)) {
                    wordCount++;
                }
            }//end while

        }//end for
        
         System.out.println("The word " + word + " appears " + wordCount + " times in the file " + file);
         
    }//end run
        

}//end class CountWordsWithThreads2
