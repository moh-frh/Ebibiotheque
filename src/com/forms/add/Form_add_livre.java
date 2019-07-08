package com.forms.add;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.Login.Connect;
import com.servlets.Login.Livre;

/**
 * Servlet implementation class Form_add_livre
 */
@WebServlet("/Form_add_livre")
public class Form_add_livre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form_add_livre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//this.getServletContext().getRequestDispatcher("ajouter_livre.jsp");
		
		Connect c = new Connect();
		
		ArrayList<String> array_recup_tous_auteurs = new ArrayList<String>();
		
		try {
			array_recup_tous_auteurs = c.recuperer_tous_auteurs();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int count_livres=0, count_auteurs=0;
		try {
			count_livres = c.count_livres();
			count_auteurs = c.count_auteurs();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("count_livres", count_livres);
		request.setAttribute("count_auteurs", count_auteurs);
		
		request.setAttribute("liste_auteurs", array_recup_tous_auteurs);
		
		this.getServletContext().getRequestDispatcher("/ajouter_livre.jsp").forward(request, response);
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
