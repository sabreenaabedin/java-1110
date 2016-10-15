//Sabreena Abedin (sa7cx)
import java.awt.Color;

import edu.virginia.cs.cs1110.multimedia.Picture;
import edu.virginia.cs.cs1110.multimedia.Pixel;

public class BlurImage {

	public static Picture getSubImage(Picture s, int sx, int sy, int w, int h) {
		// check negative values
		if (sx < 0) {
			sx = 0;
		}
		if (sy < 0) {
			sy = 0;
		}
		// check boundaries
		if ((sx + w) > s.getWidth()) {
			sx = s.getWidth() - w;
		}

		if ((sy + h) > s.getHeight()) {
			sy = s.getHeight() - h;
		}

//		System.out.println(sx + " " + sy);
		
		Picture subpic = new Picture(w, h);

		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				Pixel p = s.getPixel(x+sx, y+sy);
//				Color original = new Color(s.getPixel(sx+x, y).getRed(), s
//						.getPixel(x, y).getGreen(), s.getPixel(x, y).getBlue());
				subpic.getPixel(x, y).setColor(p.getColor());

			}
		}
		return subpic;
	}
	
	

	public static Color getAverageColor(Picture p) {

		int blue = 0;
		int green = 0;
		int red = 0;
		int count = 0;
		for (int x = 0; x < p.getWidth(); x += 1) {
			for (int y = 0; y < p.getHeight(); y += 1) {
				blue += p.getPixel(x, y).getColor().getBlue();
				green += p.getPixel(x, y).getColor().getGreen();
				red += p.getPixel(x, y).getColor().getRed();
				count++;
			}
		}
		blue = blue / count;
		red = red / count;
		green = green / count;
		Color averageColor = new Color(red, green, blue);
		return averageColor;
	}

	public static Picture blur(Picture pic, int interval) {
		int oldWidth = pic.getWidth();
		int oldHeight = pic.getHeight();

		Picture newImg = new Picture((int) (oldWidth), (int) (oldHeight));

		for (int y = 0; y < newImg.getHeight(); y += 1) {
			for (int x = 0; x < newImg.getWidth(); x += 1) {
				newImg.getPixel(x, y).setColor(
						getAverageColor(getSubImage(pic, x - interval, y
								- interval, 2 * interval, 2 * interval)));
			}
		}

		return newImg;
	}

	public static void main(String[] args) {
		Picture pict1 = new Picture("picture1.jpg");
		Picture blue = new Picture("blue.png");
		Picture blueorange = new Picture("blueandorange.png");

		Picture subImage = getSubImage(pict1, 100, 100, 50, 50);
		subImage.show();
		System.out.println(getAverageColor(subImage)); // Should output
														// java.awt.Color[r=155,g=177,b=208]
		System.out.println(getAverageColor(blue)); // Should output
													// java.awt.Color[r=0,g=93,b=179]
		System.out.println(getAverageColor(blueorange)); // java.awt.Color[r=118,g=66,b=70]

		Picture blurred = blur(pict1, 4);
		blurred.setTitle("Interval: 4");
		blurred.show();

		Picture blurred2 = blur(pict1, 10);
		blurred2.setTitle("Interval: 10");
		blurred2.show();
	}

}
