import edu.princeton.cs.introcs.StdDraw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class EmojiDriver {

	public static void main(String[] args) {
		
		StdDraw.setCanvasSize(1500, 1500);
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0,100);
		
		Scanner file = null;
		Random rng = new Random();
		
		try
		{
			file = new Scanner(new FileInputStream("emojiInput.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found. Exiting...");
			System.exit(0);
		}
		
		int rows = file.nextInt();
		int columns = file.nextInt();
		
		Emoji[][] arr = new Emoji[rows][columns];
		
		double emojiSize = 100.0 / 8.0;
		
		double xPos = 0;
		double yPos = 100;
		
		
		
		for(int i = 0; i < arr.length; ++i)
		{
			xPos = 0;
			
			for(int j = 0; j < arr[0].length; ++j)
			{
				String currentObject = file.next();
				
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
				
				xPos += 2.0 * emojiSize;
			}
			
			yPos -= 2.0 * emojiSize;
		}
		
		
	// TODO Add in animation loop. 	
//		while(true)
//		{
//			for(int i = 0; i < arr.length; ++i)
//			{
//				for(int j = 0; j < arr[0].length; ++j)
//				{
//					arr[i][j].draw();
//					StdDraw.pause(500);
//					if(arr[i][j] instanceof SmileyFaceEmoji)
//					{
//						FaceEmoji a = arr[i][j];
//					}
//				}
//			}
//		}
	}

}
