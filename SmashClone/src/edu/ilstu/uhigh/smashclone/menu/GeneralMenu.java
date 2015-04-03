package edu.ilstu.uhigh.smashclone.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.control.ControlManager;
import edu.ilstu.uhigh.smashclone.view.Panel;

public class GeneralMenu implements Menu {
	//
	//
	// currentChoice: holds the current option selected within the "Options" ArrayList
	protected static int currentChoice = 0;
	//
	//
	// options: list of options that the user can select. Must be displayed on GUI
	protected static ArrayList<String> options;
	//
	//
	// index: Holds the indexes for each of the options. This makes initializing clearer as well as
	// accessing the variables clearer
	private static final int STARTINDEX = 0;
	private static final int OPTIONSINDEX = 1;
	private static final int EXITINDEX = 2;
	private static final int GAMESTATE = 3;
	//
	//
	// background: holds the image for the background of this menu screen
	private static BufferedImage background;
	//
	//
	// titleColor: color variable of the menu title
	private static Color titleColor;
	//
	// titleFont: font variable of the menu title
	private static Font titleFont;
	//
	// textSpace:
	private static int textSpace;

	// GeneralMenu() constructor
	public GeneralMenu() {
		super();
		options = new ArrayList<String>();
		options.add(STARTINDEX, "START");
		options.add(OPTIONSINDEX, "OPTIONS");
		options.add(EXITINDEX, "EXIT");
		// options.add(GAMESTATE, "GAMESTATE");

		textSpace = 50;
	}

	@Override
	public void init() {

	}
	
	@Override
	public void update() {

	}

	@Override
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
				g.setColor(Color.WHITE);
			}

			g.drawString(options.get(i), Panel.WIDTH / 2, Panel.HEIGHT
					* (3 / 2) + (i * textSpace));
		}
	}

	@Override
	public void select(int currentChoice) {
		// Simple template for selected
		if (currentChoice == 0) { // START
			Panel.control.setState(Panel.control.GAMESTATE);
		} else if (currentChoice == 1) { // OPTIONS
			// do something
		} else if (currentChoice == 2) { // EXIT
			System.exit(0);
		} else if (currentChoice == 3) { // CHANGEGAMESTATE

		}
	}
	
	@Override
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

	@Override
	public void keyReleased(KeyEvent k) {

	}

}
