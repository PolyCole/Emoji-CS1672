
/*
 * Author: Cole Polyak
 * Assignment 3
 * 07 February 2018
 * 
 * Emoji.java
 */

public abstract class Emoji {

	private double x, y;
	private double size;
	
	public Emoji(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public abstract void draw();

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getSize() {
		return size;
	}
}
