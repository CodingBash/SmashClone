package edu.ilstu.uhigh.smashclone;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PlayerOneKeys extends KeyProcessor {
	private static int alternateKeys[];
	
	public PlayerOneKeys(){
		super(createAlternates());
	}
	//Use this constructor if your character input layout is different
	public PlayerOneKeys(int[] keys){
		super(keys);
	}
	private static int[] createAlternates() {
		alternateKeys = new int[6];
		alternateKeys[UP] = KeyEvent.VK_W;
		alternateKeys[LEFT] = KeyEvent.VK_A;
		alternateKeys[DOWN] = KeyEvent.VK_S;
		alternateKeys[RIGHT] = KeyEvent.VK_D;
		alternateKeys[BUTTONA] = 0;
		alternateKeys[BUTTONB] = 1;
		return alternateKeys;
		
	}
}
