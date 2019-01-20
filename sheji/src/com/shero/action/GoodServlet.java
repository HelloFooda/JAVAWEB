package com.shero.action;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.shero.db.JdbcUtils;

/**
 * Servlet implementation class GoodServlet
 */
@WebServlet(name="/GoodServlet",urlPatterns="/good")
public class GoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if (action.equals("sc-select")){
			String gid = request.getParameter("gid");
			try {
				java.sql.Connection connection = JdbcUtils.getConnection();
				PreparedStatement st = connection.prepareStatement
				("select gname,gphoto,gzt from goods where gid = ?");
				st.setString(1, gid);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					request.setAttribute("gphoto", rs.getString("gphoto"));
					request.setAttribute("gname", rs.getString("gname"));
					request.setAttribute("gzt", rs.getString("gzt"));
					request.getRequestDispatcher("good.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
