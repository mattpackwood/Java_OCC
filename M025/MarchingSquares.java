/** Marching Suares excercise 
 * This is for the Jave <B>2151</B> class at OCC
 * @see java.lang.Object
 * @author Matt Packwood
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MarchingSquares extends JFrame
{

private	JButton	start;
private int xCoord, yCoord;
private final int MAXIMUMSQUARES = 12;
private int currentNumberOfSquares = 0;
private Square [] squareArray = new Square [12];
	public MarchingSquares()  // constructor, as this is a single class application the main program is here
		{




//		super.setBackground(Color.WHITE);
//		repaint();
//		Graphics	gpx	=	getGraphics();
//		gpx.fillRect(0,0,100,100);
	
			
		this.addMouseListener(  // as this is an action listener for the mouse in the JFrame it uses the "this" reference
			new MouseAdapter()
			{
				public void mousePressed ( MouseEvent mevt )
				{
					if (currentNumberOfSquares < MAXIMUMSQUARES )
					{
						currentNumberOfSquares += 1;
						xCoord = mevt.getX();
						yCoord = mevt.getY();				
						Graphics	gpx	=	getGraphics();
						Color colorTemp = getBackground();
						Square square = new Square( gpx, colorTemp, xCoord, yCoord);
						squareArray [currentNumberOfSquares-1] = square;
						square.start();
					}
					else
						System.out.printf("Maximum number of squares reached\n");
				}
				
				public void mouseReleased ( MouseEvent mevt )
				{
				}
			});	// End MouseAdaptor Anonymous Inner Class (AIC) defn.			
		}

	public static void main(String args[])
	{
		// this is the main program
		MarchingSquares testMarchingSquares = new MarchingSquares();
		testMarchingSquares.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testMarchingSquares.setBackground(Color.WHITE);
		testMarchingSquares.setSize(300,300);
		testMarchingSquares.setVisible(true);
	}
}

class	Square extends Thread
{
	private Graphics	gpx;
	private Color backgroundColor;
	private int x;
	private int xChange = 10;
	private int y;
	private int size = 20;
	private int rectLeftX = 0, rectRightX  = 300;
	private int rectTopY  = 0, rectBottomY = 300;
	
	public	Square ( Graphics  g , Color colorTemp, int xTemp, int yTemp)
	{
	
	/** Square constructor
	 *  @param g Graphics container
	 */
		gpx = g;
		backgroundColor = colorTemp;
		x = xTemp;
		y = yTemp;
	}


	public	void	run()
	{
		gpx.drawRect( rectLeftX, rectTopY,
						  rectRightX - rectLeftX, rectBottomY - rectTopY );
		
		for ( int n = 0; n < 1000; n++)
		{
			gpx.setColor(backgroundColor);
			gpx.fillRect( x-1, y-1, size+2, size+2 );
			
			if ( x + xChange <= (rectRightX-size) )
					x += xChange;
			if ( x + xChange >= (rectRightX-size) )
				  x = 0;
			
			gpx.setColor( Color.red );
			gpx.drawRect( x, y, size, size);
			
			try
			{
				Thread.sleep( 250 );
			}
			catch ( InterruptedException  e )
			{
				System.err.println( "Sleep Exception." );
			}
		}	//	End "For" loop.
	}	//	End "display" method.
}	//	End "Ball" Class definition.
		


