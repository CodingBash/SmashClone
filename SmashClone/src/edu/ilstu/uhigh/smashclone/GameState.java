package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameState implements State, ScreenInterface {
	// instance variables
	boolean pause, quit;
	KeyProcessor allInputs[]; //Make sure the index corresponds to the player index
	public static final int MAXPLAYERS = 2;
	Controllable players[];
	
	public static final int MAXMAPS = 1;
	public int currentMap;
	Map maps[]; //Changed from NonInterable to specific Map to operate on specific maps and map methods
	// constructor
	public GameState() {
		super();
		init();
	}

	@Override
	public void init() {
		//Create ScreenInterface
		pause = false;
		quit = false;
		currentMap = 0;
		//Create maps
		//TODO: When loading, only need to load one map, not all (for efficiency)
		maps = new Map[MAXMAPS];
		maps[0] = new Map();
		//Create KeyInputs
		allInputs = new KeyProcessor[MAXPLAYERS];
		
		allInputs[0] = new PlayerOneKeys();
		allInputs[1] = new PlayerTwoKeys();
		
		//Create Players
		players = new Controllable[MAXPLAYERS];
		
		players[0] = new TestCharacter(100, maps[currentMap].getFloor().y, allInputs[0]);
		players[1] = new TestCharacter(500, maps[currentMap].getFloor().y, allInputs[1]);
	}


	@Override
	public void draw(Graphics g) {
		for(Map m: maps){
			m.draw(g);
		}
		for(Controllable c: players){
			c.draw(g);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (!quit && !pause) {
			for(Controllable c : players){
				c.update();
			}
		}
	}

	public void pause() {
		pause = !pause;
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent k) {
		for(Controllable c: players){
			c.sendKeyInput(k, true);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		for(Controllable c: players){
			c.sendKeyInput(k, false);
		}
		
	}

	//So what is the quit variable used for?
	//Exiting the state or exiting the game completely?
	
}
