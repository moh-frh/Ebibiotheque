package com.servlets.Login;

import java.sql.*;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Connect {
	
	public Connection connection;
	public Statement statement;
	int statut;
	public ResultSet resultat;
	
	public Connect()
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_ebibiliotheque","root","");
			
			statement = (Statement) connection.createStatement();
			
			//int statut = statement.executeUpdate( "INSERT INTO livres (nom, edition) VALUES ('nom1', 'edit1');" );
			
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void inserer_livre( String t, String r, int n, String d, String a) throws SQLException
	{
		int statut = statement.executeUpdate( "INSERT INTO livres (titre, resume, nbpage, domaine, auteur) "
				+ "VALUES ('"+t+"', '"+r+"', '"+n+"', '"+d+"', '"+a+"');" );
	}
	
	public void inserer_auteur( String n, String p, int d) throws SQLException
	{
		int statut = statement.executeUpdate( "INSERT INTO auteurs (nom, prenom, date_naiss) "
				+ "VALUES ('"+n+"', '"+p+"', '"+d+"');" );
	}
	
	public int count_livres() throws SQLException
	{
		int count = 0;
		 resultat =  statement.executeQuery("SELECT * from livres");
		 
		 while(resultat.next())
			 count ++;
		 
		 return count;
	}
	
	public int count_auteurs() throws SQLException
	{
		int count = 0;
		 resultat =  statement.executeQuery("SELECT * from auteurs");
		 
		 while(resultat.next())
			 count ++;
		 
		 return count;
	}

//	public int compteur_visiteur() throws SQLException
//	{
//		int i=0;
//		resultat = statement.executeQuery ( "EXECUTE dbo.webcounter"); 
//		
//		while(resultat.next())
//			i++;
//		
//		return i;
//	}
	
	public  ArrayList<String> recuperer_tous_auteurs() throws SQLException
	{
		ArrayList<String> arrayLivre = new ArrayList<String>();
		
		 resultat =  statement.executeQuery("SELECT * from auteurs");
		 
		 while(resultat.next())
		 {
			 String nom = resultat.getString("nom");
			 //String prenom = resultat.getString("prenom");
			 
			 //Livre l = new Livre(titre,resume,nbpage,domaine);
			// l.affiche();
			arrayLivre.add(nom);	 
		 } 
		 
		 return arrayLivre;	 
	}
	
	//;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	
	public  ArrayList<Livre> recuperer_tous_livres() throws SQLException
	{
		ArrayList<Livre> arrayLivre = new ArrayList<Livre>();
		
		 resultat =  statement.executeQuery("SELECT * from livres");
		 
		 while(resultat.next())
		 {
			 String titre = resultat.getString("titre");
			 String resume = resultat.getString("resume");
			 int nbpage = resultat.getInt("nbpage");
			 String domaine = resultat.getString("domaine");	
			 String auteur = resultat.getString("auteur");	
			 
			 Livre l = new Livre(titre,resume,nbpage,domaine,auteur);
			arrayLivre.add(l);	 
		 } 
		 
		 return arrayLivre;	 
	}


	public  ArrayList<Livre> recuperer_livres_par_domaine(String d ) throws SQLException
	{
		ArrayList<Livre> arrayLivre = new ArrayList<Livre>();
		System.out.print(d+"---- par domaine");
		 resultat =  statement.executeQuery("SELECT * from livres where domaine='"+d+"'");
		 
		 while(resultat.next())
		 {
			 
			
			 String titre = resultat.getString("titre");
			 String resume = resultat.getString("resume");
			 int nbpage = resultat.getInt("nbpage");
			 String domaine = resultat.getString("domaine");
			 String auteur = resultat.getString("auteur");
					 
			 Livre l = new Livre(titre,resume,nbpage,domaine,auteur);
			arrayLivre.add(l);	 
		 } 
		 
		 return arrayLivre;	 
	}

	public  ArrayList<Livre> recuperer_livres_par_auteur(String d ) throws SQLException
	{
		ArrayList<Livre> arrayLivre = new ArrayList<Livre>();
		
		 resultat =  statement.executeQuery("SELECT * from livres where auteur='"+d+"'");
		 
		 while(resultat.next())
		 {
			 
			
			 String titre = resultat.getString("titre");
			 String resume = resultat.getString("resume");
			 int nbpage = resultat.getInt("nbpage");
			 String domaine = resultat.getString("domaine");
			 String auteur = resultat.getString("auteur");
			 
			 
			 Livre l = new Livre(titre,resume,nbpage,domaine,auteur);
			// l.affiche();
			arrayLivre.add(l);	 
		 } 
		 
		 return arrayLivre;	 
	}
	
	public  ArrayList<Livre> recuperer_livres_par_titre(String d ) throws SQLException
	{
		ArrayList<Livre> arrayLivre = new ArrayList<Livre>();
		
		 resultat =  statement.executeQuery("SELECT * from livres where titre='"+d+"'");
		 
		 while(resultat.next())
		 {
			 
			
			 String titre = resultat.getString("titre");
			 String resume = resultat.getString("resume");
			 int nbpage = resultat.getInt("nbpage");
			 String domaine = resultat.getString("domaine");
			 String auteur = resultat.getString("auteur");
			 
		
			 Livre l = new Livre(titre,resume,nbpage,domaine,auteur);
			// l.affiche();
			arrayLivre.add(l);	 
		 } 
		 
		 return arrayLivre;	 
	}
}
