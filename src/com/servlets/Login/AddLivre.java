package com.servlets.Login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLivre
 */
@WebServlet("/AddLivre")
public class AddLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String t = request.getParameter("titre").toString();
		String r = request.getParameter("resume").toString();
		int n = Integer.parseInt(request.getParameter("nbrpage")) ;
		String d = request.getParameter("domaine").toString();
		String a = request.getParameter("auteur").toString();
		
		
		if(		
				! request.getParameter("titre").isEmpty() && 
				! request.getParameter("resume").isEmpty() &&
				! request.getParameter("nbrpage").isEmpty() &&
				! request.getParameter("domaine").isEmpty()  )
			
		{
			Connect c = new Connect();
			int count_livres = 0;
			int count_auteurs = 0;
			try {
				count_livres = c.count_livres();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				count_auteurs = c.count_auteurs();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			request.setAttribute("count_livres", count_livres);
			request.setAttribute("count_auteurs", count_auteurs);
			try {
				request.setAttribute("tous_livres", c.recuperer_tous_livres());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				c.inserer_livre(t, r, n, d,a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher("/admin_dash.jsp").forward(request, response);;
		}
		
		else 
		
		{
			
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

}
