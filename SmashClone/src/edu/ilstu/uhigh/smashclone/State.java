package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/* State is an interface that defines an object that controls a certain
 * 'part' of the game Eg. GameState and MenuState. 
 */
public interface State {

	// init()
	// Method that creates the initial objects and other tasks
	public void init();

	// draw()
	// Method that draws the state's objects to the panel
	public void draw(Graphics g);

	// update()
	// Method that updates all of the state's objects
	public void update();

	// keyPressed()
	// Method that receives the input from the control manager
	// Then is sent to the state's objects
	public void keyPressed(KeyEvent k);

	// keyPressed()
	// Method that receives the input from the control manager
	// Then is sent to the state's objects
	public void keyReleased(KeyEvent k);

	//TODO: Implement mouse input methods if needed
}
