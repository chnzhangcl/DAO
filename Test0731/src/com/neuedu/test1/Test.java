package com.neuedu.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		try {
			//1.加载数据库驱动（建桥前审批的过程）导jar包
			Class.forName("org.gjt.mm.mysql.Driver");//反射机制
			//Class.forName("com.mysql.jdbc.Driver");//黑马写法
			//2.创建连接(开始建桥)获取数据库连接对象,URL：连谁写谁IP
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			//3.创建数据库执行对象(快递员送包裹) Statement是个接口不能实例化，利用conn造对象
			String sql = "insert into admin(username,password,regtime) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql); //只负责走此桥的路，其他桥走不了
			//4.执行sql语句(快递员宋的包裹就是sql)
			int e = pstmt.executeUpdate();
			//5.处理结果集，
			if(e>0){
				System.out.println("添加成功");
			}
		
			//6.释放资源（关闭连接）
			pstmt.close();
			conn.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
