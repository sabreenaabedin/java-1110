import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import edu.virginia.cs.cs1110.multimedia.Picture;
import edu.virginia.cs.cs1110.multimedia.Pixel;

public class Unscramble {

	public static void main(String[] args) throws FileNotFoundException {
		Picture scrambled = new Picture("starterclue.jpg");
		// scrambled.show();
		Scanner input = new Scanner(new File("starter (1).csv"));
		int w = input.nextInt();
		int h = input.nextInt();
		input.nextLine();
		int horizontal = input.nextInt();
		int vertical = input.nextInt();
		String[] brokenLine;

		ArrayList<Picture> pictures = new ArrayList<Picture>(4);
		while (input.hasNextLine()) {
			brokenLine = input.nextLine().split(",");
			int xloc = Integer.parseInt(brokenLine[2]);
			int yloc = Integer.parseInt(brokenLine[3]);

			replaceSubImage(scrambled, 0, 0,
					pictures.get(Integer.parseInt(brokenLine[1]) - 1), w, h,
					xloc * w, yloc * h);
		}

		// pictures.get(1).show();
		// pictures.get(2).show();
		// pictures.get(3).show();
		// pictures.get(4).show();
	}

	public static void replaceSubImage(Picture scrambled, int sx, int sy,
			Picture dest, int x, int y, int width, int height) {

		for (int m = 0; m < width; m++) {
			for (int n = 0; n < height; n++) {
				Pixel p = scrambled.getPixel(sx, sy);

				dest.getPixel(x, y).setColor(p.getColor());

			}
		}

	}

}
