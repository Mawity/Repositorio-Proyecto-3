package entity;

import constants.Constants;
import image.Image;
import image.ImageFactory;
import visitor.Visitor;

public class Globo extends Enemigo {	
	
	public Globo(int vida) {
		super();
		incializar(vida);
	}

	private void incializar(int vida) {
		this.vida = vida;
		dmg = vida*2;
		setHitbox();
		velocidad = Constants.VELOCIDAD_BASE_ENEMIGO + vida;				
	}
	



	


	public void decreaseLives(int dmgTaken) {
		vida -= dmgTaken;
		if(vida <= 0) {
			setDead(true);
		}else {
			
			if(vida==1) {
				setImage(ImageFactory.crearImagen(Image.GLOBO_ROJO, getClass().getResource(Constants.GLOBO_ROJO_IMAGE_URL)).getImage());
			}else if(vida==2) {
				setImage(ImageFactory.crearImagen(Image.GLOBO_AZUL, getClass().getResource(Constants.GLOBO_AZUL_IMAGE_URL)).getImage());
			}
			if(velocidad>0) {
				this.velocidad--;
			}
			
		}
	}
	
	public void accept(Visitor v) {
		v.visit(this);
		
	}
	
	@Override
	public void setVelocidad(int i) {
		if(i==0) {
			this.velocidad = i;
		}else {
			this.velocidad = i + this.vida;
		}
		
	}
}
