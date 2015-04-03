package edu.ilstu.uhigh.smashclone.processors;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PlayerOneKeys extends KeyProcessor {
	
	//
	//
	// Provides a variable to contain the alternate keys to send to
	// the super constructor (constructor in the KeyProcessor)
	private static int alternateKeys[];
	
	// Constructor: Sends the default keys to the super constructor
	public PlayerOneKeys(){
		super(createAlternates());
	}
	
	// createAlternatives
	// PRECONDITION: must have keys[] instance.
	// POSTCONDITION: Provides the default key list for this class
	public PlayerOneKeys(int[] keys){
		super(keys);
	}
	
	// createAlternatives
	// PRECONDITION: must have keys[] instance.
	// POSTCONDITION: Provides the default key list for this class
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
