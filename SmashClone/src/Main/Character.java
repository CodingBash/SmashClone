package Main;

import java.awt.Graphics;

public class Character implements Controllable {
	//INSTANCE VARIABLES
	int xPos, yPos;
	int speed;
	SpriteManager sprite;
	
	//More actions may be added
	//Jump may be added as default
	//Up and down may be taken off since 2D game
	boolean up, down, left, right, buttonA, buttonB; 
	
	//Defined in specific characters based on spritesheet
	final int[] walkDown = null;
	final int[] walkUp = null;
	final int[] walkLeft = null;
	final int[] walkRight = null;
	
	public Character(int x, int y, SpriteManager sprite){
		this.xPos = x;
		this.yPos = y;
		speed = 5;
		this.sprite = sprite;
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(sprite.currentFrame(), xPos,yPos,null);
	}

	@Override
	public void update() {
		sprite.update();
		
		//Updates and animation
		if(up) {
			yPos -= speed;
			sprite.animate(walkUp);
		}
		if(down) {
			yPos += speed;
			sprite.animate(walkDown);
		}
		if(left){
			xPos -= speed;
			sprite.animate(walkLeft);
		}
		if(right){
			xPos += speed; 
			sprite.animate(walkRight);
		}
	}

	@Override
	public void inputChange(boolean[] keys) {
		up = keys[0];
		down = keys[1];
		left = keys[2];
		right = keys[3];
		buttonA = keys[4];
		buttonB = keys[5];
		
	}

}
