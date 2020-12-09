package powers;

import entity.Jugador;

public class HealthPot extends Efecto{

		
	@Override
	public void realizarEfecto() {
		Jugador.getJugador().increaseLives(15);
	}
	
}
