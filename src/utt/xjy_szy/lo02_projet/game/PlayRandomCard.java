package utt.xjy_szy.lo02_projet.game;

import java.util.Random;
import java.util.Scanner;

/**
 * the Class of PlayRandomCard, a strategy of virtuel player
 * this class inherits the Strategy interface
 * @see Person
 * @see Carpet
 * @see Strategy
 * @see Card
 */
public class PlayRandomCard implements Strategy {

	/**
	 * the strategy of virtuel player
	 * @param carpet the carpet of game
	 * @param card the card the virtuel player has on hand
	 * @see Person
	 * @see Carpet
	 * @see Strategy
	 * @see Card
	 */
	@Override
	public void PlayStrategy(Carpet carpet,Card card) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x = rand.nextInt(9)+1;
		int y = rand.nextInt(9)+1;
		card.setX(x);
		card.setY(y);
	}

}


