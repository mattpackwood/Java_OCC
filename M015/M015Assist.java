import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class M015Assist extends JFrame
{
	private 	int 	x1Coord, y1Coord;
	private 	int 	x2Coord, y2Coord;
	
	private	int 	width, height;
	
	private	Color	objectColor = Color.MAGENTA;
	
	public M015Assist()
	{
		super("M015 Assist:  C.G. Myers");	
				
		addMouseListener(
			new MouseAdapter()
			{
				public void mousePressed ( MouseEvent mevt )
				{
					x1Coord = mevt.getX();
					y1Coord = mevt.getY();
				}
				
				public void mouseReleased ( MouseEvent mevt )
				{
					x2Coord = mevt.getX();
					y2Coord = mevt.getY();
					repaint();
				}
			});	// End MouseAdaptor Anonymous Inner Class (AIC) defn.
			
		addMouseMotionListener(
			new MouseMotionAdapter()
			{
				public void mouseDragged ( MouseEvent mevt )
				{
					x2Coord = mevt.getX();
					y2Coord = mevt.getY();
					repaint();
				}
			});	// End MouseMotionAdaptor AIC defn.
			
	}	//	End M015Assist Constructor method defn.
	
	public	void	paint ( Graphics gpx )
	{
		super.paint(gpx);
		
		gpx.setColor( objectColor );
		
		x1Coord = Math.min (x1Coord, x2Coord);
		y1Coord = Math.min (y1Coord, y2Coord);
		
		width	 = Math.abs (x1Coord - x2Coord);
		height = Math.abs (y1Coord - y2Coord);
		
				
		gpx.drawOval(x1Coord, y1Coord, width, height);
	}	// End paint method.
	
	public static void main(String args[])
	{
		System.out.println("Starting App");
		
		M015Assist app = new M015Assist();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		app.setSize(400,300);
		app.setVisible( true );
	}
}