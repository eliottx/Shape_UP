package utt.xjy_szy.lo02_projet.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
 * The Game class, extends Thread, the properties are: deck, players, answer, carpet, gameMode, gameRound, hiddenCard, ifFirstPlay, x_play, y_play
 * @author Jiayin XU
 * @author Zhengyang SU
 * @see Card
 * @see Deck
 * @see Player
 * @see Carpet
 */
public class Game extends Thread{
	
	private Deck deck;
	private ArrayList<Player> players;
	private int answer;
	private Carpet carpet = new Carpet();
	private int gameMode;
	private int gameRound = 0;
	private Card hiddenCard = null;
	boolean ifFirstPlay = true;
	private int x_play=0;
	private int y_play=0;
	
	/**
	 * @return coordinate x to play
	 * @see Card
	 */
	public int getX_play() {
		return x_play;
	}
	/**
	 * @param x_play the coordinate x to play
	 * @see Card
	 */
	public void setX_play(int x_play) {
		this.x_play = x_play;
	}

	/**
	 * @return coordinate y to play
	 * @see Card
	 */
	public int getY_play() {
		return y_play;
	}
	/**
	 * @param y_play the coordinate y to play
	 * @see Card
	 */
	public void setY_play(int y_play) {
		this.y_play = y_play;
	}

	
	/**
	 * @return the mode of game
	 */
	public int getGameMode() {
		return gameMode;
	}
	
	/**
	 * @param gameMode the mode of game
	 */
	public void setGameMode(int gameMode) {
		this.gameMode = gameMode;
	}
	
	/**
	 * @return the round count of game
	 */
	public int getGameRound() {
		return gameRound;
	}
	
	/**
	 * @param gameRound the round count of game
	 */
	public void setGameRound(int gameRound) {
		this.gameRound = gameRound;
	}
	
