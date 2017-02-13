package jdbc.examples;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author K00213234
 */
public class ISEQWithImagesFrame extends javax.swing.JFrame implements ResultSetNavigatorActionListener
{
	public ISEQWithImagesFrame()
	{
		this.initComponents();
		this.OnFormLoad();
	}
	//
	//  Private Methods
	//
	private void OnFormLoad()
	{
		try
		{
			ProjectManager.ISEQDatabase.ConnectToDatabase();
			this.LoadResultSet();
			ResultSetNavigatorClass.LoadFirstRow(this, resultSet, this);
		}
		catch (SQLException ex)
		{
			JOptionPane.showMessageDialog(this, ex);
		}

	}
	private void ExitProgram()
	{
		try
		{
			this.CloseResultSet();
			ProjectManager.ISEQDatabase.CloseConnectionToDatabase();
		}
		catch (SQLException ex)
		{
			Logger.getLogger(ISEQWithImagesFrame.class.getName()).log(Level.SEVERE, null, ex);
		} finally
		{
			System.exit(0);
		}
	}
	private void ExitProgramOption()
	{
		int choice = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Exit?", "ISEQ DB", JOptionPane.YES_NO_OPTION);

		if (choice == JOptionPane.YES_OPTION)
		{
			this.ExitProgram();
		} //	else; //do nothing
	}
	//
	//  Private Methods - DatabaseMethods
	//
	private void CloseResultSet() throws SQLException
	{
		this.resultSet.close();
	}
	private void LoadResultSet() throws SQLException
	{
		Statement statement = ProjectManager.ISEQDatabase.getConnection().createStatement();
		this.resultSet = statement.executeQuery(this.allPricesSQL);
	}
	@Override
	public void LoadResultSetSelectedRow() throws SQLException
	{
		String companyName = this.resultSet.getString("Company");
		String currentPrice = this.resultSet.getString("Current_Price");
		String yesterdayPrice = this.resultSet.getString("Yesterdays_Price");
		double sharesTradedYest = this.resultSet.getDouble("Shares_Traded_Yesterday");
		String yearlyLowTF = this.resultSet.getString("Yearly_Low");
		String yearlyHighTF = this.resultSet.getString("Yearly_High");
		String listingDate = this.resultSet.getString("Listing_Date");
		String filename = this.resultSet.getString("Image");

		//String path = ""+getClass().getResource("/assets.images.companylogos/");
		ImageIcon ico = new ImageIcon(ProjectManager.ImagesPath + filename);

		this.nameJTextField.setText(companyName);
		this.priceJTextField.setText(currentPrice);
		this.yesterdayJTextField.setText(yesterdayPrice);
		this.tradedJTextField.setText(String.valueOf(sharesTradedYest));
		this.lowJTextField.setText(yearlyLowTF);
		this.highJTextField.setText(yearlyHighTF);
		this.listingDateJTextField.setText(listingDate);
		this.imageJLabel.setIcon(ico);

		if (sharesTradedYest < 10)
		{
			this.nameJTextField.setForeground(this.alertTradeColor);
		}
		else
		{
			this.nameJTextField.setForeground(this.tradeColor);
		}
	}
	//
	//  Private Methods - Navigation
	//
	private void ResultSetLoadFirstRow()
	{
		ResultSetNavigatorClass.LoadFirstRow(this, resultSet, this);
	}
	private void ResultSetLoadLastRow()
	{
		ResultSetNavigatorClass.LoadLastRow(this, resultSet, this);
	}
	private void ResultSetLoadNextRow()
	{
		ResultSetNavigatorClass.LoadNextRow(this, resultSet, this);
	}
	private void ResultSetLoadPreviousRow()
	{
		ResultSetNavigatorClass.LoadPreviousRow(this, resultSet, this);
	}
	//
	//  Private Fields - database components
	//
	private ResultSet resultSet;
	//
	//  Private Fields - SQL statements
	//
	private final String allPricesSQL = "SELECT * FROM iseq.prices;";
	//
	//  Private Fields - colors
	//
	private final Color alertTradeColor = Color.RED;
	private final Color tradeColor = Color.BLACK;

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        companiesLabel = new javax.swing.JLabel();
        companyJPanel1 = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        priceJLabel = new javax.swing.JLabel();
        yesterdayJLabel = new javax.swing.JLabel();
        tradedJLabel = new javax.swing.JLabel();
        lowJLabel = new javax.swing.JLabel();
        highJLabel = new javax.swing.JLabel();
        dateJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        priceJTextField = new javax.swing.JTextField();
        yesterdayJTextField = new javax.swing.JTextField();
        tradedJTextField = new javax.swing.JTextField();
        lowJTextField = new javax.swing.JTextField();
        highJTextField = new javax.swing.JTextField();
        listingDateJTextField = new javax.swing.JTextField();
        ControlsJLabel = new javax.swing.JLabel();
        navigationJPanel = new javax.swing.JPanel();
        firstJButton = new javax.swing.JButton();
        nextJButton = new javax.swing.JButton();
        previousJButton = new javax.swing.JButton();
        lastJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        imageJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        companiesLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        companiesLabel.setText("Companies List");

        companyJPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nameJLabel.setBackground(new java.awt.Color(0, 0, 0));
        nameJLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nameJLabel.setText("Companies Name");

        priceJLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        priceJLabel.setText("Current Price");

        yesterdayJLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        yesterdayJLabel.setText("Yesterdays Price");

        tradedJLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tradedJLabel.setText("Shares Traded Yesterday");

        lowJLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lowJLabel.setText("Yearly Low");

        highJLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        highJLabel.setText("Yearly High");

        dateJLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dateJLabel.setText("Listing Date");

        nameJTextField.setText("Name");

        priceJTextField.setText("Current Price");

        yesterdayJTextField.setText("Yesterdays Price");

        tradedJTextField.setText("Traded");

        lowJTextField.setText("Low");

        highJTextField.setText("High");

        listingDateJTextField.setText("Date");

        javax.swing.GroupLayout companyJPanel1Layout = new javax.swing.GroupLayout(companyJPanel1);
        companyJPanel1.setLayout(companyJPanel1Layout);
        companyJPanel1Layout.setHorizontalGroup(
            companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyJPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceJLabel)
                    .addComponent(yesterdayJLabel)
                    .addComponent(tradedJLabel)
                    .addComponent(lowJLabel)
                    .addComponent(highJLabel)
                    .addComponent(dateJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(priceJTextField)
                        .addComponent(yesterdayJTextField)
                        .addComponent(tradedJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(lowJTextField))
                    .addComponent(highJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listingDateJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        companyJPanel1Layout.setVerticalGroup(
            companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJLabel)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceJLabel)
                    .addComponent(priceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yesterdayJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yesterdayJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tradedJLabel)
                    .addComponent(tradedJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(highJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(highJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(companyJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listingDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateJLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ControlsJLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ControlsJLabel.setText("Controls");

        navigationJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        firstJButton.setText("First");
        firstJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                firstJButtonActionPerformed(evt);
            }
        });

        nextJButton.setText("Next");
        nextJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextJButtonActionPerformed(evt);
            }
        });

        previousJButton.setText("Previous");
        previousJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                previousJButtonActionPerformed(evt);
            }
        });

        lastJButton.setText("Last");
        lastJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                lastJButtonActionPerformed(evt);
            }
        });

        exitJButton.setText("Exit");
        exitJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navigationJPanelLayout = new javax.swing.GroupLayout(navigationJPanel);
        navigationJPanel.setLayout(navigationJPanelLayout);
        navigationJPanelLayout.setHorizontalGroup(
            navigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationJPanelLayout.createSequentialGroup()
                .addComponent(firstJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previousJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navigationJPanelLayout.setVerticalGroup(
            navigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigationJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstJButton)
                    .addComponent(nextJButton)
                    .addComponent(previousJButton)
                    .addComponent(lastJButton)
                    .addComponent(exitJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(companiesLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ControlsJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navigationJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(companyJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(imageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(companiesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(companyJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(imageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ControlsJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navigationJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstJButtonActionPerformed
		this.ResultSetLoadFirstRow();
    }//GEN-LAST:event_firstJButtonActionPerformed

    private void nextJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJButtonActionPerformed
		this.ResultSetLoadNextRow();
    }//GEN-LAST:event_nextJButtonActionPerformed

    private void previousJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousJButtonActionPerformed
		this.ResultSetLoadPreviousRow();
    }//GEN-LAST:event_previousJButtonActionPerformed

    private void lastJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastJButtonActionPerformed
		this.ResultSetLoadLastRow();
    }//GEN-LAST:event_lastJButtonActionPerformed

    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
		this.ExitProgramOption();
    }//GEN-LAST:event_exitJButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
		this.ExitProgram();
    }//GEN-LAST:event_formWindowClosing

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
		}
		catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(ISEQWithImagesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(ISEQWithImagesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(ISEQWithImagesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(ISEQWithImagesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new ISEQWithImagesFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ControlsJLabel;
    private javax.swing.JLabel companiesLabel;
    private javax.swing.JPanel companyJPanel1;
    private javax.swing.JLabel dateJLabel;
    private javax.swing.JButton exitJButton;
    private javax.swing.JButton firstJButton;
    private javax.swing.JLabel highJLabel;
    private javax.swing.JTextField highJTextField;
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JButton lastJButton;
    private javax.swing.JTextField listingDateJTextField;
    private javax.swing.JLabel lowJLabel;
    private javax.swing.JTextField lowJTextField;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JPanel navigationJPanel;
    private javax.swing.JButton nextJButton;
    private javax.swing.JButton previousJButton;
    private javax.swing.JLabel priceJLabel;
    private javax.swing.JTextField priceJTextField;
    private javax.swing.JLabel tradedJLabel;
    private javax.swing.JTextField tradedJTextField;
    private javax.swing.JLabel yesterdayJLabel;
    private javax.swing.JTextField yesterdayJTextField;
    // End of variables declaration//GEN-END:variables
}
