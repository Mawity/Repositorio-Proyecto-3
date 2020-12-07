package entity;

import javax.swing.ImageIcon;

import constants.Constants;
import image.Image;
import image.ImageFactory;

public class Dardo extends Entity{

	private int velocidadY;
	private Jugador jugador;
	private int alturaSprite;
	
	public Dardo(int x) {
		
		inicializar(x);
	}
	
	
	
	private void inicializar(int x) {
		velocidadY = 10;
		
		ImageIcon imageIcon = ImageFactory.crearImagen(Image.ICON);
		setImage(imageIcon.getImage());
		alturaSprite = imageIcon.getIconHeight();
		int xInicial = x+25;
		int yInicial = Constants.GAME_HEIGHT-100;
		
		setX(xInicial);
		setY(yInicial);
	}

	

	@Override
	public void move() {
		this.y -= velocidadY;
		if(y<-alturaSprite) {
			setDead(true);
		}
	}

}
