package visitor;

import entity.Dardo;
import entity.Globo;
import entity.Jugador;
import entity.Premio;

public class GloboCollisionVisitor implements Visitor{

	private Globo globo;
	
	
	public GloboCollisionVisitor(Globo globo) {
		this.globo = globo;
	}
	
	
	
	@Override
	public void visit(Jugador jugador) {
		
	}

	@Override
	public void visit(Dardo dardo) {
		dardo.atacar(globo);
		dardo.setDead(true);
		System.out.println("DARDOxGLOBO");
	}

	@Override
	public void visit(Globo bloon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Premio premio) {
		// TODO Auto-generated method stub
		
	}

	
}
