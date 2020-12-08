package entity;

import javax.swing.ImageIcon;

import image.Image;
import image.ImageFactory;
import powers.Efecto;
import powers.HealthPot;
import powers.Slow;
import visitor.Visitor;

public class Premio extends Entity{
	
	private Efecto efecto;
	
	
	public Premio(int efectoIndex) {
		inicializar(efectoIndex);
	}
	
	private void inicializar(int i) {
		ImageIcon imageIcon;
		velocidad = 3;
		switch (i) {
		
		case 0: 
			efecto = new Slow();
			imageIcon = ImageFactory.crearImagen(Image.PREMIO_TIEMPO);
			setImage(imageIcon.getImage());
			
		case 1:
			efecto = new HealthPot();
			imageIcon = ImageFactory.crearImagen(Image.PREMIO_VIDA);
			setImage(imageIcon.getImage());
			
		default:
			efecto = null;
		}
		
		setHitbox();

	}

	@Override
	public void move() {
		this.y += this.velocidad;
	}
	
	public void trigger() {
		efecto.realizarEfecto();
	}
	
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	
	
	
}
