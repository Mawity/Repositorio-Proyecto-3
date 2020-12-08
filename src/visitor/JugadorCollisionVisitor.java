package visitor;

import entity.Dardo;
import entity.Globo;
import entity.Jugador;
import entity.Premio;

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
		bloon.atacar(jugador);
		bloon.setDead(true);
		System.out.println("GLOBOxJUGADOR");
	}

	@Override
	public void visit(Premio premio) {
		premio.trigger();		
		premio.setDead(true);
		System.out.println("PREMIOxJUGADOR");
	}
	
	
	

}
