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
import javax.swing.JLabel;
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
import powers.EfectoTemporal;
import visitor.GloboCollisionVisitor;
import visitor.JugadorCollisionVisitor;

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
	private int globosRojos;
	private int globosAzules;
	private int globosVerdes;
	private int cantPremios;


	private Jugador jugador;
	private List<Dardo> darts;
	private List<Globo> bloons;
	private List<Premio> premios;
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

		this.darts = new ArrayList<Dardo>();
		this.bloons = new ArrayList<Globo>();
		this.premios = new ArrayList<Premio>();
		this.lvls = new ArrayList<Nivel>();
		this.onGoingEffects = new ArrayList<EfectoTemporal>();

		for (int i = 1; i < Constants.CANTIDAD_NIVELES + 1; i++) {
			lvls.add(new Nivel(i));
		}

		this.BGImage = ImageFactory.crearImagen(Image.BACKGROUND, getClass().getResource(Constants.BACKGROUND_IMAGE_URL));	
		
		this.dig_vida_1 = ImageFactory.crearImagen(Image.NUM_1, getClass().getResource(Constants.NUM_1_IMAGE_URL));
		this.dig_vida_2 = ImageFactory.crearImagen(Image.NUM_0, getClass().getResource(Constants.NUM_0_IMAGE_URL));
		this.dig_vida_3 = ImageFactory.crearImagen(Image.NUM_0, getClass().getResource(Constants.NUM_0_IMAGE_URL));
		
		this.lvlClear = new JLabel(ImageFactory.crearImagen(Image.LVL_CLEAR, getClass().getResource(Constants.LVL_CLEAR_IMAGE_URL)));
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
		drawLife(g);
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
	
	private void drawLife(Graphics g) {
		if (inGame) {
			g.drawImage(dig_vida_1.getImage(), 0, 0, null);
			g.drawImage(dig_vida_2.getImage(), dig_vida_1.getIconWidth(), 0, null);
			g.drawImage(dig_vida_3.getImage(), dig_vida_1.getIconWidth()+dig_vida_2.getIconWidth(), 0, null);
		}else {
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
		spawnPremios();
		movimiento();
		colisiones();
		updateLife();
		efectosPremios();
	}
	
	private void updateLife() {
		int dig1; 
		int dig2;
		int dig3;
		
		if(jugador.getVidas()<=0) {
			dig1 = 0;
			dig2 = 0;
			dig3 = 0;
			
		}else {
			dig1 = this.jugador.getVidas()/100;
			dig2 = ((this.jugador.getVidas()%100) / 10);
			dig3 = this.jugador.getVidas() % 10;
		}

			this.dig_vida_1 = getImageNumber(dig1);

			this.dig_vida_2 = getImageNumber(dig2);

			this.dig_vida_3 = getImageNumber(dig3);
		
	}
	
	private ImageIcon getImageNumber(int num) {
		ImageIcon toReturn = null;
		switch(num) {
		
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
	
	private void spawnPremios() {
		Random r = new Random();

		if (!lvls.isEmpty() && lvls.get(0).getCantRojos()==globosRojos && r.nextInt(100) % 15 == 0) {
			if (!lvls.isEmpty() && cantPremios < lvls.get(0).getCantPremios()) {
				premios.add(new Premio(r.nextInt(100) % 3));
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
	
	public void efectosPremios() {
		if(!onGoingEffects.isEmpty()) {
			EfectoTemporal efectoActivo = onGoingEffects.get(0);
			if(efectoActivo.getTiempoDeshacer() == tiempodeJuego) {
				efectoActivo.deshacerEfecto();
			}
		}
		
	}

	private void terminarNivel() {
		lvls.remove(0);
		globosRojos = 0;
		globosAzules = 0;
		globosVerdes = 0;
		cantPremios = 0;
		lvlClear.setVisible(true);
		timer.stop();
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	lvlClear.setVisible(false);
		            	timer.start();
		            }
		        }, 
		        750 
		);
		
		
		
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
		JOptionPane.showMessageDialog(this, "PERDISTE \n Reseteando nivel.", "JUEGO TERMINADO", JOptionPane.INFORMATION_MESSAGE, null);
		resetLevel();
	}

	private void resetLevel() {
		if (timer.isRunning())
			timer.stop();
		//resetea en nievel actual.
		if (!lvls.isEmpty()) {
			this.jugador = new Jugador();
			this.jugador.setJugador();
			this.jugador.decreaseLives(50);
			this.darts = new ArrayList<Dardo>();
			this.bloons = new ArrayList<Globo>();
			this.premios = new ArrayList<Premio>();
			timer.restart();
		}
	}
		
	
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (darts.size() < 5) {
				darts.add(new Dardo(jugador.getX()));
			}			
		}else {
			this.jugador.keyPressed(e);

		}

	}

	public void keyReleased(KeyEvent e) {
		this.jugador.keyReleased(e);
	}

	
	
	public static GamePanel getInstancia()
	{
		if (instancia == null)
		{
			instancia = new GamePanel();
		}
		
		return instancia;
	}
	
	public List<Globo> getBloons(){
		return this.bloons;
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
}
