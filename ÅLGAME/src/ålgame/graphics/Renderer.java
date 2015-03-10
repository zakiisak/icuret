package ålgame.graphics;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class Renderer {
	
	private static UnicodeFont boundFont;
	
	public static void setFont(UnicodeFont font) {
		boundFont = font;
	}
	
	public static void drawString(String str, float x, float y) {
		boundFont.drawString(x, y, str);
	}
	
	public static void setColor(float r, float g, float b, float a) {
		glColor4f(r, g, b, a);
	}
	
	public static void setColor(float r, float g, float b) {
		glColor3f(r, g, b);
	}
	
	public static void clear() {
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
	public static void setOrthographicProjection(float left, float right, float bottom, float top, float near, float far) {
		glOrtho(left, right, bottom, top, near, far);
	}
	
	public static void drawQuad(float x, float y, float width, float height) {
		glRectf(x, y, x + width, y + height);
	}
	
	public static void setTextureEnabled(boolean enabled) {
		if(enabled) glEnable(GL_TEXTURE_2D);
		else glDisable(GL_TEXTURE_2D);
	}
	
	public static void setBlendingEnabled(boolean enabled) {
		if(enabled) glEnable(GL_BLEND);
		else glDisable(GL_BLEND);
	}
	
	public static void setBlendFunc(int sfactor, int dfactor) {
		glBlendFunc(sfactor, dfactor);
	}
	
	public static void setFontAntialisingEnabled(boolean enabled) {
		if(enabled) {
			setBlendingEnabled(true);
			setBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		}
		else setBlendingEnabled(false);
	}
	
	public static void drawTexturedQuad(Image image, float x, float y, float width, float height) {
		glBindTexture(GL_TEXTURE_2D, image.getID());
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
	}
	
	public static void drawAtlasTexture(Image image, float x, float y, float width, float height, int srcX, int srcY, int srcWidth, int srcHeight) {
		float xc = (float) srcX / image.getWidth();
		float yc = (float) srcY / image.getHeight();
		float xcw = xc + (float) srcWidth / image.getWidth();
		float ycw = yc + (float) srcHeight / image.getHeight();
		glBegin(GL_QUADS);
		glTexCoord2f(xc, yc);
		glVertex2f(x, y);
		glTexCoord2f(xcw, yc);
		glVertex2f(x + width, y);
		glTexCoord2f(xcw, ycw);
		glVertex2f(x + width, y + height);
		glTexCoord2f(xc, ycw);
		glVertex2f(x, y + height);
		glEnd();
	}
	
	@SuppressWarnings("unchecked")
	public static UnicodeFont loadFont(String name, boolean bold, boolean italic, int size) {
		UnicodeFont font = null;
		if (name.toLowerCase().endsWith(".ttf")) {
			try {
				font = new UnicodeFont(name, size, bold, italic);
				font.getEffects().add(new ColorEffect(java.awt.Color.white));
				font.addAsciiGlyphs();
				try {
					font.loadGlyphs();
				} catch (SlickException e) {
					e.printStackTrace();
				}
			} catch (SlickException e) {
				e.printStackTrace();
			}
		} else {
			font = new UnicodeFont(new java.awt.Font(name, bold && italic ? 3 : bold ? 1 : italic ? 2 : 0, 24));
			font.getEffects().add(new ColorEffect(java.awt.Color.white));
			font.addAsciiGlyphs();
			try {
				font.loadGlyphs();
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		return font;
	}
}
