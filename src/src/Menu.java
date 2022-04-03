package src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Menu extends JPanel implements MouseListener, ActionListener, MouseMotionListener{
	final int width = 1000;
	final int height = 555;
	int v1 = 1;
	int v2 = 1;
	int y1 = 353;
	int y2 = 0;
    final Dimension size = new Dimension(width,height);
	Timer timer;
	JPanel panel;
	JFrame frame;
	Image background = new ImageIcon("menu2.png").getImage();
	Image btn1 = new ImageIcon("btn1.png").getImage();
	Image btn1h = new ImageIcon("btn1-h.png").getImage();
	Image btn2 = new ImageIcon("btn2.png").getImage();
	Image btn2h = new ImageIcon("btn2-h.png").getImage();
	Image btn3 = new ImageIcon("btn3.png").getImage();
	Image btn3h = new ImageIcon("btn3-h.png").getImage();
	Image button1 = btn1;
	Image button2 = btn2;
	Image button3 = btn3;
	Image animation1 = new ImageIcon("bar1.png").getImage();
	Image animation2 = new ImageIcon("bar2.png").getImage();
	ImageIcon logo = new ImageIcon("jihad.png");
	Menu(){
		frame = new JFrame();
		frame.add(this);
        this.setFocusable(true);
		this.setPreferredSize(size);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		frame.setTitle("Menu");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(logo.getImage());

		timer = new Timer(10,this);
		timer.start();
	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(button1, 400, 245, null);
		g.drawImage(button2, 380, 330, null);
		g.drawImage(button3, 400, 420, null);
		g.drawImage(animation1, 0, y1, null);
		g.drawImage(animation2, 924, y2, null);
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		if(mx >= 400 && mx <= 400 + 225 ) {
			if(my >= 245 && my <= 245 + 83) {
				frame.dispose();
				new Game(); 
			}
		}
		if(mx >= 400 && mx <= 400 + 225 ) {
			if(my >= 420 && my <= 420 + 83) {
				frame.dispose();
			}
		}
		if(mx >= 380 && mx <= 380 + 263 ) {
			if(my >= 330 && my <= 330 + 64) {
				frame.dispose();
				new About();
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(y1>= 353 || y1<0) {
			v1 = v1 * -1;
		}
		if(y2>= 353 || y2<0) {
			v2 = v2 * -1;
		}
		y1 = y1 + v1;
		y2 = y2 + v2;
		repaint();
	}
	public void mouseDragged(MouseEvent e) {
		
	}
	public void mouseMoved(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		if(mx >= 400 && mx <= 400 + 225 ) {
			if(my >= 245 && my <= 245 + 83) {
				button1 = btn1h;
				button2 = btn2;
				button3 = btn3;
				repaint();
			}
		}
		else {
			button1 = btn1;
		    repaint();
		}
		if(mx >= 380 && mx <= 380 + 263 ) {
			if(my >= 330 && my <= 330 + 64) {
				button2 = btn2h;
				button1 = btn1;
				button3 = btn3;
				repaint();
			}
		}
		else {
			button2 = btn2;
		    repaint();
		}
		if(mx >= 400 && mx <= 400 + 225 ) {
			if(my >= 420 && my <= 420 + 83) {
				button3 = btn3h;
				button1 = btn1;
				button2 = btn2;
				repaint();
			}
		}
		else {
			button3 = btn3;
		    repaint();
		}
    }
	public static void main(String[] args) {
		new Menu();
	}
}