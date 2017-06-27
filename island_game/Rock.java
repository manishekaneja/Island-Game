package com.island_game;

import javax.swing.ImageIcon;

public class Rock extends Enemy implements Utilies {
	/**
	 * Object of Rock 
	 * @param x
	 * @param y
	 */
	public Rock(int x, int y) {
		this.x = x;
		this.y = (y - height);
		img1 = img2 = img3 = new ImageIcon(Snail.class.getResource("Rock.gif")).getImage();
	}

	@Override
	public void auto_move() {
		if (this.x < BOARD_WIDTH)
			this.x -= 5;

	}
}
