/*
 * Computer.java
 *
 * Version:
 * $Id: Computer.java,v 1.1 2013/04/10 04:28:18 qdv2130 Exp $
 *
 * Revisions:
 * $Log: Computer.java,v $
 * Revision 1.1  2013/04/10 04:28:18  qdv2130
 * PokerPoly
 *
 */

/**
 * A computer player for 2-card poker
 *
 * @author paw: Phil White
 * @author revise: Quang Vu
 */

public class Computer extends Player {
	// boolean ID (a Field) will be set to be false as Computer.
	private static boolean ID;
	
    private static final int BETTER_THAN_HALF_WIN_VALUE =
		( Ranks.QUEEN.getValue() ) * 14 + 
		( Ranks.JACK.getValue() );

   /**
    * Initialize a computer player for 2-card poker
    */
    public Computer (){
    	ID = false;
    }
    /**
     * This method will return the ID of the player.
     * @return false
     */
    public boolean getID(){
    	return ID;
    }
    

   /**
    * determines if the computer should stand (vs fold).  Note the
    * computer will stand if it has >=50% chance of winning (Based on
    * other work, a High Card hand with a Q and J beats 50% of the other
    * possible hands).  For the complete odds of winning see 
<a href="../chance.html">chance.html</a> for tables containing the chance 
    * to win for 2-cards of the same suit, and 2 cards of unmatched suits
    *
    * @return	a boolean value specifying if the computer wants to stand
    */
    public boolean stand(){
	return ( myCards.value() >= BETTER_THAN_HALF_WIN_VALUE );
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