package graphe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestGraphe {
	
	private Graphe g;
	
	@Before
	public void setUp(){
		String[] dico3court = {
			       "bolt","aalt","ault","ailt","holt","holy","bilt","bill","toto" } ;
			
		g = new Graphe (dico3court) ;
	}

	@Test
	public void test_ajouterArete() {
		g.ajouterArete(0,1);
		assertEquals(1,g.getListe()[0].taille());
		assertEquals(1,g.getListe()[1].taille());
		
		assertEquals("[1]",g.getListe()[0].toString());
		assertEquals("[0]",g.getListe()[1].toString());

	}
	
	@Test
	public void test_lettreQuiSaute() {
		g.lettreQuiSaute();
		
		assertEquals(9,g.getListe().length);
		
		assertEquals(2,g.getListe()[0].taille());
		assertEquals(2,g.getListe()[1].taille());
		assertEquals(2,g.getListe()[2].taille());
		assertEquals(3,g.getListe()[3].taille());
		assertEquals(2,g.getListe()[4].taille());
		assertEquals(1,g.getListe()[5].taille());
		assertEquals(3,g.getListe()[6].taille());
		assertEquals(1,g.getListe()[7].taille());
		assertEquals(0,g.getListe()[8].taille());
		
	}
	
	@Test
	public void test_DFS() {
		g.lettreQuiSaute();
		g.DFS(0);
			
		assertEquals(0,g.tabPere()[0]);
		assertEquals(3,g.tabPere()[1]);
		assertEquals(1,g.tabPere()[2]);
		assertEquals(6,g.tabPere()[3]);
		assertEquals(0,g.tabPere()[4]);
		assertEquals(4,g.tabPere()[5]);
		assertEquals(0,g.tabPere()[6]);
		assertEquals(6,g.tabPere()[7]);
		assertEquals(0,g.tabPere()[8]);
		
	}
	
	@Test
	public void test_BFS() {
		g.lettreQuiSaute();
		g.BFSIteratif(0);
			
		assertEquals(0,g.tabPere()[0]);
		assertEquals(3,g.tabPere()[1]);
		assertEquals(3,g.tabPere()[2]);
		assertEquals(6,g.tabPere()[3]);
		assertEquals(0,g.tabPere()[4]);
		assertEquals(4,g.tabPere()[5]);
		assertEquals(0,g.tabPere()[6]);
		assertEquals(6,g.tabPere()[7]);
		assertEquals(0,g.tabPere()[8]);
	}
	
	@Test
	public void test_visit() {
		g.lettreQuiSaute();
		g.visit("DFS");
		
		assertEquals(-1,g.tabPere()[0]);
		assertEquals(3,g.tabPere()[1]);
		assertEquals(1,g.tabPere()[2]);
		assertEquals(6,g.tabPere()[3]);
		assertEquals(0,g.tabPere()[4]);
		assertEquals(4,g.tabPere()[5]);
		assertEquals(0,g.tabPere()[6]);
		assertEquals(6,g.tabPere()[7]);
		assertEquals(-1,g.tabPere()[8]);
		
		g.visit("BFS");
		
		assertEquals(-1,g.tabPere()[0]);
		assertEquals(3,g.tabPere()[1]);
		assertEquals(3,g.tabPere()[2]);
		assertEquals(6,g.tabPere()[3]);
		assertEquals(0,g.tabPere()[4]);
		assertEquals(4,g.tabPere()[5]);
		assertEquals(0,g.tabPere()[6]);
		assertEquals(6,g.tabPere()[7]);
		assertEquals(-1,g.tabPere()[8]);
	}
	
	@Test
	public void test_chemin() {
		g.lettreQuiSaute();
		g.visit("DFS");
		
		String chem = g.chemin("bolt", "holy");
		assertEquals("bolt holt holy",chem);
		
		String chem2 = g.chemin("bolt", "ault");
		assertEquals("bolt bilt ailt aalt ault",chem2);
		
		chem = g.chemin("toto", "holy");
		assertEquals("pas de chemin",chem);
		
		g.visit("BFS");
		
		chem = g.chemin("bolt", "holy");
		assertEquals("bolt holt holy",chem);
		
		chem2 = g.chemin("bolt", "ault");
		assertEquals("bolt bilt ailt ault",chem2);
		
		chem = g.chemin("toto", "holy");
		assertEquals("pas de chemin",chem);
		
	}
	
}
