import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Red, Blue, and Green are safeBorder zones

public class Rectangles extends JPanel {
	ArrayList<Point> points;

   public static void main(String[] a) {
      JFrame f = new JFrame();
      f.setSize(800, 800);
      f.add(new Rectangles());
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
      
   }

   public void paint(Graphics g) {
		  points = new ArrayList<Point>();
	  int size = 40;
	  int x = 15;//starting
	  int y = 290;
	  int w = size; 
	  int h = size;
	  Color tile = new Color(0,0,0);
	  Color red = new Color(255,0,0);
	  Color blue = new Color(0,0,255);
	  Color green = new Color(0,255,0);
	  Color yellow = new Color(255,255,0);
	  Color safeBorder = new Color(255,0,0);
	  Color safeFill = new Color (0,150,150);
	  Color base = new Color(0,179,21);
	  
    	  //Left, top
    	  for(int k = 0; k < 7; k++){
    		  g.setColor(tile);
              g.drawRect (x, y, w, h);
       	   	  points.add(new Point(x,y));
	    	  x+=size;
    	  }
    	  
    	  //Top, Left
    	  for(int k = 0; k < 8; k++){
    		  g.setColor(tile);
              g.drawRect (x, y, w, h);
       	   	  points.add(new Point(x,y));
	    	  y-=size;
    	  }
    	  
    	  x+=size;
    	  y+=size;
    	  //Top, Center
		  g.setColor(red);//SafeZone
          g.fillRect (x, y, w, h);
   	   	  points.add(new Point(x,y));
    	  x+=size;
    	  
    	  //Top, right
    	  for(int k = 0; k < 8; k++){
    		  g.setColor(tile);
              g.drawRect (x, y, w, h);
       	   	  points.add(new Point(x,y));
	    	  y+=size;
    	  }
    	  y-=size;
    	  x+=size; 
    	  
    	  //Right, top
    	  for(int k = 0; k < 7; k++){
    		  g.setColor(tile);
              g.drawRect (x, y, w, h);
       	   	  points.add(new Point(x,y));
	    	  x+=size;
    	  }
    	  
    	  //Right, Center
    	  y+=size;
    	  x-=size;
		  g.setColor(blue);//SafeZone
          g.fillRect (x, y, w, h);
   	   	  points.add(new Point(x,y));
    	  y+=size;
    	  
    	  //Right, bottom
    	  for(int k = 0; k < 7; k++){
    		  g.setColor(tile);
              g.drawRect (x, y, w, h);
       	   	  points.add(new Point(x,y));
	    	  x-=size;
    	  }
    	  
    	  //bottom, right
    	  for(int k = 0; k < 8; k++){
    		  g.setColor(tile);
              g.drawRect (x, y, w, h);
       	   	  points.add(new Point(x,y));
	    	  y+=size;
    	  }
    	  x-=size;
    	  y-=size;
    	  
    	  //bottom, Center
		  g.setColor(green);//SafeZone
          g.fillRect (x, y, w, h);
   	   	  points.add(new Point(x,y));
    	  x-=size;
    	  
    	  //bottom, left
    	  for(int k = 0; k < 8; k++){
    		  g.setColor(tile);
              g.drawRect (x, y, w, h);
       	   	  points.add(new Point(x,y));
	    	  y-=size;
    	  }
    	  y+=size;
    	  x-=size;
    	  
    	  //Left, bottom
    	  for(int k = 0; k < 7; k++){
    		  g.setColor(tile);
              g.drawRect (x, y, w, h);
       	   	  points.add(new Point(x,y));
	    	  x-=size;
    	  }
    	  
    	//left, Center
    	  y-=size;
    	  x+=size;
		  g.setColor(yellow);//SafeZone
          g.fillRect (x, y, w, h);
   	   	  points.add(new Point(x,y));
          x+=size;
    	  
          //safeBorder Horizontal
    	  for(int k = 0; k < 7; k++){
    		  g.setColor(safeFill);
              g.fillRect (x+1, y+1, w-2, h-2);
    		  g.setColor(safeBorder);//SafeZone
              g.drawRect (x, y, w, h);
	    	  x+=size;
    	  }
		  g.setColor(base);//SafeZone
          g.fillRect (x, y, w, h);
		  g.setColor(safeBorder);//SafeZone
          g.drawRect (x, y, w, h);
          x+=size;
    	  for(int k = 0; k < 7; k++){
    		  g.setColor(safeFill);
              g.fillRect (x+1, y+1, w-2, h-2);
    		  g.setColor(safeBorder);//SafeZone
              g.drawRect (x, y, w, h);
	    	  x+=size;
    	  }
    	  x-=size*8;
    	  y-=size*7;
         
    	  //safeBorder Vertical
    	  for(int k = 0; k < 7; k++){
    		  g.setColor(safeFill);
              g.fillRect (x+1, y+1, w-2, h-2);
    		  g.setColor(safeBorder);//SafeZone
              g.drawRect (x, y, w, h);
	    	  y+=size;
    	  }
    	  y+=size;//skip one
    	  for(int k = 0; k < 7; k++){
    		  g.setColor(safeFill);
              g.fillRect (x+1, y+1, w-2, h-2);
    		  g.setColor(safeBorder);//SafeZone
              g.drawRect (x, y, w, h);
	    	  y+=size;
    	  }

          System.out.println(points.size());
      }
   }
