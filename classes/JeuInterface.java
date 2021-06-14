package Vue;

import java.awt.EventQueue;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.MenuElement;

import Controleur.Controleur;
import utt.xjy_szy.lo02_projet.game.Card;
import utt.xjy_szy.lo02_projet.game.Carpet;
import utt.xjy_szy.lo02_projet.game.Game;
import utt.xjy_szy.lo02_projet.game.GameForVue;
import utt.xjy_szy.lo02_projet.game.Person;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * the JeuInterface Class, the Observer Pattern
 * @author Jiayin XU
 * @author Zhengyang SU
 */
public class JeuInterface implements Observer{
	
	// Les propriete de la classe
	private JFrame frame;
	
	//menu
	private JPanel menu;
	private JLabel title;
	private JButton startButton;
	private JButton modeButton;
	Icon defaultIcon = new ImageIcon(getClass().getResource("/Image/base.jpg"));
	
	//mode
	private JPanel chooseMode;
	private JRadioButton modeButton1;
	private JRadioButton modeButton2;
	private JRadioButton modeButton3;
	private JRadioButton modeButton4;
	private JButton modeConfireButton;
	
	//chessboard
	private JPanel chessBoard;
	private JLabel[][] labelArray = new JLabel[10][10];
	private JButton playButton;
	private JButton moveButton;
	private JButton finishButton;
	private JButton toButton;
	private JButton fromButton;
	
	private JLabel lblPointaPlayer;
	private JLabel lblPointbPlayer;
	
	private JLabel lblAPhoto;
	private JLabel lblBPhoto;
	
	private JLabel lblText;
	
	private JLabel l1_1;
	private JLabel l1_2;
	private JLabel l1_3;
	private JLabel l1_4;
	private JLabel l1_5;
	private JLabel l1_6;
	private JLabel l1_7;
	private JLabel l1_8;
	private JLabel l1_9;
	private JLabel l2_1;
	private JLabel l2_2;
	private JLabel l2_3;
	private JLabel l2_4;
	private JLabel l2_5;
	private JLabel l2_6;
	private JLabel l2_7;
	private JLabel l2_8;
	private JLabel l2_9;
	private JLabel l3_1;
	private JLabel l3_2;
	private JLabel l3_3;
	private JLabel l3_4;
	private JLabel l3_5;
	private JLabel l3_6;
	private JLabel l3_7;
	private JLabel l3_8;
	private JLabel l3_9;
	private JLabel l4_1;
	private JLabel l4_2;
	private JLabel l4_3;
	private JLabel l4_4;
	private JLabel l4_5;
	private JLabel l4_6;
	private JLabel l4_7;
	private JLabel l4_8;
	private JLabel l4_9;
	private JLabel l5_1;
	private JLabel l5_2;
	private JLabel l5_3;
	private JLabel l5_4;
	private JLabel l5_5;
	private JLabel l5_6;
	private JLabel l5_7;
	private JLabel l5_8;
	private JLabel l5_9;
	private JLabel l6_1;
	private JLabel l6_2;
	private JLabel l6_3;
	private JLabel l6_4;
	private JLabel l6_5;
	private JLabel l6_6;
	private JLabel l6_7;
	private JLabel l6_8;
	private JLabel l6_9;
	private JLabel l7_1;
	private JLabel l7_2;
	private JLabel l7_3;
	private JLabel l7_4;
	private JLabel l7_5;
	private JLabel l7_6;
	private JLabel l7_7;
	private JLabel l7_8;
	private JLabel l7_9;
	private JLabel l8_1;
	private JLabel l8_2;
	private JLabel l8_3;
	private JLabel l8_4;
	private JLabel l8_5;
	private JLabel l8_6;
	private JLabel l8_7;
	private JLabel l8_8;
	private JLabel l8_9;
	private JLabel l9_1;
	private JLabel l9_2;
	private JLabel l9_3;
	private JLabel l9_4;
	private JLabel l9_5;
	private JLabel l9_6;
	private JLabel l9_7;
	private JLabel l9_8;
	private JLabel l9_9;
	private JLabel ylabel1;
	private JLabel ylabel2;
	private JLabel ylabel3;
	private JLabel ylabel4;
	private JLabel ylabel5;
	private JLabel ylabel6;
	private JLabel ylabel7;
	private JLabel ylabel8;
	private JLabel ylabel9;
	private JLabel xlabel1;
	private JLabel xlabel2;
	private JLabel xlabel3;
	private JLabel xlabel4;
	private JLabel xlabel5;
	private JLabel xlabel6;
	private JLabel xlabel7;
	private JLabel xlabel8;
	private JLabel xlabel9;
	
	//game
	GameForVue game = new GameForVue();
	private JLabel lblaVictoryCardText;
	private JLabel lblbVictoryCardText;
	private JLabel lblaVictoryCard;
	private JLabel lblbVictoryCard;

