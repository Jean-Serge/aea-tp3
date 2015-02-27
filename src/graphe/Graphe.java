package graphe;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un graphe dans cet exercice.
 * Composé d'un tableau de mot et d'un tableau de leurs successeurs respectifs.
 * 
 * @author monbailly
 *
 */
public class Graphe {

	private String[] mot;
	private List<String>[] listeSucc;
	private int nb;
	
	public Graphe(String[] lesMots) {
		super();
		this.mot = lesMots;
		this.nb = this.mot.length;
		this.listeSucc = new ArrayList[nb];
		
		for(List<String> l : this.listeSucc){
			l = new ArrayList<String>();
		}
	}
	
	

}
