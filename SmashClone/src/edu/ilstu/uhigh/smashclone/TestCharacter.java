package edu.ilstu.uhigh.smashclone;

import edu.ilstu.uhigh.smashclone.KeyProcessor;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/* Character is the generic class that gives the default data that
 * other characters will have (which will extend this class)
 */
public class TestCharacter implements Controllable {
	//
	//
	// Character's position variables
	int xPos, yPos;
	//
	//
	// Chracter's delta xPos value
	int velocity;
	//
	//
	// Essential objects to the characters
	SpriteManager sprite;
	KeyProcessor keyButtons;
	boolean keyInput[];
	//
	//
	// Animation sequences for the characters spritesheets
	final int[] walkDown = { 0, 1, 2, 3, 4, 5 };
	final int[] walkUp = { 24, 25, 26, 27, 28, 29 };
	final int[] walkLeft = { 12, 13, 14, 15, 16, 17 };
	final int[] walkRight = { 36, 37, 38, 39, 40, 41, 42 };

	// Constructor: Sets the positions, velocity, spritesheet, and key buttons
	public TestCharacter(int x, int y, KeyProcessor keyButtons) {
		xPos = x;
		yPos = y;
		velocity = 5;
		sprite = new SpriteManager("GoblinWalk.png", 126, 170);
		this.keyButtons = keyButtons;
		keyInput = new boolean[6];
	}

	// draw()
	// PRECONDITION: The SpriteManager must be bug-free
	// POSTCONDITION: draws the current frame onto the screen
	public void draw(Graphics g) {
		g.drawImage(sprite.currentFrame(), xPos, yPos, null);
	}

	// update()
	// PRECONDITION: SpriteManager bug-free, key input works
	// POSTCONDITION: Updates movement based on directional booleans
	public void update() {
		// Update the spritesheet frame
		sprite.update();
		// Update movement based on directional booleans
		if (keyInput[KeyProcessor.UP]) {
			yPos -= velocity;
			sprite.animate(walkUp);
		}
		if (keyInput[KeyProcessor.DOWN]) {
			yPos += velocity;
			sprite.animate(walkDown);
		}
		if (keyInput[KeyProcessor.LEFT]) {
			xPos -= velocity;
			sprite.animate(walkLeft);
		}
		if (keyInput[KeyProcessor.RIGHT]) {
			xPos += velocity;
			sprite.animate(walkRight);
		}
	}

	// sendKeyInput()
	// PRECONDITION: KeyProcessor needs to be set
	// POSTCONDITION: Changes directional booleans based on key input
	public void sendKeyInput(KeyEvent k, boolean pressed) {
		// Changes directional booleans based on key input
		if (k.getKeyCode() == keyButtons.keys[KeyProcessor.UP])
			keyInput[KeyProcessor.UP] = pressed;
		if (k.getKeyCode() == keyButtons.keys[KeyProcessor.LEFT])
			keyInput[KeyProcessor.LEFT] = pressed;
		if (k.getKeyCode() == keyButtons.keys[KeyProcessor.DOWN])
			keyInput[KeyProcessor.DOWN] = pressed;
		if (k.getKeyCode() == keyButtons.keys[KeyProcessor.RIGHT])
			keyInput[KeyProcessor.RIGHT] = pressed;
		if (k.getKeyCode() == keyButtons.keys[KeyProcessor.BUTTONA])
			keyInput[KeyProcessor.BUTTONA] = pressed;
		if (k.getKeyCode() == keyButtons.keys[KeyProcessor.BUTTONB])
			keyInput[KeyProcessor.BUTTONB] = pressed;
	}
}