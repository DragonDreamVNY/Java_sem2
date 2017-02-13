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
public class ProjectManager
{
	//
	//  Public Static Final Fields
	//
	public static final String ImagesPath = "./images.company.logos/";	//	".\\images.company.logos\\";
	public static final String SQLScriptsPath = "./sql.scripts/";		//	".\\sql.scripts\\";
	public static final LitRealtyDatabaseConnectionClass LitRealtyDatabase = new LitRealtyDatabaseConnectionClass();
	public static final ISEQDatabaseConnectionClass ISEQDatabase = new ISEQDatabaseConnectionClass();
	public static final ISEQRowSetConnectionClass ISEQRowSet = new ISEQRowSetConnectionClass();
}
