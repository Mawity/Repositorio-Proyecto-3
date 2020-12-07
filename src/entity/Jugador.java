package entity;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import constants.Constants;
import image.*;


public class Jugador extends Entity{

	private int velocidadX;
	private boolean derechaPressed, izquierdaPressed;
	private int anchoJugador;
	
	
	public Jugador() {
		inicializar();
	}
	
	private void inicializar() {
		ImageIcon imageIcon = ImageFactory.crearImagen(Image.JUGADOR);
		setImage(imageIcon.getImage());
		anchoJugador = imageIcon.getIconWidth();
		int xInicial = Constants.GAME_WIDTH/2 - anchoJugador/2;
		int yInicial = Constants.GAME_HEIGHT-100;
		velocidadX = 0;
		derechaPressed = false;
		izquierdaPressed = false;
		
		setX(xInicial);
		setY(yInicial);
	}

	@Override
	public void move() {
		
		if(x<=10) {	
			if(velocidadX>0) {
				x += velocidadX;
			}
		}else if(x>=Constants.GAME_WIDTH-10-anchoJugador) {
			if(velocidadX<0) {
				x += velocidadX;
			}
		}else {
			x += velocidadX;
		}
		
		
		
		
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT) {
			velocidadX = -3;
			izquierdaPressed = true;
		}
		
		if(key==KeyEvent.VK_RIGHT) {
			velocidadX = 3;
			derechaPressed = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT) {
			izquierdaPressed = false;
			if(!derechaPressed) {
				velocidadX = 0;
			}else {
				velocidadX = 3;
			}
		}
		
		if(key==KeyEvent.VK_RIGHT) {
			derechaPressed = false;
			if(!izquierdaPressed) {
				velocidadX = 0;
			}else {
				velocidadX = -3;
			}
		}
	}























}
