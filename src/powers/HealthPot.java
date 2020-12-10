package powers;

import entity.Jugador;

public class HealthPot extends EfectoInstantaneo{

		
	@Override
	public void realizarEfecto() {
		Jugador.getJugador().increaseLives(15);
	}
	
}
