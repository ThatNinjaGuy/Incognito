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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email =request.getParameter("EmailId");
		String pass =request.getParameter("Password");
		//String uname="Empty";
		System.out.println(email+"\t"+pass);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		LoginDao dao = new LoginDaoImpl();
		//System.out.println("5");
		if(dao.checkLogin(email, pass)){
			request.setAttribute("uname", email);
			//writer.println("Welcome");
			//response.sendRedirect("success.jsp");
			//getServletContext().setAttribute("uname", email);
			System.out.println(email);
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request,response);
		}
		else {
			writer.println("Invalid Credentials Please LogIn Again");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request,response);
			
			
		} 
		
	}

}
