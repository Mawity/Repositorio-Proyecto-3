package image;

import javax.swing.ImageIcon;

import constants.Constants;

public class ImageFactory {

	
	public static ImageIcon crearImagen(Image imagen) {
		
        ImageIcon imagen_final = null;

        switch(imagen) {

        case GLOBO_ROJO:
            imagen_final = new ImageIcon(new ImageIcon(Constants.GLOBO_ROJO_IMAGE_URL).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case GLOBO_AZUL:
            imagen_final = new ImageIcon(new ImageIcon(Constants.GLOBO_AZUL_IMAGE_URL).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case GLOBO_VERDE:
            imagen_final = new ImageIcon(new ImageIcon(Constants.GLOBO_VERDE_IMAGE_URL).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case JUGADOR:
            imagen_final = new ImageIcon(Constants.JUGADOR_IMAGE_URL);
            break;
        case PREMIO_TIEMPO:
            imagen_final = new ImageIcon(new ImageIcon(Constants.PREMIO_TIEMPO_IMAGE_URL).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case PREMIO_VIDA:
            imagen_final = new ImageIcon(new ImageIcon(Constants.PREMIO_VIDA_IMAGE_URL).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case PROYECTIL:
            imagen_final = new ImageIcon(new ImageIcon(Constants.PROYECTIL_IMAGE_URL).getImage().getScaledInstance(30, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case BACKGROUND:
            imagen_final = new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
            break;
        case ICON:
            imagen_final = new ImageIcon(Constants.ICON_IMAGE_URL);
            break;
        case LVL_CLEAR:
        	imagen_final = new ImageIcon(new ImageIcon(Constants.LVL_CLEAR_IMAGE_URL).getImage().getScaledInstance(500, -1, java.awt.Image.SCALE_SMOOTH));
        	break;
        case PREMIO_DMG:
        	imagen_final = new ImageIcon(new ImageIcon(Constants.PREMIO_DMG_IMAGE_URL).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
        	break;
        case NUM_0:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_0_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_1:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_1_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_2:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_2_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_3:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_3_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_4:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_4_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_5:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_5_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_6:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_6_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_7:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_7_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_8:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_8_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_9:
            imagen_final = new ImageIcon(new ImageIcon(Constants.NUM_9_IMAGE_URL).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        default:
            imagen_final = null;
            break;
        }

        return imagen_final;
  
	}
}
