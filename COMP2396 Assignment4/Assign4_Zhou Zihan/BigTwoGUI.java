import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * This class is used for modeling a user interface for the Big Two card game.
 * 
 * @author Kenneth Wong, Zhou Zihan
 */

public class BigTwoGUI implements CardGameUI, ActionListener{
	private final static int MAX_CARD_NUM = 13; // max. no. of cards each player holds
	private BigTwo game = null; // a BigTwo object
	private ArrayList<CardGamePlayer> playerList; // the list of players
	private ArrayList<Hand> handsOnTable; // the list of hands played on the
	private int activePlayer = -1; // the index of the active player
	private boolean[] selected = new boolean[MAX_CARD_NUM]; // selected cards
	private Hand lastHandsOnTable; //the last hand on table
	private JFrame frame; //the main window of the application
	private JPanel menuPanel;
	private JPanel bigTwoPanel; //a panel for showing the cards of each player and the cards played on the table
	private JPanel functionPanel;   //a panel for showing the bottom functions of the bigTwo game, should include play, pass button and message box
	private JPanel textPanel;   //a panel for showing the msgArea and chatArea
	private JPanel mydrawPanel1;//a panel for displaying cards
	private JButton playButton; //a “Play” button for the active player to play the selected cards
	private JButton passButton; //a “Pass” button for the active player to pass his/her turn to the next player
	private JTextArea msgArea;  //a text area for showing the current game status as well as end of game messages
	private JTextArea chatArea; //a text area for showing chat messages sent by the players
	private JTextField chatInput; //a text field for players to input chat messages
	
	/**
	 * Creates and returns an instance of the BigTwoGUI class.
	 * 
	 * @param game a BigTwo object associated with this GUI
	 */
	public BigTwoGUI(BigTwo game) {
		this.game = game;
		playerList = game.getPlayerList();
		handsOnTable = game.getHandsOnTable();
	}

