package utt.xjy_szy.lo02_projet.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;

/**
 * 
 * The Carpet class, the properties are: 11 Arraylists, 
 * maxLine, maxColumn, nullCard, carpet
 * @author Jiayin XU
 * @author Zhengyang SU
 * @see Card
 */
public class Carpet extends Observable{
	private List<Card> carpetColumn1 = new ArrayList<>();
	private List<Card> carpetColumn2 = new ArrayList<>();
	private List<Card> carpetColumn3 = new ArrayList<>();
	private List<Card> carpetColumn4 = new ArrayList<>();
	private List<Card> carpetColumn5 = new ArrayList<>();
	private List<Card> carpetColumn6 = new ArrayList<>();
	private List<Card> carpetColumn7 = new ArrayList<>();
	private List<Card> carpetColumn8 = new ArrayList<>();
	private List<Card> carpetColumn9 = new ArrayList<>();
	private List<Card> carpetColumn10 = new ArrayList<>();
	private List<Card> carpetColumn11 = new ArrayList<>();
	public int maxLine;
	public int maxColumn;
	
	private final Card nullCard = new Card(null,null,null,0);
	
	private List<List<Card>> carpet = new ArrayList<>();
	
	/**
	 * @return the nullCard
	 * @see Card
	 */
	public Card getNullCard() {
		return nullCard;
	}
	
	/**
	 * @return the carpet
	 * @see Card
	 */
	public List<List<Card>> getCarpetLine() {
		return carpet;
	}

	/**
	 * @param carpet the carpet
	 * @see Card
	 */
	public void setCarpetLine(List<List<Card>> carpet) {
		this.carpet = carpet;

	}
	
	
	/**
	 * Update the maximum border length of the board
	 * @see Card
	 */
	public void updateMaxEdge() {
		ArrayList<Integer> line = new ArrayList<>();
		ArrayList<Integer> column = new ArrayList<>();
		
		
		for (Iterator<List<Card>> iterator = carpet.iterator(); iterator.hasNext();) {
			List<Card> list = iterator.next();
			for (Iterator<Card> iterator2 = list.iterator(); iterator2.hasNext();) {
				Card card2 = iterator2.next();
				if (card2.getId() != 0) {// the position (x,y) is not empty
					line.add(card2.getX());
					column.add(card2.getY());//save the card coordinates to the arrays.
				}
			}
		}
		Collections.sort(line);
		Collections.sort(column);    //Sort the numbers in the array from smallest to largest
		
		this.maxLine = line.get(line.size()-1) - line.get(0) + 1;
		this.maxColumn = column.get(column.size()-1) - column.get(0) + 1; //update the max number
	}
	/**
	 * The constructor of Carpet class without parameters
	 * Set all positions as nullCard
	 * @see Card
	 */
	public Carpet() {
		
			for(int j=0; j<11; j++) {
				carpetColumn1.add(nullCard);
				carpetColumn2.add(nullCard);
				carpetColumn3.add(nullCard);
				carpetColumn4.add(nullCard);
				carpetColumn5.add(nullCard);
				carpetColumn6.add(nullCard);
				carpetColumn7.add(nullCard);
				carpetColumn8.add(nullCard);
				carpetColumn9.add(nullCard);
				carpetColumn10.add(nullCard);
				carpetColumn11.add(nullCard);
			}
			carpet.add(0,carpetColumn1);
			carpet.add(1,carpetColumn2);
			carpet.add(2,carpetColumn3);
			carpet.add(3,carpetColumn4);
			carpet.add(4,carpetColumn5);
			carpet.add(5,carpetColumn6);
			carpet.add(6,carpetColumn7);
			carpet.add(7,carpetColumn8);
			carpet.add(8,carpetColumn9);
			carpet.add(9,carpetColumn10);
			carpet.add(10,carpetColumn11);
		
	}
	
	/**
	 * print the id of card
	 * @see Card
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Iterator<List<Card>> iter = carpet.iterator(); iter.hasNext();) {
			List<Card> c = iter.next();
			for(Iterator<Card> iter1 = c.iterator(); iter1.hasNext();) {
				Integer i = iter1.next().getId();
				sb.append(i+" ");
			}
			sb.append("\n");
			
		}
		return sb.toString();
	}
	
	/**
	 * play a card with its coordinates
	 * @see Card
	 * @param x the coordinate x of card
	 * @param y the coordinate y of card
	 * @param c the card
	 */
	public void playAcard(int x, int y, Card c) {
		carpet.get(x).set(y, c);
		c.setX(x);
		c.setY(y);
	}
	
	
	/**
	 * get the card in position (x,y)
	 * @return the card in position (x,y)
	 * @param x the coordinate x of card
	 * @param y the coordinate y of card
	 * @see Card
	 */
	public Card getCard(int x, int y) {
		Card card = carpet.get(x).get(y);
		return card;
	}
	
	/**
	 * play the first card in (5,5) when starts
	 * @param c the card
	 * @see Card
	 */
	public void playFirstcard(Card c) {
		carpet.get(5).set(5, c);
		c.setX(5);
		c.setY(5);
		this.setChanged();
		this.notifyObservers();
		
	}
	
