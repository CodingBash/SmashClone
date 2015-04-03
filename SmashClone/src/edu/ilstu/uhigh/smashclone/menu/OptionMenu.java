package edu.ilstu.uhigh.smashclone.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.control.ControlManager;
import edu.ilstu.uhigh.smashclone.control.MenuState;
import edu.ilstu.uhigh.smashclone.view.Panel;

public class OptionMenu implements Menu {

	protected int currentChoice = 0;
	protected ArrayList<String> options;

	private static final int BACKINDEX = 0;
	private static final int MAPINDEX = 1;
	private static final int PLAYERINDEX = 2;

	private BufferedImage background;
	private Color titleColor;
	private Font titleFont;

	private int textSpace;

	public OptionMenu() {
		super();
		options = new ArrayList<String>();
		options.add(BACKINDEX, "BACK");
		options.add(MAPINDEX, "MAPS");
		options.add(PLAYERINDEX, "PLAYERS");
		// options.add(GAMESTATE, "GAMESTATE");

		textSpace = 50;
	}

	public void init() {

	}

	public void update() {

	}

	public void draw(Graphics g) {
		// iterate through "options" and draw the string (with current option
		// highlighted
		// use the color and font variables
		// draw background images
		for (int i = 0; i < options.size(); i++) {
			if (i == currentChoice) {
				g.setColor(Color.RED);
				// font change or any other emphasis
			} else {
				g.setColor(Color.BLACK);
			}

			g.drawString(options.get(i), Panel.WIDTH / 2, Panel.HEIGHT
					* (3 / 2) + (i * textSpace));
		}
	}

	public void select(int currentChoice) {
		// OVERRIDE THIS, BUT HERE IS A SIMPLE TEMPLATE
		if (currentChoice == 0) { // BACK
			((MenuState) Panel.control.states.get(ControlManager.MENUSTATE)).setMenu(MenuState.GENERALMENU);
		} else if (currentChoice == 1) { // MAPS
			((MenuState) Panel.control.states.get(ControlManager.MENUSTATE)).setMenu(MenuState.MAPMENU);
		} else if (currentChoice == 2) { // PLAYERS
			((MenuState) Panel.control.states.get(ControlManager.MENUSTATE)).setMenu(MenuState.PLAYERMENU);
		} 
	}

	public void keyPressed(KeyEvent k) {
		// OVERRIDE THIS, BUT HERE IS A SIMPLE TEMPLATE
		switch (k.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			select(currentChoice);
			break;
		case KeyEvent.VK_UP:
			// TODO:Didn't know how to implement this with modulos
			currentChoice = (currentChoice <= 0) ? options.size() - 1
					: currentChoice - 1;
			break;
		case KeyEvent.VK_DOWN:
			currentChoice = (currentChoice + 1) % options.size();
			break;
		// No default unless stating an exception
		}
	}

	public void keyReleased(KeyEvent k) {

	}

}