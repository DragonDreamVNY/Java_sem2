/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.examples;

/**
 *
 * @author K00213234
 */
public class ManageDataBaseDetails
{
	public ManageDataBaseDetails()
	{
		this.serverPassword = "pass";
		this.serverPort = "3306";
		this.serverURI = "jdbc:mysql://localhost";
		this.serverUsername = "sduser";
	}
	//
	//  Protected Final Methods
	//
	protected final String ConnectionURI()
	{
		return this.serverURI + ":" + this.serverPort + "/" + this.databaseName;
	}
	//
	//  Protected Fields - database information
	//
	protected String databaseName;
	protected String serverPassword;
	protected String serverURI;
	protected String serverPort;
	protected String serverUsername;
}
