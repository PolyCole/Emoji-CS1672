import edu.princeton.cs.introcs.StdDraw;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 07 February 2018
 * 
 * FrowningFaceEmoji.java
 */

public class FrowningFaceEmoji extends FaceEmoji{
	
	public FrowningFaceEmoji(double x, double y, double size)
	{
		super(x, y, size);
	}
	
	@Override
	public void draw()
	{
		super.draw();
		
		StdDraw.setPenRadius(0.03);
		StdDraw.arc(super.getX(), super.getY() - (super.getSize()/1.5), 
				super.getSize() / 2.0, 0, 180);
	}
}
