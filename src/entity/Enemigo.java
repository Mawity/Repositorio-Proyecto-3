package entity;

import java.util.Random;

import constants.Constants;
import factory.PremioFactory;
import factory.VientoFactory;
import gui.GamePanel;
import visitor.EnemigoCollisionVisitor;
import visitor.Visitor;

public class Enemigo extends Entity {

	protected int vida;
	protected int dmg;
	protected boolean haDisparado;
	protected PremioFactory fact;

	public Enemigo() {
		this.visitor = new EnemigoCollisionVisitor(this);
		fact = new PremioFactory();
		haDisparado = false;
	}

	@Override
	public void accept(Visitor v) {

	}

	@Override
	public void move() {
		GamePanel gp = GamePanel.getInstancia();
		Jugador jugador = Jugador.getJugador();
		Random r = new Random();

		y += velocidad;
		if (y > Constants.GAME_HEIGHT) {
			y = -altoSprite;
			dmg /= 2;
			realizarDmg(jugador);
			dmg *= 2;
		}

		setHitbox();

		if (!haDisparado && r.nextInt(25) == 0 && gp.getCantViento()<5) {
			if (jugador.getX() < getX() + anchoSprite && jugador.getX() + jugador.getHitbox().getWidth() > getX()) {
				lanzarViento(gp);
			}

		}

	}

	private void lanzarViento(GamePanel gp) {
		
		VientoFactory vienFactory = new VientoFactory();
		Entity viento = vienFactory.createEntity(x+anchoSprite/2, y+altoSprite);
		
		gp.agregarEntidad(viento);
		gp.aumentarCantViento();
		haDisparado = true;

	}

	public void realizarDmg(Jugador jugador) {
		jugador.decreaseLives(dmg);
	}

	public void decreaseLives(int dmgTaken) {
		this.vida -= dmgTaken;

	}

	public int getVida() {
		return vida;
	}

	@Override
	public void setVelocidad(int i) {

	}

	@Override
	public int getVelocidad() {
		return this.velocidad;
	}

	@Override
	public void setDead(boolean dead) {
		super.setDead(dead);
		if (dead) {
			Random rand = new Random();
			GamePanel gp = GamePanel.getInstancia();
			int r = rand.nextInt(100);
			if (r % 15 == 0) {
				gp.agregarEntidad(fact.createEntity(this.x, this.y));
			}
			gp.registrarEnemigoMuerto();
		}
	}

}
