package edu.ilstu.uhigh.smashclone.game;

import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.maps.AbstractMap;
import edu.ilstu.uhigh.smashclone.maps.MainMap;

/*
 * MapManager manages all the maps and the current map
 */
public class MapManager {

	//
	//
	//List contains all maps
	public ArrayList<AbstractMap> allMaps;

	public static int currentMap;
	
	public static final int MAINMAP = 0;

	public MapManager() {
		allMaps = new ArrayList<AbstractMap>();
		this.currentMap = 0;
		addAllMaps();
	}

	private void addAllMaps() {
		allMaps.add(MAINMAP, new MainMap());
	}
}
