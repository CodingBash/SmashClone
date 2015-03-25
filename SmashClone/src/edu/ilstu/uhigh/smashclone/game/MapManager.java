package edu.ilstu.uhigh.smashclone.game;

import java.util.ArrayList;

public class MapManager {

	public ArrayList<Map> allMaps;
	
	public static final int MAINMAP = 0;
	public  MapManager(){
		allMaps = new ArrayList<Map>();
		addAllMaps();
	}

	private void addAllMaps() {
		allMaps.add(MAINMAP, new Map());
	}
	
	private Map returnMap(int index){
		return allMaps.get(index);
	}
}
