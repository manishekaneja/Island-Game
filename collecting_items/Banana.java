package com.collecting_items;

import javax.swing.ImageIcon;

import com.res.CollectingItems;
import com.res.Utilities;

public class Banana extends CollectingItems implements Utilities {
	public Banana(int x, int y) {
		this.score=100;
		this.x = x;
		this.y = y;
		img = new ImageIcon(Banana.class.getResource("fruit_4.gif")).getImage();
	}

}
