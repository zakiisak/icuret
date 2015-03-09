package icuret;

import icuret.engine.GameEngine;
import icuret.window.EventHandler;
import icuret.window.Window;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Main {
	
	private static final Core core = new Core();
	
	public static void main(String[] args) {
		new GameEngine(core, Finals.UPS_LIMIT, Finals.FPS_LIMIT);
		new Window(core, Finals.WINDOW_SIZE[0], Finals.WINDOW_SIZE[1], Finals.TITLE, Finals.RESIZABLE, Finals.FULLSCREEN, Finals.VSYNC, Finals.LWJGL_WINDOW);
		new EventHandler(core);
		new Base(core);
		core.setState(Finals.STATES[2]);
		core.getEngine().start();
	}
	
	public static void stop() {
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
		core.getWindow().getFrame().dispose();
		System.exit(0);
	}
	
	public static final Core getCore() {
		return core;
	}
	
	public static void initializeStates() {
		for(int i = 0; i < Finals.STATES.length; i++) {
			Finals.STATES[i].init(core, core.getGraphics());
		}
	}
	
	
	
}
