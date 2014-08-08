package icuret.state;

import static org.lwjgl.opengl.GL11.*;
import icuret.Core;
import icuret.graphics.DisplayList;
import icuret.graphics.Graphics;

import java.util.Random;

public class StateDisplayList implements State {
	
	private DisplayList list;
	
	public static void renderCube(float size)
	{
		final float HALF = size/2;
		glBegin(GL_QUADS);
 
		glColor3f(0, 0, 1);
		glVertex3f(-HALF, -HALF, -HALF); 
		glVertex3f(-HALF, size-HALF, -HALF); 
		glVertex3f(size-HALF, size-HALF, -HALF); 
		glVertex3f(size-HALF, -HALF, -HALF);  
 
		glColor3f(0, 1, 1);
		glVertex3f(-HALF, -HALF, size-HALF);  
		glVertex3f(-HALF, size-HALF, size-HALF);  
		glVertex3f(size-HALF, size-HALF, size-HALF); 
		glVertex3f(size-HALF, -HALF, size-HALF);  
 
		glColor3f(1, 0, 1);
		glVertex3f(-HALF, size-HALF, -HALF);  
		glVertex3f(size-HALF, size-HALF, -HALF); 
		glVertex3f(size-HALF, size-HALF, size-HALF); 
		glVertex3f(-HALF, size-HALF, size-HALF); 
 
		glColor3f(1, 0, 0);
		glVertex3f(-HALF, -HALF, -HALF);  
		glVertex3f(size-HALF, -HALF, -HALF); 
		glVertex3f(size-HALF, -HALF, size-HALF); 
		glVertex3f(-HALF, -HALF, size-HALF); 
 
		glColor3f(1, 1, 0);
		glVertex3f(-HALF, -HALF, -HALF);  
		glVertex3f(-HALF, size-HALF, -HALF); 
		glVertex3f(-HALF, size-HALF, size-HALF); 
		glVertex3f(-HALF, -HALF, size-HALF);  
 
		glColor3f(0, 1, 0);
		glVertex3f(size-HALF, -HALF, -HALF);  
		glVertex3f(size-HALF, size-HALF, -HALF); 
		glVertex3f(size-HALF, size-HALF, size-HALF); 
		glVertex3f(size-HALF, -HALF, size-HALF); 
 
		glEnd();
	}
	
	public static void renderQuad(float size) {
		final float HALF = size/2;
		glBegin(GL_QUADS);
 
		glColor3f(0, 0, 1);
		glVertex3f(-HALF, -HALF, -HALF); 
		glVertex3f(-HALF, size-HALF, -HALF); 
		glVertex3f(size-HALF, size-HALF, -HALF); 
		glVertex3f(size-HALF, -HALF, -HALF);  
		glEnd();
	}
	
	public static void renderQuad(float x, float y, float size) {
		glBegin(GL_QUADS);
 		glColor3f(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat());
		glVertex3f(x, y, 0); 
		glVertex3f(x + size, y, 0); 
		glVertex3f(x + size, y + size, 0); 
		glVertex3f(x, y + size, 0);
		glEnd();
	}
	
	public void init(Core core, Graphics g) {
		glEnable(GL_BLEND);
		//g.init2D();
		list = new DisplayList();
		list.begin();
		for(int x = 0; x < 2000; x++) {
			for(int y = 0; y < 2000; y++) {
				renderQuad((float) x * 32, (float) y * 32, 32f);
			}
		}
		list.end();
	}
	
	public void update(Core c, float delta) {
		
	}
	
	public void render(Core c, Graphics g, float delta) {
		list.call();
	}

}
