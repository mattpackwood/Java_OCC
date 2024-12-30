import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsOne extends JFrame
{
	private int x1Coord, y1Coord;
	private int x2Coord, y2Coord;
	private int width, height;
	private Color objectColor = Color.RED;
	private JButton changeColorJButton;
	private JComboBox shapeJComboBox;
	private String shapes[] = {"Oval", "Rectangle"};
	private int shapeIndex;
	private JCheckBox filledJCheckBox;
	private Boolean shapeFilled = false;
	public GraphicsOne()  // constructor, as this is a single class application the main program is here
	{
		super ("M015 GraphicsOne - Matt Packwood");
		Container container = getContentPane();  // these two lines set up the display and the layout in the Jframe
		container.setLayout( new FlowLayout() );
		changeColorJButton = new JButton ("Color");
		changeColorJButton.addActionListener(
			new ActionListener() // anonymous inner class
			{
				// display JcolorChooser when user clicks button
				public void actionPerformed (ActionEvent event)
				{
					objectColor = JColorChooser.showDialog(
						GraphicsOne.this, "Choose a color", objectColor);
						
						// set default color, if no color is returned
						if (objectColor == null)
							objectColor = Color.LIGHT_GRAY;
							
				} // end method performed
			} // end anonymous inner class
		); // end call to addItemListener
		
		add (changeColorJButton);

		shapeJComboBox = new JComboBox(shapes);
		
		shapeJComboBox.addItemListener(
			new ItemListener()  // anonymous inner class
			{
				public void itemStateChanged (ItemEvent event)
				{
					if (event.getStateChange() == ItemEvent.SELECTED)
						shapeIndex = shapeJComboBox.getSelectedIndex();
						repaint ();
					}  
				} 
			); 
			
		add (shapeJComboBox);
			
		filledJCheckBox = new JCheckBox("Filled");
		add(filledJCheckBox);
		
		filledJCheckBox.addItemListener(
			new ItemListener()  // anonymous inner class
			{
				public void itemStateChanged (ItemEvent event)
				{
					if (event.getStateChange() == ItemEvent.SELECTED)
						shapeFilled = filledJCheckBox.isSelected() ? true : false;
						repaint ();
					}
				} 
			); 

		this.addMouseListener(  // as this is an action listener for the mouse in the JFrame it uses the "this" reference
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
			
		this.addMouseMotionListener(
			new MouseMotionAdapter()
			{
				public void mouseDragged ( MouseEvent mevt )
				{
					x2Coord = mevt.getX();
					y2Coord = mevt.getY();
					repaint();
				}
			});	// End MouseMotionAdaptor AIC defn.
	}

	public void paint ( Graphics gpx )
	{
		super.paint(gpx);
		
		gpx.setColor( objectColor );
		
		int xCoord = Math.min (x1Coord, x2Coord); // I changed this from the "assist" so that it would allow right -> left and down -> up dragging
		int yCoord = Math.min (y1Coord, y2Coord);
		
		width	 = Math.abs (x1Coord - x2Coord);
		height = Math.abs (y1Coord - y2Coord);
				
		if (shapeFilled == false)  // draw different types and filled / not based on the switch / button settings
		{		
			if (shapeIndex == 0)
				gpx.drawOval(xCoord, yCoord, width, height);
			else
				gpx.drawRect(xCoord, yCoord, width, height);
		}
		else
		{		
			if (shapeIndex == 0)
				gpx.fillOval(xCoord, yCoord, width, height);
			else
				gpx.fillRect(xCoord, yCoord, width, height);
		}	
	}	// End paint method.
	
	public static void main(String args[])
	{
		// this is the main program
		GraphicsOne testGraphicsOne = new GraphicsOne();
		testGraphicsOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testGraphicsOne.setSize(300,200);
		testGraphicsOne.setVisible(true);
	}
}