package pack;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class Controller extends Component implements MouseListener {
	
	private int downX;
	private int downY;
	public static boolean gameOver = false;
	
	public void _update() {
		
	}
	public void _frameUpdate() {
		
	}
	public void _inputUpdate() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//somthigns ehres
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		downX = e.getX();
		downY = e.getY();
		if (!gameOver) {
			if ((downX < MyFrame.getScreenWidth() && downX > 0) && (downY < MyFrame.getScreenHeight() && downY > 0)) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					Main.findRectByPixil(downX, downY).flip();
				} else if (SwingUtilities.isRightMouseButton(e)) {
					Main.findRectByPixil(downX, downY).toggleFlag();
				}
			}
		} else {
			gameOver = false;
			Main.restart();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
