package com.obst;

import javax.swing.ImageIcon;

import com.res.Enemy;
import com.res.Utilities;

public class Snail extends Enemy implements Utilities {
	
	public Snail(int x, int y) {
		this.x = x;
		this.y = (y - height);
		img1 = new ImageIcon(Snail.class.getResource("snail_1.gif")).getImage();
		img2 = new ImageIcon(Snail.class.getResource("snail_2.gif")).getImage();
		img3 = new ImageIcon(Snail.class.getResource("snail_3.gif")).getImage();	}


}
