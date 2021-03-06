import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 14 February 2018
 * 
 * FrowningFaceEmoji.java
 * 
 * This class makes faceemojis that are frowning.
 */

public class FrowningFaceEmoji extends FaceEmoji{
	
	// Constructor
	public FrowningFaceEmoji(double x, double y, double size)
	{
		super(x, y, size);
	}
	
	// Draws the mouth on the face to be frowning.
	@Override
	public void draw()
	{
		super.draw();
		
		StdDraw.setPenRadius(0.03);
		StdDraw.arc(super.getX(), super.getY() - (super.getSize()/1.5), 
				super.getSize() / 2.0, 0, 180);
	}
}
