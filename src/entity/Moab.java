package entity;


import constants.Constants;
import visitor.Visitor;

public class Moab extends Enemigo {

	private boolean berserk;
	
	public Moab() {
		super();
		incializar();
	}

	private void incializar() {
		vida = Constants.VIDA_MAXIMA_MOAB;
		velocidad = Constants.VELOCIDAD_BASE_ENEMIGO;
		dmg = Constants.VIDA_MAXIMA_MOAB / 2;
		berserk = false;
		setHitbox();		
	}





	public void decreaseLives(int dmgTaken) {
		vida -= dmgTaken;

		if (vida <= 0) {
			setDead(true);
		} else if (!berserk && vida <= Constants.VIDA_MAXIMA_MOAB / 5) {
			velocidad *= 2;
			berserk=true;
		}
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public void setVelocidad(int i) {
		this.velocidad = i;
	}
	
}