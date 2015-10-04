package app.Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
//@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	System.out.println("Amish1");
	String userName = request.getParameter("username");
	String password = request.getParameter("password");
	PrintWriter out=response.getWriter();
	
	if(userName.equals("Amish"))
	{
		if(password.equals("Amish"))
		{
			request.setAttribute("entry","Succed");
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request,response);
		}
		else
		{
			out.println("Password is Incorrect");
			RequestDispatcher view = request.getRequestDispatcher("Login.jsp");	
              view.forward(request, response);
		}
		
	}
	else
		
	{
		System.out.println("Username is Incorrect ");
		RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
		view.forward(request, response);

	}
	
	
	
	}

}
