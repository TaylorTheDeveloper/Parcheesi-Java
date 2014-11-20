import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	static int numPlayers;
	ArrayList<Point> boardPoints;
	JPanel mContainer;
	public static int roll;
	static JLabel rollView;
	
	public Parchessi(){
		numPlayers = 0;
		chooseNumPlayers();
		b = new Board(numPlayers);
		m = new Menu();
		boardPoints = b.getPoints();
		//System.out.println(boardPoints.get(10));
		mContainer = new JPanel();
		rollView = new JLabel("    Roll: ");//Always Player 1's turn
		rollView.setBorder(new EmptyBorder(5, 5, 5, 5) );
		b.setBorder(new EmptyBorder(5, 5, 5, 5) );
		mContainer.add(m,"East");
		mContainer.add(rollView,"West");
		add(b, "Center");
	    add(mContainer, "South");
	    //add(rollView,"North");
	    getContentPane().setBackground(new Color(250,250,250)); 
	    setResizable(false);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//setSize( 725, 850 );
		setBounds(20,20,725,850);
		setVisible( true );
	}
	
	public static int roll(){
		Random diceRoller = new Random();
		int roll = diceRoller.nextInt(12) + 1;//Roll Two Dice
		rollView.setText("    Roll: " + Integer.toString(roll));
		return roll;
	}
	
	public static void chooseNumPlayers(){
		while(numPlayers > 4 || numPlayers < 1){
			String[] options = { "1", "2", "3", "4" };
			String x = (String) JOptionPane.showInputDialog(null, 
									"How Many Players? (1-4)","Parcheesi",
									JOptionPane.QUESTION_MESSAGE, 
									null, options, options[0]); 
        
			numPlayers = Integer.parseInt(x);
		}
	}
		
}


