package icuret;

import icuret.engine.Engine;
import icuret.graphics.Graphics;
import icuret.state.State;
import icuret.window.EventHandler;
import icuret.window.Window;

public class Core {
	
	private Engine engine;
	private State gameState;
	private Window window;
	private Graphics graphics;
	private EventHandler eventHandler;
	private Base base;
	
	public Engine getEngine() {
		return engine;
	}
	
	public State getState() {
		return gameState;
	}
	
	public Window getWindow() {
		return window;
	}
	
	public Graphics getGraphics() {
		return graphics;
	}
	
	public EventHandler getEventHandler() { 
		return eventHandler;
	}
	
	public Base getBase() {
		return base;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void setState(State state) {
		this.gameState = state;
	}
	
	public void setWindow(Window window) {
		this.window = window;
	}
	
	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}
	
	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}
	
	public void setBase(Base base) {
		this.base = base;
	}
}
