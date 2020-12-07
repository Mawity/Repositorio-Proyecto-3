package entity;

import java.awt.Image;
import constants.Constants;

public class Enemigo extends Entity {
	protected int cargaViral;
	protected int daño;
	protected float velocidad;
	
	public Enemigo(Image img, int posX, int posY) {
		setImage(img);
		this.cargaViral = 100; //ToDo::podria ser una constante guardada
		this.daño = 100; //ToDo::podria ser una constante guardada
		this.velocidad = 5; //ToDo::podria ser una constante guardada
		this.x = posX;
		this.y = posY;
		this.setDead(true);		
	}

	@Override
	public void move() {
		if(x>=10 && x<=Constants.GAME_WIDTH-10 /*-anchoEnemigo */ ) {	//ToDo:: implementar
			x += velocidad;
		}
	}
	
	public void atacar() {
		//ToDo:: Implementar
	}
}
