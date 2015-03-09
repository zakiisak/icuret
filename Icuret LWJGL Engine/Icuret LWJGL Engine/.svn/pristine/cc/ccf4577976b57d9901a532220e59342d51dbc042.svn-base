package icuret.graphics;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import icuret.Core;

public class Graphics {
	
	public static UnicodeFont arial96 = loadFont(new Font("Arial", 0, 96));
	public static UnicodeFont arial12 = loadFont(new Font("Arial", 0, 12));
	public static UnicodeFont consolas12 = loadFont(new Font("Consolas", 0, 12));
	public static UnicodeFont courierNew12 = loadFont(new Font("Courier New", 0, 12));
	public static UnicodeFont consolas16 = loadFont(new Font("Consolas", 0, 16));
	public static UnicodeFont courierNew16 = loadFont(new Font("Courier New", 0, 16));
	
	
	private Core core;
	private boolean requestingResize = false;
	private UnicodeFont font = arial96;
	
	//MAIN METHODS ---------------------------------------
	
	public void initGL() {
		init2D();
	}
	
	public void resize() {
		
		/*
		int width = core.getWindow().getFrame().getWidth();
		int height = core.getWindow().getFrame().getHeight();
		float aspect = width / height;
		glViewport(0, -32, width, height);
//		glOrtho(-50.0 * aspect, 50.0 * aspect, -50.0, 50.0, 1.0, -1.0);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 1, -1);
		/*
		glLoadIdentity();
		init2D();
		glViewport(0, 0, core.getWindow().getFrame().getWidth(), core.getWindow().getFrame().getHeight()); //NEW
		*/
	}
	
	//----------------------------------------------------
	
	public Graphics(Core core) {
		core.setGraphics(this);
		this.core = core;
		initGL();
	}
	
	public void init2D() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	
	public void refresh2D() {
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();
	}
	
	public void setColor(float r, float g, float b) {
		glColor3f(r, g, b);
	}
	
	public void setColor(float r, float g, float b, float a) {
		glColor4f(r, g, b, a);
	}
	
	public void fillRect(float x, float y, float width, float height) {
		glRectf(x, y, x + width, y + height);
	}
	
	public void fillQuad(float x1, float y1, float x2, float y2) {
		glRectf(x1, y1, x2, y2);
	}
	
	public void drawString(String str, float x, float y, Color color) {
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glEnable(GL_TEXTURE_2D);
		font.drawString(x, y, str, color);
		glDisable(GL_BLEND);
		glDisable(GL_TEXTURE_2D);
	}

	public void drawString(String str, float x, float y) {
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glEnable(GL_TEXTURE_2D);
		font.drawString(x, y, str);
		glDisable(GL_BLEND);
		glDisable(GL_TEXTURE_2D);
	}
	
	public void drawTexture(Texture texture, float x, float y) {
		Color.white.bind();
		texture.bind();
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(x, y);
		glTexCoord2f(1, 0);
		glVertex2f(x + texture.getImageWidth(), y);
		glTexCoord2f(1, 1);
		glVertex2f(x + texture.getImageWidth(), y + texture.getImageHeight());
		glTexCoord2f(0, 1);
		glVertex2f(x, y + texture.getImageHeight());
		glEnd();
		glDisable(GL_BLEND);
		texture.unbind();
	}
	
	public void drawTexture(Texture texture, float x, float y, float width, float height) {
		Color.white.bind();
		texture.bind();
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glStencilFunc(GL_EQUAL, 1, 0);
		glColorMask(true, true, true, false);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(x, y);
		glTexCoord2f(1, 0);
		glVertex2f(x + width, y);
		glTexCoord2f(1, 1);
		glVertex2f(x + width, y + height);
		glTexCoord2f(0, 1);
		glVertex2f(x, y + height);
		glEnd();
		glDisable(GL_BLEND);
		texture.unbind();
	}
	
	public void drawTexture(Texture texture, float x, float y, float width, float height, int[] index, int[] size) {
		texture.bind();
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glBegin(GL_QUADS);
		float xIndex = 1.0f / (float) texture.getImageWidth() * (float) (index[0]);
		float yIndex = 1.0f / (float) texture.getImageWidth() * (float) (index[1]);
		float wIndex = 1.0f / (float) texture.getImageWidth() * (float) (size[0]);
		float hIndex = 1.0f / (float) texture.getImageWidth() * (float) (size[1]);
		glTexCoord2f(xIndex, yIndex);
		glVertex2f(x, y);
		glTexCoord2f(xIndex + wIndex, yIndex);
		glVertex2f(x + width, y);
		glTexCoord2f(xIndex + wIndex, yIndex + hIndex);
		glVertex2f(x + width, y + height);
		glTexCoord2f(xIndex, yIndex + hIndex);
		glVertex2f(x, y + height);
		glEnd();
		glDisable(GL_BLEND);
		texture.unbind();
	}
	
	
	public void drawSprite(Sprite sprite, float x, float y) {
		drawTexture(sprite.getTexture(), x, y, sprite.getWidth(), sprite.getHeight(), new int[] {sprite.getX(), sprite.getY()}, new int[] {sprite.getWidth(), sprite.getHeight()});
	}
	
	public void drawSprite(Sprite sprite, float x, float y, float width, float height) {
		drawTexture(sprite.getTexture(), x, y, width, height, new int[] {sprite.getX(), sprite.getY()}, new int[] {sprite.getWidth(), sprite.getHeight()});
	}
	
	
	@SuppressWarnings("unchecked")
	public static UnicodeFont loadFont(Font awtFont) {
		UnicodeFont font = null;
		try {
			font = new UnicodeFont(awtFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		font.addAsciiGlyphs();
		font.addGlyphs(400, 600);
		font.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
		try {
			font.loadGlyphs();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return font;
	}
	
	@SuppressWarnings("unchecked")
	public static UnicodeFont loadFont(String location, int fontSize, int style) {
		UnicodeFont font = null;
		try {
			font = new UnicodeFont(location, fontSize, style == Font.BOLD || style == Font.BOLD + Font.ITALIC ? true : false, style == Font.ITALIC || style == Font.BOLD + Font.ITALIC ? true : false);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		font.addAsciiGlyphs();
		font.addGlyphs(400, 600);
		font.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
		try {
			font.loadGlyphs();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return font;
	}
	
	
	
	
	public Core getCore() {
		return core;
	}
	
	public void requestResize() {
		requestingResize = true;
	}
	
	public boolean isRequestingResize() {
		return requestingResize;
	}
	
	public UnicodeFont getFont() {
		return font;
	}
	
	public void setFont(UnicodeFont font) {
		this.font = font;
	}
	
}
