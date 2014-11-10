package fsu.java.parcheesi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board{
	//Frames/Panels
	private JFrame frame;//Window
	private JPanel contentPane;//Holds Game
	private JPanel board;//Left
	private JPanel menu;//Right
	private JPanel playerDetails;//North
	private JPanel game;//Center
	
	//Buttons/Labels
	private JLabel diceView;
	private JLabel playerView;
	private JLabel playerTurn;
	private JLabel[] playerData;
	private JButton rollDice;
	
	//private JButton restart;
	private JButton quit;
	//Players
	public Player[] playerList;
	
	//Variables
	private int numPlayers;
	public int diceValue;

	public Board(int p){
		numPlayers = p;
		initPlayers();
		updatePlayerDetails();
		initBoard();
		contentPane.setLayout(new BorderLayout(0,0));
		frame.setContentPane(contentPane);
		
		contentPane.add(board, BorderLayout.WEST);
		contentPane.add(menu,BorderLayout.EAST);
		
		board.add(playerDetails, BorderLayout.NORTH);
		board.add(game, BorderLayout.CENTER);
		
		for(int i = 0; i<numPlayers; i++){
			playerDetails.add(playerData[i]);
		}
		
		menu.add(playerTurn);
		menu.add(playerView);
		menu.add(diceView);
		menu.add(rollDice);
		menu.add(quit);		
		
		setListeners();
		
		frame.setSize(1200,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//Initialize Players
	public void initPlayers(){
		playerList = new Player[numPlayers];
		playerData = new JLabel[numPlayers];
		
		for(int i = 0; i<numPlayers; i++){
			playerList[i] = new Player(i);	
			playerData[i] = new JLabel();
		}
		
	}
	
	public void updatePlayerDetails(){
		for(int i = 0; i<numPlayers; i++){
			playerData[i].setText(playerList[i].details() + "||");
		}
	}
	
	//Initializes all objects, Frames,Panels, Buttons, and Labels
	public void initBoard(){
		
		frame = new JFrame("Parcheesi");
		contentPane = new JPanel();
		board = new JPanel();
		menu = new JPanel();
		
		playerDetails = new JPanel();
		game = new JPanel();
		
		//Labels
		playerTurn = new JLabel("Turn: "+1);//Always Player 1's turn
		playerView = new JLabel("Players: "+numPlayers);
		diceView = new JLabel("Roll: 1");
		
		rollDice = new JButton("Roll Dice");
		//restart = new JButton("Start Over");
		quit = new JButton("Quit");
		
	}
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillOval(0, 0, 30, 30);
		g2d.drawOval(0, 50, 30, 30);		
		g2d.fillRect(50, 0, 30, 30);
		g2d.drawRect(50, 50, 30, 30);

		g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	
	public void setListeners(){
		//Button Listeners
			quit.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent e){
			        System.exit(0);
			      }
			    });

//			restart.addActionListener(new ActionListener(){
//			      public void actionPerformed(ActionEvent e){
//			        //initBoard();//Call init to reset the game board, maybe ask user for input
//			      }
//			    });

					//Button Listeners
			rollDice.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent e){
			        diceValue = rollDice();
			        diceView.setText("Roll: " + Integer.toString(diceValue));
			      //  rollDice.setEnabled(false);
			      //  hasPlayerRolled = true;
			        //Ask which piece to move with dialog
			      }
			    });
	}
	
	public int rollDice(){
		Random diceRoller = new Random();
		int roll = diceRoller.nextInt(12) + 1;
		return roll;
	}
}
