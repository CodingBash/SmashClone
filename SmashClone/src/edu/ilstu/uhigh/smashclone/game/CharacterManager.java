package edu.ilstu.uhigh.smashclone.game;

import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.characters.AbstractCharacter;
import edu.ilstu.uhigh.smashclone.characters.GangsterCharacter;
import edu.ilstu.uhigh.smashclone.characters.LeftyLukeCharacter;
import edu.ilstu.uhigh.smashclone.processors.KeyProcessor;
import edu.ilstu.uhigh.smashclone.processors.PlayerOneKeys;
import edu.ilstu.uhigh.smashclone.processors.PlayerTwoKeys;

public class CharacterManager {
	// List that contains all available characters
	public ArrayList<AbstractCharacter> allCharacters;
	// List that contains selected characters that should play
	// Not limited by a max of two in case of adding extra players
	public ArrayList<AbstractCharacter> playingCharacters;
	// Array of inputs for each separate character
	public ArrayList<KeyProcessor> allInputs; // Make sure the index corresponds
												// to the player index
	// Variable that declares the max players on the field
	public static final int MAXPLAYERS = 2;

	public static final int LEFTYLUKE = 0;
	public static final int GANGSTER = 1;

	public CharacterManager() {
		allInputs = new ArrayList<KeyProcessor>();
		// Create Players
		allCharacters = new ArrayList<AbstractCharacter>();
		playingCharacters = new ArrayList<AbstractCharacter>();
		addAllCharacters();
	}

	private void addKeyInputs() {
		if (playingCharacters.size() > 0)
			for (int i = 0; i < playingCharacters.size(); i++) {
				switch (i) {
				case 0:
					playingCharacters.get(i).setKeys(new PlayerOneKeys());
					break;
				case 1:
					playingCharacters.get(i).setKeys(new PlayerTwoKeys());
					break;
				default:
					System.err
							.println("Too many characters on field. Not enough input fields");
					break;
				}
			}
	}

	private void addAllCharacters() {
		allCharacters.add(LEFTYLUKE, new LeftyLukeCharacter());
		allCharacters.add(GANGSTER, new GangsterCharacter());
		

	}

	public void setCharacter(int index, AbstractCharacter character) {
		playingCharacters.add(index, character);
		addKeyInputs();
	}
}
