package game.res;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class Sprite {
	/**
	 * Abstract Class for all the Sprite Images
	 */
	private static int counter = 0;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Image img;

	public Rectangle getRectangle() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Sprite.counter = counter;
	}

}
