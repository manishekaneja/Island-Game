package com.island_game;

import java.awt.Image;

public abstract class Enemy extends Sprite implements Utilies {
	private boolean changeImg = false;
	boolean gone = false;
	private int speed;
	protected Image img1;
	protected Image img2;
	protected Image img3;
	/**
	 * Abstract Class for all the Possible Enemies
	 * And there Functions
	 */

	public Enemy() {
		this.width = this.height = 50;
		this.speed = BACKGROUNG_SPEED;
		img3 = img1;
	}

	public void auto_move() {
		if (counter % 50 == 0)
			this.x -= 5;

	}

	public Image getImg() {
		if (gone) {
			img = img3;
		} else if (counter % 30 == 0) {

			changeImg = !changeImg;
			if (changeImg) {
				img = img1;
			} else {
				img = img2;
			}
		}
		return img;
	}

	public boolean isGone() {
		return gone;
	}

	public void setGone(boolean gone) {
		this.gone = gone;
	}

	void fall() {
		if (gone) {
			this.speed = -2;
			this.y += 15;
		}
	}

	void move() {
		this.x += (speed);
		this.img = getImg();
		if (gone) {
			img = img3;
		}
	}
}
