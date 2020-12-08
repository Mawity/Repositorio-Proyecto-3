package image;

import javax.swing.ImageIcon;

import constants.Constants;

public class ImageFactory {

	
	public static ImageIcon crearImagen(Image imagen) {
		
		ImageIcon imageIcon = null;
		
		switch(imagen) {
		
		case GLOBO_ROJO:
			imageIcon = new ImageIcon(Constants.GLOBO_ROJO_IMAGE_URL);
			break;
		case GLOBO_AZUL:
			imageIcon = new ImageIcon(Constants.GLOBO_AZUL_IMAGE_URL);
			break;
		case GLOBO_VERDE:
			imageIcon = new ImageIcon(Constants.GLOBO_VERDE_IMAGE_URL);
			break;
		case JUGADOR:
			imageIcon = new ImageIcon(Constants.JUGADOR_IMAGE_URL);
			break;
		case PREMIO_TIEMPO:
			imageIcon = new ImageIcon(Constants.PREMIO_TIEMPO_IMAGE_URL);
			break;
		case PREMIO_VIDA:
			imageIcon = new ImageIcon(Constants.PREMIO_VIDA_IMAGE_URL);
			break;
		case PROYECTIL:
			imageIcon = new ImageIcon(Constants.PROYECTIL_IMAGE_URL);
			break;
		case BACKGROUND:
			imageIcon = new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
			break;
		case ICON:
			imageIcon = new ImageIcon(Constants.ICON_IMAGE_URL);
			break;
		default:
			imageIcon = null;
			break;
		}
		
		return imageIcon;
	}
}
