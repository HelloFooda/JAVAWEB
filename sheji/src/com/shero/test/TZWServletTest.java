package com.shero.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.shero.dao.TbdaoImpl;
import com.shero.db.DBConnection;
import com.shero.pojo.Tb;

public class TZWServletTest {

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws Exception {
		DBConnection dbConnection = new DBConnection();
		TbdaoImpl tbdaoImpl= new TbdaoImpl(dbConnection.getConnection());
		String sql ="insert into tb values(?,?,?)";
		Tb tzw = null;
		tzw = new Tb();
		tzw.setTbt("1");
		tzw.setTzw("2");
		tzw.setTsp("3");
		System.out.println(tzw);
	}

}
