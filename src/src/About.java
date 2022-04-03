package src;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.Game.AL;

public class About extends JPanel{
	
	JFrame frame;
	Dimension size = new Dimension(1000,555);
    Image about;
    ImageIcon logoIcon = new ImageIcon("jihad.png");
	About(){
		frame = new JFrame();
		frame.add(this);
		this.setFocusable(true);
		this.setPreferredSize(size);
		about = new ImageIcon("about.png").getImage();
		frame.setTitle("Planet Fun");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(logoIcon.getImage());
	}
	public void paint (Graphics g) {
		g.drawImage(about, 0,0,null);
	}
}
