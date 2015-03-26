package edu.ilstu.uhigh.smashclone.characters;

import java.awt.Point;
import java.awt.image.BufferedImage;

import edu.ilstu.uhigh.smashclone.game.Controllable;
import edu.ilstu.uhigh.smashclone.game.SpriteManager;
import edu.ilstu.uhigh.smashclone.processors.KeyProcessor;

/*
 * AbstractCharacter used to define what a character should be. Implements the controllable interface
 */
public abstract class AbstractCharacter implements Controllable {

	// Positional variables
	int xPos, yPos;
	// Velocity variable
	int velocity;
	// Sprite sheet
	SpriteManager sprite;
	// Key processor
	KeyProcessor keyButtons;
	// Action booleans
	boolean keyInput[];

	// Icon (used for menu and HUD)
	public BufferedImage icon;

	// Animation sequences
	final int[] walkLeft = null;
	final int[] walkRight = null;

	//Rescale the image dimensions
	static final int RESCALE = 3;
	// Set the position
	abstract public void setPosition(Point pos);

	// Get the position
	abstract public Point getPosition();
}
