package entity;

import javax.swing.ImageIcon;

import constants.Constants;
import gui.GamePanel;
import image.Image;
import image.ImageFactory;
import visitor.DardoCollisionVisitor;
import visitor.Visitor;

public class Dardo extends Entity{

	private int dmg;
	
	public Dardo(int x) {
		inicializar(x);
	}
	
	private void inicializar(int x) {
		velocidad = 10;
		dmg = Constants.DMG_BASE_DARDO;
		
		visitor = new DardoCollisionVisitor(this);
		
		ImageIcon imageIcon = ImageFactory.crearImagen(Image.PROYECTIL, getClass().getResource(Constants.PROYECTIL_IMAGE_URL));
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
	public void setDead(boolean dead) {
		super.setDead(dead);
		if(dead) {
			GamePanel gp = GamePanel.getInstancia();
			gp.setDardosEnJuego(gp.getDardosEnJuego()-1);
		}
		
	}

	@Override
	public void move() {
		this.y -= velocidad;
		if(y<-altoSprite) {
			setDead(true);
		}
		setHitbox();
	}
	
	public void atacar(Enemigo enemy) {
		enemy.decreaseLives(dmg);
	}
	
	
	
	public void accept(Visitor v) {
		v.visit(this);
		
	}

	@Override
	public void setVelocidad(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVida() {
		// TODO Auto-generated method stub
		return 0;
	}

}
