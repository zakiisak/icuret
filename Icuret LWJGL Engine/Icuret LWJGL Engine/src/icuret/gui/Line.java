package icuret.gui;

import icuret.graphics.Graphics;

import org.newdawn.slick.UnicodeFont;

public class Line {
	
	private String text;
	private float[] color;
	private UnicodeFont font = Graphics.consolas16;
	
	public Line(String text, float[] color) {
		this.text = text;
		this.color = color;
	}
	
	public Line(String text, float red, float green, float blue, float alpha) {
		this(text, new float[] {red, green, blue, alpha});
	}
	
	public Line(String text, float red, float green, float blue) {
		this(text, red, green, blue, 1.0f);
	}
	
	public String getText() {
		return text;
	}
	
	public float[] getColor() {
		return color;
	}
	
	public float getRed() {
		return color[0];
	}
	
	public float getGreen() {
		return color[1];
	}
	
	public float getBlue() {
		return color[2];
	}
	
	public float getAlpha() {
		return color[3];
	}
	
	public UnicodeFont getFont() {
		return font;
	}
	
	public Line setFont(UnicodeFont font) {
		this.font = font;
		return this;
	}
	
}
