package icuret.world;

import org.lwjgl.input.Keyboard;

import icuret.Core;
import icuret.entity.Entity;
import icuret.graphics.DisplayList;
import icuret.graphics.Graphics;
import icuret.world.tile.Tile;
import static org.lwjgl.opengl.GL11.*;

public class World {
	
	private int width;
	private int height;
	private DisplayList[] tileLists;
	private Tile[] tiles;	
	
	private Entity camera;
	
	public World(Graphics g, Core c, int width, int height) {
		try {
			tiles = new Tile[width * height];
			tileLists = new DisplayList[width * height];
			
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					tiles[x + y * width] = new Tile(new Entity(x * 32, y * 32, 32, 32));
				}
			}
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					tileLists[x + y * width] = new DisplayList();
					tileLists[x + y * width].begin();
					for(int wx = 0; wx < c.getWindow().getWidth() / 32; wx++) {
						for(int wy = 0; wy < c.getWindow().getHeight() / 32; wy++) {
							if(x + wx >= width || y + wy >= height || x < 0 || y < 0 || wx > width || wy > height) continue;
							//if((x + wx) + (y + wy) * width >= width * height || x + y * width > width * height || wx + wy * width > width * height) continue;
							//if(tiles[(x + wx) + (y + wy) * width] == null) tiles[(x + wx) + (y + wy) * width] = new Tile(new Entity((x + wx) * 32, (y + wy) * 32, 32, 32));
							tiles[(x + wx) + (y + wy) * width].render(x, y);
						}
					}
					tileLists[x + y * width].end();
				}
			}
			camera = new Entity(0, 0, 0, 0);
		}
		catch(Exception e) {
			System.out.println("Error! (World Initialization)");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private float ms = 2.0f;
	
	public void update(Core core, float delta) {
		if(core.getEventHandler().getKey(Keyboard.KEY_W)) {
			camera.subY(ms);
		}
		if(core.getEventHandler().getKey(Keyboard.KEY_S)) {
			camera.addY(ms);
		}
		if(core.getEventHandler().getKey(Keyboard.KEY_A)) {
			camera.subX(ms);
		}
		if(core.getEventHandler().getKey(Keyboard.KEY_D)) {
			camera.addX(ms);
		}
	}
	
	public void render() {
		int index = (int) ((int) (camera.getX() / 32) + (int) (camera.getY() / 32) * width);
		if(index < 0) index = 0;
		if(index >= 0 && tileLists[index] != null) {
			glPushMatrix();
			glTranslatef(-camera.getX(), -camera.getY(), 0);
			tileLists[index].call();
			glPopMatrix();
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Tile getTile(int index) {
		return tiles[index];
	}
	
	public Tile getTile(int x, int y) {
		return tiles[x + y * width];
	}
	
	
}
