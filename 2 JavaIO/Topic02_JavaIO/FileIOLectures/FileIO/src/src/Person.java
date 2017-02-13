package src;

import java.io.*;

public class Person implements Serializable {
	
	public String name;
	private int YOB;
	private String address;
	private int phone;
	private String RSI;
	private String occupation;
        //private transient String thingy; //mark transient if you don't want them written to file
	
	public Person() {
		
		name = "Jane Doe";
		YOB = 1972;
		address = "Moylish Park, Limerick";
		phone = 123456;
		RSI = "K44521452";
		occupation = "Unemployed";
		
	}//end default constructor
	
	public Person(String nme, int year, String add, int pne, String rsiNum, String job) {
		name = nme;
		YOB = year;
		address = add;
		phone = pne;
		RSI = rsiNum;
		occupation = job;
	}//end constructor
	
	
	public String getName() {
		return name;
	}//end getName
	
	public void setName(String nme) {
		name = nme;
	}//end setName
	
	
	public int getYOB() {
		return YOB;
	}//end getYOB
	

	public void setYOB(int year) {
		YOB = year;
	}//end setYOB

	
	public String getAddress() {
		return address;
	}//end getAddress
	
	public void setAddress(String add) {
		address = add;
	}//end setAddress
	
	
	public int getPhone() {
		return phone;
	}//end getPhone
	
	public void setPhone(int pne) {
		phone = pne;
	}//end setPhone
	
	
	public String getRSI() {
		return RSI;
	}//end getRSI
	
	public void setRSI(String rsiNum) {
		RSI = rsiNum;
	}//end setName


	public String getOccupation() {
		return occupation;
	}//end getOccupation
	
	public void setOccupation(String job) {
		occupation = job;
	}//end setOccupation

	
	public int calculateAge(int year) {
		return 2013 - year;
	}//end calulateAge
	
	public String toString() {
		
		String output = "Name is " + getName();
		output +="\nAge is "  + calculateAge(getYOB());
		output +="\nAddress is " + getAddress();
		output +="\nPhone Number is " + getPhone();
		output += "\nRSI Number is " + getRSI();
		output += "\nOccupation is " + getOccupation();
		return output;
	}
	
}//end class Person