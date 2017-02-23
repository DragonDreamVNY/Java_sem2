package ResourceBundleExamples;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;


public class PersonalDetailsFrame extends javax.swing.JFrame {

    //array to hold the options in the combobox
    String language[] = {"English", "French", "German", "Italian","Spanish"};

    //array of locales
    Locale locales[] = { new Locale("en"), new Locale("fr"), new Locale("de"), new Locale("it"), new Locale("es")};

   //declare and create your resource bundle
   static  ResourceBundle rb = ResourceBundle.getBundle("MyResourceBundle"); //root of the file name is the same for all resoure bundles

    //Declare a JFrame object - we need this to change the title of the Frame when a different locale is selected
    //JFrame theFrame;

    Locale locale; //reference to instance of Locale object
    
    public PersonalDetailsFrame(String title) {
  
 
        super(title);

       //assign the frame object to variable "theFrame" this makes it (the frame) available to the methods of the class
    	//later on we will need this variable (theFrame) to update its title as the user changes from Locale to Locale
    	//theFrame = this; //not needed in this example
        
       initComponents();

        // Add locale names to the combo box
    	for (int i=0; i<language.length; i++)
     		 jcboLocale.addItem(language[i]);

    } //end PersonalDetailsFrame

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblLocale = new javax.swing.JLabel();
        jcboLocale = new javax.swing.JComboBox();
        jlblName = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jlblAddress = new javax.swing.JLabel();
        jtfAddress = new javax.swing.JTextField();
        jlblPhone = new javax.swing.JLabel();
        jtfPhone = new javax.swing.JTextField();
        jlblJob = new javax.swing.JLabel();
        jtfJob = new javax.swing.JTextField();
        jbtnSubmit = new javax.swing.JButton(rb.getString("Submit_Button"));
        jbtnClear = new javax.swing.JButton(rb.getString("Clear_Button"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(6, 2));

        jlblLocale.setText(rb.getString("Choose_Locale"));
        getContentPane().add(jlblLocale);

        jcboLocale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboLocaleActionPerformed(evt);
            }
        });
        getContentPane().add(jcboLocale);

        jlblName.setText(rb.getString("Choose_Locale"));
        getContentPane().add(jlblName);

        jtfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNameActionPerformed(evt);
            }
        });
        getContentPane().add(jtfName);

        jlblAddress.setText(rb.getString("Enter_Name"));
        getContentPane().add(jlblAddress);
        getContentPane().add(jtfAddress);

        jlblPhone.setText(rb.getString("Enter_Phone"));
        getContentPane().add(jlblPhone);
        getContentPane().add(jtfPhone);

        jlblJob.setText(rb.getString("Enter_Job"));
        getContentPane().add(jlblJob);

        jtfJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfJobActionPerformed(evt);
            }
        });
        getContentPane().add(jtfJob);
        getContentPane().add(jbtnSubmit);
        getContentPane().add(jbtnClear);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfJobActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jtfJobActionPerformed

    private void jtfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNameActionPerformed

    private void jcboLocaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboLocaleActionPerformed
        //user makes selection on ComboBox object, get an integer and look up locales array, return a locale object
        //get the selected locale from the combobox
      locale = locales[jcboLocale.getSelectedIndex()];

      //call the method updateStrings which will update all the GUI components to reflect the selection of a new locale
      updateStrings();

    }//GEN-LAST:event_jcboLocaleActionPerformed

    private void updateStrings() {

       	 //load a new resource bundle based on the selection of a new locale
    	 rb = ResourceBundle.getBundle("MyResourceBundle", locale);

    	 //update all the labels, buttons and the title of the frame.
         //Resources must all be the same or NetBeans gives "Missing Resource Exception"
    	 jlblLocale.setText(rb.getString("Choose_Locale")); //look up if 'fr' is selected, then look up the keys associated and update the labels
    	 jlblName.setText(rb.getString("Enter_Name"));
	 jlblAddress.setText(rb.getString("Enter_Address"));
	 jlblPhone.setText(rb.getString("Enter_Phone"));
    	 jlblJob.setText(rb.getString("Enter_Job"));
    	 jbtnSubmit.setText(rb.getString("Submit_Button"));
    	 jbtnClear.setText(rb.getString("Clear_Button"));
         setTitle(rb.getString("Frame_Title")); //title of the Frame is localised too, with a value coming from the Key from the resource bundle
         
         //theFrame.setTitle(rb.getString("Frame_Title"));

     	 //repaint();

    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonalDetailsFrame(rb.getString("Frame_Title")).setVisible(true);
             }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnSubmit;
    private javax.swing.JComboBox jcboLocale;
    private javax.swing.JLabel jlblAddress;
    private javax.swing.JLabel jlblJob;
    private javax.swing.JLabel jlblLocale;
    private javax.swing.JLabel jlblName;
    private javax.swing.JLabel jlblPhone;
    private javax.swing.JTextField jtfAddress;
    private javax.swing.JTextField jtfJob;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPhone;
    // End of variables declaration//GEN-END:variables

}
