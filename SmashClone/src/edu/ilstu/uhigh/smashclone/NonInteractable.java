package edu.ilstu.uhigh.smashclone;
import java.awt.Graphics;

/* NonInteractable defines an object that does not interact with the 
 * characters nor is controlled
 */
public interface NonInteractable {
	/* draw is called once per frame
	 * draw is handed the whole graphics screen to draw on - don't mess it up!
	 */
	public void draw(Graphics g);
	
	
}