import processing.core.*;

public class scrabble extends PApplet
{
	PApplet p;
	PImage star;
	PImage tripleword;
	PImage tripleletter;
	PImage doubleword;
	PImage doubleletter;
	
	boolean on = true;
	int length = 750;
	int width = 750;
	
	// The argument passed to main must match the class name
	public static void main(String[] args) 
	{
		PApplet.main("scrabble");
	}
	// method for setting the size of the window
	public void settings()
	{

		size(length, width);
	}
	// identical use to setup in Processing IDE except for size()
	public void setup()
	{
		star = loadImage("star.jpg");
		tripleword = loadImage("tripleword.jpg");
		tripleletter = loadImage("triple_letter.jpg");
		doubleword = loadImage("doubleword.jpg");
		doubleletter = loadImage("double_letter.jpg");
		
		background(245, 245, 220);
		stroke(5);
		strokeWeight(0);
	}
	// identical use to draw in Processing IDE
	public void draw()
	{
		//ball1.draw(this);
		
		for (int i = 0; i < 15; i++)
		{
			for (int j = 0; j < 15; j++)
			{
				if (i%7==0  &&  j%7==0)
				{
					image(tripleword, 40*i+41, 40*j+40, 40, 40);
				}
				else if (i==j && i<5|| j==14-i && i>9 || i==14-j && i<5 || i==j && i>9)
				{
					if(frameCount%10 >= 0 && frameCount%10 < 3)
					{
						rect(40*i+40, 40*j+40, 40, 40);
						fill(255);
					}
					else
					{
						image(doubleword, 40*i+40, 40*j+40, 40,40);
					}
				}
				else if (i%4==1 && j%4==1)
				{
					image(tripleletter, 40*i+40, 40*j+40, 40, 40);
				}
				else if ((j==3||j==11) && i%7==0 || (i==3||i==11) && j%7==0 || (i==2||i==12) && (j==6||j==8) || (i==6||i==8) && (j==12||j==2) || (i==6||i==8)&&(j==6||j==8))
				{
					image(doubleletter, 40*i+40, 40*j+40, 40, 40);
				}
				else
				{
					rect(40*i+40, 40*j+40, 40, 40);
					fill(210, 210, 185);
				}
			}
		}
		if (frameCount%20 > 0 && frameCount%20 < 10)
		{
			image(star, 305, 305, 70, 70);
		}
		else
		{
			image(star, 325, 325, 35, 35);
		}
		strokeWeight(5);
		line(40, 40, 40, 640);
		line(640, 40, 640, 640);
		line(40, 40, 640, 40);
		line(40, 640, 640, 640);
		strokeWeight(1);
	
	}
}
