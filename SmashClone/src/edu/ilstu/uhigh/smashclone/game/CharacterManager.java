package edu.ilstu.uhigh.smashclone.game;

import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.characters.TestCharacter;

public class CharacterManager {
	// List that contains all available characters
	public ArrayList<Controllable> allCharacters;
	// List that contains selected characters that should play
	// Not limited by a max of two in case of adding extra players
	public ArrayList<Controllable> playingCharacters;
	// Array of inputs for each separate character
	public ArrayList<KeyProcessor> allInputs; // Make sure the index corresponds
												// to the player index
	// Variable that declares the max players on the field
	public static final int MAXPLAYERS = 2;

	public CharacterManager() {
		allInputs = new ArrayList<KeyProcessor>();
		// Create Players
		allCharacters = new ArrayList<Controllable>();
		playingCharacters = new ArrayList<Controllable>();
		addAllCharacters();
		addKeyInputs();
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
		allCharacters.add(new TestCharacter());

	}

	public void setCharacter(int index, Controllable character) {
		playingCharacters.add(index, character);
		addKeyInputs();
	}
}
