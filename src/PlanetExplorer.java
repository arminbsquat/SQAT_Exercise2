
// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:

public class PlanetExplorer {
	

	
	
	int posX;
	int posY;
	char direction; // N, S, E, W
	int gridX;
	int gridY;
	Obstacle[] obs;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 *
	 */
		this.initObs(obstacles);
		
		obs = new Obstacle[10];
		this.posY = 0;
		this.posX = 0;
		this.direction = 'N';
		this.gridX = x;
		this.gridY = y;
	}
	
	private void initObs(String obstacles) {
		char[] charObs = obstacles.toCharArray();
		for(char character : charObs) {
			
		}
		
	}

	public String executeCommand(String command){
		/*					 y
		 *		   S --
		 *      0xxxxxxxx
		 *      xxxxxxxxx
		 * -- W xxxxxxxxx E ++
		 *      xxxxxxxxx
		 *      xxxxxxxxx
		 *		   N ++
		 *  x
		 *  
		 *  l = uhrzeigersinn
		 *  r = gegenuhrzeigersinn
		 */
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		char[] charCommand = command.toCharArray();
		
		for(char character : charCommand) {
			switch(character) {
			
			case 'l': 
				this.nextDirectionLeft();
				break;
			case 'r': 
				this.nextDirectionRight();
				break;
			case 'f': 
				this.nextPositionForward();
				break;
			case 'b': 
				this.nextPositionBackward();
				break;
				
			default: break;
			}
		}
		
		
		
		
		return null;
	}
	
	private void nextDirectionLeft() {
		switch(this.direction) {
		case 'N': 
			this.direction = 'W';
			break;
		case 'W': 
			this.direction = 'S';
			break;
		case 'S': 
			this.direction = 'E';
			break;
		case 'E': 
			this.direction = 'N';
			break;
		default: break;
		}
	}
	
	private void nextDirectionRight() {
		switch(this.direction) {
		case 'N': 
			this.direction = 'E';
			break;
		case 'W': 
			this.direction = 'N';
			break;
		case 'S': 
			this.direction = 'W';
			break;
		case 'E': 
			this.direction = 'S';
			break;
		default: break;
		}
	}
	
	private void nextPositionForward() {
		switch(this.direction) {
		case 'N': 
			this.posX++;
			if(this.posX > this.gridX) {
				this.posX = 0; 
			}
			break;
		case 'W':
			this.posY--;
			if(this.posY < 0) {
				this.posY = this.gridY; 
			}
			break;
		case 'S':
			this.posX--;
			if(this.posX < 0) {
				this.posX = this.gridX; 
			}
			break;
		case 'E':
			this.posY++;
			if(this.posY > this.gridY) {
				this.posY = 0; 
			}
			break;
		default: break;	
		}
	}
	
	private void nextPositionBackward() {
		switch(this.direction) {
		case 'N': 
			this.posX--;
			break;
		case 'W':
			this.posY++;
			break;
		case 'S':
			this.posX++;
			break;
		case 'E':
			this.posY--;
			break;
		default: break;	
		}
	}
}



