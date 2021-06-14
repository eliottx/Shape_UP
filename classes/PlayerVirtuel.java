package utt.xjy_szy.lo02_projet.game;

import java.util.LinkedList;

/**
 * the Class of virtuel player
 * this class inherits from the Person class
 * @see Person
 * @see Card
 */
public class PlayerVirtuel extends Person{
	/**
	 * the constructor of PlayerVirtuel Class, set the name as "Computer"
	 * @see Person
	 */
	public PlayerVirtuel() {
		// TODO Auto-generated constructor stub
		setNom("Computer");
	}

	/**
	 * the virtuel player plays a card by using the strategy
	 * @param carpet the carpet of game
	 * @see Card
	 * @see Person
	 * @see Context
	 * @see Strategy
	 */
	public void comPlayCard(Carpet carpet) {
		Card card =getHand().peek();
		Context context = new Context(new PlayRandomCard());
		System.out.println("Computer------------------");
		while (true) {
			context.executeStrategy(carpet,card);
			if (carpet.ifCanPlay(card.getX(),card.getY(),card)) {
				carpet.playAcard(card.getX(),card.getY(),card);
				System.out.println("The computer has placed the cards\n");
				getHand().pop();
				break;
			}
			
		}
		

	}
	
	

	
	
}
