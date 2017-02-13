package src;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Exercise1

{
//static char[] alphabet = {'', 'a','b'};

    public static void main(String[] args)
    {
        Path target = Paths.get("names.txt");
        List<String> names;

        try
        {
            names = Files.readAllLines(target, Charset.forName("UTF-8"));
            String output = "";

            for (String item : names)
            {
                output += item + "\n";
            }
            System.out.println(output);
        }//end try
        catch (IOException ex)
        {
            System.out.println("error");
        }//end catch
    }//end main
}//end class
