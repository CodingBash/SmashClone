package edu.ilstu.uhigh.smashclone.characters;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import edu.ilstu.uhigh.smashclone.game.Controllable;
import edu.ilstu.uhigh.smashclone.game.KeyProcessor;
import edu.ilstu.uhigh.smashclone.game.SpriteManager;

/* Character is the generic class that gives the default data that
 * other characters will have (which will extend this class)
 */
public class TestCharacter implements Controllable {
	//
	//
	// Character's position variables
	private int xPos, yPos;
	//
	//
	// Chracter's delta xPos value
	int velocity;
	private static final int RESCALE = 3;
	//
	//
	// Essential objects to the characters
	SpriteManager sprite;
	private KeyProcessor keyButtons;
	boolean keyInput[];
	//
	//
	// Animation sequences for the characters spritesheets
	//final int[] walkDown = { 0, 1, 2, 3, 4, 5 };
	//final int[] walkUp = { 24, 25, 26, 27, 28, 29 };
	final int[] walkLeft = { 4, 5, 6, 7};
	final int[] walkRight = { 0, 1, 2, 3};

	// Constructor: Sets the positions, velocity, spritesheet, and key buttons
	public TestCharacter(){
		sprite = new SpriteManager("LeftyLukeSpriteSheet.png", 16, 16);
		keyInput = new boolean[6];
		velocity = 3;
	}
	
	public TestCharacter(int x, int y, KeyProcessor keyButtons) {
		sprite = new SpriteManager("LeftyLukeSpriteSheet.png", 16, 16);
		xPos = x;
		yPos = y-(sprite.spriteHeight*RESCALE);
		velocity = 3;
		this.keyButtons = keyButtons;
		keyInput = new boolean[6];
	}

	// draw()
	// PRECONDITION: The SpriteManager must be bug-free
	// POSTCONDITION: draws the current frame onto the screen
	public void draw(Graphics g) {
		g.drawImage(sprite.currentFrame(), xPos, yPos, xPos+RESCALE*sprite.currentFrame().getWidth(), yPos+RESCALE*sprite.currentFrame().getHeight(), 
				0,0,16, 16,  null);
		
	}

	// update()
	// PRECONDITION: SpriteManager bug-free, key input works
	// POSTCONDITION: Updates movement based on directional booleans
	public void update() {
		// Update the spritesheet frame
		sprite.update();
		// Update movement based on directional booleans
		/*
		if (keyInput[KeyProcessor.UP]) {
			yPos -= velocity;
			sprite.animate(walkUp);
		}
		if (keyInput[KeyProcessor.DOWN]) {
			yPos += velocity;
			sprite.animate(walkDown);
		}
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
	
	public void setKeys(KeyProcessor keys){
		this.keyButtons = keys;
	}
	public void setPosition(int x, int y){
		this.xPos = x;
		this.yPos = y-(sprite.spriteHeight*RESCALE);
	}
	public void setPosition(Point pos){
		this.xPos = pos.x;
		this.yPos = pos.y-(sprite.spriteHeight*RESCALE);
	}
	public Point getPos(){
		return new Point(this.xPos,this.yPos);
	}
}