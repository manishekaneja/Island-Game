package com.island_game;

import javax.swing.ImageIcon;

public class Snail extends Enemy implements Utilies {
	/**
	 * Object of Snail
	 * @param x
	 * @param y
	 */

	public Snail(int x, int y) {
		this.x = x;
		this.y = (y - height);
		img1 = new ImageIcon(Snail.class.getResource("snail_1.gif")).getImage();
		img2 = new ImageIcon(Snail.class.getResource("snail_2.gif")).getImage();
		img3 = new ImageIcon(Snail.class.getResource("snail_3.gif")).getImage();	}


}
