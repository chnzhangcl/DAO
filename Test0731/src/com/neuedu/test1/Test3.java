package com.neuedu.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个用户名：");
		String uname = sc.next();
		System.out.println("请输入一个密码：");
		String pword = sc.next();
		boolean flag = false;
		try {
			//1.加载数据库驱动（建桥前审批的过程）导jar包
			Class.forName("org.gjt.mm.mysql.Driver");//反射机制
			//Class.forName("com.mysql.jdbc.Driver");//黑马写法
			//2.创建连接(开始建桥)获取数据库连接对象,URL：连谁写谁IP
			Connection conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//3.创建数据库执行对象(快递员送包裹) Statement是个接口不能实例化，利用conn造对象
			Statement stmt = conn.createStatement(); //只负责走此桥的路，其他桥走不了
			//4.执行sql语句(快递员宋的包裹就是sql)
			String sql = "select id,username,password from admin";
			ResultSet rs =stmt.executeQuery(sql);
			//5.处理结果集，
			while(rs.next()){ //next 一下光标就下移一行   相当于集合链表，但是不是
				//循环判断游标是否是最后一行
				int id = rs.getInt("id"); //括号里写此数据在第几列，知道1写1也行
				String username = rs.getString("username");
				String password = rs.getString("password");
				if(uname.equals(username)&&pword.equals(password)){
					System.out.println("登录成功:"+"你的id是:"+id+",用户名是："+username+",密码是："+"*****");
					flag = false;
					break;
				}
				flag = true;
				//System.out.println(id+" "+username+" "+password);
			}
			if(flag){
				System.out.println("用户名或密码错误");
			}
			//6.释放资源（关闭连接）
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
