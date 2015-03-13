package graphe;

/**
 * Classe permettant de manipuler des listes d'entiers.
 * @author monbailly
 *
 */
public class Liste {

	public final int BASE_LENGTH = 5;
	private int[] liste;
	private int nb;
	
	
	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================
	
	/**
	 * Permet d'initialiser la liste (en fonction de la constante BASE_LENGTH).
	 */
	public Liste(){
		super();
		this.liste = new int[this.BASE_LENGTH];
		this.nb = 0;
	}
	
	// 	========================================================================================= 
	//	Fonctions utiles
	// 	=========================================
	
	/**
	 * Permet d'ajouter la valeur indiquée à la liste courante.
	 * Si le tableau est plein, sa capacité est doublée.
	 * (on suppose la valeur de val correcte)
	 * 
	 * @param val la valeur à ajouter au tableau
	 * 
	 */
	public void ajouter(Integer val){
		if(nb == liste.length){
			int[] tmp = new int[this.liste.length * 2];
			for(int i = 0 ; i < this.liste.length ; i++){
				tmp[i] = this.liste[i];
			}
			this.liste = tmp;
		}
			
		this.liste[nb++] = val;
	}

	// 	========================================================================================= 
	//	Accesseurs
	// 	=========================================
	
	/**
	 * Affiche le contenu du tableau.
	 * 
	 * @return un affichage en console du tableau
	 */
	public String toString(){
		// Si la liste est vide
		if(this.nb == 0){
			return "[]";
		}
		String retour = "[" + this.liste[0];
		for(int i = 1 ; i < this.nb ; i++){
			retour += ", " + this.liste[i];
		}
		retour += "]";
		
		return retour;
	}

	/**
	 * Retourne la taille totale allouée pour le tableau
	 * @return la taille allouée pour le tableau
	 */
	public int tailleAllouee() {
		return liste.length;
	}

	/**
	 * Retourne le nombre d'éléments dans le tableau
	 * @return le nombre d'éléments dans le tableau
	 */
	public int taille() {
		return nb;
	}
	
	/**
	 * Retourne la liste d'entier correspondante à Liste.
	 * @return la liste
	 */
	public int[] listeEntier() {
		return this.liste;
	}
}
