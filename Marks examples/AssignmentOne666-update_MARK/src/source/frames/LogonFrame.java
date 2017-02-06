package source.frames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LogonFrame extends javax.swing.JFrame
{

    ResultSet resultset;
    Connection connection;

    String username = "sduser";
    String databaseURI = "jdbc:mysql://localhost:3306/litrealty";
    String password = "pass";

    String loginSQL = "SELECT agentId FROM litrealty.agents WHERE username = ? AND password = ?;";

    private void ConnectToDatabase() throws SQLException
    {
        connection = DriverManager.getConnection(databaseURI, username, password);

    }


    public LogonFrame()
    {
        initComponents();
        try
        {

            this.ConnectToDatabase();
        
        } catch (SQLException ex)
        {
            Logger.getLogger(LogonFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        logonButton = new javax.swing.JButton();
        imgLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();

        setTitle("LIT Realty");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        headerLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        headerLabel.setText("LIT Realty - System Logon");

        userNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userNameLabel.setText("Enter Username");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setText("Enter Password");

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordField.setText("jPasswordField1");
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        logonButton.setBackground(new java.awt.Color(255, 255, 255));
        logonButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/logon.jpg"))); // NOI18N
        logonButton.setText("Logon");
        logonButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logonButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        logonButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logonButtonActionPerformed(evt);
            }
        });

        imgLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/LITLogo.gif"))); // NOI18N

        usernameTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(headerLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userNameLabel)
                                    .addComponent(passwordLabel))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(usernameTextField))))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgLabel1)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userNameLabel)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(headerLabel)))
                .addGap(18, 18, 18)
                .addComponent(logonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logonButtonActionPerformed

        try
        {

            String usernameText = usernameTextField.getText();
            String passwordtext = passwordField.getText();

            PreparedStatement preparedStatement = connection.prepareStatement(loginSQL);
            preparedStatement.setString(1, usernameText);
            preparedStatement.setString(2, passwordtext);

       
            boolean get_in = false;
            try
            {
                        resultset = preparedStatement.executeQuery();

                //The agentId must be passed from this frame to the second one, so that
                //you can display all the properties for that agent in the GUI.
                //When you authenticate an agent, you will get access to their ID.
                //The following assignment statement assumes that the agent ID is 2
                //In reality the agent ID will come from the DB after you perform the query
                //to authenticate/login an agent
                //Remember that an agent Id uniquely identifies an agent.
//            if (this.rowSet.next()) {
                int agentId = -1;

                if (get_in)
                {
                    agentId = 1;//4 is 'Laura.Blain'

                } else if (this.resultset.next())
                {
                    agentId = this.resultset.getInt(1);
                }

                if (agentId != -1)
                {
                    //hide this/current frame
                    this.setVisible(false);

                    //create an object of the display frame and pass a reference to this frame to it
                    //and the ID of the agent who has logged in
                    DisplayProperties propertiesFrame = new DisplayProperties(this, agentId);

                    //show the properties frame
                    propertiesFrame.setVisible(true);

                } else
                {

                    JOptionPane.showMessageDialog(null, "Incorrect Username or password. Please try again");

                }

            } catch (SQLException ex)
            {
                Logger.getLogger(LogonFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(LogonFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_logonButtonActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(LogonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(LogonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(LogonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(LogonFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("a");
                //new LogonFrame().setVisible(true);
                new LogonFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel imgLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logonButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
