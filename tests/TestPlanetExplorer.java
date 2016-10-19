import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void test_executeCommand() {
		fail("Not yet implemented");
	}
	
	
	@Test public void PlanetExplorer_testCorrectInit() {
		PlanetExplorer pE = new PlanetExplorer(100,100,"");
		
		assertEquals(""+pE.posX+pE.posY+pE.direction, "00N");
	}
	
	@Test public void 
}
