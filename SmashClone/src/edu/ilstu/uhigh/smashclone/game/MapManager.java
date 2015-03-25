package edu.ilstu.uhigh.smashclone.game;

import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.maps.MainMap;

public class MapManager {

	public ArrayList<MainMap> allMaps;

	public static final int MAINMAP = 0;

	public MapManager() {
		allMaps = new ArrayList<MainMap>();
		addAllMaps();
	}

	private void addAllMaps() {
		allMaps.add(MAINMAP, new MainMap());
	}

	private MainMap returnMap(int index) {
		return allMaps.get(index);
	}
}
