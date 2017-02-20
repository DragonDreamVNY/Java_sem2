package Standard;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;

public class NumberFormatDemo extends javax.swing.JFrame {

    // Current locale
    Locale locale = Locale.getDefault();

    // Declare locales to store available locales
    Locale locales[] = Calendar.getAvailableLocales();

    public NumberFormatDemo() {


        initComponents();
        initialiseComboBox();


    }

    /**Initialize the combo box*/
    public void initialiseComboBox() {


        // Add locale names to the combo box
        for (int i = 0; i < locales.length; i++) {
            jcboLocale.addItem(locales[i].getDisplayName());
        }


    } //end initializeComboBox()

    private void computeMortgage() {

        double loan = 0.0;
        double interestRate = 0.0;
        int numOfYears = 0;

        // Retrieve input from user
        try {

            loan = new Double(jtfLoanAmount.getText()).doubleValue();
            interestRate = new Double(jtfInterestRate.getText()).doubleValue() / 1200;
            numOfYears = new Integer(jtfNumOfYears.getText()).intValue();

        } catch (NumberFormatException nfe) {

            JOptionPane.showMessageDialog(null, "Please Enter Numeric Data\n" + nfe.toString());
        }

        // Calculate payments
        double monthlyPayment = loan * interestRate / (1 - (Math.pow(1 / (1 + interestRate), numOfYears * 12)));
        double totalPayment = monthlyPayment * numOfYears * 12;

        // Get formatters
        NumberFormat percentFormatter = NumberFormat.getPercentInstance(locale);
        NumberFormat currencyForm = NumberFormat.getCurrencyInstance(locale);
        NumberFormat numberForm = NumberFormat.getNumberInstance(locale);
        percentFormatter.setMinimumFractionDigits(2);

        // Display formatted input
        jtfFormattedInterestRate.setText(percentFormatter.format(interestRate * 12));
        jtfFormattedNumOfYears.setText(numberForm.format(numOfYears));
        jtfFormattedLoanAmount.setText(currencyForm.format(loan));

        // Display results in currency format
        jtfMonthlyPayment.setText(currencyForm.format(monthlyPayment));
        jtfTotalPayment.setText(currencyForm.format(totalPayment));

    }//end computeMortgage() method

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcboLocale = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfInterestRate = new javax.swing.JTextField();
        jtfNumOfYears = new javax.swing.JTextField();
        jtfLoanAmount = new javax.swing.JTextField();
        jtfFormattedInterestRate = new javax.swing.JTextField();
        jtfFormattedNumOfYears = new javax.swing.JTextField();
        jtfFormattedLoanAmount = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfMonthlyPayment = new javax.swing.JTextField();
        jtfTotalPayment = new javax.swing.JTextField();
        computePaymentJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose A Locale"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jcboLocale.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jcboLocale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcboLocaleItemStateChanged(evt);
            }
        });
        jcboLocale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboLocaleActionPerformed(evt);
            }
        });
        jPanel1.add(jcboLocale, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter Interest Rate, Number of Years and Loan Amount"));

        jLabel1.setText("Interest Rate");

        jLabel2.setText("Number of Years");

        jLabel3.setText("Loan Amount");

        jtfInterestRate.setText("4.5");
        jtfInterestRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfInterestRateActionPerformed(evt);
            }
        });

        jtfNumOfYears.setText("33");

        jtfLoanAmount.setText("250000");

        jtfFormattedInterestRate.setEditable(false);

        jtfFormattedNumOfYears.setEditable(false);

        jtfFormattedLoanAmount.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfLoanAmount)
                    .addComponent(jtfNumOfYears)
                    .addComponent(jtfInterestRate, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfFormattedLoanAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jtfFormattedNumOfYears, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jtfFormattedInterestRate, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFormattedInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNumOfYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFormattedNumOfYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfLoanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFormattedLoanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Payment"));

        jLabel4.setText("Monthly Payment");

        jLabel5.setText("Total Payment");

        jtfMonthlyPayment.setEditable(false);

        jtfTotalPayment.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTotalPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jtfMonthlyPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfMonthlyPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfTotalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        computePaymentJButton.setText("Compute Payment");
        computePaymentJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computePaymentJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(computePaymentJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(computePaymentJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcboLocaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboLocaleActionPerformed
    }//GEN-LAST:event_jcboLocaleActionPerformed

    private void computePaymentJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computePaymentJButtonActionPerformed

        computeMortgage();

    }//GEN-LAST:event_computePaymentJButtonActionPerformed

    private void jcboLocaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcboLocaleItemStateChanged

        locale = locales[jcboLocale.getSelectedIndex()];
        computeMortgage();
    }//GEN-LAST:event_jcboLocaleItemStateChanged

    private void jtfInterestRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfInterestRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfInterestRateActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NumberFormatDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton computePaymentJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox jcboLocale;
    private javax.swing.JTextField jtfFormattedInterestRate;
    private javax.swing.JTextField jtfFormattedLoanAmount;
    private javax.swing.JTextField jtfFormattedNumOfYears;
    private javax.swing.JTextField jtfInterestRate;
    private javax.swing.JTextField jtfLoanAmount;
    private javax.swing.JTextField jtfMonthlyPayment;
    private javax.swing.JTextField jtfNumOfYears;
    private javax.swing.JTextField jtfTotalPayment;
    // End of variables declaration//GEN-END:variables
}
