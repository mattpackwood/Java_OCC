//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Shapes.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M008														//
//																																						//
//	This class contains the common methods for the circle and square, it is never instanstated and has abstract paint 			//
//	and erase methods.  Some of the methods are not used but I figured they may be of use later							//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import java.awt.*;

public abstract class Shape
{
	public static int WIDTH = 50;
	public static int HEIGHT = 50;
	
	private int width = WIDTH;
	private int height = HEIGHT;
	private Point point;
	private Color color;  
	
	public Shape()  
	{	
	point = new Point(0,0); 
	}
	
	// below are get and set methods for changing the size, location and color of a "Shape".....
	public void setColor (Color c)
	{
	color = c;
	}
	
	public Color getColor ()
	{
	return color;
	}
	
	public void setWidth (int w)
	{
	width = w;
	}
	
	public void setHeight (int h)
	{
	height = h;
	}
	
	public int getWidth ()
	{
	return width;
	}
	
	public int getHeight ()
	{
	return height;
	}
		
	public int getXCoord ()
	{
	return (int) point.getX();
	}
	
	public int getYCoord ()
	{
	return (int) point.getY();
	}
	
	public void setXCoord (int x)
	{
	point.setLocation( x,point.getY() );
	}
	
	public void setYCoord (int y)
	{
	point.setLocation( point.getX(),y );
	}

	public void setPoint (int x, int y)
	{
	point.setLocation(x,y);
	}
	
	//check the color, if it is green make it red, if it is not make it blue
	public void flipColor()
	{
	setColor( (getColor()==Color.BLUE) ? Color.RED : Color.BLUE );
	}
	
	public abstract void erase (Graphics g);

	public abstract void draw (Graphics g);
	
	
}