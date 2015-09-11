/*
 * Human.java
 *
 * Version:
 * $Id: Human.java,v 1.1 2013/04/10 04:28:18 qdv2130 Exp $
 *
 * Revisions:
 * $Log: Human.java,v $
 * Revision 1.1  2013/04/10 04:28:18  qdv2130
 * PokerPoly
 *
 */
// Any imports go here
import java.util.Scanner;

/**
 * A human player for 2-card poker.
 *
 * @author paw: Phil White
 * @author revise: Quang Vu
 */

public class Human extends Player {
	// boolean ID ( a field ) will be set to be true as Human. 
	private static boolean ID;
    private static Scanner in;

   /**
    * Initialize a human player for 2-card poker
    */
    public Human ( Scanner inScan ){
	in = inScan;
	ID = true;
    }

    /**
     * This method simply return the ID of the player.
     * @return true.
     */
    public boolean getID(){
    	return ID;
    }
    /**
     * Asks the player if they want to stand.  You should prompt the
     * player with a suitable message, and then read the players response
     * from standard input.
     *
     * @return  a boolean value specifying if the human wants to stand
     */
    public boolean stand(){
	boolean res = true;
	String answer;
	char c;

	do{
	    System.out.print("Do you want to stand (y/n)? ");
	    answer = in.next();
	    answer = answer.toLowerCase();
	    c = answer.charAt(0);
	}while( c != 'y' && c != 'n' );

	if ( c == 'y' ){
	    res = true;
	} else {
	    res = false;
	}
	return res;
    }

   /**
    * Compares the humans hand with the specified computers hand for order. 
    * Returns a:	<table BORDER="1" CELLPADDING="1" CELLSPACING="1">
    *		  <tr><td>negative integer<td>player hand < computers hand	
    *		  <tr><td>zero<td>player hand == computers hand	
    *		  <tr><td>positive integer<td>player hand > computers hand	
    *		</table>
    *
    * @return	a negative integer, zero, or a positive integer as the
    *		human is less than, equal to, or greater than the computer
    */
    public int compareTo( Computer d ){
/*
	int res;

	if( myCards.value() > d.value() ){
	    res = 1;
	} else if( myCards.value() == d.value() ){
	    res = 0;
	} else {
	    res = -1;
	}
	return res;
*/
	return myCards.value() - d.value();
    }

   /**
    * main method for a test driver that should test all the methods
    * in the class
    *
    * @param    args    command line arguments
    */
    public static void main( String args[] ){
    }
}