	/**
	 * This class is used to create mydrawPanel which implements MouseListener
	 * In this mydrawPanel, cards, players and their avatars are stored. 
	 * 
	 * @author zhouzihan
	 *
	 */
	class mydrawPanel extends JPanel implements MouseListener{
		/**
		 * Constructor of mydrawPanel
		 * add MouseListener to mydrawPanel
		 */
		public mydrawPanel() {
			this.addMouseListener(this);
		}
		/**
		 * Method to paintComponent in mydrawPanel
		 * paint cards, lines, players and their avatars in it
		 */
		public void paintComponent(Graphics g) {
			super.paintComponent(g); 
			Image backCard = new ImageIcon("b.gif").getImage();    //the back of the card
			//insert image of all kinds of cards
			Image _2s = new ImageIcon("2s.gif").getImage();
			Image _2h = new ImageIcon("2h.gif").getImage();
			Image _2c = new ImageIcon("2c.gif").getImage();
			Image _2d = new ImageIcon("2d.gif").getImage();
			Image _3s = new ImageIcon("3s.gif").getImage();
			Image _3h = new ImageIcon("3h.gif").getImage();
			Image _3c = new ImageIcon("3c.gif").getImage();
			Image _3d = new ImageIcon("3d.gif").getImage();
			Image _4s = new ImageIcon("4s.gif").getImage();
			Image _4h = new ImageIcon("4h.gif").getImage();
			Image _4c = new ImageIcon("4c.gif").getImage();
			Image _4d = new ImageIcon("4d.gif").getImage();
			Image _5s = new ImageIcon("5s.gif").getImage();
			Image _5h = new ImageIcon("5h.gif").getImage();
			Image _5c = new ImageIcon("5c.gif").getImage();
			Image _5d = new ImageIcon("5d.gif").getImage();
			Image _6s = new ImageIcon("6s.gif").getImage();
			Image _6h = new ImageIcon("6h.gif").getImage();
			Image _6c = new ImageIcon("6c.gif").getImage();
			Image _6d = new ImageIcon("6d.gif").getImage();
			Image _7s = new ImageIcon("7s.gif").getImage();
			Image _7h = new ImageIcon("7h.gif").getImage();
			Image _7c = new ImageIcon("7c.gif").getImage();
			Image _7d = new ImageIcon("7d.gif").getImage();
			Image _8s = new ImageIcon("8s.gif").getImage();
			Image _8h = new ImageIcon("8h.gif").getImage();
			Image _8c = new ImageIcon("8c.gif").getImage();
			Image _8d = new ImageIcon("8d.gif").getImage();
			Image _9s = new ImageIcon("9s.gif").getImage();
			Image _9h = new ImageIcon("9h.gif").getImage();
			Image _9c = new ImageIcon("9c.gif").getImage();
			Image _9d = new ImageIcon("9d.gif").getImage();
			Image _ts = new ImageIcon("ts.gif").getImage();
			Image _th = new ImageIcon("th.gif").getImage();
			Image _tc = new ImageIcon("tc.gif").getImage();
			Image _td = new ImageIcon("td.gif").getImage();
			Image _js = new ImageIcon("js.gif").getImage();
			Image _jh = new ImageIcon("jh.gif").getImage();
			Image _jc = new ImageIcon("jc.gif").getImage();
			Image _jd = new ImageIcon("jd.gif").getImage();
			Image _qs = new ImageIcon("qs.gif").getImage();
			Image _qh = new ImageIcon("qh.gif").getImage();
			Image _qc = new ImageIcon("qc.gif").getImage();
			Image _qd = new ImageIcon("qd.gif").getImage();
			Image _ks = new ImageIcon("ks.gif").getImage();
			Image _kh = new ImageIcon("kh.gif").getImage();
			Image _kc = new ImageIcon("kc.gif").getImage();
			Image _kd = new ImageIcon("kd.gif").getImage();
			Image _as = new ImageIcon("as.gif").getImage();
			Image _ah = new ImageIcon("ah.gif").getImage();
			Image _ac = new ImageIcon("ac.gif").getImage();
			Image _ad = new ImageIcon("ad.gif").getImage();
			
			//insert and paint the image of players' avatars
			Image player0 = new ImageIcon("Player0.JPG").getImage();
			Image player1 = new ImageIcon("Player1.JPG").getImage();
			Image player2 = new ImageIcon("Player2.JPG").getImage();
			Image player3 = new ImageIcon("Player3.JPG").getImage();
			g.drawImage(player0, 100, 48, this);
			g.drawImage(player1, 100, 158, this);
			g.drawImage(player2, 100, 268, this);
			g.drawImage(player3, 100, 378, this);
			
			//print out the player name
			for (int s = 0; s < 4; s++) {
				if (s != activePlayer) {
					g.drawString("Player "+s, 110, 40+110*s);
				}
				else {
					g.setColor(Color.YELLOW);
					g.drawString("You", 110, 40+110*s);
					g.setColor(Color.BLACK);
					
				}
			}
			
			//paint the cards of lastHandsOnTable 
			int lastHandPlayerIdx = 0;
			if (handsOnTable.size() > 0) {
				CardGamePlayer lastHandPlayer = handsOnTable.get(handsOnTable.size() - 1).getPlayer();
				for (int r = 0; r < 4; r++) {
					if (lastHandPlayer == playerList.get(r)) {
						lastHandPlayerIdx = r;
					}
				}
				String table = "Played by "+ playerList.get(lastHandPlayerIdx).getName();
				g.drawString(table, 110, 462);
			}
			
			//set the x-coordinate and y-coordinate of the drawing position
			int getx, gety;
			getx = 180;
			gety = 18;
			for (int i = 0; i < 4; i++) {
				g.drawLine(0, 120+110*i, 900, 120+110*i);
				if (i != activePlayer) {
					CardGamePlayer player = playerList.get(i);
					gety = 18 + 110*i;
					for (int k = 0; k < player.getNumOfCards(); k++) {
						getx = 180 + 20*k;
						g.drawImage(backCard, getx, gety, this);
					}
				}
				else {
					CardGamePlayer player = playerList.get(activePlayer);
					CardList cardList = player.getCardsInHand();
					for (int j = 0; j < cardList.size(); j++) {
						
						//check whether the card should be up or down
						if (selected[j] == false) {   //the card should be down
							gety = 18 + 110*i;
						}
						else {                        //the card should be up
							gety = 13 + 110*i;
						}
					
						getx = 180 + 20*j;            //set the x coordinate of the card
						
						//show the right card
						if (cardList.getCard(j).getRank() == 0 && cardList.getCard(j).getSuit() == 0) {
							g.drawImage(_ad, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 0 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_ac, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 0 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_ah, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 0 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_as, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 1 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_2d, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 1 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_2c, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 1 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_2h, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 1 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_2s, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 2 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_3d, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 2 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_3c, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 2 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_3h, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 2 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_3s, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 3 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_4d, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 3 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_4c, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 3 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_4h, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 3 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_4s, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 4 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_5d, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 4 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_5c, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 4 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_5h, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 4 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_5s, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 5 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_6d, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 5 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_6c, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 5 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_6h, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 5 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_6s, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 6 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_7d, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 6 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_7c, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 6 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_7h, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 6 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_7s, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 7 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_8d, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 7 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_8c, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 7 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_8h, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 7 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_8s, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 8 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_9d, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 8 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_9c, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 8 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_9h, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 8 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_9s, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 9 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_td, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 9 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_tc, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 9 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_th, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 9 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_ts, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 10 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_jd, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 10 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_jc, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 10 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_jh, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 10 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_js, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 11 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_qd, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 11 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_qc, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 11 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_qh, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 11 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_qs, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 12 && cardList.getCard(j).getSuit() == 0){
							g.drawImage(_kd, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 12 && cardList.getCard(j).getSuit() == 1){
							g.drawImage(_kc, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 12 && cardList.getCard(j).getSuit() == 2){
							g.drawImage(_kh, getx, gety, this);
						}
						else if(cardList.getCard(j).getRank() == 12 && cardList.getCard(j).getSuit() == 3){
							g.drawImage(_ks, getx, gety, this);
						}
					}
				}
			}
			
			if (handsOnTable.size()>0) {
				lastHandsOnTable = handsOnTable.get(handsOnTable.size() - 1);
				for (int q = 0; q < lastHandsOnTable.size(); q++) {
					int getx1 = 100 + 75*q;
					int gety1 = 464;
					Card playCard = handsOnTable.get(handsOnTable.size() - 1).getCard(q);
					if (playCard.getRank() == 0 && playCard.getSuit() == 0) {
						g.drawImage(_ad, getx1, gety1, this);
					}
					else if(playCard.getRank() == 0 && playCard.getSuit() == 1){
						g.drawImage(_ac, getx1, gety1, this);
					}
					else if(playCard.getRank() == 0 && playCard.getSuit() == 2){
						g.drawImage(_ah, getx1, gety1, this);
					}
					else if(playCard.getRank() == 0 && playCard.getSuit() == 3){
						g.drawImage(_as, getx1, gety1, this);
					}
					else if(playCard.getRank() == 1 && playCard.getSuit() == 0){
						g.drawImage(_2d, getx1, gety1, this);
					}
					else if(playCard.getRank() == 1 && playCard.getSuit() == 1){
						g.drawImage(_2c, getx1, gety1, this);
					}
					else if(playCard.getRank() == 1 && playCard.getSuit() == 2){
						g.drawImage(_2h, getx1, gety1, this);
					}
					else if(playCard.getRank() == 1 && playCard.getSuit() == 3){
						g.drawImage(_2s, getx1, gety1, this);
					}
					else if(playCard.getRank() == 2 && playCard.getSuit() == 0){
						g.drawImage(_3d, getx1, gety1, this);
					}
					else if(playCard.getRank() == 2 && playCard.getSuit() == 1){
						g.drawImage(_3c, getx1, gety1, this);
					}
					else if(playCard.getRank() == 2 && playCard.getSuit() == 2){
						g.drawImage(_3h, getx1, gety1, this);
					}
					else if(playCard.getRank() == 2 && playCard.getSuit() == 3){
						g.drawImage(_3s, getx1, gety1, this);
					}
					else if(playCard.getRank() == 3 && playCard.getSuit() == 0){
						g.drawImage(_4d, getx1, gety1, this);
					}
					else if(playCard.getRank() == 3 && playCard.getSuit() == 1){
						g.drawImage(_4c, getx1, gety1, this);
					}
					else if(playCard.getRank() == 3 && playCard.getSuit() == 2){
						g.drawImage(_4h, getx1, gety1, this);
					}
					else if(playCard.getRank() == 3 && playCard.getSuit() == 3){
						g.drawImage(_4s, getx1, gety1, this);
					}
					else if(playCard.getRank() == 4 && playCard.getSuit() == 0){
						g.drawImage(_5d, getx1, gety1, this);
					}
					else if(playCard.getRank() == 4 && playCard.getSuit() == 1){
						g.drawImage(_5c, getx1, gety1, this);
					}
					else if(playCard.getRank() == 4 && playCard.getSuit() == 2){
						g.drawImage(_5h, getx1, gety1, this);
					}
					else if(playCard.getRank() == 4 && playCard.getSuit() == 3){
						g.drawImage(_5s, getx1, gety1, this);
					}
					else if(playCard.getRank() == 5 && playCard.getSuit() == 0){
						g.drawImage(_6d, getx1, gety1, this);
					}
					else if(playCard.getRank() == 5 && playCard.getSuit() == 1){
						g.drawImage(_6c, getx1, gety1, this);
					}
					else if(playCard.getRank() == 5 && playCard.getSuit() == 2){
						g.drawImage(_6h, getx1, gety1, this);
					}
					else if(playCard.getRank() == 5 && playCard.getSuit() == 3){
						g.drawImage(_6s, getx1, gety1, this);
					}
					else if(playCard.getRank() == 6 && playCard.getSuit() == 0){
						g.drawImage(_7d, getx1, gety1, this);
					}
					else if(playCard.getRank() == 6 && playCard.getSuit() == 1){
						g.drawImage(_7c, getx1, gety1, this);
					}
					else if(playCard.getRank() == 6 && playCard.getSuit() == 2){
						g.drawImage(_7h, getx1, gety1, this);
					}
					else if(playCard.getRank() == 6 && playCard.getSuit() == 3){
						g.drawImage(_7s, getx1, gety1, this);
					}
					else if(playCard.getRank() == 7 && playCard.getSuit() == 0){
						g.drawImage(_8d, getx1, gety1, this);
					}
					else if(playCard.getRank() == 7 && playCard.getSuit() == 1){
						g.drawImage(_8c, getx1, gety1, this);
					}
					else if(playCard.getRank() == 7 && playCard.getSuit() == 2){
						g.drawImage(_8h, getx1, gety1, this);
					}
					else if(playCard.getRank() == 7 && playCard.getSuit() == 3){
						g.drawImage(_8s, getx1, gety1, this);
					}
					else if(playCard.getRank() == 8 && playCard.getSuit() == 0){
						g.drawImage(_9d, getx1, gety1, this);
					}
					else if(playCard.getRank() == 8 && playCard.getSuit() == 1){
						g.drawImage(_9c, getx1, gety1, this);
					}
					else if(playCard.getRank() == 8 && playCard.getSuit() == 2){
						g.drawImage(_9h, getx1, gety1, this);
					}
					else if(playCard.getRank() == 8 && playCard.getSuit() == 3){
						g.drawImage(_9s, getx1, gety1, this);
					}
					else if(playCard.getRank() == 9 && playCard.getSuit() == 0){
						g.drawImage(_td, getx1, gety1, this);
					}
					else if(playCard.getRank() == 9 && playCard.getSuit() == 1){
						g.drawImage(_tc, getx1, gety1, this);
					}
					else if(playCard.getRank() == 9 && playCard.getSuit() == 2){
						g.drawImage(_th, getx1, gety1, this);
					}
					else if(playCard.getRank() == 9 && playCard.getSuit() == 3){
						g.drawImage(_ts, getx1, gety1, this);
					}
					else if(playCard.getRank() == 10 && playCard.getSuit() == 0){
						g.drawImage(_jd, getx1, gety1, this);
					}
					else if(playCard.getRank() == 10 && playCard.getSuit() == 1){
						g.drawImage(_jc, getx1, gety1, this);
					}
					else if(playCard.getRank() == 10 && playCard.getSuit() == 2){
						g.drawImage(_jh, getx1, gety1, this);
					}
					else if(playCard.getRank() == 10 && playCard.getSuit() == 3){
						g.drawImage(_js, getx1, gety1, this);
					}
					else if(playCard.getRank() == 11 && playCard.getSuit() == 0){
						g.drawImage(_qd, getx1, gety1, this);
					}
					else if(playCard.getRank() == 11 && playCard.getSuit() == 1){
						g.drawImage(_qc, getx1, gety1, this);
					}
					else if(playCard.getRank() == 11 && playCard.getSuit() == 2){
						g.drawImage(_qh, getx1, gety1, this);
					}
					else if(playCard.getRank() == 11 && playCard.getSuit() == 3){
						g.drawImage(_qs, getx1, gety1, this);
					}
					else if(playCard.getRank() == 12 && playCard.getSuit() == 0){
						g.drawImage(_kd, getx1, gety1, this);
					}
					else if(playCard.getRank() == 12 && playCard.getSuit() == 1){
						g.drawImage(_kc, getx1, gety1, this);
					}
					else if(playCard.getRank() == 12 && playCard.getSuit() == 2){
						g.drawImage(_kh, getx1, gety1, this);
					}
					else if(playCard.getRank() == 12 && playCard.getSuit() == 3){
						g.drawImage(_ks, getx1, gety1, this);
					}
				}
			}
			
			
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			//get the coordinates of the mouseReleased place
			int x = e.getX();
			int y = e.getY();
			CardGamePlayer player = playerList.get(activePlayer);
			CardList cardList = player.getCardsInHand();
			int size = cardList.size();     //get the number of cards in hand
			
			int yCoordinate = 18 + 110* activePlayer;

			for (int l = 0; l < size; l++) {
				int xCoordinate =  180 + 20*l;
				//not the last card, the click scope is part of the card
				if (l != size - 1) {
					if (selected[l] == false) {
						//if the card after it is not clicked up
						if (selected[l+1] == false) {
							if (x >= xCoordinate && x < xCoordinate+20 && y >= yCoordinate && y < yCoordinate + 97) {
								selected[l] = true;	
							}
						}
						//the card after it is clicked up
						else {
							if (x >= xCoordinate && x < xCoordinate+20 && y >= yCoordinate && y < yCoordinate + 97) {
								selected[l] = true;	
							}
							else if (x >= xCoordinate+20 && x < xCoordinate+73 && y >= yCoordinate+92 && y < yCoordinate+97) {
								selected[l] = true;	
							}
							else {
								selected[l] = false;
							}
						}
						
					}
					else {
						//the card has been clicked up
						//case 1
						if (x >= xCoordinate && x < xCoordinate+20 && y >= yCoordinate - 5 && y < yCoordinate + 92) {
							selected[l] = false;
						}
						//the card has been clicked up
						//case 2
						else if (x >= xCoordinate+20 && x < xCoordinate+73 && y >= yCoordinate - 5 && y < yCoordinate) {
							selected[l] = false;
						}
						else {
							selected[l] = true;
						}
					}
				}
				//the last card, the click scope is the whole card
				else {
					if (selected[l] == false) {
						if (x >= xCoordinate && x < xCoordinate+73 && y >= yCoordinate && y < yCoordinate + 97) {
							selected[l] = true;	
						}
					}
					else {
						//the card has been clicked up
						if (x >= xCoordinate && x < xCoordinate+73 && y >= yCoordinate - 5 && y < yCoordinate + 92) {
							selected[l] = false;
						}
					}
				}
			}
			
			
			frame.repaint();
		}
	}
	
	/**
	 * Initialize the BigTwo GUI
	 */
	public void go() {
		//create the frame
		JFrame frame = new JFrame("BIGTWO GAME");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.frame = frame;
		
		//set the size and visible status of the frame
		frame.setPreferredSize(new Dimension(900, 750));
		frame.setMinimumSize(new Dimension(900, 750));
		frame.setVisible(true);
		
		
		//create the menuPanel
		JPanel menuPanel = new JPanel();
		this.menuPanel = menuPanel;
		menuPanel.setPreferredSize(new Dimension(900, 40));
		
		//create menuBar and add it to menuPanel
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem restart = new JMenuItem("Restart");
		JMenuItem quit = new JMenuItem("Quit");
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BigTwoDeck bigTwoDeck = new BigTwoDeck();
				bigTwoDeck.shuffle();
				game.start(bigTwoDeck);
				clearMsgArea();
				promptActivePlayer();
			}
		});
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(restart);
		menu.add(quit);
		menuBar.add(menu);
		menuPanel.add(menuBar);
	
