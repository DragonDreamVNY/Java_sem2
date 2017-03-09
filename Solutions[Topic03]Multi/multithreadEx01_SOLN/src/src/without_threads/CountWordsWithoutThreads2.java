package src.without_threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class CountWordsWithoutThreads2 {

    public static void main(String[] args) throws Exception {

        if (args.length==0) {
            System.out.println("ERROR: No files passed to the program");
            System.exit(0);
        }//end if
            
        String searchWord = "and";

        for (String aFile : args) { //program is flexible, will work for any number of files thsat are passed into the args array
            System.out.println("The word " + searchWord + " appears " + countWords(aFile, searchWord) + " times in the file " + aFile);
        }//end foreach
    }//end main

    public static int countWords(String file, String word) {

      List<String> lines = null;
        int wordCount = 0;
        
        try {
            
            Path path = Paths.get(file); //file is passed in one at a time from the foreach loop
            
            lines = Files.readAllLines(path);
        
        }//end try
        
        catch (IOException ex) {
            System.out.println(ex);
        }//end catch
        
        
        for (String aLine: lines) {
            
            StringTokenizer st = new StringTokenizer(aLine); //didn't use StreamTokenizer to parse, use StringTokenizer instead
            
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                
                //use equalsIgnoreCase for whole word search
                //use contains for whole and partial word search
                if (s.toLowerCase().contains(word)) {
                    wordCount++;
                }
            }//end while

        }//end for
        
        return wordCount;
    
    }//end countWords

}//end class CountWordsWithoutThreads2