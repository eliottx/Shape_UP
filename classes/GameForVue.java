package utt.xjy_szy.lo02_projet.game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
/**
 * The class of the game especially for VUE
 * This class inherits from the Observable
 * The properties are: deck, a-cplayer, players' arraylist, answer, carpet, gameMode, gameRound,
 * hiddenCard, ifFirstPlay, x_play, y_play, x_from, y_from, x_to, y_to, cardPlay, finish, 
 * cardMove, textString
 * @author Jiayin XU
 * @author Zhengyang SU
 * @see Card
 * @see Deck
 * @see Person
 * @see Player
 * @see Carpet
 */
public class GameForVue extends Observable {
	
	private Deck deck;
	private Player aPlayer=new Player("Player a");
	private Player bPlayer=new Player("Player b");;
	private Player cPlayer=new Player("Player c");;
	private ArrayList<Player> players;
	private int answer;
	private Carpet carpet = new Carpet();
	private int gameMode;
	private int gameRound = 0;
	private Card hiddenCard = null;
	private boolean ifFirstPlay = false;
	private int x_play=0;
	private int y_play=0;
	private int x_from;
	private int y_from;
	private int x_to;
	private int y_to;
	
	private boolean cardPlay = false;
	private boolean finish = false;
	private boolean cardMove = false;
	public String textString;
	
	/**
	 * @return the the coordinate x of play position
	 */
	public int getX_play() {
		return x_play;
	}
	
	/**
	 * @param x_play the the coordinate x of play position
	 */
	public void setX_play(int x_play) {
		this.x_play = x_play;
	}

	/**
	 * @return the the coordinate y of play position
	 */
	public int getY_play() {
		return y_play;
	}

	/**
	 * @param y_play the the coordinate y of play position
	 */
	public void setY_play(int y_play) {
		this.y_play = y_play;
	}
	
	/**
	 * @return the the coordinate x of the old position
	 */
	public int getX_from() {
		return x_from;
	}

	/**
	 * @param x_from the the coordinate x of the old position
	 */
	public void setX_from(int x_from) {
		this.x_from = x_from;
	}

	/**
	 * @return the the coordinate y of the old position
	 */
	public int getY_from() {
		return y_from;
	}

	/**
	 * @param y_from the the coordinate y of the old position
	 */
	public void setY_from(int y_from) {
		this.y_from = y_from;
	}

	/**
	 * @return the the coordinate x of the target position
	 */
	public int getX_to() {
		return x_to;
	}
	
	/**
	 * @param x_to the the coordinate x of the target position
	 */
	public void setX_to(int x_to) {
		this.x_to = x_to;
	}

	/**
	 * @return the the coordinate y of the target position
	 */
	public int getY_to() {
		return y_to;
	}

	/**
	 * @param y_to the the coordinate y of the target position
	 */
	public void setY_to(int y_to) {
		this.y_to = y_to;
	}

	/**
	 * @return the mode of game which is chosen by player
	 */
	public int getGameMode() {
		return gameMode;
	}

	/**
	 * @param gameMode the mode of game which is chosen by player
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
	 * @return the choice of player
	 */
	public int getAnswer() {
		return answer;
	}

	/**
	 * @param answer the choice of player
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}

	/**
	 * @return the hidden card of the game
	 * @see Card
	 */
	public Card getHiddenCard() {
		return hiddenCard;
	}

	/**
	 * @param hiddenCard the hidden card of the game
	 * @see Card
	 */
	public void setHiddenCard(Card hiddenCard) {
		this.hiddenCard = hiddenCard;
	}

	/**
	 * @return the deck of the game
	 * @see Deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @param deck the deck of the game
	 * @see Deck
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	/**
	 * @return the carpet of the game
	 * @see Carpet
	 */
	public Carpet getCarpet() {
		return carpet;
	}

	/**
	 * @param carpet the carpet of the game
	 * @see Carpet
	 */
	public void setCarpet(Carpet carpet) {
		this.carpet = carpet;
	}

	/**
	 * @return the player a of the game
	 * @see Person
	 * @see Player
	 */
	public Player getaPlayer() {
		return aPlayer;
	}

