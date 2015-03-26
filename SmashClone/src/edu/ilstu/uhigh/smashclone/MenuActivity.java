package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.util.List;

public class MenuActivity extends Activity {

	List<Controllable> players;
	List<Interactive> objects;
	List<NonInteractive> scenery;
	
	public MenuActivity(List<Controllable> p, List<Interactive> o, List<NonInteractive> s){
		players = p;
		objects = o;
		scenery = s;
	}
	
	public void update() {
	}

	public void paint(Graphics g) {
		
	}
	
	public void end(){
	}

	public void inputChange(boolean[] keys) {
	}
	
}
