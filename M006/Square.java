//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Square.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M006														//
//																																						//
//	This class handles the drawing of the square 																						//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import java.awt.*;
import javax.swing.*;

public class Square extends Shapes
{
	// simple 5 input constructor to set up all the sizes, locations and color
	public Square(int x, int y, int s, int c, Color color)  
	{  
		setXCoord(x);
		setYCoord(y);
		setColor(color);
		setSize(s);
		setChangeSize(c);
	}

	// this constructor is not needed but it is nice to have something that creates a default size / location / color for testing
	public Square()
	{
		this (200,300,50,10,Color.GREEN);
	}

	
	// this is the only method I call for Squares that does anything different than Circles
	public void paint( Graphics gpx)
	{
	gpx.setColor (getColor() );
	gpx.fillRect (getXCoord()-(getSize()/2),getYCoord()-(getSize()/2),getSize(),getSize());  // this is the only unique part of the class's methods
	}
}
