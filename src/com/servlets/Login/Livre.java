package com.servlets.Login;

import java.util.ArrayList;

public class Livre {
	
	
	public int nbpage;
	public String titre, resume, domaine;
	public String auteur;
	
	public ArrayList<Livre> array_livres ;
	
	Livre(String titre, String resume, int nbpage, String domaine, String auteur)
	{
		this.titre = titre;
		this.resume = resume;
		this.nbpage = nbpage;
		this.domaine = domaine;
		this.auteur = auteur;
	}
	
	public void affiche()
	{
		 System.out.println(titre+"-"+resume+"-"+nbpage+"-"+domaine);
	}
	


	public int getNbpage() {
		return nbpage;
	}
	public void setNbpage(int nbpage) {
		this.nbpage = nbpage;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	

}
