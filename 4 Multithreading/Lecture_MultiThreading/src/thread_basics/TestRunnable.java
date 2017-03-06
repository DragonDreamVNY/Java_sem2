package thread_basics;
// TestRunnable.java: Define threads using the Runnable interface
public class TestRunnable {
  /**Main method*/
  public static void main(String[] args) {
    new TestRunnable();
  }

  /**Default constructor*/
  public TestRunnable() {
    // Create threads
    Thread printA = new Thread( new PrintChar('a', 100) ); 
    Thread printB = new Thread( new PrintChar('b', 100) );//output is different everytime as the threads are juggled around by the System.
    Thread print100 = new Thread( new PrintNum(100) );// However it is possible to give a thread priortity
    
    //Start threads
    print100.start();
    printA.start();
    printB.start();
  }
//implement is an interface from API because no multiple inheritance in Java
// ie Class Thingy extends JFrame implements Runnable
  // The thread class for printing a specified character
  // in specified times
  class PrintChar implements Runnable { 
    private char charToPrint;  // The character to print
    private int times;  // The times to repeat

    /**Construct a thread with specified character and number of
       times to print the character
     */
    public PrintChar(char c, int t) {
      charToPrint = c;
      times = t;
    }

    /**Override the run() method to tell the system
       what the thread will do
     */
    public void run() {
      for (int i=0; i<=times; i++)
        System.out.print(charToPrint);
    }
  }

  // The thread class for printing number from 1 to n for a given n
  class PrintNum implements Runnable {
    private int lastNum;

    /**Construct a thread for print 1, 2, ... i*/
    public PrintNum(int n) { //pass in 100 numbers, PrintNum prints 100 of them
      lastNum = n;
    }

    /**Tell the thread how to run*/
    public void run() {
      for (int i=1; i <= lastNum; i++)
        System.out.print(" " + i);
    }
  }
}