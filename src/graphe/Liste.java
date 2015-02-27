package graphe;

/**
 * Classe permettant de manipuler des listes d'entiers (encapsule une ArrayList).
 * @author monbailly
 *
 */
public class Liste {

	private final int BASE_LENGTH = 5;
	private int[] liste;
	private int nb;
	
	/**
	 * Permet d'initialiser la liste.
	 */
	public Liste(){
		super();
		this.liste = new int[this.BASE_LENGTH];
		this.nb = 0;
	}
	

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

	/**
	 * Affiche le contenu du tableau.
	 * 
	 * @return un affichage en console du tableau
	 */
	public String toString(){
		String retour = "[" + this.liste[0];
		
		for(int i = 1 ; i < this.nb ; i++){
			retour += ", " + this.liste[i];
		}
		
		retour += "]";
		return retour;
	}
}
