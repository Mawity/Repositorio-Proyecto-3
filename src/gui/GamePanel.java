package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import constants.Constants;
import entity.Jugador;
import image.Image;
import image.ImageFactory;
import listener.GameEventListener;

public class GamePanel extends JPanel {
	
	private ImageIcon BGImage;
	private Timer timer;
	private Jugador jugador;
	private boolean inGame;

	public GamePanel() {
		inicializarVariables();
		inicializarLayout();
	}

	private void inicializarVariables() {
		this.inGame = true;
		this.jugador = new Jugador();
		this.BGImage = ImageFactory.crearImagen(Image.BACKGROUND);
		this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
		this.timer.start();
	}

	private void inicializarLayout() {
		addKeyListener(new GameEventListener(this));
		setFocusable(true);
		setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
	}
	
	private void drawJugador(Graphics g) {
		g.drawImage(jugador.getImage(), jugador.getX(), jugador.getY(), this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(BGImage.getImage(), 0, 0, null);

		drawEntities(g);
	}
	
	
	private void drawEntities(Graphics g) {
		if(inGame) {
			drawJugador(g);
		} else{
			if(timer.isRunning()) {
				timer.stop();
			}
		}
		
		Toolkit.getDefaultToolkit().sync();
		
	}

	public void loop() {
		update();
		repaint();
	}

	private void update() {
		this.jugador.move();
	}

	public void keyPressed(KeyEvent e) {
		this.jugador.keyPressed(e);
		
	}
	
	public void keyReleased(KeyEvent e) {
		this.jugador.keyReleased(e);
	}	
	
	
	
	
	
	
	
	
	
}
