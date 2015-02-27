package graphe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListe {

	private Liste l;
	
	@Before
	public void setUp(){
		this.l = new Liste();
	}
	
	// 	========================================================================================= 
	//	Test constructeurs
	// 	=========================================
	
	/**
	 * Vérifie que l'initialisation d'une liste se passe bien.
	 */
	@Test
	public void testCreationListe(){
		assertEquals(5, l.tailleAllouee());
		assertEquals(0, l.taille());
		
	}
	
	
	// 	========================================================================================= 
	//	Test ajout dans la liste
	// 	=========================================
	
	
	/**
	 * Test de simples ajouts dans la liste.
	 */
	@Test
	public void testAjout(){
		l.ajouter(4);
		assertEquals(1, l.taille());
		l.ajouter(5);
		assertEquals(2, l.taille());
	}
	
	/**
	 * Vérifie que la réallocation fonctionne bien quand le tableau est plein.
	 */
	@Test
	public void testReallocation(){
		for(int i = 0 ; i < 10 ; i++){
			l.ajouter(i);
		}
		assertEquals(10, l.tailleAllouee());
		l.ajouter(42);
		assertEquals(20, l.tailleAllouee());
	}
}
