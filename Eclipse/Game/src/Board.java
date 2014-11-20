import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JPanel;



public class Board extends JPanel {
	private ArrayList<Point> points;
	private int SIZE = 40;
	public Token t;
	public Player[] p;

	public Board(int numPlayers) {
		//t = new Token();
		p = new Player[numPlayers];
		for(int i = 0; i< numPlayers;i++ ){
			p[i] = new Player(i);
		}
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
	
	public void paintPlayerOverlay(Graphics g){
		for(int i = 0; i< p.length;i++ ){
			p[i].update(g);
		}		
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
		Color safeBorder = new Color(0, 255, 0);
		Color safeFill = new Color(0, 150, 150);
		Color base = new Color(0, 179, 21);
		//
		// t.draw(g);
		//
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
		g.setColor(tile);// SafeZone
		g.drawRect(x, y, w, h);
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
		g.setColor(tile);// SafeZone
		g.drawRect(x, y, w, h);
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
		g.setColor(tile);// SafeZone
		g.drawRect(x, y, w, h);
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
		g.setColor(tile);// SafeZone
		g.drawRect(x, y, w, h);
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

		paintPlayerOverlay(g);
	}
}
