package factory;

import entity.Entity;

public abstract class Factory {
	
	protected int x;
	protected int y;
	
	public abstract Entity createEntity(int x, int y);
}
