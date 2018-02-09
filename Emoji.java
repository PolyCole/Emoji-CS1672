
/*
 * Author: Cole Polyak
 * Assignment 3
 * 07 February 2018
 * 
 * Emoji.java
 * 
 * This class creates emojis.
 */

public abstract class Emoji {

	// Instance variables.
	private double x, y;
	private double size;
	
	// Constructor
	public Emoji(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	// Abstract methods
	public abstract void draw();
	public abstract void animate();

	// Getters
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
