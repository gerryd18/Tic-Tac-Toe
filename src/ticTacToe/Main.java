package ticTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener{
JPanel titlePanel,boardPanel, scorePanel, centerPanel, bottomPanel;
JButton resetButton, exitButton;
JLabel titleLabel, player1ScoreLabel, player2ScoreLabel, scoreLabel;
JButton[] buttons = new JButton[9];
Random rand = new Random();


private boolean player1Turn;
private int xScore=0, oScore=0;

	public Main() {
		setFrame();
		
		//title
		titlePanel = new JPanel();
		titleLabel = new JLabel("Tic Tac Toe");
		titleLabel.setFont(titleLabel.getFont().deriveFont(40f));
		
		titlePanel.add(titleLabel);
		titlePanel.setBackground(Color.decode("#d1faff"));
		add(titlePanel, BorderLayout.NORTH);
		
//		game board
		boardPanel = new JPanel( new GridLayout(3,3));
		boardPanel.setPreferredSize(new Dimension(300,300));
		boardPanel.setBackground(Color.decode("#2b2b2b"));
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.decode("#2b2b2b"));
		
//		buttons
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			buttons[i].setFont(getFont().deriveFont(30f));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.decode("#808080"));
			boardPanel.add(buttons[i]);
		}
		
		
		boardPanel.setBorder(BorderFactory.createEmptyBorder(40,0,0,50));
		centerPanel.add(boardPanel);
		add(centerPanel, BorderLayout.CENTER);
		
		
//		Score
		scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setPreferredSize(new Dimension(300,100));
		scorePanel.setBackground(Color.decode("#d1faff"));
		
		scoreLabel = new JLabel("Score :"); 
		scoreLabel.setBounds(120,0,100,30);
		scoreLabel.setFont(getFont().deriveFont(20f));
		
		player1ScoreLabel = new JLabel("Player X : " + xScore);
		player1ScoreLabel.setBounds(20,30,150,30);
		player1ScoreLabel.setFont(getFont().deriveFont(18f));
		
		player2ScoreLabel = new JLabel("Player O : " + oScore); 
		player2ScoreLabel.setBounds(20,60,150,30);
		player2ScoreLabel.setFont(getFont().deriveFont(18f));
		
		scorePanel.add(scoreLabel);
		scorePanel.add(player1ScoreLabel);
		scorePanel.add(player2ScoreLabel);
		centerPanel.add(scorePanel);
		
