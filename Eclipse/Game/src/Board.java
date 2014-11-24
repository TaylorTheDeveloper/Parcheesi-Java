import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Board extends JPanel {
	/*
	 * POINT DATA DECLARED AT BOTTOM OF FILE!!!
	 */
	private Color tile = new Color(0, 0, 0);
	private Color red = new Color(255, 0, 0);
	private Color blue = new Color(0, 0, 255);
	private Color green = new Color(0, 255, 0);
	private Color yellow = new Color(255, 255, 0);
	private Color safeBorder = new Color(0, 255, 0);
	private Color safeFill = new Color(0, 150, 150);
	private Color base = new Color(0, 179, 21);
	private static ArrayList<Point> points;
	private int SIZE = 40;
	//public Token t;
	public static Player[] p;

	public Board(int numPlayers) {
		//t = new Token();
		p = new Player[numPlayers];
		for(int i = 0; i< numPlayers;i++ ){
			p[i] = new Player(i);
		}
	}
	
	/*
	 * tv = turnValue
	 * Moves Player based on tv index.
	 */
	public static void movePlayer(int tv, int r){
		int tok = p[tv].chooseToken();
		int i  = p[tv].t[tok].getPositionIndex();
		p[tv].t[tok].setPositionIndex(i+r);
		int z = p[tv].t[tok].getPositionIndex();
		
		p[tv].t[tok].setX(points.get(z).x);
		p[tv].t[tok].setY(points.get(z).y);
		System.out.println("pt:" + points.get(z).x + " "+ points.get(z).y);
		
	}
	
	public void foo(){
		
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
	public int getPointLength() {
		return points.size();
	}
	
	public void printPoints(){
		for(int i =0; i < points.size();i++){
			System.out.println(points.get(i));
		}
	}

	/*
	 * Returns Block Size for Board
	 */
	public int getBlockSize() {
		return SIZE;
	}

	public void update(){
		repaint();
	}

	public void paintPlayerOverlay(Graphics g){
		for(int i = 0; i< p.length;i++ ){
			p[i].update(g);
		}		
	}

	public void paint(Graphics g) {
		super.paint(g);
		points = new ArrayList<Point>();
		int size = SIZE;
		int x = 15;// starting
		int y = 315;
		int w = size;
		int h = size;
		
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
		
		//printPoints();
	}
	//Point Data for Traversals
	private final static Point[] pointData = {
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
