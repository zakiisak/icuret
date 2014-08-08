package icuret.state;

import icuret.Core;
import icuret.graphics.Graphics;

public interface State {
	//Remember arguments! :D
	public void init(Core core, Graphics g);
	public void update(Core c, float delta);
	public void render(Core c, Graphics g, float delta);
}
