package com.island_game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Hammer extends Sprite implements Utilies {
	private int select = 1;
	private int velocity = -10;
	private int gravity = 1;
	private int speed;
	private Image img1, img2, img3, img4;
/**
 * Object of Hammer
 */
	public Image getImg() {

		if (counter % 5 == 0) {
			if (select == 1) {
				img = img1;
				select = 2;

			} else if (select == 2) {
				img = img2;
				select = 3;

			} else if (select == 3) {
				img = img3;
				select = 4;

			} else if (select == 4) {
				img = img4;
				select = 1;

			}

		}
		return img;
	}

	public Hammer(int x, int y) {
		this.x = x;
		this.y = (y - this.height);
		this.width = this.height = 50;
		this.speed = 10;
		img1 = new ImageIcon(Snail.class.getResource("hammer_1.gif")).getImage();
		img2 = new ImageIcon(Snail.class.getResource("hammer_2.gif")).getImage();
		img3 = new ImageIcon(Snail.class.getResource("hammer_3.gif")).getImage();
		img4 = new ImageIcon(Snail.class.getResource("hammer_4.gif")).getImage();
	}

	void attack() {
		this.x += (speed);

	}

	void fall() {
		
				this.velocity = this.velocity + this.gravity;
		this.y = this.y + this.velocity;

		attack();
		img = getImg();
	}
}
