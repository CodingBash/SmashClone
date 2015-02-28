package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/* Controllable defines an interface for character objects
 * to be controlled by the game engine
 */
public interface Controllable {

	//
	//
	/*
	 * draw is called once per frame draw is handed the whole graphics screen to
	 * draw on - don't mess it up!
	 */
	public void draw(Graphics g);

	//
	//
	/*
	 * update is called once per frame it should update character state and exit
	 * as quickly as possible.
	 */
	public void update();

	//
	//
	/*
	 * sendKeyInput is called to provide an input value to the Controllable
	 * object since the "controllable" must be "controlled" :)
	 */
	public void sendKeyInput(KeyEvent k, boolean pressed);

}