package com.neuedu.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���û�����");
		String uname = sc.next();
		System.out.println("������һ�����룺");
		String pword = sc.next();
		boolean flag = false;
		try {
			//1.�������ݿ�����������ǰ�����Ĺ��̣���jar��
			Class.forName("org.gjt.mm.mysql.Driver");//�������
			//Class.forName("com.mysql.jdbc.Driver");//����д��
			//2.��������(��ʼ����)��ȡ���ݿ����Ӷ���,URL����˭д˭IP
			Connection conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//3.�������ݿ�ִ�ж���(���Ա�Ͱ���) Statement�Ǹ��ӿڲ���ʵ����������conn�����
			Statement stmt = conn.createStatement(); //ֻ�����ߴ��ŵ�·���������߲���
			//4.ִ��sql���(���Ա�εİ�������sql)
			String sql = "select id,username,password from admin";
			ResultSet rs =stmt.executeQuery(sql);
			//5.����������
			while(rs.next()){ //next һ�¹�������һ��   �൱�ڼ����������ǲ���
				//ѭ���ж��α��Ƿ������һ��
				int id = rs.getInt("id"); //������д�������ڵڼ��У�֪��1д1Ҳ��
				String username = rs.getString("username");
				String password = rs.getString("password");
				if(uname.equals(username)&&pword.equals(password)){
					System.out.println("��¼�ɹ�:"+"���id��:"+id+",�û����ǣ�"+username+",�����ǣ�"+"*****");
					flag = false;
					break;
				}
				flag = true;
				//System.out.println(id+" "+username+" "+password);
			}
			if(flag){
				System.out.println("�û������������");
			}
			//6.�ͷ���Դ���ر����ӣ�
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
