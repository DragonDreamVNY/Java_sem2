package thread_basics;

//A class to create three threads, assign them a priority and then run them
public class TestThread {

  /**Main method*/
  public static void main(String[] args) {

    // Create threads
    PrintChar printA = new PrintChar('a', 100);
    PrintChar printB = new PrintChar('b', 100);
    PrintNum  print100 = new PrintNum(100);
  
    // Start threads
    print100.start();
    printA.start();
    printB.start();


  }//end main
}//end class Test Thread

// The thread class for printing a specified character a specified number of times
class PrintChar extends Thread {

  private char charToPrint;  // The character to print
  private int times;  // The times to repeat

  //Construct a thread with specified character and number of times to print the character

  public PrintChar(char c, int t) {
    charToPrint = c;
    times = t;
  }

  //tell the system what the thread will do in run()
  public void run() {
    for (int i=0; i<times; i++)
      System.out.print(charToPrint);
  }//end run
}//end class PrintChar

// The thread class for printing number from 1 to n for a given n
class PrintNum extends Thread {

  private int lastNum;

  //Construct a thread for print 1, 2, ... i
  public PrintNum(int n) {
    lastNum = n;
  }

  //tell the system what the thread will do in run()
  public void run() {
    for (int i=1; i <= lastNum; i++)
      System.out.print(" " + i);
  }//end run

}//end class PrintNum