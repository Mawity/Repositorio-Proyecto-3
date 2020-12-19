package factory;

import java.util.Random;

import javax.swing.ImageIcon;

import constants.Constants;
import entity.Enemigo;
import entity.Entity;
import entity.Globo;
import entity.Moab;
import image.Image;
import image.ImageFactory;
import levels.Nivel;

public class EnemigoFactory extends Factory {

	private Nivel lvlActual;

	
	public EnemigoFactory(Nivel lvl) {
		lvlActual = lvl;
	}
	
	@Override
	public Entity createEntity(int x, int y) {
		ImageIcon imageIcon;
		Enemigo enemigo = null;
		boolean yaCreado = false;
		
		Random rand = new Random();
		int r = rand.nextInt(50);
		
		if(r%2==0) {
			
			if(r%32==0 && lvlActual.getCantMoabs()!=0) {
				enemigo = new Moab();
				lvlActual.restarMoab();
				imageIcon = ImageFactory.crearImagen(Image.MOAB, getClass().getResource(Constants.MOAB_IMAGE_URL));
				enemigo.setImage(imageIcon.getImage());
				enemigo.setAnchoSprite(imageIcon.getIconWidth());
				enemigo.setAltoSprite(imageIcon.getIconHeight());
				enemigo.setX(x);
				enemigo.setY(y);
				yaCreado = true;
			}
			
			if(!yaCreado && r%16==0 && lvlActual.getCantVerdes()!=0){
				enemigo = new Globo(3);
				lvlActual.restarVerde();
				imageIcon = ImageFactory.crearImagen(Image.GLOBO_VERDE, getClass().getResource(Constants.GLOBO_VERDE_IMAGE_URL));
				enemigo.setImage(imageIcon.getImage());
				enemigo.setAnchoSprite(imageIcon.getIconWidth());
				enemigo.setAltoSprite(imageIcon.getIconHeight());
				enemigo.setX(x);
				enemigo.setY(y);
				yaCreado = true;
			}
			
			if(!yaCreado && r%8==0 && lvlActual.getCantAzules()!=0) {
				enemigo = new Globo(2);
				lvlActual.restarAzul();
				imageIcon = ImageFactory.crearImagen(Image.GLOBO_AZUL, getClass().getResource(Constants.GLOBO_AZUL_IMAGE_URL));
				enemigo.setImage(imageIcon.getImage());
				enemigo.setAnchoSprite(imageIcon.getIconWidth());
				enemigo.setAltoSprite(imageIcon.getIconHeight());
				enemigo.setX(x);
				enemigo.setY(y);
				yaCreado = true;	
			}
			
			if(!yaCreado && r%4==0 && lvlActual.getCantRojos()!=0) {
				enemigo = new Globo(1);
				lvlActual.restarRojo();
				imageIcon = ImageFactory.crearImagen(Image.GLOBO_ROJO, getClass().getResource(Constants.GLOBO_ROJO_IMAGE_URL));
				enemigo.setImage(imageIcon.getImage());
				enemigo.setAnchoSprite(imageIcon.getIconWidth());
				enemigo.setAltoSprite(imageIcon.getIconHeight());
				enemigo.setX(x);
				enemigo.setY(y);
				
			}
			
		
		}
		
		
		
		return enemigo;
	}

	
	
}
