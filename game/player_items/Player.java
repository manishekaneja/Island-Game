package game.player_items;

import java.awt.Image;

import javax.swing.ImageIcon;

import game.res.Sprite;
import game.res.Utilities;

public class Player extends Sprite implements Utilities {
	private int velocity;
	private int gravity;
	private boolean notJump = true;
	private boolean isBig = false;
	private boolean check1 = false;
	private int select = 1;
	private boolean changeImg;
	private boolean active = true;
	final Image imgOb, imgSta, imgSta2,  imgFor1, imgFor2,
			 imgKill, imgFall_2, imgJump;

	public Player() {
		imgSta = new ImageIcon(Player.class.getResource("stand_1.gif")).getImage();
		imgSta2 = new ImageIcon(Player.class.getResource("stand_2.gif")).getImage();
		imgFor1 = new ImageIcon(Player.class.getResource("moveFor_1.gif")).getImage();
		imgFor2 = new ImageIcon(Player.class.getResource("moveFor_3.gif")).getImage();
		imgKill = new ImageIcon(Player.class.getResource("kill_1.gif")).getImage();
		imgOb = new ImageIcon(Player.class.getResource("Fall_1.gif")).getImage();
		imgFall_2 = new ImageIcon(Player.class.getResource("Fall_2.gif")).getImage();
		imgJump = new ImageIcon(Player.class.getResource("Jump.gif")).getImage();

		this.width = 50;
		this.height = 70;
		this.y = FLOOR - height;
		this.x = INIT_POS;
		this.img = imgSta;
		this.velocity = 0;
		this.gravity = 1;
		this.changeImg = false;
	}

	public void jump(boolean move) {
		if (notJump) {
			if (move) {
				this.velocity = -17;
			} else {
				this.velocity = -13;
			}
			this.gravity = 1;
			notJump = !notJump;
			this.y = this.y + this.velocity;
		}
	}

	public void fall() {
		if (this.y < (FLOOR - height)) {
			this.velocity = this.velocity + this.gravity;
			this.y = this.y + this.velocity;
		} else if (y >= (FLOOR - height)) {
			this.velocity = 0;
			notJump = true;
			this.y = FLOOR - height;
		}
	}

	public void kill() {
		setActive(false);
		this.img = imgKill;
		this.width = this.height = 70;
		return;
	}

	public Image getJumpImg() {
		img = imgJump;
		return img;
	}

	public Image getStandImg() {
		if (active)
			if (getCounter() % 5 == 0) {
				changeImg = !changeImg;
				if (changeImg) {
					img = imgFor1;
					return img;
				} else {
					img = imgFor2;
					return img;
				}

			}
		return img;
	}

	public Image getRunImg() {
		if (active)
			if (getCounter() % 5 == 0) {
				changeImg = !changeImg;
				if (changeImg) {

					img = imgSta;
					return img;
				} else {
					img = imgSta2;
					return img;
				}
			}
		return img;

	}

	public Image getThrowImg() {
		changeImg = !changeImg;
		if (active)
			if (changeImg) {

				img = imgFall_2;
				return img;
			}
		return img;

	}

	public Image getObImg() {
		changeImg = !changeImg;
		if (changeImg) {

			img = imgOb;
			return img;
		}
		return img;

	}

	public boolean isCheck1() {
		return check1;
	}

	public void setCheck1(boolean check1) {
		this.check1 = check1;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public boolean isBig() {
		return isBig;
	}

	public void setBig(boolean isBig) {
		this.isBig = isBig;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
