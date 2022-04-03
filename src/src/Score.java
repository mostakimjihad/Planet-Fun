package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Score extends Rectangle {
	private int gameWidth;
	private int gameHeight;
	int player1;
	int player2;
	
	Score(int gameWidth, int gameHeight){
	    this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
	}
	public void draw(Graphics g) {
		
		g.setFont(new Font("Digital-7",Font.PLAIN,60));
		
		g.setColor(new Color(17, 246, 23));
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (gameWidth/2)-80, 50);
		g.setColor(new Color(0, 192, 255));
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (gameWidth/2)+20, 50);
	}
}
