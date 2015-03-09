package icuret.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;

public class Texture {
	
	private static Texture[] textures = new Texture[256*256];
	public static Texture getTexture(int index) {return textures[index];}
	public static Texture x16Template;
	
	private org.newdawn.slick.opengl.Texture texture;
	private int id;
	private int imgWidth;
	private int imgHeight;
	private String path;
	
	public Texture(org.newdawn.slick.opengl.Texture t) {
		this.texture = t;
		this.id = t.getTextureID();
		this.imgWidth = t.getImageWidth();
		this.imgHeight = t.getImageHeight();
		
	}
	
	public Texture(String location) {
		this.path = location;
		load();
	}
	
	public Texture(int id, int imgWidth, int imgHeight) {
		this.id = id;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
	}
	
	private void load() {
		try {
			Texture tex = getTexture(path);
			this.texture = tex.getImage();
			this.id = tex.getID();
			this.imgWidth = tex.getImageWidth();
			this.imgHeight = tex.getImageHeight();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Texture getTexture(String filename) {
		Texture texture = null;
		try {
			org.newdawn.slick.opengl.Texture t = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(filename));
			texture = new Texture(t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(texture != null) textures[texture.getID()] = texture;
		return texture;
	}
	
	public static Texture loadTexture(String fileName) {
		glEnable(GL_TEXTURE_2D);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(fileName));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		glEnable(GL_TEXTURE_2D);
		int[] pixels = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getHeight());
		
		ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);
		
		for(int y = 0; y < image.getHeight(); y++) {
			for(int x = 0; x < image.getWidth(); x++) {
				int pixel = pixels[x + y * image.getWidth()];
				buffer.put((byte) ((pixel >> 16) & 0xFF));
				buffer.put((byte) ((pixel >> 8) & 0xFF));
				buffer.put((byte) ((pixel) & 0xFF));
				buffer.put((byte) ((pixel >> 24) & 0xFF));
			}
		}
		
		buffer.flip();
		
		int id = glGenTextures();
		
		glBindTexture(GL_TEXTURE, id);
		
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, image.getWidth(), image.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		
		return new Texture(id, image.getWidth(), image.getHeight());
	}
	
	public void bind() {
		glEnable(GL_TEXTURE_2D);
		this.texture.bind();
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
	}
	
	public void unbind() {
		glDisable(GL_TEXTURE_2D);
	}
	
	public int getID()  {
		return id;
	}
	
	public int getImageWidth() {
		return imgWidth;
	}
	
	public int getImageHeight() {
		return imgHeight;
	}
	
	public org.newdawn.slick.opengl.Texture getImage() {
		return texture;
	}
	
}
