package main;

import tools.Dicos;
import graphe.Graphe;

public class Main {
	
	public static void main (String[] args) {
		
		// exercice 1 :
		
		String[] dico3court = {
	       "gag", "gai", "gaz", "gel", "gks", "gin",
	       "gnu", "glu", "gui", "guy", "gre", "gue",
	       "ace", "acm", "agi", "ait", "aie", "ail",
	       "air", "and", "alu", "ami", "arc", "are",
	       "art", "apr", "avr", "sur", "mat", "mur" } ;
	
		Graphe gex = new Graphe (dico3court) ;
	    gex.lettreQuiSaute() ;
	    gex.visit("DFS");
	    System.out.println();
	    
		
		// ------------------------------------------------
		// Execution demandée pour l'exercice 2 :
		
		Graphe g = new Graphe (Dicos.dico4) ;
	    g.lettreQuiSaute() ;
	    g.visit("DFS");
	    System.out.println();
	    
	    // "peur" et "lion" sont membres de la composante connexe n°1 !
	    // ------------------------------------------------
	    
	    // ------------------------------------------------
	 	// Execution demandée pour l'exercice 3 :
	    
	    System.out.println(g.chemin("lion", "peur"));
	    System.out.println();
	    
	    // résultat : lion pion paon pain paix poix pois bois boit bout gout aout bout boit bois pois poix voix voie vote hote home houe houx toux tous mous vous nous bous bouc boue doue dose dise dose rose roue roux poux pouf pour peur
	    // ------------------------------------------------
	    
	    
	    // ------------------------------------------------
	 	// Execution demandée pour l'exercice 4 :
	    
	    g.visit("BFSIteratif");
	    System.out.println();
	    System.out.println(g.chemin("lion", "peur"));
	    
	    // résultat : lion pion paon pain bain brin bric broc troc croc choc chou clou clot plot plut peut peur
	    // ------------------------------------------------
	    
	  }
}
