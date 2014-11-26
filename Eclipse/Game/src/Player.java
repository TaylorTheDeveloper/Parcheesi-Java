import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
 * POINT DATA DECLARED AT BOTTOM OF FILE!!! In Token Class
 */
@SuppressWarnings("serial")
class Player extends JPanel {

	private final int NUM_TOKENS = 4;
	private int pid;// Player id
	private Point p;// Player info,Starting point for pieces for each player
	private Point entry;//Entry Point for each players token
	private Color color;
	private int offset;
	public Token[] t;
	//Point Data for Special Traversals
	public final ArrayList<Point> specialPointData;
	

	// Constructor Expects player one to logically be '0', so we increment it to
	// '1'
	public Player(int id) {
		specialPointData = new ArrayList<Point>();
		// Initialize Player Details
		pid = id + 1;
		switch (id) {
		case 0:// player1
			p = new Point(20, 20);
			entry = new Point(345,45);
			offset = 15;//Perfect
			color = Color.RED;// color = new Color(255, 185, 15);//Orange
			//Special Point Data for Traversals
			specialPointData.add(new Point(335, 35));
			specialPointData.add(new Point(335, 75));
			specialPointData.add(new Point(335, 115));
			
			specialPointData.add(new Point(335, 155));
			specialPointData.add(new Point(335, 195));
			specialPointData.add(new Point(335, 235));
			
			specialPointData.add(new Point(335, 275));
			specialPointData.add(new Point(335, 315));
			specialPointData.add(new Point(335, 355));
			
			break;
		case 1:// player2
			p = new Point(440, 20);
			entry = new Point(  665, 365);
			offset = 31;
			color = Color.BLUE;// color = new Color(30, 144, 255);//dodger blue
			break;
		case 2:// player3
			p = new Point(20, 460);
			entry = new Point( 25, 365);
			offset = -1;
			color = Color.YELLOW;// color = new Color(205, 0, 205);//Magenta
			break;
		case 3:// player4
			p = new Point(440, 460);
			entry = new Point(345, 685);
			offset = 47;
			color = Color.GREEN;// color = new Color(165, 42, 42);//Garnet
			break;
		default: // This should never happen
			p = new Point(20, 20);
			color = Color.RED;// color = new Color(255, 185, 15);
		}

		t = new Token[NUM_TOKENS];
		for (int i = 0; i < NUM_TOKENS; i++) {
			t[i] = new Token(i, p.x, p.y, getColor());
		}
	}
	
	public int getOffset(){
		return offset;
	}
	/*
	 * Choose Player's Token to move with Error Bounds Checking
	 */
	public int chooseToken() {
		int tok = -1;
		while (tok > 3 || tok < 0) {
			String[] options = { "0","1", "2", "3" };
			String x = (String) JOptionPane.showInputDialog(null,
					"Which Token Would You Like To Move? (WTWYLTM?)", "Parcheesi",
					JOptionPane.QUESTION_MESSAGE, null, options, autoSelectFreeToken());

			tok = Integer.parseInt(x);
		}
		return tok;	
	}
	/*
	 * Select Token To Move, returns an integer representing a valid usable token. -1 otherwise
	 */
	public int autoSelectFreeToken(){
		int tok = -1;
		for(int k = 0; k < NUM_TOKENS;k++){
			if(!t[k].isSafe()){
				//Grab the first not safe token!
				tok = k;
			}			
		}		
		return tok;		
		
	}

	public void setPoint(int x, int y) {
		p = new Point(x, y);
	}

	public void update(Graphics g) {
		// Update Player Info
		g.setColor(color);
		g.fillRect(p.x, p.y, 150, 150);
		g.setColor(Color.BLACK);
		g.drawRect(p.x, p.y, 150, 150);
		g.drawString("Player " + pid, p.x + 8, p.y + 15);
		// Update Tokens
		for (int i = 0; i < NUM_TOKENS; i++) {
			t[i].draw(g);
		}
	}
	
	public boolean hasWon(){
		if(t[0].isSafe()&&t[1].isSafe()&&t[2].isSafe()&&t[3].isSafe()){
			System.out.println("A Player Has Won");
			return true;
		}
		else{
			return false;
		}
	}

	public Color getColor() {
		return color;
	}

	class Token {
		// Index Represents where a peice is on the board
		private int tokenSize;
		private int id;
		private int index;
		private boolean lastEight;
		private Point pos;
		private Color c;
		private final int SAFE = 100;// Index for all Safe Tokens!

		// This constructor takes the players individual Corner Parameteres
		public Token(int i, int x, int y, Color col) {
			lastEight = false;
			tokenSize = 20;
			id = i;
			index = 0;
			pos = new Point(x, y);
			c = col;
		}

		// Draws a token, anywhere on the board we want to
		public void drawToken(Graphics g, int x, int y) {
			g.setColor(c);
			g.fillRect(x, y, tokenSize, tokenSize);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, tokenSize, tokenSize);
			g.drawString(Integer.toString(id), x + 7, y + 15);
		}

		public void draw(Graphics g) {
			// If not on board, draw within it's corresponding box

			if (index == 0) {
				switch (id) {
				case 0:
					drawToken(g, p.x + 30, p.y + 30);
					break;
				case 1:
					drawToken(g, p.x + 60, p.y + 30);
					break;
				case 2:
					drawToken(g, p.x + 30, p.y + 60);
					break;
				case 3:
					drawToken(g, p.x + 60, p.y + 60);
					break;
				default:
				}
			} else {// Else Draw on Board
				drawToken(g, getX(), getY());
			}

		}
		
		/*
		 * If the player has traversed the entire board, then we want to go down the players safe zone for a win!
		 * Returns -1 if false
		 * Returns any other positive value to represent how many spaces the user can traverse following the turn
		 */
		public int checkTraversal(){
			if(getPositionIndex() >= 63){
				lastEight = true;
				return getPositionIndex()%63;
			}
			else{
				return -1;
			}			
		}
		
		public boolean getSafeZone(){
			return lastEight;			
		}
		public void setSafeZone(boolean b){
			lastEight = b;			
		}
		
		public boolean isSafe(){
			if(index == SAFE){
				return true;
			}
			else{
				return false;
			}
		}

		public int getID() {
			return id;
		}

		public void setID(int i) {
			id = i;
		}

		public int getPositionIndex() {
			return index;
		}

		public void setPositionIndex(int x) {
			System.out.println("Set index plus " + x);
			index = x;
		}

		public void setX(int xPos) {
			pos.x = xPos;
		}

		public int getX() {
			return pos.x;
		}

		public void setY(int yPos) {
			pos.y = yPos;
		}

		public int getY() {
			return pos.y;
		}

		public int getWidth() {
			return tokenSize;
		}

		public int getHeight() {
			return tokenSize;
		}
		



	}
}