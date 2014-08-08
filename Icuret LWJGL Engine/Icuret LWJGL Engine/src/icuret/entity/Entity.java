package icuret.entity;

public class Entity {
	
	protected float x;
	protected float y;
	protected float width;
	protected float height;
	
	public Entity() {}
	
	public Entity(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void addX(float x) {
		this.x += x;
	}
	
	public void subX(float x) {
		this.x -= x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void addY(float y) {
		this.y += y;
	}
	
	public void subY(float y) {
		this.y -= y;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSize(float width, float height) {
		this.width = width;
		this.height = height;
	}
	
	public void setBounds(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
