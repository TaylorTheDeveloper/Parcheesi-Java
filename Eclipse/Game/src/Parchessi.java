import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
class Parchessi extends JFrame{
	public static Board b;
	public Menu m;
	static int numPlayers;
	public JPanel mContainer;
	public static int roll;
	public static JLabel rollView;
	private static JFrame gameFrame;
	
	public Parchessi(){
		
		//Set and Initialize Number of Players
		numPlayers = 4;
		//chooseNumPlayers();
		
		//Initialize Board and Menu
		b = new Board(numPlayers);
		m = new Menu();
		
		//Game Panel Stuff
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
		setBounds(-900,200,725,850);
		setVisible( true );
	}
	
	public static Board getBoard(){
		return b;
	}
	
	/*
	 * Roll Dice. If both Dice are equal, Player can go again
	 * 
	 */
	public static int roll(){
		Random diceRoller = new Random();
		int roll = diceRoller.nextInt(6) + 1;//Roll first Dice
		int roll2 = diceRoller.nextInt(6) + 1;//Roll second Dice
		
		if(roll == roll2){
			//Set Roll Again Condition to True
		}
		roll += roll2;
		rollView.setText("    Roll: " + Integer.toString(roll));
		System.out.println("Dice Rolled in roll() with value " + roll);
		
		//Now Update
		return roll;
	}
	/*
	 * Choose Number of Players with Error Bounds Checking
	 */
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
		 
	/*
	 * Resets the Game
	 */
	 public static void reset(){
		 gameFrame.setVisible(false); //you can't see me!
		 gameFrame.dispose();
		 gameFrame = new Parchessi();
	 }
	 
	 public static void move(){
		 
	 }

	public static void main(String[] args) {
		 gameFrame = new Parchessi();		 
		 
		 
		  }
		
}


