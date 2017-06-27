package com.res;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Background implements Utilities {
	private int speed;
	private int x;
	private int width;
	private Image img;

	public Background(int x, int width, ImageIcon img) {
		this.speed = BACKGROUNG_SPEED;
		this.x = x;
		this.width = width;
		this.img = img.getImage();
	}

	public void motion() {
		this.x += (speed);
	}

	public int getX() {
		return x;
	}

	public int getWidth() {
		return width;
	}

	public Image getImg() {
		return img;
	}

}