	/**
	 * judge if the position (x,y) is fit to play a card
	 * @param x the coordinate x of card
	 * @param y the coordinate y of card
	 * @param card the card
	 * @see Card
	 * @return true(can play) or false(can't play)
	 */
	public boolean ifCanPlay(int x, int y, Card card) {
		//up,down,left,right
		int up = carpet.get(x).get(y-1).getId();
		int down = carpet.get(x).get(y+1).getId();
		int left = carpet.get(x-1).get(y).getId();
		int right = carpet.get(x+1).get(y).getId();
		boolean flag = false;
		
		//out of range
		if (x < 0 || x > 10 || y < 0 || y > 10) {
			//throw exception(illegal!)
			System.out.println("Coordinates " + "(" + x + "," + y + ")" + " is out of carpet!");
			return flag;
		}
		
		
		//already exists a card
		if (getCard(x, y).getId() != 0) {
			System.out.println("Already exists a card");
			return flag;
		}
		else {//not out of range, and no card in position
			if (up != 0 || down != 0 || left != 0 || right != 0) {//satisfy orthogonal conditions
				flag = true;
				//if exceeds the carpet of 5*3
				playAcard(x, y, card);
				updateMaxEdge();
				if ((maxColumn > 3 && maxLine > 3) || maxColumn > 5 || maxLine > 5) {
					System.out.println("The position " + "(" + x + "," + y + ")" + "that you want to play exceeds the carpet of 5*3");
					deleteACard(x, y, card);
					flag = false;
				}
				else {
					
				}
			}
			else {
				flag = false;
				System.out.println("The position that you want to play " + "(" + x + "," + y + ")" + " doesn't satisfy orthogonal conditions");
				return flag;
			}
		}
		return flag;
	}
				
	/**
	 * judge if the card in position(x_from,y_from) is able to be moved to (x_to, y_to)
	 * @param x_from the old coordinate x of card
	 * @param y_from the old coordinate y of card
	 * @param x_to the target coordinate x of card
	 * @param y_to the target coordinate y of card
	 * @see Card
	 * @return true(can move) or false(can't move)
	 */
	public boolean ifCanMove(int x_from,int y_from, int x_to,int y_to) {
		boolean flag = false;
		Card tempCard = getCard(x_from, y_from);
		
		if (getCard(x_from, y_from).getId() != 0) {
			tempCard = getCard(x_from, y_from);
		}
		else {
			flag = false;
			return flag;
		}
		
		deleteACard(x_from, y_from, tempCard);
		if (ifCanPlay(x_to, y_to, tempCard)) {
			flag = true;
		}
		else {
			flag = false;
		}
		
		playAcard(x_to, y_to, tempCard);
		return flag;
		
		
		
	
	}
	
	
	/**
	 * delete the card in position (x,y)
	 * @param x the coordinate x of card
	 * @param y the coordinate y of card
	 * @param c the card
	 * @see Card
	 */
	public void deleteACard(int x, int y, Card c) {
		for(Iterator<List<Card>> iter = carpet.iterator(); iter.hasNext();) {
			List<Card> c1 = iter.next();
			for(Iterator<Card> iter1 = c1.iterator(); iter1.hasNext();) {
				Integer temp = iter1.next().getId();
				if (temp == c.getId()) {
					carpet.get(c.getX()).set(c.getY(), nullCard);
				}
			}
		}
	}
	
	/**
	 * judge if there're already 15 cards on the carpet
	 * @see Card
	 * @return the judgement
	 */
	public boolean ifFullCarpet() {
		//Set Counter
		int cal = 0;
		for (Iterator<List<Card>> iterator = carpet.iterator(); iterator.hasNext();) {
			List<Card> list = iterator.next();
			for (Iterator<Card> iterator2 = list.iterator(); iterator2.hasNext();) {
				cal = iterator2.next().getId();	
				if (cal != 0) {
					cal++;
				}
			}
		}
		//Determine if there are 15 cards on the carpet.
		if (cal == 15) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * refresh the carpet, move the upper left corner of the current board to (2,2)
	 * @see Card
	 */
	public void refresh() {
		int min_x = 11;
		int min_y = 11;
		Card tempCard[][] = new Card[11][11]; 

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (carpet.get(i).get(j) != nullCard ) {
					if (carpet.get(i).get(j).getX() < min_x) {
						min_x = carpet.get(i).get(j).getX();
					}
					if (carpet.get(i).get(j).getY() < min_y) {
						min_y = carpet.get(i).get(j).getY();
					}
				}
			}
		}
		//initialize
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				tempCard[i][j] = nullCard;
			}
		}
		//store che cards in tempCard
		int a = 2;
		int b = 2;
		for (int i = min_x; i < min_x+5; i++) {
			for (int j = min_y; j < min_y+5; j++) {
				tempCard[a][b]=carpet.get(i).get(j);
				b++;
			}
			a++;
			b=2;
		}
		//clear the carpet
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				carpet.get(i).set(j, nullCard);
			}
		}
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				carpet.get(i).set(j, tempCard[i][j]);
				carpet.get(i).get(j).setX(i);
				carpet.get(i).get(j).setY(j);
			}
		}
	}
}
