package com.shero.action.user;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shero.action.Action;
import com.shero.db.DAOFactory;
import com.shero.pojo.Users;

public class EditPasswdAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int uid = Integer.parseInt(String.valueOf(
				request.getSession().getAttribute("uid")));
	
		String oldPasswd = request.getParameter("oldPasswd");

		String passwd = request.getParameter("passwd1");
		String confirdPasswd = request.getParameter("passwd2");
		try{

			Users user =DAOFactory.getUserDAOInstance().
				queryByName(String.valueOf(
						request.getSession().getAttribute("uname")));
			
			if(user.getPasswd().equals(oldPasswd)){
				if(isValidPassword(passwd,confirdPasswd)){
					request.setAttribute("status", "密码为空或者密码不一致");
				}
				if(DAOFactory.getUserDAOInstance().
						editPasswd(uid, passwd)==1){
					request.setAttribute("status", "密码修改成功");
				}else{
					request.setAttribute("status", "密码修改操作失败，请重试");
				}
			}else{
				request.setAttribute("status", "原密码错误，你不能修改密码");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "login.jsp";
	}

	public boolean isValidPassword(String passwd,String confirdPasswd){
		return passwd==null||confirdPasswd==null
		||passwd.length()<6||confirdPasswd.length()<6
		||!passwd.equals(confirdPasswd);
	}
}
