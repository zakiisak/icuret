package icuret.gui;

import icuret.Core;
import icuret.graphics.Graphics;

import org.newdawn.slick.UnicodeFont;

public class Button extends Component{
	public static final String COMP_ID = "ui.button";
	
	
	private String text = "";
	private UnicodeFont font;
	private float[] colorDefault = {0.30f, 0.30f, 0.30f, 0.75f};
	private float[] colorIntersection = {0.50f, 0.50f, 0.50f, 1.0f};
	private float[] color = colorDefault;
	
	private int animationDelay = 10;
	private int animationTick = 0;
	
	public Button(float x, float y, float width, float height) {
		setBounds(x, y, width, height);
		this.font = Graphics.consolas16;
		setUI(COMP_ID);
	}
	
	public Button(String text, float x, float y) {
		this.text = text;
		this.font = Graphics.consolas16;
		setLocation(x, y);
		setSize(this.font.getWidth(text) + 8, this.font.getLineHeight() + 8);
		setUI(COMP_ID);
	}
	
	public Button(String text, UnicodeFont font, float x, float y) {
		this.text = text;
		this.font = font;
		setLocation(x, y);
		setSize(this.font.getWidth(text) + 8, this.font.getLineHeight() + 8);
		setUI(COMP_ID);
	}
	
	public Button(String text, float x, float y, float width, float height) {
		this(x, y, width, height);
		this.text = text;
	}
	
	public Button(String text, UnicodeFont font, float x, float y, float width, float height) {
		this(text, font, x, y);
		setSize(width, height);
	}
	
	public void update(Core core, float delta) {
		super.update(core, delta);
		if(intersectsMouse()) {
			if(animationTick < animationDelay) {
				animationTick++;
				setColor();
			}
		}
		else {
			if(animationTick > 0) {
				animationTick--;
				setColor();
			}
		}
	}
	
	public String getText() {
		return text;
	}
	
	public UnicodeFont getFont() {
		return font;
	}
	
	public Button setFont(UnicodeFont font) {
		this.font = font;
		return this;
	}
	
	public Button setActionLeft(ActionEvent e) {
		setActionEventLeft(e);
		return this;
	}
	
	public Button setActionMiddle(ActionEvent e) {
		setActionEventMiddle(e);
		return this;
	}
	
	public Button setActionRight(ActionEvent e) {
		setActionEventRight(e);
		return this;
	}
	
	private float getRed() {
		float distance = (float) colorIntersection[0] - (float) colorDefault[0];
		float red = (float) distance / (float) animationDelay * (float) animationTick;
		return red;
	}
	
	private float getGreen() {
		float distance = colorIntersection[1] - colorDefault[1];
		float green = (float) distance / (float) animationDelay * (float) animationTick;
		return green;
	}
	
	private float getBlue() {
		float distance = colorIntersection[2] - colorDefault[2];
		float blue = (float) distance / (float) animationDelay * (float) animationTick;
		return blue;
	}
	
	private float getAlpha() {
		float distance = colorIntersection[3] - colorDefault[3];
		float alpha = (float) distance / (float) animationDelay * (float) animationTick;
		return alpha;
	}
	
	private void setColor() {
		color[0] = colorDefault[0] + getRed();
		color[1] = colorDefault[0] + getGreen();
		color[2] = colorDefault[0] + getBlue();
		color[3] = colorDefault[0] + getAlpha();
	}
	
	public float[] getDefaultColor() {
		return colorDefault;
	}
	
	public float[] getIntersectionColor() {
		return colorIntersection;
	}
	
	public int getAnimationDelay() {
		return animationDelay;
	}
	
	public float getAnimationProgress() {
		return (float) animationTick / (float) animationDelay;
	}
	
	public int getAnimationTick() {
		return animationTick;
	}
	
	public Button setColor(float[] defaultColor, float[] intersectionColor) {
		this.colorDefault = defaultColor;
		this.colorIntersection = intersectionColor;
		this.color = colorDefault;
		return this;
	}
	
	public Button setAnimationDelay(int upsTicks) {
		this.animationDelay = upsTicks;
		return this;
	}
	
	public float[] getColor() {
		return color;
	}
	
}
