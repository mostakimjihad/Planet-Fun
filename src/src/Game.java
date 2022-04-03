package src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{
	static final int gameWidth = 1000;
	static final int gameHeight = 555;
	static final Dimension gameSize = new Dimension(gameWidth, gameHeight);
	static final int ballDiameter = 95;
	static final int barWidth = 76;
	static final int barHeight = 202;
	Random random;
	Bar bar1;
	JFrame frame;
	Thread gameThread;
	Image image;
	Image backgroundImage;
	ImageIcon logo = new ImageIcon("jihad.png");
	Graphics graphics;
	Bar bar2;
	Ball ball;
	Score score;
	
	Game(){
		frame = new JFrame();
		frame.add(this);
		newPaddles();
		newBall();
		score = new Score(gameWidth, gameHeight);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(gameSize);
		backgroundImage = new ImageIcon("background2.png").getImage();
		frame.setTitle("Planet Fun");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(logo.getImage());
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall() {
		
		random = new Random();
		ball = new Ball((gameWidth/2)-(ballDiameter/2), random.nextInt(gameHeight-ballDiameter), ballDiameter, ballDiameter);
		
	}
	public void newPaddles() {
		
		bar1 = new Bar(0,(gameHeight/2)-(barHeight/2),barWidth, barHeight,1);
		bar2 = new Bar(gameWidth-barWidth,(gameHeight/2)-(barHeight/2), barWidth, barHeight,2);
		
	}
	public void paint(Graphics g) {
		
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
		
	}
	public void draw(Graphics g) {
		
		g.drawImage(backgroundImage, 0, 0, null);
		bar1.draw(g);
		bar2.draw(g);
		ball.draw(g);
		score.draw(g);
 
	}
	public void move() {
		bar1.move();
		bar2.move();
		ball.move();
	}
	public void checkCollision() {
		
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= gameHeight-ballDiameter) {
			ball.setYDirection(-ball.yVelocity);
		}

		if(ball.intersects(bar1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++;
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(ball.intersects(bar2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; 
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(bar1.y<=0)
			bar1.y=0;
		if(bar1.y >= (gameHeight-barHeight))
			bar1.y = gameHeight-barHeight;
		if(bar2.y<=0)
			bar2.y=0;
		if(bar2.y >= (gameHeight-barHeight))
			bar2.y = gameHeight-barHeight;
		if(ball.x <=0) {
			score.player2++;
			newPaddles();
			newBall();
		}
		if(ball.x >= gameWidth-ballDiameter) {
			score.player1++;
			newPaddles();
			newBall();
		}
	}
	public void run() {
		
		long startTime = System.nanoTime();
		double gameFPS =60.0;
		double ns = 1000000000 / gameFPS;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -startTime)/ns;
			startTime = now;
			if(delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		 
		public void keyPressed(KeyEvent e) {
			bar1.keyPressed(e);
			bar2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			bar1.keyReleased(e);
			bar2.keyReleased(e);
		}
	}
}
