package com.shero.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shero.dao.UserDao;
import com.shero.pojo.Users;

public class UserDaoImpl implements UserDao {

	private Connection conn = null; // ���ݿ����Ӷ���
	private PreparedStatement pstmt = null; // ���ݿ��������
	ResultSet rs = null;

	// ͨ�����췽��ȡ�����ݿ�����
	public UserDaoImpl(Connection conn) { 
		this.conn = conn;  
	}
	public int addUser(Users user) throws Exception{
		String sql = "insert into users(uname,passwd,email,lastlogin) values(?,?,?,sysdate())";
		int result = 0;
		pstmt = this.conn.prepareStatement(sql);//��ȡPreparedStatement����
		pstmt.setString(1, user.getUname());//�趨�û��û���
		pstmt.setString(2, user.getPasswd());//�趨�û�����
		pstmt.setString(3, user.getEmail());//�趨�û�Email
		result = pstmt.executeUpdate();//ִ�����ݿ����
		pstmt.close();
		return result;
	}

	public Users queryByEmail(String email) throws Exception{
		String sql = "select uid,uname,passwd,lastlogin from users where email=?";
		Users user = new Users();
		pstmt = this.conn.prepareStatement(sql);//��ȡPreparedStatement����
		pstmt.setString(1, email);
		rs = pstmt.executeQuery();//ִ�����ݿ����
		if (rs.next()) {
			user.setUid(rs.getInt(1));//�趨�û�id
			user.setUname(rs.getString(2));//�趨�û��û���
			user.setPasswd(rs.getString(3));//�趨�û�����
			user.setEmail(email);//�趨�û�Email
			
		}
		rs.close();//�ر�ResultSet����
		pstmt.close();//�ر�PreparedStatement����
		return user;
	}

	public Users queryByName(String uname) throws Exception{
		String sql = "select uid,passwd,email,lastlogin from users where uname=?";
		Users user = new Users();
		pstmt = this.conn.prepareStatement(sql);//��ȡPreparedStatement����
		pstmt.setString(1, uname);
		rs = pstmt.executeQuery();//ִ�����ݿ����
		if (rs.next()) {
			user.setUid(rs.getInt(1));//�趨�û�id
			user.setPasswd(rs.getString(2));//�趨�û�����
			user.setUname(uname);//�趨�û��û���
			user.setEmail(rs.getString(3));//�趨�û�Email
		
		}
		rs.close();//�ر�ResultSet����
		pstmt.close();//�ر�PreparedStatement����
		return user;
	}

	public int deleteUser(int uid) throws Exception{//ɾ��ָ���û�
		String sql = "delete from users where uid=?";
		int result = 0;
		pstmt = this.conn.prepareStatement(sql);//��ȡPreparedStatement����
		pstmt.setInt(1, uid);
		result = pstmt.executeUpdate();//ִ�����ݿ����
		pstmt.close();//�ر�PreparedStatement����
		return result;
	}

	//����ָ���û���Ϣ
	public int editInf(int uid, String uname, String email) throws Exception{
		System.out.println(uid+"---"+uname+"---"+email);
		String sql="update users set uname=?,email=? where uid=?";
		int result=0;
		pstmt=this.conn.prepareStatement(sql);//��ȡPreparedStatement����
		pstmt.setString(1, uname);
		pstmt.setString(2, email);
		pstmt.setInt(3, uid);
		result=pstmt.executeUpdate();//ִ�����ݿ����
		pstmt.close();
		return result;
	}
	//�޸��û�����
	public int editPasswd(int uid, String passwd) throws Exception{
		String sql="update users set passwd=? where uid=?";
		int result=0;
		pstmt=this.conn.prepareStatement(sql);//��ȡPreparedStatement����
		pstmt.setString(1, passwd);
		pstmt.setInt(2, uid);
		result=pstmt.executeUpdate();//ִ�����ݿ����
		pstmt.close();
		return result;
	}
}