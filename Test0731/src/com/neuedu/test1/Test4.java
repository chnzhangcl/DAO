package com.neuedu.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个用户名：");
		String uname = sc.next();
		System.out.println("请输入一个密码：");
		String pword = sc.next();
		try {
			//1.加载数据库驱动（建桥前审批的过程）导jar包
			Class.forName("org.gjt.mm.mysql.Driver");//反射机制
			//Class.forName("com.mysql.jdbc.Driver");//黑马写法
			//2.创建连接(开始建桥)获取数据库连接对象,URL：连谁写谁IP
			Connection conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//3.创建数据库执行对象(快递员送包裹) Statement的儿子PreparedStatement
			String sql = "select id,username,password from admin where username = ? and password = ?";
			//Statement stmt = conn.createStatement(); //只负责走此桥的路，其他桥走不了
			PreparedStatement pstmt = conn.prepareStatement(sql);//预编译看一下Sql语句对不对
			//4.执行sql语句(快递员宋的包裹就是sql)
			pstmt.setString(1,uname);
			pstmt.setString(2,pword);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				System.out.println("登录成功");
			}else{
				System.out.println("登录失败");
			}
			//6.释放资源（关闭连接）
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