		//create the textPanel
		JPanel textPanel = new JPanel();
		this.textPanel = textPanel;
		textPanel.setPreferredSize(new Dimension(400, 600));
		textPanel.setLayout(new GridBagLayout());
		GridBagConstraints s = new GridBagConstraints();
		s.gridx = 0;
		s.gridy = 0;
		s.gridwidth = 1;  //default value
		s.gridheight = 1; //default value
		s.weightx = 0.0;  //default value
		s.weighty = 0.0;  //default value
		s.anchor = GridBagConstraints.CENTER;  //default value
		s.fill = GridBagConstraints.HORIZONTAL;
		s.insets = new Insets(0, 0, 0, 0);  //default value
		s.ipadx = 0;  //default value
		s.ipady = 0;  //default value
		s.insets = new Insets(3, 3, 3, 3);
		
		//set msgArea in textPanel
		JTextArea msgArea = new JTextArea();
		this.msgArea = msgArea;
		msgArea.setEditable(false);
		
		s.gridx = 0;
		s.gridy = 0;
		s.gridwidth = 1;
		s.gridheight = 1;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		s.weightx = 1;
		s.weighty = 0.5;
		s.anchor = GridBagConstraints.CENTER;
		s.fill = GridBagConstraints.BOTH;
		JScrollPane msgscroll = new JScrollPane(msgArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textPanel.add(msgscroll, s);
		
		//set chatArea in textPanel
		JTextArea chatArea = new JTextArea();
		this.chatArea = chatArea;
		chatArea.setForeground(Color.BLUE);
		chatArea.setEditable(false);
		s.gridx = 0;
		s.gridy = 1;
		s.gridwidth = 1;
		s.gridheight = 1;
		s.weightx = 1;
		s.weighty = 0.5;
		s.anchor = GridBagConstraints.CENTER;
		s.fill = GridBagConstraints.BOTH;
		JScrollPane chatscroll = new JScrollPane(chatArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textPanel.add(chatscroll, s);
		
		//create the bigTwoPanel
		JPanel bigTwoPanel = new JPanel();
		this.bigTwoPanel = bigTwoPanel;
		Color c1 = new Color(0, 153, 0);
		bigTwoPanel.setBackground(c1);
		bigTwoPanel.setPreferredSize(new Dimension(700, 600));
		
		//create mydrawPanel
		mydrawPanel mydrawPanel1 = new mydrawPanel();
		this.mydrawPanel1 = mydrawPanel1;
		mydrawPanel1.setPreferredSize(new Dimension(700, 600));
		Color c2 = new Color(0, 153, 0);
		mydrawPanel1.setBackground(c2);
		
		//create the functionPanel
		JPanel functionPanel = new JPanel();
		this.functionPanel = functionPanel;
		functionPanel.setPreferredSize(new Dimension(900, 40));
		functionPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;  //default value
		c.gridheight = 1; //default value
		c.weightx = 0.0;  //default value
		c.weighty = 0.0;  //default value
		c.anchor = GridBagConstraints.CENTER;  //default value
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0);  //default value
		c.ipadx = 0;  //default value
		c.ipady = 0;  //default value
		c.insets = new Insets(3, 3, 3, 3);
		
		//add play button
		c.gridx = 0;
		c.gridwidth = 1; 
		c.gridheight = 1;
		c.weightx = 0.1;
		c.weighty = 0.5;
		JButton playButton = new JButton("Play");
		this.playButton = playButton;
		functionPanel.add(playButton, c);
		
		playButton.addActionListener(new ActionListener() {
			/**
			 * play the selected card
			 * @Override
			 */
			public void actionPerformed(ActionEvent e) {
				int[] selectedList = getSelected();

				if (getSelected() != null) {
					resetSelected();
					game.makeMove(activePlayer, selectedList);
				}
				else {
					printMsg("Select the card to play or pass this round.");
				}
			}
		});
		
		//add pass button
		c.gridx = 1;
		c.gridwidth = 1; 
		c.gridheight = 1;
		c.weightx = 0.1;
		c.weighty = 0.5;
		JButton passButton = new JButton("Pass");
		this.passButton = passButton;
		functionPanel.add(passButton, c);
		passButton.addActionListener(new ActionListener() {
			/**
			 * pass this round
			 * @Override
			 */
			public void actionPerformed(ActionEvent e) {
				int[] selectedList1 = getSelected();
				if (getSelected() == null) {
					resetSelected();
					game.makeMove(activePlayer, selectedList1); 
				}
				else {
					printMsg("You shall not pass with the selected card.");
					resetSelected();
				}
			}
		});
		
		//add message label
		c.gridx = 2;
		c.gridwidth = 1; 
		c.gridheight = 1;
		c.weightx = 0.1;
		c.weighty = 0.5;
		JLabel messageLabel = new JLabel("Message: ");
		functionPanel.add(messageLabel, c);
		
		//add chatInput textField
		c.gridx = 3;
		c.gridwidth = 1; 
		c.gridheight = 1;
		c.weightx = 0.8;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 1;
		JTextField chatInput = new JTextField();
		this.chatInput = chatInput;
		functionPanel.add(chatInput, c);
		//add action listener to chatInput
		chatInput.addActionListener(new ActionListener() {
			/**
			 * get chatInput and clear the chatInput textField
			 * @Override
			 */
			public void actionPerformed(ActionEvent e) {
                String gtext = chatInput.getText();
                chatArea.setEditable(true);
                chatArea.append("Player " + activePlayer + ": " + gtext + "\n");
                chatInput.setText("");
			}
		});

		
		//use GridBagLayout to set the frame 
		//with bigTwoPanel, menuPanel, textPanel and functionPanel
		frame.setLayout(new GridBagLayout());
		GridBagConstraints k = new GridBagConstraints();
		k.insets = new Insets(3, 3, 3, 3);
		k.gridx = 0;
		k.gridy = 0;
		k.gridwidth = 1;  //default value
		k.gridheight = 1; //default value
		k.weightx = 0.0;  //default value
		k.weighty = 0.0;  //default value
		k.anchor = GridBagConstraints.CENTER;  //default value
		k.fill = GridBagConstraints.HORIZONTAL;
		k.insets = new Insets(0, 0, 0, 0);  //default value
		k.ipadx = 0;  //default value
		k.ipady = 0;  //default value
		
		//add menuPanel
		k.gridx = 0;
		k.gridy = 0;
		k.gridwidth = 2;
		k.gridheight = 1;
		k.weightx = 1;
		k.weighty = 0.05;
		k.fill = GridBagConstraints.BOTH;
		frame.add(menuPanel, k);
		
		//add bigTwoPanel
		k.gridx = 0;
		k.gridy = 1;
		k.gridwidth = 1;
		k.gridheight = 1;
		k.weightx = 0.6;
		k.weighty = 1;
		k.fill = GridBagConstraints.BOTH;
		frame.add(bigTwoPanel, k);
		k.gridx = 0;
		k.gridy = 0;
		k.gridwidth = 1;
		k.gridheight = 1;
		k.weightx = 1;
		k.weighty = 1;
		k.fill = GridBagConstraints.BOTH;
		bigTwoPanel.add(mydrawPanel1, k);
		
		//add textPanel
		k.gridx = 1;
		k.gridy = 1;
		k.gridwidth = 1;
		k.gridheight = 1;
		k.weightx = 0.4;
		k.weighty = 1;
		k.fill = GridBagConstraints.BOTH;
		frame.add(textPanel, k);
		
		//add functionPanel
		k.gridx = 0;
		k.gridy = 2;
		k.gridwidth = 2;
		k.gridheight = 1;
		k.weightx = 1;
		k.weighty = 0.1;
		k.fill = GridBagConstraints.BOTH;
		frame.add(functionPanel, k);
		
		frame.pack();
		

	}
	/**
	 * call makeMove method in bigTwo to make a move
	 */
	protected void makeMove() {
		game.makeMove(activePlayer, getSelected()); 
	}
	
