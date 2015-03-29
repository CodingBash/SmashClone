package edu.ilstu.uhigh.smashclone.characters;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import edu.ilstu.uhigh.smashclone.game.SpriteManager;
import edu.ilstu.uhigh.smashclone.processors.KeyProcessor;
import edu.ilstu.uhigh.smashclone.view.Panel;

/* Character is the generic class that gives the default data that
 * other characters will have (which will extend this class)
 */
public class GangsterCharacter extends AbstractCharacter {

	private final static String IMAGEFILE = "GangsterGuillermoSpriteSheet.png";

	// Constructor: Sets the positions, velocity, spritesheet, and key buttons
	public GangsterCharacter() {
		super(0, 0, null, IMAGEFILE);
		walkLeft = new int[] { 0, 1, 2, 3 };
		walkRight = new int[] { 4, 5, 6, 7 };
		animations.add(WALKLEFT, walkLeft);
		animations.add(WALKRIGHT, walkRight);
		count = 3;
		extendFrames();

	}

	public GangsterCharacter(int x, int y, KeyProcessor keyButtons) {
		super(x, y, keyButtons, IMAGEFILE);
	}

	// draw()
	// PRECONDITION: The SpriteManager must be bug-free
	// POSTCONDITION: draws the current frame onto the screen

}