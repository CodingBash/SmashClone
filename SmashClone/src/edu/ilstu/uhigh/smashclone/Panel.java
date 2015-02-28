package edu.ilstu.uhigh.smashclone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel {
	// DIMENSION VARIABLES
	public static final int HEIGHT = 240;
	public static final int WIDTH = 320;
	public static final int SCALE = 2;
	//
	//
	// FRAMERATE VARIABLES
	private final int FPS = 60;
	private final long targetTime = 1000 / FPS;
	//
	//
	// PANEL VARAIBLES
	protected boolean running;
	//
	//
	// CONTROL INSTANCES
	protected static ControlManager control;
	private InputAdapter ia;

	// Creates the panel and control framework
	public Panel() {
		// Create the Control Manager
		control = new ControlManager();
		// Set the game as running
		running = true;
		// Set the panel information
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setBackground(Color.BLACK);
		// Declare the input adapter
		ia = new InputAdapter(control);
		// Add the input listeners to the input adapter
		addMouseListener(ia);
		addKeyListener(ia);
	}

	// paintCompontent
	// PRECONDITION: Graphics and control object made
	// POSTCONDITION: Calls the draw methods of the control models
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		control.draw(g);
	}

	// TODO: inits run method
	// init()
	// PRECONDITION:
	// POSTCONDITION:
	private void init() {
		/* Initial Actions */
	}

	// TODO: Possibly move the run method inside the control
	// PRECONDITION: Control created
	// POSTCONDITION: Runs the game
	// DESCRIPTION: This is the main loop of the game, handles frames as well
	public void run() {
		// Call initial methods
		init();
		// Create the framerate variables
		long startTime;
		long elapsedTime;
		long wait;
		// While the game is running. . .
		while (running) {
			// Record the time of this nano second
			startTime = System.nanoTime();
			// Update all the states
			control.update();
			// Paint and draw all models
			repaint();
			// Record the time of this nano second subtracted by the previous
			// record
			// This gives the elapsed time of performing all processes
			elapsedTime = System.nanoTime() - startTime;
			// Calculate the delay in order to get the preferred framerate
			wait = targetTime - elapsedTime / ((long) (Math.pow(10, 9)));
			// Delay with the non-constant
			delay((int) wait);
			// }
		}
	}

	// delay()
	// PRECONDITION: Provide a wait integer
	// POSTCONDITION: Delay the game to match the framerate
	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
