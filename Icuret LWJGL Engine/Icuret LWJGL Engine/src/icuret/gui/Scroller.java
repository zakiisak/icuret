package icuret.gui;

import icuret.Core;
import icuret.window.EventHandler;

public class Scroller extends Component{
	public static final String COMP_ID = "ui.scroller";
	public static final int VERTICAL = 1;
	public static final int HORISONTAL = 2;
	public static final int THICKNESS = 24;
	
	private Component attachedArea;
	private int allignMode;
	private float scrollX;
	private float scrollY;
	
	public Scroller(Area attachedArea, int allignMode) {
		this.attachedArea = attachedArea;
		this.allignMode = allignMode;
		if(allignMode == VERTICAL) {
			setBounds(attachedArea.getX() + attachedArea.getWidth(), attachedArea.getY(), THICKNESS, attachedArea.getHeight() / (float) (1.0f));
		}
		else if(allignMode == HORISONTAL) {
			setBounds(attachedArea.getX(), attachedArea.getY() + attachedArea.getHeight(), attachedArea.getWidth(), THICKNESS);
		}
		setUI(COMP_ID);
	}
	
	public void update(Core core, float delta) {
		super.update(core, delta);
		if(intersectsMouse() && core.getEventHandler().getMouse(EventHandler.MOUSE_LEFT)) {
			if(allignMode == VERTICAL) {
				float difference = (float) core.getEventHandler().getMouseY() - getY();
				float dy = getY() - difference;
				if(dy < y) dy = getY();
				if(dy > y + height) dy = getY() + getHeight();
				setY(dy);
				
			}
			else if(allignMode == HORISONTAL) {
				
			}
		}
	}
	
	public Component getAttachedComponent() {
		return attachedArea;
	}
	
	public int getAllignMode() {
		return allignMode;
	}
	
	public float getScrollX() {
		return scrollX;
	}
	
	public float getScrollY() {
		return scrollY;
	}
	
}
