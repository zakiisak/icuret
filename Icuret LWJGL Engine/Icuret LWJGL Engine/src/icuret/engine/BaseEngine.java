package icuret.engine;

import icuret.Core;
import icuret.Main;

public abstract class BaseEngine implements Engine, Runnable{

	protected int ups;
	protected int fps;
	protected int upsLimit;
	protected int fpsLimit;
	
	protected Core core;
	
	protected boolean running = false;
	
	protected Thread thread;

	public BaseEngine(Core core, int upsLimit, int fpsLimit) {
		this.core = core;
		this.upsLimit = upsLimit;
		this.fpsLimit = fpsLimit;
		core.setEngine(this);
	}

	public void start() {
		this.thread = new Thread(this, "Engine Thread");
		this.running = true;
		this.thread.start();
	}
	
	public void stop() {
		this.running = false;
		Main.stop();
	}

	public abstract void loop();
	
	public void run() {
		core.getWindow().create();
		loop();
	}
	
	public Thread getThread() {
		return thread;
	}
	
	@SuppressWarnings("deprecation")
	public void stopThread() {
		this.thread.stop();
	}
	
	public Core getCore() {
		return core;
	}

	public int getUPS() {
		return ups;
	}

	public int getFPS() {
		return fps;
	}

	public int getUPSLimit() {
		return upsLimit;
	}

	public int getFPSLimit() {
		return fpsLimit;
	}
	
	public boolean isRunning() {
		return running;
	}

}
