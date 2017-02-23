package Standard;

import java.awt.GraphicsEnvironment;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
* @author Alan Ryan
*/

public class FancyClock extends javax.swing.JFrame {

    DateFormat formatter;
	String language = "ENGLISH";
	String country = "IRELAND";
	Locale locale = new Locale(language, country);
	String today; //holds today's date and time
	Locale locales[] = Calendar.getAvailableLocales();


    
    public FancyClock() {

        initComponents();

        setLocale(); //gets current date and time from computer

		timeLabel.setText(today); //String has been formatted below in the setLocale method

		// Initialize the combo box to add locale names. Add each of the locales array into the combobox
    	for (int i=0; i<locales.length; i++)
      		localesComboBox.addItem(locales[i].getDisplayName()); //use display name, otherwise you won't make sense of the Country Codes IE, US, CA, PO blah blah bnlah

        localesComboBox.setSelectedItem("English"); //set selected item as English... otherwise when it runs Nothing will be in the comboBox
        //NOTE event handler in comboBox from GUI/awt
    }

    public void setLocale() {

        GregorianCalendar cal = new GregorianCalendar();
        
        formatter = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale); //pass these three arguments into the method. LONG is how the date is displayed, February vs Feb vs 2... Date, Time, Locale 
        //get a calendar with current time, format it, assign it to the String variable to display
        today = formatter.format(cal.getTime()); 
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeLabel = new javax.swing.JLabel();
        localesComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Using Localisation");

        timeLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        timeLabel.setText("jLabel1");

        localesComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        localesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localesComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeLabel)
                    .addComponent(localesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(timeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(localesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void localesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localesComboBoxActionPerformed
        //user selects an item from ComboBox. //take index and looks up the locale for that index in array. 
        locale = locales[localesComboBox.getSelectedIndex()]; 
        //format the date and times based on that locale 
    	setLocale(); 

        timeLabel.setText(today);
    }//GEN-LAST:event_localesComboBoxActionPerformed

 
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FancyClock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox localesComboBox;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables

}
