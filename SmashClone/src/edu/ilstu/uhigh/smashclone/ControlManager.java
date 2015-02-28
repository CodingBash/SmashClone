package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

//
public class ControlManager {

	// List contains all the states within the game
	private ArrayList<State> states;
	//
	//
	// Current state index that the control is operating on
	protected int currentState;
	//
	//
	// State indexes
	public static final int MENUSTATE = 0;
	public static final int GAMESTATE = 1;

	// Control constructor: Initializes list, states, and sets the current state
	public ControlManager() {
		states = new ArrayList<State>();
		states.add(MENUSTATE, new MenuState());
		states.add(GAMESTATE, new GameState());
		currentState = MENUSTATE;
	}

	// setState()
	// PRECONDITION: Provide the preferred index of the state to change to
	// POSTCONDITION: Sets the current state to the preferred state
	public void setState(int stateIndex) {
		// Set the currentState index to the preferred state index
		// Refer to the index instances above
		currentState = stateIndex;
	}

	// draw()
	// PRECONDITION: Provide a graphics and have a working draw method in the
	// states
	// POSTCONDITION: Pass the graphics to the current state's draw method,
	// which the real drawing will be handled down there. Method called from
	// panel
	public void draw(Graphics g) {
		states.get(currentState).draw(g);
	}

	// update()
	// PRECONDITION: Have a working update method in the state classes
	// POSTCONDITION: Call the current state's update method. This method is
	// called from the panel's main game loop
	public void update() {
		states.get(currentState).update();
	}

	// keyPressed()
	// PRECONDITION: Provide a KeyEvent (from the InputAdapter class)
	// POSTCONDITION: Send the key input to the current state
	public void keyPressed(KeyEvent k) {
		states.get(currentState).keyPressed(k);
	}
	
	// keyReleased()
	// PRECONDITION: Provide a KeyEvent (from the InputAdapter class)
	// POSTCONDITION: Send the key input to the current state
	public void keyReleased(KeyEvent k) {
		states.get(currentState).keyReleased(k);
	}

	//TODO: Handle passing mouse inputs (if needed in the future)
}
