package com.shero.test;

import org.junit.Test;

import com.shero.pojo.PageObject;
import com.shero.service.GoodsService;
import com.shero.service.GoodsServiceImpl;

public class GoodsServiceImplTest {
	GoodsService GoodsService=null;
	@Test
	public void test() throws Exception {
		GoodsService=new GoodsServiceImpl();
		System.out.println("-----------����һ�����---------");
		PageObject pageObject=GoodsService.queryByPage(2, 6);
		System.out.println(pageObject.getData().toString());
	}
	@Test
	public void test1() throws Exception{
		GoodsService=new GoodsServiceImpl();
		System.out.println("-----------����pageSizeδ�������---------");
		PageObject pageObject1=GoodsService.queryByPage(1, 0);
		System.out.println(pageObject1.getData().toString());
		System.out.println("-------------------------------");
	}
	@Test
	public void test2() throws Exception{
		GoodsService=new GoodsServiceImpl();
		System.out.println("-----------����pageSize���븺ֵ���---------");
		PageObject pageObject2=GoodsService.queryByPage(1, -5);
		System.out.println(pageObject2.getData().toString());
		System.out.println("-------------------------------");
	}

}
