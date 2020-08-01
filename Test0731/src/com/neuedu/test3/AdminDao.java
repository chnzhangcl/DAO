/*package com.neuedu.test3;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDao {
	private Connection conn;
	
	public AdminDao() throws Exception{
		//1.�������ݿ�����������ǰ�����Ĺ��̣���jar��
		Class.forName("org.gjt.mm.mysql.Driver");//�������
		//Class.forName("com.mysql.jdbc.Driver");//����д��
		//2.��������(��ʼ����)��ȡ���ݿ����Ӷ���,URL����˭д˭IP
		conn = DriverManager.getConnection("jdbc:mysql:///test","root","root");
	}
	
	
	public void insert(String uname,String pword,Timestamp ts) throws SQLException{
		PreparedStatement pstmt = null;
		try {
			//3.�������ݿ�ִ�ж���
			conn.setAutoCommit(false); //�ֶ��ύ
			String sql ="insert into admin(username,password,regtime) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);//Ԥ���뿴һ��Sql���Բ���
			//4.ִ��sql���
			pstmt.setString(1,uname);
			pstmt.setString(2,pword);
			pstmt.setTimestamp(3, ts);
			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("ע��ɹ�");
			}
			conn.commit();
		} catch (Exception e) { 
			e.printStackTrace();
		}finally{
			//6.�ͷ���Դ���ر����ӣ�
			if(pstmt!= null){
				pstmt.close();
			}
		}
	}
	
	public void query(){
		PreparedStatement pstmt = null;
		try {
			//3.�������ݿ�ִ�ж���
			conn.setAutoCommit(false); //�ֶ��ύ
			String sql ="insert into admin(username,password,regtime) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);//Ԥ���뿴һ��Sql���Բ���
			//4.ִ��sql���

			int num = pstmt.executeUpdate();
			if(num>0){
				System.out.println("ע��ɹ�");
			}
			conn.commit();
		} catch (Exception e) { 
			e.printStackTrace();
		}finally{
			//6.�ͷ���Դ���ر����ӣ�
			if(pstmt!= null){
				pstmt.close();
			}
		}
	}

	public void update(){
		
	}

	public void delete(){
		
	}	
}
*/