package entity;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import constants.Constants;
import image.*;
import visitor.JugadorCollisionVisitor;
import visitor.Visitor;


public class Jugador extends Entity{

	private boolean derechaPressed, izquierdaPressed;
	private int vidas;
	protected static Jugador jugador;
	
	
	
	public Jugador() {
		inicializar();
	}
	
	private void inicializar() {
		ImageIcon imageIcon = ImageFactory.crearImagen(Image.JUGADOR, getClass().getResource(Constants.JUGADOR_IMAGE_URL));
		setImage(imageIcon.getImage());
		anchoSprite = imageIcon.getIconWidth();
		altoSprite = imageIcon.getIconHeight();
		int xInicial = Constants.GAME_WIDTH/2 - anchoSprite/2;
		int yInicial = Constants.GAME_HEIGHT-100;
		
		visitor = new JugadorCollisionVisitor(this);
		
		velocidad = 0;
		vidas = Constants.VIDA_MAXIMA;
		derechaPressed = false;
		izquierdaPressed = false;
		
		setX(xInicial);
		setY(yInicial);
		
		setHitbox();
	}

	@Override
	public void move() {
		
		if(x<=10) {	
			if(velocidad>0) {
				x += velocidad;
			}
		}else if(x>=Constants.GAME_WIDTH-10-anchoSprite) {
			if(velocidad<0) {
				x += velocidad;
			}
		}else {
			x += velocidad;
		}	
		
		setHitbox();
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT) {
			velocidad = -7;
			izquierdaPressed = true;
		}
		
		if(key==KeyEvent.VK_RIGHT) {
			velocidad = 7;
			derechaPressed = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT) {
			izquierdaPressed = false;
			if(!derechaPressed) {
				velocidad = 0;
			}else {
				velocidad = 7;
			}
		}
		
		if(key==KeyEvent.VK_RIGHT) {
			derechaPressed = false;
			if(!izquierdaPressed) {
				velocidad = 0;
			}else {
				velocidad = -5;
			}
		}
	}

	
	public void increaseLives(int pv) {
		if(vidas+pv>Constants.VIDA_MAXIMA) {
			vidas = Constants.VIDA_MAXIMA;
		}else {
			vidas += pv;
		}
	}
	
	public void decreaseLives(int pv) {
		vidas -= pv;
		if(vidas<=0) {
			this.setDead(true);
		}
	}
	

	public static Jugador getJugador() {
		return jugador;
	}
	
	public void setJugador() {
		jugador = this; 
	}

	
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	
	@Override
	public int getVida() {
		return vidas;
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



}
