import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

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
	public Token[] t;

	// Constructor Expects player one to logically be '0', so we increment it to
	// '1'
	public Player(int id) {
		// Initialize Player Details
		pid = id + 1;
		switch (id) {
		case 0:// player1
			p = new Point(20, 20);
			entry = new Point(345,45);
			color = Color.RED;// color = new Color(255, 185, 15);//Orange
			break;
		case 1:// player2
			p = new Point(440, 20);
			entry = new Point(  665, 365);
			color = Color.BLUE;// color = new Color(30, 144, 255);//dodger blue
			break;
		case 2:// player3
			p = new Point(20, 460);
			entry = new Point( 25, 365);
			color = Color.YELLOW;// color = new Color(205, 0, 205);//Magenta
			break;
		case 3:// player4
			p = new Point(440, 460);
			entry = new Point(345, 685);
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
		private Point pos;
		private Color c;
		private final int SAFE = 100;// Index for all Safe Tokens!

		// This constructor takes the players individual Corner Parameteres
		public Token(int i, int x, int y, Color col) {
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
		

		//Point Data for Traversals
		public final Point[] pointData = {
				new Point(15,315), 
				new Point(55,315), 
				new Point(95,315), 
				new Point(135,315), 
				new Point(175,315), 
				new Point(215,315), 
				new Point(255,315), 
				new Point(295,315), 
				new Point(295,275), 
				new Point(295,235), 
				new Point(295,195), 
				new Point(295,155), 
				new Point(295,115), 
				new Point(295,75), 
				new Point(295,35), 
				new Point(335,35), 
				new Point(375,35), 
				new Point(375,75), 
				new Point(375,115), 
				new Point(375,155), 
				new Point(375,195), 
				new Point(375,235), 
				new Point(375,275), 
				new Point(375,315), 
				new Point(415,315), 
				new Point(455,315), 
				new Point(495,315), 
				new Point(535,315), 
				new Point(575,315), 
				new Point(615,315), 
				new Point(655,315), 
				new Point(655,355), 
				new Point(655,395), 
				new Point(615,395), 
				new Point(575,395), 
				new Point(535,395), 
				new Point(495,395), 
				new Point(455,395), 
				new Point(415,395), 
				new Point(375,395), 
				new Point(375,435), 
				new Point(375,475), 
				new Point(375,515), 
				new Point(375,555), 
				new Point(375,595), 
				new Point(375,635), 
				new Point(375,675), 
				new Point(335,675), 
				new Point(295,675), 
				new Point(295,635), 
				new Point(295,595), 
				new Point(295,555), 
				new Point(295,515), 
				new Point(295,475), 
				new Point(295,435), 
				new Point(295,395), 
				new Point(255,395), 
				new Point(215,395), 
				new Point(175,395), 
				new Point(135,395), 
				new Point(95,395), 
				new Point(55,395), 
				new Point(15,395), 
				new Point(15,355), 
				new Point(15,315), 
				new Point(55,315), 
				new Point(95,315), 
				new Point(135,315), 
				new Point(175,315), 
				new Point(215,315), 
				new Point(255,315), 
				new Point(295,315), 
				new Point(295,275), 
				new Point(295,235), 
				new Point(295,195), 
				new Point(295,155), 
				new Point(295,115), 
				new Point(295,75), 
				new Point(295,35), 
				new Point(335,35), 
				new Point(375,35), 
				new Point(375,75), 
				new Point(375,115), 
				new Point(375,155), 
				new Point(375,195), 
				new Point(375,235), 
				new Point(375,275), 
				new Point(375,315), 
				new Point(415,315), 
				new Point(455,315), 
				new Point(495,315), 
				new Point(535,315), 
				new Point(575,315), 
				new Point(615,315), 
				new Point(655,315), 
				new Point(655,355), 
				new Point(655,395), 
				new Point(615,395), 
				new Point(575,395), 
				new Point(535,395), 
				new Point(495,395), 
				new Point(455,395), 
				new Point(415,395), 
				new Point(375,395), 
				new Point(375,435), 
				new Point(375,475), 
				new Point(375,515), 
				new Point(375,555), 
				new Point(375,595), 
				new Point(375,635), 
				new Point(375,675), 
				new Point(335,675), 
				new Point(295,675), 
				new Point(295,635), 
				new Point(295,595), 
				new Point(295,555), 
				new Point(295,515), 
				new Point(295,475), 
				new Point(295,435), 
				new Point(295,395), 
				new Point(255,395), 
				new Point(215,395), 
				new Point(175,395), 
				new Point(135,395), 
				new Point(95,395), 
				new Point(55,395), 
				new Point(15,395), 
				new Point(15,355), };

	}
}