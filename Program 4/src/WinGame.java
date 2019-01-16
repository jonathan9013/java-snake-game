import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
//	creates win game panel
public class WinGame extends JPanel{
	public WinGame(){
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times New Roman", Font.BOLD, 40));
		g.drawString("Congradulations! You Win!" , 300, 400);
		g.drawString("Your score is: 1000000" , 370, 500);
	}
}
