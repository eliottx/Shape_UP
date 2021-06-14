package utt.xjy_szy.lo02_projet.game;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Scanner;


/**
 * The class of Person, which implements Scoring and Element, Person is a concrete visitor 
 * The properties are: nom, totalScore, hand, victoryCard, deck and carpet
 * @author Jiayin XU
 * @author Zhengyang SU
 * @see Deck
 * @see Card
 * @see Carpet
 */
public abstract class Person implements Scoring,Element{

	private String nom;
	public Integer totalScore;
	private LinkedList<Card> hand = new LinkedList<Card>();  
	private Card victoryCard = null;
	private Deck deck;
	private Carpet carpet;
	
	/**
	 * @return name of person
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom name of person
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the list of cards of person
	 */
	public LinkedList<Card> getHand() {
		return hand;
	}
	
	/**
	 * print the cards in hand
	 */
	public void showHand() {
		System.out.println(getNom() + ", These are the cards in your hand");
		System.out.println(getHand());
	}

	/**
	 * @param hand the list of cards
	 */
	public void setHand(LinkedList<Card> hand) {
		this.hand = hand;
	}
	
	/**
	 * @return the total score of player
	 */
	public Integer getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore the total score of player
	 */
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	/**
	 * @return the victory card of player
	 */
	public Card getVictoryCard() {
		return victoryCard;
	}

	/**
	 * @param victoryCard the victory card of player
	 */
	public void setVictoryCard(Card victoryCard) {
		this.victoryCard = victoryCard;
	}

	/**
	 * @return the deck of cards
	 * @see Deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @param deck the deck of cards
	 * @see Deck
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}


	/**
	 * @return the carpet of game
	 * @see Carpet
	 */
	public Carpet getCarpet() {
		return carpet;
	}

	/**
	 * @param carpet the carpet of game
	 * @see Carpet
	 */
	public void setCarpet(Carpet carpet) {
		this.carpet = carpet;
	}

	/**
	 * the player draws a card in the deck
	 * @param d the deck of cards
	 * @see Deck
	 */
	public void drawCard(Deck d) {
		if (victoryCard == null ) {
			victoryCard = d.getDeck().get(d.getDeck().size()-1);
			d.removeTopCard();
			System.out.println(getNom() + " Your victoryCard : " + victoryCard );
		}
		else {
			//
			//Adding cards to the hand
			hand.add(d.getDeck().get(d.getDeck().size()-1));
			d.removeTopCard();
			for (Iterator iterator = hand.iterator(); iterator.hasNext();) {
				Card card = (Card) iterator.next();
				System.out.println(getNom() + ", the card you drew is " + card);
				
			}
		}
	}
	
	/**
	 * acceptor of Visitor pattern
	 * @param p person, c carpet
	 * @see Carpet
	 * @see Person
	 */
	public void accept(Carpet c) {
		this.Scoring(c);
	}
	
	/**
	 * the first player puts the first card on the carpet
	 * @param carpet the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	public void playFirstCard(Carpet carpet) {
		Card card = hand.peek();
		carpet.playFirstcard(card);
		System.out.println("Because it is the first card, it will automatically be placed at the center of the board.");
		System.out.println("Your turn is over.");
		hand.pop();
	}
	

	/**
	 * player plays a card on the carpet
	 * @param carpet the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	public void playCard(Carpet carpet) {
		Card card = hand.peek();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter X and Y: ");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			card.setX(x);
			card.setY(y);
			if (carpet.ifCanPlay(x,y,card)) {
				
				carpet.playAcard(x, y, card);
				System.out.println("You can place the card at this place.\n");
				hand.pop();
				
				break;
				
			}
			else {
				System.out.println("You can't place the card at this place");
				//System.out.println("The placement of cards must be orthogonal.\n");
				System.out.println("Please select another coordinate\n");
			}
		}
	}


	/**
	 * player moves a card on the carpet
	 * @param carpet the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	public void moveCard(Carpet carpet) {
		boolean flag = false;
		while (flag == false) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Which card do you want to move?");
			System.out.println("Please enter the original coordinate X and Y: ");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			if (carpet.getCard(x, y).getId() != 0) {
				Card tempCard = carpet.getCard(x, y);
				hand.add(tempCard);
				carpet.deleteACard(x, y, tempCard);
				playCard(carpet);
				flag = true;
			}
			else {
				System.out.println("No cards in this location.");
				System.out.println("Please select another coordinate\n");
			}
		}
	}
	
	/**
	 * player plays a card on the carpet, the function is especially for VUE
	 * @param x the target coordinate x of card
	 * @param y the target coordinate y of card
	 * @param carpet the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	public void playCardForVue(int x, int y, Carpet carpet) {
		Card card = getHand().peek();
			card.setX(x);
			card.setY(y);
			if (carpet.ifCanPlay(x,y,card)) {      
				carpet.playAcard(x, y, card);
				System.out.println("You can place the card at this place.\n");
				hand.pop();
				//carpet.refresh();
				
			}
			else {
				System.out.println("You can't place the card at this place");
				//System.out.println("The placement of cards must be orthogonal.\n");
				System.out.println("Please select another coordinate\n");
			}
	}


	/**
	 * player moves a card on the carpet, the function is especially for VUE
	 * @param x_from the old coordinate x of card
	 * @param y_from the old coordinate y of card
	 * @param x_to the target coordinate x of card
	 * @param y_to the target coordinate y of card
	 * @param carpet the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	public void moveCardForVue(int x_from,int y_from, int x_to,int y_to,Carpet carpet) {
		if (carpet.getCard(x_from, y_from).getId() != 0) {
			Card tempCard = carpet.getCard(x_from, y_from);
			hand.add(tempCard);
			carpet.deleteACard(x_from, y_from, tempCard);
			playCardForVue(x_to, y_to, carpet);
		}
		else {
			System.out.println("No cards in this location.");
			System.out.println("Please select another coordinate\n");
		}
		
	}
	
	/**
	 * player draws a card in the deck, the function is especially for the advanced mode
	 * @param d the deck of cards
	 * @see Carpet
	 * @see Card
	 */
	//The following methods with advanced are only for Advanced Shape UP!
	public void drawCardAdvanced(Deck d) {
		Card addCard = d.getDeck().get(d.getDeck().size()-1);
		hand.add(addCard);
		d.removeTopCard();
		System.out.println(getNom() + " ,the card you drew is " + addCard);
	}


