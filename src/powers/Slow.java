package powers;

import constants.Constants;

public class Slow extends Efecto{

	@Override
	public void realizarEfecto() {
		run();
	}
	
	
	public void run() {
		Constants.modificarVelocidadGlobos(-1);
		for(int i=0; i<5; i++) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Constants.modificarVelocidadGlobos(1);
	}

	

	
}
