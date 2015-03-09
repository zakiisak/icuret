package icuret.window;

import icuret.Core;
import icuret.gui.Component;

import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class EventHandler implements WindowListener, ComponentListener{
	
	public static final int MOUSE_LEFT = 0;
	public static final int MOUSE_RIGHT = 1;
	public static final int MOUSE_MIDDLE = 2;
	
	private Core core;
	
	private Thread keyThread;
	private Thread mouseThread;
	
	private boolean closeRequested = false;
	private boolean keys[] = new boolean[65536];
	private boolean mouse[] = new boolean[128];
	
	private int mouseX;
	private int mouseY;
	
	private boolean mouseInBounds = false;
	private boolean windowFocused = false;
	
	private Component bindedComponent = null;
	
	public EventHandler(Core core) {
		core.setEventHandler(this);
		this.core = core;
	}
	
	public void start() {
		keyThread = new Thread(new Runnable() {
			public void run() {
				while(core.getEngine().isRunning()) {
					while(Keyboard.next()) {
						int keycode = Keyboard.getEventKey();
						boolean pressed = Keyboard.getEventKeyState();
						keys[keycode] = pressed;
						if(bindedComponent != null) bindedComponent.input(core, keycode, pressed);
					}
				}
			}
		}, "Icuret Key-Input Thread");
		mouseThread = new Thread(new Runnable() {
			public void run() {
				while(core.getEngine().isRunning()) {
					while(Mouse.next()) {
						int button = Mouse.getEventButton();
						boolean pressed = Mouse.getEventButtonState();
						if(button < 0) {
							if(button == -1) {
								mouseX = Mouse.getEventX();
								mouseY = Display.getHeight() - Mouse.getEventY();
							}
						}
						else {
							mouse[button] = pressed;
						}
					}
				}
			}
		}, "Icuret Mouse-Input Thread");
		keyThread.start();
		mouseThread.start();
	}
	
	//EVENTS
	
	
	public void windowActivated(WindowEvent arg0) {
		windowFocused = true;
	}

	public void windowClosed(WindowEvent arg0) {
		
	}

	public void windowClosing(WindowEvent arg0) {
		closeRequested = true;
	}

	public void windowDeactivated(WindowEvent arg0) {
		windowFocused = false;
	}

	public void windowDeiconified(WindowEvent arg0) {
		
	}

	public void windowIconified(WindowEvent arg0) {
		
	}

	public void windowOpened(WindowEvent arg0) {
		
	}

	public void componentHidden(ComponentEvent arg0) {
		
	}

	public void componentMoved(ComponentEvent arg0) {
		
	}

	public void componentResized(ComponentEvent arg0) {
		try {
			core.getGraphics().requestResize();
		}
		catch(Exception e) {
		}
	}

	public void componentShown(ComponentEvent arg0) {
		
	}
	
	
	//METHODS
	
	public void bind(Component c) {
		this.bindedComponent = c;
	}
	
	public void unbind() {
		this.bindedComponent = null;
	}
	
	public boolean isCloseRequested() { 
		return closeRequested;
	}
	
	public boolean getMouse(int button) {
		return mouse[button];
	}
	
	public boolean getKey(int keycode) {
		return keys[keycode];
	}
	
	public void setMouse(int button, boolean pressed) {
		this.mouse[button] = pressed;
	}
	
	public void setKey(int keycode, boolean pressed) {
		this.keys[keycode] = pressed;
	}
	
	public boolean isMouseInBounds() {
		return mouseInBounds;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	public int[] getMouse() {
		return new int[] {mouseX, mouseY};
	}
	
	public Point getMousePoint() {
		return new Point(mouseX, mouseY);
	}
	
	public boolean isWindowFocused() {
		return windowFocused;
	}
	
	
	
}
