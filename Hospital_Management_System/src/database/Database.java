package database;

import java.sql.*;

public class Database {
	
	private Connection connection;
	public Database() {
		super();
		initialConnection();
	}
	
	//Create Connection 
	public void initialConnection(){
		try {
			String url = "jdbc:mysql://localhost:3306/hospital_management_system";
			//Connect to the Database
			this.connection = DriverManager.getConnection (url, "root", "");
//			System.out.println("The Connection is started");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	//Close the Connection and Statement objects after query
	public void closeConnection(){
		try {
			this.connection.close();
//			System.out.println("The Connection is terminated");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	//Getter and setter methods
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
