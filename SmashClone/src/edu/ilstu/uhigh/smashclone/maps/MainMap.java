package edu.ilstu.uhigh.smashclone.maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.view.Panel;

/*
 * MainMap will include the image of the map as well as positions of platforms, positions of spawns, etc.
 */
public class MainMap extends AbstractMap {

	// Platform variables will begin with a p_
	// A map must have a floor platform
	// TODO: Array of Platforms. First platform in the array should be the main
	// floor.
	private ArrayList<Rectangle> platforms;
	public static final int FLOOR = 0;
	public ArrayList<Point> spawns;

	public MainMap() {
		platforms = new ArrayList<Rectangle>();
		platforms.add(0, new Rectangle(0, Panel.HEIGHT * Panel.SCALE - 20,
				Panel.WIDTH * Panel.SCALE + 20, 20)); // TODO: strange offset on
														// width(had to
														// add 20)
		spawns = new ArrayList<Point>();
		initSpawns();
	}

	private void initSpawns() {
		spawns.add(0, new Point(100, platforms.get(FLOOR).y));
		spawns.add(1, new Point(500, platforms.get(FLOOR).y));
		// Only two points for spawns. If more than two characters per game
		// is implemented, must add more spawns otherwise NullPointerException

	}

	public MainMap(Rectangle p_floor) {

	}

	@Override
	public void draw(Graphics g) {
		for (Rectangle p : platforms)
			drawPlatform(g, p);

	}

	public static void drawPlatform(Graphics g, Rectangle platform) {
		g.setColor(Color.WHITE);
		g.fillRect(platform.x, platform.y, platform.width, platform.height);
	}

	public Rectangle getFloor() {
		return this.platforms.get(FLOOR);
	}
}
