package creditcardparse_ex03;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author k00223361 Vincent Lee DRAGONDREAM
 * Ref: https://notendur.hi.is/snorri/SDK-docs/lang/lang231.htm
 */

public class CreditCardParse_ex03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FileReader fileReadSt = null;
        FileWriter fileWriteSt = null;

        StreamTokenizer inStream = null;
        PrintWriter outStream = null;
        //DecimalFormat cardDecFormat = new DecimalFormat("################");

        //8 params
        String title = null;        // 0.  FIRST TOKEN     Title
        String firstName = null;    // 1.  SECOND TOKEN    First Name
        String midIntl = null;      // 2. THIRD TOKEN      MI
        String lastName = null;     // 3. FOURTH TOKEN     Last Name
        String cardType = null;     // 4. FIFTH TOKEN      Card Type
        double cardNumber = 0;   // 5. SIXTH TOKEN      CardNumber /convert to String later for validation method?
        String expiry = null;       // 6. SEVENTH TOKEN    Expiry xx/xxxx
        double cvv = 0;          // 7. EIGTH TOKEN      CVV

        // valid card params for Luhn Mod10 test
        // note: Mastercards must stat with 51, 53 or 55
        // noteL VISA must start with 4...
        double newCardNumber = 0;
        String newExpiry = null;
        double newCVV = 0;

        //for formatted column width
        String titleHeading = "Title";
        String firstNameHeading = "FirstName";
        String initialHeading = "MI";
        String lastNameHeading = "LastName";
        String cardTypeHeading = "CardType";
        String cardNumberHeading = "CardNumber";
        String expiryHeading = "Expiry";
        String cvvHeading = "CVV";

        try{
            String output = ""; //for second File

            fileReadSt = new FileReader("cctestdata.txt");
            fileWriteSt = new FileWriter("ccData_corrected.txt");

            inStream = new StreamTokenizer(fileReadSt);
            outStream = new PrintWriter(fileWriteSt);

            //This means the car reg will be available as 2 tokens
            //For example: 06/2018, this doesn't affect the header column

            //inStream.ordinaryChar('/'); //DON'T NEED THIS. Date will be STRING!!!

            //skip the column headers first..
            for (int i = 0; i < 8; i++){
                inStream.nextToken();
            }

            //position on first token (Title)  Hello 'Mr'
            inStream.nextToken();

            // Process a record
            while (inStream.ttype != StreamTokenizer.TT_EOF) {

                // // FIRST token is... (Title MR MRS MS)
                if (inStream.ttype == StreamTokenizer.TT_WORD) {
                title = inStream.sval;
                System.out.println(title);
                }
                else
                    System.out.println("Bad file format - what's the Title?");

              //read SECOND token (FirstName)
                inStream.nextToken();
                if (inStream.ttype == StreamTokenizer.TT_WORD) {
                    firstName = inStream.sval;
                    System.out.print("\t" + firstName);
                }
                else
                System.err.println("Bad file format - FirstName?");

                //read THIRD token (MI)
                inStream.nextToken();
                if (inStream.ttype == StreamTokenizer.TT_WORD){
                    midIntl = inStream.sval;
                    System.out.print("\t" + midIntl);
                }
                else
                    System.err.println("Bad file format - Initials?");

                //read FOURTH token (LastName)
                inStream.nextToken();
                if (inStream.ttype == StreamTokenizer.TT_WORD){
                    lastName = inStream.sval;
                    System.out.print("\t" + lastName);
                }
                else
                    System.out.println("Bad file format - Last Name?");

                //read FIFTH token (CardType) Visa | MasterCard
                inStream.nextToken();
                if (inStream.ttype == StreamTokenizer.TT_WORD){
                    cardType = inStream.sval;
                    System.out.print("\t" + cardType);
                }
                else
                    System.err.println("Bad file format - VISA/MasterCard?");

                //read SIXTH token (CardNumber)
                inStream.nextToken();
                //inStream.toString(); //The current token and the current line number are converted to a string of the form: "Token[x], line m"
                if (inStream.ttype == StreamTokenizer.TT_NUMBER){
                    //cardNumber = inStream.nval; 
                    //cardNumber = String.valueOf(inStream.nval); //convert double to String
                    cardNumber = (long)(inStream.nval); //convert to long
                    System.out.print("\t" + cardNumber);
                }
                else
                    System.err.println("Bad file format - what CC Number?");

                //read SEVENTH token (Expiry date)  is a String!!!! No need to split token
                inStream.nextToken();
                if (inStream.ttype == StreamTokenizer.TT_WORD){
                    expiry = inStream.sval; // 'xx/xxxx'
                    System.out.print("\t" + expiry);
                }
                else
                    System.err.println("Bad file format - Expiry Date?");

                //read EIGHT token (CVV)
                inStream.nextToken();
                if (inStream.ttype == StreamTokenizer.TT_NUMBER){
                    //cvv = String.valueOf(inStream.nval); // because I need them for validation methods
                    cvv = (int)inStream.nval; // because I need them for validation methods
                    System.out.print("\t" + cvv);
                }
                else
                    System.err.println("Bad file format - what CVV ?");

                // Mr Sam D Wall Visa 4485908554332601 11/2007 209
                output += "\n" + title + "\t" + firstName + "\t\t" + midIntl + "\t" + lastName + "\t\t" + cardType + "\t" + cardNumber + "\t" + expiry + "\t" + cvv;

                //read next token, should be new Row or NextLine at Title token
                inStream.nextToken();
            }//end while


            //print info to second file
            // formatted Columns (title, firstname, MI, lastName, cardType, cardNumber, expiry, cvv)
            outStream.printf("%-7s %-15s %-5s %-15s %-15s %-20s %-10s %-5s", titleHeading, firstNameHeading, initialHeading, lastNameHeading, cardTypeHeading , cardNumberHeading, expiryHeading , cvvHeading);
            outStream.println(output);
            System.out.println("\nData written to file : \'ccData_corrected.txt\'  ");
            
            //display message dialog which contains the text area
            //Note if it writes to JTextArea it doesn't write to outStream at all???? - useful for debugging at least...
            JTextArea jta = new JTextArea(output);
            JOptionPane.showMessageDialog(null, jta);
            
            //-----Test-----
           /*
            //validate four possible cc nums - does not vaidate based on card type, or length of digits - just on the Luhn test
            System.out.println("4485908554332601 is a valid number? " + isValidNumber("4485908554332601"));
            System.out.println("5559288160422144 is a valid number? " + isValidNumber("5559288160422144"));
            System.out.println("5596749989807707 is a valid number? " + isValidNumber("5596749989807707"));
            System.out.println("5596749989807707 is a valid number? " + isValidNumber("446667651"));

            //generate three cc nums
            System.out.println(generateCCNumber("4", 16)); //generate a visa,  '4' goes into the Prefix
            System.out.println(generateCCNumber("55", 16)); //generate a mastercard, '55' goes into the Prefix. Consider letting user enter 51,53, or 55?
            //-----end Test-----
           */


        }//end try

        catch(FileNotFoundException ex)   {
            System.out.println("File not found: in.dat");
        }
        catch (IOException ex)   {
            System.out.println(ex.getMessage());
        }
        finally   {
            try {
                if (fileReadSt != null) fileReadSt.close();
                if (fileWriteSt != null) fileWriteSt.close();
            }
            catch (IOException ex)  {
                System.out.println(ex);
            }
        }//end finally

    }// end main

    //newDate method to go HERE
    private static String newDate(String expiryDate) {
        // new calendar object to hold current date
        Calendar todayExpiryDate = Calendar.getInstance();
        Calendar newExpiryDate = Calendar.getInstance();

        //set month in new Date, and year 2016
        newExpiryDate.set(Calendar.MONTH, Calendar.JANUARY);
        newExpiryDate.set(Calendar.YEAR, 2016);

        System.out.println(todayExpiryDate.before(newExpiryDate));
        return newExpiryDate.toString();

    }//end newExpiryDate

    //******Alan's validator methods*******
    /**
     * Checks whether a string of digits is a valid credit card number according
     * to the Luhn algorithm.
     *
     * 1. Starting with the second to last digit and moving left, double the
     * value of all the alternating digits. For any digits that thus become 10
     * or more, add their digits together. For example, 1111 becomes 2121, while
     * 8763 becomes 7733 (from (1+6)7(1+2)3).
     *
     * 2. Add all these digits together. For example, 1111 becomes 2121, then
     * 2+1+2+1 is 6; while 8763 becomes 7733, then 7+7+3+3 is 20.
     *
     * 3. If the total ends in 0 (put another way, if the total modulus 10 is
     * 0), then the number is valid according to the Luhn formula, else it is
     * not valid. So, 1111 is not valid (as shown above, it comes out to 6),
     * while 8763 is valid (as shown above, it comes out to 20).
     *
     * @param number the credit card number to validate.
     * @return true if the number is valid, false otherwise.
     */
    private static boolean isValidNumber(String cardNumber) {
        int sum = 0;

        for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(cardNumber.substring(i, i + 1));
            if (i > 0) {
                int d = 2 * Integer.parseInt(cardNumber.substring(i - 1, i));
                if (d > 9) {
                    d -= 9;
                }
                sum += d;
            }//end if
        }//end for

        return sum % 10 == 0;
    }//end method isValidNumber

    /**
    * Returns a valid credit card number based on prefix and a card length
    *
    * @parm prefix  - the prefix for the newly generated credit card number
    * @param length - the number of digits the newly generated credit card number will have
    */
    public static String generateCCNumber(String prefix, int length) {

        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        Random random = new Random(System.currentTimeMillis());

        // The number of random digits that we need to generateCCNumber is equal to the
        // total length of the card number minus the start digits given by the
        // user, minus the check digit at the end.
        int randomNumberLength = length - (prefix.length() + 1);

        StringBuilder builder = new StringBuilder(prefix);
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }

        // Do the Luhn algorithm to generateCCNumber the check digit.
        int checkDigit = getCheckDigit(builder.toString());
        builder.append(checkDigit);

        return builder.toString();

    } //end GenerateCC


    private static int getCheckDigit(String number) {

        // Get the sum of all the digits, however we need to replace the value
        // of the first digit, and every other digit, with the same digit
        // multiplied by 2. If this multiplication yields a number greater
        // than 9, then add the two digits together to get a single digit
        // number.
        //
        // The digits we need to replace will be those in an even position for
        // card numbers whose length is an even number, or those is an odd
        // position for card numbers whose length is an odd number. This is
        // because the Luhn algorithm reverses the card number, and doubles
        // every other number starting from the second number from the last
        // position.
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {

            // Get the digit at the current position.
            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10); // if two digits, add the first digit with seocnd digit
                }
            }
            sum += digit;
        }

        // The check digit is the number required to make the sum a multiple of
        // 10.
        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }//end CheckDigit


} // end Credit Card Parsing class
