package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/* MenuState:
 * State that handles all the menus. Also controls
 * and data that must be sent to other states
 */
public class MenuState implements State {
	//
	//
	// List of all menu screens
	private ArrayList<Menu> menus;
	//
	//
	// Index of the current menu
	protected int currentMenu = 0;
	//
	//
	// Index of each menu in the list
	// USE THESE CONSTANTS TO YOUR ADVANTAGE
	public static final int GENERALMENU = 0;
	public static final int OPTIONMENU = 1;
	public static final int PLAYERMENU = 2;
	public static final int MAPMENU = 3;
	public static final int FINALMENU = 4;

	// Constructor: Calls the init() method which handles all the construction
	public MenuState() {
		init();
	}

	// init(): Initializes the menu list, adds menus, set current menu
	public void init() {
		menus = new ArrayList<Menu>();
		menus.add(GENERALMENU, new GeneralMenu());
		currentMenu = GENERALMENU;
	}

	// setMenu()
	// PRECONDITION: currentMenu in menu list must be non-null
	// POSTCONDITION: The preffered menu is initialized
	public void setMenu(int menuIndex) {
		// Change the currentMenu to the preferred menu index (menuIndex)
		currentMenu = menuIndex;
		// Initialize the new menu
		menus.get(currentMenu).init();
	}

	// draw()
	// PRECONDITION: Must have a graphics object and a non-null menu in the
	// index
	// POSTCONDITION: Sends the graphics to the current menus draw method
	// All drawing is done there, this method just sends it from above
	public void draw(Graphics g) {
		// Sends the graphics to the current menu's draw method
		menus.get(currentMenu).draw(g);
	}

	// update()
	// PRECONDITION: The current menu must have a working update method. The
	// index must not be null in the menu list
	// POSTCONDITION: Calls the current menu's update method. This method
	// is called from the control manager
	public void update() {
		// Calls the current menu's update method
		menus.get(currentMenu).update();
	}

	// keyPressed()
	// PRECONDITION: Provide a KeyEvent, currentMenu must have a working
	// keyPressed method. The index must not be null in the menu list
	// POSTCONDITION: Calls the current menu's keyPressed method. This method
	// is called from the control manager
	public void keyPressed(KeyEvent k) {
		// Sends the KeyEvent to the currentMenus keyPressed method
		menus.get(currentMenu).keyPressed(k);
	}

	// keyReleased()
	// PRECONDITION: Provide a KeyEvent, currentMenu must have a working
	// keyPressed method. The index must not be null in the menu list
	// POSTCONDITION: Calls the current menu's keyReleased method. This method
	// is called from the control manager
	public void keyReleased(KeyEvent k) {
		// Sends the KeyEvent to the currentMenus keyReleased method
		menus.get(currentMenu).keyReleased(k);
	}

}
