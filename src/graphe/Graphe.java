package graphe;

import tools.ToolsString;

/**
 * Classe représentant un graphe dans cet exercice. Composé d'un tableau de mots
 * et d'un tableau d'indice de leurs successeurs respectifs.
 * 
 * @author monbailly
 * 
 */
public class Graphe {

	private String[] mot;
	private Liste[] listeSucc;
	private int nb;
	private boolean[] dejaVu;

	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================
	
	public Graphe(String[] lesMots) {
		super();
		this.mot = lesMots;
		this.nb = this.mot.length;
		this.listeSucc = new Liste[nb];
		this.dejaVu = new boolean[nb];

		for (int i=0; i< nb; i++)
			this.listeSucc[i] = new Liste();
		
		for (int i=0; i< nb; i++)
			this.dejaVu[i] = false;
	}

	// 	========================================================================================= 
	//	Fonctions Utiles
	// 	=========================================
	
	/**
	 * Ajoute successeur à la liste des successeurs du predecesseur.
	 * (on suppose que les mots qu'ils représentent différent bel et bien d'une lettre)
	 * (on suppose également les entiers indiqués corrects)
	 * 
	 * @param successeur
	 * @param predecesseur
	 */
	public void ajouterArete (int successeur, int predecesseur){
		this.listeSucc[predecesseur].ajouter(successeur);
		this.listeSucc[successeur].ajouter(predecesseur);

	}
	
	/**
	 * Initialise les listes de successeurs des mots contenus dans le dictionnaire.
	 * Pour rappel, un mot est successeur d'un autre si on peut passer de l'un à l'autre en changeant qu'une seule lettre.
	 */
	public void lettreQuiSaute() {
		// On fait toutes les combinaisons de mots possibles :
		for (int i=0; i < nb; i++) {
			for (int j=i+1; j < nb; j++) {

				// Si les deux mots différent d'une lettre et sont de même longueur on ajoute une arete
				if (this.mot[i].length() == this.mot[j].length() 
						&& ToolsString.diffUneLettre(this.mot[i],this.mot[j])) {
					this.ajouterArete(i,j);
				}
				// Dans le cas contraire on ne fait rien !
				
			}
		}
	}
	
	
	/**
	 * 
	 * @param depart
	 */
	public void DFS(int depart) {
		// On marque le départ :
		this.dejaVu[depart] = true;
		Liste succ = this.listeSucc[depart];
		int[] ind_succ = succ.listeEntier();
				
		for (int i=0; i< succ.taille(); i++) {
			if (!this.dejaVu[ind_succ[i]]) {
				System.out.println("on parcourt "+this.mot[i]+" en venant de "+this.mot[depart]);
				DFS(ind_succ[i]);
			}
		}
		
	}
	
	
	// 	========================================================================================= 
	//	Accesseurs
	// 	=========================================
	
	public String toString() {
		String res = "";
		for (int i=0; i< nb; i++)
			res += this.listeSucc[i].toString()+"\n";
		return res;
	}
	
	
	public static void main (String[] args) {
	    String[] dico3court = {
	       "gag", "gai", "gaz", "gel", "gks", "gin",
	       "gnu", "glu", "gui", "guy", "gre", "gue",
	       "ace", "acm", "agi", "ait", "aie", "ail",
	       "air", "and", "alu", "ami", "arc", "are",
	       "art", "apr", "avr", "sur", "mat", "mur" } ;
	    Graphe g = new Graphe (dico3court) ;
	    g.lettreQuiSaute() ;
	    g.DFS(0);
	  }

}
