package icuret.gui;

import icuret.Core;
import icuret.graphics.Graphics;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.UnicodeFont;

public class UI {
	
	
	public static final UI UI_DEFAULT = new UI() {{
		addComponent(TextField.COMP_ID, new UIEvent() {
			public void render(Core core, Graphics g, Component c, float delta) {
				TextField tf = (TextField) c;
				if(tf.isFocused()) {
					g.setColor(0.45f, 0.45f, 0.45f, 0.75f);
					g.fillRect(tf.getX(), tf.getY(), tf.getWidth(), tf.getHeight());
					g.setColor(0.90f, 0.90f, 0.90f, 1.0f);
					UnicodeFont font = g.getFont();
					g.setFont(tf.getFont());
					int cursorHeight = (int) (tf.getFont().getLineHeight());
					int offset = 4;
					g.drawString(tf.getText(), tf.getX() + 4, tf.getY() + tf.getHeight() / 2 - g.getFont().getLineHeight() / 2);
					if(tf.shouldRenderCursor()) {
						if(tf.getCursorPosition() >= 0 && tf.getText().length() > 0)
							g.fillRect(tf.getX() + 4 + tf.getFont().getWidth(tf.getText().substring(0, tf.getCursorPosition()) + "_"), tf.getY() + tf.getHeight() / 2 - g.getFont().getLineHeight() / 2 + offset / 2, 1, cursorHeight - offset);
						else g.fillRect(tf.getX() + 4, tf.getY() + tf.getHeight() / 2 - g.getFont().getLineHeight() / 2 + offset / 2, 1, cursorHeight - offset);
					}
					g.setFont(font);
				}
				else {
					g.setColor(0.32f, 0.32f, 0.32f, 0.5f);
					g.fillRect(tf.getX(), tf.getY(), tf.getWidth(), tf.getHeight());
					g.setColor(0.65f, 0.65f, 0.65f, 1.0f);
					UnicodeFont font = g.getFont();
					g.setFont(tf.getFont());
					g.drawString(tf.getText(), tf.getX() + 4, tf.getY() + tf.getHeight() / 2 - g.getFont().getLineHeight() / 2);
					g.setFont(font);
				}
			}
		});
		
		addComponent(Button.COMP_ID, new UIEvent() {
			public void render(Core core, Graphics g, Component c, float delta) {
				UnicodeFont font = g.getFont();
				Button b = (Button) c;
				float damping = 0.50f;
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				g.setColor(b.getColor()[0], b.getColor()[1], b.getColor()[2], b.getColor()[3]);
				g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
				g.setColor(b.getColor()[0] * damping, b.getColor()[1] * damping, b.getColor()[2] * damping, b.getColor()[3] * damping);
				g.setFont(b.getFont());
				g.drawString(b.getText(), b.getX() + b.getWidth() / 2 - b.getFont().getWidth(b.getText()) / 2, b.getY() + b.getHeight() / 2 - b.getFont().getLineHeight() / 2);
				g.setFont(font);
			}
		});
		
		addComponent(Label.COMP_ID, new UIEvent() {
			public void render(Core core, Graphics g, Component c, float delta) {
				UnicodeFont font = g.getFont();
				Label l = (Label) c;
				g.setColor(l.getColor()[0], l.getColor()[1], l.getColor()[2], l.getColor()[3]);
				g.setFont(l.getFont());
				g.drawString(l.getText(), l.getX(), l.getY());
				g.setFont(font);
			}
		});
		
		addComponent(Area.COMP_ID, new UIEvent() {
			public void render(Core core, Graphics g, Component c, float delta) {
				Area a = (Area) c;
				g.setColor(0.4f, 0.4f, 0.4f);
				g.fillRect(a.getX(), a.getY(), a.getWidth(), a.getHeight());
			}
		});
		
		
		
	}};
	
	private static UI UI = UI_DEFAULT;
	
	public static UI getCurrentUI() {
		return UI;
	}
	
	public static void setUI(UI ui) {
		UI = ui;
	}
	
	private Map<String, UIEvent> ui = new HashMap<String, UIEvent>();
	
	public Map<String, UIEvent> getUI() {
		return ui;
	}
	
	public UIEvent getComponent(Object id) {
		return ui.get(id);
	}
	
	public void addComponent(String id, UIEvent e) {
		ui.put(id, e);
	}
}
