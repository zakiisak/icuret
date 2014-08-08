package icuret.window;

import icuret.Core;
import icuret.Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {
	
	private Core core;
	private JFrame frame;
	private Canvas canvas;
	
	private int width;
	private int height;
	private String title;

	private boolean resizable = false;
	private boolean fullscreen = false;
	private boolean vsync = true;
	private boolean lwjglWindow = false;

	public Window(Core core, int width, int height, String title, boolean resizable, boolean fullscreen, boolean vsync, boolean lwjglWindow) {
		this.core = core;
		this.width = width;
		this.height = height;
		this.title = title;
		this.resizable = resizable;
		this.fullscreen = fullscreen;
		this.vsync = vsync;
		this.lwjglWindow = lwjglWindow;
		core.setWindow(this);
	}

	public void create() {
		try {
			if(!lwjglWindow) {
				frame = new JFrame(title);
				canvas = new Canvas();
				frame.add(canvas);
				Display.setParent(canvas);
				frame.setResizable(resizable);
				setFullscreen(fullscreen);
				frame.setMinimumSize(new Dimension(width, height));
				frame.setPreferredSize(new Dimension(width, height));
				frame.pack();
				frame.addWindowListener(core.getEventHandler());
				frame.addComponentListener(core.getEventHandler());
				if(!fullscreen) frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.requestFocus();
				canvas.requestFocus();
			}
			else {
				Display.setDisplayMode(new DisplayMode(width, height));
				Display.setTitle(title);
				Display.setFullscreen(fullscreen);
				Display.setVSyncEnabled(vsync);
			}
			Display.create();
			Keyboard.create();
			Mouse.create();
			core.getEventHandler().start();
			Main.initializeStates();
		}
		catch(Exception e) {
			Sys.alert("Error!", "Error while attempting to create window: " + e);
		}
	}
	
	public void setFullscreen(boolean fullscreen) {
		if(fullscreen) {
			frame.setLocation(0, 0);
			frame.setExtendedState(Frame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
		}
		else {
			frame.setExtendedState(Frame.NORMAL);
			frame.setUndecorated(false);
		}
	}
	
	
	public Canvas getCanvas() {
		return canvas;
	}

	public Frame getFrame() {
		return frame;
	}

	public int getWidth() {
		if(frame != null) return frame.getWidth();
		if(Display.getDisplayMode() != null) return Display.getWidth();
		return width;
	}

	public int getHeight() {
		if(frame != null) return frame.getHeight();
		if(Display.getDisplayMode() != null) return Display.getHeight();
		return height;
	}

	public String getTitle() {
		return title;
	}

	public boolean isResizable() {
		return resizable;
	}

	public boolean isFullscreen() {
		return fullscreen;
	}

}
