package edu.ilstu.uhigh.smashclone.maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import edu.ilstu.uhigh.smashclone.game.NonInteractable;
import edu.ilstu.uhigh.smashclone.view.Panel;

/*
 * AbstractMap to define what a map should be. Implement the NonInteractable interface
 */
public abstract class AbstractMap implements NonInteractable {
	//
	//
	// List of platforms in the maps
	public ArrayList<Rectangle> platforms;
	//
	//
	//
	static final int FLOOR = 0;
	//
	//
	// Background image
	static BufferedImage bg_image;
	//
	//
	// Icon (Used for HUD and menu)
	BufferedImage icon;
	//
	//
	// List of spawns
	ArrayList<Point> spawns;

	//
	//
	//
	public AbstractMap(String file) {
		//
		//
		//
		// Add the image
		try {
			bg_image = ImageIO.read(getClass().getResource(
					"/edu/ilstu/uhigh/smashclone/resources/" + file));
		} catch (IOException e) {
			System.err.println("IOException @ " + getClass().getName());
			e.printStackTrace();
		}
		//
		//
		//
		// Initialize the platforms
		platforms = new ArrayList<Rectangle>();
		// Add the platforms
		addPlatforms();
		//
		//
		//
		// Initialize the list for spawns
		spawns = new ArrayList<Point>();
		// Add the spawns
		initSpawns();
	}

	abstract protected void addPlatforms();

	//
	//
	//
	abstract protected void initSpawns();

	/*
	 * draw() PRECONDITION: Available platforms and background image
	 * POSTCONDITION: Iterates through the platforms and draws. Draws the
	 * background
	 */
	@Override
	public void draw(Graphics g) {
		// Draw the background image
		g.drawImage(bg_image, 0, 0, Panel.WIDTH * Panel.SCALE, Panel.HEIGHT
				* Panel.SCALE, null);
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

	public int getTop(int index) {
		return this.platforms.get(index).y - this.platforms.get(index).height;
	}

	public int getCenter(int index){
		return this.platforms.get(index).x+ this.platforms.get(index).width/2;
	}
	public Point getSpawn(int index) {
		return spawns.get(index);
	}

	public String toString() {
		String s = spawns.get(0).x + " " + spawns.get(0).y;
		return s;

	}
}
