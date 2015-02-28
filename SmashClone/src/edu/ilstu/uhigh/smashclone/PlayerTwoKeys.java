package edu.ilstu.uhigh.smashclone;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/*
 * PlayerTwoKeys is a subclass of KeyProcessor which inherits its constructors
 * and instance methods. However, this adds a default list of keys[] that
 * player 1 uses. Adds the option to insert another list of keys
 */
public class PlayerTwoKeys extends KeyProcessor {
	//
	//
	// Provides a variable to contain the alternate keys to send to
	// the super constructor (constructor in the KeyProcessor)
	private static int alternateKeys[];

	// Constructor: Sends the default keys to the super constructor
	public PlayerTwoKeys() {
		super(createAlternates());
	}

	// Constructor: Provides an option to recieve a list of keys
	// to send to the super constructor
	public PlayerTwoKeys(int[] keys) {
		super(keys);
	}

	// createAlternatives
	// PRECONDITION: must have keys[] instance.
	// POSTCONDITION: Provides the default key list for this class
	private static int[] createAlternates() {
		// Initializes the key list
		alternateKeys = new int[6];
		// Adds the KeyEvents to their respected index
		alternateKeys[UP] = KeyEvent.VK_O;
		alternateKeys[LEFT] = KeyEvent.VK_K;
		alternateKeys[DOWN] = KeyEvent.VK_L;
		alternateKeys[RIGHT] = KeyEvent.VK_SEMICOLON;
		alternateKeys[BUTTONA] = 0;
		alternateKeys[BUTTONB] = 1;
		// Return (to the constructor, which is send to the super constructor)
		return alternateKeys;
	}
}
