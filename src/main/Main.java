package main;

import graphe.Graphe;

public class Main {
	
	public static void main (String[] args) {
		String[] dico3court = {
	       "gag", "gai", "gaz", "gel", "gks", "gin",
	       "gnu", "glu", "gui", "guy", "gre", "gue",
	       "ace", "acm", "agi", "ait", "aie", "ail",
	       "air", "and", "alu", "ami", "arc", "are",
	       "art", "apr", "avr", "sur", "mat", "mur" } ;
		Graphe g = new Graphe (dico3court) ;
	    g.lettreQuiSaute() ;
	    System.out.println(g);
	  }
}
