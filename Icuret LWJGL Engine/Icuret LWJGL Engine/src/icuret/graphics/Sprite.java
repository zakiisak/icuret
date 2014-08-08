package icuret.graphics;

public class Sprite {
	
	private int textureID;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Sprite(Texture texture, int x, int y, int width, int height) {
		this.textureID = texture.getID();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Sprite(int id, int x, int y, int width, int height) {
		this.textureID = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Sprite(String textureLocation, int x, int y, int width, int height) { 
		this(Texture.getTexture(textureLocation), x, y, width, height);
	}
	
	public int getID() {
		return textureID;
	}
	
	public Texture getTexture() {
		return Texture.getTexture(textureID);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
