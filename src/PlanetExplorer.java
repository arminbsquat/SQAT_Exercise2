import java.util.ArrayList;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:

public class PlanetExplorer {
	

	
	int oldPosX;
	int oldPosY;
	int posX;
	int posY;
	char direction; // N, S, E, W
	int gridX;
	int gridY;
	ArrayList<Obstacle> obs = new ArrayList<Obstacle>();
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use: For a 100x100 grid with two obstacles at coordinates (5,5) and (7,8)
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  
		 
	 *
	 */
		this.initObs(obstacles);
		
		this.posY = 0;
		this.posX = 0;
		this.direction = 'N';
		this.gridX = x;
		this.gridY = y;
	}
	
	private void initObs(String obstacles) {
		char[] charObs = obstacles.toCharArray();
		boolean start = false;
		StringBuffer singleNumber = new StringBuffer();
		int x = 0; 
		int y = 0;
		for(char character : charObs) {
			
			if(start) {
				singleNumber.append(character);
			}
			
			if(character == '(') {
				start = true;
			}
			
			if(character == ',') {
				String a = singleNumber.toString().substring(0, singleNumber.length()-1);
				singleNumber = new StringBuffer(); // empty singleNumber
				x = Integer.parseInt(a);
			}
			
			if(character == ')') {
				start = false;
				String b = singleNumber.toString().substring(0, singleNumber.length()-1);
				y = Integer.parseInt(b);
				Obstacle ob = new Obstacle(x,y);
				this.obs.add(ob) ;
			}

			


			
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
			this.oldPosX = this.posX;
			this.posX++;
			if(this.posX > this.gridX) {
				this.posX = 0; 
			}
			this.obstacleDetection();
			break;
		case 'W':
			this.oldPosY = this.posY;
			this.posY--;
			if(this.posY < 0) {
				this.posY = this.gridY; 
			}
			this.obstacleDetection();
			break;
		case 'S':
			this.oldPosX = this.posX;
			this.posX--;
			if(this.posX < 0) {
				this.posX = this.gridX; 
			}
			this.obstacleDetection();
			break;
		case 'E':
			this.oldPosY = this.posY;
			this.posY++;
			if(this.posY > this.gridY) {
				this.posY = 0; 
			}
			this.obstacleDetection();
			break;
		default: break;	
		}
	}
	
	private void obstacleDetection() {
		
		for(Obstacle ob : this.obs) {
			if(ob.x == this.posX && ob.y == this.posY) { // rover is on obstacle
				this.posX = this.oldPosX;
				this.posY = this.oldPosY;
			}
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



