package jdbc.examples;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author K00213234
 */
public class ResultSetNavigatorClass
{
	//
	//  Public Static Methods
	//
	public static void LoadFirstRow(ResultSetNavigatorActionListener resultSetNavigatorActionListener, ResultSet resultSet, Component optionPaneParentComponent)
	{
		try
		{
			resultSet.first();
			resultSetNavigatorActionListener.LoadResultSetSelectedRow();
		}
		catch (SQLException exception)
		{
			JOptionPane.showMessageDialog(optionPaneParentComponent, ResultSetNavigatorClass.errorMessageString + exception);
		}
	}
	public static void LoadLastRow(ResultSetNavigatorActionListener resultSetNavigatorActionListener, ResultSet resultSet, Component optionPaneParentComponent)
	{
		try
		{
			resultSet.last();
			resultSetNavigatorActionListener.LoadResultSetSelectedRow();
		}
		catch (SQLException exception)
		{
			JOptionPane.showMessageDialog(optionPaneParentComponent, ResultSetNavigatorClass.errorMessageString + exception);
		}
	}
	public static void LoadNextRow(ResultSetNavigatorActionListener resultSetNavigatorActionListener, ResultSet resultSet, Component optionPaneParentComponent)
	{
		try
		{
			if (resultSet.next())
			{
				resultSetNavigatorActionListener.LoadResultSetSelectedRow();
			}
			else
			{
				JOptionPane.showMessageDialog(optionPaneParentComponent, ResultSetNavigatorClass.lastListMessageString);
				resultSet.last();
			}
		}
		catch (SQLException exception)
		{
			JOptionPane.showMessageDialog(optionPaneParentComponent, ResultSetNavigatorClass.errorMessageString + exception);
		}
	}
	public static void LoadPreviousRow(ResultSetNavigatorActionListener resultSetNavigatorActionListener, ResultSet resultSet, Component optionPaneParentComponent)
	{
		try
		{
			if (resultSet.previous())
			{
				resultSetNavigatorActionListener.LoadResultSetSelectedRow();
			}
			else
			{
				JOptionPane.showMessageDialog(optionPaneParentComponent, ResultSetNavigatorClass.firstListMessageString);
				resultSet.first();
			}
		}
		catch (SQLException exception)
		{
			JOptionPane.showMessageDialog(optionPaneParentComponent, ResultSetNavigatorClass.errorMessageString + exception);
		}
	}
	//
	//	Private Static Final Fields - messages
	//
	private static final String firstListMessageString = "You have reached the start of the list.";
	private static final String lastListMessageString = "You have reached the end of the list.";
	private static final String errorMessageString = "Error: ";	//"There are no records in the database";
}
