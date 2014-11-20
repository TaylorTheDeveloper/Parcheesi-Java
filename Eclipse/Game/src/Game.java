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
		b.setBorder(new EmptyBorder(5, 5, 5, 5) );
		add(b, "Center");
	    add(m, "South");
	    add(rollView,"North");
	    //getContentPane().setBackground(new Color(72,209,204)); 
	    setResizable(false);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 725, 850 );
		setVisible( true );
	}
	
	public static int roll(){
		Random diceRoller = new Random();
		int roll = diceRoller.nextInt(12) + 1;//Roll Two Dice
		rollView.setText("    Roll: " + Integer.toString(roll));
		return roll;
	}
		
}


