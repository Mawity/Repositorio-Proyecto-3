package entity;

import javax.swing.ImageIcon;

import image.Image;
import image.ImageFactory;
import powers.Efecto;
import powers.HealthPot;
import powers.TimeStop;

public class Premio extends Entity{
	
	private Efecto efecto;
	
	
	public Premio(int efectoIndex) {
		inicializar(efectoIndex);
	}
	
	private void inicializar(int i) {
		ImageIcon imageIcon;
		velocidad = 15;
		switch (i) {
		
		case 0: 
			efecto = new TimeStop();
			imageIcon = ImageFactory.crearImagen(Image.PREMIO_TIEMPO);
			setImage(imageIcon.getImage());
			
		case 1:
			efecto = new HealthPot();
			imageIcon = ImageFactory.crearImagen(Image.PREMIO_VIDA);
			setImage(imageIcon.getImage());
			
		default:
			efecto = null;
		}
	}

	@Override
	public void move() {
		this.y += this.velocidad;
	}
	
	
	
	
}
