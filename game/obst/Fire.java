package game.obst;

import java.awt.Image;

import javax.swing.ImageIcon;

import game.res.Sprite;
import game.res.Utilities;

public class Fire extends Sprite implements Utilities {
	private boolean check = false;
	private int speed;
	Image img1, img2;
	public Fire(int x, int y) {
		this.width = 40;
		this.height = 40;

		this.x = x;
		this.y = (y - height);
		this.speed = BACKGROUNG_SPEED;
		img1 = new ImageIcon(Fire.class.getResource("fire_1.gif")).getImage();
		img2 = new ImageIcon(Fire.class.getResource("fire_2.gif")).getImage();
	}

	public Image getImage() {
		if (getCounter() % 5 == 0) {
			check=!check;
			if (check) {
				img = img1;
			} else {
				img = img2;
			}
		}
		return img;
	}

	public void move() {
		this.x += (speed);
	}

}
