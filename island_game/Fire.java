package com.island_game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Fire extends Sprite implements Utilies {
	private boolean check = false;
	private int speed;
	Image img1, img2;
/**
 * Objects of Fire
 * @param x
 * @param y
 */
	public Fire(int x, int y) {
		this.width = 40;
		this.height = 40;

		this.x = x;
		this.y = (y - height);
		this.speed = BACKGROUNG_SPEED;
		img1 = new ImageIcon(Stone.class.getResource("fire_1.gif")).getImage();
		img2 = new ImageIcon(Stone.class.getResource("fire_2.gif")).getImage();
	}

	public Image getImage() {
		if (counter % 5 == 0) {
			check=!check;
			if (check) {
				img = img1;
			} else {
				img = img2;
			}
		}
		return img;
	}

	void move() {
		this.x += (speed);
	}

}
