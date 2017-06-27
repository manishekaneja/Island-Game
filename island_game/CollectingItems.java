package com.island_game;

public abstract class CollectingItems extends Sprite implements Utilies {
/**
 * Abstract Class for all the Collect able Items
 */
	private final int speed = BACKGROUNG_SPEED;

	protected int score;
	
	void move() {
		this.x += ( speed);
	}

	public CollectingItems() {
		this.width = 50;
		this.height = 50;

	}

	public int getSpeed() {
		return speed;
	}

	public int getScore() {
		return score;
	}
}
