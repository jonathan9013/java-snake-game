import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartGame extends JPanel{
//	this class creates a frame and a keylistener for the start screen of the game.  when the space bar is pressed it closes this frame
//	and calls screen .java which is where most of the game is run from
	private static JFrame frame = new JFrame("Snake");
	public StartGame(){
		addKeyListener(new SpaceListener());
		setFocusable(true);
	}
	private class SpaceListener implements KeyListener {		
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {	
			int key = e.getKeyCode();
			if(key==KeyEvent.VK_SPACE){
				frame.setVisible(false);
				Screen.main(null);
				
			}
		}
		public void keyReleased(KeyEvent e) {
		}
	}
//	this simply creates the writing for the start screen
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times New Roman", Font.BOLD, 40));
		g.drawString("Snake" , 400, 400);
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g.drawString("press space to start" , 370, 500);
	}
	public static void main(String[] args){
		frame.setSize(1000, 1000);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StartGame myPanel = new StartGame();
		myPanel.setBackground(Color.BLACK);
		frame.add(myPanel);
		frame.setVisible(true);
	}
}
