package edu.ilstu.uhigh.smashclone.characters;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import edu.ilstu.uhigh.smashclone.game.SpriteManager;
import edu.ilstu.uhigh.smashclone.processors.KeyProcessor;

/* Character is the generic class that gives the default data that
 * other characters will have (which will extend this class)
 */
public class GangsterCharacter extends AbstractCharacter {
	
	final int[] walkLeft = { 0, 1, 2, 3 };
	final int[] walkRight = { 4, 5, 6, 7 };

	// Constructor: Sets the positions, velocity, spritesheet, and key buttons
	public GangsterCharacter() {
		init();
	}

	public GangsterCharacter(int x, int y, KeyProcessor keyButtons) {
		xPos = x;
		yPos = y - (sprite.spriteHeight * RESCALE);
		this.keyButtons = keyButtons;
		init();
	}

	private void init() {
		sprite = new SpriteManager("GangsterGuillermoSpriteSheet.png", 16, 16);
		keyInput = new boolean[6];
		velocity = 3;
	}

	// draw()
	// PRECONDITION: The SpriteManager must be bug-free
	// POSTCONDITION: draws the current frame onto the screen
	public void draw(Graphics g) {
		g.drawImage(sprite.currentFrame(), xPos, yPos, xPos + RESCALE
				* sprite.currentFrame().getWidth(), yPos + RESCALE
				* sprite.currentFrame().getHeight(), 0, 0, 16, 16, null);

	}

	// update()
	// PRECONDITION: SpriteManager bug-free, key input works
	// POSTCONDITION: Updates movement based on directional booleans
	public void update() {
		// Update the spritesheet frame
		sprite.update();
		// Update movement based on directional booleans
		/*
		 * if (keyInput[KeyProcessor.UP]) { yPos -= velocity;
		 * sprite.animate(walkUp); } if (keyInput[KeyProcessor.DOWN]) { yPos +=
		 * velocity; sprite.animate(walkDown); }
		 */
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

	public void setKeys(KeyProcessor keys) {
		this.keyButtons = keys;
	}

	public void setPosition(int x, int y) {
		this.xPos = x;
		this.yPos = y - (sprite.spriteHeight * RESCALE);
	}

	public void setPosition(Point pos) {
		this.xPos = pos.x;
		this.yPos = pos.y - (sprite.spriteHeight * RESCALE);
	}

	public Point getPosition() {
		return new Point(this.xPos, this.yPos);
	}
}