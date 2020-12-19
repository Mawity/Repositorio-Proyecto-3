package powers;


import constants.Constants;
import gui.GamePanel;

public class ExtraDMG extends EfectoTemporal{

	public ExtraDMG() {
		gamePanel = GamePanel.getInstancia();
		this.duracion = Constants.TIEMPO_EXTRA_DMG;
		
	}
	
	@Override
	public void realizarEfecto() {
		
		Constants.changeDartsDMG(Constants.DMG_BASE_DARDO+1);	
		this.tiempoDeshacer = gamePanel.getTiempoDeJuego()+this.duracion;
		gamePanel.setEfecto(this);
	}

	@Override
	public EfectoTemporal deshacerEfecto() {
		Constants.changeDartsDMG(Constants.DMG_BASE_DARDO-1);
		return this;
	}
	
	public int getTiempoDeshacer() { 
		return tiempoDeshacer;
	}


}
