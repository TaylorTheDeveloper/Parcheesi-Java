package fsu.java.parcheesi;

import javax.swing.JOptionPane;

public class Parchessi {
	//Game Constants
	
	//Game Variables
	Board b;
	
	public void Parcheesi(){
	}


	public static void main(String[] args) {
		//Game Variables
		int numPlayers;
		Parchessi P = new Parchessi();
		
		//Get Number Of Players:
//		do{
//			String[] options = { "1", "2", "3", "4" };
//			String x = (String) JOptionPane.showInputDialog(null, 
//									"How Many Players? (1-4)","Parcheesi",
//									JOptionPane.QUESTION_MESSAGE, 
//									null, options, options[0]); 
//        
//			numPlayers = Integer.parseInt(x);
//		}while(numPlayers > 4 || numPlayers < 1);
		numPlayers = 4;	
		
		Board b = new Board(numPlayers);

	}

}
