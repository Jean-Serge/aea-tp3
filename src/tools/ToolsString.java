package tools;

/**
 * Cette classe offre des fonctions statiques de manipulation de
 * chaîne de caractère.
 * 
 * @author Jean-Serge Monbailly
 * @author Thibaud Verbaere
 *
 */
public class ToolsString {

	/**
	 * Retourne true si a et b sont idéntiques à une lettre près.
	 * (on suppose que a et b ont la même longueur)
	 * 
	 * @param a le 1er mot 
	 * @param b le 2nd mot
	 * @return true si a et b n'ont qu'une lettre de différence
	 */
	public static boolean diffUneLettre (String a, String b) {
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
	
}
