package edu.ilstu.uhigh.smashclone.characters;

import java.awt.Point;
import java.awt.image.BufferedImage;

import edu.ilstu.uhigh.smashclone.game.Controllable;
import edu.ilstu.uhigh.smashclone.game.SpriteManager;
import edu.ilstu.uhigh.smashclone.processors.KeyProcessor;
/*
 * AbstractCharacter 
 */
public abstract class AbstractCharacter implements Controllable {

	private int xPos, yPos;
	private int velocity;
	private SpriteManager sprite;
	private KeyProcessor keyButtons;
	boolean keyInput[];

	public BufferedImage icon;

	private final int[] walkLeft = {};
	private final int[] walkRight = {};

	abstract public void setPosition(Point pos);

	abstract public Point getPosition();
}
