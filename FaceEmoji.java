import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 07 February 2018
 * 
 * FaceEmoji.java
 */

public class FaceEmoji extends Emoji {

	private boolean winking;
	
	public FaceEmoji(double x, double y, double size)
	{
		super(x, y, size);
		this.winking = false;
	}
	
	@Override
	public void draw() {
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledCircle(super.getX(), super.getY(), super.getSize());
			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(super.getX() - (super.getSize()/4.0), 
								 super.getY() + (super.getSize()/4.0), 
								 super.getSize()/10.0);
			if(winking)
			{
				StdDraw.setPenRadius(0.03);
				StdDraw.line((super.getX() + (super.getSize()/4.0)) - super.getSize() / 8.0, 
						     super.getY() + (super.getSize()/4.0), 
							 (super.getX() + (super.getSize()/4.0)) + super.getSize() / 8.0, 
							 super.getY() + (super.getSize()/4.0));
			}
			else
			{
				StdDraw.filledCircle(super.getX() + (super.getSize()/4.0), 
						 super.getY() + (super.getSize()/4.0), 
						 super.getSize()/10.0);
			}
	}
	
	// TODO Implement wink() in animation loop.
	public void wink()
	{
		winking = !winking;
	}

}
