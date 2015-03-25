package edu.ilstu.uhigh.smashclone.control;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import edu.ilstu.uhigh.smashclone.game.CharacterManager;
import edu.ilstu.uhigh.smashclone.game.Controllable;
import edu.ilstu.uhigh.smashclone.game.Map;
import edu.ilstu.uhigh.smashclone.game.MapManager;
import edu.ilstu.uhigh.smashclone.game.ScreenInterface;

public class GameState implements State, ScreenInterface {
	// instance variables
	boolean pause, quit;
	public int currentMap;
	public CharacterManager characters;
	public MapManager maps;
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
		maps = new MapManager();
		characters = new CharacterManager();
		characters.setCharacter(0, characters.allCharacters.get(0));
		characters.setCharacter(1, characters.allCharacters.get(1));
		spawnCharacters();
	}


	private void spawnCharacters() {
		for(int i = 0; i<characters.playingCharacters.size(); i++){
			characters.playingCharacters.get(i).setPosition(
					maps.allMaps.get(currentMap).spawns.get(i));
		}
		
	}

	@Override
	public void draw(Graphics g) {
		for(Map m: maps.allMaps){
			m.draw(g);
		}
		for(Controllable c: characters.playingCharacters){
			c.draw(g);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (!quit && !pause) {
			for(Controllable c : characters.playingCharacters){
				c.update();
			}
		}
		System.out.println(characters.playingCharacters.get(0).getPos());
		System.out.println(characters.playingCharacters.get(1).getPos());
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
		for(Controllable c: characters.playingCharacters){
			c.sendKeyInput(k, true);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		for(Controllable c: characters.playingCharacters){
			c.sendKeyInput(k, false);
		}
		
	}

	//So what is the quit variable used for?
	//Exiting the state or exiting the game completely?
	
}
