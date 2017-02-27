/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsecreditcardfile;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan.Ryan
 */
public class CreditCardUtility {

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

    public static boolean checkVisa(String cardNum) {

        return ((cardNum.startsWith("4")) && (isValidNumber(cardNum)) && cardNum.length() == 16);

    }

    public static boolean checkMastercard(String cardNum) {

        return ((cardNum.startsWith("51")) || (cardNum.startsWith("53")) || (cardNum.startsWith("55"))) && ((isValidNumber(cardNum)) && cardNum.length() == 16);

    }

    public static String generateCCNumber(String prefix, int length) {

        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(CreditCardUtility.class.getName()).log(Level.SEVERE, null, ex);
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

    }

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
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }

        // The check digit is the number required to make the sum a multiple of
        // 10.
        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }

    public static int generateRandomNumber(int min, int max) {
        Random rand = new Random();

        return rand.nextInt((max - min) + 1) + min;
    }

}