	/**
	 * repaint the frame when action is performed
	 */
	public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
	
	/**
	 * Sets the index of the active player.
	 * 
	 * @param activePlayer the index of the active player (i.e., the player who can
	 *                     make a move)
	 */
	public void setActivePlayer(int activePlayer) {
		if (activePlayer < 0 || activePlayer >= playerList.size()) {
			this.activePlayer = -1;
		} else {
			this.activePlayer = activePlayer;
		}
	}

	/**
	 * Redraws the GUI.
	 */
	public void repaint() {
		frame.repaint();
		for (int i = 0; i < playerList.size(); i++) {
			CardGamePlayer player = playerList.get(i);
			String name = player.getName();
			if (activePlayer == i) {
				System.out.println("<" + name + ">");
				System.out.print("==> ");
				player.getCardsInHand().print(true, true);
			} else if (activePlayer == -1) {
				System.out.println("<" + name + ">");
				System.out.print("    ");
				player.getCardsInHand().print(true, true);
			} else {
				System.out.println("<" + name + ">");
				System.out.print("    ");
				player.getCardsInHand().print(false, true);
			}
		}
		System.out.println("<Table>");
		Hand lastHandOnTable = (handsOnTable.isEmpty()) ? null : handsOnTable.get(handsOnTable.size() - 1);
		if (lastHandOnTable != null) {
			System.out
					.print("    <" + lastHandOnTable.getPlayer().getName() + "> {" + lastHandOnTable.getType() + "} ");
			lastHandOnTable.print(true, false);
		} else {
			System.out.println("  [Empty]");
		}
	}
	
