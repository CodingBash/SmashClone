package edu.ilstu.uhigh.smashclone.control;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import edu.ilstu.uhigh.smashclone.characters.AbstractCharacter;
import edu.ilstu.uhigh.smashclone.game.CharacterManager;
import edu.ilstu.uhigh.smashclone.game.Controllable;
import edu.ilstu.uhigh.smashclone.game.MapManager;
import edu.ilstu.uhigh.smashclone.game.ScreenInterface;
import edu.ilstu.uhigh.smashclone.maps.AbstractMap;

public class GameState implements State, ScreenInterface {
	// instance variables
	boolean pause, quit;
	public CharacterManager characters;
	public MapManager maps;

	// constructor
	public GameState() {
		super();
		init();
	}

	@Override
	public void init() {
		pause = false;
		quit = false;
		maps = new MapManager();
		maps.currentMap = 0;
		characters = new CharacterManager();
		characters.setCharacter(0,
				characters.allCharacters.get(CharacterManager.LEFTYLUKE));
		characters.setCharacter(1,
				characters.allCharacters.get(CharacterManager.GANGSTER));
		spawnCharacters();
	}

	private void spawnCharacters() {
		for (int i = 0; i < characters.playingCharacters.size(); i++) {
			characters.playingCharacters.get(i).setPosition(
					maps.allMaps.get(maps.currentMap).getSpawn(i));
		}
	}

	@Override
	public void draw(Graphics g) {
		for (AbstractMap m : maps.allMaps) {
			m.draw(g);
		}
		for (Controllable c : characters.playingCharacters) {
			c.draw(g);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (!quit && !pause) {
			for (AbstractCharacter c : characters.playingCharacters) {
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
		for (Controllable c : characters.playingCharacters) {
			c.sendKeyInput(k, true);
		}

	}

	@Override
	public void keyReleased(KeyEvent k) {
		for (Controllable c : characters.playingCharacters) {
			c.sendKeyInput(k, false);
		}

	}

}
