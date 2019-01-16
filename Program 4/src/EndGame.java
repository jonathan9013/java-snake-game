import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//	creates game over screen and prints outs the score
public class EndGame extends JPanel {
	public EndGame(){
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times New Roman", Font.BOLD, 40));
		g.drawString("Game Over", 400,400);
		g.drawString("Your score is: " + Snake.getScore() , 370, 500);
	}
}
