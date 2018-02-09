import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 07 February 2018
 * 
 * FaceEmoji.java
 * 
 * This class is used solely for emojis of faces.
 */

public class FaceEmoji extends Emoji {

	// Instance variable.
	private boolean winking;
	
	// Constructor
	public FaceEmoji(double x, double y, double size)
	{
		super(x, y, size);
		this.winking = false;
	}
	
	// Makes animation simpler.
	@Override
	public void animate()
	{
		this.wink();
	}
	
	// Draws basic face.
	@Override
	public void draw() {
			// Head
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledCircle(super.getX(), super.getY(), super.getSize());
			
			// Left eye
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(super.getX() - (super.getSize()/4.0), 
								 super.getY() + (super.getSize()/4.0), 
								 super.getSize()/10.0);
			
			// Draws the right eye differently if the emoji is winking.
			if(winking)
			{
				StdDraw.setPenRadius(0.03);
				StdDraw.line((super.getX() + (super.getSize()/4.0)) - (super.getSize() / 8.0), 
						     super.getY() + (super.getSize()/4.0), 
							 (super.getX() + (super.getSize()/4.0)) + (super.getSize() / 8.0), 
							 super.getY() + (super.getSize()/4.0));
			}
			else
			{
				StdDraw.filledCircle(super.getX() + (super.getSize()/4.0), 
						 super.getY() + (super.getSize()/4.0), 
						 super.getSize()/10.0);
			}
	}
	
	// Toggles the status of winking.
	public void wink()
	{
		winking = !winking;
	}

}
