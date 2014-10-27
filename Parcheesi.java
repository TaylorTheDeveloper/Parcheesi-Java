import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.lang.Exception;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;

/*
0,boardSize-1 = p1
0,0 = p2
boardSize-1,0 = p3
boardSize-1,boardSize-1 = p4
*/




public class Parcheesi  extends JFrame implements KeyListener {
	//movement delay
	long time = 500;
	//diceview so user can see what they rolled
	JLabel diceView;
	JButton rollDice;
	JButton restart;
	JButton quit;
	//
	int NUMPLAYERS;
	int boardSize = 15;
	int diceValue = 1;
	JButton board[][];

	public static void main (String[] args){
		new Parcheesi();
	}

	public Parcheesi(){
		init();
		run();
	}

	public void run(){
		Boolean run = true;
		int playerCounter = 0;
		//traverse(0,boardSize-1,3);//p1
		//traverse(0,0,3);//p2
		traverse(boardSize-1,0,37);//p3
		traverse(0,7,37);//p3
		//traverse(boardSize-1,boardSize-1,5);//p4
		while(run){
			//Player Increment
			playerCounter = (playerCounter+1)%NUMPLAYERS;
			//RollDice
			//Traverse
			//CheckWin
			//Next Turn

		}

	}
	/* Initilize Game Board */
	public void init(){
		final int MENU_ITEMS = 4;
		NUMPLAYERS = 0;
		//Menu Buttons
		rollDice = new JButton("Roll Dice");
		restart = new JButton("Start Over");
		quit = new JButton("Quit");
		//Frame, panels, etc
		JFrame frame = new JFrame("Shape Project"); 
		JPanel contentPane = new JPanel();     
		board = new JButton [boardSize][boardSize];
		//Labels
		diceView = new JLabel("Roll:");
		//Dialog for how many players?
		//JOptionPane optionPane = new JOptionPane("How Many Players?",  JOptionPane.QUESTION_MESSAGE);
		while(NUMPLAYERS > 4 || NUMPLAYERS < 1){
			//NUMPLAYERS =0;
			String[] options = { "1", "2", "3", "4" };
			String x = (String) JOptionPane.showInputDialog(null, 
									"How Many Players? (1-4)","Parcheesi",
									JOptionPane.QUESTION_MESSAGE, 
									null, options, options[0]); 
        
			NUMPLAYERS = Integer.parseInt(x);
			//
		}

		//Button Listeners
		quit.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		        System.exit(0);
		      }
		    });

		restart.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		        init();//Call init to reset the game board, maybe ask user for input
		      }
		    });

				//Button Listeners
		rollDice.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		        diceValue = rollDice();
		        diceView.setText("Roll: " + Integer.toString(diceValue));
		        rollDice.setEnabled(false);
		        //Ask which piece to move with dialog
		      }
		    });
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,1200,800);

		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));

		frame.setContentPane(contentPane);

		JPanel panel_west = new JPanel();
		contentPane.add(panel_west, BorderLayout.WEST);
		panel_west.setLayout(new GridLayout(boardSize,boardSize));

		JPanel panel_menu = new JPanel();
		contentPane.add(panel_menu, BorderLayout.EAST);
		panel_menu.setLayout(new GridLayout(MENU_ITEMS,1));

		//Add Menu Items
		panel_menu.add(diceView);
		panel_menu.add(rollDice);
		panel_menu.add(restart);
		panel_menu.add(quit);


  		//frame.setLayout(new GridLayout(boardSize,boardSize));
		// //Board
		for (int y = 0;y<boardSize;y++){
            for (int x = 0;x<boardSize;x++){
                    board[x][y] = new JButton("");
                    board[x][y].setBackground(Color.blue);
                    panel_west.add(board[x][y]);
                    board[x][y].setEnabled(true);
            }
    	}
    	colorLanes();
    	colorSafeZones();

    	frame.setResizable(true);
		//frame.setSize(500, 500);
		frame.setVisible(true);
	}

	public int rollDice(){
		Random diceRoller = new Random();
		int roll = diceRoller.nextInt(12) + 1;
		return roll;
	}


public void colorSafeZones(){
	int index = boardSize/2;
	for(int y = 0; y < boardSize; y++){//Do Row
		board[index][y].setBackground(Color.red);
	}
	for(int y = 0; y < boardSize; y++){//Do Column
		board[y][index].setBackground(Color.red);
	}
	board[index][index].setBackground(Color.blue);
	board[index][index].setText("SAFE");

	//Image?
	try {
	    Image img = ImageIO.read(getClass().getResource("res/fork.jpg"));
		//board[index][index].setIcon(new ImageIcon(img));
	} catch (IOException ex) {
	}
	
}

public void colorLanes(){
	for(int y = 0; y < boardSize; y++){//Left Row
		board[0][y].setBackground(Color.white);
	}
	for(int y = 0; y < boardSize; y++){//Right Row
		board[boardSize-1][y].setBackground(Color.white);
	}
	for(int y = 0; y < boardSize; y++){//Top Row
		board[y][0].setBackground(Color.white);
	}
	for(int y = 0; y < boardSize; y++){//Bottom Row
		board[y][boardSize-1].setBackground(Color.white);
	}
}
/*
* x = pos x on board
* y = pos y on board
* roll = rollval
* Issue, wont travers more than 35?
*/
public void traverse(int x, int y, int roll){
	//Traverse Outer Ring
	
	//start
	board[x][y].setBackground(Color.yellow);
	for(int i = 0; i < roll; i++){
	    //System.out.println(Integer.toString(x) + " " + Integer.toString(y));
	    if ( y==0 && x<boardSize-1 ) {//good
	    	//System.out.println("x++");
	        x++;
	    }
	    else if (y<boardSize-1 && x==boardSize-1) {
	    	//System.out.println("y++");
	        y++;
	    }
	    else if ( y==boardSize-1 && x>0 ) {
	    	//System.out.println("x--");
	        x--;
	    }
	    else if ( y>0 && x==0 ) {//good
	    	//System.out.println("y--");
	        y--;
	    }

	    board[x][y].setBackground(Color.green);

	    //Sleep between movements
	   	try {
			Thread.sleep(time);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			//press = true;
			}
		if (e.getKeyCode() == KeyEvent.VK_C){
			//color = color+1;
			//color = color % colors.length;
			}
		if (e.getKeyCode() == KeyEvent.VK_Q){
			System.exit(0);
			}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}