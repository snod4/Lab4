package lab4;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Road {
	private int MINIMUM_GAP = 20;
	private int length;
	private boolean horizontal;
	private int xPos;
	private int yPos;
	private int thickness;
	public Road(boolean horizontal, int length, int xPos, int yPos, int thickness) {
		
		
	}
	
	public boolean enoughDistance(BufferedImage img) {
		for(int i = 0; i < length; i++) {
			if(!placementPossible(img, i)) {
					return false;
			}
		}
		return true;
	}
	
	public void placeRoad(BufferedImage img) {
		if(horizontal) {
			Utility.DrawLine(img, xPos, yPos, xPos+length-1, yPos, thickness, Color.black);
			}
		else {
			Utility.DrawLine(img, xPos, yPos, xPos, yPos+length-1, thickness, Color.black);
		}
		
	}
	
	private boolean placementPossible(BufferedImage img, int i) {
		int middle;
		for(int g = 0; g < MINIMUM_GAP; g++) {
			if(horizontal) {
				middle = (int) (yPos+thickness/2);
				if((middle+g < img.getHeight() && img.getRGB(xPos+i, middle+g) == Color.black.getRGB()) 
						|| (middle-g >= 0 && img.getRGB(xPos+i, middle-g) == Color.black.getRGB())) {
					return false;
				}
				
			}
			else {
				middle = (int) (xPos+thickness/2);
				if((middle+g < img.getWidth() && img.getRGB(middle+g, yPos+i ) == Color.black.getRGB()) 
						|| (middle-g >= 0 && img.getRGB(middle+g, yPos+i) == Color.black.getRGB())) {
					return false;
				}
			}
		}
		return true;
	}
}
