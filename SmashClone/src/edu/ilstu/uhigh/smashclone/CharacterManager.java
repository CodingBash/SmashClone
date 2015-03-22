package edu.ilstu.uhigh.smashclone;

import java.util.ArrayList;

public class CharacterManager {

	private ArrayList<Controllable> characters1;
	private ArrayList<Controllable> characters2;
	
	public Controllable[] currentplayers = new Controllable[2];
	KeyProcessor allInputs[]; //Make sure the index corresponds to the player index
	public static final int MAXPLAYERS = 2;
	
	public CharacterManager() {
		//Create KeyInputs
		allInputs = new KeyProcessor[MAXPLAYERS];
				
		allInputs[0] = new PlayerOneKeys();
		allInputs[1] = new PlayerTwoKeys();
		
		characters1 = new ArrayList<Controllable>();
		characters2 = new ArrayList<Controllable>();
		// Add created characters twice for each set of keys
		characters1.add(new TestCharacter(500, 100, new PlayerOneKeys()));
		characters2.add(new TestCharacter(500, 100, new PlayerTwoKeys()));
		characters1.add(new TestCharacter2(500, 100, new PlayerOneKeys()));
		characters2.add(new TestCharacter2(500, 100, new PlayerTwoKeys()));
				//Set Default Characters to test characters
		currentplayers[0] = characters1.get(0);
		currentplayers[0] = characters2.get(0);

	}
	
	public ArrayList<Controllable> getCharacters1()
	{
		return characters1;
	}
	
	public ArrayList<Controllable> getCharacters2()
	{
		return characters2;
	}

}
