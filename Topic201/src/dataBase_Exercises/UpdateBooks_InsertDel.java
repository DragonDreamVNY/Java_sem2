package dataBase_Exercises;

import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

/**
 *
 * @author Vincent Lee k00223361
 * Display Books with JFrame interface
 */
public class UpdateBooks_InsertDel extends javax.swing.JFrame {
    /*some global variables*/
    ResultSet resultSet;
    Connection connection; 
    Statement statement;
    
    
    public UpdateBooks_InsertDel() {
        initComponents();
    
        int number =0;
        try {
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/books", "sduser", "pass");
            System.out.println("connection established at " + connection); 

            statement = connection.createStatement();
            
            String query = "SELECT * FROM authors";  
            resultSet = statement.executeQuery(query);
            
            resultSet.first(); //position cursor at first record
            input(); //set textfields
            System.out.println("displaying from \'AUTHORS\' Table");
        }//end try
        catch(SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.out.println("Error Connecting, check your port no");
            System.exit(0);
        }
        

    }//end 'UpdateBooks_InsertDel' class
    
    private void input(){
        try{
            String authorID = resultSet.getObject(1).toString(); 
            String firstName = resultSet.getObject(2).toString();
            String lastName = resultSet.getObject(3).toString();
            
            authorIDTextField.setText(authorID);
            firstNameTextField.setText(firstName);
            lastNameTextField.setText(lastName);
        } catch (SQLException sqlex) {
            System.out.println("input to String is wrong \nCouldn't set textfields");
        } //end try catch
    }// end input
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        prevBtn = new javax.swing.JButton();
        lastBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        authorIDTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        authorLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        del_Btn = new javax.swing.JButton();
        upd_Btn = new javax.swing.JButton();
        ins_Btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        firstBtn.setText("First");
        firstBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstBtnActionPerformed(evt);
            }
        });

        nextBtn.setText("Next >>");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        prevBtn.setText("<< Previous");
        prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtnActionPerformed(evt);
            }
        });

        lastBtn.setText("Last");
        lastBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("EXIT");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        authorIDTextField.setEnabled(false);
        authorIDTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authorIDTextFieldMouseClicked(evt);
            }
        });
        authorIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorIDTextFieldActionPerformed(evt);
            }
        });

        firstNameTextField.setEnabled(false);
        firstNameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstNameTextFieldMouseClicked(evt);
            }
        });

        lastNameTextField.setEnabled(false);
        lastNameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastNameTextFieldMouseClicked(evt);
            }
        });
        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        authorLabel.setText("AuthorID");

        firstNameLabel.setText("First Name");

        lastNameLabel.setText("Last Name");

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        del_Btn.setText("Delete");
        del_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_BtnActionPerformed(evt);
            }
        });

        upd_Btn.setText("Update");
        upd_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upd_BtnActionPerformed(evt);
            }
        });

        ins_Btn.setText("Insert");
        ins_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ins_BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(firstBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(prevBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(lastBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(ins_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upd_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(del_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitBtn)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel)
                    .addComponent(authorLabel)
                    .addComponent(lastNameLabel))
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLabel))
                .addGap(14, 14, 14)
                .addComponent(firstBtn)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextBtn)
                            .addComponent(prevBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exitBtn)
                            .addComponent(ins_Btn)
                            .addComponent(upd_Btn)
                            .addComponent(del_Btn))
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstBtnActionPerformed
        // FIRST Button code goes here
        try{
            if (resultSet.first() ){
                input();
                firstBtn.setEnabled(false);
                prevBtn.setEnabled(false);
                lastBtn.setEnabled(true);
                nextBtn.setEnabled(true);
            }
            else{
                resultSet.first();
            }
        }//end try
        
        catch(Exception sqlex) {
            System.out.println("First Button is borked");
            System.exit(0);
	}//end catch
        
    }//GEN-LAST:event_firstBtnActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void authorIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorIDTextFieldActionPerformed
        // AuthorID textfield code goes here
        
    }//GEN-LAST:event_authorIDTextFieldActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // Next button goes here
        try{
            if(resultSet.next() ){ //if checks that there are records in the table
                prevBtn.setEnabled(true);
                input();
            }
            else{
                resultSet.last();
                System.out.println("last");
            }
        }
        catch(Exception sqlex){
            System.out.println("next button is borked");
        }
        
    }//GEN-LAST:event_nextBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // 'EXIT Stage Right!': Pink Panther
        try{
            statement.close();
            connection.close();
            System.out.println("connection closed \nExiting");
            System.exit(0);
        }
        catch(SQLException sqlex) {
            System.out.println("exit is wrong");
        } //end try catch
    }//GEN-LAST:event_exitBtnActionPerformed

    private void lastBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastBtnActionPerformed
        // Last Button code here:
        try{
            if (resultSet.last() ){
                input();
                lastBtn.setEnabled(false);
                nextBtn.setEnabled(false);
                firstBtn.setEnabled(true);
                prevBtn.setEnabled(true);
            }
        }
        catch(Exception sqlex){
            System.out.println("last button is borked");
        } // end catch
        
    }//GEN-LAST:event_lastBtnActionPerformed

    private void prevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBtnActionPerformed
        // Previous Button code here:
        try{
            if (resultSet.previous() ){
                nextBtn.setEnabled(true);
                input();
            }
            else{
                resultSet.first();
                System.out.println("first");
            }
        }
        catch(Exception sqlex){
            System.out.println("previous button is borked");
        } // end catch
        
    }//GEN-LAST:event_prevBtnActionPerformed

    private void del_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_BtnActionPerformed
        // DELETE a RECORD
        // http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html 
        // 
        
     /*
        JFrame frame = new JFrame("To delete or not delete");
        
        int response;
        response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this record?","Warning", JOptionPane.QUESTION_MESSAGE);
        int dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this record?","Warning", dialogButton);
        String deletetSQL = "Delete from authors WHERE LastName = 'Watson'";
    */
     
     // ref: http://www.java2s.com/Tutorial/Java/0240__Swing/Yesnocanceldialog.htm
     // see Alan's NavigateRecords.java solution02 for .NO_OPTION version.
        try{ 
            // 0=yes, 1=no, 2=cancel
            int i = yesNoCancel("Are your sure you want to delete this property?");
            System.out.println("ret : " + i);
            if (i == 0){
                System.out.println("You selected \'Yes\'");
            } //end if CANCEL

            if (i == 1){
                System.out.println("You selected \'No\'");
                JOptionPane.showMessageDialog(null, "Attention", "The record has not been deleted", JOptionPane.INFORMATION_MESSAGE);
            } // end if NO DELETE

            if (i == 2){
                System.out.println("Cancelled");

                // get what's currently in the textfields
                String authorID = resultSet.getObject(1).toString();
                int authIDcheck = Integer.parseInt(authorID); //authorID in 'authors' table is INT type       
                System.out.println("authID (int) :" + authIDcheck);

                String firstNameDel = firstNameTextField.getText();
                System.out.println("first name to delete is... :" + firstNameDel);

                String lastNameDel =  lastNameTextField.getText();
                System.out.println("surname to delete is... :" + lastNameDel);

                String delRecord = "DELETE FROM authors WHERE AuthorID = 'authIDcheck'";
                PreparedStatement delstmt= connection.prepareStatement(delRecord);

                int row = delstmt.executeUpdate();

                System.out.println("\n__________________\nRecord is deleted in \'AUTHORS\' table!");
                System.out.println(row + " rows affected\n");

                JFrame frame = new JFrame("Yes");
                JOptionPane.showMessageDialog(frame, "Record Successfully Deleted", "Delete Operation Complete", JOptionPane.INFORMATION_MESSAGE);

                // display the new record and grey out the text fields again
                input(); 
                firstNameTextField.setEnabled(false);
                lastNameTextField.setEnabled(false);
            } //end if 2 - YES DELETE
            else{ System.exit(0); }
        
        
        }//end try
        
        catch(SQLException sqlex){
            System.err.println("borked the delete");
            System.err.println(sqlex.getMessage());
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "Error trying to update", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }// end catch
    }//GEN-LAST:event_del_BtnActionPerformed

    // Yes-No-Cancel return type needs to be an int. (0 = Yes | 1 = No | 2 = Cancel) YES and CANCEL might be reveresed on MacOS.
    public static int yesNoCancel(String theMessage) {
        int yesNoresult = JOptionPane.showConfirmDialog((Component) null, theMessage,"Confirm Deletion", JOptionPane.YES_NO_CANCEL_OPTION);
        return yesNoresult;
    }
    
    
    private void upd_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upd_BtnActionPerformed
        // UPDATE BUTTON code here:
        try{
            // get what's currently in the textfields
            String authorID = resultSet.getObject(1).toString();
            int authIDcheck = Integer.parseInt(authorID); //authorID in 'authors' table is INT type       
            System.out.println("authID (int) :" + authIDcheck);
            
            String firstNameUpdate = firstNameTextField.getText();
            System.out.println("first name to update is... :" + firstNameUpdate);
            
            String lastNameUpdate =  lastNameTextField.getText();
            System.out.println("surname to update is... :" + lastNameUpdate);
 
            String dataUpdate = "UPDATE authors SET FirstName = ?, LastName = ? WHERE AuthorID = 'authIDcheck'";
            PreparedStatement upstmt= connection.prepareStatement(dataUpdate);
           
            upstmt.setString(1, firstNameUpdate); //FirstName variable currently in textfield after edit
            upstmt.setString(2, lastNameUpdate); //LastName
            
            int recs = upstmt.executeUpdate();
            
            System.out.println("\n__________________\nRecord is updated in \'AUTHORS\' table!");
            System.out.println(recs + " row affected\n");
            
            JFrame frame = new JFrame("Yes");
            JOptionPane.showMessageDialog(frame, "Record Successfully updated", "Update Complete", JOptionPane.INFORMATION_MESSAGE);
            
            // display the new record and grey out the text fields again
            input(); 
            firstNameTextField.setEnabled(false);
            lastNameTextField.setEnabled(false);
            
        }//end try
        catch(SQLException sqlex){
            System.err.println("borked the update");
            System.err.println(sqlex.getMessage());
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame, "Error trying to update", "ERROR", JOptionPane.ERROR_MESSAGE);
        }// end catch
        
    }//GEN-LAST:event_upd_BtnActionPerformed

    private void ins_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ins_BtnActionPerformed
        // INSERT CODE here... no really:
        // http://alvinalexander.com/java/java-mysql-insert-example-preparedstatement 
        
        try{
            /* Insert new data from user inputs*/
            String authInput = JOptionPane.showInputDialog(null, "please enter your AuthorID");
            int authNewID = Integer.parseInt(authInput);
            
            String firstNameInput = JOptionPane.showInputDialog(null, "please enter your first name");
            String lastNameInput = JOptionPane.showInputDialog(null, "please enter your last name");
            
            String ybornInput = JOptionPane.showInputDialog(null, "please enter your year of birth");
            int nYearBorn = Integer.parseInt(ybornInput);
                
            String dataInsert = "INSERT INTO authors (AuthorID, FirstName, LastName, YearBorn) "
                                    + "VALUES(?,?,?,?)";
            PreparedStatement pstmt= connection.prepareStatement(dataInsert);

            pstmt.setInt(1, authNewID); //AuthorID
            pstmt.setString(2, firstNameInput); //FirstName
            pstmt.setString(3, lastNameInput); //LastName
            pstmt.setInt(4, nYearBorn); //YearBorn
            
            int recs = pstmt.executeUpdate();
            
            //this gets back the integer number of 'how many rows are affected' by the Statement
        //    int rowCount = statement.executeUpdate(dataInsert); 
            System.out.println(recs + " row inserted\n");
            
            
        }//end try
        catch(SQLException sqlex){
            System.err.println("borked the insert");
            System.err.println(sqlex.getMessage());
        }// end catch
    }//GEN-LAST:event_ins_BtnActionPerformed

    private void authorIDTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorIDTextFieldMouseClicked
        //authorIDTextField.setEnabled(true);
        //authorIDTextField.setText("");
    }//GEN-LAST:event_authorIDTextFieldMouseClicked

    private void firstNameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameTextFieldMouseClicked
        firstNameTextField.setEnabled(true);
        firstNameTextField.setText("");
    }//GEN-LAST:event_firstNameTextFieldMouseClicked

    private void lastNameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameTextFieldMouseClicked
        lastNameTextField.setEnabled(true);
        lastNameTextField.setText("");
    }//GEN-LAST:event_lastNameTextFieldMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateBooks_InsertDel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateBooks_InsertDel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateBooks_InsertDel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateBooks_InsertDel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateBooks_InsertDel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorIDTextField;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton del_Btn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton firstBtn;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JButton ins_Btn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lastBtn;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton prevBtn;
    private javax.swing.JTextArea textArea;
    private javax.swing.JButton upd_Btn;
    // End of variables declaration//GEN-END:variables
}
