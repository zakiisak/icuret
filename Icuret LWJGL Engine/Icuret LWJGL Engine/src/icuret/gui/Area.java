package icuret.gui;

import icuret.Core;

import java.util.ArrayList;
import java.util.List;

public class Area extends Component{
	public static final String COMP_ID = "ui.area";
	
	/*
	 * TODO: Create caret follow feature. Think of other things which could be nice to add. :D
	 */
	
	private List<Line> lines = new ArrayList<Line>();
	private int caretPos = 0;
	
	private boolean focused = false;
	private boolean renderingCursor = false;
	
	private int cursorDelay = 30;
	private int cursorTick;
	private float maxLineWidth = 0;
	private float totalHeight = 0;
	
	public Area(float x, float y, float width, float height) {
		setBounds(x, y, width, height);
		setUI(COMP_ID);
	}
	
	public void input(Core core, int keycode, boolean pressed) {
		
	}
	
	public void update(Core core, float delta) {
		super.update(core, delta);
		if(core.getEventHandler().getMouse(0) && !isActionEventLeftPerforming() && !isActionEventMiddlePerforming() && !isActionEventRightPerforming() && !intersectsMouse()) {
			focused = false;
			core.getEventHandler().unbind();
			core.getEventHandler().setMouse(0, false);
		}
		if(focused) {
			if(cursorTick > 0) cursorTick--;
			else {
				cursorTick = cursorDelay;
				renderingCursor = renderingCursor ? false : true;
			}
		}
	}
	
	public List<Line> getLines() {
		return lines;
	}
	
	public Line getLine(int index) {
		return lines.get(index);
	}
	
	public void append(Line line) {
		int strWidth = line.getFont().getWidth(line.getText());
		int strHeight = line.getFont().getHeight(line.getText());
		totalHeight += strHeight;
		if(strWidth > maxLineWidth) maxLineWidth = strWidth;
		lines.add(line);
	}
	
	public void append(String text, float[] color) {
		append(new Line(text, color));
	}
	
	public void setText(Line[] lines) {
		this.lines.clear();
		maxLineWidth = 0;
		totalHeight = 0;
		for(int i = 0; i < lines.length; i++) {
			Line line = lines[i];
			int strWidth = line.getFont().getWidth(line.getText());
			int strHeight = line.getFont().getHeight(line.getText());
			totalHeight += strHeight;
			if(strWidth > maxLineWidth) maxLineWidth = strWidth;
			this.lines.add(line);
		}
	}
	
	public void setText(Line line) {
		setText(new Line[] {line});
	}
	
	public void setText(String text, float[] color) {
		setText(new Line(text, color));
	}
	
	public float getMaxLineWidth() {
		return maxLineWidth;
	}
	
	public float getTotalLineHeight() {
		return totalHeight;
	}
	
}
