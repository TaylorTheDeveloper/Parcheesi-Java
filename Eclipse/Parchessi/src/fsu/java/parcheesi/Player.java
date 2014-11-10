package fsu.java.parcheesi;

import java.awt.Color;
	
public class Player {
	private Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};//Player Colors
	private String[] colorstr = {"RED", "BLUE", "GREEN", "YELLOW"};//Player Colors
	private Color c;
	private int id;
	private Token[] tokens;
	
	public Player(int i){
		id = i;
		c = colors[i];
		tokens = new Token[4];
		for(int k = 0; k < 4; k++){
			//tokens[k].setNum(k);
		}
	}
	
	public String details(){
		StringBuilder str = new StringBuilder();
		str.append("Player: " + Integer.toString(id+1));
		str.append(" Tokens: ");
		
		for(int i = 0; i < 4; i++){
			if(tokens[i].isSafe()){
				str.append(Integer.toString(i+1) + " ");
			}
			else{
				str.append("$ ");
			}
		}
		
		System.out.println(str.toString());
		return str.toString();
	}
	
	public class Token{
		//If Location = 0, Token is not on Board
		int num;
		int location;
		boolean safe;
		
		public Token(){
			num = 0;
			location = 0;
			safe = true;
		}
		
		public boolean isSafe(){
			return safe;
		}
		
		public void setNum(int i){
			num=i;
		}
		public int getNum(){
			return num;
		}
		public void setLocation(int i){
			location=i;
		}
		public int getLocation(){
			return location;
		}
	}
	

}
