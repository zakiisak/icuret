package icuret.engine;

import icuret.Core;

public interface Engine {
	
	public void start();
	public void stop();
	public void loop();
	public Thread getThread();
	public void stopThread();
	public Core getCore();
	
	public int getUPS();
	public int getFPS();
	public int getUPSLimit();
	public int getFPSLimit();
	public boolean isRunning();
	
}
