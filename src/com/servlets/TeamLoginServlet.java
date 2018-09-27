package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDao;
import com.dao.impl.LoginDaoImpl;

/**
 * Servlet implementation class TeamLoginServlet
 */
@WebServlet("/tlogin")
public class TeamLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailid =request.getParameter("EmailId");
		String pass =request.getParameter("Password");
		System.out.println(emailid+"\t"+pass);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		LoginDao dao = new LoginDaoImpl();
		//System.out.println("5");
		if(dao.checkLogin(emailid, pass)){
			request.setAttribute("uname1", emailid);
			//writer.println("Welcome");
			//response.sendRedirect("success.jsp");
			//getServletContext().setAttribute("uname", email);
			System.out.println(emailid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("team.jsp");
		dispatcher.forward(request,response);
		}
		else {
			writer.println("Invalid Credentials Please LogIn Again");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request,response);
			
			
		} 
		
		// TODO Auto-generated method stub
	}

}