	/**
	 * Prints the specified string to the GUI.
	 * 
	 * @param msg the string to be printed to the GUI
	 */
	public void printMsg(String msg) {
		System.out.print(msg);
		msgArea.append(msg);
		msgArea.append("\n");
	}

	/**
	 * Clears the message area of the GUI.
	 */
	public void clearMsgArea() {
		// not used in non-graphical UI
		msgArea.setText("");
	}

	/**
	 * Resets the GUI.
	 */
	public void reset() {
		//reset the list of selected cards
		resetSelected();
		//clear the msgArea
		clearMsgArea();
		//enable user interactions
		enable();
	}

	/**
	 * Enables user interactions.
	 */
	public void enable() {
		//enable play and pass button
		playButton.setEnabled(true);
		passButton.setEnabled(true);
		//enable all the Panels
		menuPanel.setEnabled(true);
		bigTwoPanel.setEnabled(true);
		textPanel.setEnabled(true);
		functionPanel.setEnabled(true);
		//enable chatInput area
		chatInput.setEditable(true);
		
	}

	/**
	 * Disables user interactions.
	 */
	public void disable() {
		//disable play and pass button
		playButton.setEnabled(false);
		passButton.setEnabled(false);
		//disable the chat input
		chatInput.setEditable(false);
		//disable bigTwo Panel
		bigTwoPanel.setEnabled(false);
	}

	/**
	 * Prompts active player to select cards and make his/her move.
	 */
	public void promptActivePlayer() {
		printMsg(playerList.get(activePlayer).getName() + "'s turn: ");
		//int[] cardIdx = getSelected();
		resetSelected();
		repaint();
		//game.makeMove(activePlayer, cardIdx);
	}
	
	/**
	 * Returns an array of indices of the cards selected through the GUI.
	 * 
	 * @return an array of indices of the cards selected, or null if no valid cards
	 *         have been selected
	 */
	private int[] getSelected() {
		
		int[] cardIdx = null;
		int count = 0;
		for (int j = 0; j < selected.length; j++) {
			if (selected[j]) {
				count++;
			}
		}

		if (count != 0) {
			cardIdx = new int[count];
			count = 0;
			for (int j = 0; j < selected.length; j++) {
				if (selected[j]) {
					cardIdx[count] = j;
					count++;
				}
			}
		}
		return cardIdx;
	}

	/**
	 * Resets the list of selected cards to an empty list.
	 */
	private void resetSelected() {
		for (int j = 0; j < selected.length; j++) {
			selected[j] = false;
		}
	}
}
