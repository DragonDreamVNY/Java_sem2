package dataBase_Exercises;

import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class QucikEx01_queries extends javax.swing.JFrame {

    /** Creates new form DisplayRecords */
    public QucikEx01_queries() {
        initComponents();

        try {

              //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "sduser", "pass");
              Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/books", "sduser", "pass");
              System.out.println("connection established at " + connection);

	      Statement statement = connection.createStatement();

	      //ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");
              //ResultSet resultSet = statement.executeQuery("SELECT Title, YearPublished FROM titles WHERE (YearPublished < 1998) ORDER BY title ASC");
              //ResultSet resultSet = statement.executeQuery("SELECT Title, YearPublished FROM titles WHERE ( (YearPublished >= 1994) AND (YearPublished <= 1998) ) ORDER BY title ASC");
              //ResultSet resultSet = statement.executeQuery("SELECT COUNT(Title) AS PublisherCount FROM titles WHERE ( PublisherID = 1 )");
              //ResultSet resultSet = statement.executeQuery("SELECT AVG(Price) FROM titles");
              /*
              ResultSet resultSet = statement.executeQuery("SELECT \n" +
                                                            "t.Title, \n" +
                                                            "a.FirstName, \n" +
                                                            "a.LastName\n" +
                                                            "FROM \n" +
                                                            "titles t,\n" +
                                                            "authors a\n" +
                                                            "ORDER BY\n" +
                                                            "a.Lastname");
                */
              ResultSet resultSet = statement.executeQuery("ai.AuthorID,\n" +
                                                            "t.ISBN,\n" +
                                                            "t.Title, \n" +
                                                            "a.FirstName, \n" +
                                                            "a.LastName\n" +
                                                            "FROM \n" +
                                                            "authorisbn ai\n" +
                                                            "INNER JOIN titles t ON ai.ISBN = t.ISBN \n" +
                                                            "INNER JOIN authors a ON ai.AuthorID = a.AuthorID");

	      String results="";

	      ResultSetMetaData metaData =  resultSet.getMetaData();

	      int numberOfColumns = metaData.getColumnCount();
              
	      for (int i =1; i < numberOfColumns; i++) {
				results += metaData.getColumnName(i) + "\t";
	      }

	     results +="\n";
             
	     while(resultSet.next()) {
                 
		for (int i=1;  i <= numberOfColumns; i++){
                    results +=resultSet.getObject(i) + "\t";
                    
                    
                }//end for

                //results +=resultSet.getObject(1) + "\t";
                results+= "\n";
            }//end while

	    statement.close();
            connection.close();

	     textArea.setText(results);

	}//end try

	catch(SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.toString());
            System.exit(0);
	}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Display Records From Books Database");
        setMinimumSize(new java.awt.Dimension(250, 150));

        textArea.setEditable(false);
        textArea.setColumns(40);
        textArea.setRows(10);
        jScrollPane1.setViewportView(textArea);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QucikEx01_queries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

}
