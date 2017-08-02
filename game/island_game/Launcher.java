package game.island_game;

import javax.swing.JFrame;

public class Launcher extends JFrame {

	private static final long serialVersionUID = -5040672717107143445L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			new Launcher();
		}

	/**
	 * Create the frame.
	 */
	public Launcher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(new Board());
		this.setSize(1000, 600);
		this.setVisible(true);
		this.setResizable(false);
	}

}
