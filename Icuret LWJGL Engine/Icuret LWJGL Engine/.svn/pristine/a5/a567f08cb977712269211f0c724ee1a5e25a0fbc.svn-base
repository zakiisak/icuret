package icuret.gui;

import icuret.Core;
import icuret.graphics.Graphics;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.UnicodeFont;

public class TextField extends Component{
	public static final String COMP_ID = "ui.textfield";
	
	private boolean focused;
	private String text;
	private UnicodeFont currentFont = Graphics.consolas16;
	private int position = -1;
	private boolean renderingCursor = true;
	private int cursorDelay = 30;
	private int cursorTick = cursorDelay;
	
	public TextField(float x, float y, float width, float height) {
		setBounds(x, y, width, height);
		final TextField tf = this;
		setActionEventLeft(new ActionEvent() {
			public void actionPerformed(Core core) {
				focused = true;
				core.getEventHandler().bind(tf);
			}
		});
		this.text = "";
		setUI(UI.getCurrentUI().getComponent(COMP_ID));
	}
	
	public void input(Core core, int keycode, boolean pressed) {
		if(pressed) {
			if(keycode == Keyboard.KEY_LEFT) {
				if(position >= 0) position--;
				resetCursor();
				return;
			}
			if(keycode == Keyboard.KEY_RIGHT) {
				if(position < text.length() - 1) position++;
				resetCursor();
				return;
			}
			if(keycode != Keyboard.KEY_BACK && keycode != Keyboard.KEY_DELETE) {
				if(allowKeys(keycode)) { //57 == SPACE
					if(currentFont.getWidth(text + Keyboard.getEventCharacter()) + getX() + 8 <= getX() + getWidth()) {
						char[] charArray = text.toCharArray();
						String finalString = "";
						for(int i = 0; i < text.length(); i++) {
								finalString += charArray[i];
								if(i == position) finalString += Keyboard.getEventCharacter();
						}
						if(text.length() < 1) finalString += Keyboard.getEventCharacter();
						if(position + 1 <= 0 && text.length() > 0) finalString = Keyboard.getEventCharacter() + text;
						text = finalString;
						position++;
						resetCursor();
					}
				}
			}
			else if(keycode == Keyboard.KEY_BACK && text.length() > 0) {
				char[] charArray = text.toCharArray();
				String finalString = "";
				for(int i = 0; i < text.length(); i++) {
					if(i != position)
						finalString += charArray[i];
				}
				text = finalString;
				position--;
				resetCursor();
			}
			else if(keycode == Keyboard.KEY_DELETE && text.length() > 0 && position < text.length()) {
				char[] charArray = text.toCharArray();
				String finalString = "";
				for(int i = 0; i < text.length(); i++) {
					if(i - 1 != position)
						finalString += charArray[i];
				}
				text = finalString;
				resetCursor();
			}
		}
	}
	
	private boolean allowKeys(int keycode) {
		if(Keyboard.getKeyName(keycode).length() < 2 || keycode == 57) return true;
		if(rangeAllow(keycode, new int[] {39, 40, 41, 43, 26, 27, 125, 144, 83, 145, 146, 147, 148, 51, 52})) return true;
		return false;
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
	
	public void render(Core c, Graphics g, float delta) {
		getUI().render(c, g, this, delta);
	}
	
	public void resetCursor() {
		cursorTick = cursorDelay;
		renderingCursor = true;
	}
	
	public void setCursorDelay(int upsTicks) {
		this.cursorDelay = upsTicks;
	}
	
	public boolean isFocused() {
		return focused;
	}
	
	public String getText() {
		return text;
	}
	
	public UnicodeFont getFont() {
		return currentFont;
	}
	
	public void setFont(UnicodeFont font) {
		this.currentFont = font;
	}
	
	public boolean shouldRenderCursor() {
		return renderingCursor;
	}
	
	public int getCursorPosition() {
		return position;
	}
	
	public static boolean rangeAllow(int keycode, int[] codesAllowed) {
		for(int i = 0; i < codesAllowed.length; i++) {
			if(keycode == codesAllowed[i]) return true;
		}
		return false;
	}
}
