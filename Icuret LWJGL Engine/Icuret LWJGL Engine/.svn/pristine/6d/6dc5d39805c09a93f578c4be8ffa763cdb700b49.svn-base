package icuret.gui;

import java.awt.geom.Rectangle2D;

import icuret.Core;
import icuret.entity.Entity;
import icuret.graphics.Graphics;

public class Component extends Entity{
	
	private ActionEvent actionEventIntersect;
	private ActionEvent actionEventLeft;
	private ActionEvent actionEventMiddle;
	private ActionEvent actionEventRight;
	
	private UIEvent renderer;
	
	private boolean intersecting = false;
	private boolean actionEventPerformedLeft;
	private boolean actionEventPerformedMiddle;
	private boolean actionEventPerformedRight;
	
	public void input(Core core, int keycode, boolean pressed) {}
	
	/**
	 * Call super.update(core, delta) in order to get the collision-detection.
	 * @param core
	 * @param delta
	 */
	public void update(Core core, float delta) {
		actionEventPerformedLeft = false;
		actionEventPerformedMiddle = false;
		actionEventPerformedRight = false;
		if(getRectangle().contains(core.getEventHandler().getMousePoint())) {
			intersecting = true;
			if(actionEventIntersect != null) actionEventIntersect.actionPerformed(core);
			if(core.getEventHandler().getMouse(0)) {
				if(actionEventLeft != null) {
					actionEventLeft.actionPerformed(core);
					actionEventPerformedLeft = true;
					core.getEventHandler().setMouse(0, false);
				}
			}
			if(core.getEventHandler().getMouse(2)) {
				if(actionEventMiddle != null) {
					actionEventMiddle.actionPerformed(core);
					actionEventPerformedMiddle = true;
					core.getEventHandler().setMouse(2, false);
				}
			}
			if(core.getEventHandler().getMouse(1)) {
				if(actionEventRight != null) {
					actionEventRight.actionPerformed(core);
					actionEventPerformedRight = true;
					core.getEventHandler().setMouse(1, false);
				}
			}
		}
		else {
			intersecting = false;
		}
	}
	public void render(Core core, Graphics g, float delta) {
		if(getUI() != null) {
			getUI().render(core, g, this, delta);
		}
	}
	
	public Rectangle2D.Float getRectangle() {
		return new Rectangle2D.Float(x, y, width, height);
	}
	
	public ActionEvent getActionEventLeft() {
		return actionEventLeft;
	}
	
	public ActionEvent getActionEventMiddle() {
		return actionEventMiddle;
	}
	
	public ActionEvent getActionEventRight() {
		return actionEventRight;
	}
	
	public UIEvent getUI() {
		return renderer;
	}
	
	public boolean intersectsMouse() {
		return intersecting;
	}
	
	public boolean isActionEventLeftPerforming() {
		return actionEventPerformedLeft;
	}
	
	public boolean isActionEventMiddlePerforming() {
		return actionEventPerformedMiddle;
	}
	
	public boolean isActionEventRightPerforming() {
		return actionEventPerformedRight;
	}
	
	public void setActionEventLeft(ActionEvent e) {
		this.actionEventLeft = e;
	}
	
	public void setActionEventMiddle(ActionEvent e) {
		this.actionEventMiddle = e;
	}
	
	public void setActionEventRight(ActionEvent e) {
		this.actionEventRight = e;
	}
	
	public void setUI(UIEvent renderer) {
		this.renderer = renderer;
	}
	
	public void setUI(String uiField) {
		this.renderer = UI.getCurrentUI().getComponent(uiField);
	}
	
}
