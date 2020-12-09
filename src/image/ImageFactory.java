package image;

import javax.swing.ImageIcon;

import constants.Constants;

public class ImageFactory {

	
	public static ImageIcon crearImagen(Image imagen) {
		
		ImageIcon imageIcon = null;
        ImageIcon imagen_final = null;

        switch(imagen) {

        case GLOBO_ROJO:
            imageIcon = new ImageIcon(Constants.GLOBO_ROJO_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case GLOBO_AZUL:
            imageIcon = new ImageIcon(Constants.GLOBO_AZUL_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case GLOBO_VERDE:
            imageIcon = new ImageIcon(Constants.GLOBO_VERDE_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case JUGADOR:
            imagen_final = new ImageIcon(Constants.JUGADOR_IMAGE_URL);
            break;
        case PREMIO_TIEMPO:
            imageIcon = new ImageIcon(Constants.PREMIO_TIEMPO_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case PREMIO_VIDA:
            imageIcon = new ImageIcon(Constants.PREMIO_VIDA_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case PROYECTIL:
            imageIcon = new ImageIcon(Constants.PROYECTIL_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(30, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case BACKGROUND:
            imagen_final = new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
            break;
        case ICON:
            imagen_final = new ImageIcon(Constants.ICON_IMAGE_URL);
            break;
        default:
            imageIcon = null;
            break;
        }

        return imagen_final;
  
	}
}
