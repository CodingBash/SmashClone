package edu.ilstu.uhigh.smashclone;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/*
 * The InputAdapter receives all the input from the operating system.
 * Also handles interpreting controller events to KeyEvents <--TODO
 */
public class InputAdapter implements MouseListener, KeyListener {
	//
	//
	// Control to send the inputs into
	ControlManager ctrl;

	// Constructor: sets instance controlmanger from the provided control
	// manager (which is the main one sent from panel)
	public InputAdapter(ControlManager ctrl) {
		this.ctrl = ctrl;
	}

	// keypPressed()
	// PRECONDITION: Receives input from the Listener interfaces
	// POSTCONDITION: Sends the keyInput to the controller
	public void keyPressed(KeyEvent e) {
		// Sends the keyPressed event to the control in order
		// to flow through the framework into the models (characters)
		ctrl.keyPressed(e);
	}

	// keypReleased()
	// PRECONDITION: Receives input from the Listener interfaces
	// POSTCONDITION: Sends the keyInput to the controller
	public void keyReleased(KeyEvent e) {
		// Sends the keyReleased event to the control in order
		// to flow through the framework into the models (characters)
		ctrl.keyReleased(e);
	}

	// This does not need to be implemented
	// Unless we have a keyboard to set a
	// characters name (as an example) TODO
	public void keyTyped(KeyEvent e) {

	}

	// This does not need to be implemented
	// unless we use mouse input to control
	// anything such as clicking a button
	// or for a players attack (as an example) TODO
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

}