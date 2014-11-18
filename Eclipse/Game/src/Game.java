import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Game {
	private static JFrame gameFrame;
	 public static void main(String[] args) {
		 gameFrame = new Parchessi();
		  }
	 
	 public static void reset(){
		 gameFrame.setVisible(false); //you can't see me!
		 gameFrame.dispose();
		 gameFrame = new Parchessi();
	 }
}

class Parchessi extends JFrame{
	Board b;
	Menu m,n;
	public static int roll;
	static JLabel rollView;
	
	public Parchessi(){
		b = new Board();
		m = new Menu();
		rollView = new JLabel("    Roll: ");//Always Player 1's turn
		rollView.setBorder(new EmptyBorder(5, 5, 5, 5) );
		add(b, "Center");
	    add(m, "South");
	    add(rollView,"North");
	    getContentPane().setBackground(new Color(72,209,204)); 
	    setResizable(false);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 800, 800 );
		setVisible( true );
	}
	
	public static int roll(){
		Random diceRoller = new Random();
		int roll = diceRoller.nextInt(12) + 1;//Roll Two Dice
		rollView.setText("    Roll: " + Integer.toString(roll));
		return roll;
	}
		
}

class Board extends JPanel{
	public Board(){
	    setBackground(Color.WHITE);
	}

   public void paint(Graphics g) {
	   super.paint(g);
	   g.drawRect (10, 10, 200, 200); 
	   
   }
}



class Menu extends JPanel{
	ImageIcon help,reset,quit,dice;
	
	/* Add's a button to the Panel */
	public Menu(){
	    setBackground(new Color(72,209,204)); 
		/*
		 * Load Menu Images
		 */
	    help = new ImageIcon();
	    reset  = new ImageIcon();
	    quit  = new ImageIcon();
	    dice  = new ImageIcon();
		
		/*
		 * Add Menu Buttons
		 */
	    
		addButton(this, "Roll Dice",null, new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	    	  Parchessi.roll();
	        }
	      });
		
		addButton(this, "Help/Instructions",null, new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	String info = "Goal: \n\tGet all of your tokens arround the board,"
	        			+ " and then to the center of the board.\n\nRules:\n\tIf a token is on a white tile,"
	        			+ " and another Player's token is moved there, the origonal token must"
	        			+ " go back to start. \nEach player will roll 2 dice, with a maximum value of 12 to determine"
	        			+ " how many spaces to move\n\n"
	        			+ "For Each Player's Turn: \n\t1.First Roll the dice.\n\t2.Then Select Which piece to move.\n "
	        			+ "WARNING! If you select a peice before the roll, this piece will be moved to that location.";
	        	JOptionPane.showMessageDialog(null, info, "Help/Instuctions", JOptionPane.INFORMATION_MESSAGE);
	        }
	      });

	      addButton(this, "Exit Game",null, new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	          System.exit(0);
	        }
	      });
	      
			addButton(this, "New Game",null, new ActionListener() {
		        public void actionPerformed(ActionEvent evt) {
		          //System.exit(0);

		        	Game.reset();
		        }
		      });
		
	}
	  public void addButton(Container c, String title, ImageIcon img, ActionListener a) {
		    JButton b = new JButton(title);
		    c.add(b);
		    b.addActionListener(a);
		  }
}