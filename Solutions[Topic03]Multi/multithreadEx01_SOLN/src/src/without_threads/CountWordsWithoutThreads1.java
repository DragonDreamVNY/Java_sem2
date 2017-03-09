package src.without_threads;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class CountWordsWithoutThreads1 {

    public static void main(String[] args) throws Exception {

        
        if (args.length==0) {
            System.out.println("ERROR: No files passed to the program");
            System.exit(0);
        }//end if
            
        String searchWord = "and";

        for (String aFile : args) {
            System.out.println("The word " + searchWord + " appears " + countWords(aFile, searchWord) + " times in the file " + aFile);
        }//end for
    }//end main

    public static int countWords(String file, String word) {

      int wordCount =0;
      FileReader frs;

      try {
            frs = new FileReader(file);

            StreamTokenizer st = new StreamTokenizer(frs);

            st.nextToken(); //read first token

            
            while (st.ttype != StreamTokenizer.TT_EOF) {
                
             if (st.ttype == StreamTokenizer.TT_WORD) {
                    //use equalsIgnoreCase for whole word search
                    //use contains for whole and partial word search
                    if (st.sval.contains(word)) {
                        wordCount++;
                    }//end inner if
                }//end outter if

                st.nextToken();//read next token
            }//end while

            
        }//end try //end try 
        catch (IOException ex) {
            System.out.println("ERROR " + ex);
        }//end catch

      return wordCount;
    
    }//end countWords

}//end class CountWordsWithoutThreads1