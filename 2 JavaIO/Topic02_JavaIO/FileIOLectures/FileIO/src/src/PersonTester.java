package src;

import javax.swing.*;
import java.io.*;

public class PersonTester {
	
	ObjectOutputStream out;
	ObjectInputStream in;
	Person retrievedPerson; 
		
	public static void main(String args[]) {
		
		PersonTester pt = new PersonTester();
	}
	
	public PersonTester() {
		
		
		try {
		
                    out = new ObjectOutputStream(new FileOutputStream("savedfile.dat"));
                    in = new ObjectInputStream(new FileInputStream("savedfile.dat"));


                    //process first object
                    Person person1 = new Person();
                    out.writeObject(person1);
                    retrievedPerson = (Person)in.readObject();
                    JOptionPane.showMessageDialog(null, retrievedPerson.toString()); //display all values that were written to that file, excluding the ones marked 'transient'
                                                            // convert toString to write neatly to JOptionPane
                    
                    //process second object
                    Person person2 = new Person("Enda Kenny", 1951, "Mayo", 4578240, "F78452157", "Taoiseach"); //construct using the other constructor
                    out.writeObject(person2);
                    retrievedPerson =  (Person)in.readObject();
                    JOptionPane.showMessageDialog(null, retrievedPerson.toString());

                    //process third object
                    Person person3 = new Person("Eamon Gilmore", 1955, "Dún Laoghaire", 123456, "D785235", "Tanaiste");
                    out.writeObject(person3); //write object to file
                    retrievedPerson  = (Person)in.readObject(); //read it back in to show it's been written in the first place
                    JOptionPane.showMessageDialog(null, retrievedPerson.toString());

                    //house keeping

                    out.close(); //good practice to close the steams
                    in.close(); //my program has exclusive access to those file, preventing other programs from using
		
		}
		catch (Exception ioe) {
                    System.out.println(ioe);
		}
		finally {
                    System.exit(0);
		}
		
	}//end default constructor
	
}//end PersonTester class