package visitor;

import entity.Dardo;
import entity.Globo;
import entity.Jugador;
import entity.Moab;
import entity.Premio;
import entity.Viento;

public interface Visitor {
	
	public void visit(Jugador jugador);
	public void visit(Dardo dardo);
	public void visit(Globo bloon);
	public void visit(Premio premio);
	public void visit(Moab moab);
	public void visit(Viento viento);
	
}
