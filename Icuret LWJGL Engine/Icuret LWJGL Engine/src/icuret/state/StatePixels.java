package icuret.state;

import icuret.Core;
import icuret.graphics.Graphics;
import icuret.graphics.Sprite;
import icuret.graphics.Texture;
import icuret.gui.Button;
import icuret.gui.Label;
import icuret.gui.TextField;
import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;

import org.lwjgl.input.Keyboard;

public class StatePixels implements State {
	
	private Sprite test;
	int[] pixels = new int[64 * 64];
	
	public void init(Core core, Graphics g) {
	}
	
	public void update(Core c, float delta) {
	}
	
	public void render(Core c, Graphics g, float delta) {
		g.refresh2D();
		glDrawPixels(64, 64, GL_RGB, GL_UNSIGNED_INT, pixels);
	}

}
