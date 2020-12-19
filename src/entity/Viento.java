package entity;

import constants.Constants;
import gui.GamePanel;
import visitor.VientoCollisionVisitor;
import visitor.Visitor;

public class Viento extends Entity {

	private int dmg;
	
	
	public Viento() {
		inicializar();
	}

	private void inicializar() {
		velocidad = 4;
		dmg = 3;
		visitor = new VientoCollisionVisitor(this);
		setHitbox();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);

	}

	@Override
	public void move() {
		y += velocidad;
		if(y>Constants.GAME_HEIGHT) {
			setDead(true);
		}
		
		setHitbox();
	}



	@Override
	public void setVelocidad(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVida() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void realizarDmg(Jugador jugador) {
		jugador.decreaseLives(dmg);		
	}
	
	@Override
	public void setDead(boolean dead) {
		GamePanel gp = GamePanel.getInstancia();
		super.setDead(dead);
		gp.decrementarCantViento();
	}

}
