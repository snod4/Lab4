package lab4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class CityGenerator {
	
	private PriorityQueue<Road> roads;
	private String axiom;
	ArrayList<Rule> rules;
	String size;
	public CityGenerator(String axiom, ArrayList<Rule> rules, String size) {
		roads = new PriorityQueue<Road>();
		
	}
	
	
	public static void PerlinNoise(BufferedImage img) {
		Random rand = new Random(12);
		PerlinNoise noise = new PerlinNoise(rand.nextInt());
		for(int r = 0; r < img.getHeight(); r++) {
			for(int c = 0; c < img.getWidth(); c++) {
				double val = noise.noise(c*.01,r*.01);
				double scaledVal = Utility.map(val, -1, 1, 0, 256);
				Color colorVal;
				if(scaledVal >= 0 && scaledVal < 110) {
					colorVal = Color.GREEN;
				}
				else if(scaledVal < 170) {
					colorVal = Color.red;
				}
				else {
					colorVal = Color.blue;
				}
				img.setRGB(c, r, colorVal.getRGB());
			}
		}

	}
	
	public static void main(String[] args) {
		BufferedImage cityZones = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
		PerlinNoise(cityZones);
		Utility.SaveImage(cityZones, ".\\Images\\cityZones.png");
	}
}
