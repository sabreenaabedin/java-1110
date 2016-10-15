import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BigGame extends JFrame implements ActionListener{

	public static JButton[] buttons = new JButton[9];
	private ImageIcon X;
	private ImageIcon O;
	private int count;
	private static int a;

	public BigGame() {
		this.setTitle("Welcome to Tic-Tac-Nine!");
		this.setSize(900, 900);
		this.setResizable(false);

		this.X = new ImageIcon("x.jpg");
		this.O = new ImageIcon("circle.png");

		for (int i = 0; i < 9; i++) {

			buttons[i] = new JButton();
			buttons[i].setIcon(null);
			this.add(buttons[i]);

		}
		this.setLayout(new GridLayout(3, 3));
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new BigGame();
	}

	public static void GameOverX() {
		buttons[a].add(new JLabel(new ImageIcon("X")));
	}

	public static void GameOverO() {
		buttons[a].add(new JLabel(new ImageIcon("O")));
	}

	public void actionPerformed(ActionEvent e) {
		new SubGame(a);
		this.setEnabled(false);
		
	}

}
