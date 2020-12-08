package entity;

import java.awt.Rectangle;

public class Hitbox extends Rectangle{
	
	
	public Hitbox(int x, int y, int ancho, int alto) {
		this.setBounds(x, y, ancho, alto);
	}
	
	public boolean colisiona(Hitbox hb) {
		return this.intersects(hb);
	}
	
	
	
}
