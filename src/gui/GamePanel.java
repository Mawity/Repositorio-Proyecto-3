package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import constants.Constants;
import entity.Dardo;
import entity.Jugador;
import image.Image;
import image.ImageFactory;
import listener.GameEventListener;

public class GamePanel extends JPanel {
	
	private ImageIcon BGImage;
	private Timer timer;
	private boolean inGame;
	
	private Jugador jugador;
	private List<Dardo> darts;

	public GamePanel() {
		inicializarVariables();
		inicializarLayout();
	}

	private void inicializarVariables() {
		this.inGame = true;
		this.jugador = new Jugador();
		this.darts = new ArrayList<Dardo>();
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
	
	private void drawDardos(Graphics g) {
		for(Dardo tempDart: darts) {
			g.drawImage(tempDart.getImage(), tempDart.getX(), tempDart.getY(), this);
		}
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
			drawDardos(g);
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
		System.out.println(darts.size());
	}

	private void update() {
		List<Dardo> offLimits = new ArrayList<Dardo>();
		
		this.jugador.move();
		for(Dardo tempDart: darts) {
			if(tempDart.isDead()) {
				offLimits.add(tempDart);
			}else {
				tempDart.move();
			}
		}
		
		darts.removeAll(offLimits);
		
		
		
	}

	public void keyPressed(KeyEvent e) {
		this.jugador.keyPressed(e);
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			darts.add(new Dardo(jugador.getX()));
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		this.jugador.keyReleased(e);
	}	
	
	
	
	
	
	
	
	
	
}
