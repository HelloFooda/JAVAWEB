package com.shero.action;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.shero.db.JdbcUtils;
import com.sun.xml.internal.ws.client.sei.ValueSetter;


/**
 * Servlet implementation class FabuServlet
 */
@WebServlet(name="FabuServlet",urlPatterns="/fabu")
public class FabuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FabuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tsp =request.getParameter("tsp");
		String tbt =request.getParameter("tbt");
		String tzw =request.getParameter("tzw");
			 
        try {
			java.sql.Connection connection = JdbcUtils.getConnection();
			PreparedStatement st = connection.prepareStatement
				("Insert into tb(tsp,tbt,tzw) values(?,?,?)");
			st.setString(1, tsp);
			st.setString(2, tbt);
			st.setString(3, tzw);
			st.executeUpdate();
			request.getRequestDispatcher("tl.jsp").forward(request, response );
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
