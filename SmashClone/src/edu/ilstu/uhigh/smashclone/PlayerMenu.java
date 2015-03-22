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
	private static final int PLAYER1INDEX = 2;
	private static final int PLAYER2INDEX = 3;

	private BufferedImage background;
	private Color titleColor;
	private Font titleFont;

	private int textSpace;
	private int[] CharacterChoice = new int[2];
	public PlayerMenu() {
		super();
		CharacterChoice[0] = Panel.control.characters1.indexOf(Panel.control.currentplayers[0]);
		CharacterChoice[1] = Panel.control.characters2.indexOf(Panel.control.currentplayers[1]);
		options = new ArrayList<String>();
		options.add(BACKINDEX, "BACK");
		options.add(HOMEINDEX, "Home");
		options.add(PLAYER1INDEX, Panel.control.characters1.get(CharacterChoice[0]).toString());
		options.add(PLAYER2INDEX, Panel.control.characters2.get(CharacterChoice[1]).toString());
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
		for (int i = 0, n = 0; i < options.size(); i++) {
			if (i == currentChoice) {
				g.setColor(Color.RED);
				// font change or any other emphasis
			} else {
				g.setColor(Color.WHITE);
			}
			if(i == PLAYER1INDEX)
			{
				g.setColor(Color.WHITE);
				g.drawString("PLAYER 1", Panel.WIDTH / 2, Panel.HEIGHT
						* (3 / 2) + (i * textSpace));
				n++;
			}
			else if(i == PLAYER2INDEX)
			{
				g.setColor(Color.WHITE);
				g.drawString("PLAYER 2", Panel.WIDTH / 2, Panel.HEIGHT
						* (3 / 2) + (i * textSpace));
				n++;
			}
			g.drawString(options.get(i), Panel.WIDTH / 2, Panel.HEIGHT
					* (3 / 2) + ((i+n) * textSpace));
		}
		
	}

	public void select(int currentChoice) {
		// OVERRIDE THIS, BUT HERE IS A SIMPLE TEMPLATE
		if (currentChoice == 0) { // Back
			Panel.control.menu.setMenu(MenuState.OPTIONMENU);
		} else if (currentChoice == 1) { // Home
			Panel.control.menu.setMenu(MenuState.OPTIONMENU);
		} else if(currentChoice == 2)
		{
			Panel.control.currentplayers[0] = Panel.control.characters1.get(CharacterChoice[0]);
		} else if(currentChoice == 3)
		{
			Panel.control.currentplayers[1] = Panel.control.characters2.get(CharacterChoice[1]);
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
		case KeyEvent.VK_LEFT:
			if(currentChoice == PLAYER1INDEX)
			{
				CharacterChoice[0] = (CharacterChoice[0] + 1) % Panel.control.characters1.size();
				options.set(PLAYER1INDEX, Panel.control.characters1.get(CharacterChoice[0]).toString());
			}
			else if(currentChoice == PLAYER2INDEX)
			{
				CharacterChoice[1] = (CharacterChoice[1] + 1) % Panel.control.characters2.size();
				options.set(PLAYER2INDEX, Panel.control.characters2.get(CharacterChoice[1]).toString());
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(currentChoice == PLAYER1INDEX)
			{
				CharacterChoice[0]--;
				if(CharacterChoice[0] == 0)
					CharacterChoice[0] = Panel.control.characters1.size() - 1;
				options.set(PLAYER1INDEX, Panel.control.characters1.get(CharacterChoice[0]).toString());
			}
			else if(currentChoice == PLAYER2INDEX)
			{
				CharacterChoice[1]--;
				if(CharacterChoice[1] == 0)
					CharacterChoice[1] = Panel.control.characters2.size() - 1;
				options.set(PLAYER2INDEX, Panel.control.characters2.get(CharacterChoice[1]).toString());
			}
		// No default unless stating an exception
		}
	}

	public void keyReleased(KeyEvent k) {

	}

}
