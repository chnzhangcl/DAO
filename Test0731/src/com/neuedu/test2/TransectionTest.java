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
		System.out.println("������һ���û�����");
		String uname = sc.next();
		System.out.println("������һ�����룺");
		String pword = sc.next();
		Date date = new Date();
		//��1970�굽���ڵ�ms��
		Timestamp ts = new Timestamp(date.getTime());
		try {
			//1.�������ݿ�����������ǰ�����Ĺ��̣���jar��
			Class.forName("org.gjt.mm.mysql.Driver");//�������
			//Class.forName("com.mysql.jdbc.Driver");//����д��
			//2.��������(��ʼ����)��ȡ���ݿ����Ӷ���,URL����˭д˭IP
			Connection conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
			//3.�������ݿ�ִ�ж���
			conn.setAutoCommit(false); //�ֶ��ύ
			String sql ="insert into admin(username,password,regtime) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);//Ԥ���뿴һ��Sql���Բ���
			//4.ִ��sql���
			pstmt.setString(1,uname);
			pstmt.setString(2,pword);
			pstmt.setTimestamp(3, ts);
			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("ע��ɹ�");
			}
			conn.commit();
			//6.�ͷ���Դ���ر����ӣ�
			pstmt.close();
			conn.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
