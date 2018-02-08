import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 07 February 2018
 * 
 * Clock.java
 */

public class Clock extends Emoji {

	private int hour;
	
	public Clock(double x, double y, double size, int hour)
	{
		super(x, y, size);
		this.hour = hour;
	}
	
	@Override
	public void draw() {
		
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle(super.getX(), super.getY(), super.getSize());

		double cur = (Math.PI * 2) / 12;
		
		StdDraw.line(super.getX(), super.getY(), 
					 super.getX() + Math.cos(cur * (hour-3)) * super.getSize(), 
					 super.getY() + Math.sin(cur * (hour+3)) * super.getSize());
	}
	
	// TODO implement tick() in animation loop.
	public void tick()
	{
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
