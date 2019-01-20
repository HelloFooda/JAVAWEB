package com.shero.test;

import static org.junit.Assert.*;
import java.util.Vector;
import org.junit.Test;
import com.shero.dao.TbdaoImpl;
import com.shero.db.DBConnection;
import com.shero.pojo.Tb;

public class TbdaoImplTest {

	@Test
	public void testTbdaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTZW() throws Exception {
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

	@Test
	public void testQueryByPage() throws Exception {
			DBConnection dbConnection = new DBConnection();
			TbdaoImpl tbdaoImpl= new TbdaoImpl(dbConnection.getConnection());
			Vector<Tb> tbList=tbdaoImpl.queryByPage(1, 2);
			System.out.println(tbList);
	}

	@Test
	public void testGetCount() {
		fail("Not yet implemented");
	}

}
