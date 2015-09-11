/*
 * Poker.java
 *
 * Version:
 * $Id: Poker.java,v 1.1 2013/04/10 04:28:18 qdv2130 Exp $
 *
 * Revisions:
 * $Log: Poker.java,v $
 * Revision 1.1  2013/04/10 04:28:18  qdv2130
 * PokerPoly
 *
 */

// Any imports go here.
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * A 2-card poker game played between a human and a computer player
 *
 * @author paw: Phil White
 * @author revise: Quang Vu
 */

public class Poker {


   /**
    * Plays a single hand of poker
    *
    * @param    group  The group a people/computer who play the game.
    * @param    d	The deck
    * @return   An int telling if the user lost/tied/won (neg/0/pos)
    */
    public static Player playHand( ArrayList<Player> group, Deck d ){
    // if stand is true, it means the player will stand the play
    // If stand is false, it means the player will fold.
	boolean stand = true;
	// An arrayList of player which will only takes people who continue to play or stand.
	ArrayList<Player> standOrFold = new ArrayList<Player>();
	// playerWon is the player who win the game. 
	// playerWon is equal to null if nobody win the game.
	Player playerWon = null;

	System.out.println( "== Dealing Cards\n" );
	//give initial cards 
	for (int j=0; j<group.size(); j++ ){
	    group.get(j).addCard( d.dealCard() );
	    group.get(j).addCard( d.dealCard() );
	
	}
	/**
	 * print out the human player's hands
	 */
	for( Player player : group){
		if(player.getID() == true){
			System.out.println( "============== Human " + player.getName() + " Cards  ========" );
			player.printHand();
		}
	}

	// ask all players if they want to stand or not
	for( Player player : group){
		if(player.getID() == true){
			stand = player.stand();
			if(stand){
				standOrFold.add(player);				
			}
		}else{
			stand = player.stand();
			// If the computer is the last player of the game, and everyone else folded
			// The last computer will automatically is the winner.
			if(standOrFold.size() == 0 && player == group.get(group.size() - 1) ){
				System.out.println( "Computer " + player.getName() + " is the only player left, so they stand automatically" );
				standOrFold.add(player);
			}
			
			else if(stand){
				System.out.println( "Computer " + player.getName() + " Stands" );
				standOrFold.add(player);
			}
			else{
				System.out.println( "Computer " + player.getName() + " Folds" );
			}
		}

	}
	/**
	 * Prints out the computer player's hand only.
	 */
	
	for( Player player : group){
		if(player.getID()== false){
			System.out.println( "==============  Computer " + player.getName() + " Cards ========" );
			player.printHand();
		}
	}
	// Nobody is playing
	if(standOrFold.size() == 0){
		playerWon = null;
	}
	// Only one player
	else if(standOrFold.size() == 1){
		playerWon = standOrFold.get(0);
	}
	// More than one player standing in the game.
	else{
		Collections.sort(standOrFold);
		// First player of the collection has the best hand.
		Collections.reverse(standOrFold);
		// First player and second player have same hand.
		if(standOrFold.get(0) == standOrFold.get(1)){
			playerWon = null;
		}
		// First one win the game.
		else{
			playerWon = standOrFold.get(0);
		}
	}
	// have everyone throw in their cards
	for(Player player : group){
		player.newHand();
	}
	// Re-order the turn
	Player first = group.remove(0);
	group.add(first);
	
	return playerWon;
    }

   /**
    * main method -- plays multiple hands of poker, after each hand
    * ask the user if they want to play again.  We also keep track of
    * the number of games played/won by the user and print the results
    * at the end.
    *
    * @param    args      command line arguments
    */
    public static void main( String args[] ){
   
	Scanner in = new Scanner( System.in );
	System.out.println("How many players for this poker game");
	int numPlayer = in.nextInt();

	ArrayList<Player> group = new ArrayList<Player>();
	// Checking if player is human or computer.
	// Adding them into the group list correspond to their type ( human/ computer), and assign a number for each player. 
	for(int i = 0; i < numPlayer;i ++){
		System.out.println("Is player " + i + " human or computer (h/c)");
		String compOrHuman = in.next();
		if(compOrHuman.equals("h")){
			Player player = new Human(in);
			player.assignName(Integer.toString(i));
			group.add(player);
		}
		else if(compOrHuman.equals("c")){
			Player player = new Computer();
			player.assignName(Integer.toString(i));
			group.add(player);
		}
		
	}
	
	
	String again;
	char c;
	Player playerWon;
	int numGames = 0;
	int numTie = 0;
	Deck theDeck = new Deck();
	//Computer theComputer = new Computer();
	//Human theHuman = new Human( in );

	do {
	    numGames = numGames + 1;

	    System.out.println();
	    System.out.println( "##########################################" );
	    System.out.println( "##########       NEW HAND      ###########" );
	    System.out.println( "##########################################" );
	    System.out.println( "\n== Shuffling" );
	    theDeck.shuffle();

	    playerWon = playHand( group , theDeck );
	    // null means a tie game or nobody is actually in the game.
	    if(playerWon == null){
	    	System.out.println("          Tie Game");
	    	numTie = numTie + 1;
	    // Found a player win the game.
	    }else{
	    	if(playerWon.getID() == true){
	    		playerWon.incCounter();
	    		System.out.println("**** Human " + playerWon.getName() + " Won ****" );
	    	}
	    	else{
	    		playerWon.incCounter();
	    		System.out.println("**** Computer " + playerWon.getName() + " Won ****");
	    	}
	    }
	    
	    
	    do{
	    	System.out.print( "Do you wish to play " +
				    "another hand (y/n):" );
		again = in.next();
		again = again.toLowerCase();
		c = again.charAt( 0 );
		
	    }while( c != 'y' && c != 'n' );

	} while ( c == 'y' );
	
	// PRINTING THE RESULT OF THE GAME.
	System.out.println( "========== Results ==========" );
	System.out.println( "Games:\t" + numGames );
	for(Player player : group){
		if(player.getID() == true){
			System.out.println("Human " + player.getName() + " Won: " + player.counter);
		}
		else{
			System.out.println("Computer " + player.getName() + " Won: " + player.counter);
		}
	}
	System.out.println("Ties: " + numTie);
	in.close();
    }
} 