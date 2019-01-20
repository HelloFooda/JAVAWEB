package com.shero.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shero.db.DAOFactory;
import com.shero.pojo.Goods;
import com.shero.pojo.PageObject;
import com.shero.service.GoodsService;
import com.shero.service.GoodsServiceImpl;

@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 同时支持get请求
		String action=request.getParameter("action");
		
		if("all".equals(action)){
			//调用service进行商品分页查询
			String curPage=request.getParameter("curPage");
			String pageSize=request.getParameter("pageSize");
			
			GoodsService goodsService=null;
			try{
			
			goodsService=new GoodsServiceImpl();
		}catch (Exception e) {
			e.printStackTrace();
		}	
			int curPage1=0;
			int pageSize1=0;
			if(curPage!=null&&curPage.equals("")){
				curPage1=Integer.valueOf(curPage);
				pageSize1=Integer.valueOf(pageSize);
		
			}
			PageObject pObject=null;
			try {
				pObject=goodsService.queryByPage(curPage1,pageSize1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("pageObject", pObject);
			String path="sc.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		if("search".equals(action)){
			//执行模糊查询
		}
	}
}
