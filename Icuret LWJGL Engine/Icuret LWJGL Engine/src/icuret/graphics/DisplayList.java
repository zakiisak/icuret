package icuret.graphics;

import static org.lwjgl.opengl.GL11.*;

public class DisplayList {
	
	private int id;
	
	public void begin() {
		id = glGenLists(1);
		glNewList(id, GL_COMPILE);
	}
	
	public void end() {
		glEndList();
	}
	
	public void call() {
		glCallList(id);
	}
	
	public int getID() {
		return id;
	}
	
}