	/**
	 * update the game interface
	 * @param instanceObservable the observabel instance
	 * @param arg1 Object
	 */
	public void update(Observable instanceObservable, Object arg1) {
		
		//update the text
		lblText.setText(game.textString);
		
		//display the score
		this.lblPointaPlayer.setText("a Player's point: " + game.getaPlayer().Scoring(game.getCarpet()));
		this.lblPointbPlayer.setText("b Player's point: " + game.getbPlayer().Scoring(game.getCarpet()));
		
		//update player's draw card
		if (game.getaPlayer().getHand().size() != 0) {
			ImageIcon icon_AplayerIcon = new ImageIcon(getClass().getResource(game.getaPlayer().getHand().get(0).getPath()));
			lblAPhoto.setIcon(icon_AplayerIcon);
		}
		if (game.getbPlayer().getHand().size() != 0) {
			ImageIcon icon_BplayerIcon = new ImageIcon(getClass().getResource(game.getbPlayer().getHand().get(0).getPath()));
			lblBPhoto.setIcon(icon_BplayerIcon);
		}
		
		//update Vitcory card
		ImageIcon aVictoryCard = new ImageIcon(getClass().getResource(game.getaPlayer().getVictoryCard().getPath()));
		lblaVictoryCard.setIcon(aVictoryCard);
		ImageIcon bVictoryCard = new ImageIcon(getClass().getResource(game.getbPlayer().getVictoryCard().getPath()));
		lblbVictoryCard.setIcon(bVictoryCard);
		
		
		//display the image of card
			int weight = 30;
			int height = 30;
				for (int i = 1; i <10; i++) {
					for (int j = 1; j < 10; j++) {
						if (game.getCarpet().getCard(i, j) != game.getCarpet().getNullCard()) {
							ImageIcon imageCard = new ImageIcon(getClass().getResource(game.getCarpet().getCard(i, j).getPath()));
							imageCard.setImage(imageCard.getImage().getScaledInstance(weight, height, Image.SCALE_DEFAULT));
							labelArray[i][j].setIcon(imageCard);
						}
						if (game.getCarpet().getCard(i, j) == game.getCarpet().getNullCard()) {
							labelArray[i][j].setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
						}
					}
				}
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GameForVue game = new GameForVue();

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JeuInterface window = new JeuInterface(game);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		game.playForVue();
	
	}

	/**
	 * Create the application.
	 * @param gameForVue the game for Vue
	 */
	public JeuInterface(GameForVue gameForVue) {
		game = gameForVue;
		game.getCarpet().addObserver(this);
		game.addObserver(this);
		initialize();
		Controleur controleur = new Controleur(game, menu, chessBoard, chooseMode, playButton, moveButton,fromButton, toButton, finishButton, startButton, modeButton,modeConfireButton);
		

		

		

		

		
		
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 833, 637);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		menu = new JPanel();
		menu.setBounds(10, 10, 799, 580);
		frame.getContentPane().add(menu);
		menu.setLayout(null);
		menu.setVisible(true);

		chooseMode = new JPanel();
		chooseMode.setBounds(10, 10, 799, 580);
		frame.getContentPane().add(chooseMode);
		chooseMode.setLayout(null);
		chooseMode.setVisible(false);
 
 
		
		chessBoard = new JPanel();
		chessBoard.setBounds(10, 10, 799, 580);
		frame.getContentPane().add(chessBoard);
		chessBoard.setLayout(null);
		chessBoard.setVisible(false);
		
		
		
		////////////////////////////////////////menu//////////////////////
		title = new JLabel("SHAPE UP!");
		title.setFont(new Font("Arial Black", Font.PLAIN, 30));
		title.setBounds(290, 51, 222, 74);
		menu.add(title);
		
		startButton = new JButton("START");
		
		
		startButton.setFont(new Font("Arial Black", Font.PLAIN, 25));
		startButton.setBounds(290, 135, 222, 49);
		menu.add(startButton);
		
