package com.island_game;

import java.awt.Font;

import javax.swing.ImageIcon;

public interface Utilies {

	int BOARD_HEIGHT = 600;
	int BOARD_WIDTH = 1000;
	int FLOOR = BOARD_HEIGHT - 160;
	int INIT_POS = 80;
	int DEALY = 100;
	int BACKGROUNG_SPEED = -7;
	int FRUIT_LEVEL_1 = BOARD_HEIGHT - 320;
	int FRUIT_LEVEL_2 = BOARD_HEIGHT - 400;

	Background BACKGROUND1 = new Background(0, 15000,new ImageIcon(Board.class.getResource("back.jpg")));
		int ENEMY_XLOC[] = { BOARD_WIDTH + 1300, BOARD_WIDTH + 2380, BOARD_WIDTH + 2530, BOARD_WIDTH + 3570,
			BOARD_WIDTH + 3975, BOARD_WIDTH + 4240, BOARD_WIDTH + 4400, BOARD_WIDTH + 5000 };
	int FRUITS_XLOC[] = { BOARD_WIDTH + 130, BOARD_WIDTH + 535, BOARD_WIDTH + 2130, BOARD_WIDTH + 2730,
			BOARD_WIDTH + 3330, BOARD_WIDTH + 3700, BOARD_WIDTH + 4230 };
	int FRUITS_YlOC[] = { FRUIT_LEVEL_1, FRUIT_LEVEL_2, FRUIT_LEVEL_2, FRUIT_LEVEL_2, FRUIT_LEVEL_1, FRUIT_LEVEL_2,
			FRUIT_LEVEL_2, };
	int STONE_XLOC[] = { BOARD_WIDTH + 2830, BOARD_WIDTH + 3330 };
	int FIRE_XLOC[] = { BOARD_WIDTH + 1830, BOARD_WIDTH + 2330 };

	int FRUIT_SELECTOR[] = { 3, 2, 1, 2, 1, 1, 1 };
	int ENEMY_SELECTOR[] = { 2, 2, 3, 2, 4, 1, 1, 1 };

	Font ENERGY_FONT = new Font("Arial", Font.BOLD, 15);
	Font MESSAGE_FONT = new Font("Arial", Font.BOLD, 50);
	Font FINAL_SCORE_FONT = new Font("Arial", Font.BOLD, 40);
}
