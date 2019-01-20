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
import com.shero.pojo.Tb;

/**
 * Servlet implementation class NeiRongServlet
 */
@WebServlet(name="/NeiRongServlet", urlPatterns="/neirong")
public class NeiRongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NeiRongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		String path=null;
		
		if (action.equals("tl-select")){
			String tid = request.getParameter("tid");
			try {
				java.sql.Connection connection = JdbcUtils.getConnection();
				PreparedStatement st = connection.prepareStatement
				("select tbt,tzw from tb where tid = ?");
				st.setString(1, tid);
				ResultSet rs = st.executeQuery();
				while (rs.next()){
				request.setAttribute("tbt1", rs.getString("tbt"));
				request.setAttribute("tzw1", rs.getString("tzw"));
				request.getRequestDispatcher("nr.jsp").forward(request, response);
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
