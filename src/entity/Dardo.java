package entity;

import javax.swing.ImageIcon;

import constants.Constants;
import image.Image;
import image.ImageFactory;

public class Dardo extends Entity{

	
	public Dardo(int x) {
		
		inicializar(x);
	}
	
	private void inicializar(int x) {
		velocidad = 10;
		
		ImageIcon imageIcon = ImageFactory.crearImagen(Image.ICON);
		setImage(imageIcon.getImage());
		altoSprite = imageIcon.getIconHeight();
		int xInicial = x+25;
		int yInicial = Constants.GAME_HEIGHT-100;
		
		setX(xInicial);
		setY(yInicial);
		
		setHitbox();
	}

	@Override
	public void move() {
		this.y -= velocidad;
		if(y<-altoSprite) {
			setDead(true);
		}
	}

}
