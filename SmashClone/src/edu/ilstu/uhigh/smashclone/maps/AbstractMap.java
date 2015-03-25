package edu.ilstu.uhigh.smashclone.maps;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.game.NonInteractable;

public abstract class AbstractMap implements NonInteractable {
	
	private ArrayList<Rectangle> platforms;
	private BufferedImage bg_image;
	private BufferedImage icon;
	
}
