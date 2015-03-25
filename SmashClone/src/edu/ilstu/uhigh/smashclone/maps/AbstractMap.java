package edu.ilstu.uhigh.smashclone.maps;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.game.NonInteractable;
/*
 * AbstractMap to define what a map should be. Implement the NonInteractable interface
 */
public abstract class AbstractMap implements NonInteractable {
	//
	//
	//List of platforms in the maps
	private ArrayList<Rectangle> platforms;
	//
	//
	//
	public static final int FLOOR = 0;
	//
	//
	//Background image
	public static BufferedImage bg_image;
	//
	//
	//Icon (Used for HUD and menu)
	private BufferedImage icon;
	//
	//
	//List of spawns
	public ArrayList<Point> spawns;
	//
	//
	//
	abstract public Point getSpawn(int index);
}
