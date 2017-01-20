package dataBase_Exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent Lee k00223361
 * Display Books with JFrame interface
 */
public class UpdateBooks_InsertDel extends javax.swing.JFrame {

ResultSet resultSet;
Connection connection; 
Statement statement;
    
    /**Creates new form Books*/
    public UpdateBooks_InsertDel() {
        initComponents();
    
        int number =0;
        try {
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/books", "sduser", "pass");
            System.out.println("connection established at " + connection); 

            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("SELECT * FROM authors");
            
            /* Insert new data */
            /*
            String authInput = JOptionPane.showInputDialog(null, "please enter your AuthorID");
            int authNewID = Integer.parseInt(authInput);
            String firstNameInput = JOptionPane.showInputDialog(null, "please enter your first name");
            String lastNameInput = JOptionPane.showInputDialog(null, "please enter your last name");
            String yborn = JOptionPane.showInputDialog(null, "please enter your year of birth");
            int yearBorn = Integer.parseInt(yborn);
              */
            /* 
            String insertSQL = "INSERT INTO 'authors'(AuthorID, FirstName, LastName, YearBorn)VALUES ('" + authInput + "', '" + "'" + firstNameInput + "', '" + lastNameInput + "' " + ",'" + born)";
            */
            /*
            String exInsert = "INSERT INTO `authors`(AuthorID, FirstName, LastName, YearBorn) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt= connection.prepareStatement(exInsert);

            pstmt.setInt(1,authNewID);
            pstmt.setString(2,firstNameInput);
            pstmt.setString(3,lastNameInput);
            pstmt.setInt(3, yearBorn);

            int rowCount = statement.executeUpdate(exInsert); //this gets back the integer number of 'how many rows are affected' by the Statement
            
            textArea.setText(rowCount + " row inserted\n");
            */
            String query = "SELECT * FROM authors";  
            resultSet = statement.executeQuery(query);

            String results="";

            ResultSetMetaData metaData =  resultSet.getMetaData();
            /*
            int numberOfColumns = metaData.getColumnCount();

            for (int i =1; i < numberOfColumns; i++) {
                              results += metaData.getColumnName(i) + "\t";
            }

           results +="\n";

           while(resultSet.next()) {
              for (int i=1;  i < numberOfColumns; i++){
                  results +=resultSet.getObject(i) + "\t";
              }//end for

              results+= "\n";
            }
            */ 
          /*
            ResultSetMetaData metaData =  resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            */ 
          
            if (resultSet.next()){
                input();
            }
            
        }//end try
        catch(SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.out.println("Error Connecting, check your port no");
            System.exit(0);
        }
        
        
    
    
    }
    
    private void input(){
        try{
            String authorID = resultSet.getObject(1).toString(); 
            String firstName = resultSet.getObject(2).toString();
            String lastName = resultSet.getObject(3).toString();
            
            authorIDTextField.setText(authorID);
            firstNameTextField.setText(firstName);
            lastNameTextField.setText(lastName);
        } catch (SQLException sqlex) {
            System.out.println("input to String wrong");
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
        topLabel = new javax.swing.JLabel();
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

        authorIDTextField.setText("ID");
        authorIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorIDTextFieldActionPerformed(evt);
            }
        });

        firstNameTextField.setText("First Name..");

        lastNameTextField.setText("Last Name..");
        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        authorLabel.setText("AuthorID");

        firstNameLabel.setText("First Name");

        lastNameLabel.setText("Last Name");

        topLabel.setText("JFrame for displaying records from database");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel)
                            .addComponent(authorLabel)
                            .addComponent(lastNameLabel))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addComponent(firstBtn))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(topLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(prevBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nextBtn))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(93, 93, 93)
                                    .addComponent(lastBtn)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                            .addComponent(ins_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(upd_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(authorIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(del_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(topLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            }
            else{
                resultSet.first();
            }
        }
        
        catch(Exception sqlex) {
            System.out.println("First Button is borked");
            System.exit(0);
	} //end catch
        
    }//GEN-LAST:event_firstBtnActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void authorIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorIDTextFieldActionPerformed
        // AuthorID textfield code goes here
        try{
            //authorIDTextField.setText()
        }
        catch(Exception sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.out.println("Author ID is borked");
            System.exit(0);
	} //end catch
        
    }//GEN-LAST:event_authorIDTextFieldActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // Next button goes here
        try{
            if(resultSet.next() ){ //if checks that there are records in the table
                input();
            }
            else{
                resultSet.last();
            }
        }
        catch(Exception sqlex){
            System.out.println("next button is borked");
        }
        
    }//GEN-LAST:event_nextBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        try{statement.close();
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
                input();
            }
            else{
                resultSet.first();
            }
        }
        catch(Exception sqlex){
            System.out.println("previous button is borked");
        } // end catch
        
    }//GEN-LAST:event_prevBtnActionPerformed

    private void del_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_del_BtnActionPerformed

    private void upd_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upd_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_upd_BtnActionPerformed

    private void ins_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ins_BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ins_BtnActionPerformed

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
    private javax.swing.JLabel topLabel;
    private javax.swing.JButton upd_Btn;
    // End of variables declaration//GEN-END:variables
}
