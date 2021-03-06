package graphe;

import java.util.LinkedList;
import java.util.Queue;

import tools.ToolsString;

/**
 * Classe représentant un graphe dans cet exercice. Composé d'un tableau de mots
 * et d'un tableau d'indice de leurs successeurs respectifs.
 * 
 * @author monbailly
 * @author verbaere
 */
public class Graphe {

	private String[] mot;
	private Liste[] listeSucc;
	private int nb;
	private boolean[] dejaVu;
	private int[] pere;

	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================
	
	public Graphe(String[] lesMots) {
		super();
		this.mot = lesMots;
		this.nb = this.mot.length;
		this.listeSucc = new Liste[nb];
		this.dejaVu = new boolean[nb];
		this.pere = new int[nb];

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
	 * Effectue un parcours en profondeur dans le graphe depuis un mot de départ.
	 * @param depart l'indice du mot de départ du parcours
	 */
	public void DFS(int depart) {
		System.out.print(this.mot[depart]+" ");
		// On marque le départ :
		this.dejaVu[depart] = true;
		Liste succ = this.listeSucc[depart];
		
		// On récupère les indices de tous les successeurs du mot d'indice 'depart' :
		int[] ind_succ = succ.listeEntier();
		
		
		for (int i=0; i< succ.taille(); i++) {
			// Pour chaque successeur, si on trouve un mot qui n'a pas encore été parcouru alors on continu le parcours.
			if (!this.dejaVu[ind_succ[i]]) {
				DFS(ind_succ[i]);
				this.pere[ind_succ[i]] = depart;
			}
		}
	}
	
	/**
	 * Effectue un parcours en profondeur dans le graphe depuis un mot de départ itérativement
	 * (cad qu'on regarde les profondeurs x puis x+1 etc...).
	 * @param depart l'indice du mot de départ du parcours
	 */
	public void BFSIteratif(int x) {
		System.out.print(this.mot[x]+" ");
		Queue<Integer> fifo = new LinkedList<Integer>();
		this.dejaVu[x] = true;
		
		Liste succ = this.listeSucc[x];
		// On récupère les indices de tous les successeurs du mot d'indice 'depart' :
		int[] ind_succ = succ.listeEntier();
		
		// Initialisation, on ajoute dans la file, on marque et on affecte le pere des fils
		// du sommet de départ.
		for (int i=0; i< succ.taille(); i++) {
			this.dejaVu[ind_succ[i]] = true;
			fifo.add(ind_succ[i]);
			this.pere[ind_succ[i]] = 0;
		}
		
		// Tant que la file n'a pas été vidée alors on execute l'algo
		while (!fifo.isEmpty()) {
			// On prend la valeur de tête
			int y = fifo.remove();
			
			System.out.print(this.mot[y]+" ");
			succ = this.listeSucc[y];
			// On récupère les indices de tous les successeurs de cette tête :
			ind_succ = succ.listeEntier();
			
			// Pour chaque successeur, s'il est pas marqué alors on le marque, on l'ajoute
			// dans la file et on affecte son pere.
			for (int i=0; i< succ.taille(); i++) {
				if (!this.dejaVu[ind_succ[i]]) {
					fifo.add(ind_succ[i]);
					this.pere[ind_succ[i]] = y;
					this.dejaVu[ind_succ[i]] = true;
				}
			}
	
		}
		
	}
	
	
	/**
	 * Permet de visiter l'intégralité du graphe.
	 * Un affichage vous renseignera sur le nombre de composantes connexes du graphe,
	 * ainsi que les sommets qui y sont affectés.
	 * @param mode le mode de parcours du graphe
	 * 
	 */
	public void visit(String mode) {
		// On initialise dejaVu afin de ne pas afficher plusieurs fois les mots
		for (int i=0; i< nb; i++)
			this.dejaVu[i] = false;
		// dans un premier temps, on visite l'arbre depuis l'indice 0
		int ind_non_vu = 0;
		int compteur_composantes_connexes = 1;
		
		// Tant que nous avons des sommets qu'il reste a parcourir :
		while (ind_non_vu != -1) {
			// on affiche la valeur du compteur
			System.out.print(compteur_composantes_connexes+" : ");
			
			// A chaque racine de composante connexe on affecte à père -1 (utile pour chemin)
			this.pere[ind_non_vu] = -1;
			
			// On effectue le parcours
			if (mode.equals("DFS"))
				this.DFS(ind_non_vu);
			else
				this.BFSIteratif(ind_non_vu);
			
			System.out.println();
			// On incrémente le compteur
			compteur_composantes_connexes++;
			// On affecte à ind_non_vu l'indice du prochain sommet non parcouru
			ind_non_vu = this.premierNonVu();
		}
	}
	
	/**
	 * Retourne l'indice du premier sommet non visité, cad le premier indice du
	 * tableau dejaVu qui est à false.
	 * @return l'indice du premier sommet non visité, si on ne trouve pas alors -1
	 */
	private int premierNonVu() {
		int i = 0;
		
		while (i < this.dejaVu.length && this.dejaVu[i] != false) {
			i++;
		}
		// Si on a parcouru tout le tableau alors on doit renvoyer -1 sinon en renvoie la valeur de i
		if (i == this.dejaVu.length)
			return -1;
		else
			return i;
	}
	
	/**
	 * Imprime le chemin entre deux mots.
	 * @param from le mot de départ
	 * @param to le mot de fin
	 * 
	 */
	public String chemin(String from, String to) {
		// On recupère les indices de départ et d'arrivée
		int indice_from = this.indice(from);
		int indice_to = this.indice(to);
		// chemin1 et chemin2 vont se constituer au fur et a mesure de l'execution, a la fin la chemin sera la concaténation des deux
		String chemin1 = "";
		String chemin2 = "";
		
		while (indice_to != -1 && indice_from != -1) {
			// Tant qu'on peut esperer trouver un resultat (indice_to et from != -1
			if (indice_to == indice_from) {
				// Si les deux indices sont identiques alors on a trouvé un chemin
				if (ToolsString.diffUneLettre(chemin2.trim().split(" ")[0],from)
						|| ToolsString.diffUneLettre(chemin1.trim().split(" ")[0],from))
					return from+" "+(chemin2+" "+chemin1).trim();
				else
					return (chemin2+" "+chemin1).trim();
			}
			// Si l'indice to et plus grand que l'indice from alors on accede au pere de "to"
			if (indice_to > indice_from) {
				if (indice_to != -1)
					chemin1 = this.mot[indice_to]+" "+chemin1;
				indice_to = this.pere[indice_to];
			}
			// Si l'indice from et plus grand que l'indice to alors on accede au pere de "from"
			else {
				if (indice_from != -1)
					chemin2 = chemin2+" "+this.mot[indice_from];
				indice_from = this.pere[indice_from];
			}
		}
		// Sinon pas de chemin possible
		return "pas de chemin";
			
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
	
	public int[] tabPere() {
		return this.pere;
	}
	
	/**
	 * Retourne l'indice du mot passé en paramètre
	 * @param m le mot
	 * @return l'indice
	 */
	public int indice(String m) {
		
	    for (int i=0 ; i<this.mot.length ; ++i)
	        if (m.equals (this.mot[i]))
	        	return i ;
	    
	    throw new Error (m + " n'est pas dans le tableau.");
	    
	 }
	
	public Liste[] getListe() {
		return this.listeSucc;
	}
	
	public boolean[] getDejaVu() {
		return this.dejaVu;
	}
	
}
