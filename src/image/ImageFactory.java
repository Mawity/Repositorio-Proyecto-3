package image;

import java.net.URL;

import javax.swing.ImageIcon;

import constants.Constants;

public class ImageFactory {

	
	public static ImageIcon crearImagen(Image imagen, URL ruta) {
		
        ImageIcon imagen_final = null;

        switch(imagen) {

        
        
        
        //getClass().getResource()
        
        
        
        case GLOBO_ROJO:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case GLOBO_AZUL:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case GLOBO_VERDE:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case JUGADOR:
            imagen_final = new ImageIcon(ruta);
            break;
        case PREMIO_TIEMPO:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case PREMIO_VIDA:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case PROYECTIL:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(30, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case BACKGROUND:
            imagen_final = new ImageIcon(ruta);
            break;
        case ICON:
            imagen_final = new ImageIcon(ruta);
            break;
        case LVL_CLEAR:
        	imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(500, -1, java.awt.Image.SCALE_SMOOTH));
        	break;
        case PREMIO_DMG:
        	imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(70, -1, java.awt.Image.SCALE_SMOOTH));
        	break;
        case NUM_0:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_1:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_2:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_3:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_4:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_5:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_6:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_7:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_8:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        case NUM_9:
            imagen_final = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(50, -1, java.awt.Image.SCALE_SMOOTH));
            break;
        default:
            imagen_final = null;
            break;
        }

        return imagen_final;
  
	}
}
