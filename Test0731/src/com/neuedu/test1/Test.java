package com.neuedu.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		try {
			//1.�������ݿ�����������ǰ�����Ĺ��̣���jar��
			Class.forName("org.gjt.mm.mysql.Driver");//�������
			//Class.forName("com.mysql.jdbc.Driver");//����д��
			//2.��������(��ʼ����)��ȡ���ݿ����Ӷ���,URL����˭д˭IP
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			//3.�������ݿ�ִ�ж���(���Ա�Ͱ���) Statement�Ǹ��ӿڲ���ʵ����������conn�����
			String sql = "insert into admin(username,password,regtime) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql); //ֻ�����ߴ��ŵ�·���������߲���
			//4.ִ��sql���(���Ա�εİ�������sql)
			int e = pstmt.executeUpdate();
			//5.����������
			if(e>0){
				System.out.println("��ӳɹ�");
			}
		
			//6.�ͷ���Դ���ر����ӣ�
			pstmt.close();
			conn.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
