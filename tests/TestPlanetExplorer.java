import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	PlanetExplorer pE = new PlanetExplorer(100,100,"");
	@Test
	public void test_executeCommand() {
		fail("Not yet implemented");
	}
	
	
	@Test public void PlanetExplorer_testCorrectInit() {
		
		
		assertEquals(""+pE.posX+pE.posY+pE.direction+pE.gridX+pE.gridY, "00N100100");
	}
	
	@Test public void executeCommand_testRotationLeft_ChangeDirectionFromNToE() {
		pE.executeCommand("");
	}
	

}
