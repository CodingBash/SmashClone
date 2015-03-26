package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.util.List;

public class GameActivity extends Activity {
	List<Controllable> players;
	List<Interactive> objects;
	List<NonInteractive> scenery;

	public GameActivity(List<Controllable> p, List<Interactive> o, List<NonInteractive> s) {
		players = p;
		objects = o;
		scenery = s;
		p.add(new Character(100, 300));
		p.add(new Character(300, 300));
	}

	public void update() {
		for (Controllable p : players) {
			p.update();
		}
		for (Interactive o : objects) {
			o.update();
		}
	}

	public void paint(Graphics g) {
		for (Controllable p : players) {
			p.paint(g);
		}
		for (Interactive o : objects) {
			o.paint(g);
		}
		for (NonInteractive s : scenery) {
			s.paint(g);
		}
	}
	
	
	public void end() {

	}

	public void inputChange(boolean[] inputs) {
		for(Controllable p : players){
			boolean[] keys = new boolean[p.getKeymapSize()];
			for (int i = 0; i < keys.length; i++) {
				keys[i] = inputs[i];
			}	
			p.inputChange(keys);
		}
	}
}
