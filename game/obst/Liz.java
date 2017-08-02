package game.obst;

import javax.swing.ImageIcon;

import game.res.Enemy;
import game.res.Utilities;

public class Liz extends Enemy implements Utilities {
	public Liz(int x, int y) {
		this.x = x;
		this.y = (y - height);
		img1 = new ImageIcon(Liz.class.getResource("Liz_1.gif")).getImage();
		img2 = new ImageIcon(Liz.class.getResource("Liz_2.gif")).getImage();
		img3 = img1;
	}

}
