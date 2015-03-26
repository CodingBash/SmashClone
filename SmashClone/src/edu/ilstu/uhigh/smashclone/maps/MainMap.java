package edu.ilstu.uhigh.smashclone.maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import edu.ilstu.uhigh.smashclone.view.Panel;

/*
 * MainMap will include the image of the map as well as positions of platforms, positions of spawns, etc.
 */
public class MainMap extends AbstractMap {
	/*
	 * Constructor for the map
	 */
	public MainMap() {
		try {
			bg_image = ImageIO.read(getClass().getResource(
					"/edu/ilstu/uhigh/smashclone/resources/" + "MainMapBackground.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Initialize the platforms
		platforms = new ArrayList<Rectangle>();
		// Add the floor to the map
		platforms.add(FLOOR, new Rectangle(0, Panel.HEIGHT * Panel.SCALE - 20,
				Panel.WIDTH * Panel.SCALE + 20, 20)); // TODO: strange offset on
														// width(had to
		// add 20)
		// Initialize the list for spawns
		spawns = new ArrayList<Point>();
		// Add the spawns
		initSpawns();
		spawns.get(0);
	}

	/*
	 * initSpawns(); PRECONDITION: should probably have a platform
	 * POSTCONDITION: add the spawns in the map
	 */
	private void initSpawns() {
		spawns.add(0, new Point(100, platforms.get(FLOOR).y));
		spawns.add(1, new Point(500, platforms.get(FLOOR).y));
		// Only two points for spawns. If more than two characters per game
		// is implemented, must add more spawns otherwise NullPointerException

	}

	/*
	 * draw() PRECONDITION: Available platforms and background image
	 * POSTCONDITION: Iterates through the platforms and draws. Draws the
	 * background
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(bg_image, 0, 0, null, null);
		// Iterate through the platforms
		for (Rectangle p : platforms)
			// Send the graphics and platform to a method to draw individual
			// platform
			drawPlatform(g, p);
		

	}

	/*
	 * drawPlatform() PRECONDITION: POSTCONDITION: draws the platform on the
	 * screen
	 */
	public static void drawPlatform(Graphics g, Rectangle platform) {
		g.setColor(Color.WHITE);
		g.fillRect(platform.x, platform.y, platform.width, platform.height);
	}

	/*
	 * getFloor() PRECONDITION: Must have a floor platform POSTCONDITION:
	 * Returns the floor platform
	 */
	public Rectangle getFloor() {
		return this.platforms.get(FLOOR);
	}

	public Point getSpawn(int index) {
		return spawns.get(index);
	}

	public String toString() {
		String s = spawns.get(0).x + " " + spawns.get(0).y;
		return s;

	}
}
