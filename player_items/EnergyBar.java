package com.player_items;

import javax.swing.ImageIcon;

import com.res.Sprite;
import com.res.Utilities;

public class EnergyBar extends Sprite implements Utilities {
	public EnergyBar(int x, int y) {
		this.width = 10;
		this.height = 20;
		this.x = x;
		this.y = y;
		img = new ImageIcon(EnergyBar.class.getResource("progress.gif")).getImage();

	}
}
