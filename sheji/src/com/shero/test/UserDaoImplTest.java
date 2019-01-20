package com.shero.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.shero.dao.UserDaoImpl;
import com.shero.db.DBConnection;

public class UserDaoImplTest {

	@Test
	public void testUserDaoImpl() throws Exception {
		DBConnection dbConnection = new DBConnection();
		UserDaoImpl userdaoimpl	= new UserDaoImpl(dbConnection.getConnection());

	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

}
