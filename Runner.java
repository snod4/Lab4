package lab4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;



public class Runner {
	
	/*
	 * Generates gray-scale image using Perlin Noise
	 * img, a BufferedImage object
	 * */
	public static void PerlinNoise(BufferedImage img) {
		
		//initializes Random and PerlinNoise objects and ensures the seeds are constantly different
		Random rand = new Random(System.currentTimeMillis()); 
		PerlinNoise noise = new PerlinNoise(rand.nextInt());
		for(int r = 0; r < img.getHeight(); r++) {
			for(int c = 0; c < img.getWidth(); c++) {
				//gets noise value from Perlin 2D function
				double val = noise.noise(c*.1,r*.1);
				
				//scaled noise value to the range between 0 and 255 inclusive
				double scaledVal = Utility.map(val, -1, 1, 0, 256);
				Color greyScale = new Color((int)scaledVal, (int)scaledVal,	(int)scaledVal);
				img.setRGB(c, r, greyScale.getRGB());

			}
		}

	}

	/*
	 * Generates gray-scale image using Simplex Noise
	 * img, a BufferedImage object
	 * */
	public static void SimplexNoise(BufferedImage img) {
		for(int r = 0; r < img.getHeight(); r++) {
			for(int c = 0; c < img.getWidth(); c++) {
				//gets noise value from Simplex 2D function
				double val = SimplexNoise.noise(c*.1,r*.1);
				
				//scaled noise value to the range between 0 and 255 inclusive
				double scaledVal = Utility.map(val, -1, 1, 0, 256);
				Color greyScale = new Color((int)scaledVal, (int)scaledVal,	(int)scaledVal);
				img.setRGB(c, r, greyScale.getRGB());

			}
		}
	}

	/*
	 * Generates gray-scale white noise image
	 * img, a BufferedImage object
	 * */
	public static void WhiteNoise(BufferedImage img) {
		//initializes Random object and ensures the seed is constantly different
		Random rand = new Random(System.currentTimeMillis());
		for(int r = 0; r < img.getHeight(); r++) {
			for(int c = 0; c < img.getWidth(); c++) {
				int randVal = rand.nextInt();
				//scales randVal to the range 0 and 255 inclusive
				int scaledVal = (int)	Utility.map(randVal, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 256);
				Color greyScale = new Color(scaledVal, scaledVal, scaledVal);
				img.setRGB(c, r, greyScale.getRGB());

			}
		}
	}

	/*
	 * Utilizes InfinitePattern to create a checker board where each square is an InfinitePattern
	 * img, a BufferedImage object
	 * squareSize, an int denoting the size of each square
	 * color1, color2, Color objects denoting the alternating colors of InfinitePattern
	 * */
	public static void InfiniteCheckerBoard(BufferedImage img, int squareSize, Color color1, Color color2) {
		for(int r = 0; r < img.getHeight(); r+=squareSize) {
			for(int c = 0; c < img.getWidth(); c+=squareSize) {
				InfinitePattern(img, c, r, squareSize, 1, color1, color2);
			}
		}
	}

	/*
	 * Generates pattern of nested squares of alternating colors
	 * img, a BufferedImage object
	 * startX, an int, starting x position of the pattern
	 * startY, an int, starting y position of pattern
	 * size, an int, size of squares,
	 * thickness, an int, thickness of resulting lines of alternating colors 
	 * */
	public static void InfinitePattern(BufferedImage img, int startX, int startY, int size, int thickness, Color color1, Color color2) {
		if(size >= thickness) {

			Utility.DrawFilledRect(img, startX, startY, size, size, color1);
			InfinitePattern(img, startX+thickness, startY+thickness, size-2*thickness, thickness, color2, color1);
		}
	}

	/*
	 * Generates a checker board pattern with alternating colors
	 * img, a BufferedImage object
	 * squareSize, an int denoting the square sizes 
	 * color1 and color2, Color objects
	 * */
	public static void CheckerBoard(BufferedImage img, int squareSize, Color color1, Color color2) {
		//gives the checkerboard alternating pattern
		boolean rowStart = true;
		boolean alternate = true; 
		for(int r = 0; r < img.getHeight(); r+=squareSize) {
			rowStart = !rowStart;
			alternate = rowStart;
			for(int c = 0; c < img.getWidth(); c+=squareSize) {
				if(alternate) {
					Utility.DrawFilledRect(img, c, r, squareSize, squareSize, color1);
				}
				else {
					Utility.DrawFilledRect(img, c, r, squareSize, squareSize, color2);
				}
				alternate = !alternate;
			}
		}
	}
	/*
	 * Fills image with a given colored
	 * img, BufferedImage object
	 * color, Color object
	 * */
	public static void ColorAllPixels(BufferedImage img, Color color) {
		for(int r = 0; r < img.getHeight(); r++) {
			for(int c = 0; c < img.getWidth(); c++) {
				img.setRGB(c, r, color.getRGB());
			}
		}
	}

	public static void main(String[] args) {
		BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
//		ColorAllPixels(img, Color.red);
//		Utility.SaveImage(img, ".\\Images\\colorAllPixel.png");
//		CheckerBoard(img, 10, Color.white, Color.black);
//		Utility.SaveImage(img, ".\\Images\\checkerboard.png");
//		CheckerBoard(img, 10,Color.red, Color.yellow);
//		Utility.SaveImage(img, ".\\Images\\checkerboardDifferentColors.png");
//		InfinitePattern(img, 0,0, img.getWidth(),10,Color.red, Color.black);
//		Utility.SaveImage(img, ".\\Images\\infinitePattern.png");
//		InfiniteCheckerBoard(img, 10, Color.black, Color.white);
//		Utility.SaveImage(img, ".\\Images\\infiniteCheckerboard.png");
//		PerlinNoise(img);
//		Utility.SaveImage(img, ".\\Images\\perlinNoise.png");
//		SimplexNoise(img);
//		Utility.SaveImage(img, ".\\Images\\simplexNoise.png");
//		WhiteNoise(img);
//		Utility.SaveImage(img, ".\\Images\\whiteNosie.png");

	}

}
