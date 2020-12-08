package visitor;

import entity.Dardo;
import entity.Globo;
import entity.Jugador;
import entity.Premio;

public interface Visitor {
	
	public void visit(Jugador jugador);
	public void visit(Dardo dardo);
	public void visit(Globo bloon);
	public void visit(Premio premio);
	
	
}
