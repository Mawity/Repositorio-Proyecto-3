package factory;

import javax.swing.ImageIcon;

import constants.Constants;
import entity.Entity;
import entity.Viento;
import image.Image;
import image.ImageFactory;

public class VientoFactory extends Factory {

	@Override
	public Entity createEntity(int x, int y) {

		ImageIcon imageIcon;
		Viento viento;

		viento = new Viento();
		imageIcon = ImageFactory.crearImagen(Image.VIENTO, getClass().getResource(Constants.VIENTO_IMAGE_URL));
		viento.setImage(imageIcon.getImage());
		viento.setAnchoSprite(imageIcon.getIconWidth());
		viento.setAltoSprite(imageIcon.getIconHeight());

		viento.setX(x-imageIcon.getIconWidth()/2);
		viento.setY(y);

		return viento;
	}

}
