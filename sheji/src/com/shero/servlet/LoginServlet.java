package com.shero.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shero.db.DAOFactory;
import com.shero.pojo.Users;

@WebServlet(
	urlPatterns = { "/login" }, 
	name = "loginServlet" 
)
public class LoginServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		String action = request.getParameter("action");
		String path = null;

		try{
			if (action.equals("login")) {
				Users user = DAOFactory.getUserDAOInstance().
					queryByName(uname);
				if (passwd.equals(user.getPasswd())) {
					request.getSession().setAttribute("uname", uname);
					request.getSession().setAttribute("uid", user.getUid());
					path = "frist.jsp";
				} else {
					request.setAttribute("status", "鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒锛�");
					path = "login.jsp";
				}
			} else if (action.equals("logout")) {
				request.getSession().removeAttribute("uname");
				request.getSession().removeAttribute("uid");
				path = "login.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
