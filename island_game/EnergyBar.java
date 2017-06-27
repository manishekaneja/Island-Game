package com.island_game;

import javax.swing.ImageIcon;

public class EnergyBar extends Sprite implements Utilies {
/**
 * Object of energy Bar
 * @param x
 * @param y
 */
	public EnergyBar(int x, int y) {
		this.width = 10;
		this.height = 20;
		this.x = x;
		this.y = y;
		img = new ImageIcon(Stone.class.getResource("progress.gif")).getImage();

	}
}
