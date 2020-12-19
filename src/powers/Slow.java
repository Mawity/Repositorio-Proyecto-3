package powers;

import java.util.List;

import constants.Constants;
import entity.Entity;
import gui.GamePanel;

public class Slow extends EfectoTemporal{

	
	
	public Slow() {
		gamePanel = GamePanel.getInstancia();
		this.duracion = Constants.TIEMPO_SLOW;
		
	}
	
	@Override
	public void realizarEfecto() {
		List<Entity> lista = gamePanel.getEntities();
		for(Entity tempEnt: lista) {
			tempEnt.setVelocidad(0);			
		}
		this.tiempoDeshacer = gamePanel.getTiempoDeJuego()+this.duracion;
		gamePanel.setEfecto(this);
	}

	@Override
	public EfectoTemporal deshacerEfecto() {
		List<Entity> lista = gamePanel.getEntities();
		for(Entity tempEnt: lista) {
			tempEnt.setVelocidad(Constants.VELOCIDAD_BASE_ENEMIGO);			
		}
		return this;
	}
	
	public int getTiempoDeshacer() { 
		return tiempoDeshacer;
	}

	

	
}
