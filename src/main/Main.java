package main;

import tools.Dicos;
import graphe.Graphe;

public class Main {
	
	public static void main (String[] args) {
		String[] dico3court = {
	       "gag", "gai", "gaz", "gel", "gks", "gin",
	       "gnu", "glu", "gui", "guy", "gre", "gue",
	       "ace", "acm", "agi", "ait", "aie", "ail",
	       "air", "and", "alu", "ami", "arc", "are",
	       "art", "apr", "avr", "sur", "mat", "mur" } ;
	
		Graphe gex = new Graphe (dico3court) ;
	    gex.lettreQuiSaute() ;
	    gex.visit();
	    
	    System.out.println();
		
		// ------------------------------------------------
		// Execution demandée pour l'exercice 2 :
		
		Graphe g = new Graphe (Dicos.dico4) ;
	    g.lettreQuiSaute() ;
	    g.visit();
	    
	    // "peur" et "lion" sont membres de la composante connexe n°1 !
	    // ------------------------------------------------
	    
	    // ------------------------------------------------
	 	// Execution demandée pour l'exercice 3 :
	    
	    g.chemin("lion", "peur");
	    
	    // SOLUTION A VERIFIER POUR VALIDATION DE LA METHODE !
	    // ------------------------------------------------
	    
	  }
}
