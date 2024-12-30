//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Draw.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M008														//
//																																						//
//	This program creates up to 5 circles or squares and changes the colors, swapping from blue to red and visa versa			//
//																																						//
// This is the main class, it handles the creation of the container and the event handler that drives the changes to them		//
//	the actual changes are handled by methods inherrited from Shapes.java and drawn in the draw methods of Circle.java &			//
//	Square.java, finally this class handles the JFrame object that acts as a container for the other objects					//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// notice the class it's self extends JFrame and implements ActionListener as this is the "container" for all the objects
public class Draw extends JFrame implements ActionListener
{
	private JButton changeButton;
	private int numberDisplayed;
	Shape shapes[] = new Shape [5];  // I left this in as a hardcoded number, it could be a Static variable but I wanted to read it indirectly through accessing the current size of the array when I need to
	
	private Container container;

	private JButton addCircleButton;
	private JButton addSquareButton;
	private JButton changeColorButton;

	//  the constructor handles setting up the Flow manager,
	//  and creating and attaching the JButtons to the actionlistener
	public Draw()
	{
	super("CIS 173 M008 Matt Packwood");  // I tried to do this by creating a String and using that but it appears this has to be a litteral, also, isn't it the wrong course number?

	Container container = getContentPane();  // these two lines set up the display and the layout in the JFrame
	container.setLayout( new FlowLayout() );

	
	addCircleButton = new JButton("Add Circle");
	container.add(addCircleButton);
	addCircleButton.addActionListener(this);
	
	addSquareButton = new JButton("Add Square");
	container.add(addSquareButton);
	addSquareButton.addActionListener(this);
	
	changeColorButton = new JButton("Change Color");
	container.add(changeColorButton);
	changeColorButton.addActionListener(this);


	}

	public static void main(String args[])
	{
		Draw myDraw = new Draw();
//		myDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // non anonymous inner class window closer
		myDraw.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e){   // not sure why this needs to be an anonomous inner class but that is what the spec said....
			System.exit(0); } } );
		myDraw.setSize(450,500);		
		myDraw.setVisible(true);		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == changeColorButton)
			{
			for (int j = 0; j < numberDisplayed; j++)
				shapes[ j ].flipColor();
			}

		if (numberDisplayed < shapes.length)
		{

		if (ae.getSource() == addCircleButton)  // this creates a Circle which is referenced as a Shape through Polymorphism
			{
				shapes[numberDisplayed] = new Circle( (50+(numberDisplayed*75)), (75+(numberDisplayed*75)), Color.BLUE);
				numberDisplayed++;  // as the shapes array is already defined I just have to instanstate a new object to reference through it
			}	
			
		if (ae.getSource() == addSquareButton)  // this creates a Square that can also be referenced as a Shape
			{
				shapes[numberDisplayed] = new Square( (50+(numberDisplayed*75)), (75+(numberDisplayed*75)), Color.RED);
				numberDisplayed++;
			}	
		}
	repaint ();
	}
	
	public void paint (Graphics gpx)
	{
	super.paint(gpx);  // this shoule always be called for Swing

	for (int j = 0; j < numberDisplayed; j++)  // I can only display items that exist, if they are null I get an error, this handles it for me
		shapes[j].draw(gpx);  // this allows me to draw the "Shapes" by allowing Polymorphism to access the correct draw method for the type of shape
		
	}
	
}
