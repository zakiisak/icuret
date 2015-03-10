package ålgame.main;

import java.awt.Font;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.UnicodeFont;

import ålgame.geom.Entity;
import ålgame.graphics.DisplayManager;
import ålgame.graphics.Image;
import ålgame.graphics.Renderer;

public class Main {
	
	public static void main(String[] args) {
		DisplayManager.create();
		
		Renderer.setOrthographicProjection(0, Display.getWidth(), Display.getHeight(), 0, -1, 1); //For 2D rendering
		
		Renderer.setTextureEnabled(true);
		Image testImage = new Image("white.png");
		Entity e1 = new Entity(32, 32, 32, 32);
		Entity e2 = new Entity(65, 64, 64, 64);
		
		Renderer.setFontAntialisingEnabled(true);
		UnicodeFont font = Renderer.loadFont(Font.MONOSPACED, true, false, 24);
		Renderer.setFont(font);
		
		float dt = 0.0f;
		while(DisplayManager.isOpen()) {
			long lt = System.nanoTime();
			Renderer.clear();
			float[] color = {1, 1, 1};
			if(e2.intersects(e1)) color = new float[] {1, 0, 0};
			Renderer.setColor(color[0], color[1], color[2]);
			Renderer.drawTexturedQuad(testImage, e1.getX(), e1.getY(), e1.getWidth(), e1.getHeight());
			Renderer.drawTexturedQuad(testImage, e2.getX(), e2.getY(), e2.getWidth(), e2.getHeight());
			
			Renderer.setColor(1, 1, 1);
			Renderer.drawString("Mouse X: " + Mouse.getX() + ", Mouse Y: " + Mouse.getY(), 128, 16);
			
			float ms = 2.0f;
			if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
				e1.setY(e1.getY() - ms * dt);
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
				e1.setY(e1.getY() + ms * dt);
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
				e1.setX(e1.getX() - ms * dt);
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
				e1.setX(e1.getX() + ms * dt);
			}
			
			DisplayManager.update();
			float dfps = 1000000000.0f / (float) (System.nanoTime() - lt);
			dt = 1.0f;
			Display.setTitle("fps: " + dfps);
		}
		
		DisplayManager.destroy();
	}
	
}
