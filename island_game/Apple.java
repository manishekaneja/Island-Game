package com.island_game;

import javax.swing.ImageIcon;

public class Apple extends CollectingItems implements Utilies {

/**
 * Object of Apple
 * @param x
 * @param y
 */
	public Apple(int x, int y) {
		this.score=50;
		this.x = x;
		this.y = y;
		img = new ImageIcon(Apple.class.getResource("fruit_1.gif")).getImage();
	}


}
