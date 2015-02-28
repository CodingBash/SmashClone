package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/* Menu Interface:
 * Specifies which methods a menu should have
 */
public interface Menu {

	// Initiate the menu
	public void init();

	// Update and information within the menu
	public void update();

	// Draw whatever is on the menu such as text, images, players, etc
	// This is where the design comes into play
	public void draw(Graphics g);

	// Select any options and transporting any data or other changes...
	public void select(int index);

	// Method to receive keyPressed inputs
	public void keyPressed(KeyEvent k);

	// Method to receive keyReleased inputs
	public void keyReleased(KeyEvent k);

	// TODO: Add mouse input methods if needed
}
