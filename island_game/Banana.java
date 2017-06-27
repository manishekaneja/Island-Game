package com.island_game;

import javax.swing.ImageIcon;

public class Banana extends CollectingItems implements Utilies {
/**
 * Object of Banana
 * @param x
 * @param y
 */
	public Banana(int x, int y) {
		this.score=100;
		this.x = x;
		this.y = y;
		img = new ImageIcon(Apple.class.getResource("fruit_4.gif")).getImage();
	}

}
