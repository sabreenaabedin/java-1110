import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SubGame extends JFrame implements ActionListener{
	
	public JButton[] buttons = new JButton[9];
	private ImageIcon X;
	private ImageIcon O;
	private int count;
	private int a;
	
	public SubGame(int a) {
		this.setTitle("Welcome to Mini Tic-Tac-Nine!");
		this.setSize(900, 900);
		this.setResizable(false);
		
		this.X = new ImageIcon("x.jpg");
		this.O = new ImageIcon("circle.png");
		
		this.a = a;
		
		for (int i = 0; i < 9; i++) {
			
			buttons[i] = new JButton();
			buttons[i].setIcon(null);
			buttons[i].setEnabled(true);
			this.add(buttons[i]);
		
		}
		this.setLayout(new GridLayout(3,3));
		this.setVisible(true);

	}
	public static void main(String[] args) {
		new SubGame(4);
	}

	public void actionPerformed(ActionEvent e) {
		count = Counter.getCount();

		if (count % 2 == 1) {
			this.add(new JLabel(new ImageIcon("X")));
			Counter.increaseCount();

			int[] temp = CheckWin.getCheck();
			temp[a] = 1;
			CheckWin.setCheck(temp);
			System.out.println(temp[a]);
			CheckWin.run();
			if (CheckWin.run() == true) {
				System.out.print("hi");
				BigGame.GameOverX();
			}
				
		} else {
			
			this.add(new JLabel(new ImageIcon("O")));
			Counter.increaseCount();

			int[] temp = CheckWin.getCheck();
			temp[a] = 2;
			System.out.println(temp[a]);
			CheckWin.setCheck(temp);
			CheckWin.run();
			if (CheckWin.run() == true) {
				BigGame.GameOverO();
			}
				
		}
		this.setEnabled(false);
		
		new SubGame(a);
	}

}
