//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Shapes.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M006														//
//																																						//
//	This class contains the common methods for the circle and square, it is never instanstated and has no paint method			//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import java.awt.*;
import javax.swing.*;

public class Shapes
{
	private Color currentColor = Color.BLACK;  // give these some default values
	private int xCoord = 0;
	private int yCoord = 0;
	private int size = 0;
	private int sizeChange;
	
	public Shapes()  
	{	
	// nothing here as there is nothing to construct but I will leave this in as a place holder
	}
	
	// below are get and set methods for changing the size, location and color of a "Shape".....
	public void setColor (Color c)
	{
	currentColor = c;
	}
	
	public Color getColor ()
	{
	return currentColor;
	}
	
	public void setXCoord (int x)
	{
	xCoord = x;
	}
	
	public void setYCoord (int y)
	{
	yCoord = y;
	}
	
	public void setSize (int s)
	{
	size = s;
	}

	public int getXCoord ()
	{
	return xCoord;
	}
	
	public int getYCoord ()
	{
	return yCoord;
	}
	
	public int getSize()
	{
	return size;
	}
	
	public void makeBigger()
	{
	size += 10;
	}
	
	public void makeSmaller()
	{
	size -= 10;
	}
	
	//check the color, if it is green make it red, if it is not make it green
	public void flipColor()
	{
	setColor( (getColor()==Color.GREEN) ? Color.RED : Color.GREEN );
	}
	
	// method to change the size change / delta (so it increases if it drops to 20 and decreases if it reaches 100, 
	// between these values the size change remains unchanged)
	public void changeSize()
	{
	if (getSize() >= 100)
		sizeChange = -10;
	if (getSize() <=20)
		sizeChange = +10;
		
	setSize(getSize()+sizeChange );
	}
	
	public void setChangeSize(int c)
	{
	sizeChange = c;
	}
	
}