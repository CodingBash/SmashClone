package edu.ilstu.uhigh.smashclone.game;

import java.util.ArrayList;

import edu.ilstu.uhigh.smashclone.characters.AbstractCharacter;
import edu.ilstu.uhigh.smashclone.characters.GangsterCharacter;
import edu.ilstu.uhigh.smashclone.characters.LeftyLukeCharacter;
import edu.ilstu.uhigh.smashclone.processors.KeyProcessor;
import edu.ilstu.uhigh.smashclone.processors.PlayerOneKeys;
import edu.ilstu.uhigh.smashclone.processors.PlayerTwoKeys;
/*
 * CharacterManager manages all the available characters as well as the characters
 * that are currently on the field. Also holds the list for inputs as well
 * as assigning the inputs to characters
 */
public class CharacterManager {
	//
	//
	// List that contains all available characters
	public ArrayList<AbstractCharacter> allCharacters;
	//
	//
	// List that contains selected characters that should play
	// Not limited by a max of two in case of adding extra players
	public ArrayList<AbstractCharacter> playingCharacters;
	//
	//
	// Array of inputs for each separate character
	public ArrayList<KeyProcessor> allInputs; // Make sure the index corresponds
												// to the player index
	// Variable that declares the max players on the field
	public static final int MAXPLAYERS = 2;
	//
	//
	//Index of all the characters in the list. Used for reference in other classes
	//for easy access
	public static final int LEFTYLUKE = 0;
	public static final int GANGSTER = 1;

	/*
	 * CharacterManager() constructor
	 * Initializes all the lists and inputs
	 */
	public CharacterManager() {
		//Initialize list of inputs
		allInputs = new ArrayList<KeyProcessor>();
		//Initialize list of all characters
		allCharacters = new ArrayList<AbstractCharacter>();
		//Initialize list of playing characters
		playingCharacters = new ArrayList<AbstractCharacter>();
		//Add all characters to allCharacters list
		addAllCharacters();
	}

	/*
	 * addkeyInputs()
	 * PRECONDITION: must have available players. Must have inputs for every separate player
	 * POSTCONDITION: assign available inputs to separate characters
	 */
	private void addKeyInputs() {
		//Check if playingCharacters is not empty
		if (playingCharacters.size() > 0)
			//Iterate through the playing characters
			for (int i = 0; i < playingCharacters.size(); i++) {
				//Assign inputs based on switch case.
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

	/*
	 * addAllCharacters()
	 * PRECONDITION: available characters to add to list
	 * POSTCONDITION: all listed characters are added to the list in their own index
	 */
	private void addAllCharacters() {
		//Add characters with the paramaters (INDEX, ABSTRACTCHARACTER OBJECT)
		allCharacters.add(LEFTYLUKE, new LeftyLukeCharacter());
		allCharacters.add(GANGSTER, new GangsterCharacter());
		

	}

	/*
	 * setCharacter();
	 * PRECONDITION: must have available inputs for the added character
	 * POSTCONDITION: adds character to the field. Assigns input IF available
	 * otherwise will throw an error upon user input
	 * 
	 */
	public void setCharacter(int index, AbstractCharacter character) {
		//Add character to the playingCharacters list
		playingCharacters.add(index, character);
		//Adjust the inputs
		addKeyInputs();
	}
}
