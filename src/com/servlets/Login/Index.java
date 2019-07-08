package com.servlets.Login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ResultSet> array_livres = new ArrayList<ResultSet>();
		Connect c = new Connect();
		
		try {
			
			ArrayList<Livre> array_recup_tous_livres = new ArrayList<Livre>();
			
			array_recup_tous_livres.addAll(c.recuperer_tous_livres());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			request.setAttribute("livres", c.recuperer_tous_livres());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<ResultSet> array_livres = new ArrayList<ResultSet>();
		Connect c = new Connect();
		
		String rech = request.getParameter("recherche").toString();
		String type_rech = request.getParameter("type_recherche").toString();
		
		
			
			ArrayList<Livre> array_recup_livres = new ArrayList<Livre>();
			
			if(type_rech.equals("par domaine"))
				try {
					array_recup_livres.addAll(c.recuperer_livres_par_domaine(rech));
					request.setAttribute("livres", c.recuperer_livres_par_domaine(rech));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			else if(type_rech.equals("par livre"))
				try {
					array_recup_livres.addAll(c.recuperer_livres_par_titre(rech));
					request.setAttribute("livres", c.recuperer_livres_par_titre(rech));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			else if(type_rech.equals("par auteur"))
				try {
					array_recup_livres.addAll(c.recuperer_livres_par_auteur(rech));
					request.setAttribute("livres", c.recuperer_livres_par_auteur(rech));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			else
				try {
					array_recup_livres.addAll(c.recuperer_tous_livres());
					request.setAttribute("livres", c.recuperer_tous_livres());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
	
		
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

}
