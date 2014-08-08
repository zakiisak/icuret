package icuret.world.tile;

import icuret.entity.Entity;
import icuret.graphics.Graphics;
import icuret.state.StateDisplayList;

import java.util.Random;

import org.newdawn.slick.Color;

import static org.lwjgl.opengl.GL11.*;

public class Tile extends Entity{
	
	public float[] rgb;
	
	public Tile(Entity e) {
		Random r = new Random();
		rgb = new float[] {r.nextFloat(), r.nextFloat(), r.nextFloat()};
		setBounds(e.getX(), e.getY(), e.getWidth(), e.getHeight());
	}
	
	public void render(int x, int y) {
		StateDisplayList.renderQuad(this.x, this.y, width);
		/*
		glLoadIdentity();
		glTranslatef(this.x, this.y, 0);
		Graphics.arial12.drawString(this.x + 4, this.y + 4, "X: " + x, Color.white);
		Graphics.arial12.drawString(this.x + 4, this.y + 20, "Y: " + y, Color.white);
		glLoadIdentity();
		*/
	}
}
