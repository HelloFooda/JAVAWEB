package com.shero.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shero.action.Action;
import com.shero.db.DAOFactory;
import com.shero.pojo.Users;

public class ShowUserAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			
			Users user = DAOFactory.getUserDAOInstance().queryByName(
					String.valueOf(request.getSession().getAttribute("uname")));
			request.setAttribute("email", user.getEmail());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "user/myinf.jsp";
	}
}