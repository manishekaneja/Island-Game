package com.collecting_items;

import javax.swing.ImageIcon;

import com.res.CollectingItems;
import com.res.Utilities;

public class Jackpot extends CollectingItems implements Utilities {
	public Jackpot(int x, int y) {
		this.score=1000;
		this.x = x;
		this.y = y;
		img = new ImageIcon(Jackpot.class.getResource("pot.gif")).getImage();
	}

}
