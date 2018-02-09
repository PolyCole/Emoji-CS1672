// Import block
import edu.princeton.cs.introcs.StdDraw;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 07 February 2018
 * 
 * EmojiDriver.java
 */

public class EmojiDriver {

	public static void main(String[] args) {
		
		// Canvas initialization.
		StdDraw.setCanvasSize(1500, 1500);
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0,100);
		StdDraw.enableDoubleBuffering();
		
		// Scanner initialization and try/catch block.
		Scanner file = null;
		
		try
		{
			file = new Scanner(new FileInputStream("emojiInput.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found. Exiting...");
			System.exit(0);
		}
		
		// Reads array size from file.
		int rows = file.nextInt();
		int columns = file.nextInt();
		
		Emoji[][] arr = new Emoji[rows][columns];
		
		// Lays out variables needed for emoji display.
		double emojiSize = 100.0 / 8.0;
		double xPos = 0;
		double yPos = 100;
		
		
		// Initializes array.
		for(int i = 0; i < arr.length; ++i)
		{
			xPos = 0;
			
			for(int j = 0; j < arr[0].length; ++j)
			{
				String currentObject = file.next();
				
				// Creates emoji based on file dictation.
				if(currentObject.equals("smile"))
				{
					arr[i][j] = new SmileyFaceEmoji(xPos + emojiSize, yPos - emojiSize, emojiSize);
				}
				else if(currentObject.equals("frown"))
				{
					arr[i][j] = new FrowningFaceEmoji(xPos + emojiSize, yPos - emojiSize, emojiSize);
				}
				else
				{
					arr[i][j] = new Clock(xPos + emojiSize, yPos - emojiSize, emojiSize, file.nextInt());
				}
				
				// Alters where the emojis are drawn on the x axis.
				xPos += 2.0 * emojiSize;
			}
			// Alters where the emojis are drawn on the Y axis.
			yPos -= 2.0 * emojiSize;
		}
			
		// Animation loop.
		while(true)
		{
			StdDraw.clear();
			for(int i = 0; i < arr.length; ++i)
			{
				for(int j = 0; j < arr[0].length; ++j)
				{
					
					arr[i][j].draw();
					arr[i][j].animate(); // Much simpler with abstract methods.
					
					// Uncomment lines 94-104 for old method of animation.
					
//					if(arr[i][j] instanceof SmileyFaceEmoji ||
//					   arr[i][j] instanceof FrowningFaceEmoji)
//					{
//						FaceEmoji a = (FaceEmoji)arr[i][j];
//						a.wink();
//					}
//					else
//					{
//						Clock a = (Clock)arr[i][j];
//						a.tick();
//					}
					
				}
			}
			StdDraw.show();
			StdDraw.pause(500);
		}
	}

}
