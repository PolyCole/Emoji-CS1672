import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 07 February 2018
 * 
 * SmileyFaceEmoji.java
 */

public class SmileyFaceEmoji extends FaceEmoji {

	public SmileyFaceEmoji(double x, double y, double size)
	{
		super(x, y, size);
	}
	
	@Override
	public void draw()
	{
		super.draw();
		
		StdDraw.setPenRadius(0.03);
		StdDraw.arc(super.getX(), super.getY() - (super.getSize()/4.0), 
				super.getSize() / 2.0, 200, 340);
	}
}
