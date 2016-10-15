import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class JoustScreen extends KeyAdapter implements ActionListener {
	public static void main(String[] args) {
		// add a list of all extras you did, such as
		// System.out.println("Moving obstacles");
		new JoustScreen();

	}

	// DO NOT CHANGE the next four fields (the window and timer)
	private JFrame window; // the window itself
	private BufferedImage content; // the current game graphics
	private Graphics2D paintbrush; // for drawing things in the window
	private Timer gameTimer; // for keeping track of time passing
	private Bird birdr;
	private Bird birdg;
	private int score1;
	private int score2;
	private Rectangle obstacle1;
	private Rectangle obstacle2;
	private boolean gameOver;
	private String winner;

	public int getScore1() {
		return score1;
	}

	public int getScore2() {
		return score2;
	}

	public void incrementScore() {
		CollisionBox birdrBox = new CollisionBox(birdr.getRectangle());
		CollisionBox birdgBox = new CollisionBox(birdg.getRectangle());
		if (birdrBox.isSmallerOverlapVertical(birdgBox)
				&& birdr.collidesWith(birdg)) {
			if (birdr.isHigherThan(birdg)) {
				score1++;
				birdg.moveTo(200, 100);
			} else {
				score2++;
				birdr.moveTo(600, 100);
			}
		}
		gameOver = false;
		winner = "";
		if (score1 >= 10 || score2 >= 10) {
			gameOver = true;
			if (score1 > score2) {
				winner += "Red player wins!";
			} else {
				winner += "Green player wins!";
			}
		}

	}

	public JoustScreen() {
		// DO NOT CHANGE the window, content, and paintbrush lines below
		this.window = new JFrame("Joust Clone");
		this.content = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		this.paintbrush = (Graphics2D) this.content.getGraphics();
		this.window.setContentPane(new JLabel(new ImageIcon(this.content)));
		this.window.pack();
		this.window.setVisible(true);
		this.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.window.addKeyListener(this);
		// DO NOT CHANGE the window, content, and paintbrush lines above

		birdr = new Bird("birdr", 200, 400, false);
		birdg = new Bird("birdg", 600, 400, false);
		obstacle1 = new Rectangle(100, 100, 50, 200);
		obstacle2 = new Rectangle(500, 300, 250, 50);

		// DO NOT CHANGE the next two lines nor add lines after them
		this.gameTimer = new Timer(20, this); // tick at 1000/20 fps
		this.gameTimer.start(); // and start ticking now
		// DO NOT CHANGE the previous two lines nor add lines after them
	}

	public void keyPressed(KeyEvent event) {

		if (event.getKeyCode() == KeyEvent.VK_A) { // example
			System.out.println("The 'a' key was pressed");
			birdr.applyForce(-70, -70, 0.1);

		}
		if (event.getKeyCode() == KeyEvent.VK_S) { // example
			System.out.println("The 's' key was pressed");
			birdr.applyForce(70, -70, 0.1);

		}
		if (event.getKeyCode() == KeyEvent.VK_K) { // example
			System.out.println("The 'k' key was pressed");
			birdg.applyForce(-70, -70, 0.1);
		}
		if (event.getKeyCode() == KeyEvent.VK_L) { // example
			System.out.println("The 'l' key was pressed");
			birdg.applyForce(70, -70, 0.1);
		}

	}

	/**
	 * Java will call this every time the gameTimer ticks (50 times a second).
	 * If you want to stop the game, invoke this.gameTimer.stop() in this
	 * method.
	 */
	public void actionPerformed(ActionEvent event) {
		// DO NOT CHANGE the next four lines, and add nothing above them
		if (!this.window.isValid()) { // the "close window" button
			this.gameTimer.stop(); // should stop the timer
			return; // and stop doing anything else
		}
		// DO NOT CHANGE the previous four lines
		incrementScore();

		birdr.applyForce(0, 5, 0.02);
		birdg.applyForce(0, 5, 0.02);
		birdr.applyDrag(.1, 0.02);
		birdg.applyDrag(.1, 0.02);
		birdr.bounceIfOutsideOf(.5);
		birdg.bounceIfOutsideOf(.5);

		// time passes method
		birdr.setX(birdr.getX() + birdr.getDx());
		birdr.setY(birdr.getY() + birdr.getDy());
		birdg.setX(birdg.getX() + birdg.getDx());
		birdg.setY(birdg.getY() + birdg.getDy());

		obstacleCollision(birdr, obstacle1, .5);
		obstacleCollision(birdr, obstacle2, .5);
		obstacleCollision(birdg, obstacle1, .5);
		obstacleCollision(birdg, obstacle2, .5);

		double threshold = 1.5;
		if (birdr.getDx() > threshold) {

			birdr.setI(0);
		} else if (birdr.getDx() < 0) {
			birdr.setI(3);
		}

		// DO NOT CHANGE the next line; it must be last in this method
		this.refreshScreen(); // redraws the screen after things move
		// DO NOT CHANGE the above line; it must be last in this method
	}

	/**
	 * Re-draws the screen. You should erase the old image and draw a new one,
	 * but you should not change anything in this method (use actionPerformed
	 * instead if you need something to change).
	 */

	private void obstacleCollision(Bird bird, Rectangle obstacle,
			double bounciness) {
		if (bird.collidesWithObstacle(obstacle)) {

			CollisionBox obstacleBox = new CollisionBox(obstacle);
			CollisionBox birdBox = new CollisionBox(bird.getRectangle());

			if (!obstacleBox.isSmallerOverlapVertical(birdBox)) {
				if (bird.getX() > obstacle.getX()) {
					bird.setX(obstacle.getX() + obstacle.getWidth());
					bird.setDx(-Math.abs(bird.getDx()) * bounciness);
				} else if (bird.getX() < (obstacle.getX() + obstacle.getWidth())) {
					bird.setX(obstacle.getX() - 60);
					bird.setDx(Math.abs(bird.getDx()) * bounciness);
				}
			} else {
				if (bird.getY() > obstacle.getY()) {
					bird.setY(obstacle.getY() + obstacle.getHeight());
					bird.setDy(-Math.abs(bird.getDy()) * bounciness);

				} else if (bird.getY() < (obstacle.getY() + obstacle
						.getHeight())) {
					bird.setY(bird.getY()
							- obstacleBox.verticalDifference(birdBox));
					bird.setDy(Math.abs(bird.getDy()) * bounciness);
				}
			}
		}
	}

	private void refreshScreen() {
		this.paintbrush.setColor(new Color(150, 210, 255)); // pale blue
		this.paintbrush.fillRect(0, 0, this.content.getWidth(),
				this.content.getHeight()); // erases the previous frame

		birdr.draw(this.paintbrush);
		birdg.draw(this.paintbrush);
		this.paintbrush.setColor(Color.BLACK);
		this.paintbrush.fill(obstacle1);
		this.paintbrush.fill(obstacle2);

		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		this.paintbrush.setFont(f);
		this.paintbrush.setColor(new Color(127, 0, 0)); // dark red
		this.paintbrush.drawString(new Integer(score1).toString(), 30, 30);
		this.paintbrush.setColor(new Color(0, 127, 0)); // dark green
		this.paintbrush.drawString(new Integer(score2).toString(), 760, 30);
		if (gameOver) {
			Font g = new Font(Font.SANS_SERIF, Font.BOLD, 50);
			this.paintbrush.setFont(g);
			this.paintbrush.setColor(new Color(0, 0, 127));
			this.paintbrush.drawString("Game Over: " + winner, 40, 450);
			//write something here to end the game
		}
		//

		// DO NOT CHANGE the next line; it must be last in this method
		this.window.repaint(); // displays the frame to the screen
		// DO NOT CHANGE the above line; it must be last in this method
	}

}