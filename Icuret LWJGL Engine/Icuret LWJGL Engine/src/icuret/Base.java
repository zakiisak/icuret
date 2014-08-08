package icuret;

import icuret.graphics.Graphics;
import icuret.gui.Component;

import java.util.ArrayList;
import java.util.List;

public class Base {
	
	private List<Component> components = new ArrayList<Component>();
	
	public Base(Core core) {
		core.setBase(this);
	}
	
	public void update(Core core, float delta) {
		for(int i = 0; i < components.size(); i++) {
			components.get(i).update(core, delta);
		}
	}
	
	public void render(Core core, Graphics g, float delta) {
		for(int i = 0; i < components.size(); i++) {
			components.get(i).render(core, g, delta);
		}
	}
	
	@SuppressWarnings("unused")
	private List<Component> getComponents() {
		return components;
	}
	
	public Component getComponent(int index) {
		return components.get(index);
	}
	
	public void add(Component c) {
		components.add(c);
	}
	
	public void remove(int index) {
		components.remove(index);
	}
	
	public void remove(Object component) {
		components.remove(component);
	}
	
}