		modeButton = new JButton("MODE");
		modeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.setVisible(false);
				chooseMode.setVisible(true);
				chessBoard.setVisible(false);
			}
		});
		modeButton.setFont(new Font("Arial Black", Font.PLAIN, 25));
		modeButton.setBounds(290, 214, 222, 49);
		menu.add(modeButton);
 
 
		
		
		
		///////////////////////////choosemode/////////////////////////////
		modeButton1 = new JRadioButton("    2 Players",true);
		modeButton1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		modeButton1.setBounds(214, 69, 380, 62);
		chooseMode.add(modeButton1);
		
		modeButton2 = new JRadioButton("    1 Player vs 1 Player Virtuel");
		modeButton2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		modeButton2.setBounds(214, 150, 380, 62);
		chooseMode.add(modeButton2);
		
		modeButton3 = new JRadioButton("    3 Players");
		modeButton3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		modeButton3.setBounds(214, 228, 380, 62);
		chooseMode.add(modeButton3);
		
		modeButton4 = new JRadioButton("    Avanc\u00E9");
		modeButton4.setFont(new Font("Arial Black", Font.PLAIN, 20));
		modeButton4.setBounds(214, 310, 380, 62);
		chooseMode.add(modeButton4);
		
		ButtonGroup group=new ButtonGroup();
		group.add(modeButton1);
		group.add(modeButton2);
		group.add(modeButton3);
		group.add(modeButton4);
		
		modeConfireButton = new JButton("BACK");
		modeConfireButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.setVisible(true);
				chooseMode.setVisible(false);
				chessBoard.setVisible(false);
			}
		});
		
		modeConfireButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		modeConfireButton.setBounds(224, 378, 229, 69);
		chooseMode.add(modeConfireButton);
 
 
		
		
		
		////////////////////////////chessboard////////////////////////////
		playButton = new JButton("Play A Card");
		playButton.setFont(new Font("Arial", Font.PLAIN, 20));
		playButton.setBounds(32, 518, 150, 52);
		chessBoard.add(playButton);
		
		moveButton = new JButton("Move A Card");
		moveButton.setFont(new Font("Arial", Font.PLAIN, 20));
		moveButton.setBounds(194, 518, 164, 52);
		chessBoard.add(moveButton);
		
		fromButton = new JButton("FROM");
		fromButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		fromButton.setBounds(368, 490, 133, 40);
		chessBoard.add(fromButton);
		fromButton.setVisible(false);
		
		toButton = new JButton("TO");
		toButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		toButton.setBounds(368, 534, 133, 40);
		chessBoard.add(toButton);
		toButton.setVisible(false);
		
		finishButton = new JButton("Finish");
		finishButton.setFont(new Font("Arial", Font.PLAIN, 20));
		finishButton.setBounds(619, 518, 143, 52);
		chessBoard.add(finishButton);
		
		lblPointaPlayer = new JLabel("a Player's Point:");
		lblPointaPlayer.setBounds(509, 17, 242, 23);
		chessBoard.add(lblPointaPlayer);
		
		lblPointbPlayer = new JLabel("b Player's point");
		lblPointbPlayer.setBounds(509, 202, 242, 23);
		chessBoard.add(lblPointbPlayer);
		
		lblAPhoto = new JLabel("");
		lblAPhoto.setIcon(new ImageIcon(JeuInterface.class.getResource("/Image/base.jpg")));
		lblAPhoto.setBounds(509, 52, 100, 100);
		chessBoard.add(lblAPhoto);
		
		lblBPhoto = new JLabel("");
		lblBPhoto.setIcon(new ImageIcon(JeuInterface.class.getResource("/Image/base.jpg")));
		lblBPhoto.setBounds(509, 237, 100, 100);
		chessBoard.add(lblBPhoto);
		
		lblaVictoryCardText = new JLabel("Victory Card");
		lblaVictoryCardText.setBounds(679, 17, 100, 23);
		chessBoard.add(lblaVictoryCardText);
		
		lblbVictoryCardText = new JLabel("Victory Card");
		lblbVictoryCardText.setBounds(679, 205, 100, 23);
		chessBoard.add(lblbVictoryCardText);
		
		lblaVictoryCard = new JLabel("New label");
		lblaVictoryCard.setIcon(new ImageIcon(JeuInterface.class.getResource("/Image/base.jpg")));
		lblaVictoryCard.setBounds(679, 52, 100, 100);
		chessBoard.add(lblaVictoryCard);
		
		lblbVictoryCard = new JLabel("New label");
		lblbVictoryCard.setIcon(new ImageIcon(JeuInterface.class.getResource("/Image/base.jpg")));
		lblbVictoryCard.setBounds(679, 237, 100, 100);
		chessBoard.add(lblbVictoryCard);
		
		lblText = new JLabel("");
		lblText.setBounds(509, 369, 270, 91);
		chessBoard.add(lblText);

		
		l1_1 = new JLabel("New label");
		
		l1_1.setBackground(Color.WHITE);
		l1_1.setBounds(10, 10, 30, 30);
		chessBoard.add(l1_1);
		l1_1.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		//l1_1.setIcon(new ImageIcon(getClass().getResource("/Image/Card(BLUE,FILLED,CIRCLE).png")));
		labelArray[1][1] = l1_1;
		
		l1_2 = new JLabel("New label");
		l1_2.setBackground(Color.WHITE);
		l1_2.setBounds(60, 10, 30, 30);
		chessBoard.add(l1_2);
		l1_2.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[1][2] = l1_2;
		
		l1_3 = new JLabel("New label");
		l1_3.setBackground(Color.WHITE);
		l1_3.setBounds(110, 10, 30, 30);
		chessBoard.add(l1_3);
		l1_3.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[1][3] = l1_3;
		
		l1_4 = new JLabel("New label");
		l1_4.setBackground(Color.WHITE);
		l1_4.setBounds(160, 10, 30, 30);
		chessBoard.add(l1_4);
		l1_4.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[1][4] = l1_4;
		
		l1_5 = new JLabel("New label");
		l1_5.setBackground(Color.WHITE);
		l1_5.setBounds(210, 10, 30, 30);
		chessBoard.add(l1_5);
		l1_5.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[1][5] = l1_5;
		
		l1_6 = new JLabel("New label");
		l1_6.setBackground(Color.WHITE);
		l1_6.setBounds(260, 10, 30, 30);
		chessBoard.add(l1_6);
		l1_6.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[1][6] = l1_6;
		
		l1_7 = new JLabel("New label");
		l1_7.setBackground(Color.WHITE);
		l1_7.setBounds(310, 10, 30, 30);
		chessBoard.add(l1_7);
		l1_7.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[1][7] = l1_7;
		
		l1_8 = new JLabel("New label");
		l1_8.setBackground(Color.WHITE);
		l1_8.setBounds(360, 10, 30, 30);
		chessBoard.add(l1_8);
		l1_8.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[1][8] = l1_8;
		
		l1_9 = new JLabel("New label");
		l1_9.setBackground(Color.WHITE);
		l1_9.setBounds(410, 10, 30, 30);
		chessBoard.add(l1_9);
		l1_9.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[1][9] = l1_9;
		
		l2_1 = new JLabel("New label");
		l2_1.setBackground(Color.WHITE);
		l2_1.setBounds(10, 60, 30, 30);
		chessBoard.add(l2_1);
		l2_1.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[2][1] = l2_1;
		
		l2_2 = new JLabel("New label");
		l2_2.setBackground(Color.WHITE);
		l2_2.setBounds(60, 60, 30, 30);
		chessBoard.add(l2_2);
		l2_2.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[2][2] = l2_2;
		
		l2_3 = new JLabel("New label");
		l2_3.setBackground(Color.WHITE);
		l2_3.setBounds(110, 60, 30, 30);
		chessBoard.add(l2_3);
		l2_3.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[2][3] = l2_3;
		
		l2_4 = new JLabel("New label");
		l2_4.setBackground(Color.WHITE);
		l2_4.setBounds(160, 60, 30, 30);
		chessBoard.add(l2_4);
		l2_4.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[2][4] = l2_4;
		
		l2_5 = new JLabel("New label");
		l2_5.setBackground(Color.WHITE);
		l2_5.setBounds(210, 60, 30, 30);
		chessBoard.add(l2_5);
		l2_5.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[2][5] = l2_5;
		
		l2_6 = new JLabel("New label");
		l2_6.setBackground(Color.WHITE);
		l2_6.setBounds(260, 60, 30, 30);
		chessBoard.add(l2_6);
		l2_6.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[2][6] = l2_6;
		
		l2_7 = new JLabel("New label");
		l2_7.setBackground(Color.WHITE);
		l2_7.setBounds(310, 60, 30, 30);
		chessBoard.add(l2_7);
		l2_7.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[2][7] = l2_7;
		
		l2_8 = new JLabel("New label");
		l2_8.setBackground(Color.WHITE);
		l2_8.setBounds(360, 60, 30, 30);
		chessBoard.add(l2_8);
		l2_8.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[2][8] = l2_8;
		
		l2_9 = new JLabel("New label");
		l2_9.setBackground(Color.WHITE);
		l2_9.setBounds(410, 60, 30, 30);
		chessBoard.add(l2_9);
		l2_9.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[2][9] = l2_9;
		
		l3_1 = new JLabel("New label");
		l3_1.setBackground(Color.WHITE);
		l3_1.setBounds(10, 110, 30, 30);
		chessBoard.add(l3_1);
		l3_1.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[3][1] = l3_1;
		
		l3_2 = new JLabel("New label");
		l3_2.setBackground(Color.WHITE);
		l3_2.setBounds(60, 110, 30, 30);
		chessBoard.add(l3_2);
		l3_2.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[3][2] = l3_2;
		
		l3_3 = new JLabel("New label");
		l3_3.setBackground(Color.WHITE);
		l3_3.setBounds(110, 110, 30, 30);
		chessBoard.add(l3_3);
		l3_3.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[3][3] = l3_3;
		
		l3_4 = new JLabel("New label");
		l3_4.setBackground(Color.WHITE);
		l3_4.setBounds(160, 110, 30, 30);
		chessBoard.add(l3_4);
		l3_4.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[3][4] = l3_4;
		
		l3_5 = new JLabel("New label");
		l3_5.setBackground(Color.WHITE);
		l3_5.setBounds(210, 110, 30, 30);
		chessBoard.add(l3_5);
		l3_5.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[3][5] = l3_5;
		
		l3_6 = new JLabel("New label");
		l3_6.setBackground(Color.WHITE);
		l3_6.setBounds(260, 110, 30, 30);
		chessBoard.add(l3_6);
		l3_6.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[3][6] = l3_6;
		
		l3_7 = new JLabel("New label");
		l3_7.setBackground(Color.WHITE);
		l3_7.setBounds(310, 110, 30, 30);
		chessBoard.add(l3_7);
		l3_7.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[3][7] = l3_7;
		
		l3_8 = new JLabel("New label");
		l3_8.setBackground(Color.WHITE);
		l3_8.setBounds(360, 110, 30, 30);
		chessBoard.add(l3_8);
		l3_8.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[3][8] = l3_8;
		
		l3_9 = new JLabel("New label");
		l3_9.setBackground(Color.WHITE);
		l3_9.setBounds(410, 110, 30, 30);
		chessBoard.add(l3_9);
		l3_9.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[3][9] = l3_9;
		
		l4_1 = new JLabel("New label");
		l4_1.setBackground(Color.WHITE);
		l4_1.setBounds(10, 160, 30, 30);
		chessBoard.add(l4_1);
		l4_1.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[4][1] = l4_1;
		
		l4_2 = new JLabel("New label");
		l4_2.setBackground(Color.WHITE);
		l4_2.setBounds(60, 160, 30, 30);
		chessBoard.add(l4_2);
		l4_2.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[4][2] = l4_2;
		
		l4_3 = new JLabel("New label");
		l4_3.setBackground(Color.WHITE);
		l4_3.setBounds(110, 160, 30, 30);
		chessBoard.add(l4_3);
		l4_3.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[4][3] = l4_3;
		
		l4_4 = new JLabel("New label");
		l4_4.setBackground(Color.WHITE);
		l4_4.setBounds(160, 160, 30, 30);
		chessBoard.add(l4_4);
		l4_4.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[4][4] = l4_4;
		
		l4_5 = new JLabel("New label");
		l4_5.setBackground(Color.WHITE);
		l4_5.setBounds(210, 160, 30, 30);
		chessBoard.add(l4_5);
		l4_5.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[4][5] = l4_5;
		
		l4_6 = new JLabel("New label");
		l4_6.setBackground(Color.WHITE);
		l4_6.setBounds(260, 160, 30, 30);
		chessBoard.add(l4_6);
		l4_6.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[4][6] = l4_6;
		
		l4_7 = new JLabel("New label");
		l4_7.setBackground(Color.WHITE);
		l4_7.setBounds(310, 160, 30, 30);
		chessBoard.add(l4_7);
		l4_7.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[4][7] = l4_7;
		
		l4_8 = new JLabel("New label");
		l4_8.setBackground(Color.WHITE);
		l4_8.setBounds(360, 160, 30, 30);
		chessBoard.add(l4_8);
		l4_8.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[4][8] = l4_8;
		
		l4_9 = new JLabel("New label");
		l4_9.setBackground(Color.WHITE);
		l4_9.setBounds(410, 160, 30, 30);
		chessBoard.add(l4_9);
		l4_9.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[4][9] = l4_9;
		
		l5_1 = new JLabel("New label");
		l5_1.setBackground(Color.WHITE);
		l5_1.setBounds(10, 210, 30, 30);
		chessBoard.add(l5_1);
		l5_1.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[5][1] = l5_1;
		
		l5_2 = new JLabel("New label");
		l5_2.setBackground(Color.WHITE);
		l5_2.setBounds(60, 210, 30, 30);
		chessBoard.add(l5_2);
		l5_2.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[5][2] = l5_2;
		
		l5_3 = new JLabel("New label");
		l5_3.setBackground(Color.WHITE);
		l5_3.setBounds(110, 210, 30, 30);
		chessBoard.add(l5_3);
		l5_3.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[5][3] = l5_3;
		
		l5_4 = new JLabel("New label");
		l5_4.setBackground(Color.WHITE);
		l5_4.setBounds(160, 210, 30, 30);
		chessBoard.add(l5_4);
		l5_4.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[5][4] = l5_4;
		
		l5_5 = new JLabel("New label");
		l5_5.setBackground(Color.WHITE);
		l5_5.setBounds(210, 210, 30, 30);
		chessBoard.add(l5_5);
		l5_5.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[5][5] = l5_5;
		
		l5_6 = new JLabel("New label");
		l5_6.setBackground(Color.WHITE);
		l5_6.setBounds(260, 210, 30, 30);
		chessBoard.add(l5_6);
		l5_6.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[5][6] = l5_6;
		
		l5_7 = new JLabel("New label");
		l5_7.setBackground(Color.WHITE);
		l5_7.setBounds(310, 210, 30, 30);
		chessBoard.add(l5_7);
		l5_7.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[5][7] = l5_7;
		
		l5_8 = new JLabel("New label");
		l5_8.setBackground(Color.WHITE);
		l5_8.setBounds(360, 210, 30, 30);
		chessBoard.add(l5_8);
		l5_8.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[5][8] = l5_8;
		
		l5_9 = new JLabel("New label");
		l5_9.setBackground(Color.WHITE);
		l5_9.setBounds(410, 210, 30, 30);
		chessBoard.add(l5_9);
		l5_9.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[5][9] = l5_9;
		
		l6_1 = new JLabel("New label");
		l6_1.setBackground(Color.WHITE);
		l6_1.setBounds(10, 260, 30, 30);
		chessBoard.add(l6_1);
		l6_1.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[6][1] = l6_1;
		
		l6_2 = new JLabel("New label");
		l6_2.setBackground(Color.WHITE);
		l6_2.setBounds(60, 260, 30, 30);
		chessBoard.add(l6_2);
		l6_2.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[6][2] = l6_2;
		
		l6_3 = new JLabel("New label");
		l6_3.setBackground(Color.WHITE);
		l6_3.setBounds(110, 260, 30, 30);
		chessBoard.add(l6_3);
		l6_3.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[6][3] = l6_3;
		
		l6_4 = new JLabel("New label");
		l6_4.setBackground(Color.WHITE);
		l6_4.setBounds(160, 260, 30, 30);
		chessBoard.add(l6_4);
		l6_4.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[6][4] = l6_4;
		
		l6_5 = new JLabel("New label");
		l6_5.setBackground(Color.WHITE);
		l6_5.setBounds(210, 260, 30, 30);
		chessBoard.add(l6_5);
		l6_5.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[6][5] = l6_5;
		
		l6_6 = new JLabel("New label");
		l6_6.setBackground(Color.WHITE);
		l6_6.setBounds(260, 260, 30, 30);
		chessBoard.add(l6_6);
		l6_6.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[6][6] = l6_6;
		
		l6_7 = new JLabel("New label");
		l6_7.setBackground(Color.WHITE);
		l6_7.setBounds(310, 260, 30, 30);
		chessBoard.add(l6_7);
		l6_7.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[6][7] = l6_7;
		
		l6_8 = new JLabel("New label");
		l6_8.setBackground(Color.WHITE);
		l6_8.setBounds(360, 260, 30, 30);
		chessBoard.add(l6_8);
		l6_8.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[6][8] = l6_8;
		
		l6_9 = new JLabel("New label");
		l6_9.setBackground(Color.WHITE);
		l6_9.setBounds(410, 260, 30, 30);
		chessBoard.add(l6_9);
		l6_9.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[6][9] = l6_9;
		
		l7_1 = new JLabel("New label");
		l7_1.setBackground(Color.WHITE);
		l7_1.setBounds(10, 310, 30, 30);
		chessBoard.add(l7_1);
		l7_1.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[7][1] = l7_1;
		
		l7_2 = new JLabel("New label");
		l7_2.setBackground(Color.WHITE);
		l7_2.setBounds(60, 310, 30, 30);
		chessBoard.add(l7_2);
		l7_2.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[7][2] = l7_2;
		
		l7_3 = new JLabel("New label");
		l7_3.setBackground(Color.WHITE);
		l7_3.setBounds(110, 310, 30, 30);
		chessBoard.add(l7_3);
		l7_3.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[7][3] = l7_3;
		
		l7_4 = new JLabel("New label");
		l7_4.setBackground(Color.WHITE);
		l7_4.setBounds(160, 310, 30, 30);
		chessBoard.add(l7_4);
		l7_4.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[7][4] = l7_4;
		
		l7_5 = new JLabel("New label");
		l7_5.setBackground(Color.WHITE);
		l7_5.setBounds(210, 310, 30, 30);
		chessBoard.add(l7_5);
		l7_5.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[7][5] = l7_5;
		
		l7_6 = new JLabel("New label");
		l7_6.setBackground(Color.WHITE);
		l7_6.setBounds(260, 310, 30, 30);
		chessBoard.add(l7_6);
		l7_6.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[7][6] = l7_6;
		
		l7_7 = new JLabel("New label");
		l7_7.setBackground(Color.WHITE);
		l7_7.setBounds(310, 310, 30, 30);
		chessBoard.add(l7_7);
		l7_7.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[7][7] = l7_7;
		
		l7_8 = new JLabel("New label");
		l7_8.setBackground(Color.WHITE);
		l7_8.setBounds(360, 310, 30, 30);
		chessBoard.add(l7_8);
		l7_8.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[7][8] = l7_8;
		
		l7_9 = new JLabel("New label");
		l7_9.setBackground(Color.WHITE);
		l7_9.setBounds(410, 310, 30, 30);
		chessBoard.add(l7_9);
		l7_9.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[7][9] = l7_9;
		
		l8_1 = new JLabel("New label");
		l8_1.setBackground(Color.WHITE);
		l8_1.setBounds(10, 360, 30, 30);
		chessBoard.add(l8_1);
		l8_1.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[8][1] = l8_1;
		
		l8_2 = new JLabel("New label");
		l8_2.setBackground(Color.WHITE);
		l8_2.setBounds(60, 360, 30, 30);
		chessBoard.add(l8_2);
		l8_2.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[8][2] = l8_2;
		
		l8_3 = new JLabel("New label");
		l8_3.setBackground(Color.WHITE);
		l8_3.setBounds(110, 360, 30, 30);
		chessBoard.add(l8_3);
		l8_3.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[8][3] = l8_3;
		
		l8_4 = new JLabel("New label");
		l8_4.setBackground(Color.WHITE);
		l8_4.setBounds(160, 360, 30, 30);
		chessBoard.add(l8_4);
		l8_4.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[8][4] = l8_4;
		
		l8_5 = new JLabel("New label");
		l8_5.setBackground(Color.WHITE);
		l8_5.setBounds(210, 360, 30, 30);
		chessBoard.add(l8_5);
		l8_5.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[8][5] = l8_5;
		
		l8_6 = new JLabel("New label");
		l8_6.setBackground(Color.WHITE);
		l8_6.setBounds(260, 360, 30, 30);
		chessBoard.add(l8_6);
		l8_6.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[8][6] = l8_6;
		
		l8_7 = new JLabel("New label");
		l8_7.setBackground(Color.WHITE);
		l8_7.setBounds(310, 360, 30, 30);
		chessBoard.add(l8_7);
		l8_7.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[8][7] = l8_7;
		
		l8_8 = new JLabel("New label");
		l8_8.setBackground(Color.WHITE);
		l8_8.setBounds(360, 360, 30, 30);
		chessBoard.add(l8_8);
		l8_8.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[8][8] = l8_8;
		
		l8_9 = new JLabel("New label");
		l8_9.setBackground(Color.WHITE);
		l8_9.setBounds(410, 360, 30, 30);
		chessBoard.add(l8_9);
		l8_9.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[8][9] = l8_9;
		
		l9_1 = new JLabel("New label");
		l9_1.setBackground(Color.WHITE);
		l9_1.setBounds(10, 410, 30, 30);
		chessBoard.add(l9_1);
		l9_1.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[9][1] = l9_1;
		
		l9_2 = new JLabel("New label");
		l9_2.setBackground(Color.WHITE);
		l9_2.setBounds(60, 410, 30, 30);
		chessBoard.add(l9_2);
		l9_2.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[9][2] = l9_2;
		
		l9_3 = new JLabel("New label");
		l9_3.setBackground(Color.WHITE);
		l9_3.setBounds(110, 410, 30, 30);
		chessBoard.add(l9_3);
		l9_3.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[9][3] = l9_3;
		
		l9_4 = new JLabel("New label");
		l9_4.setBackground(Color.WHITE);
		l9_4.setBounds(160, 410, 30, 30);
		chessBoard.add(l9_4);
		l9_4.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[9][4] = l9_4;
		
		l9_5 = new JLabel("New label");
		l9_5.setBackground(Color.WHITE);
		l9_5.setBounds(210, 410, 30, 30);
		chessBoard.add(l9_5);
		l9_5.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[9][5] = l9_5;
		
		l9_6 = new JLabel("New label");
		l9_6.setBackground(Color.WHITE);
		l9_6.setBounds(260, 410, 30, 30);
		chessBoard.add(l9_6);
		l9_6.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[9][6] = l9_6;
		
		l9_7 = new JLabel("New label");
		l9_7.setBackground(Color.WHITE);
		l9_7.setBounds(310, 410, 30, 30);
		chessBoard.add(l9_7);
		l9_7.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[9][7] = l9_7;
		
		l9_8 = new JLabel("New label");
		l9_8.setBackground(Color.WHITE);
		l9_8.setBounds(360, 410, 30, 30);
		chessBoard.add(l9_8);
		l9_8.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[9][8] = l9_8;
		
		
		l9_9 = new JLabel("New label");
		l9_9.setBackground(Color.WHITE);
		l9_9.setBounds(410, 410, 30, 30);
		chessBoard.add(l9_9);
		l9_9.setIcon(new ImageIcon(getClass().getResource("/Image/base.jpg")));
		labelArray[9][9] = l9_9;
		
		//Point label to read the x-axis and y-axis of coordinates
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				JLabel temp = labelArray[i][j];
				labelArray[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e1) {
						
						for(int a = 1; a<= 9; a++) {
							for(int b= 1; b<= 9; b++) {
								labelArray[a][b].setBorder(null);
								}
							}
						
						temp.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
						
						for(int a = 1; a<= 9; a++) {
							for(int b= 1; b<= 9; b++) {
								if(e1.getSource()==labelArray[a][b]) {
									game.setX_play(a);
									game.setY_play(b);
									
								}
								
							}
						}
					}
				});
			}
		}
		
		ylabel1 = new JLabel("1");
		ylabel1.setFont(new Font("Arial", Font.PLAIN, 15));
		ylabel1.setBounds(10, 460, 34, 32);
		chessBoard.add(ylabel1);
		
		ylabel2 = new JLabel("2");
		ylabel2.setFont(new Font("Arial", Font.PLAIN, 15));
		ylabel2.setBounds(60, 460, 34, 32);
		chessBoard.add(ylabel2);
		
		ylabel3 = new JLabel("3");
		ylabel3.setFont(new Font("Arial", Font.PLAIN, 15));
		ylabel3.setBounds(110, 460, 34, 32);
		chessBoard.add(ylabel3);
		
		ylabel4 = new JLabel("4");
		ylabel4.setFont(new Font("Arial", Font.PLAIN, 15));
		ylabel4.setBounds(159, 460, 41, 32);
		chessBoard.add(ylabel4);
		
		ylabel5 = new JLabel("5");
		ylabel5.setFont(new Font("Arial", Font.PLAIN, 15));
		ylabel5.setBounds(210, 460, 34, 32);
		chessBoard.add(ylabel5);
		
		ylabel6 = new JLabel("6");
		ylabel6.setFont(new Font("Arial", Font.PLAIN, 15));
		ylabel6.setBounds(260, 460, 34, 32);
		chessBoard.add(ylabel6);
		
		ylabel7 = new JLabel("7");
		ylabel7.setFont(new Font("Arial", Font.PLAIN, 15));
		ylabel7.setBounds(310, 460, 34, 32);
		chessBoard.add(ylabel7);
		
		ylabel8 = new JLabel("8");
		ylabel8.setFont(new Font("Arial", Font.PLAIN, 15));
		ylabel8.setBounds(360, 460, 34, 32);
		chessBoard.add(ylabel8);
		
		ylabel9 = new JLabel("9");
		ylabel9.setFont(new Font("Arial", Font.PLAIN, 15));
		ylabel9.setBounds(410, 460, 34, 32);
		chessBoard.add(ylabel9);
		
		xlabel1 = new JLabel("1");
		xlabel1.setFont(new Font("Arial", Font.PLAIN, 15));
		xlabel1.setBounds(463, 9, 34, 32);
		chessBoard.add(xlabel1);
		
		xlabel2 = new JLabel("2");
		xlabel2.setFont(new Font("Arial", Font.PLAIN, 15));
		xlabel2.setBounds(463, 59, 34, 32);
		chessBoard.add(xlabel2);
		
		xlabel3 = new JLabel("3");
		xlabel3.setFont(new Font("Arial", Font.PLAIN, 15));
		xlabel3.setBounds(463, 109, 34, 32);
		chessBoard.add(xlabel3);
		
		xlabel4 = new JLabel("4");
		xlabel4.setFont(new Font("Arial", Font.PLAIN, 15));
		xlabel4.setBounds(463, 159, 34, 32);
		chessBoard.add(xlabel4);
		
		xlabel5 = new JLabel("5");
		xlabel5.setFont(new Font("Arial", Font.PLAIN, 15));
		xlabel5.setBounds(463, 209, 34, 32);
		chessBoard.add(xlabel5);
		
		xlabel6 = new JLabel("6");
		xlabel6.setFont(new Font("Arial", Font.PLAIN, 15));
		xlabel6.setBounds(463, 259, 34, 32);
		chessBoard.add(xlabel6);
		
		xlabel7 = new JLabel("7");
		xlabel7.setFont(new Font("Arial", Font.PLAIN, 15));
		xlabel7.setBounds(463, 309, 34, 32);
		chessBoard.add(xlabel7);
		
		xlabel8 = new JLabel("8");
		xlabel8.setFont(new Font("Arial", Font.PLAIN, 15));
		xlabel8.setBounds(463, 359, 34, 32);
		chessBoard.add(xlabel8);
		
		xlabel9 = new JLabel("9");
		xlabel9.setFont(new Font("Arial", Font.PLAIN, 15));
		xlabel9.setBounds(463, 409, 34, 32);
		chessBoard.add(xlabel9);
		
	}
}
