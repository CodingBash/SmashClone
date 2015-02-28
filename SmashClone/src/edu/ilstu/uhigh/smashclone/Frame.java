package edu.ilstu.uhigh.smashclone;

import javax.swing.JFrame;

/* Frame controls the actual window of the program.*/
public class Frame {

	public static void main(String[] args) {
		System.out.println("Working Dir:" + System.getProperty("user.dir"));
		// Sets the title of the program
		JFrame f = new JFrame("ULTIMATE SMASH BRETHREN");
		// Create the main panel
		Panel p = new Panel();
		// Action when program is closed
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Adds the panel to the window
		f.add(p);
		// Other window and panel actions
		f.pack();
		f.setVisible(true);
		p.setFocusable(true);
		f.setResizable(false);
		p.requestFocusInWindow();
		p.run();
		f.dispose();
	}
}