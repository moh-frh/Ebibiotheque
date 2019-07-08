package com.servlets.Login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddAuteur
 */
@WebServlet("/AddAuteur")
public class AddAuteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAuteur() {
        super();
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
		
System.out.print("auteur post");
		
		String n = request.getParameter("nom").toString();
		String p = request.getParameter("prenom").toString();
		int d = Integer.parseInt(request.getParameter("date_naiss")) ;
		
		
		
		if(		
				! request.getParameter("nom").isEmpty() && 
				! request.getParameter("prenom").isEmpty() &&
				! request.getParameter("date_naiss").isEmpty()  )				
			
		{
			Connect c = new Connect();
			try {
				c.inserer_auteur(n, p, d);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher("/admin_dash.jsp").forward(request, response);
		}
		
		else 
		
		{

			
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
