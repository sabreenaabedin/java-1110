import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.imageio.ImageIO;

public class Bird {

	// / imgs: default storage for the pictures of the bird
	private BufferedImage[] imgs;

	// TODO: add your own fields here
	private double posX;
	private double posY;
	private double dx;
	private double dy;
	private double drag;
	private boolean isLeft; // denotes direction the bird is facing

	public Bird(String basename, double x, double y, boolean isLeft) {
		this.posX = x;
		this.posY = y;
		this.dx = 0; // edit speed
		this.dy = 4; // insert gravity
		// this.drag =
		this.isLeft = isLeft;

		// You may change this method if you wish, including adding
		// parameters if you want; however, the existing image code works as is.
		this.imgs = new BufferedImage[6];
		try {
			// 0-2: right-facing (folded, back, and forward wings)
			this.imgs[0] = ImageIO.read(new File(basename + ".png"));
			this.imgs[1] = ImageIO.read(new File(basename + "f.png"));
			this.imgs[2] = ImageIO.read(new File(basename + "b.png"));
			// 3-5: left-facing (folded, back, and forward wings)
			this.imgs[3] = Bird.makeFlipped(this.imgs[0]);
			this.imgs[4] = Bird.makeFlipped(this.imgs[1]);
			this.imgs[5] = Bird.makeFlipped(this.imgs[2]);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void setX(double posX) {

		this.posX = posX;

	}

	public void setY(double posY) {

		this.posY = posY;

	}

	public double getX() {
		return posX;
	}

	public double getY() {
		return posY;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getDy() {
		return dy;
	}

	public double getDx() {
		return dx;
	}

	public void setIsLeft(boolean isLeft, Bird bird) {
		this.isLeft = isLeft;
	}

	public boolean getIsLeft() {
		return isLeft;
	}

	public boolean isHigherThan(Bird other) {

		if (this.getY() > other.getY()) {
			return false;
		} else {
			return true;
		}

	}

	public Rectangle getRectangle() {
		Rectangle birdRectangle = new Rectangle((int) this.getX(),
				(int) this.getY(), 60, 60);

		return birdRectangle;
	}

	public void moveTo(double x, double y) {
		this.posX = x;
		this.posY = y;

	}

	public boolean collidesWith(Bird other) {
		Rectangle b1 = this.getRectangle();// new Rectangle((int) this.getX(),
											// (int) this.getY(), 80,80);
		Rectangle b2 = other.getRectangle();// new Rectangle((int) other.getX(),
											// (int) other.getY(),80, 80);
		if (b1.intersects(b2)) {
			return true;

		} else {

			return false;
		}
	}

	public boolean collidesWithObstacle(Rectangle other) {
		Rectangle b1 = this.getRectangle();// new Rectangle((int) this.getX(),
											// (int) this.getY(), 80,80);
		if (b1.intersects(other)) {
			return true;

		} else {

			return false;
		}
	}

	public void bounceIfOutsideOf(double bounciness) {
		Rectangle r = new Rectangle(0, 0, 740, 540);

		if (this.posX < r.getX()) {
			this.posX = r.getX();
			this.dx = Math.abs(dx * bounciness);
		} else if (posX > (r.getX() + r.getWidth())) {
			this.posX = r.getX() + r.getWidth();
			this.dx = -Math.abs(dx * bounciness);
		}
		if (this.posY < r.getY()) {
			this.posY = r.getY();
			this.dy = Math.abs(dy * bounciness);

		} else if (this.posY > (r.getY() + r.getHeight())) {
			this.posY = r.getY() + r.getHeight();
			this.dy = -Math.abs(dy * bounciness);
		}

	}

	public void applyForce(double fx, double fy, double dt) {

		dx += (fx) * dt;
		dy += (fy) * dt;

	}

	public double getSpeed() {
		double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

		return speed;
	}

	public void applyDrag(double drag, double dt) {

		this.applyForce(-dx * this.getSpeed() * drag, -dy * this.getSpeed()
				* drag, dt);

	}

	private static BufferedImage makeFlipped(BufferedImage original) {
		AffineTransform af = AffineTransform.getScaleInstance(-1, 1);
		af.translate(-original.getWidth(), 0);
		BufferedImage ans = new BufferedImage(original.getWidth(),
				original.getHeight(), original.getType());
		Graphics2D g = (Graphics2D) ans.getGraphics();
		g.drawImage(original, af, null);
		return ans;
	}

	public int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void draw(Graphics g) {

		int dir = this.i;

		if (this.dy < -2) {
			dir += 1;
		}

		g.drawImage(this.imgs[dir], (int) posX, (int) posY, null);
	}
}