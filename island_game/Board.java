package com.island_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements Utilies {

	Graphics2D tD;
	private static final long serialVersionUID = 2665453087591530261L;
	/**
	 * LinkedList of EnergyBar
	 */
	private EnergyBar energybar[] = new EnergyBar[10];
	/**
	 * Object of Player
	 */
	private Player player;
	/**
	 * List to store objects of Enemy Fruit Stone Fire Hammer
	 */
	private LinkedList<Enemy> enemy = new LinkedList<Enemy>();
	private LinkedList<CollectingItems> fruit = new LinkedList<CollectingItems>();
	private LinkedList<Stone> stone = new LinkedList<Stone>();
	private LinkedList<Fire> fire = new LinkedList<Fire>();
	private LinkedList<Hammer> hammer = new LinkedList<Hammer>();
	/**
	 * Objects of Timer to control Animation
	 */
	private Timer timer, animate;
	/**
	 * Stores the energy number at that instant
	 */
	private int energyLevel = 10;
	/**
	 * Stores the Total Score
	 */
	private int totalScore;
	/**
	 * Variables to control animation of Hammer
	 */
	private boolean hamshow;
	private boolean ham;
	/**
	 * To Control the Action of Player
	 */
	private boolean moveFor;
	private boolean jump;
	private boolean stand;
	/**
	 * To show Score in The Last
	 */
	private boolean showScore;
	/**
	 * To check whether game is playable at that moment
	 */
	private boolean playable;
	/**
	 * To change the image and cause Animation
	 */
	private boolean ob;
	private String message;
	private boolean started;

	/**
	 * Getter of tD
	 * 
	 * @return tD
	 */
	public Graphics2D gettD() {
		return tD;
	}

	/**
	 * Setter of tD
	 * 
	 * @param tDevent
	 */
	public void settD(Graphics2D tD) {
		this.tD = tD;
	}

	/**
	 * Create the panel and screen of Game Also Contains Actions Of Various
	 * Event Listener
	 */
	public Board() {
		this.hamshow = false;
		this.ham = true;
		this.moveFor = false;
		this.jump = false;
		this.stand = true;
		this.showScore = false;
		this.playable = true;
		this.ob = false;
		this.message = "YOU LOSE";
		this.started = false;

		this.setSize(1000, 600);
		this.setVisible(true);
		this.setBackground(Color.CYAN);
		this.setFocusable(true);
		this.createObj();

		if (playable) {
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (playable) {
						if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
							moveFor = true;
							stand = false;
						}

						if (e.getKeyCode() == KeyEvent.VK_SPACE) {
							jump = true;
							player.jump(moveFor);
						}
						if (e.getKeyCode() == KeyEvent.VK_Z) {
							if (ham) {
								hamshow = true;
								ham = false;
								player.img = player.getThrowImg();
								hammer.add(new Hammer(player.getX() + (player.getWidth() / 2),
										player.getY() + (player.getHeight() / 2)));
							}
						}
						/*
						 * } else { if (e.getKeyCode() == KeyEvent.VK_Q) {
						 * createObj(); new Launcher(); }
						 */ }

				}

				@Override
				public void keyReleased(KeyEvent e) {
					if (playable) {
						if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
							moveFor = false;
							stand = true;
						}

						if (e.getKeyCode() == KeyEvent.VK_Z) {
							hamshow = false;
							ham = true;
						}
					}
				}

			});
		}
		/**
		 * Controls the timing of all Objects
		 * 
		 * @timer
		 * @animate
		 */
		timer = new Timer(13, (e) -> {
			repaint();
			if (Sprite.counter % 300 == 0 && energyLevel > 0) {
				energyLevel--;
			}
			if (energyLevel == 0) {
				playable = false;
				gameOver();
			}

		});
		animate = new Timer(13, (e) -> {
			Sprite.counter++;

		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				animate.start();
				timer.start();

			}
		});

	}

	/**
	 * Creates and Initialize all the Objects and Variables
	 */
	private void createObj() {
		for (int i = 0, temp = 70; i < 10; i++, temp += energybar[i - 1].getWidth()) {
			energybar[i] = new EnergyBar(temp, 2);
		}
		player = new Player();

		for (int xLoc = 0, yLoc = 0, counter = 0; xLoc < ENEMY_XLOC.length
				&& yLoc < FRUITS_YlOC.length; xLoc++, yLoc++, counter++) {
			if (ENEMY_SELECTOR[counter] == 1) {
				enemy.add(new Snail(ENEMY_XLOC[xLoc], FLOOR));
			} else if (ENEMY_SELECTOR[counter] == 2) {
				enemy.add(new Bird(ENEMY_XLOC[xLoc], FRUITS_YlOC[yLoc]));
			} else if (ENEMY_SELECTOR[counter] == 3) {
				enemy.add(new Liz(ENEMY_XLOC[xLoc], FLOOR));
			} else if (ENEMY_SELECTOR[counter] == 4) {
				enemy.add(new Rock(ENEMY_XLOC[xLoc], FLOOR));
			}

		}

		for (int xLoc = 0, yLoc = 0, counter = 0; xLoc < FRUITS_XLOC.length
				&& yLoc < FRUITS_YlOC.length; xLoc++, yLoc++, counter++) {
			if (FRUIT_SELECTOR[counter] == 1) {
				fruit.add(new Apple(FRUITS_XLOC[xLoc], FRUITS_YlOC[yLoc]));
			} else if (FRUIT_SELECTOR[counter] == 2) {
				fruit.add(new Banana(FRUITS_XLOC[xLoc], FRUITS_YlOC[yLoc]));
			} else if (FRUIT_SELECTOR[counter] == 3) {
				fruit.add(new Jackpot(FRUITS_XLOC[xLoc], FRUITS_YlOC[yLoc]));
			}

		}
		for (int xLoc : STONE_XLOC) {

			stone.add(new Stone(xLoc, FLOOR));
		}
		for (int xLoc : FIRE_XLOC) {

			fire.add(new Fire(xLoc, FLOOR));
		}

	}

	/**
	 * Sprite Drawing Function
	 * 
	 * @param sp
	 */
	void drawSprite(Sprite sp) {
		gettD().drawImage(sp.getImg(), sp.getX(), sp.getY(), sp.getWidth(), sp.getHeight(), null);
	}

	/**
	 * Background Drawing Function
	 */
	void drawBackground() {
		gettD().drawImage(BACKGROUND1.getImg(), BACKGROUND1.getX(), 0, 15000, 570, null);

	}

	/**
	 * Calls all the required Objects and Values to draw the screen of Game
	 */
	void draw() {
		drawBackground();
		gettD().setColor(Color.WHITE);
		gettD().setFont(ENERGY_FONT);
		gettD().drawString("Energy", 10, 20);
		gettD().drawString(((Integer) totalScore).toString(), BOARD_HEIGHT - 100, 20);
		if (!started) {
			started = !started;
			gettD().setFont(MESSAGE_FONT);
			gettD().drawString("PRESS ANY KEY TO START", 100, 100);
		}

		if (ob) {
			player.getObImg();
		}

		if (hamshow) {
			player.getThrowImg();

		} else if (jump) {
			player.getJumpImg();
		} else if (moveFor) {
			player.getStandImg();
		} else if (stand) {
			player.getRunImg();
		}

		drawSprite(player);
		for (CollectingItems f : fruit) {
			drawSprite(f);
		}
		for (Enemy en : enemy) {
			drawSprite(en);
		}
		for (Stone st : stone) {
			drawSprite(st);
		}
		for (int i = 0; i < energyLevel; i++) {
			drawSprite(energybar[i]);
		}
		for (Hammer h : hammer) {
			// System.out.println("ABC");
			drawSprite(h);
		}
		for (Fire h : fire) {
			h.getImage();
			drawSprite(h);

		}

		if (showScore) {
			score(totalScore + (energyLevel * 200));
			timer.stop();
			animate.stop();
		}
		return;
	}

	/**
	 * Removes all the Objects which are not required Anymore
	 */
	void removeImg() {
		try {
			for (CollectingItems f : fruit) {
				if ((f.getX() + f.getWidth()) < 0) {
					fruit.remove(f);
				}
			}

			for (Hammer h : hammer) {
				if (h.getY() > BOARD_HEIGHT) {
					hammer.remove(h);
				}
			}
			for (Enemy s : enemy) {
				if ((s.getX() + s.getWidth()) < 0 || s.getY() >= BOARD_HEIGHT) {
					enemy.remove(s);
				}
			}

		} catch (ConcurrentModificationException e) {
			return;
		}
	}

	/**
	 * Motion Creating Function of all Objects
	 */
	void motion() {
		if (playable) {
			player.fall();
			if (moveFor) {

				BACKGROUND1.motion();

				for (CollectingItems f : fruit) {
					f.move();
				}

				for (Enemy sn : enemy) {
					sn.move();
				}
				for (Stone st : stone) {
					st.move();
				}

				for (Fire h : fire) {
					h.move();
				}

			}
			if (player.getY() >= (FLOOR - player.getHeight())) {
				jump = false;
				stand = true;
			}
			for (Enemy sn : enemy) {
				sn.auto_move();
				sn.fall();
			}
			for (Hammer h : hammer) {
				h.fall();
			}

			gameOver();
		}
		return;
	}

	/**
	 * Checks Collision between 2 Sprite
	 * 
	 * @param sp1
	 * @param sp2
	 * @return boolean
	 */

	boolean isCollision(Sprite sp1, Sprite sp2) {
		if (sp1.getRectangle().intersects(sp2.getRectangle())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks whether Game is Over or Not
	 */
	void gameOver() {

		if ((player.getX() + player.getWidth()) >= (BACKGROUND1.getX() + BACKGROUND1.getWidth() - BOARD_WIDTH)) {
			message = "YOU WON";
			showScore = true;
			moveFor = false;
			playable = false;
		}

		else if (!playable) {
			player.kill();
			energyLevel = 0;
			showScore = true;
			playable = false;
			moveFor = false;
		}

	}

	/**
	 * Check Collision of all the Objects
	 */

	void checkCollision() {
		for (CollectingItems f : fruit) {
			if (f.getX() < BOARD_WIDTH && f.getX() > 0 && isCollision(f, player)) {
				if (energyLevel < 10) {
					energyLevel++;
				}
				this.totalScore += f.getScore();
				f.setX(-100);
			}
		}
		for (Stone s : stone) {
			if (s.getX() < BOARD_WIDTH && s.getX() > 0 && !s.isHit() && isCollision(s, player) && !ob) {
				ob = true;
				energyLevel -= 2;
				s.setHit(true);

			} else if (s.getX() < BOARD_WIDTH && s.getX() > 0 && !isCollision(s, player) && ob) {
				ob = false;

			}
		}
		for (Enemy s : enemy) {
			if (s.getX() < BOARD_WIDTH && s.getX() > 0 && isCollision(s, player)) {
				if (!s.gone) {
					playable = false;
					gameOver();
				}
			}
			for (Hammer h : hammer) {
				if (s.getX() < BOARD_WIDTH && s.getX() > 0 && isCollision(s, h) && !(s instanceof Rock)) {
					h.setY(700);
					s.setGone(true);
				}

			}
		}
	}

	/**
	 * Prints Final Score
	 * 
	 * @param score
	 */
	void score(int score) {
		gettD().setFont(MESSAGE_FONT);
		gettD().drawString(message, BOARD_WIDTH / 2 - 140, BOARD_HEIGHT / 2 - 50);
		gettD().setFont(FINAL_SCORE_FONT);
		gettD().drawString("Your Score is " + ((Integer) score).toString(), BOARD_WIDTH / 2 - 140,
				BOARD_HEIGHT / 2 + 50);
	}

	/**
	 * Paint all the required things on Board
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		settD((Graphics2D) g);
		draw();
		motion();
		checkCollision();
		removeImg();
		Toolkit.getDefaultToolkit().sync();
	}
}
