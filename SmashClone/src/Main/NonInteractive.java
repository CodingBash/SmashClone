package Main;
import java.awt.Graphics;

/* Controllable defines an interface for character objects
 * to be controlled by the game engine
 */
public interface NonInteractive {
	/* paint is called once per frame
	 * paint is handed the whole graphics screen to draw on - don't mess it up!
	 */
	public void paint(Graphics g);
	
	
}