package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import constants.Constants;
import entity.Dardo;
import entity.Globo;
import entity.Jugador;
import entity.Premio;
import image.Image;
import image.ImageFactory;
import levels.Nivel;
import listener.GameEventListener;
import visitor.GloboCollisionVisitor;
import visitor.JugadorCollisionVisitor;

public class GamePanel extends JPanel {

	private ImageIcon BGImage;
	private Timer timer;
	private boolean inGame;
	private int globosRojos;
	private int globosAzules;
	private int globosVerdes;
	private int cantPremios;

	private Jugador jugador;
	private List<Dardo> darts;
	private List<Globo> bloons;
	private List<Premio> premios;
	private List<Nivel> lvls;

	public GamePanel() {
		inicializarVariables();
		inicializarLayout();
	}

	private void inicializarVariables() {
		this.inGame = true;
		this.jugador = new Jugador();
		jugador.setJugador();

		this.darts = new ArrayList<Dardo>();
		this.bloons = new ArrayList<Globo>();
		this.premios = new ArrayList<Premio>();
		this.lvls = new ArrayList<Nivel>();

		for (int i = 1; i < Constants.CANTIDAD_NIVELES + 1; i++) {
			lvls.add(new Nivel(i));
		}

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
		for (Dardo tempDart : darts) {
			g.drawImage(tempDart.getImage(), tempDart.getX(), tempDart.getY(), this);
		}
	}

	private void drawGlobos(Graphics g) {
		for (Globo tempBloon : bloons) {
			g.drawImage(tempBloon.getImage(), tempBloon.getX(), tempBloon.getY(), this);
		}
	}

	private void drawPremios(Graphics g) {
		for (Premio tempPremios : premios) {
			g.drawImage(tempPremios.getImage(), tempPremios.getX(), tempPremios.getY(), this);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(BGImage.getImage(), 0, 0, null);

		drawEntities(g);
	}

	private void drawEntities(Graphics g) {
		if (inGame) {
			drawJugador(g);
			drawDardos(g);
			drawGlobos(g);
			drawPremios(g);
		} else {
			if (timer.isRunning()) {
				timer.stop();
			}
		}

		Toolkit.getDefaultToolkit().sync();

	}

	public void loop() {
		update();
		repaint();
		// System.out.println(darts.size());
		// System.out.println(bloons.size());
		//perder(); //Borrar
	}

	private void update() {
		spawnEnemigos();
		spawnPremios();
		movimiento();
		colisiones();
	}

	private void spawnPremios() {
		Random r = new Random();

		if (r.nextInt(100) % 5 == 0) {
			if (!lvls.isEmpty() && cantPremios < lvls.get(0).getCantPremios()) {
				premios.add(new Premio(r.nextInt(100) % 2));
				cantPremios++;
			}
		}

	}

	private void spawnEnemigos() {
		Random r = new Random();
		boolean agregadoEsteTick = false;

		if (r.nextInt(1000) % 50 == 0 && !lvls.isEmpty()) {
			if (globosRojos < lvls.get(0).getCantRojos()) {
				bloons.add(new Globo(1));
				globosRojos++;
				agregadoEsteTick = true;
			}

			if (globosAzules < lvls.get(0).getCantAzules() && !agregadoEsteTick) {
				bloons.add(new Globo(2));
				globosAzules++;
				agregadoEsteTick = true;
			}

			if (globosVerdes < lvls.get(0).getCantVerdes() && !agregadoEsteTick) {
				bloons.add(new Globo(3));
				globosVerdes++;
			}
		}

		if (!lvls.isEmpty()) {
			if (globosRojos + globosAzules + globosVerdes == lvls.get(0).getCantEnemigos()) {
				if (bloons.isEmpty()) {
					terminarNivel();
				}
			}
		} else {
			if (jugador.getVidas() <= 0) {
				perder();
			} else {
				ganar();
			}
		}

	}

	private void movimiento() {

		List<Dardo> consumedDart = new ArrayList<Dardo>();
		List<Globo> popped = new ArrayList<Globo>();
		List<Premio> consumedPrize = new ArrayList<Premio>();

		this.jugador.move();

		for (Dardo tempDart : darts) {
			if (tempDart.isDead()) {
				consumedDart.add(tempDart);
			} else {
				tempDart.move();
			}
		}
		darts.removeAll(consumedDart);

		for (Globo tempBloon : bloons) {
			if (tempBloon.isDead()) {
				popped.add(tempBloon);
			} else {
				tempBloon.move();
			}
		}
		bloons.removeAll(popped);

		for (Premio tempPremio : premios) {
			if (tempPremio.isDead()) {
				consumedPrize.add(tempPremio);
			} else {
				tempPremio.move();

			}
		}
		premios.removeAll(consumedPrize);

	}

	private void colisiones() {
		Rectangle hitbox;
		GloboCollisionVisitor visitorGlobo;
		JugadorCollisionVisitor visitorJugador = new JugadorCollisionVisitor(jugador);

		for (Globo tempBloon : bloons) {
			hitbox = tempBloon.getHitbox();

			if (hitbox.intersects(jugador.getHitbox())) {
				tempBloon.accept(visitorJugador);
				if(jugador.isDead()) {
					perder();
				}
			}

			for (Dardo tempDart : darts) {
				System.out.println(hitbox.intersects(tempDart.getHitbox()));

				if (!tempBloon.isDead() && hitbox.intersects(tempDart.getHitbox())) {
					visitorGlobo = new GloboCollisionVisitor(tempBloon);
					tempDart.accept(visitorGlobo);
				}
			}
		}

		for (Premio tempPremio : premios) {
			if (tempPremio.getHitbox().intersects(jugador.getHitbox())) {
				tempPremio.accept(visitorJugador);
			}
		}
		
		System.out.println(jugador.getVidas());

	}

	private void terminarNivel() {
		lvls.remove(0);
		globosRojos = 0;
		globosAzules = 0;
		globosVerdes = 0;
		cantPremios = 0;
	}

	private void ganar() {
		timer.stop();
		JOptionPane.showMessageDialog(this, "GANASTE!!", "Resultado", JOptionPane.INFORMATION_MESSAGE, null);
		//luego de quitar el cartel se cierra el juego?
		System.out.println("aca termino todo señores"); //Borrar
	}
	
	private void perder() {
		timer.stop();
		JOptionPane.showMessageDialog(this, "PERDISTE /n Reseteando nivel.", "Resultado", JOptionPane.INFORMATION_MESSAGE, null);
		resetLevel(); //Resetea el nivel despues de perder?

	}

	private void resetLevel() {
		//resetea en nievel actual.
		if (!lvls.isEmpty()) {
			Nivel nivel_actual = lvls.get(0);
			nivel_actual.reset();
			//no se como mierda resetear las imagenes y las entidades del juego (estoy perdidisimo)
			timer.restart();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		this.jugador.keyPressed(e);

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (darts.size() < 5) {
				darts.add(new Dardo(jugador.getX()));
			}

		}

	}

	public void keyReleased(KeyEvent e) {
		this.jugador.keyReleased(e);
	}

}
