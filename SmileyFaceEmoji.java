import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 14 February 2018
 * 
 * SmileyFaceEmoji.java
 * 
 * This class draws faceemojis that are smiling.
 */

public class SmileyFaceEmoji extends FaceEmoji {

	// Constructor
	public SmileyFaceEmoji(double x, double y, double size)
	{
		super(x, y, size);
	}
	
	// Draws the mouth on the face to be smiling.
	@Override
	public void draw()
	{
		super.draw();
		
		StdDraw.setPenRadius(0.03);
		StdDraw.arc(super.getX(), super.getY() - (super.getSize()/4.0), 
				super.getSize() / 2.0, 200, 340);
	}
}
