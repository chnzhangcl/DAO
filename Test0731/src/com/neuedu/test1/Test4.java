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
		System.out.println("������һ���û�����");
		String uname = sc.next();
		System.out.println("������һ�����룺");
		String pword = sc.next();
		try {
			//1.�������ݿ�����������ǰ�����Ĺ��̣���jar��
			Class.forName("org.gjt.mm.mysql.Driver");//�������
			//Class.forName("com.mysql.jdbc.Driver");//����д��
			//2.��������(��ʼ����)��ȡ���ݿ����Ӷ���,URL����˭д˭IP
			Connection conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//3.�������ݿ�ִ�ж���(���Ա�Ͱ���) Statement�Ķ���PreparedStatement
			String sql = "select id,username,password from admin where username = ? and password = ?";
			//Statement stmt = conn.createStatement(); //ֻ�����ߴ��ŵ�·���������߲���
			PreparedStatement pstmt = conn.prepareStatement(sql);//Ԥ���뿴һ��Sql���Բ���
			//4.ִ��sql���(���Ա�εİ�������sql)
			pstmt.setString(1,uname);
			pstmt.setString(2,pword);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				System.out.println("��¼�ɹ�");
			}else{
				System.out.println("��¼ʧ��");
			}
			//6.�ͷ���Դ���ر����ӣ�
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
