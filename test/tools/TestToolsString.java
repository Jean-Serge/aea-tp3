package tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestToolsString {

	@Test
	public void testDiffUneLettre() {
		assertTrue(ToolsString.diffUneLettre("toto", "tito"));
		assertFalse(ToolsString.diffUneLettre("tota", "tota"));
		assertFalse(ToolsString.diffUneLettre("toto", "tata"));
	}
}
