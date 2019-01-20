package com.shero.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Vector;
import org.junit.Test;
import com.shero.dao.GoodsDaoImpl;
import com.shero.db.DBConnection;
import com.shero.pojo.Goods;

public class GoodsDaoImplTest {

	
	@Test//标记方法是测试方法
	public void testQueryByPage() throws Exception {
		DBConnection dbConnection = new DBConnection();
		GoodsDaoImpl goodsDaoImpl= new GoodsDaoImpl(dbConnection.getConnection());
		Vector<Goods> goodsList=goodsDaoImpl.queryByPage(1, 5);
		System.out.println(goodsList);
		
	}

	@Test
	public void testGetCount() throws Exception {
		DBConnection dbConnection = new DBConnection();
		GoodsDaoImpl goodsDaoImpl= new GoodsDaoImpl(dbConnection.getConnection());
		int count=goodsDaoImpl.getCount();
		System.out.println(count);
	}

}
