import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
//	This class runs the bulk of the game
public class Screen extends JPanel {
	private final int TIME_DELAY = 100;
	private static Timer timer;
	private Snake starterSnake = new Snake();
	private Food starterFood = new Food();
	private static JFrame frame = new JFrame("Snake");
	private static Screen myPanel = new Screen();
	static EndGame gameOver = new EndGame();
//	Implements the keylistener and timerlistener
	public Screen(){
		addKeyListener(new ArrowListener());
		setFocusable(true);
		timer = new Timer(TIME_DELAY, new TimerListener());
		timer.start();
	}
//	timerlistener calls movesnake method which moves the snake also calls the play method from sound class 
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			starterSnake.moveSnake();
			Sound.play("Blip_Select4.wav");
			repaint();
		}
	}
//	keylistener that changes the direction of the leading box of the snake 
	private class ArrowListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key==KeyEvent.VK_UP){
				if(!starterSnake.getBox(0).getDirection().equals("down"))
					starterSnake.getBox(0).changeDirection("up");
			}
			else if(key == KeyEvent.VK_DOWN){
				if(!starterSnake.getBox(0).getDirection().equals("up"))
					starterSnake.getBox(0).changeDirection("down");
			}
			else if(key ==KeyEvent.VK_RIGHT){
				if(!starterSnake.getBox(0).getDirection().equals("left"))
					starterSnake.getBox(0).changeDirection("right");
			}
			else if(key==KeyEvent.VK_LEFT){
				if(!starterSnake.getBox(0).getDirection().equals("right"))
					starterSnake.getBox(0).changeDirection("left");
			}
		}
		public void keyReleased(KeyEvent e) {
		}
	}
//	paints the snake and food
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		for(int i = 0; i<starterSnake.size();i++){
			g.fillRect(starterSnake.getBox(i).getX(), starterSnake.getBox(i).getY(), starterSnake.getBox(i).getWidth(), starterSnake.getBox(i).getWidth());
		}
		g.fillRect(starterFood.getBox().getX(), starterFood.getBox().getY(), starterFood.getBox().getWidth(), starterFood.getBox().getWidth());
	}
//	for the rare occasion in which someone wins the game this will replace the game panel with the win game panel
	public static void WinGame(){
		Screen.timer.stop();
		Sound.play("Randomize13.wav");
		WinGame endGame = new WinGame();
		endGame.setBackground(Color.BLACK);
		frame.remove(myPanel);
		frame.add(endGame);
		frame.revalidate();
	}
//	when the game ends it replaces the game panel with the end game panel
	public static void GameOver(){
		Screen.timer.stop();
		Sound.play("Randomize2.wav");
		gameOver.setBackground(Color.BLACK);
		frame.remove(myPanel);
		frame.add(gameOver);
		frame.revalidate();
	}
	public static void main(String[] args){
		frame.setSize(1000, 1000);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel.setBackground(Color.BLACK);
		frame.add(myPanel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
