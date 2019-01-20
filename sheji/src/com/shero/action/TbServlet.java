package com.shero.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shero.pojo.PageObject;
import com.shero.service.TbService;
import com.shero.service.TbServiceImpl;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/tb")
public class TbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TbServlet() {
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
			
			TbService tbService=null;
			try{
			
			tbService=new TbServiceImpl();
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
				pObject=tbService.queryByPage(curPage1,pageSize1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("pageObject", pObject);
			String path="tl.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		if("search".equals(action)){
			//执行模糊查询
		}
	}

}
