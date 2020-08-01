package com.neuedu.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test2 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		String sql = "DELETE FROM admin where id = 10";
		stmt.executeUpdate(sql);
		
		stmt.close();
		conn.close();
	}
}
