package com.shero.dao;

import com.shero.pojo.Users;

public interface UserDao {
	//����û�
	public int addUser(Users user) throws Exception;
	//�޸��û���Ϣ
	public int editInf(int uid,String uname,String email) throws Exception;
	//�޸��û�����
	public int editPasswd(int uid,String passwd) throws Exception;
	//�����û�id��ɾ���û�
	public int deleteUser(int uid) throws Exception;
	//�����û�����ѯ�û�
	public Users queryByName(String uname) throws Exception;
	//�����û�Email��ѯ�û�
	public Users queryByEmail(String email) throws Exception;

}
