package edu.ilstu.uhigh.smashclone.characters;

import edu.ilstu.uhigh.smashclone.processors.KeyProcessor;

/* Character is the generic class that gives the default data that
 * other characters will have (which will extend this class)
 */
public class LeftyLukeCharacter extends AbstractCharacter {

	private final static String IMAGEFILE = "LeftyLukeSpriteSheet.png";

	// Constructor: Sets the positions, velocity, spritesheet, and key buttons
	public LeftyLukeCharacter() {
		super(0, 0, null, IMAGEFILE);
		walkRight = new int[] { 0, 1, 2, 3 };
		walkLeft = new int[] { 4, 5, 6, 7 };
		animations.add(WALKLEFT, walkLeft);
		animations.add(WALKRIGHT, walkRight);
		count = 3;
		extendFrames();
	}

	public LeftyLukeCharacter(int x, int y, KeyProcessor keyButtons) {
		super(x, y, keyButtons, IMAGEFILE);
	}

	// draw()
	// PRECONDITION: The SpriteManager must be bug-free
	// POSTCONDITION: draws the current frame onto the screen

}