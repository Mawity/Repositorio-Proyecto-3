package powers;

import entity.Jugador;

public class HealthPot implements Efecto{
	
	@Override
	public void realizarEfecto() {
		Jugador.getJugador().increaseLives(10);
	}
	
}
