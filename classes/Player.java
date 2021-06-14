package utt.xjy_szy.lo02_projet.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;




/**
 * the Class of Player
 * this class inherits from the Person class
 * @see Person
 * @see Card
 */
public class Player extends Person {
	
	/**
	 * the constructor of Player Class
	 * @param nom the name of player
	 * @see Person
	 */
	public Player(String nom) {
		this.setNom(nom);
		this.setTotalScore(0);
		this.setHand(getHand());
	}
	
	/**
	 * print the information of player
	 */
	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(getNom());
		sBuffer.append(" : ");
		sBuffer.append(getHand());
		sBuffer.append("\n");
		return sBuffer.toString();
		
	}
	
}
