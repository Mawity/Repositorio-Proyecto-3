package visitor;

import entity.Dardo;
import entity.Globo;
import entity.Jugador;
import entity.Moab;
import entity.Premio;
import entity.Viento;

public class VientoCollisionVisitor implements Visitor {

	@SuppressWarnings("unused")
	private Viento viento;
	
	
	public VientoCollisionVisitor(Viento viento) {
		this.viento = viento;
	}
	
	
	@Override
	public void visit(Jugador jugador) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Dardo dardo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Globo bloon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Premio premio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Moab moab) {
		// TODO Auto-generated method stub

	}


	@Override
	public void visit(Viento viento) {
		// TODO Auto-generated method stub
		
	}

}
