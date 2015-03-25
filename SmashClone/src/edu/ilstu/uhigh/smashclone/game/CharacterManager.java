package edu.ilstu.uhigh.smashclone.game;

import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.characters.TestCharacter;

public class CharacterManager {
	// List that contains all available characters
	public ArrayList<TestCharacter> allCharacters;
	// List that contains selected characters that should play
	// Not limited by a max of two in case of adding extra players
	public ArrayList<TestCharacter> playingCharacters;
	// Array of inputs for each separate character
	public ArrayList<KeyProcessor> allInputs; // Make sure the index corresponds
												// to the player index
	// Variable that declares the max players on the field
	public static final int MAXPLAYERS = 2;

	public static final int LEFTYLUKE = 0;
	
	public CharacterManager() {
		allInputs = new ArrayList<KeyProcessor>();
		// Create Players
		allCharacters = new ArrayList<TestCharacter>();
		playingCharacters = new ArrayList<TestCharacter>();
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
		allCharacters.add(LEFTYLUKE, new TestCharacter());
		allCharacters.add(LEFTYLUKE+1, new TestCharacter());

	}

	public void setCharacter(int index, TestCharacter character) {
		playingCharacters.add(index, character);
		addKeyInputs();
	}
}
