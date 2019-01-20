package com.shero.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shero.action.Action;
import com.shero.action.user.EditPasswdAction;
import com.shero.action.user.EditUserAction;
import com.shero.action.user.EditinfUserAction;
import com.shero.action.user.ShowUserAction;


@WebServlet(
		urlPatterns = { "/user" }, 
		name = "userServlet" 
	)
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		Action targetAction =null;
		String path = null;
		if (action.equals("show")) {//查看用户列表
			targetAction = new ShowUserAction();
			path=targetAction.execute(request, response);
		} else if (action.equals("edit")) {//跳转编辑用户页面
			targetAction = new EditUserAction();
			path=targetAction.execute(request, response);
		} else if (action.equals("editinf")) {//修改用户信息
			targetAction = new EditinfUserAction();
			path=targetAction.execute(request, response);
		} else if (action.equals("editpasswd")) {//更改密码
			targetAction = new EditPasswdAction();
			path=targetAction.execute(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}