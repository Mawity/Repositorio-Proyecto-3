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
        case NUM_0:
            imageIcon = new ImageIcon(Constants.NUM_0_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_1:
            imageIcon = new ImageIcon(Constants.NUM_1_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_2:
            imageIcon = new ImageIcon(Constants.NUM_2_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_3:
            imageIcon = new ImageIcon(Constants.NUM_3_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_4:
            imageIcon = new ImageIcon(Constants.NUM_4_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_5:
            imageIcon = new ImageIcon(Constants.NUM_5_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_6:
            imageIcon = new ImageIcon(Constants.NUM_6_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_7:
            imageIcon = new ImageIcon(Constants.NUM_7_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_8:
            imageIcon = new ImageIcon(Constants.NUM_8_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_9:
            imageIcon = new ImageIcon(Constants.NUM_9_IMAGE_URL);
            imagen_final = new ImageIcon(imageIcon.getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        default:
            imageIcon = null;
            break;
        }

        return imagen_final;
  
	}
}
