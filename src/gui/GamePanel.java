package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import constants.Constants;
import entity.Dardo;
import entity.Entity;
import entity.Jugador;
import factory.EnemigoFactory;
import image.Image;
import image.ImageFactory;
import levels.Nivel;
import listener.GameEventListener;
import powers.EfectoTemporal;
import visitor.Visitor;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private ImageIcon BGImage;
	private ImageIcon dig_vida_1;
	private ImageIcon dig_vida_2;
	private ImageIcon dig_vida_3;

	private JLabel lvlClear;

	protected static GamePanel instancia;

	private Timer timer;
	private int tiempodeJuego;
	private boolean inGame;
	private int enemigosMuertos;
	private int dardosEnJuego;
	private int cantViento;

	private Jugador jugador;
	private List<Entity> entidades;
	private List<Entity> aAgregar;
	private List<Nivel> lvls;
	private List<EfectoTemporal> onGoingEffects;

	public GamePanel() {
		inicializarVariables();
		inicializarLayout();
	}

	private void inicializarVariables() {
		this.inGame = true;
		this.jugador = new Jugador();
		jugador.setJugador();

		this.entidades = new ArrayList<Entity>();
		this.aAgregar = new ArrayList<Entity>();
		this.lvls = new ArrayList<Nivel>();
		this.onGoingEffects = new ArrayList<EfectoTemporal>();

		this.enemigosMuertos = 0;
		this.tiempodeJuego = 0;
		this.cantViento = 0;

		for (int i = 1; i < Constants.CANTIDAD_NIVELES + 1; i++) {
			lvls.add(new Nivel(i));
		}

		this.BGImage = ImageFactory.crearImagen(Image.BACKGROUND,
				getClass().getResource(Constants.BACKGROUND_IMAGE_URL));

		this.dig_vida_1 = ImageFactory.crearImagen(Image.NUM_1, getClass().getResource(Constants.NUM_1_IMAGE_URL));
		this.dig_vida_2 = ImageFactory.crearImagen(Image.NUM_0, getClass().getResource(Constants.NUM_0_IMAGE_URL));
		this.dig_vida_3 = ImageFactory.crearImagen(Image.NUM_0, getClass().getResource(Constants.NUM_0_IMAGE_URL));

		this.lvlClear = new JLabel(
				ImageFactory.crearImagen(Image.LVL_CLEAR, getClass().getResource(Constants.LVL_CLEAR_IMAGE_URL)));
		this.lvlClear.setVisible(false);
		this.add(lvlClear);
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

	private void drawEntidades(Graphics g) {
		for (Entity tempEntity : entidades) {
			g.drawImage(tempEntity.getImage(), tempEntity.getX(), tempEntity.getY(), this);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(BGImage.getImage(), 0, 0, null);
		drawEntities(g);
		drawLife(g);
	}

	private void drawEntities(Graphics g) {
		if (inGame) {
			drawJugador(g);
			drawEntidades(g);
		} else {
			if (timer.isRunning()) {
				timer.stop();
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}

	private void drawLife(Graphics g) {
		if (inGame) {
			g.drawImage(dig_vida_1.getImage(), 0, 0, null);
			g.drawImage(dig_vida_2.getImage(), dig_vida_1.getIconWidth(), 0, null);
			g.drawImage(dig_vida_3.getImage(), dig_vida_1.getIconWidth() + dig_vida_2.getIconWidth(), 0, null);
		} else {
			if (timer.isRunning())
				timer.stop();
		}
	}

	public void loop() {
		update();
		repaint();
		tiempodeJuego++;
	}

	private void update() {
		spawnEnemigos();
		movimiento();
		colisiones();
		updateLife();
		efectosPremios();
	}

	private void updateLife() {
		int dig1;
		int dig2;
		int dig3;

		if (jugador.getVida() <= 0) {
			dig1 = 0;
			dig2 = 0;
			dig3 = 0;

		} else {
			dig1 = this.jugador.getVida() / 100;
			dig2 = ((this.jugador.getVida() % 100) / 10);
			dig3 = this.jugador.getVida() % 10;
		}

		this.dig_vida_1 = getImageNumber(dig1);

		this.dig_vida_2 = getImageNumber(dig2);

		this.dig_vida_3 = getImageNumber(dig3);

	}

	private ImageIcon getImageNumber(int num) {
		ImageIcon toReturn = null;
		switch (num) {

		case 0:
			toReturn = ImageFactory.crearImagen(Image.NUM_0, getClass().getResource(Constants.NUM_0_IMAGE_URL));
			break;
		case 1:
			toReturn = ImageFactory.crearImagen(Image.NUM_1, getClass().getResource(Constants.NUM_1_IMAGE_URL));
			break;
		case 2:
			toReturn = ImageFactory.crearImagen(Image.NUM_2, getClass().getResource(Constants.NUM_2_IMAGE_URL));
			break;
		case 3:
			toReturn = ImageFactory.crearImagen(Image.NUM_3, getClass().getResource(Constants.NUM_3_IMAGE_URL));
			break;
		case 4:
			toReturn = ImageFactory.crearImagen(Image.NUM_4, getClass().getResource(Constants.NUM_4_IMAGE_URL));
			break;
		case 5:
			toReturn = ImageFactory.crearImagen(Image.NUM_5, getClass().getResource(Constants.NUM_5_IMAGE_URL));
			break;
		case 6:
			toReturn = ImageFactory.crearImagen(Image.NUM_6, getClass().getResource(Constants.NUM_6_IMAGE_URL));
			break;
		case 7:
			toReturn = ImageFactory.crearImagen(Image.NUM_7, getClass().getResource(Constants.NUM_7_IMAGE_URL));
			break;
		case 8:
			toReturn = ImageFactory.crearImagen(Image.NUM_8, getClass().getResource(Constants.NUM_8_IMAGE_URL));
			break;
		case 9:
			toReturn = ImageFactory.crearImagen(Image.NUM_9, getClass().getResource(Constants.NUM_9_IMAGE_URL));
			break;
		}

		return toReturn;
	}

	private void spawnEnemigos() {
		Random r = new Random();
		int xInicial = r.nextInt(Constants.GAME_WIDTH - 60);
		int yInicial = -10;
		if (!lvls.isEmpty()) {
			Nivel lvlActual = lvls.get(0);

			if (r.nextInt(10) % 5 == 0) {
				EnemigoFactory enemFact = new EnemigoFactory(lvlActual);
				Entity nuevoEnemigo = enemFact.createEntity(xInicial, yInicial);
				if (nuevoEnemigo != null) {
					entidades.add(nuevoEnemigo);
				}
			}


			if (!lvls.isEmpty()) {
				if (enemigosMuertos == lvlActual.getCantEnemigos() && entidades.isEmpty()) {
					terminarNivel();
				}
			} else {
				if (jugador.getVida() <= 0) {
					perder();
				} else {
					ganar();
				}
			}

		} else {
			if (jugador.getVida() <= 0) {
				perder();
			} else {
				ganar();
			}
		}

	}

	private void movimiento() {

		List<Entity> deadEntities = new ArrayList<Entity>();
		
		this.jugador.move();

		for (Entity tempEnt : entidades) {
			if (tempEnt.isDead()) {
				deadEntities.add(tempEnt);
			} else {
				tempEnt.move();

			}
		}
		entidades.removeAll(deadEntities);
	}

	private void colisiones() {
		Rectangle hitbox;
		Visitor visitor;

		for (Entity tempEnt : entidades) {

			hitbox = tempEnt.getHitbox();

			if (hitbox.intersects(jugador.getHitbox())) {
				tempEnt.accept(jugador.getVisitor());
				if (jugador.isDead()) {
					perder();
				}
			}

			for (Entity tempEnt2 : entidades) {
				if (!tempEnt.isDead() && hitbox.intersects(tempEnt2.getHitbox())) {
					visitor = tempEnt.getVisitor();
					tempEnt2.accept(visitor);
				}
			}

		}
		entidades.addAll(aAgregar);
		aAgregar = new ArrayList<Entity>();

	}

	public void agregarEntidad(Entity e) {
		aAgregar.add(e);
	}

	public void efectosPremios() {
		List<EfectoTemporal> efectosCadudacos = new ArrayList<EfectoTemporal>();
		if (!onGoingEffects.isEmpty()) {
			for (EfectoTemporal tempEfc : onGoingEffects) {
				if (tempEfc.getTiempoDeshacer() == tiempodeJuego) {
					efectosCadudacos.add(tempEfc.deshacerEfecto());
				}
			}
			onGoingEffects.removeAll(efectosCadudacos);
		}

	}

	private void terminarNivel() {
		lvls.remove(0);
		entidades = new ArrayList<Entity>();
		for (EfectoTemporal tempEfc : onGoingEffects) {
			tempEfc.deshacerEfecto();
		}
		onGoingEffects = new ArrayList<EfectoTemporal>();
		dardosEnJuego = 0;
		enemigosMuertos = 0;
		cantViento = 0;
		lvlClear.setVisible(true);
		timer.stop();
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				lvlClear.setVisible(false);
				timer.start();
			}
		}, 750);

	}

	private void ganar() {
		if (timer.isRunning())
			timer.stop();
		JOptionPane.showMessageDialog(this, "GANASTE!!", "JUEGO TERMINADO", JOptionPane.INFORMATION_MESSAGE, null);
		System.exit(0);
	}

	private void perder() {
		updateLife();
		repaint();
		if (timer.isRunning())
			timer.stop();
		JOptionPane.showMessageDialog(this, "PERDISTE \n Reseteando nivel.", "JUEGO TERMINADO",
				JOptionPane.INFORMATION_MESSAGE, null);
		resetLevel();
	}

	private void resetLevel() {
		if (timer.isRunning())
			timer.stop();
		// resetea en nievel actual.
		if (!lvls.isEmpty()) {
			lvls.get(0).reiniciarNivel();
			enemigosMuertos = 0;
			dardosEnJuego = 0;
			cantViento = 0;
			this.jugador = new Jugador();
			this.jugador.setJugador();
			this.jugador.decreaseLives(50);
			for (Entity tempEnt : entidades) {
				tempEnt.setDead(true);
			}
			this.entidades = new ArrayList<Entity>();
			for (EfectoTemporal tempEfc : onGoingEffects) {
				tempEfc.deshacerEfecto();
			}
			this.onGoingEffects = new ArrayList<EfectoTemporal>();
			timer.restart();
		}
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (dardosEnJuego < 5) {
				entidades.add(new Dardo(jugador.getX()));
				dardosEnJuego++;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			pause();
		} else {
			this.jugador.keyPressed(e);
		}

	}

	public void setDardosEnJuego(int i) {
		dardosEnJuego = i;
	}

	public void registrarEnemigoMuerto() {
		enemigosMuertos++;
	}

	public int getDardosEnJuego() {
		return dardosEnJuego;
	}

	private void pause() {
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.start();
		}

	}

	public void keyReleased(KeyEvent e) {
		this.jugador.keyReleased(e);
	}

	public static GamePanel getInstancia() {
		if (instancia == null) {
			instancia = new GamePanel();
		}

		return instancia;
	}

	public List<Entity> getEntities() {
		return this.entidades;
	}

	public void setEfecto(EfectoTemporal e) {
		onGoingEffects.add(e);
	}

	public void removeEfecto(EfectoTemporal e) {
		onGoingEffects.remove(e);
	}

	public int getTiempoDeJuego() {
		return tiempodeJuego;
	}
	
	public int getCantViento() {
		return cantViento;
	}
	
	public void aumentarCantViento() {
		cantViento++;
	}
	
	public void decrementarCantViento() {
		cantViento--;
	}
	
}
