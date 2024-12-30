import java.awt.*;
import javax.swing.*;

public class DisplayArea extends JPanel
{
	private int xLocation = 50;
	private int yLocation = 50;
	private String displayedString;
	private int stringWidth;
	private int stringHeight;
	private int xDrawLocation = xLocation;
	private int yDrawLocation = yLocation;
	
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent (g);
		setBackground(Color.CYAN);
		g.setFont ( new Font( "SansSerif", Font.BOLD, 12) );
		FontMetrics metrics = g.getFontMetrics();
		stringWidth = metrics.stringWidth(displayedString);
		stringHeight = metrics.getHeight();
		xDrawLocation = ( (xLocation + stringWidth <= 200) ? xLocation : (200 - stringWidth) );
		yDrawLocation = ( (yLocation - stringHeight >= 0) ? yLocation : stringHeight );		
		g.drawString (displayedString, xDrawLocation, yDrawLocation);
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension (200,200);
	}
	
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
	
	public String getDisplayedString()
	{
		return displayedString;
	}
	
	public void setDisplayedString (String s)
	{
		displayedString = s;
	}
	
	public void setYLocation (int y)
	{
		yLocation = y;
	}
	
	public void setXLocation (int x)
	{
		xLocation = x;
	}
	
}