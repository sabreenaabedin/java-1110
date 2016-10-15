//Sabreena Abedin (sa7cx)

import java.awt.Rectangle;

public class CollisionBox {

	private Rectangle rect;

	public CollisionBox(Rectangle rect) {
		this.rect = rect;

	}

	public CollisionBox(int x, int y, int width, int height) {
		this.rect = new Rectangle(x, y, width, height);

	}

	public Rectangle getRectangle() {
		return rect;
	}

	public boolean collidesWith(CollisionBox other) {
		if (this.rect.intersects(other.getRectangle())) {
			return true;

		} else {

			return false;
		}
	}

	public void moveTo(int x, int y) {

		this.rect.setLocation(x, y);
	}

	public void moveCenterTo(int x, int y) {
		this.rect.setLocation(x - rect.width / 2, y - rect.height / 2);
	}

	public boolean isHigherThan(CollisionBox other) {

		if (rect.getCenterY() < other.getRectangle().getCenterY()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isLeftOf(CollisionBox other) {
		if (rect.getCenterX() < other.getRectangle().getCenterX()) {
			return true;
		} else {
			return false;
		}
	}

	public int verticalDifference(CollisionBox other) {

		double optionA = Math.abs(rect.getY()
				- (other.getRectangle().getY() + other.getRectangle()
						.getHeight()));
		double optionB = Math.abs(other.getRectangle().getY()
				- (rect.getY() + rect.getHeight()));

		if (optionA < optionB) {
			return (int) optionA;
		} else {
			return (int) optionB;
		}

	}

	public int horizontalDifference(CollisionBox other) {
		double optionA = Math.abs(rect.getX()
				- (other.getRectangle().getX() + other.getRectangle()
						.getWidth()));
		double optionB = Math.abs(other.getRectangle().getX()
				- (rect.getX() + rect.getWidth()));

		if (optionA < optionB) {
			return (int) optionA;
		} else {
			return (int) optionB;
		}
	}

	public boolean isSmallerOverlapVertical(CollisionBox other) {

		if (verticalDifference(other) < horizontalDifference(other)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

	}

}
