package pack;

import java.awt.Image;

import javax.swing.*;

public class MyFrame extends JFrame {
	
	private static int screenWidth = 655;
	private static int screenHeight = 677;//640x640 + offset
	
	
	MyFrame(String s) {
		super(s);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenWidth, screenHeight);
		this.setLayout(null);
		this.addMouseListener(Main.getController());
		
		this.setVisible(true);
		//this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("src/icon.png")));
		
	}
	
	//accessor methods
	public static int getScreenWidth() {
		return screenWidth;
	}
	public static int getScreenHeight() {
		return screenHeight;
	}
	
}