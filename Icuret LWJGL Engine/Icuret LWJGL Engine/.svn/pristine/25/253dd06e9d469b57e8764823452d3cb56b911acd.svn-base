package icuret.state;

import icuret.Core;
import icuret.graphics.Graphics;
import icuret.world.World;

public class StateWorld implements State {
	
	private World world;
	
	public void init(Core core, Graphics g) {
		world = new World(g, core, 16, 16);
	}
	
	public void update(Core c, float delta) {
		world.update(c, delta);
	}
	
	public void render(Core c, Graphics g, float delta) {
		g.refresh2D();
		world.render();
	}

}