	/**
	 * the first player plays the first card on the carpet
	 * the function is especially for the advanced mode
	 * @param carpet the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	public void playFirstCardAdvanced(Carpet carpet) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			showHand();
			System.out.println("Which card do you want to play? The first one(1), the second one(2) or the third one(3)?");
			System.out.println("Please enter the number.");
			int numCard = scanner.nextInt();
			if (numCard == 1) {
				Card card = hand.peek();
				carpet.playFirstcard(card);
				System.out.println("Because it is the first card, it will automatically be placed at the center of the board.");
				System.out.println("Your turn is over.");
				hand.pop();
				
				break;
			}
			else if (numCard == 2) {
				Card temCard = hand.peek();
				hand.remove();
				Card card = hand.peek();
				carpet.playFirstcard(card);
				System.out.println("Because it is the first card, it will automatically be placed at the center of the board.");
				System.out.println("Your turn is over.");
				hand.pop();
				hand.add(temCard);
				break;	
			}
			else if (numCard == 3) {
				Card card = hand.peekLast();
				carpet.playFirstcard(card);
				System.out.println("Because it is the first card, it will automatically be placed at the center of the board.");
				System.out.println("Your turn is over.");
				hand.remove(2);
				break;
			}
			else {
				System.out.println("Invalid number.Please re-enter.");
			}
	
		}
		
	}
	
	/**
	 * player plays a card on the carpet
	 * the function is especially for the advanced mode
	 * @param carpet the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	public void playCardAdvanced(Carpet carpet) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			showHand();
			System.out.println("Which card do you want to play? The first one(1), the second one(2) or the third one(3)?");
			System.out.println("Please enter the number.");
			int numCard = scanner.nextInt();
			
			if (numCard == 1) {
				Card card = hand.peek();
				while (true) {
					System.out.println("Please enter X and Y: ");
					int x = scanner.nextInt();
					int y = scanner.nextInt();
					card.setX(x);
					card.setY(y);
					if (carpet.ifCanPlay(x,y,card)) {
						
						carpet.playAcard(x, y, card);
						System.out.println("You can place the card at this place.\n");
						break;
						
					}
					else {
						System.out.println("You can't place the card at this place");
						//System.out.println("The placement of cards must be orthogonal.\n");
						System.out.println("Please select another coordinate\n");
					}
				}
				hand.pop();
				break;
			}
			
			else if (numCard == 2) {
				Card temCard = hand.peek();
				hand.remove();
				Card card = hand.peek();
				while (true) {
					System.out.println("Please enter X and Y: ");
					int x = scanner.nextInt();
					int y = scanner.nextInt();
					card.setX(x);
					card.setY(y);
					if (carpet.ifCanPlay(x,y,card)) {
						
						carpet.playAcard(x, y, card);
						System.out.println("You can place the card at this place.\n");
						break;
						
					}
					else {
						System.out.println("You can't place the card at this place");
						//System.out.println("The placement of cards must be orthogonal.\n");
						System.out.println("Please select another coordinate\n");
					}
				}
				hand.pop();
				hand.add(temCard);
				break;	
			}
			else if (numCard == 3) {
				Card card = hand.peekLast();
				while (true) {
					System.out.println("Please enter X and Y: ");
					int x = scanner.nextInt();
					int y = scanner.nextInt();
					card.setX(x);
					card.setY(y);
					if (carpet.ifCanPlay(x,y,card)) {			
						carpet.playAcard(x, y, card);
						System.out.println("You can place the card at this place.\n");
						break;
						
					}
					else {
						System.out.println("You can't place the card at this place");
						//System.out.println("The placement of cards must be orthogonal.\n");
						System.out.println("Please select another coordinate\n");
					}
				}
				hand.removeLast();
				break;
			}
			else {
				System.out.println("Invalid number.Please re-enter.");
			}
			
		}
		
			
	}
	
	/**
	 * calculate the score of each player
	 * @param c the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	@Override
	public int Scoring(Carpet c) {
		  int totalScore; 
		  int colorScore = 0;
		  int shapeScore = 0;
		  int filledScore = 0;   
		  Color victoryColor = getVictoryCard().getC();
		  Shape victoryShape = getVictoryCard().getS();
		  Filled victoryFilled = getVictoryCard().getF();
		 
		//shape score, finding by line
			for(int i=0; i<11; i++) {
				for(int j=0; j<11; j++) {
					if(c.getCard(i,j)!=null) {
						if(c.getCard(i,j).getS() == victoryShape) {//first card has the right shape.
							if(c.getCard(i,(j+1))!=null) {//if the next card exists
								if(c.getCard(i,(j+1)).getS() == c.getCard(i,j).getS()) {//next card has the same shape.
									shapeScore = shapeScore +1;
									j=j+1;
									if(c.getCard(i,(j+1))!=null) {//if the next card exists
										if(c.getCard(i,(j+1)).getS() == c.getCard(i,(j)).getS()) {//has the same shape.
											shapeScore = shapeScore +1;
											j=j+1;
											if(c.getCard(i,(j+1))!=null) {//recursive
												if(c.getCard(i,(j+1)).getS() == c.getCard(i,(j)).getS()) {
													shapeScore = shapeScore +1;
													j=j+1;
													if(c.getCard(i,(j+1))!=null) {//
														if(c.getCard(i,(j+1)).getS() == c.getCard(i,(j)).getS()) {
															shapeScore = shapeScore +1;
														}	
													}
												}
											}
										}
									}
								}
							}
						}

					}
				}
			}
			
			//shape score, finding by column
			for(int j=0; j<11; j++) {
				for(int i=0; i<11; i++) {
					if(c.getCard(i,j)!=null) {
						if(c.getCard(i,j).getS() == victoryShape) {
							if(c.getCard((i+1),j)!= null) {
								if(c.getCard((i+1),j).getS() == c.getCard(i,j).getS()) {
									shapeScore = shapeScore +1;
									i=i+1;
									if(c.getCard((i+1),j)!=null) {
										if(c.getCard((i+1),j).getS() == c.getCard(i,j).getS()) {
											shapeScore = shapeScore +1;
											i=i+1;
											if(c.getCard((i+1),j)!=null) {
												if(c.getCard((i+1),j).getS() == c.getCard(i,j).getS()) {
													shapeScore = shapeScore +1;
													i=i+1;
													if(c.getCard((i+1),j)!=null) {
														if(c.getCard((i+1),j).getS() == c.getCard(i,(j)).getS()) {
															shapeScore = shapeScore +1;
														}
														
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			
			//color score, finding by line
			for(int i=0; i<11; i++) {
				for(int j=0; j<11; j++) {
					if(c.getCard(i,j)!=null) {
						if(c.getCard(i,j).getC() == victoryColor) {
							if(c.getCard(i,(j+1))!=null) {
								if(c.getCard(i,(j+1)).getC() == c.getCard(i,j).getC()) {
									j=j+1;
									if(c.getCard(i,(j+1))!=null) {
										if(c.getCard(i,(j+1)).getC() == c.getCard(i,(j)).getC()) {
											colorScore = colorScore +4;
											j=j+1;
											if(c.getCard(i,(j+1))!=null) {
												if(c.getCard(i,(j+1)).getC() == c.getCard(i,(j)).getC()) {
													colorScore = colorScore +1;
													j=j+1;
													if(c.getCard(i,(j+1))!=null) {
														if(c.getCard(i,(j+1)).getC() == c.getCard(i,(j)).getC()) {
															colorScore = colorScore +1;
														}
														
													}
												}
												
											}
										}
										
									}
								}
								
							}
						}
						
					}
				}
			}
			//color score, finding by column
			for(int j=0; j<11; j++) {
				for(int i=0; i<11; i++) {
					if(c.getCard(i,j)!=null) {
						if(c.getCard(i,j).getC() == victoryColor) {
							if(c.getCard((i+1),j)!= null) {
								if(c.getCard((i+1),j).getC() == c.getCard(i,j).getC()) {
									i=i+1;
									if(c.getCard((i+1),j)!=null) {
										if(c.getCard((i+1),j).getC() == c.getCard(i,j).getC()) {
											colorScore = colorScore + 4;
											i=i+1;
											if(c.getCard((i+1),j)!=null) {
												if(c.getCard((i+1),j).getC() == c.getCard(i,j).getC()) {
													colorScore = colorScore + 1;
													i=i+1;
													if(c.getCard((i+1),j)!=null) {
														if(c.getCard((i+1),j).getC() == c.getCard(i,(j)).getC()) {
															colorScore = colorScore + 1;
														}
														
													}
												}
												
											}
										}
										
									}
								}
								
							}
						}
						
					}
				}
			}
			

			//filled score, finding by line
			for(int i=0; i<11; i++) {
				for(int j=0; j<11; j++) {
					if(c.getCard(i,j)!=null) {
						if(c.getCard(i,j).getF() == victoryFilled) {
							if(c.getCard(i,(j+1))!=null) {
								if(c.getCard(i,(j+1)).getF() == c.getCard(i,j).getF()) {
									j=j+1;
									if(c.getCard(i,(j+1))!=null) {
										if(c.getCard(i,(j+1)).getF() == c.getCard(i,(j)).getF()) {
											filledScore = filledScore +3;
											j=j+1;
											if(c.getCard(i,(j+1))!=null) {
												if(c.getCard(i,(j+1)).getF() == c.getCard(i,(j)).getF()) {
													filledScore = filledScore +1;
													j=j+1;
													if(c.getCard(i,(j+1))!=null) {
														if(c.getCard(i,(j+1)).getF() == c.getCard(i,(j)).getF()) {
															filledScore = filledScore +1;
														}
														
													}
												}
												
											}
										}
										
									}
								}
								
							}
						}
						
					}
				}
			}
			//filled score, finding by column
			for(int j=0; j<11; j++) {
				for(int i=0; i<11; i++) {
					if(c.getCard(i,j)!=null) {
						if(c.getCard(i,j).getF() == victoryFilled) {
							if(c.getCard((i+1),j)!= null) {
								if(c.getCard((i+1),j).getF() == c.getCard(i,j).getF()) {
									i=i+1;
									if(c.getCard((i+1),j)!=null) {
										if(c.getCard((i+1),j).getF() == c.getCard(i,j).getF()) {
											filledScore = filledScore +3;
											i=i+1;
											if(c.getCard((i+1),j)!=null) {
												if(c.getCard((i+1),j).getF() == c.getCard(i,j).getF()) {
													filledScore = filledScore +1;
													i=i+1;
													if(c.getCard((i+1),j)!=null) {
														if(c.getCard((i+1),j).getF() == c.getCard(i,(j)).getF()) {
															filledScore = filledScore +1;
														}
														
													}
												}
												
											}
										}
										
									}
								}
								
							}
						}
						
					}
				}
			}
			
			totalScore = colorScore + shapeScore + filledScore;
//			System.out.println(getNom() + ", your colorcore: " + colorScore);
//			System.out.println(getNom() + ", your shapescore: " + shapeScore);
//			System.out.println(getNom() + ", your filledscore: " + filledScore);
//			System.out.println(getNom() + ", your totalscore: " + totalScore);
			return totalScore;
		  
}


	/**
	 * internal function of function moveCardAdvanced
	 * @param carpet the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	//this method is only used in the moving card in advanced mode
	public void playTemHandCard(Carpet carpet) {
		Card card = hand.peekLast();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter X and Y: ");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			card.setX(x);
			card.setY(y);
			if (carpet.ifCanPlay(x,y,card)) {
				
				carpet.playAcard(x, y, card);
				System.out.println("You can place the card at this place.\n");
				hand.removeLast();
				break;
				
			}
			else {
				System.out.println("You can't place the card at this place");
				//System.out.println("The placement of cards must be orthogonal.\n");
				System.out.println("Please select another coordinate\n");
			}
		}
	}
	
	/**
	 * player moves a card on the carpet
	 * the function is especially for the advanced mode
	 * @param carpet the carpet of game
	 * @see Carpet
	 * @see Card
	 */
	public void moveCardAdvanced(Carpet carpet) {
		boolean flag = false;
		while (flag == false) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Which card do you want to move?");
			System.out.println("Please enter the original coordinate X and Y: ");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			if (carpet.getCard(x, y).getId() != 0) {
				Card tempCard = carpet.getCard(x, y);
				hand.add(tempCard);
				carpet.deleteACard(x, y, tempCard);
				playTemHandCard(carpet);
				flag = true;
			}
			else {
				System.out.println("No cards in this location.");
				System.out.println("Please select another coordinate\n");
			}
		}
	}
	

}
