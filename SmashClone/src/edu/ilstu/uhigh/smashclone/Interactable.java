package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;

/* Interactable defines an object that does interact with the 
 * characters but is not controlled
 */
public interface Interactable {
	/*
	 * draw is called once per frame paint is handed the whole graphics screen
	 * to draw on - don't mess it up!
	 */
	public void draw(Graphics g);

	/*
	 * update is called once per frame it should update character state and exit
	 * as quickly as possible.
	 */
	public void update();

}