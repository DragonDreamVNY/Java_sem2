package src.with_threads;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class CountWordsWithThreads1 {

    public static void main(String[] args) throws Exception {

        if (args.length==0) {
            System.out.println("ERROR: No files passed to the program");
            System.exit(0);
        }//end if
            
        String searchWord = "miss";

        for (String aFile : args) {
            Thread t = new Thread(new CountSpecificWords1(aFile, searchWord));
            t.start();
        }//end for
    }//end main

}//end class CountWordsWithThreads1

class CountSpecificWords1 implements Runnable {

    String file;
    String word;
    int count = 0;

    public CountSpecificWords1(String file, String word) {

        this.file = file;
        this.word = word;
    }

    @Override
    public void run() {
        try {
            FileReader frs;

            frs = new FileReader(file);

            StreamTokenizer st = new StreamTokenizer(frs);

            st.nextToken(); //read first token

            while (st.ttype != StreamTokenizer.TT_EOF) {
                
             if (st.ttype == StreamTokenizer.TT_WORD) {
                 //use equalsIgnoreCase for whole word search
                 //use contains for whole and partial word search
                 if (st.sval.contains(word)) {
                        count++;
                    }//end inner if
                }//end outter if

                st.nextToken();//read next token
            }//end while

            System.out.println("The word " + word + " appears " + count + " times in the file " + file);
        }//end try 
        catch (IOException ex) {
            System.out.println("ERROR " + ex);
        }//end catch

    }//end run

}//end class CountWordsWithThreads1
