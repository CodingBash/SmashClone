package edu.ilstu.uhigh.smashclone;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class SmashController {

	final int WIDTH = 640;
	final int HEIGHT = 480;
	final int FPS = 60;
	final int TARGET_TIME = 1000 / FPS;
	final int IN_MENU = 0;
	final int IN_GAME = 1;

	SmashFrame sf;
	InputAdapter ia;
	Activity[] active;
	List<Controllable> players;
	List<Interactive> objects;
	List<NonInteractive> scenery;
	int gameState;
	
	public static void main(String[] args) {
		//System.out.println("Working Dir:"+System.getProperty("user.dir"));
		SmashController sc = new SmashController();
		sc.run();
		sc.exit();
	}
	
	public SmashController(){
		sf = new SmashFrame(WIDTH, HEIGHT);
		ia = new InputAdapter(this);
		sf.addMouseListener(ia);
		sf.addKeyListener(ia);
		
		players = new ArrayList<Controllable>();
		objects = new ArrayList<Interactive>();
		scenery = new ArrayList<NonInteractive>();
		
		active = new Activity[2];
		active[IN_MENU] = new MenuActivity(players, objects, scenery);
		active[IN_GAME] = new GameActivity(players, objects, scenery);
	}
	
	private void run() {
		gameState = 1;
		while(true){
			long startTime = System.nanoTime();
			active[gameState].update();
			draw();
			long elapsedTime = System.nanoTime() - startTime; 
			int wait = (int) (TARGET_TIME - elapsedTime / ((long) (Math.pow(10, 9)))); 
			delay(wait);
		}
	}
 
	private void draw() {
		BufferStrategy bf = sf.getBufferStrategy();
		Graphics g = null;
	 
		try {
			g = bf.getDrawGraphics();
			g.clearRect(0, 0, 640, 480);
			active[gameState].paint(g);	
		} finally {
			g.dispose();
		} 
		bf.show();
	    //Tell the System to do the Drawing now, otherwise it can take a few extra ms until drawing is done which looks very jerky
	     Toolkit.getDefaultToolkit().sync();	
	}
	
	protected void inputChange(boolean[] keys){
		active[gameState].inputChange(keys);
	}
	
	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public void exit(){
	    sf.dispose();
	}

}
