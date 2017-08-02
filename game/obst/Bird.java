package game.obst;

import javax.swing.ImageIcon;

import game.res.Enemy;
import game.res.Utilities;

public class Bird extends Enemy implements Utilities {

	private int verSpeed, horSpeed, dir;

	public Bird(int x, int y) {
		this.x = x;
		this.y = (y - height);
		img1 = new ImageIcon(Bird.class.getResource("bird_1.gif")).getImage();
		img2 = new ImageIcon(Bird.class.getResource("bird_2.gif")).getImage();
		img3 = new ImageIcon(Bird.class.getResource("bird_3.gif")).getImage();

		verSpeed = 4;
		horSpeed = 5;
		dir = 1;
	}

	@Override
	public void auto_move() {
		if (this.x <= BOARD_WIDTH) {
			if (this.y >= FRUIT_LEVEL_1) {
				dir = 1;
			} else if (this.y <= FRUIT_LEVEL_2) {
				dir = -1;
			}
			this.y -= (dir * this.verSpeed);
			this.x -= this.horSpeed;
			this.img = getImg();
			if (this.isGone()) {
				horSpeed = 0;
			}

		}
	}

}
