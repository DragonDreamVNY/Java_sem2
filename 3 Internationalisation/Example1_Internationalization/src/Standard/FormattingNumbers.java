package Standard;

import java.awt.GraphicsEnvironment;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class FormattingNumbers extends javax.swing.JFrame {

    double aMoneyValue = 1234567.89;
    double aPercentValue = .2898;
    double aNumberValue = 1234567.89;

    String language = "ENGLISH";
	String country = "IRELAND";
	Locale locale = new Locale(language, country); //create locale object

    Locale locales[] = Calendar.getAvailableLocales(); //array of all locales
    
    public FormattingNumbers() {
        initComponents();
        
        //Thai Characters...
        //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //ge.getAllFonts();

        for (int i=0; i<locales.length; i++)
      		localesComboBox.addItem(locales[i].getDisplayName());

        setLabels();
    }

    public void setLabels() {
        
        NumberFormat percentFormatter = NumberFormat.getPercentInstance(locale);
    	NumberFormat currencyForm = NumberFormat.getCurrencyInstance(locale);
    	NumberFormat numberForm = NumberFormat.getNumberInstance(locale);
    	percentFormatter.setMinimumFractionDigits(2);
    	moneyLabel.setText("Money Value = " + currencyForm.format(aMoneyValue));
    	percentLabel.setText("Percentage Value = " + percentFormatter.format(aPercentValue));
    	numberLabel.setText("Number Value = " + numberForm.format(aNumberValue));
  	}

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moneyLabel = new javax.swing.JLabel();
        percentLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        localesComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formatting Numbers");

        moneyLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        moneyLabel.setText("jLabel1");

        percentLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        percentLabel.setText("jLabel1");

        numberLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        numberLabel.setText("jLabel1");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moneyLabel)
                    .addComponent(percentLabel)
                    .addComponent(numberLabel)
                    .addComponent(localesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(336, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(moneyLabel)
                .addGap(53, 53, 53)
                .addComponent(percentLabel)
                .addGap(53, 53, 53)
                .addComponent(numberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(localesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void localesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localesComboBoxActionPerformed
        locale = locales[localesComboBox.getSelectedIndex()];
    	setLabels();
    }//GEN-LAST:event_localesComboBoxActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormattingNumbers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox localesComboBox;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JLabel percentLabel;
    // End of variables declaration//GEN-END:variables

}
