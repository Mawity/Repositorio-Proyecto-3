package entity;

import java.util.Random;

import javax.swing.ImageIcon;

import constants.Constants;
import image.Image;
import image.ImageFactory;
import powers.Efecto;
import powers.HealthPot;
import powers.Slow;
import visitor.Visitor;

public class Premio extends Entity{
	
	private boolean esTemporal;
	private Efecto efecto;
	
	
	public Premio(int efectoIndex) {
		inicializar(efectoIndex);
	}
	
	private void inicializar(int i) {
		ImageIcon imageIcon;
		velocidad = 3;
		Random r = new Random();
		
		if(i==0) {
			efecto = new Slow();
			imageIcon = ImageFactory.crearImagen(Image.PREMIO_TIEMPO);
			setImage(imageIcon.getImage());

			anchoSprite = imageIcon.getIconWidth();
			altoSprite = imageIcon.getIconHeight();
			esTemporal = true;
			
		}else if(i==1) {
			efecto = new HealthPot();
			imageIcon = ImageFactory.crearImagen(Image.PREMIO_VIDA);
			setImage(imageIcon.getImage());

			anchoSprite = imageIcon.getIconWidth();
			altoSprite = imageIcon.getIconHeight();
			esTemporal = false;
		}
		
		int xInicial = r.nextInt(Constants.GAME_WIDTH-this.getImage().getWidth(null)/2);
		int yInicial = -10;
		
		setX(xInicial);
		setY(yInicial);
		
		setHitbox();

	}

	@Override
	public void move() {
		this.y += this.velocidad;
		setHitbox();
	}
	
	public void trigger() {
		efecto.realizarEfecto();
	}
	
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	
	
	
}
