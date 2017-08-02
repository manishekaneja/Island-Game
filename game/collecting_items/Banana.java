package game.collecting_items;

import javax.swing.ImageIcon;

import game.res.CollectingItems;
import game.res.Utilities;

public class Banana extends CollectingItems implements Utilities {
	public Banana(int x, int y) {
		this.score=100;
		this.x = x;
		this.y = y;
		img = new ImageIcon(Banana.class.getResource("fruit_4.gif")).getImage();
	}

}
