package com.shero.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shero.db.DAOFactory;
import com.shero.pojo.Users;

@WebServlet(
		urlPatterns = { "/register" }, 
		name = "registerServlet" 
	)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//��ȡҳ������������û�����������
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		String path = null;
		//Ϊ�û��趨����ֵ
		Users user = new Users();
		user.setUname(uname);
		user.setPasswd(passwd);
		user.setEmail(email);
		try{
			if (DAOFactory.getUserDAOInstance().
					queryByName(uname).getUid() == 0) {// �û�������
				if (DAOFactory.getUserDAOInstance().
						queryByEmail(email).getUid() == 0) {// �������
					if (DAOFactory.getUserDAOInstance().addUser(user) == 1) {
						request.getSession().setAttribute("uname", uname);
						request.getSession().setAttribute("uid",
								DAOFactory.getUserDAOInstance().queryByName(uname).getUid());
						path = "login.jsp";
						request.setAttribute("status", "��ϲ����ע��ɹ���");
					} else {
						path = "register.jsp";
						request.setAttribute("status", "ע��ʧ�ܣ������ԡ���");
					}
				} else {
					path = "register.jsp";
					request.setAttribute("status", "���������ѱ�ע��");
				}
			}else{
				path = "register.jsp";
				request.setAttribute("status", "�û����ѱ�ע��");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
