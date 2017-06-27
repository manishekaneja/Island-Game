package com.island_game;

import javax.swing.ImageIcon;

public class Liz extends Enemy implements Utilies {
	/**
	 * Object of Lizard Enemy
	 * @param x
	 * @param y
	 */
	public Liz(int x, int y) {
		this.x = x;
		this.y = (y - height);
		img1 = new ImageIcon(Snail.class.getResource("Liz_1.gif")).getImage();
		img2 = new ImageIcon(Snail.class.getResource("Liz_2.gif")).getImage();
		img3 = img1;
	}

}
