package com.servlets.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(request.getParameter("password").equals("admin") && request.getParameter("email").equals("admin@admin.dz") )
		{
			
			Connect c = new Connect();
			
			int i =0;
			
			try {
				int count_livres = c.count_livres();
				int count_auteurs = c.count_auteurs();
				
				
				request.setAttribute("count_livres", count_livres);
				request.setAttribute("count_auteurs", count_auteurs);
				request.setAttribute("tous_livres", c.recuperer_tous_livres());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("email", "admin@admin");
			
			
			this.getServletContext().getRequestDispatcher("/admin_dash.jsp").forward(request, response);
		}
		else {
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
	}

}
