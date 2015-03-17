package edu.ilstu.uhigh.smashclone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * Map will include the image of the map as well as positions of platforms, positions of spawns, etc.
 */
public class Map implements NonInteractable {

	// Platform variables will begin with a p_
	// A map must have a floor platform
	private Rectangle p_floor;

	public Map() {
		p_floor = new Rectangle(0, Panel.HEIGHT * Panel.SCALE - 20, Panel.WIDTH
				* Panel.SCALE + 20, 20); // TODO: strange offset on width(had to
											// add 20)
	}

	public Map(Rectangle p_floor) {

	}

	@Override
	public void draw(Graphics g) {
		drawPlatform(g, p_floor);

	}

	public static void drawPlatform(Graphics g, Rectangle platform) {
		g.setColor(Color.WHITE);
		g.fillRect(platform.x, platform.y, platform.width, platform.height);
	}

	public Rectangle getFloor(){
		return this.p_floor;
	}
}
