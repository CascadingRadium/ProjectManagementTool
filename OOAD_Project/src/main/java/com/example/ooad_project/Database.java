package com.example.ooad_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
	private static Database dbInstance;
	private static Connection con;
	private static Statement stmt;
	private Database() {
	}
	public static Database getInstance()
	{
		if (dbInstance==null)
			dbInstance = new Database();
		return dbInstance;
	}
	public Connection getConnection()
	{
        if(con==null)
		{
            	try{
					Class.forName("org.postgresql.Driver");
					con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "7456");
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
					System.err.println(e.getClass().getName()+": "+e.getMessage());
					System.exit(0);
            	}
		}
        return con;
	}
}