package icuret.gui;

import icuret.graphics.Graphics;

import org.newdawn.slick.UnicodeFont;

public class Label extends Component{
	public static final String COMP_ID = "ui.label";
	
	private String text;
	private UnicodeFont font = Graphics.arial12;
	private float[] color = {1.0f, 1.0f, 1.0f, 1.0f};
	
	public Label(String text, float x, float y) {
		this.text = text;
		setLocation(x, y);
		setUI(UI.getCurrentUI().getComponent(COMP_ID));
	}
	
	public Label(String text, UnicodeFont font, float x, float y) {
		this(text, x, y);
		this.font = font;
	}
	
	
	public String getText() {
		return text;
	}
	
	public UnicodeFont getFont() {
		return font;
	}
	
	public float[] getColor() {
		return color;
	}
	
	public Label setColor(float r, float g, float b) {
		this.color = new float[] {r, g, b, 1.0f};
		return this;
	}
	
	public Label setColor(float r, float g, float b, float a) {
		this.color = new float[] {r, g, b, a};
		return this;
	}
	
	public Label setColor(float[] color) {
		this.color = color;
		return this;
	}
	
	public Label setFont(UnicodeFont font) {
		this.font = font;
		return this;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
