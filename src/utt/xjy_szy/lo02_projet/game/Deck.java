package utt.xjy_szy.lo02_projet.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * The Deck class, the property is deck
 * @author Jiayin XU
 * @author Zhengyang SU
 * @see Card 
 */
public class Deck {
	
	private ArrayList<Card> deck = null;
	/**
	 * get the deck
	 * @return the deck
	 * @see Card 
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}
	/**
	 * 
	 * @param deck the deck to set
	 * @see Card 
	 */
	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	
	/**
	 * The constructor of Deck class
	 * @see Card 
	 */
	public Deck() {
		//initialized to 18
		deck = new ArrayList<Card>(17); 
	}
	
	/**
	 * Add card to deck
	 * @param card the card to be added
	 * @see Card 
	 */
	public void addCard(Card card) {
			deck.add(card);
		}

	/**
	 * Shuffle the deck
	 * @see Card 
	 */
	public void shuffleDeck() {
		Collections.shuffle(deck);
		System.out.println("The deck has been shuffled.");
	}
	
	/**
	 * When a player draws a card, he removes the top card from the deck.
	 * @see Card 
	 */
	public void removeTopCard() {
		deck.remove(deck.size()-1);
	}
	
	/**
	 * print the information of deck
	 */
	@Override
	public String toString () {
		return deck.toString();
	}
	
}
