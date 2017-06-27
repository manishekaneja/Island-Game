package com.island_game;

import javax.swing.ImageIcon;

public class Stone extends Sprite implements Utilies {
/**
 * Object of Stone;
 */
	private boolean check = false;
	private int speed;
	private boolean hit = false;

	public Stone(int x, int y) {
		this.width = 40;
		this.height = 40;

		this.x = x;
		this.y = (y - height);
		this.speed = BACKGROUNG_SPEED;
		img = new ImageIcon(Stone.class.getResource("stone.gif")).getImage();
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	void move() {
		this.x += (speed);
		}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

}