	/**
	 * @param aPlayer the player a of the game
	 * @see Person
	 * @see Player
	 */
	public void setaPlayer(Player aPlayer) {
		this.aPlayer = aPlayer;
	}

	/**
	 * @return the player b of the game
	 * @see Person
	 * @see Player
	 */
	public Player getbPlayer() {
		return bPlayer;
	}

	/**
	 * @param bPlayer the player b of the game
	 * @see Person
	 * @see Player
	 */
	public void setbPlayer(Player bPlayer) {
		this.bPlayer = bPlayer;
	}

	/**
	 * @return if the card is played(true or false)
	 */
	public boolean isCardPlay() {
		return cardPlay;
	}

	/**
	 * @param cardPlay true or false
	 */
	public void setCardPlay(boolean cardPlay) {
		this.cardPlay = cardPlay;
	}

	/**
	 * @return if the card is moved(true or false)
	 */
	public boolean isCardMove() {
		return cardMove;
	}

	/**
	 * @param cardMove true or false
	 */
	public void setCardMove(boolean cardMove) {
		this.cardMove = cardMove;
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
	 * pick the hidden card
	 * @see Card
	 */
	public void pickTheHiddenCard() {
		while (hiddenCard == null) {
			int index = (int)(Math.random()*deck.getDeck().size());
			setHiddenCard(deck.getDeck().get(index));
			deck.getDeck().remove(index);
			System.out.println("Already pick the hidden card");
		}
	}
	
	/**
	 * play a card
	 * @param player the player
	 * @see Card
	 * @see Carpet
	 */
	public void playCard(Player player) {
		player.playCardForVue(getX_play(), getY_play(), getCarpet());
		gameRound = gameRound +1;
			
		
	}
	/**
	 * the player's turn, player can decide what they want to do (Play a card/Move a card)
	 * @param p player
	 * @see Deck
	 * @see Carpet
	 * @see Card
	 */
	public void Turn(Player p) {
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
	 * the game for vue
	 */
	public synchronized void playForVue() {
		gameSetup();
		pickTheHiddenCard();
		System.out.println(getCarpet());
		
		if (aPlayer.getVictoryCard() == null) {
			aPlayer.drawCard(deck);
		}

		if (bPlayer.getVictoryCard() == null) {

			bPlayer.drawCard(deck);
		}
		
		while (!IsGameOver()) {

			
			if (ifFirstPlay == false) {
				aPlayer.drawCard(deck);
				aPlayer.playFirstCard(carpet);
				getCarpet().refresh();
				notice();
				gameRound++;
				ifFirstPlay = true;
				System.out.println(getCarpet());
			}
			else {
				
				textString = "b Player's Turn";
				bPlayer.drawCard(deck);
				notice();

				try {
					this.wait();
				} catch (Exception e) {
					// TODO: handle exception
				}

				textString = "a Player's Turn";
				aPlayer.drawCard(deck);
				notice();
				try {
					this.wait();
				} catch (Exception e) {
					// TODO: handle exception
				}

				if (IsGameOver()) {
					break;

				   }	
			}

		  }
		int aScore = aPlayer.Scoring(getCarpet());
		int bScore = bPlayer.Scoring(getCarpet());
		  
		if (aScore>bScore) {
		   System.out.println(aPlayer.getNom() + ", you win!");
		  }
		else if (aScore<bScore) {
		 System.out.println(bPlayer.getNom() + ", you win!");
		  }
		else {
		System.out.println("Draw");
		  }

	}
	
	/**
	 * judge if the game is over
	 * @return true or false
	 */
	public boolean IsGameOver() {
		if (gameRound == 15) {
			System.out.println("The game is over.");
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * notify the observer
	 */
	public void notice() {
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * change the statu when finishes
	 */
	public synchronized void finish() {
		if (cardPlay==false) {
			System.out.println("You have to play a card");
		}else {
			cardPlay = false;
			this.finish = true;
			cardMove = false;
			notifyAll();
		}
	}
	
	public static void main(String arg[]) {
		GameForVue gameForVue = new GameForVue();
		gameForVue.playForVue();
	}
	

}
