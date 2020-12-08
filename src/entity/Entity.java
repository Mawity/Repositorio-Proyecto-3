package entity;

import java.awt.Image;
import java.awt.Rectangle;

import visitor.Visitable;

public abstract class Entity implements Visitable{
	
	private Image image;
	private boolean dead;
	
	protected int x;
	protected int y;
	protected int anchoSprite;
	protected int altoSprite;
	protected int velocidad;
	
	protected Rectangle hitbox;
	
	public abstract void move();
	
	public Entity() {
		this.dead = false;
	}

	
	// getters y setters
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setHitbox() {
		hitbox = new Rectangle(x, y, anchoSprite, altoSprite);
	}
	
	public Rectangle getHitbox() {
		return hitbox;
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
