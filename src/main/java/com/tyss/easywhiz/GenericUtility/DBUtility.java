package com.tyss.easywhiz.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DBUtility {


	Connection con=null;
	/**
	 * This method is used to connect to the database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstant.DBURL, IPathConstant.DBUSERNAME, IPathConstant.DBPASSWORD);
		
	}
	/**
	 * This method is used to execute the query and get the data from data base
	 * 
	 * @param query
	 * @param colIndex
	 * @param expData
	 * @throws SQLException
	 */
	
	
	public void executeAndGetData(String query, int colIndex, String expData) throws SQLException {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		boolean flag = false;
		while(result.next()) {
			String actualD = result.getString(colIndex);
			if(actualD.contains(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("Data is present");
		}
		else {
			System.out.println("Data is not present");
		}
		
		
	}
	/**
	 * This method is used to close the connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
	}

}
