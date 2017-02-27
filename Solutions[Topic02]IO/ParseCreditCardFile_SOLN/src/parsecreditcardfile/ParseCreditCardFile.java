package parsecreditcardfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Calendar;

public class ParseCreditCardFile {

    public static void main(String[] args) {
        
        
        //3 different prefixes for mastercard
        String [] masterCardPrefixes = {"51","53","55"};

        //Calendar to store the current date
        Calendar now  = Calendar.getInstance();
        
        //Calendar to store the date from the file
        Calendar dateFromFile = Calendar.getInstance();
           
        // Declare file reader and writer streams
        FileReader frs = null;
        FileWriter fws = null;

        // Declare streamTokenizer
        StreamTokenizer in = null;

        // Declare a print stream
        PrintWriter out = null;

        try {
            // Create file input and output streams
            frs = new FileReader("cctestdata.txt");
            fws = new FileWriter("validdata.txt");

            // Create a stream tokenizer wrapping file input stream
            in = new StreamTokenizer(frs);
            out = new PrintWriter(fws);

            //set the - character as a "ordinary" char
            in.ordinaryChar('/');

            // Read past col headings.
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();
            in.nextToken();

            //read first token of first row (Title)
            in.nextToken();

            //print col heads to second file
            out.println("Title\tFirstName\tMI\tLastName\tCardType\tCardNumber\tExpiry\tCVV");

            // Process a record
            while (in.ttype != StreamTokenizer.TT_EOF) {

                if (in.ttype == StreamTokenizer.TT_WORD) {
                    out.print(in.sval + "\t");
                } else {
                    System.out.println("Bad file structure");
                }

                //read next token (FirstName)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    out.print(in.sval + "\t\t");
                } else {
                    System.out.println("Bad file structure");
                }

                //read next token (MI)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    out.print(in.sval + "\t");
                } else {
                    System.out.println("Bad file structure");
                }

                //read next token (LasttName)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    out.print(in.sval + "\t\t");
                } else {
                    System.out.println("Bad file structure");
                }

           
                //read next token (CardType)
                in.nextToken();
                String cType = "";
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    cType = in.sval;
                    out.print(cType + "\t");
                } else {
                    System.out.println("Bad file structure");
                }

                //read next token (CardNumber)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_NUMBER) {

                    //read ccnum from the file and cast it to a long
                    long ccnum = (long) in.nval;
                    
                    //convert the ccnum (which is a long) to a string
                    String cNumAsString = String.valueOf(ccnum);

                    if (cType.equalsIgnoreCase("visa")) {
                        if (!CreditCardUtility.checkVisa(cNumAsString)) {

                            //we have encountered an invalid ccnum so 
                            //generate a new 16 digit visa number
                            String newCCNum = CreditCardUtility.generateCCNumber("4", 16);
                            
                            //print newly generated ccnum to the second file
                            out.print(newCCNum + "\t");

                        }//end if
                        
                        else {

                            //if the ccnum from the orginal file is valid, just print it to the second file
                            out.print(cNumAsString + "\t");

                        }//end else
                    
                    }//end if
                    
                    else if (cType.equalsIgnoreCase("mastercard")) {
                        if (!CreditCardUtility.checkMastercard(cNumAsString)) {

                            //we have encountered an invalid ccnum so 
                            //generate a new 16 digit mastercard number
                            
                            int rand = CreditCardUtility.generateRandomNumber(0,2);
                            String newCCNum = CreditCardUtility.generateCCNumber(masterCardPrefixes[rand], 16);
                            
                            //print newly generated ccnum to the second file
                            out.print(newCCNum + "\t");

                        }//end if
                        
                        else {

                            //if the ccnum from the orginal file is valid, just print it to the second file
                            out.print(cNumAsString + "\t");

                        }//end else

                    }//end else

                }//end if
                
                else {
                    System.out.println("Bad file structure");
                }//end else

                //read next token (Month)
                in.nextToken();
                int month = 0;
                if (in.ttype == StreamTokenizer.TT_NUMBER) {
                    month = (int) in.nval;
            
                } else {
                    System.out.println("Bad file structure");
                }

                //read delimiter 
                in.nextToken();
             

                //read next token (Year)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_NUMBER) {
                    
                    int year = (int) in.nval;
                    
                    dateFromFile.set(Calendar.MONTH, month-1);
                    dateFromFile.set(Calendar.YEAR, year);
                    
                    if (dateFromFile.before(now)) {
                        //generate new month
                        month = CreditCardUtility.generateRandomNumber(now.get(Calendar.MONTH)+1, 12);
                        
                        //generate new year
                        year = CreditCardUtility.generateRandomNumber(now.get(Calendar.YEAR),now.get(Calendar.YEAR)+6);
                    }
                    
                   //print month, delimeter and year to the second file
                   out.print(month + "/" + year + "\t");
                
                }//end if

                //read next token (CVV)
                in.nextToken();
                if (in.ttype == StreamTokenizer.TT_NUMBER) {
                    int cvv = (int) in.nval;
                    out.print(cvv);
                } else {
                    System.out.println("Bad file structure");
                }

                //skip a line in out file
                out.println();
                
                //read next token
                in.nextToken();

            }//end while

            System.out.println("Parsing file complete  - check validdata.txt");

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: in.dat");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (frs != null) {
                    frs.close();
                }
                if (fws != null) {
                    fws.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

}
