package powers;

import gui.GamePanel;

public abstract class EfectoTemporal implements Efecto{

	int duracion;
	int tiempoDeshacer;
	GamePanel gamePanel;
	
	public abstract EfectoTemporal deshacerEfecto();
	public abstract int getTiempoDeshacer();
	
	
}
