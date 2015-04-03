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

	static final String file = "MainMapBackground.png";

	public MainMap() {
		super(file);

	}

	/*
	 * initSpawns(); PRECONDITION: should probably have a platform
	 * POSTCONDITION: add the spawns in the map
	 */
	@Override
	protected void initSpawns() {
		spawns.add(0, new Point(Panel.WIDTH * Panel.SCALE / 4, getTop(FLOOR)));
		spawns.add(1, new Point(getCenter(1), getTop(1)));
		spawns.add(2, new Point(Panel.WIDTH * Panel.SCALE * 3 / 4,
				getTop(FLOOR)));
		// Only two points for spawns. If more than two characters per game
		// is implemented, must add more spawns otherwise NullPointerException

	}

	protected void addPlatforms() {
		platforms.add(FLOOR, new Rectangle(0, Panel.HEIGHT * Panel.SCALE,
				Panel.WIDTH * Panel.SCALE, Panel.HEIGHT / 10)); 
		platforms.add(1, new Rectangle(Panel.WIDTH*Panel.SCALE/2, Panel.HEIGHT * Panel.SCALE/2,
				Panel.WIDTH * Panel.SCALE/2, Panel.HEIGHT / 10)); 
	}

}
