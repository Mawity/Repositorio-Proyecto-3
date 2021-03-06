package visitor;

import entity.Dardo;
import entity.Globo;
import entity.Jugador;
import entity.Moab;
import entity.Premio;
import entity.Viento;

public class JugadorCollisionVisitor implements Visitor{

	private Jugador jugador;
	
	
	public JugadorCollisionVisitor(Jugador jugador) {
		this.jugador = jugador;
	}
	
	@Override
	public void visit(Jugador jugador) {
		
	}

	@Override
	public void visit(Dardo dardo) {
		
	}

	@Override
	public void visit(Globo bloon) {
		bloon.realizarDmg(jugador);
		bloon.setDead(true);
	}

	@Override
	public void visit(Premio premio) {
		premio.trigger();		
		premio.setDead(true);
	}

	@Override
	public void visit(Moab moab) {
		moab.realizarDmg(jugador);
		moab.setDead(true);
	}

	@Override
	public void visit(Viento viento) {
		viento.realizarDmg(jugador);
		viento.setDead(true);
	}
	
	
	

}
