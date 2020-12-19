package entity;


import constants.Constants;
import powers.Efecto;
import visitor.PremioCollisionVisitor;
import visitor.Visitor;

public class Premio extends Entity{
	
	private Efecto efecto;
	
	
	public Premio() {
		inicializar();
	}
	
	private void inicializar() {
		velocidad = 3;
		visitor = new PremioCollisionVisitor(this);
		setHitbox();
	}

	@Override
	public void move() {
		this.y += this.velocidad;
		if(y>Constants.GAME_HEIGHT) {
			this.setDead(true);
		}
		setHitbox();
	}
	
	public void trigger() {
		efecto.realizarEfecto();
	}
	
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	
	public void setEfecto(Efecto e) {
		efecto = e;
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


	
}
