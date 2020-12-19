package factory;

import java.util.Random;

import javax.swing.ImageIcon;

import constants.Constants;
import entity.Entity;
import entity.Premio;
import image.Image;
import image.ImageFactory;
import powers.ExtraDMG;
import powers.HealthPot;
import powers.Slow;

public class PremioFactory extends Factory {

	@Override
	public Entity createEntity(int x, int y) {
		ImageIcon imageIcon;
		Premio premio = new Premio();
		
		Random rand = new Random();
		int r = rand.nextInt(3);
		
		switch(r) {
		case 0:
			premio.setEfecto(new Slow());
			imageIcon = ImageFactory.crearImagen(Image.PREMIO_TIEMPO, getClass().getResource(Constants.PREMIO_TIEMPO_IMAGE_URL));
			premio.setImage(imageIcon.getImage());
			premio.setAnchoSprite(imageIcon.getIconWidth());
			premio.setAltoSprite(imageIcon.getIconHeight());
			break;
		case 1: 
			premio.setEfecto(new HealthPot());
			imageIcon = ImageFactory.crearImagen(Image.PREMIO_VIDA, getClass().getResource(Constants.PREMIO_VIDA_IMAGE_URL));
			premio.setImage(imageIcon.getImage());
			premio.setAnchoSprite(imageIcon.getIconWidth());
			premio.setAltoSprite(imageIcon.getIconHeight());
			break;
		case 2:
			premio.setEfecto(new ExtraDMG());
			imageIcon = ImageFactory.crearImagen(Image.PREMIO_DMG, getClass().getResource(Constants.PREMIO_DMG_IMAGE_URL));
			premio.setImage(imageIcon.getImage());
			premio.setAnchoSprite(imageIcon.getIconWidth());
			premio.setAltoSprite(imageIcon.getIconHeight());
			break;
		}
		
		premio.setX(x);
		premio.setY(y);
		
		
		
		
		return premio;
	}

}
