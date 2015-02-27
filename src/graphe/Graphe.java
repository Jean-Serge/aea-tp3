package graphe;

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

	public Graphe(String[] lesMots) {
		super();
		this.mot = lesMots;
		this.nb = this.mot.length;
		this.listeSucc = new Liste[nb];

		for (int i=0; i< nb; i++)
			this.listeSucc[i] = new Liste();
	}

	
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
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static boolean diffUneLettre (String a, String b) {
	    // a et b supposees de meme longueur
	    int i=0 ;
	    while (i<a.length () && a.charAt (i) == b.charAt (i))
	      ++i ;
	    if (i == a.length ()) return false ;
	    ++i ;
	    while (i<a.length () && a.charAt (i) == b.charAt (i))
	      ++i ;
	    if (i == a.length ()) return true ;
	    return false ;
	  }
	
	
	/**
	 * 
	 */
	public void lettreQuiSaute() {
		// On fait toutes les combinaisons de mots possibles :
		for (int i=0; i < nb; i++) {

			for (int j=i+1; j < nb; j++) {

				// Si les deux mots différent d'une lettre et sont de même longueur on ajoute une arete
				if (this.mot[i].length() == this.mot[j].length() 
						&& diffUneLettre(this.mot[i],this.mot[j])) {
					this.ajouterArete(i,j);
				}
				
			}
		}
	}
	
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
	    System.out.println(g);
	  }
	
}
