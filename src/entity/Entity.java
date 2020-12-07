package entity;

import java.awt.Image;

public abstract class Entity {
	
	private Image image;
	private boolean dead;
	
	protected int x;
	protected int y;
	protected int anchoSprite;
	protected int altoSprite;
	
	public abstract void move();
	
	public Entity() {
		this.dead = false;
	}
	
	public void desaparecer() {
		this.dead = true;
	}
	
	// getters y setters
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	
}
