package entity;

import javax.swing.ImageIcon;

import constants.Constants;
import image.Image;
import image.ImageFactory;
import visitor.Visitor;

public class Dardo extends Entity{

	private int dmg;
	
	public Dardo(int x) {
		
		inicializar(x);
	}
	
	private void inicializar(int x) {
		velocidad = 10;
		dmg = 1;
		
		ImageIcon imageIcon = ImageFactory.crearImagen(Image.PROYECTIL);
		setImage(imageIcon.getImage());
		
		anchoSprite = imageIcon.getIconWidth();
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
		setHitbox();
	}
	
	public void atacar(Globo globo) {
		globo.decreaseLives(dmg);
	}

	
	public void accept(Visitor v) {
		v.visit(this);
		
	}
}
