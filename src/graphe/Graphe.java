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

		for (Liste liste : this.listeSucc)
			liste = new Liste();
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
		
	}
}
