package emoji;

// Import block
import edu.princeton.cs.introcs.StdDraw;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Author: Cole Polyak
 * Assignment 3
 * 14 February 2018
 * 
 * EmojiDriver.java
 * 
 * This class exercises the Emoji classes and their subclasses.
 */

public class EmojiDriver {
	
	public static Scanner file = null;
	
	public static void main(String[] args) {
		
		// Inputting file
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please input file name: ");
		initFile(keyboard.next());
		System.out.println("File success. Reading file...");
		
		keyboard.close();
		
		
		// Reads array size from file.
		int rows = file.nextInt();
		int columns = file.nextInt();
		
		Emoji[][] arr = new Emoji[rows][columns];
		
		// Canvas initialization.
				StdDraw.setCanvasSize(1500, 1500);
				StdDraw.setXscale(0, rows*100);
				StdDraw.setYscale(0, columns*100);
				StdDraw.enableDoubleBuffering();
		
		// Lays out variables needed for emoji display.
		double emojiSize = rows*100 / 8.0;
		double xPos = 0;
		double yPos = rows*100;
		
		
		// Initializes array.
		for(int i = 0; i < arr.length; ++i)
		{
			xPos = 0;
			
			for(int j = 0; j < arr[0].length; ++j)
			{
				String currentObject = file.next();
				
				// Creates emoji based on file dictation.
				if("smile".equals(currentObject))
				{
					arr[i][j] = new SmileyFaceEmoji(xPos + emojiSize, yPos - emojiSize, emojiSize);
				}
				else if("frown".equals(currentObject))
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
					arr[i][j].animate(); 				
				}
			}
			StdDraw.show();
			StdDraw.pause(500);
		}
	}
	
	// Method goes about establishing file input.
	public static String initFile(String fileName)
	{
		Scanner keyboard = new Scanner(System.in);

		try
		{
			file = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e)
		{
			// Infinite until valid file is inputted.
			System.out.println("File not found. Please double check filename and try again.");
			initFile(keyboard.next());
		}
		
		keyboard.close();
		return fileName;
	}

}
