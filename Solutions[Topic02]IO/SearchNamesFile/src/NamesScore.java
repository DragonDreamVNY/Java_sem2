import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class NamesScore {

    static char[] alphabet = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    static List<String> listOfNames;

    public static void main(String[] args) throws IOException {

        //get "search name" from the user
        String name = JOptionPane.showInputDialog("Enter name");

        //convert the users input to lower case
        name = name.toLowerCase();
        
        //get path to file
        Path path = Paths.get("names.txt");

        //read all the names into a list
        listOfNames = Files.readAllLines(path);
        
        //convert the list to lowercase
        for(int i=0; i < listOfNames.size(); i++) {
            listOfNames.set(i, listOfNames.get(i).toLowerCase());
        }//end for
        
        //check if the list contains the name
        if (!listOfNames.contains(name)) {

            JOptionPane.showMessageDialog(null, "Name not found");
            System.exit(0);
        }//end if

        //convert the list to an array - this is a necessary step as its very easy to sort an array
        String l[] = listOfNames.toArray(new String[0]);

        //sort the array
        Arrays.sort(l);

        //convert the sorted array back to a list
        listOfNames = Arrays.asList(l);

        //print the names from the file and their index -> Not required by the spec 
        //but this makes it easier to check if the score the program generates is correct
        int counter = 1;
        
        for (String n : listOfNames) {
            System.out.println(counter++ + "\t\t" + n);
        }//end foreach

        //get the index of the users name in the list
        int index = listOfNames.indexOf(name);

        //incr index by 1 as the list starts at index 0
        index++;

        //var to hold the score for the name
        //initially set it equal to the index 
        int score = 0;

        System.out.println("-------------------------------------------------");
        System.out.println("Name entered is " + name);
        
        //go through each letter in the name and check its score
        for (int i = 0; i < name.length(); i++) {

            score += checkLetter(name.charAt(i));

        }//end for

        System.out.println("Total Alhpabetical Score for " + name + " is " + score);
        System.out.println(name + " is at Index " + index);
        
        score *= index;
        
        System.out.println("Alhpabetical Score * index is " + score);
        System.out.println("-------------------------------------------------");
        
        //give the users their score
        JOptionPane.showMessageDialog(null, "Score for " + name + " is " + score);

    }//end main

    //method to determine the alphabetical score of each letter in the name entered
    static int checkLetter(char c) {

        for (int i = 0; i < alphabet.length; i++) {

            if (alphabet[i] == c) {
                System.out.println(c + " is worth " + i);
                return i;
            }

        }

        //should never get to this return statement
        return 0;

    }//end method checkLetter

}//end class