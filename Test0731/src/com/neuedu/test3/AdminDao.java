/*package com.neuedu.test3;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDao {
	private Connection conn;
	
	public AdminDao() throws Exception{
		//1.加载数据库驱动（建桥前审批的过程）导jar包
		Class.forName("org.gjt.mm.mysql.Driver");//反射机制
		//Class.forName("com.mysql.jdbc.Driver");//黑马写法
		//2.创建连接(开始建桥)获取数据库连接对象,URL：连谁写谁IP
		conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
	}
	
	
	public void insert(String uname,String pword,Timestamp ts) throws SQLException{
		PreparedStatement pstmt = null;
		try {
			//3.创建数据库执行对象
			conn.setAutoCommit(false); //手动提交
			String sql ="insert into admin(username,password,regtime) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);//预编译看一下Sql语句对不对
			//4.执行sql语句
			pstmt.setString(1,uname);
			pstmt.setString(2,pword);
			pstmt.setTimestamp(3, ts);
			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("注册成功");
			}
			conn.commit();
		} catch (Exception e) { 
			e.printStackTrace();
		}finally{
			//6.释放资源（关闭连接）
			if(pstmt!= null){
				pstmt.close();
			}
		}
	}
	
	public void query(){
		PreparedStatement pstmt = null;
		try {
			//3.创建数据库执行对象
			conn.setAutoCommit(false); //手动提交
			String sql ="insert into admin(username,password,regtime) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);//预编译看一下Sql语句对不对
			//4.执行sql语句

			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("注册成功");
			}
			conn.commit();
		} catch (Exception e) { 
			e.printStackTrace();
		}finally{
			//6.释放资源（关闭连接）
			if(pstmt!= null){
				pstmt.close();
			}
		}
	}

	public void update(){
		
	}

	public void delete(){
		
	}	
}
*/