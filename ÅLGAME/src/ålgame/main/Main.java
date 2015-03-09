package ålgame.main;

import org.lwjgl.opengl.Display;

import ålgame.graphics.DisplayManager;
import ålgame.graphics.Renderer;

public class Main {
	
	public static void main(String[] args) {
		DisplayManager.create();
		
		Renderer.setOrthographicProjection(0, Display.getWidth(), Display.getHeight(), 0, -1, 1); //For 2D rendering
		
		while(DisplayManager.isOpen()) {
			Renderer.clear();
			Renderer.drawQuad(32, 32, 32, 32);
			DisplayManager.update();
		}
		
		DisplayManager.destroy();
	}
	
}
