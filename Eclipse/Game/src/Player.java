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
		switch(id){
		case 0:
			p = new Point(20,20);
			color = new Color(255, 185, 15);//Orange
			break;
		case 1:
			p = new Point(780,20);
			color = new Color(30, 144, 255);//dodgerblue
			break;
		case 2:
			p = new Point(20,780);
			color = new Color(205, 0, 205);//Magenta
			break;
		case 3:
			p = new Point(20,780);
			color = new Color(165, 42, 42);//Garnet
			break;
		default: 
			p = new Point(20,20);
			color = new Color(255, 185, 15);//This should never happen
		
		}
		a = new Token(5);
		b = new Token(10);
		c = new Token(20);
		d = new Token();
	}

	public void update(Graphics g) {
		//Update Player Info
		g.setColor(Color.BLACK);
		g.drawString("Player " + pid, p.x+8, p.y+15);
		g.setColor(color);
		g.drawRect(p.x, p.y, 150, 150);
		//Update Tokens
		a.draw(g);
		b.draw(g);
		c.draw(g);
		d.draw(g);
	}
}