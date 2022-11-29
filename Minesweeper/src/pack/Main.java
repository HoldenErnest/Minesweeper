package pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.List;
import java.math.*;

public class Main {
	
	private static int gameSize = 32;
	private static Rectangle[][] rectMatrix;//grid of graphics
	private static int numBombs = 150;
	
	private static MyFrame m;
	private static Controller c;
	
	public static void main(String[] args) {
		c = new Controller();
		m = new MyFrame("Minesweeper (32x32)");
		rectMatrix = new Rectangle[gameSize][gameSize];
		createRecs();
		placeBombs(numBombs);
		
		//revealAll();
	}
	
	public static void createRecs() { //instantiate a group of rectangles to do whatever with.
		//summon rectangles
		for (int i = 0; i < rectMatrix.length; i++) {
			for (int j = 0; j < rectMatrix[0].length; j++) {
				rectMatrix[i][j] = new Rectangle((i*20),j*20,21,20);
			}
		}
	}
	public static void placeBombs(int bombsToPlace) {
		int nx = (int)(Math.random()*gameSize);
		int ny = (int)(Math.random()*gameSize);
		
		if (!rectMatrix[nx][ny].isBomb()) {//bomb can be placed
			if (bombsToPlace > 0) {
				rectMatrix[nx][ny].setBomb();
				placeBombs(bombsToPlace - 1);
			}
		} else {
			placeBombs(bombsToPlace);
		}
	}
	
	public static int getGameSize() {
		return gameSize;
	}
	public static Rectangle[][] getList() {
		return rectMatrix;
	}
	public static Controller getController() {
		return c;
	}
	
	public static MyFrame getMyFrame() {
		return m;
	}
	
	public static Rectangle findRectByPixil(int xx, int yy) {
		
		int xg = (int)((xx-10) / 20);//-10 for center of rect
		int yg = (int)((yy-32) / 20);//-22 for title bar offset
		return rectMatrix[xg][yg];
	}
	
	public static void revealAll() {
		for (Rectangle[] arr : rectMatrix) {
			for (Rectangle thisRect : arr) {
				if (!thisRect.isBomb())
					thisRect.flip();
			}
		}
	}
	
	public static int numBombsNear(Rectangle thisRect) {
		int xLocation = getRectMatrixPosX(thisRect);
		int yLocation = getRectMatrixPosY(thisRect);
		int bombsNearCount = 0;
		//find the rectangles location inside the array
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if ((xLocation + i >= 0 && xLocation + i < gameSize) && (yLocation + j >= 0 && yLocation + j < gameSize))
				if (rectMatrix[xLocation + i][yLocation + j].isBomb()) {
					bombsNearCount++;
				}
			}
		}
		
		return bombsNearCount;
	}
	
	public static void restart() {
		createRecs();
		placeBombs(numBombs);
		//revealAll();
	}
	
	public static void revealNeigbors(Rectangle thisRect) {
		int xLocation = getRectMatrixPosX(thisRect);
		int yLocation = getRectMatrixPosY(thisRect);
		int bombsNearCount = 0;
		//find the rectangles location inside the array
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if ((xLocation + i >= 0 && xLocation + i < gameSize) && (yLocation + j >= 0 && yLocation + j < gameSize))
					rectMatrix[xLocation + i][yLocation + j].flip();
			}
		}
	}
	
	public static int getRectMatrixPosX(Rectangle thisRect) {
		int xLocation = 0;
		int yLocation = 0;
		for (int i = 0; i < rectMatrix.length; i++)
			if (Arrays.asList(rectMatrix[i]).indexOf(thisRect) >= 0) {
				xLocation = i;
				yLocation = Arrays.asList(rectMatrix[i]).indexOf(thisRect);
			}
		return xLocation;
	}
	public static int getRectMatrixPosY(Rectangle thisRect) {
		int xLocation = 0;
		int yLocation = 0;
		for (int i = 0; i < rectMatrix.length; i++)
			if (Arrays.asList(rectMatrix[i]).indexOf(thisRect) >= 0) {
				xLocation = i;
				yLocation = Arrays.asList(rectMatrix[i]).indexOf(thisRect);
			}
		
		return yLocation;
	}
	
	
}
