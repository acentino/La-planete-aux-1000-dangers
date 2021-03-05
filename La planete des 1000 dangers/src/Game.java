import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleFrame, startButtonFrame, mainTextFrame, choiceButtonFrame, playerInfo;
	JLabel title, lpText, lp, weaponText, weapon;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 28);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP;
	String weaponequiped, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {
		
		new Game();
	}
	public Game(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titleFrame = new JPanel();
		titleFrame.setBounds(100, 100, 600, 150);
		titleFrame.setBackground(Color.black);
		title = new JLabel("LA PLANETE DES 1000 DANGERS");
		title.setForeground(Color.white);
		title.setFont(titleFont);
		
		startButtonFrame = new JPanel();
		startButtonFrame.setBounds(300, 400, 200, 100);
		startButtonFrame.setBackground(Color.black);
		
		startButton = new JButton("Demarrer");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(buttonFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleFrame.add(title);
		startButtonFrame.add(startButton);
		
		con.add(titleFrame);
		con.add(startButtonFrame);
	}
	
public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
			
		}
	}

public class ChoiceHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent event) {
		
		String yourChoice = event.getActionCommand();
		
		switch(position) {
		
		case "Debut":
			switch(yourChoice) {
			case "c1": Canyon(); break;
			}

		case "Canyon":
			switch(yourChoice) {
			case "c1": Mouches(); break;
			case "c2": Fruits(); break;
			}
		
		case "Mouches":
			switch(yourChoice) {
			case "c1": GameOver() ; break;
			case "c2": GameOver() ; break;
			case "c3": GameOver() ; break;
			}
		
		case "Fruits":
			switch(yourChoice) {
			case "c1": GameOver(); break;
			case "c2": GameOver(); break;
			case "c3": GameOver(); break;
			case "c4": GameOver(); break;
			}
		

		case "GameOver":
			switch(yourChoice) {
			case "c1": Debut(); break;
			}
		}
	}
}

	
	public void createGameScreen(){
		
		titleFrame.setVisible(false);
		title.setVisible(false);
		startButtonFrame.setVisible(false);
		startButton.setVisible(false);
		
		mainTextFrame = new JPanel();
		mainTextFrame.setBounds(100, 100, 600, 250);
		mainTextFrame.setBackground(Color.black);
		con.add(mainTextFrame);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(buttonFont);
		mainTextArea.setLineWrap(true);
		mainTextFrame.add(mainTextArea);
		
		choiceButtonFrame = new JPanel();
		choiceButtonFrame.setBounds(250, 350, 300, 150);
		choiceButtonFrame.setBackground(Color.black);
		choiceButtonFrame.setLayout(new GridLayout(4,1));
		con.add(choiceButtonFrame);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(buttonFont);
		choice1.setFocusPainted(false);
		choiceButtonFrame.add(choice1);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(buttonFont);
		choice2.setFocusPainted(false);
		choiceButtonFrame.add(choice2);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choice3 = new JButton("Choice 3");		
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(buttonFont);
		choice3.setFocusPainted(false);
		choiceButtonFrame.add(choice3);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(buttonFont);
		choice4.setFocusPainted(false);
		choiceButtonFrame.add(choice4);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		
		playerInfo = new JPanel();
		playerInfo.setBounds(100, 15, 600, 50);
		playerInfo.setBackground(Color.black);
		playerInfo.setLayout(new GridLayout(1,4));
		con.add(playerInfo);
		
		lpText = new JLabel("HP:");
		lpText.setFont(buttonFont);
		lpText.setForeground(Color.white);
		playerInfo.add(lpText);
		
		lp = new JLabel();
		lp.setFont(buttonFont);
		lp.setForeground(Color.white);
		playerInfo.add(lp);
		

		weaponText = new JLabel("Arme:");
		weaponText.setFont(buttonFont);
		weaponText.setForeground(Color.white);
		playerInfo.add(weaponText);
		
		weapon = new JLabel();
		weapon.setFont(buttonFont);
		weapon.setForeground(Color.white);
		playerInfo.add(weapon);
		
		playerSetup();
	}
	
	public void playerSetup(){
		playerHP = 15;
		weaponequiped = "Fusil Laser";
		weapon.setText(weaponequiped);
		lp.setText("" + playerHP);
		
		Debut();
	}
	
	public void Debut() {
		
		position = "Debut";
		
		mainTextArea.setText("Aprés avoir sauté en parachute de votre vaisseau spatial endommagé, vous avez atteri sur La planete des 1000 dangers et devez retrouver l'endroit ou votre engin s'est écrasé.");
		
		choice1.setText(">");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		
	}
	
	public void Canyon() {
		
		position = "Canyon";
				
		mainTextArea.setText("Alors que vous marchez en direction du lieu du crash votre vaisseau, un grand canyon se dresse sur votre route.");
		
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(false);
		choice4.setVisible(false);
		choice1.setText("Descendre");
		choice2.setText("Contourner");
		
	}
	
	public void Mouches() {
		
		position = "Mouches";
				
		mainTextArea.setText("A mesure que vous descendez, vous entendez un vrombissement sourd qui s'emplifie. Avant que vous n'ayez pu rebrousser chemin, un essain de mouches géantes vous attaque");
		
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(false);
		choice1.setText("Attendre");
		choice2.setText("Sauter sur le bord opposé");
		choice3.setText("Chercher une faille dans la fallaise");
		
	}
	
	public void Fruits() {
		
		position = "Fruits";
				
		mainTextArea.setText("Arrivé au sommet du canyon, vous vous retrouvez devant une foret titanesque. Vous appércevez des baies rouges suspendus à 1 métre du sol et des fruits verts bien plus haut dans les branchages.");
		
		choice1.setVisible(true);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
		choice1.setText("Manger les baie");
		choice2.setText("Manger les fruits");
		choice3.setText("Observer");
		choice4.setText("Passer votre chemin");
		
	}
	
	public void GameOver() {
		
		position = "GameOver";
				
		mainTextArea.setText("Vous etes mort.");
		
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
		choice1.setText("Recommancer");		
	}
	
}
