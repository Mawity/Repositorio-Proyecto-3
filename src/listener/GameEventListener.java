package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import gui.GamePanel;

public class GameEventListener extends KeyAdapter{

	private GamePanel panel;
	
	public GameEventListener(GamePanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		this.panel.keyReleased(e);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		this.panel.keyPressed(e);
	}
	
}
