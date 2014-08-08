package icuret.state;

import icuret.Core;
import icuret.graphics.Graphics;
import icuret.graphics.Sprite;
import icuret.graphics.Texture;
import icuret.gui.Button;
import icuret.gui.Label;
import icuret.gui.TextField;

import java.awt.Font;

import org.lwjgl.input.Keyboard;

public class StateTest implements State {
	
	private Sprite test;
	
	public void init(Core core, Graphics g) {
		/*
//		Texture.x16Template = new Texture("C:/16x16 Template.PNG");
//		test = new Sprite(Texture.x16Template, 0, 0, 16, 16);
		core.getBase().add(new TextField(112, 112, 128, 32));
		core.getBase().add(new Button("TG", 160, 160));
		core.getBase().add(new Label("Hello!", 360, 192).setFont(Graphics.loadFont(new Font("Courier New", 0, 72))));
		Keyboard.enableRepeatEvents(true);
		*/
		
	}
	
	public void update(Core c, float delta) {
		if(c.getEventHandler().getKey(Keyboard.KEY_W)) {
			
		}
	}
	
	public void render(Core c, Graphics g, float delta) {
		g.refresh2D();
//		g.drawSprite(test, 64, 64, 32, 32);
		g.fillRect(16, 16, 32, 32);
	}

}
