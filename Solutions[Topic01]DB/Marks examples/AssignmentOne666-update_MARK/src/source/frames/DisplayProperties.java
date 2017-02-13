package source.frames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DisplayProperties extends javax.swing.JFrame
{

    JFrame logonFrame;
    int agentId;

    Connection connection;

    ResultSet resultSet = null;

    String url = "jdbc:mysql://localhost:3306/litrealty";
    String uName = "sduser";
    String password = "pass";

    public DisplayProperties(JFrame loginFrame, int agentId)
    {
        initComponents();

        this.logonFrame = loginFrame;
        this.agentId = agentId;

        this.ConnectToDatabase();
        this.LoadRecords(agentId);
    }

    private void LoadRecords(int agentId)
    {
        try
        {
            String sql = "SELECT `properties`.`id`,\n"
                    + "    `properties`.`street`,\n"
                    + "    `properties`.`bedrooms`,\n"
                    + "    `properties`.`bathrooms`,\n"
                    + "    `properties`.`squarefeet`,\n"
                    + "    `properties`.`description`,\n"
                    + "    `properties`.`photo`,\n"
                    + "    `properties`.`price`\n"
                    + "FROM `litrealty`.`properties` WHERE agentID = ?; ";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, agentId);
            //exexute our query, which will lead to the return of a resultset
            resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                LoadRecord();
            } //end if
            else
            {
                JOptionPane.showMessageDialog(null, "There are no records in the database");
            } //end else
        }//end try
        catch (SQLException sqlex)
        {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.exit(0);
        }
    }

    private void ConnectToDatabase()
    {
     

        try
        {
            //only need the conection because I want to call a stored procedure with it
            //otherwise I wouldn't need it
            connection = DriverManager.getConnection(url, uName, password);

        }//end try//end try
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }//end catch

    }

    void LoadStats()
    {
        String countSQL = "SELECT COUNT(*) FROM `litrealty`.`properties` WHERE agentID = ?;";
        String sumSQL = "SELECT SUM(`price`) FROM `litrealty`.`properties` WHERE agentID = ?;";
        String maxSQL = "SELECT MAX(`price`)  FROM `litrealty`.`properties` WHERE agentID = ?;";
        String agentSQL = "SELECT username FROM litrealty.agents WHERE agentID = ?;";

        int count = 0;
        double max = 0.0;
        double sum = 0.0;
        String name = "";
        PreparedStatement statement;

        try
        {
            
            ResultSet resultSet = null;
            //
            //count
            //
            statement = connection.prepareStatement(countSQL);
            statement.setInt(1, agentId);
            resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                count = resultSet.getInt(1);
            }
            //
            //sum
            //
            statement = connection.prepareStatement(sumSQL);
            statement.setInt(1, agentId);
            resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                sum = resultSet.getDouble(1);
            }
            //
            //max
            //
            statement = connection.prepareStatement(maxSQL);
            statement.setInt(1, agentId);
            resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                max = resultSet.getDouble(1);
            }
            //
            //name
            //
            statement = connection.prepareStatement(agentSQL);
            statement.setInt(1, agentId);
            resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                name = resultSet.getString(1);
            }
            String mask = "€#.00";
            DecimalFormat decimalFormat = new DecimalFormat(mask);
            decimalFormat.setGroupingUsed(true);

            decimalFormat.setGroupingSize(3);

            String output = name +"\n"+ "You have " + count + " properties in your portfolio.\n"
                    + "The total value of the properties in your portfolio is " + decimalFormat.format(sum) + "\n"
                    + "The highest priced property in your portfolio costs " + decimalFormat.format(max) + "";

            JOptionPane.showMessageDialog(null, output);
            resultSet.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DisplayProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void LoadRecord()
    {
        try
        {
            //to get an icon for say the file 335965.jpg
            //Icon pic = new ImageIcon(getClass().getResource("/assets/images/properties/335965.jpg"));
            //after you have an icon you now need to put the pic in the appropriate label (along with all the other property info)
            //remember each property in the database table has an image/filename associated with it

            this.StreetJTextField.setText(resultSet.getString(2));
            this.BedroomsJTextField.setText(resultSet.getString(3));
            this.BathroomsJTextField.setText(resultSet.getString(4));
            this.SquareFeetJTextField.setText(resultSet.getString(5));
            this.DescriptionJTextArea.setText(resultSet.getString(6));

            String photofilename = resultSet.getString(7);
            double price = resultSet.getDouble(8);

            Icon pic = new ImageIcon(getClass().getResource("/assets/images/properties/" + photofilename));
            this.photoJLabel.setIcon(pic);

            String mask = "€#.00";
            DecimalFormat decimalFormat = new DecimalFormat(mask);
            decimalFormat.setGroupingUsed(true);

            decimalFormat.setGroupingSize(3);

            this.priceJLabel.setText(decimalFormat.format(price));
//            if (Traded < 10) {
//                NameT.setForeground(red);
//            } else {
//                NameT.setForeground(black);
//            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DisplayProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "ERROR " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        displayPanel = new javax.swing.JPanel();
        StreetJLabel = new javax.swing.JLabel();
        StreetJTextField = new javax.swing.JTextField();
        BedroomsJLabel = new javax.swing.JLabel();
        BedroomsJTextField = new javax.swing.JTextField();
        BathroomsJLabel = new javax.swing.JLabel();
        BathroomsJTextField = new javax.swing.JTextField();
        SquareFeetJLabel = new javax.swing.JLabel();
        SquareFeetJTextField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DescriptionJTextArea = new javax.swing.JTextArea();
        imgLabel1 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        statsButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        photoJLabel = new javax.swing.JLabel();
        priceJLabel = new javax.swing.JLabel();
        imgLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LIT Realty");

        framePanel.setBackground(new java.awt.Color(255, 255, 255));

        headerLabel.setFont(new java.awt.Font("Bookman Old Style", 0, 48)); // NOI18N
        headerLabel.setText("LIT Realty");

        displayPanel.setBackground(new java.awt.Color(255, 255, 255));
        displayPanel.setLayout(new java.awt.GridLayout(5, 2, 15, 15));

        StreetJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        StreetJLabel.setText("Street");
        displayPanel.add(StreetJLabel);

        StreetJTextField.setEditable(false);
        displayPanel.add(StreetJTextField);

        BedroomsJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BedroomsJLabel.setText("No. Of Bedrooms");
        displayPanel.add(BedroomsJLabel);

        BedroomsJTextField.setEditable(false);
        displayPanel.add(BedroomsJTextField);

        BathroomsJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BathroomsJLabel.setText("No. Of Bathrooms");
        displayPanel.add(BathroomsJLabel);

        BathroomsJTextField.setEditable(false);
        displayPanel.add(BathroomsJTextField);

        SquareFeetJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        SquareFeetJLabel.setText("Square Feet");
        displayPanel.add(SquareFeetJLabel);

        SquareFeetJTextField.setEditable(false);
        displayPanel.add(SquareFeetJTextField);

        descriptionLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        descriptionLabel.setText("Description");
        displayPanel.add(descriptionLabel);

        DescriptionJTextArea.setEditable(false);
        DescriptionJTextArea.setColumns(20);
        DescriptionJTextArea.setLineWrap(true);
        DescriptionJTextArea.setRows(5);
        DescriptionJTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(DescriptionJTextArea);

        displayPanel.add(jScrollPane1);

        imgLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/LITLogo.gif"))); // NOI18N

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));

        nextButton.setBackground(new java.awt.Color(255, 255, 255));
        nextButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/next.jpg"))); // NOI18N
        nextButton.setText("Next");
        nextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nextButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        nextButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(nextButton);

        previousButton.setBackground(new java.awt.Color(255, 255, 255));
        previousButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        previousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/previous.png"))); // NOI18N
        previousButton.setText("Previous");
        previousButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previousButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        previousButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(previousButton);

        statsButton.setBackground(new java.awt.Color(255, 255, 255));
        statsButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        statsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/stats.jpg"))); // NOI18N
        statsButton.setText("View Stats");
        statsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        statsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(statsButton);

        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/exit.jpg"))); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        photoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/noimage.jpg"))); // NOI18N

        priceJLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        priceJLabel.setText("€0.00");

        imgLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/LITLogo.gif"))); // NOI18N

        javax.swing.GroupLayout framePanelLayout = new javax.swing.GroupLayout(framePanel);
        framePanel.setLayout(framePanelLayout);
        framePanelLayout.setHorizontalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(framePanelLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(priceJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(framePanelLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(photoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(framePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(headerLabel)
                .addGap(18, 18, 18)
                .addComponent(imgLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        framePanelLayout.setVerticalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgLabel1)
                    .addGroup(framePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(headerLabel))
                    .addComponent(imgLabel2))
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(framePanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(framePanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(photoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceJLabel)))
                .addGap(18, 18, 18)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        getContentPane().add(framePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
        logonFrame.setVisible(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        try
        {
            if (resultSet.previous())
            {
                this.LoadRecord();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You have reached the start of the list");
                resultSet.first();
            }
        }//end try//end try
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }//end catch
        //JOptionPane.showMessageDialog(this, "Show Previous Property");

        //to get an icon for say the file 335965.jpg
        //Icon pic = new ImageIcon(getClass().getResource("/assets/images/properties/335965.jpg"));
        //after you have an icon you now need to put the pic in the appropriate label (along with all the other property info)
        //remember each property in the database table has an image/filename associated with it

    }//GEN-LAST:event_previousButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        try
        {

            if (resultSet.next())
            {
                this.LoadRecord();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You have reached the end of the list");
                resultSet.last();
            }
        }    //end try//end try
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }//end catch

        //to get an icon for say the file 335965.jpg
        //Icon pic = new ImageIcon(getClass().getResource("/assets/images/properties/335965.jpg"));
        //after you have an icon you now need to put the pic in the appropriate label (along with all the other property info)
        //remember each property in the database table has an image/filename associated with it

    }//GEN-LAST:event_nextButtonActionPerformed

    private void statsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsButtonActionPerformed

        this.LoadStats();

    }//GEN-LAST:event_statsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BathroomsJLabel;
    private javax.swing.JTextField BathroomsJTextField;
    private javax.swing.JLabel BedroomsJLabel;
    private javax.swing.JTextField BedroomsJTextField;
    private javax.swing.JTextArea DescriptionJTextArea;
    private javax.swing.JLabel SquareFeetJLabel;
    private javax.swing.JTextField SquareFeetJTextField;
    private javax.swing.JLabel StreetJLabel;
    private javax.swing.JTextField StreetJTextField;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JPanel framePanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel imgLabel1;
    private javax.swing.JLabel imgLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel photoJLabel;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel priceJLabel;
    private javax.swing.JButton statsButton;
    // End of variables declaration//GEN-END:variables
}
