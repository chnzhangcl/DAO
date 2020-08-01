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
			//1.�������ݿ�����������ǰ�����Ĺ��̣���jar��
			Class.forName("org.gjt.mm.mysql.Driver");//�������
			//Class.forName("com.mysql.jdbc.Driver");//����д��
			//2.��������(��ʼ����)��ȡ���ݿ����Ӷ���,URL����˭д˭IP
			Connection conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//3.�������ݿ�ִ�ж���(���Ա�Ͱ���) Statement�Ķ���PreparedStatement
			String sql = "select id,username,password,regtime from admin ";
			//Statement stmt = conn.createStatement(); //ֻ�����ߴ��ŵ�·���������߲���
			PreparedStatement pstmt = conn.prepareStatement(sql);//Ԥ���뿴һ��Sql���Բ���
			//4.ִ��sql���(���Ա�εİ�������sql)
			ResultSet rs = pstmt.executeQuery();
			//5.��������
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HHСʱmm��ss��");
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Timestamp ts = rs.getTimestamp("regtime");
				System.out.println(sdf.format(ts));//����ʱ�����ڸ�ʽ
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