	/**
	 * @return the round count of game
	 */
	public int getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer of player
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}

	/**
	 * @return the hidden card of a game
	 * @see Card
	 */
	public Card getHiddenCard() {
		return hiddenCard;
	}

	/**
	 * @param hiddenCard the hidden card of a game
	 * @see Card
	 */
	public void setHiddenCard(Card hiddenCard) {
		this.hiddenCard = hiddenCard;
	}
	
	/**
	 * @return the deck of a game
	 * @see Deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @param deck the deck of a game
	 * @see Deck
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	/**
	 * @return players
	 * @see Player
	 * @see PlayerVirtuel
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the player in game
	 * @see Player
	 * @see PlayerVirtuel
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * @return carpet
	 * @see Carpet
	 */
	public Carpet getCarpet() {
		return carpet;
	}

	/**
	 * @param carpet the carpet
	 * @see Carpet
	 */
	public void setCarpet(Carpet carpet) {
		this.carpet = carpet;
	}

	/**
	 * initilize the game:create deck, shuffle deck and pick the hidden card
	 * @see Deck
	 * @see Card
	 */
	public void gameSetup() {
		
		//create deck
		deck = CreateDeck.createDeck();
		
		//shuffle deck
		deck.shuffleDeck();
		
		//pick the hidden card
		pickTheHiddenCard();
		
	}

	/**
	 * choose the mode of game to play
	 */
	public void chooseMode() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int a = 0;
			System.out.println("Please select the game mode.");
			System.out.println("Mode1: 2 real Players");
			System.out.println("Mode2: 2 Players(You and computer)");
			System.out.println("Mode3: 3 real Players");
			System.out.println("Mode4: Advanced Shape UP!");
			System.out.println("Please enter the number.");
			a = scanner.nextInt();
			if (a == 1 || a == 2 || a == 3 || a == 4) {
				gameMode = a;
				break;
			}
			else {
				System.out.println("Invalid number, please re-enter");
			}
			
		}
	}
	
	/**
	 * the four different modes of game
	 * @see Player
	 * @see PlayerVirtuel
	 */
	public void playMode() {
		if (gameMode == 1) {
			//2 players
			//Game g = new Game();
			Scanner scanner = new Scanner(System.in);
			String nom;
			gameSetup();
			pickTheHiddenCard();
			System.out.println(getCarpet());
			System.out.println("Enter the name of Player 1");
			nom = scanner.next();
			Player aPlayer = new Player(nom);
			System.out.println("Enter the name of Player 2");
			nom = scanner.next();
			Player bPlayer = new Player(nom);

			  
			while (!isGameOver()) {
			turn(aPlayer);
			System.out.println(getCarpet());
			if (isGameOver()) {
			    break;
			   }
			turn(bPlayer);
			System.out.println(getCarpet());  
			  }
			  
			System.out.println(getCarpet());
			int aScore = aPlayer.Scoring(getCarpet());
			int bScore = bPlayer.Scoring(getCarpet());
			  
			if (aScore>bScore) {
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
			    System.out.println(aPlayer.getNom() + ", you win!");
			  }
			else if (aScore<bScore) {
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
				System.out.println(bPlayer.getNom() + ", you win!");
			  }
			else {
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
				System.out.println("Draw");
			  }
			  			
		}
		if (gameMode == 2) {
			//1 player vs 1 computer
			Scanner scanner = new Scanner(System.in);
			String nom;
			PlayerVirtuel com = new PlayerVirtuel();
			gameSetup();
			pickTheHiddenCard();
			System.out.println(getCarpet());
			System.out.println("enter your name");
			nom = scanner.next();
			Player aPlayer = new Player(nom);
			while (!isGameOver()) {
				   turn(aPlayer);
				   System.out.println(getCarpet());
				   if (isGameOver()) {
				    break;
				   }
				   comTurn(com);
				   System.out.println(getCarpet());
				   
				  }
				  
				  System.out.println(getCarpet());
				  int aScore = aPlayer.Scoring(getCarpet());
				  int bScore = com.Scoring(getCarpet());
				  
				  if (aScore>bScore) {
					  System.out.println(aPlayer.getNom() + ", your score: " + aScore);
					  System.out.println("Computer's Scoring" + bScore);
					  System.out.println(aPlayer.getNom() + ", you win!");
				  }
				  else if (aScore<bScore) {
					  System.out.println(aPlayer.getNom() + ", your score: " + aScore);
					  System.out.println("Computer's Scoring" + bScore);
				      System.out.println(com.getNom() + ", you win!");
				  }
				  else {
					  System.out.println(aPlayer.getNom() + ", your score: " + aScore);
					  System.out.println("Computer's Scoring" + bScore);
					  System.out.println("Draw");
				  }
		}
		
		if (gameMode == 3) {
			//3 players
			Scanner scanner = new Scanner(System.in);
			String nom;
			gameSetup();
			pickTheHiddenCard();
			System.out.println(getCarpet());
			System.out.println("Enter the name of Player 1");
			nom = scanner.next();
			Player aPlayer = new Player(nom);
			System.out.println("Enter the name of Player 2");
			nom = scanner.next();
			Player bPlayer = new Player(nom);
			System.out.println("Enter the name of Player 3");
			nom = scanner.next();
			Player cPlayer = new Player(nom);
	  
			while (!isGameOver()) {
			turn(aPlayer);
			System.out.println(getCarpet());
			turn(bPlayer);
			if (isGameOver()) {
			    break;
			   }
			System.out.println(getCarpet()); 
			turn(cPlayer);
			System.out.println(getCarpet()); 

			 }
			  
			System.out.println(getCarpet());
			int aScore = aPlayer.Scoring(getCarpet());
			int bScore = bPlayer.Scoring(getCarpet());
			int cScore = cPlayer.Scoring(getCarpet());
			  
			if (aScore>bScore && aScore>cScore){
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
				System.out.println(cPlayer.getNom() + ", your score: " + cScore);
			    System.out.println(aPlayer.getNom() + ", you win!");
			  }
			else if (bScore>aScore && bScore>cScore){
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
				System.out.println(cPlayer.getNom() + ", your score: " + cScore);
				System.out.println(bPlayer.getNom() + ", you win!");
			  }
			else if (cScore>aScore && cScore>bScore) {
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
				System.out.println(cPlayer.getNom() + ", your score: " + cScore);
				System.out.println(cPlayer.getNom() + ", you win!");
				}
			else {
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
				System.out.println(cPlayer.getNom() + ", your score: " + cScore);
				System.out.println("Draw");
			  }
			
		}
		
		if (gameMode == 4) {
			Scanner scanner = new Scanner(System.in);
			String nom;
			gameSetup();
			
			System.out.println(getHiddenCard());
			System.out.println(getCarpet());
			System.out.println("Enter the name of Player 1");
			nom = scanner.next();
			Player aPlayer = new Player(nom);
			System.out.println("Enter the name of Player 2");
			nom = scanner.next();
			Player bPlayer = new Player(nom);
			
			
			//every player get 3 cards
			for (int i = 0; i < 3; i++) {
				aPlayer.drawCardAdvanced(deck);
				bPlayer.drawCardAdvanced(deck);	
			}
			
			
			//Start game
			while (!isGameOver()) {
				turnAdvanced(aPlayer);
				System.out.println(getCarpet());
				if (isGameOver()) {
				    break;
				   }
				turnAdvanced(bPlayer);
				System.out.println(getCarpet());  
			}
			
			//Find the victory card
			aPlayer.setVictoryCard(aPlayer.getHand().peek());
			bPlayer.setVictoryCard(bPlayer.getHand().peek());
			
			//show victorycard
			System.out.println(aPlayer.getNom() + ", your victory card is " + aPlayer.getVictoryCard());
			System.out.println(bPlayer.getNom() + ", your victory card is " + bPlayer.getVictoryCard());
			
			
			//Calculer the Scoring
			System.out.println(getCarpet());
			int aScore = aPlayer.Scoring(getCarpet());
			int bScore = bPlayer.Scoring(getCarpet());
			  
			if (aScore>bScore) {
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
			    System.out.println(aPlayer.getNom() + ", you win!");
			  }
			else if (aScore<bScore) {
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
				System.out.println(bPlayer.getNom() + ", you win!");
			  }
			else {
				System.out.println(aPlayer.getNom() + ", your score: " + aScore);
				System.out.println(bPlayer.getNom() + ", your score: " + bScore);
				System.out.println("Draw");
			  }
			
			

		}

		
	}
	
	/**
	 * pick the hidden card
	 * @see Card
	 */
	//method pick the hidden card is in the gameSetUp
	public void pickTheHiddenCard() {
		while (hiddenCard == null) {
			int index = (int)(Math.random()*deck.getDeck().size());
			//p.setVictoryCard(deck.getDeck().get(index));
			setHiddenCard(deck.getDeck().get(index));
			deck.getDeck().remove(index);
			System.out.println("Already pick the hidden card");
		}
	}
	
	/**
	 * the player's turn(normal version), player can decide what they want to do (Play a card/Move a card)
	 * @param p player
	 * @see Deck
	 * @see Carpet
	 * @see Card
	 */
	public void turn(Player p) {
		if (p.getVictoryCard() == null) {

			p.drawCard(deck);
		}
		if (ifFirstPlay == true) {

			p.drawCard(deck);
			p.playFirstCard(carpet);
			ifFirstPlay = false;
			gameRound++;
		}
		else {
			int i;
			Scanner scanner = new Scanner(System.in);
			System.out.println(p.getNom() + ", Do you want to draw a card(1) or move a card(2) first? ");
			System.out.println("Please enter the number 1) or 2)");
			i = scanner.nextInt();
			//draw a card
			if (i==1) {
				p.drawCard(deck);
				System.out.println("Please play the card");
				p.playCard(carpet);
				System.out.println("Do you want to move the card? Yes(1) or No(2)");
				System.out.println("Please enter the number 1) or 2)");
				i = scanner.nextInt();
				if (i==1) {
					p.moveCard(carpet);
					gameRound++;
					System.out.println(p.getNom() + ", Your turn is over.");
				}
				else {
					gameRound++;
					System.out.println(p.getNom() + ", Your turn is over.");
				}			
			}
			//move a card -> draw a card -> play a card
			else {
				p.moveCard(carpet);
				System.out.println("You have moved a card. Now draw a card");
				p.drawCard(deck);
				System.out.println("Please play the card");
				p.playCard(carpet);
				gameRound++;
				System.out.println(p.getNom() + ", Your turn is over.");	
			}
		}

	}
	/**
	 * the player's turn(advanced version), player can decide what they want to do (Play a card/Move a card)
	 * @param p player
	 * @see Deck
	 * @see Carpet
	 * @see Card
	 */
	public void turnAdvanced(Player p) {
		if (ifFirstPlay == true) {
			p.playFirstCardAdvanced(carpet);
			ifFirstPlay = false;
			gameRound++;
			System.out.println(p.getNom() + ", Your turn is over. Now draw a card to replace the card you played");
			p.drawCardAdvanced(deck);
		}
		else {
			int i;
			Scanner scanner = new Scanner(System.in);
			System.out.println(p.getNom() + ", Do you want to play a card(1) or move a card(2) first? ");
			System.out.println("Please enter the number 1) or 2)");
			i = scanner.nextInt();
			if (i==1) {
				//play a card
				System.out.println("Please play the card");
				p.playCardAdvanced(carpet);
				System.out.println("Do you want to move the card? Yes(1) or No(2)");
				System.out.println("Please enter the number 1) or 2)");
				i = scanner.nextInt();
				if (i==1) {
					p.moveCardAdvanced(carpet);
					gameRound++;
					if (deck.getDeck().size() != 0) {
						System.out.println(p.getNom() + ", Your turn is over. Now draw a card to replace the card you played");
						p.drawCardAdvanced(deck);
					}
					else {
						System.out.println(p.getNom() + ", Your turn is over. No more cards in the deck");
					}
				}
				else {
					gameRound++;
					if (deck.getDeck().size() != 0) {
						System.out.println(p.getNom() + ", Your turn is over. Now draw a card to replace the card you played");
						p.drawCardAdvanced(deck);
					}
					else {
						System.out.println(p.getNom() + ", Your turn is over. No more cards in the deck");
					}
				}			
			}
			//move a card -> draw a card -> play a card
			else {
				p.moveCardAdvanced(carpet);
				System.out.println("You have moved a card. Now play a card");
				System.out.println("Please play the card");
				p.playCardAdvanced(carpet);
				gameRound++;
				if (deck.getDeck().size() != 0) {
					System.out.println(p.getNom() + ", Your turn is over. Now draw a card to replace the card you played");
					p.drawCardAdvanced(deck);
				}
				else {
					System.out.println(p.getNom() + ", Your turn is over. No more cards in the deck");
				}	
			}
			
			
		}
	}
	
	/**
	 * the Computer-player's turn
	 * @param p virtuel player
	 * @see Deck
	 * @see Carpet
	 * @see Card
	 */
	public void comTurn(PlayerVirtuel p) {
		if (p.getVictoryCard() == null) {

			p.drawCard(deck);
		}
		else {
			p.drawCard(deck);
			p.comPlayCard(carpet);
			gameRound++;
			System.out.println("Computer's turn is over.");
		}
		
		
	}
	
	/**
	 * judge if the game is end by seeing the round count and the mode of game
	 * @return true(over) or false(isn't over)
	 */
	public boolean isGameOver() {
		if ((gameMode==1 && gameRound == 15) || (gameMode==2 && gameRound == 15) || (gameMode==4 && gameRound == 15)) {
			System.out.println("The game is over.");
			return true;
		}
		else if (gameMode==3 && gameRound == 14) {
			System.out.println("The game is over.");
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void main(String args[]) {
		Game g = new Game();
		g.chooseMode();
		g.playMode();

	}
}
