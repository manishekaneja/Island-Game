package game.collecting_items;

import javax.swing.ImageIcon;

import game.res.CollectingItems;
import game.res.Utilities;

public class Apple extends CollectingItems implements Utilities {
	public Apple(int x, int y) {
		this.score=50;
		this.x = x;
		this.y = y;
		img = new ImageIcon(Apple.class.getResource("fruit_1.gif")).getImage();
	}


}
