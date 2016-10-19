import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanetExplorer {
	PlanetExplorer pE = new PlanetExplorer(100,100,"");
	
	
	@Test public void PlanetExplorer_testCorrectInit() {	
		assertEquals(""+pE.posX+pE.posY+pE.direction+pE.gridX+pE.gridY, "00N100100");
	}
	
	@Test public void executeCommand_testRotationLeft_ChangeDirectionFromNToW() {
		pE.executeCommand("l");
		assertEquals('W', pE.direction);
	}
	
	@Test public void executeCommand_testRotationRight_ChangeDirectionFromNToE() {
		pE.executeCommand("r");
		assertEquals('E', pE.direction);
	}
	
	@Test public void executeCommand_testMovingForward_ChangePosXFrom0To1() {
		pE.executeCommand("f");
		assertEquals(1, pE.posX);
	}
	
	@Test public void executeCommand_testMovingBackwards_ChangePosXFrom2To1() {
		pE.executeCommand("f");
		pE.executeCommand("f");
		pE.executeCommand("b");
		assertEquals(1, pE.posX);
	}
	
	@Test public void executeCommand_testMovingTo2_2() {
		pE.executeCommand("f");
		pE.executeCommand("f");
		pE.executeCommand("r");
		pE.executeCommand("f");
		pE.executeCommand("f");
		
		assertEquals("22", ""+pE.posX+pE.posY);
		
	}
	
	@Test public void executeCommand_testMovingTo3_5() {
		pE.executeCommand("f");
		pE.executeCommand("f");
		pE.executeCommand("f");
		pE.executeCommand("r");
		pE.executeCommand("f");
		pE.executeCommand("f");
		pE.executeCommand("f");
		pE.executeCommand("f");
		pE.executeCommand("f");
		
		assertEquals("35", ""+pE.posX+pE.posY);	
	}
	
	@Test public void executeCommand_testMovingOutOfBounds_MovingFrom00To0100() {
		pE.executeCommand("l");
		pE.executeCommand("f");
		
		assertEquals("0100", ""+pE.posX+pE.posY);	
	}
	
	@Test public void executeCommand_testMovingOutOfBounds_MovingFrom1000To00() {
		for(int i = 0; i < 100; i++) {
			pE.executeCommand("f");
		}
		
		
		assertEquals("1000", ""+pE.posX+pE.posY);	
	}

}
