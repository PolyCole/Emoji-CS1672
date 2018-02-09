import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 07 February 2018
 * 
 * Clock.java
 * 
 * This class draws clock emojis.
 */

public class Clock extends Emoji {

	// Instance variable.
	private int hour;
	
	// Constructor
	public Clock(double x, double y, double size, int hour)
	{
		super(x, y, size);
		this.hour = hour;
	}
	
	// Used to simplify animation.
	@Override
	public void animate()
	{
		this.tick();
	}
	
	// Draws the clock with the variable hour as the hour displayed.
	@Override
	public void draw() {
		
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle(super.getX(), super.getY(), super.getSize());

		double cur = (Math.PI * 2) / 12;
		
		// Draws the dial on the clock.
		StdDraw.line(super.getX(), super.getY(), 
					 super.getX() + Math.cos(cur * (hour-3)) * super.getSize(), 
					 super.getY() + Math.sin(cur * (hour+3)) * super.getSize());
	}
	
	// Makes the clock advance by one hour.
	public void tick()
	{
		// Helps the clock reset after 12.
		if(hour + 1 == 12)
		{
			hour = 0;
		}
		else
		{
			++hour;
		}
	}

}
