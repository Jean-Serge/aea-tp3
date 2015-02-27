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

	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================
	
	public Graphe(String[] lesMots) {
		super();
		this.mot = lesMots;
		this.nb = this.mot.length;
		this.listeSucc = new Liste[nb];

		for (int i=0; i< nb; i++)
			this.listeSucc[i] = new Liste();
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
	
	public void lettreQuiSaute() {
		// On fait toutes les combinaisons de mots possibles :
		for (int i=0; i < nb; i++) {

			for (int j=i+1; j < nb; j++) {

				// Si les deux mots différent d'une lettre et sont de même longueur on ajoute une arete
				if (this.mot[i].length() == this.mot[j].length() 
						&& ToolsString.diffUneLettre(this.mot[i],this.mot[j])) {
					this.ajouterArete(i,j);
				}
				
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

}
