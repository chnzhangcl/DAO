package com.neuedu.test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class TransectionTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个用户名：");
		String uname = sc.next();
		System.out.println("请输入一个密码：");
		String pword = sc.next();
		Date date = new Date();
		//从1970年到现在的ms数
		Timestamp ts = new Timestamp(date.getTime());
		try {
			//1.加载数据库驱动（建桥前审批的过程）导jar包
			Class.forName("org.gjt.mm.mysql.Driver");//反射机制
			//Class.forName("com.mysql.jdbc.Driver");//黑马写法
			//2.创建连接(开始建桥)获取数据库连接对象,URL：连谁写谁IP
			Connection conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//3.创建数据库执行对象
			conn.setAutoCommit(false); //手动提交
			String sql ="insert into admin(username,password,regtime) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);//预编译看一下Sql语句对不对
			//4.执行sql语句
			pstmt.setString(1,uname);
			pstmt.setString(2,pword);
			pstmt.setTimestamp(3, ts);
			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("注册成功");
			}
			conn.commit();
			//6.释放资源（关闭连接）
			pstmt.close();
			conn.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
