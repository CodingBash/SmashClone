package edu.ilstu.uhigh.smashclone.game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/*
 * KeyProcessor is a class the processes any input received
 * from the control. A controllable should receive an object
 * that extends this
 */
public class KeyProcessor {
	//
	//
	// array of integers (specifically KeyCodes)
	public int keys[];
	//
	//
	// RULES FOR KEYINPUT TO STAY CONSISTENT WITH CLASS
	// Also indexes used in KeyProcessor classes AND
	// the character objects! Don't screw this up otherwise
	// your input will be messed up!
	public static int UP = 0;
	public static int DOWN = 1;
	public static int LEFT = 2;
	public static int RIGHT = 3;
	public static int BUTTONA = 4;
	public static int BUTTONB = 5;

	// Constructor: Initializes empty key list (this constructor
	// should be rarely called)
	public KeyProcessor() {
		keys = new int[6];
		System.err.println("Add Keys");
	}

	// Constructor: Initializes instance with provided key
	// list. (Can also be super() called from any object
	// that extends this class)
	public KeyProcessor(int[] keys) {
		this.keys = keys;
	}

	// isEmpty()
	// PRECONDITION: Have a key list
	// POSTCONDITION: Returns boolean on whether list is empty
	public boolean isEmpty() {
		return (keys.length == 0);
	}

	// getIndex()
	// PRECONDITION: Have a key list with a non-null index
	// POSTCONDITION: Returns the KeyEvent of that index
	// OTHER: You can call the instance directly since
	// it is publicly visible.
	public int getIndex(int button) {
		// TODO: try-catch null pointer exception
		// in case the index is empty
		return keys[button];
	}
}
