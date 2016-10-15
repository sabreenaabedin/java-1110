import java.awt.Color;
import java.util.Random;

public class Turtle1 {

	public static Color[] listOfColors = { Color.red, Color.pink, Color.cyan,
			Color.DARK_GRAY, Color.orange };

	public static void main(String[] args) {
		World myWorld = new World();
		Turtle A = new Turtle(myWorld);

		drawShape(A, 20, 20, 40, null, 8);
		drawShape(A, 100, 100, 150, null, 3);
		drawShape(A, 70, -95, 45, null, 5);
		drawShape(A, -150 ,50 ,75 ,null ,7);
		myWorld.saveAs("TurtlePicture.png");
	
	}

	public static void drawShape(Turtle A, int x, int y, int size, Color c,
			int sides) {
		A.setShellSize(20);
		A.pickPenUp();
		A.goTo(x, y);
		A.putPenDown();
		
		for (int i = 0; i < sides; i++) {
			A.forward(size);
			if (c != null) {
				A.setColor(c);
			} else {
				Random rand = new Random();
				Color randomColor = listOfColors[rand.nextInt(listOfColors.length)];
				A.setColor(randomColor);
			}
			A.right(360 / sides);

		}
	}
}
