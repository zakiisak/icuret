package icuret.engine;

import icuret.Core;
import icuret.graphics.Graphics;

import org.lwjgl.opengl.Display;

public class GameEngine extends BaseEngine {

	public GameEngine(Core core, int upsLimit, int fpsLimit) {
		super(core, upsLimit, fpsLimit);
	}
	
	public void loop() {
		Graphics g = new Graphics(core);
		long lastTime = System.nanoTime();
		long lastTime2 = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / upsLimit, ns2 = 1000000000.0 / fpsLimit;
		double delta = 0, delta2 = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			long now2 = System.nanoTime();
			delta2 += (now2 - lastTime2) / ns2;
			lastTime2 = now2;
			while(delta2 >= 1) {
				
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while (delta >= 1) {
					core.getState().update(core, 1.0f / (float) ups);
					core.getBase().update(core, 1.0f / (float) ups);
					updates++;
					delta--;
				
				}
				core.getState().render(core, g, 1.0f / (float) fps);
				core.getBase().render(core, g, 1.0f / (float) fps);
				if(g.isRequestingResize()) g.resize();
				Display.update();
				frames++;
				if(System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					fps = frames;
					ups = updates;
					System.out.println("FPS: " + fps + "  |  UPS: " + ups);
					updates = 0;
					frames = 0;
				}
				
				delta2--;
			}
		}
		stop();
	
	}

	

}
