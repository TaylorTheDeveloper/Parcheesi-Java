Parcheesi Java Application
============================

Developers:
Taylor Brockhoeft
Rob Shnayder

==============
Contents:
* What's this?
* How to Run
* Official Rules

==============

What's this?
==============
This is a Java Application built after the indian game of the same name, Parchessi. The goal of the game is to manuver your tokens arround the board before any other player does.


How to run:
==============

Just run the executable!
* java -jar parchessi.jar

Or, you can run ./compile from the command line in the Parchessi/src folder. 
And then run java Parchessi to play

Alternativley, you can open up the source. It's already setup to import into Eclipse running JDK 1.7. 
If you compile it yourself, you can go to the main methood in Parchessi.java and look for the commented code block, which should look like this(line 246):

		/*
		 * Uncomment this code below if you wish for it to run a game
		 * automatically for you. This feature was used while debugging to save
		 * me click time! All you are required to input is the number of players
		 * (1-4)
		 */
		//
		// int res = getBoard().checkWin();
		// while(res < 0){
		// PlayAI();
		// res = getBoard().checkWin();
		// }

Official Rules:
===============
Parcheesi is played with two dice and the goal of the game is to move each of one's pieces home to the center space. The most popular Parcheesi boards in America have 68 spaces around the edge of the board, 12 of which are darkened safe spaces where a piece cannot be captured.

Each player selects four pieces of the same color and places them in their "nest", or starting area.  Pieces enter play onto the darkened space to the left of the nest and continue counter-clockwise around the board to the home path directly in front of the player.

Each player rolls a die; the highest roller goes first, and subsequent play continues to the left. On each turn, players throw one or both dice and use the values shown to move their pieces around the board. If an amount on one or both of the dice cannot be moved, that amount is forfeited.
