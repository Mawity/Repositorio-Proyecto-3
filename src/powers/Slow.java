package powers;

import java.util.List;

import constants.Constants;
import entity.Globo;
import gui.GamePanel;

public class Slow extends EfectoTemporal{

	
	
	public Slow() {
		gamePanel = GamePanel.getInstancia();
		this.duracion = Constants.TIEMPO_SLOW;
		
	}
	
	@Override
	public void realizarEfecto() {
		List<Globo> lista = gamePanel.getBloons();
		for(Globo tempBloon: lista) {
			tempBloon.setVelocidad(tempBloon.getVelocidad()-1);			
		}
		this.tiempoDeshacer = gamePanel.getTiempoDeJuego()+this.duracion;
		gamePanel.setEfecto(this);
	}

	@Override
	public void deshacerEfecto() {
		List<Globo> lista = gamePanel.getBloons();
		for(Globo tempBloon: lista) {
			tempBloon.setVelocidad(tempBloon.getVelocidad()+1);			
		}
		gamePanel.removeEfecto(this);
	}
	
	public int getTiempoDeshacer() { 
		return tiempoDeshacer;
	}

	

	
}
