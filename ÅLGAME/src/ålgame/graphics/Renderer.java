package ålgame.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {
	
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
	
}
