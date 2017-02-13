/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namesio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DragonDream
 * ref: http://stackoverflow.com/questions/7164381/changing-absolute-paths-in-my-code-mac-to-relative-paths-for-my-pc
 * ref: https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html
 * ref: https://examples.javacodegeeks.com/core-java/util/list/java-list-to-array-example/
 * ref: http://stackoverflow.com/questions/19468122/how-to-sort-a-string-alphabetically-java
 */
public class NamesIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //note: Mac use "/" , Windows use "\\" for paths 
        Path pathToFile = Paths.get("names.txt"); //relative path to names.txt file
        List<String> namesList;
        
        //verification
        if(Files.isRegularFile(pathToFile) & Files.isReadable(pathToFile) & Files.isExecutable(pathToFile)){
            System.out.print("Is a file, readable and executable");
        }

        try { // Read file, namesList has <String> file types specified above
            namesList = Files.readAllLines(pathToFile,Charset.forName("UTF-8"));
            String output = "";
            output += "The file " + pathToFile.getFileName() + " has " + namesList.size() + " lines\n";
            
            // Get all the elements in the file. These are put into a List
            for(String item : namesList ) { output += item + "\n"; }
//            System.out.println(output);
            
            // Convert list to an array
            String[] arrayOfNames = namesList.toArray( new String[namesList.size()] );          
//            for (String namesInArray : arrayOfNames) { System.out.println(arrayOfNames); } 

            // Sort the array 
            Arrays.sort(arrayOfNames);
            System.out.println("The sorted int array is:");
               for (String sortedArray : arrayOfNames) {
                    System.out.println(sortedArray);
            }
              
            // Convert array back to a list which is now sorted Alphabetically
            namesList = Arrays.asList(arrayOfNames);
           
            // User enters name. 
            String nameInput = JOptionPane.showInputDialog(null,"Enter Your Name");
            System.out.println( "you've entered: " + (nameInput) );
            
            // check if User's input name is on the list
           int value = namesList.indexOf(nameInput);
/*
            System.out.println(value); // returns index. -1 means it isn't on the list.
            if (value == -1){ 
                JOptionPane.showMessageDialog(null, "Your name is not on the list", "You're not popular", JOptionPane.INFORMATION_MESSAGE); 
                System.exit(0);
            }
            else{
                for (String string : namesList) {
                      System.out.println(string);
                }
                System.out.println("You're name was found at : " + value + "\n");    
            }
*/

            // charAt() method from String API           
            
            // need array of character strings. ie CAT => C. A. T.
/*            int addCharIndex = 0; 
            for ( String charVal: nameInput.split("") ) {
                
                value = namesList.indexOf(charVal);
                System.out.println(value);
                addCharIndex += value;
             }
*/          
          
// 
//  ++ add one to variable before evaluating..
            
            //toCharArray
           Static char[] alphabet = [' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'V', 'X', 'Y', 'Z'];
           
           for (String nameString : namesList) {
               
                      System.out.println(nameString);
                }
   
           

        } //end try
        catch (IOException ex) {
            System.err.println("error");
        }// end catch      
    }// end main
}// end class


