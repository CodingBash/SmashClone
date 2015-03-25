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

	//Positional variables
	private int xPos, yPos;
	//Velocity variable
	private int velocity;
	//Sprite sheet
	private SpriteManager sprite;
	//Key processor
	private KeyProcessor keyButtons;
	//Action booleans
	boolean keyInput[];

	//Icon (used for menu and HUD)
	public BufferedImage icon;

	//Animation sequences
	private final int[] walkLeft = {};
	private final int[] walkRight = {};

	//Set the position
	abstract public void setPosition(Point pos);

	//Get the position
	abstract public Point getPosition();
}
