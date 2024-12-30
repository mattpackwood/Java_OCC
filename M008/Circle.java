//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Square.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M008														//
//																																						//
//	This class handles the drawing of the square 																						//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import java.awt.*;
import javax.swing.*;

public class Circle extends Shape
{
	// simple 3 input constructor to set up all the sizes, locations and color
	public Circle(int x, int y, Color color)  
	{  
		setPoint(x,y);
		setColor(color);
	}

	// this constructor is not needed but it is nice to have something that creates a default size / location / color for testing
	public Circle()
	{
		this (100,100,Color.BLUE);
	}

	
	// this is the only method I call for Squares that does anything different than Circles
	public void draw( Graphics gpx)
	{
	gpx.setColor (getColor() );
	gpx.fillOval (getXCoord()-(getWidth()/2),getYCoord()-(getHeight()/2),getWidth(),getHeight());  // this is the only unique part of the class's methods
	}
	
	// this is a placeholder for this application, we will probaby use it later
	public void erase( Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(g2.getBackground() );
		draw(g2);
	}	
}
