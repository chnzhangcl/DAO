package com.neuedu.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.swing.text.SimpleAttributeSet;

public class Test6 {
	public static void main(String[] args) {
		try {
			//1.加载数据库驱动（建桥前审批的过程）导jar包
			Class.forName("org.gjt.mm.mysql.Driver");//反射机制
			//Class.forName("com.mysql.jdbc.Driver");//黑马写法
			//2.创建连接(开始建桥)获取数据库连接对象,URL：连谁写谁IP
			Connection conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//3.创建数据库执行对象(快递员送包裹) Statement的儿子PreparedStatement
			String sql = "select id,username,password,regtime from admin ";
			//Statement stmt = conn.createStatement(); //只负责走此桥的路，其他桥走不了
			PreparedStatement pstmt = conn.prepareStatement(sql);//预编译看一下Sql语句对不对
			//4.执行sql语句(快递员宋的包裹就是sql)
			ResultSet rs = pstmt.executeQuery();
			//5.处理结果集
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH小时mm分ss秒");
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Timestamp ts = rs.getTimestamp("regtime");
				System.out.println(sdf.format(ts));//更改时间日期格式
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
