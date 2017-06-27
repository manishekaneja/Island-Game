package com.island_game;

import javax.swing.ImageIcon;

public class Jackpot extends CollectingItems implements Utilies {
	/**
	 * Object of Jackpot
	 * @param x
	 * @param y
	 */
	public Jackpot(int x, int y) {
		this.score=1000;
		this.x = x;
		this.y = y;
		img = new ImageIcon(Apple.class.getResource("pot.gif")).getImage();
	}

}
