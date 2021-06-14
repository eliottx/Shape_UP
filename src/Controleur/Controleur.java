package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;

import utt.xjy_szy.lo02_projet.game.Card;
import utt.xjy_szy.lo02_projet.game.Carpet;
import utt.xjy_szy.lo02_projet.game.Game;
import utt.xjy_szy.lo02_projet.game.GameForVue;
import utt.xjy_szy.lo02_projet.game.Person;

/**
 * the Controleur Class, the Observer Pattern
 * @author Jiayin XU
 * @author Zhengyang SU
 */
public class Controleur {
	
	private GameForVue game;
	private JButton playButton;
	private JButton moveButton;
	private JButton fromButton;
	private JButton toButton;
	private JButton finishButton;
	private JButton startButton;
	private JButton modeButton;
	private JButton backButton;
	private JPanel menu;
	private JPanel chessBoard;
	private JPanel chooseMode;
	
	
	
	
	/**
	 * the Controleur Class, the Observer Pattern
	 * @param g GameForVue
	 * @param menu menu panel
	 * @param chessboard chessboard panel
	 * @param choosemode mode panel
	 * @param playButton play button
	 * @param moveButton move button
	 * @param fromButton the from button
	 * @param toButton the to button
	 * @param startButton the start button
	 * @param modeButton the mode button
	 * @param finishButton the finish button
	 * @param backButton the back button
	 * @see GameForVue
	 */
	public Controleur(GameForVue g, JPanel menu, JPanel chessboard, JPanel choosemode, JButton playButton, JButton moveButton, JButton fromButton,JButton toButton, JButton finishButton,JButton startButton,JButton modeButton,JButton backButton ) {
		this.game = g;
		this.playButton = playButton;
		this.moveButton = moveButton;
		this.toButton = toButton;
		this.fromButton = fromButton;
		this.finishButton = finishButton;
		this.startButton = startButton;
		this.modeButton = modeButton;

		this.chessBoard = chessboard;
		this.chooseMode = choosemode;
		this.menu = menu;
		
		//start button
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.setVisible(false);
				chooseMode.setVisible(false);
				chessBoard.setVisible(true);
				game.getCarpet().refresh();
				game.notice();
				System.out.println(game.getCarpet());

			}
		});
		
		//move button
				moveButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						moveButton.setVisible(false);
						fromButton.setVisible(true);
						toButton.setVisible(true);
					}
				});
		
		//from button
				fromButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						game.setX_from(game.getX_play());
						game.setY_from(game.getY_play());
						
					}
				} );
				
		
		//to button
				toButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						game.setX_to(game.getX_play());
						game.setY_to(game.getY_play());
						if (game.isCardMove() == false && game.getCarpet().ifCanMove(game.getX_from(), game.getY_from(), game.getX_to(), game.getY_to())) {
							game.getaPlayer().moveCardForVue(game.getX_from(), game.getY_from(), game.getX_to(), game.getY_to(), game.getCarpet());
							game.setCardMove(true);
							System.out.println("Succeed moving");
						}
						else {
							System.out.println("Move failed,Please move again.");
						}
						
						game.getCarpet().refresh();
						game.notice();
						
						moveButton.setVisible(true);
						fromButton.setVisible(false);
						toButton.setVisible(false);
					}
				});
		
		


		
				
		//finish button
		finishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.finish();
			}
		});
		
		//play a card button
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int a = game.getX_play();
				int b = game.getY_play();
				if (game.getGameRound()%2 == 1 ) {
					//haven't played a card
					if (game.getX_play()==0 || game.getY_play() ==0) {
						game.textString = "You have not selected coordinates.";
						return;
					}
					if (! game.getCarpet().ifCanPlay(a, b, game.getCarpet().getCard(a, b))) {
						game.textString = "Location is illegal, please reselect the coordinates for placing this card.";
						return;
					}
					if (game.getbPlayer().getHand().size() != 0) {
						game.playCard(game.getbPlayer());
						game.setCardPlay(true);
						game.getCarpet().refresh();
						try {
							TimeUnit.MILLISECONDS.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						game.notice();
					}
					
				}
				else if (game.getGameRound()%2 == 0) {
					
					if (game.getX_play()==0 || game.getY_play() ==0) {
						System.out.println("You have not selected coordinates.");
						return;
					}
					if (! game.getCarpet().ifCanPlay(a, b, game.getCarpet().getCard(a, b))) {
						System.out.println("Location is illegal, please reselect the coordinates for placing this card.");
						return;
					}
					if (game.getaPlayer().getHand().size() != 0) {
						game.playCard(game.getaPlayer());
						game.setCardPlay(true);
						game.getCarpet().refresh();
						try {
							TimeUnit.MILLISECONDS.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						game.notice();
					}
				}

			}
		});
		
		
		
	}
	

	

}
