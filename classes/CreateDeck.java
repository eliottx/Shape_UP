package utt.xjy_szy.lo02_projet.game;

/**
 * Class of CreateDeck
 * @author Jiayin XU
 * @author Zhengyang SU
 * @see Card
 * @see Deck
 */
public class CreateDeck {
	/**
	 * create the deck with 18 cards inside
	 * @see Card
	 * @return the deck
	 */
	public static Deck createDeck() {
		//card blue
		Card card1 = new Card(Color.blue, Shape.circle, Filled.hollow,1);
		Card card2 = new Card(Color.blue, Shape.circle, Filled.solid,2);
		Card card3 = new Card(Color.blue, Shape.square, Filled.hollow,3);
		Card card4 = new Card(Color.blue, Shape.square, Filled.solid,4);
		Card card5 = new Card(Color.blue, Shape.triangle, Filled.hollow,5);
		Card card6 = new Card(Color.blue, Shape.triangle, Filled.solid,6);
		
		//card green
		Card card7 = new Card(Color.green, Shape.circle, Filled.hollow,7);
		Card card8 = new Card(Color.green, Shape.circle, Filled.solid,8);
		Card card9 = new Card(Color.green, Shape.square, Filled.hollow,9);
		Card card10 = new Card(Color.green, Shape.square, Filled.solid,10);
		Card card11 = new Card(Color.green, Shape.triangle, Filled.hollow,11);
		Card card12 = new Card(Color.green, Shape.triangle, Filled.solid,12);
		
		//card red
		Card card13 = new Card(Color.red, Shape.circle, Filled.hollow,13);
		Card card14 = new Card(Color.red, Shape.circle, Filled.solid,14);
		Card card15 = new Card(Color.red, Shape.square, Filled.hollow,15);
		Card card16 = new Card(Color.red, Shape.square, Filled.solid,16);
		Card card17 = new Card(Color.red, Shape.triangle, Filled.hollow,17);
		Card card18 = new Card(Color.red, Shape.triangle, Filled.solid,18);
		
		//Create a new deck
		Deck deck = new Deck();
		
		//Add cards to deck
		//blue
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		deck.addCard(card4);
		deck.addCard(card5);
		deck.addCard(card6);
		
		//green
		deck.addCard(card7);
		deck.addCard(card8);
		deck.addCard(card9);
		deck.addCard(card10);
		deck.addCard(card11);
		deck.addCard(card12);
		
		//red
		deck.addCard(card13);
		deck.addCard(card14);
		deck.addCard(card15);
		deck.addCard(card16);
		deck.addCard(card17);
		deck.addCard(card18);
		
		return deck;
		
		
	}

}
