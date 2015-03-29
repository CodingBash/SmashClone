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

	// Positional variables
	private int xPos, yPos;
	// Velocity variable
	private int dx;
	// Sprite sheet
	private int dy;
	private SpriteManager sprite;
	// Key processor
	private KeyProcessor keyButtons;
	// Action booleans
	private boolean keyInput[];
	//
	private boolean canJump;
	private int jumpHeight;
	private int jumpCounter;
	int count;
	// Icon (used for menu and HUD)
	public BufferedImage icon;

	ArrayList<int[]> animations = null;
	// Animation sequences
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
		// Update the spritesheet frame
		sprite.update();
		// Update movement based on directional booleans
		/*
		 * if (keyInput[KeyProcessor.UP]) { yPos -= velocity;
		 * sprite.animate(walkUp); } if (keyInput[KeyProcessor.DOWN]) { yPos +=
		 * velocity; sprite.animate(walkDown); }
		 */
		if (keyInput[KeyProcessor.LEFT]) {
			xPos -= dx;
			sprite.animate(animations.get(WALKLEFT));
		}
		if (keyInput[KeyProcessor.RIGHT]) {
			xPos += dx;
			sprite.animate(animations.get(WALKRIGHT));
		}
		if(keyInput[KeyProcessor.UP]) {
			yPos-= dy;
			jumpCounter += dy;
		}
		if(checkPanelCollision()){
			yPos += dy;
			jumpCounter = (jumpCounter-dy< 0) ? 0 : jumpCounter - dy;
		}
		checkJump();
	}

	private void checkJump() {

		if(jumpCounter == 0)
			canJump = true;
		if(jumpCounter > jumpHeight){
			canJump = false;
			keyInput[KeyProcessor.UP] = false;
		}
		
		
	}

	//
	//
	//
	public boolean checkPanelCollision(){
		if(keyInput[KeyProcessor.UP]) 
			return false;
		ArrayList<Rectangle> plats = ((GameState)Panel.control.states.get(ControlManager.GAMESTATE)).
				maps.allMaps.get(MapManager.currentMap).platforms;
		boolean goingDown = true;
		for(Rectangle a: plats){
			if(getFoot().x < a.x + a.width && getFoot().x > a.x){
				if(getFoot().y > a.y-a.height && getFoot().y <a.y-a.height+5){
					goingDown = false;
				}
			}
		}
		return goingDown;
	
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
