package edu.ilstu.uhigh.smashclone.characters;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.control.ControlManager;
import edu.ilstu.uhigh.smashclone.control.GameState;
import edu.ilstu.uhigh.smashclone.game.Controllable;
import edu.ilstu.uhigh.smashclone.game.MapManager;
import edu.ilstu.uhigh.smashclone.game.SpriteManager;
import edu.ilstu.uhigh.smashclone.processors.KeyProcessor;
import edu.ilstu.uhigh.smashclone.view.Panel;

/*
 * AbstractCharacter used to define what a character should be. Implements the controllable interface
 */
public abstract class AbstractCharacter implements Controllable {
	//
	// Positional variables
	private int xPos, yPos;
	//
	// Velocity variable
	private int dx;
	private int dy;
	//
	// Sprite sheet
	private SpriteManager sprite;
	//
	// Key processor
	private KeyProcessor keyButtons;
	//
	// Action booleans
	private boolean keyInput[];
	//
	// canJump: ability to jump
	private boolean canJump;
	//
	// jumpHeight: The max pixels the character can jump in one setting
	private int jumpHeight;
	//
	// jumpCounter: How much pixels the character has left to jump
	private int jumpCounter;
	//
	// count: the amount of frames the animation spritesheet sequence should be
	// multiplied by
	protected int count;
	// icon: used for menu and HUD
	public BufferedImage icon;

	//
	// animations: list of image sequences for each player action
	ArrayList<int[]> animations = null;
	// Animation sequences with respected indexes
	int[] walkLeft = null;
	public final int WALKLEFT = 0;
	int[] walkRight = null;
	public final int WALKRIGHT = 1;

	// Rescale the image dimensions
	private final int RESCALE = 2;

	// Set the position

	public AbstractCharacter() {
		init();
	}

	public AbstractCharacter(int x, int y, KeyProcessor keyButtons, String file) {
		System.out.println("Made class in " + getClass().getName() + file);
		animations = new ArrayList<int[]>();
		sprite = new SpriteManager(file, 16, 16);
		xPos = x;
		yPos = y - (sprite.spriteHeight * RESCALE);
		this.keyButtons = keyButtons;
		init();
	}

	private void init() {
		keyInput = new boolean[6];
		dx = 3;
		dy = 3;
		canJump = true;
		jumpHeight = 150;
		jumpCounter = 0;

	}

	// draw(): Model method for drawing the character
	// PRECONDITION: character object must have a loaded spritesheet.
	// PRECONDITION: character's animation sequences must be working
	// POSTCONDITION: display the current sprite image on the screen (placed in
	// the right position)
	public void draw(Graphics g) {
		g.drawImage(sprite.currentFrame(), xPos, yPos, xPos + RESCALE
				* Panel.SCALE * sprite.currentFrame().getWidth(), yPos
				+ RESCALE * Panel.SCALE * sprite.currentFrame().getHeight(), 0,
				0, 16, 16, null);

	}

	// update()
	// PRECONDITION: SpriteManager bug-free, key input works
	// POSTCONDITION: Updates movement based on directional booleans
	public void update() {
		// Update the SpriteSheet image
		sprite.update();

		//
		// BUTTON PRESSES
		//
		// If the "LEFT" Button is pressed
		if (keyInput[KeyProcessor.LEFT]) {
			xPos -= dx;
			sprite.animate(animations.get(WALKLEFT));
		}
		// If the "RIGHT" Button is pressed
		if (keyInput[KeyProcessor.RIGHT]) {
			xPos += dx;
			sprite.animate(animations.get(WALKRIGHT));
		}
		
		checkJump(); // Check if the character can jump
		// If the "UP" Button is pressed
		if (keyInput[KeyProcessor.UP]) {
			yPos -= dy;
			jumpCounter += dy;
		}

		// Collision detection conditions
		if (checkPanelCollision() == false
				&& keyInput[KeyProcessor.UP] == false) { // If in the air and not jumping
			// Player physics to bring player down
			// TODO: Add acceleration/gravity
			yPos += dy; // yPos goes DOWN based on delta y
		} else if (checkPanelCollision() == true) { // If on a platform
			jumpCounter = 0; // JumpCounter is reseted
			canJump = true; // canJump set to true
		}
		
		

	}

	// checkJump(): Check if the character can jump
	private void checkJump() {
		// If jumpCounter is 0 out of jumpHeight
		if (jumpCounter == 0)
			canJump = true; //CanJump is set to true
		//If jumpCounter surpassed the jumpHeight limit
		if (jumpCounter > jumpHeight) { 
			canJump = false; //canJump is false
			keyInput[KeyProcessor.UP] = false; // Amend all UP presses
		}

	}

	// checkPanelCollision()
	//
	// PRECONDITION: Must have a UP processor boolean. The map should have
	// platforms
	//
	// POSTCONDITION: Returns TRUE if the player is ON the platform. Returns
	// FALSE if player is NOT on any platform AKA the air
	public boolean checkPanelCollision() {
		// Get the list of platforms from the current map
		ArrayList<Rectangle> plats = ((GameState) Panel.control.states
				.get(ControlManager.GAMESTATE)).maps.allMaps
				.get(MapManager.currentMap).platforms;

		// Iterate through all the platforms
		for (Rectangle a : plats) {

			//
			// If the x-coordinate is between the sides of the platforms
			if (getFoot().x < a.x + a.width && getFoot().x > a.x) {
				// <
				if (getFoot().y < a.y && getFoot().y > a.y - a.height) {
					return true;
				}
				//
				//
			}
			//
			//
		}
		return false;

	}

	// sendKeyInput()
	// PRECONDITION: KeyProcessor needs to be set
	// POSTCONDITION: Changes directional booleans based on key input
	public void sendKeyInput(KeyEvent k, boolean pressed) {
		// Changes directional booleans based on key input
		if (k.getKeyCode() == keyButtons.keys[KeyProcessor.UP] && canJump)
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
		System.out.println(sprite);
		this.xPos = pos.x;
		this.yPos = pos.y - (sprite.spriteHeight * RESCALE);
	}

	public Point getPosition() {
		return new Point(this.xPos, this.yPos);
	}

	public void setVelocity(int velocity) {
		this.dx = velocity;
	}

	public String toString() {
		return getClass().getName();
	}

	public Point getFoot() {
		return new Point(this.xPos, this.yPos + sprite.spriteHeight * RESCALE);
	}

	public void extendFrames() {
		// TODO: Make an exception class
		if (count <= 0) {
			System.err.println("Count must be greater than 0");
			System.err.println("Setting count to default: 1");
			count = 1;
		}
		// Go through each animations sequence
		for (int x = 0; x < animations.size(); x++) {
			// set the index of the temporary
			int index = 0;
			// initialize the temporary with the length of original * count
			int[] temp = new int[animations.get(x).length * count];
			// Iterate through the original animation sequence
			for (int i = 0; i < animations.get(x).length; i++) {
				// Add up until each is met to the "count" variable
				for (int k = 0; k < count; k++) {
					// set temporary = to the current original index
					temp[index] = animations.get(x)[i];
					// Next index in temporary
					index++;
				}

			}
			// Replace
			animations.remove(x);
			animations.add(x, temp);
		}

	}
}
