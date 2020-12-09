package entity;



import java.util.Random;

import javax.swing.ImageIcon;

import constants.Constants;
import image.Image;
import image.ImageFactory;
import visitor.Visitor;

public class Globo extends Entity {
	protected int capas;
	protected int dmg;
	
	
	public Globo(int capas) {
		incializar(capas);
	}

	private void incializar(int capas) {
		this.capas = capas;
		velocidad = Constants.VELOCIDAD_BASE_GLOBO;
		

		Random r = new Random();
		
		establecerImagen(capas);

		setHitbox();

		int xInicial = r.nextInt(Constants.GAME_WIDTH-this.getImage().getWidth(null)/2);
		int yInicial = -10;
		
		dmg = capas*2;
		velocidad += capas;
		
		setX(xInicial);
		setY(yInicial);
		
				
	}
	
	private void establecerImagen(int capas) {
		ImageIcon imageIcon;
		
		if(capas==1) {
			imageIcon = ImageFactory.crearImagen(Image.GLOBO_ROJO);
			setImage(imageIcon.getImage());
		}else if(capas==2) {
			imageIcon = ImageFactory.crearImagen(Image.GLOBO_AZUL);
			setImage(imageIcon.getImage());
		}else {
			imageIcon = ImageFactory.crearImagen(Image.GLOBO_VERDE);
			setImage(imageIcon.getImage());
		}
		
		anchoSprite = imageIcon.getIconWidth();
		altoSprite = imageIcon.getIconHeight();
		
	}

	@Override
	public void move() {
		y += velocidad;
		if(y>Constants.GAME_HEIGHT) {
			setDead(true);
			atacar(Jugador.getJugador());
		}
		
		
		
		setHitbox();
	}
	
	public void atacar(Jugador jugador) {
		jugador.decreaseLives(dmg);
	}

	public void decreaseLives(int dmgTaken) {
		capas -= dmgTaken;
		if(capas <= 0) {
			setDead(true);
		}else {
			establecerImagen(capas);
		}
	}
	
	public int getCapas() {
		return capas;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
		
	}
}