//		button
		bottomPanel = new JPanel();
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,70,0));
		bottomPanel.setBackground(Color.decode("#2b2b2b"));
		
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");
		
		resetButton.setPreferredSize(new Dimension(200,50));
		exitButton.setPreferredSize(new Dimension(200,50));
		
		bottomPanel.add(resetButton);
		bottomPanel.add(exitButton);
		add(bottomPanel,BorderLayout.SOUTH);
		
		
		//add actionListener
		resetButton.addActionListener(this);
		exitButton.addActionListener(this);
		firstTurn();
	}
	
	//random for the first turn
	void firstTurn() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rand.nextInt(2)==0) {
			player1Turn=true;
			titleLabel.setText("X turn");
		}
		else {
			player1Turn=false;
			titleLabel.setText("O turn");
		}
	}
	
	void winCondition() {
		// x wins ====================================================================
		if (	buttons[0].getText()=="X" &&
				buttons[1].getText()=="X" &&
				buttons[2].getText()=="X" 
				) {
			xWins(0,1,2);
		}else
			if (	buttons[0].getText()=="X" &&
				buttons[3].getText()=="X" &&
				buttons[6].getText()=="X" 
				) {
			xWins(0,3,6);
		}else
			if (	buttons[6].getText()=="X" &&
				buttons[7].getText()=="X" &&
				buttons[8].getText()=="X" 
				) {
			xWins(6,7,8);
		}else
			if (	buttons[2].getText()=="X" &&
			buttons[5].getText()=="X" &&
			buttons[8].getText()=="X" 
			) {
		xWins(2,5,8);
		}else
			if (	buttons[0].getText()=="X" &&
				buttons[4].getText()=="X" &&
				buttons[8].getText()=="X" 
				) {
			xWins(0,4,8);
		}else
			if (	buttons[1].getText()=="X" &&
				buttons[4].getText()=="X" &&
				buttons[7].getText()=="X" 
				) {
			xWins(1,4,7);
		}else
			if (	buttons[6].getText()=="X" &&
				buttons[4].getText()=="X" &&
				buttons[2].getText()=="X" 
				) {
			xWins(6,4,2);
		}else
			if (	buttons[3].getText()=="X" &&
				buttons[4].getText()=="X" &&
				buttons[5].getText()=="X" 
				) {
			xWins(3,4,5);
		}else // O wins ========================================================================
			if (	buttons[0].getText()=="O" &&
				buttons[1].getText()=="O" &&
				buttons[2].getText()=="O" 
				) {
			oWins(0,1,2);
		}else
			if (	buttons[0].getText()=="O" &&
				buttons[3].getText()=="O" &&
				buttons[6].getText()=="O" 
				) {
			oWins(0,3,6);
		}else
			if (	buttons[6].getText()=="O" &&
				buttons[7].getText()=="O" &&
				buttons[8].getText()=="O" 
				) {
			oWins(6,7,8);
		}else
			if (	buttons[2].getText()=="O" &&
				buttons[5].getText()=="O" &&
				buttons[8].getText()=="O" 
				) {
			oWins(2,5,8);
		}else
			if (	buttons[0].getText()=="O" &&
				buttons[4].getText()=="O" &&
				buttons[8].getText()=="O" 
				) {
			oWins(0,4,8);
		}else
			if (	buttons[1].getText()=="O" &&
				buttons[4].getText()=="O" &&
				buttons[7].getText()=="O" 
				) {
			oWins(1,4,7);
		}else
			if (	buttons[6].getText()=="O" &&
				buttons[4].getText()=="O" &&
				buttons[2].getText()=="O" 
				) {
			oWins(6,4,2);
		}else
			if (	buttons[3].getText()=="O" &&
				buttons[4].getText()=="O" &&
				buttons[5].getText()=="O" 
				) {
			oWins(3,4,5);
		}
			
			
	}
	
	
	void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.decode("#9df595"));
		buttons[b].setBackground(Color.decode("#9df595"));
		buttons[c].setBackground(Color.decode("#9df595"));
		
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		JOptionPane.showMessageDialog(this, "congratulation X wins!!!");
		xScore += 1;
		reset();
	}
	
	void oWins(int a,int b, int c) {
		buttons[a].setBackground(Color.decode("#9df595"));
		buttons[b].setBackground(Color.decode("#9df595"));
		buttons[c].setBackground(Color.decode("#9df595"));
		
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		JOptionPane.showMessageDialog(this, "congratulation O wins!!!");
		oScore += 1;
		reset();
	}
	
	void reset() {
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(true);
			buttons[i].setText("");
			buttons[i].setBackground(Color.decode("#808080"));
		}
		player1ScoreLabel.setText("Player X : " + xScore);
		player2ScoreLabel.setText("Player O : " + oScore);
	}
	
	void setFrame() {
		//set JFrame
		setVisible(true); //biar keliatan 
		setLocation(500,300);
		setSize(700,600); //ukuran framenya
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // biar langsung terminate ketika close GUI
		setResizable(false); //biar ukuran frame static | tidak bisa diubah	
		this.getContentPane().setBackground(Color.decode("#2b2b2b"));// cara ubah background frame
	}

	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitButton) {
			if (JOptionPane.showConfirmDialog(this, "Confirm if you want to leave this game", "tic tac toe", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		}else
			if(e.getSource() == resetButton) {
				reset();
		}else {
			for (int i = 0; i < 9; i++) {
				if (e.getSource()==buttons[i]) {
					if (player1Turn==true) {
						if (buttons[i].getText() == "") { //check if button is already clicked/not
							buttons[i].setBackground(Color.decode("#ff8f98"));
							buttons[i].setText("X");
							winCondition();
							//change turn
							player1Turn=false;
							titleLabel.setText("O turn");
						}
					}
					else {
						if (buttons[i].getText() == "") {
							buttons[i].setBackground(Color.decode("#8f96ff"));
							buttons[i].setText("O");
							winCondition();
							//change turn
							player1Turn=true;
							titleLabel.setText("X turn");
						}
					}
				}
			}
		}
	}

}
