import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;


class Player extends JPanel {
	final int NUM_TOKENS = 4;
	int pid;//Player id
	Point p;//Player info
	Point start;//Starting point for pieces
	Color color;
	Token a, b, c, d;

	public Player(int id) {
		pid = id+1;
		switch(id){
		case 0://player1
			p = new Point(20,20);
			//color = new Color(255, 185, 15);//Orange
			color = Color.RED;
			break;
		case 1://player2
			p = new Point(440,20);
			//color = new Color(30, 144, 255);//dodgerblue
			color = Color.BLUE;
			break;
		case 2://player3
			p = new Point(20,460);
			//color = new Color(205, 0, 205);//Magenta
			color = Color.YELLOW;
			break;
		case 3://player4
			p = new Point(440,460);
			//color = new Color(165, 42, 42);//Garnet
			color = Color.GREEN;
			break;
		default: 
			p = new Point(20,20);
			color = new Color(255, 185, 15);//This should never happen
			color = Color.RED;		
		}
		
		a = new Token(0,p.x,p.y,getColor());
		b = new Token(1,p.x,p.y,getColor());
		c = new Token(2,p.x,p.y,getColor());
		d = new Token(3,p.x,p.y,getColor());
	}
	
	public void setPoint(int x, int y){
		p = new Point(x,y);		
	}

	public void update(Graphics g) {
		//Update Player Info
		g.setColor(color);
		g.fillRect(p.x, p.y, 150, 150);
		g.setColor(Color.BLACK);
		g.drawRect(p.x, p.y, 150, 150);
		g.drawString("Player " + pid, p.x+8, p.y+15);
		//Update Tokens
		a.draw(g);
		b.draw(g);
		c.draw(g);
		d.draw(g);
	}
	
	public Color getColor(){
		return color;
	}
	


class Token extends JPanel {
	//Idex Represents where a peice is on the board
	int tokenSize;
	int id;
	int index;
	Point pos;
	Color c;

	//This constructor takes the players individual Corner Parameteres
	public Token(int i,int x, int y, Color col) {
		tokenSize = 20;
		id = i;
		index = 0;
		pos = new Point(x,y);
		c = col;
	}
	
	public int getID(){
		return id;
	}	

	public int getPosition() {
		return index;
	}

	public void setPosition(int x) {
		index = x;
	}
	
	//Draws a token, anywhere on the board we want to
	public void drawToken(Graphics g,int id,int x, int y){
		g.setColor(c);
		g.fillRect(x, y, tokenSize, tokenSize);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, tokenSize, tokenSize);
		g.drawString(Integer.toString(id), x+7, y+15);
	}

	public void draw(Graphics g) {
		// super.paint(g);
		
		//If not on board, draw within it's corresponding box
		if (index == 0) {
			switch(id){
			case 0:
				//g.drawRect(p.x+30, p.y+30, 20, 20);
				drawToken(g,id,p.x+30, p.y+30);
				break;
			case 1:
				//g.drawRect(p.x+60, p.y+30, 20, 20);
				drawToken(g,id,p.x+60, p.y+30);
				break;
			case 2:
				//g.drawRect(p.x+30, p.y+60, 20, 20);
				drawToken(g,id,p.x+30, p.y+60);
				break;
			case 3:
				//g.drawRect(p.x+60, p.y+60, 20, 20);
				drawToken(g,id,p.x+60, p.y+60);
				break;
			default:
			}
		} else {
			g.fillRect(50, 50, 20, 20);
		}

	}

}
}