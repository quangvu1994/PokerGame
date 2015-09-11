/*
 * Player.java
 * 
 * Version:
 * $Id: Player.java,v 1.1 2013/04/10 04:28:17 qdv2130 Exp $
 * 
 * Revisions:
 * $Log: Player.java,v $
 * Revision 1.1  2013/04/10 04:28:17  qdv2130
 * PokerPoly
 *
 * 
 */

// Any imports go here

/**
 * 
 * @author quangvu
 * @e-mail qdv2130
 *
 */

public abstract class Player implements Comparable<Player> {
	/**
	 * Fields of the class
	 */
	protected PokerHand myCards;
	protected int counter;
	String name;
	/**
	 * Constructor that initialize all the fields or member variables
	 */
	public Player(){
		counter = 0;
		myCards =  new PokerHand();
		name = "";
	}
	/**
	 * This method takes a name and assign it to the player's name.
	 * @param Take any String
	 *
	 */
	public void assignName(String n){
		name = n;
	}
	/**
	 * 
	 * @return the name of the player
	 */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return the cards of the player
	 */
	public PokerHand getCard(){
		return myCards;
	}
	/**
	 * This method keep track of how many times a specific player has won in the game.
	 * @return
	 */
	public int incCounter(){
		return counter += 1;
	}
	/**
	 * Compare to method that compare two object.
	 * @return -1 if the first object is smaller than the second object.
	 * 		    0 if they are both equal.
	 * 		    1 if the first object is bigger than the second object.
	 */
	public int compareTo(Player p){
		if(this.getCard().value() < p.getCard().value()){
			return - 1;
		}
		else if(this.getCard().value() == p.getCard().value()){
			return 0;
			
		}else{
			return 1;
		}
	}
	/**
	 * An abstract method that return a boolean true or false.
	 * A requirement method for sub-classes
	 * @return true or false
	 */
	abstract boolean getID();
	
	/**
	 * An abstract method that return a boolean true or false
	 * A requirement method for sub-classes
	 * @return true of false
	 */
	abstract boolean stand();
	/**
	 * The method simply add a card to the poker hand.
	 * @param an object c type Card
	 */
	public void addCard(Card c){
		myCards.addCard(c);
	/**
	 * The method print out the hand of the player.	
	 */
	}
	public void printHand(){
		myCards.printHand(); 
		System.out.println();
	}
	/**
	 * The method reset the player's cards by creating a new instance of PokerHand class.
	 */
	public void newHand(){
		myCards = new PokerHand();
	}
	/**
	 * 
	 * @return the value of the cards.
	 */
	public int value(){
		return myCards.value();
	}
	
}
