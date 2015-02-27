package graphe;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de manipuler des listes d'entiers (encapsule une ArrayList).
 * @author monbailly
 *
 */
public class Liste {

	private List<Integer> liste;
	
	/**
	 * Permet d'initialiser la liste.
	 */
	public Liste(){
		super();
		this.liste = new ArrayList<Integer>();
	}

}
