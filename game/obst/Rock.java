package game.obst;

import javax.swing.ImageIcon;

import game.res.Enemy;
import game.res.Utilities;

public class Rock extends Enemy implements Utilities {
	public Rock(int x, int y) {
		this.x = x;
		this.y = (y - height);
		img1 = img2 = img3 = new ImageIcon(Rock.class.getResource("Rock.gif")).getImage();
	}

	@Override
	public void auto_move() {
		if (this.x < BOARD_WIDTH)
			this.x -= 5;

	}
}
