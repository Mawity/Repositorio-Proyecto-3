package visitor;

import entity.Dardo;
import entity.Globo;
import entity.Jugador;
import entity.Moab;
import entity.Premio;
import entity.Viento;

public class DardoCollisionVisitor implements Visitor{

	private Dardo dardo;
	
	
	public DardoCollisionVisitor(Dardo dardo) {
		this.dardo = dardo;
	}
	
	
	@Override
	public void visit(Jugador jugador) {
		
	}

	@Override
	public void visit(Dardo dardo) {

	}

	@Override
	public void visit(Globo bloon) {
		dardo.atacar(bloon);
		dardo.setDead(true);
	}

	@Override
	public void visit(Premio premio) {
		
	}

	@Override
	public void visit(Moab moab) {
		dardo.atacar(moab);
		dardo.setDead(true);

	}


	@Override
	public void visit(Viento viento) {
		// TODO Auto-generated method stub
		
	}

	
}
