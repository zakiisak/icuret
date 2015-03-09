package ålgame.graphics;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class DisplayManager {
	
	public static int WIDTH = 640;
	public static int HEIGHT = 480;
	public static String TITLE = "ÅL \"GAME\"";
	
	public static void create() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle(TITLE);
			Display.setVSyncEnabled(true);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public static void destroy() {
		Display.destroy();
	}
	
	public static boolean isOpen() {
		return !Display.isCloseRequested();
	}
	
	public static void update() {
		Display.update();
	}
	
}
