package edu.ilstu.uhigh.smashclone;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/*
 * This class allows animation based on a sprite sheet.
 * The sprite sheet must consist of rectangular sprite 
 * image frames that all have the same width and same height. 
 * Width and height may be different, and there may be any 
 * number of rows and columns.
 * Change the values in SPRITE_WIDTH and SPRITE_HEIGHT to
 * match those of an individual tile.  
 */
public class SpriteManager {

	BufferedImage spriteSheet;
	int spriteWidth;
	int spriteHeight;
	final int BUFFER_LIMIT = 2;
	int rows, columns;
	ArrayList<Integer> animQueue;

	/*
	 * From your character class, create a new SpriteManager, supplying the
	 * filename for your sprite sheet as a String and the width and height of an
	 * individual sprite frame
	 */
	public SpriteManager(String file, int w, int h) {
		animQueue = new ArrayList<Integer>();
		try {
			spriteSheet = ImageIO.read(getClass().getResource(
					"/resources/" + file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		spriteWidth = w;
		spriteHeight = h;
		columns = spriteSheet.getWidth() / spriteWidth;
		rows = spriteSheet.getHeight() / spriteHeight;
		animQueue.add(0);
	}

	/*
	 * The animate method is used to add a series of sprite frames to the
	 * animation queue. The frames will be painted in the order added. To add a
	 * series of frames, call animate with the list of frame numbers (as an
	 * integer array). Sprite frames are numbered across rows, then columns: 0 1
	 * 2 3 4 5 6 7 8 9 Your character class can define named integer arrays to
	 * easily add animation sequences. For example: int[] walkLeft =
	 * {0,1,3,5,10,11}; mySpiteManager.animate(walkLeft); BUFFER_LIMIT sets a
	 * max size on the animation queue to avoid a long line of frames waiting to
	 * be painted.
	 */
	public int animate(int[] a) {
		if (animQueue.size() < BUFFER_LIMIT) {
			for (int i : a) {
				if (i >= 0 && i < rows * columns)
					animQueue.add(i);
			}
			return animQueue.size();
		}
		return -1;
	}

	/*
	 * Your character's paint method should call currentFrame. This method will
	 * return the current sprite frame as a BufferedImage, which can be used
	 * directly in g.drawImage
	 */
	public BufferedImage currentFrame() {
		int u = animQueue.get(0) % columns;
		int v = animQueue.get(0) / columns;

		return spriteSheet.getSubimage(u * spriteWidth, v * spriteHeight,
				spriteWidth, spriteHeight);
	}

	/*
	 * Your character's update method should call this update method Update
	 * moves the animation to the next frame in line by removing the first frame
	 * from the queue (it assumes that the first frame has been painted by now.)
	 * The last frame in line is always kept as a "resting" image
	 */
	public void update() {
		if (animQueue.size() > 1)
			animQueue.remove(0);
	}

	/*
	 * Clear removes all animation frames except for the very last One frame is
	 * kept as a "resting" frame to be painted
	 */
	public void clear() {
		Integer i = animQueue.get(animQueue.size() - 1);
		animQueue.clear();
		animQueue.add(i);
	}

}
