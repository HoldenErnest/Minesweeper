package pack;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Rectangle extends Shape {
	
	private int width, height;
	private JLabel selectedRect = new JLabel();;//The graphics object
	ImageIcon icon;
	public static int totalFlipped = 0;
	
	private boolean isFlagged = false;
	private boolean isFlipped = false;
	private boolean bombRect = false;
	
	Rectangle(int x1, int y1, int x2, int y2) {
		super();
		setX(x1);
		setY(y1);
		width = x2;
		height = y2;
		createRect();
		
	}
	
	public void createRect() {
		selectedRect.setBounds(getX(), getY(), width, height);
		selectedRect.setOpaque(true);
		Main.getMyFrame().add(selectedRect);
		//setColor(new Color(r, g, b));
		icon = new ImageIcon("src/assets/square-1.png");
		updateIcon();
	}
	
	public void setColor(Color c) {
		selectedRect.setBackground(c);
	}
	public void updateIcon() {
		selectedRect.setIcon(icon);
	}
	public boolean isBomb() {
		return bombRect;
	}
	public void setBomb() {
		bombRect = true;
	}
	
	public void moveRect(int xx, int yy) {
		setX(getX() + xx);
		setY(getY() + yy);
		selectedRect.setLocation(selectedRect.getX() + xx, selectedRect.getY() + yy);
	}
	public void setRectPosition(int xx, int yy) {
		setX(xx);
		setY(yy);
		selectedRect.setLocation(xx, yy);
	}
	public void toggleFlag() {
		if (!isFlipped) {
			if (!isFlagged)  {
				icon = new ImageIcon("src/assets/flagged.png");
				isFlagged = true;
			}
			else {
				isFlagged = false;
				icon = new ImageIcon("src/assets/square-1.png");
			}
		}
		updateIcon();
	}
	
	public void flip() {
		if (!isFlipped) {
			isFlipped = true;
			int bombNeigbors = Main.numBombsNear(this);
		
			if (!isBomb()) {
				totalFlipped++;
				//check all neighbors, if bomb add 1 to count, set icon to count number
				
				icon = new ImageIcon("src/assets/square" + bombNeigbors + ".png");
				if (bombNeigbors == 0) {
					Main.revealNeigbors(this);
				}
			} else {
				icon = new ImageIcon("src/assets/bomb.png");
				System.out.println("You Lose! Click to continue");
				Controller.gameOver = true;
			}
			//if you lost dont update
			updateIcon();
		}
	}
	
	public void setIcon(int s) {
		icon = new ImageIcon("src/assets/square" + s + ".png");
		updateIcon();
	}
	
}
