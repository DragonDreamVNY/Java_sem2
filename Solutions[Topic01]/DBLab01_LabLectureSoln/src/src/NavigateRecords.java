package src;

import java.sql.*;
import javax.swing.JOptionPane;


public final class NavigateRecords extends javax.swing.JFrame {
    
    ResultSet resultSet;

    /** Creates new form NavigateRecords */
    public NavigateRecords() {
        initComponents();

        try {

              //create the connection object
              //ATTN: username and password must be changed depending on the settings on your database server
              Connection connection = DriverManager.getConnection("jdbc:mysql://itshares.student.litdom.lit.ie:3306/books", "sd3user", "pass");

              //create a statement object.
	      //We will use this object to carry our query to the database
	      Statement statement = connection.createStatement();

              //exexute our query, which will lead to the return of a resultset
	      resultSet = statement.executeQuery("SELECT * FROM authors");

              if (resultSet.next()) {
                loadRecord();
              } //end if
      
              else {
                JOptionPane.showMessageDialog(null, "There are no records in the database");
              } //end else
        }//end try

	catch(SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.exit(0);
	}
    }
    
    //get the results from columns 1,2,3 and stores them in local variables
    public void loadRecord() {
        
        try  {
            String authorsID = resultSet.getObject(1).toString(); // can also use  '= rresultSet.getString("FirstName")' as shorthand
            String authorsFirstName = resultSet.getObject(2).toString();
            String authorsSecondName = resultSet.getObject(3).toString();

            authorIDTextfield.setText(authorsID);
            fnameTextField.setText(authorsFirstName);
            lnameTextfield.setText(authorsSecondName);    
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR " + ex);
        }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recordsPanel = new javax.swing.JPanel();
        authorIDLabel = new javax.swing.JLabel();
        authorIDTextfield = new javax.swing.JTextField();
        fnameLabel = new javax.swing.JLabel();
        fnameTextField = new javax.swing.JTextField();
        lnameLabel = new javax.swing.JLabel();
        lnameTextfield = new javax.swing.JTextField();
        controlPanel = new javax.swing.JPanel();
        firstButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display Records From Books Database");
        setMinimumSize(new java.awt.Dimension(250, 150));

        recordsPanel.setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        authorIDLabel.setText("Author ID");
        recordsPanel.add(authorIDLabel);

        authorIDTextfield.setEditable(false);
        recordsPanel.add(authorIDTextfield);

        fnameLabel.setText("First Name");
        recordsPanel.add(fnameLabel);

        fnameTextField.setEditable(false);
        recordsPanel.add(fnameTextField);

        lnameLabel.setText("Last Name");
        recordsPanel.add(lnameLabel);

        lnameTextfield.setEditable(false);
        recordsPanel.add(lnameTextfield);

        getContentPane().add(recordsPanel, java.awt.BorderLayout.CENTER);

        firstButton.setText("First");
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });
        controlPanel.add(firstButton);

        nextButton.setText("Next >>");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        controlPanel.add(nextButton);

        previousButton.setText("<< Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        controlPanel.add(previousButton);

        lastButton.setText("Last");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });
        controlPanel.add(lastButton);

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        controlPanel.add(exitButton);

        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-338)/2, 416, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        try  {
            if (resultSet.next()) {
                loadRecord();
            }
            else {
                JOptionPane.showMessageDialog(null, "You have reached the end of the list");
                resultSet.last(); //repositions the cursor to last record
            }
        }//end try
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }//end catch
    }//GEN-LAST:event_nextButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        try  {
            if (resultSet.previous()) {
                loadRecord();
            }
            else {
                JOptionPane.showMessageDialog(null, "You have reached the start of the list");
                resultSet.first(); // handler for the cursor, repositions it to the first record 
            }
        }//end try
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }//end catch
    }//GEN-LAST:event_previousButtonActionPerformed

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        try {
            resultSet.first();
            loadRecord();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }
    }//GEN-LAST:event_firstButtonActionPerformed

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
       try {
            resultSet.last(); 
            loadRecord();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex);
        }
    }//GEN-LAST:event_lastButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NavigateRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorIDLabel;
    private javax.swing.JTextField authorIDTextfield;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton firstButton;
    private javax.swing.JLabel fnameLabel;
    private javax.swing.JTextField fnameTextField;
    private javax.swing.JButton lastButton;
    private javax.swing.JLabel lnameLabel;
    private javax.swing.JTextField lnameTextfield;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JPanel recordsPanel;
    // End of variables declaration//GEN-END:variables

}
