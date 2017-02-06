/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.examples;

import com.sun.rowset.JdbcRowSetImpl;
import java.sql.SQLException;
import javax.sql.RowSet;

/**
 *
 * @author K00213234
 */
public class ManageRowSetBaseClass extends ManageDataBaseDetails
{
	//
	//  Public Final Properties
	//
	public final RowSet getRowSet()
	{
		return this.rowSet;
	}
	//
	//  Public Final Methods - DatabaseMethods
	//
	public final void ConnectToDatabase() throws SQLException
	{
		this.rowSet = new JdbcRowSetImpl();
		//
		//	rowSet
		//
		this.rowSet.setUrl(super.ConnectionURI());
		this.rowSet.setUsername(super.serverUsername);
		this.rowSet.setPassword(super.serverPassword);
	}
	public final void CloseConnectionToDatabase() throws SQLException
	{
		this.rowSet.close();
	}
	//
	//  Private Fields - database components
	//
	private RowSet rowSet;
}
