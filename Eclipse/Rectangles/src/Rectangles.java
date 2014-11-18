import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Red, Blue, and Green are safeBorder zones

public class Rectangles extends JPanel {
	private ArrayList<Point> points;
	private int SIZE = 40;
	public Token t;
	public Player p;

	public Rectangles() {
		t = new Token();
		p = new Player(0);
	}

	/*
	 * Returns List of Points, for the Game Logic Array.
	 */
	public ArrayList<Point> getPoints() {
		ArrayList<Point> pts = new ArrayList<Point>();
		pts = points;
		return pts;
	}

	/*
	 * Returns Point List Length
	 */
	public int getLength() {
		return points.size();
	}

	/*
	 * Returns Block Size for Board
	 */
	public int getBlockSize() {
		return SIZE;
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void paint(Graphics g) {
		points = new ArrayList<Point>();
		int size = SIZE;
		int x = 15;// starting
		int y = 315;
		int w = size;
		int h = size;
		Color tile = new Color(0, 0, 0);
		Color red = new Color(255, 0, 0);
		Color blue = new Color(0, 0, 255);
		Color green = new Color(0, 255, 0);
		Color yellow = new Color(255, 255, 0);
		Color safeBorder = new Color(255, 0, 0);
		Color safeFill = new Color(0, 150, 150);
		Color base = new Color(0, 179, 21);
		//
		// t.draw(g);
		p.update(g);
		//
		// Left, top
		for (int k = 0; k < 7; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			x += size;
		}

		// Top, Left
		for (int k = 0; k < 8; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			y -= size;
		}

		x += size;
		y += size;
		// Top, Center
		g.setColor(red);// SafeZone
		g.fillRect(x, y, w, h);
		points.add(new Point(x, y));
		x += size;

		// Top, right
		for (int k = 0; k < 8; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			y += size;
		}
		y -= size;
		x += size;

		// Right, top
		for (int k = 0; k < 7; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			x += size;
		}

		// Right, Center
		y += size;
		x -= size;
		g.setColor(blue);// SafeZone
		g.fillRect(x, y, w, h);
		points.add(new Point(x, y));
		y += size;

		// Right, bottom
		for (int k = 0; k < 7; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			x -= size;
		}

		// bottom, right
		for (int k = 0; k < 8; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			y += size;
		}
		x -= size;
		y -= size;

		// bottom, Center
		g.setColor(green);// SafeZone
		g.fillRect(x, y, w, h);
		points.add(new Point(x, y));
		x -= size;

		// bottom, left
		for (int k = 0; k < 8; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			y -= size;
		}
		y += size;
		x -= size;

		// Left, bottom
		for (int k = 0; k < 7; k++) {
			g.setColor(tile);
			g.drawRect(x, y, w, h);
			points.add(new Point(x, y));
			x -= size;
		}

		// left, Center
		y -= size;
		x += size;
		g.setColor(yellow);// SafeZone
		g.fillRect(x, y, w, h);
		points.add(new Point(x, y));
		x += size;

		// safeBorder Horizontal
		for (int k = 0; k < 7; k++) {
			g.setColor(safeFill);
			g.fillRect(x + 1, y + 1, w - 2, h - 2);
			g.setColor(safeBorder);// SafeZone
			g.drawRect(x, y, w, h);
			x += size;
		}
		g.setColor(base);// SafeZone
		g.fillRect(x, y, w, h);
		g.setColor(safeBorder);// SafeZone
		g.drawRect(x, y, w, h);
		x += size;
		for (int k = 0; k < 7; k++) {
			g.setColor(safeFill);
			g.fillRect(x + 1, y + 1, w - 2, h - 2);
			g.setColor(safeBorder);// SafeZone
			g.drawRect(x, y, w, h);
			x += size;
		}
		x -= size * 8;
		y -= size * 7;

		// safeBorder Vertical
		for (int k = 0; k < 7; k++) {
			g.setColor(safeFill);
			g.fillRect(x + 1, y + 1, w - 2, h - 2);
			g.setColor(safeBorder);// SafeZone
			g.drawRect(x, y, w, h);
			y += size;
		}
		y += size;// skip one
		for (int k = 0; k < 7; k++) {
			g.setColor(safeFill);
			g.fillRect(x + 1, y + 1, w - 2, h - 2);
			g.setColor(safeBorder);// SafeZone
			g.drawRect(x, y, w, h);
			y += size;
		}

		// System.out.println(points.size());
	}
}

class Token extends JPanel {
	int id;
	int position;

	public Token() {
		id = 1;
		position = 0;
	}

	public Token(int p) {
		id = 1;
		position = p;
	}

	public void draw(Graphics g) {
		// super.paint(g);
		if (position == 0) {
			g.drawRect(20, 20, 20, 20);
		} else {
			g.fillRect(50, 50, 20, 20);
		}

	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int x) {
		position = x;
	}
}

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
