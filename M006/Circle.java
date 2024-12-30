//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Circle.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M006														//
//																																						//
//	This class handles the drawing of the circle 																						//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import java.awt.*;
import javax.swing.*;

public class Circle extends Shapes
{
	// simple 5 input constructor to set up all the sizes, locations and color
	public Circle(int x, int y, int s, int c, Color color)  	{  
		setXCoord(x);
		setYCoord(y);
		setColor(color);
		setSize(s);
		setChangeSize(c);
	}

	// this constructor is not needed but it is nice to have something that creates a default size / location / color for testing
	public Circle()
	{
		this (200,150,50,-10,Color.RED);
	}
	
	// this is the only method I call for Circles that does anything different than Squares
	public void paint(Graphics gpx)
	{
	gpx.setColor (getColor() );
	gpx.fillOval (getXCoord()-(getSize()/2),getYCoord()-(getSize()/2),getSize(),getSize());  // this is the only unique part of the class's methods
	}
}