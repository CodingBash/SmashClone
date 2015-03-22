package edu.ilstu.uhigh.smashclone;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerMenu implements Menu {

	protected int currentChoice = 0;
	protected ArrayList<String> options;

	private static final int BACKINDEX = 0;
	private static final int HOMEINDEX = 1;

	private BufferedImage background;
	private Color titleColor;
	private Font titleFont;

	private int textSpace;
	private int n = 0;

	public PlayerMenu() {
		super();
		int i = 2;
		for (Controllable character : Panel.control.characters)
		{
			if(character != Panel.control.currentplayers[0] &&  i%2 == 0)
			{
				options.add(i, character.getName());
				i++;
			}
			else if (character != Panel.control.currentplayers[1] &&  (i-1)%2 == 0){
				options.add(2 + Panel.control.characters.size()/2, character.getName());
				i++;
			}
			else
			{
				n++;
			}
		}
		options = new ArrayList<String>();
		options.add(BACKINDEX, "BACK");
		options.add(HOMEINDEX, "HOME");
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
				g.setColor(Color.WHITE);
			}
		}
		int i = 0;
		for(; i <2; i++)
			g.drawString(options.get(i), Panel.WIDTH / 2, Panel.HEIGHT
					* (3 / 2) + (i * textSpace));
		g.drawString("Player 1", Panel.WIDTH / 2, Panel.HEIGHT
				* (3 / 2) + (i * textSpace));
		for(;i < 2 + Panel.control.characters.size()/2; i++)
		{
			g.drawString(options.get(i), Panel.WIDTH / 2, Panel.HEIGHT
					* (3 / 2) + (i * textSpace));
		}
		g.drawString("Player 2", Panel.WIDTH / 2, Panel.HEIGHT
				* (3 / 2) + (i * textSpace));
		for(;i < options.size(); i++)
		{
			g.drawString(options.get(i), Panel.WIDTH / 2, Panel.HEIGHT
					* (3 / 2) + (i * textSpace));
		}
	}

	public void select(int currentChoice) {
		// OVERRIDE THIS, BUT HERE IS A SIMPLE TEMPLATE
		if (currentChoice == 0) { // Back
			Panel.control.menu.setMenu(MenuState.OPTIONMENU);
		} else if (currentChoice == 1) { // Home
			Panel.control.menu.setMenu(MenuState.OPTIONMENU);
		} else 
		{
			if(currentChoice < 2 + Panel.control.characters.size())
			Panel.control.currentplayers[0] = Panel.control.characters.get(currentChoice - 2 - n);
			else
				Panel.control.currentplayers[1] = Panel.control.characters.get(currentChoice - 2 - n);
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
