/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author K00213234
 */
public class ManageDBConnectionBaseClass extends ManageDataBaseDetails
{
	//
	//  Public Final Properties
	//
	public final Connection getConnection()
	{
		return this.connection;
	}
	//
	//  Public Final Methods - DatabaseMethods
	//
	public final void ConnectToDatabase() throws SQLException
	{
		this.connection = DriverManager.getConnection(super.ConnectionURI(),
				super.serverUsername,
				super.serverPassword
		);
	}
	public final void CloseConnectionToDatabase() throws SQLException
	{
		this.connection.close();
	}
	//
	//  Private Fields - database components
	//
	private Connection connection;
}
