package com.shero.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shero.action.Action;
import com.shero.db.DAOFactory;
import com.shero.pojo.Users;

public class EditinfUserAction implements Action{

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		int uid = Integer.parseInt(String.valueOf(
				request.getSession().getAttribute("uid")));
	
		String uname = request.getParameter("uname");
	
		String email = request.getParameter("email");
		try{
			
			Users user=DAOFactory.getUserDAOInstance().queryByName(
					String.valueOf(request.getSession().getAttribute("uname")));
			if(user.getUname().equals(uname)||
					DAOFactory.getUserDAOInstance().
					queryByName(uname).getUid()==0){
				if(user.getEmail().equals(email)||
						DAOFactory.getUserDAOInstance().
						queryByEmail(email).getUid()==0){
					if(DAOFactory.getUserDAOInstance().
							editInf(uid, uname, email)==1){
						request.getSession().setAttribute("uname", uname);
						request.setAttribute("status", "信息修改成功！");
					}else{
						request.setAttribute("status", "修改操作失败，请重试！");
					}
				}else{
					request.setAttribute("status", "电子邮箱账号已被注册，请换一个！");
				}
			}else{
				request.setAttribute("status", "用户名已存在，请换一个！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "shoppingcart?action=lookbus";
	}

}
