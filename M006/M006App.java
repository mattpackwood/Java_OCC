//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// M006App.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M006													//
//																																						//
//	This program creates a circle and square and changes the colors and shapes, swapping from green to red and visa versa		//
//	the shapes increase in size until they reach 100 pixels across at which point they start to reduce in size until they 		//
//	reach 20 pixels at which point they start increasing again.																		//
//																																						//
// This is the main class, it handles the creation of the objects and the event handler that drives the changes to them			//
//	the actual changes are handled by methods inherrited from Shapes.java and drawn in the paint methods of Circle.java &		//
//	Square.java, finally this class handles the JFrame object that acts as a container for the other objects					//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// notice the class it's self extends JFrame and implements ActionListener as this is the "container" for all the objects
public class M006App extends JFrame implements ActionListener
{
	private JButton changeButton;
	private int xCoord1;
	private int yCoord1;
	private int xCoord2;
	private int yCoord2;

	Square mySquare;
	Circle myCircle;

	//  the constructor handles setting up the Flow manager, creating the circle and square
	//  and creating and attaching the JButton to the actionlistener
	public M006App()
	{
	Container container = getContentPane();  // these two lines set up the display and the layout in the Jframe
	container.setLayout( new FlowLayout() );

	changeButton = new JButton("Change");
	container.add(changeButton);
	changeButton.addActionListener(this);
	
	mySquare = new Square(200,300,50,10,Color.GREEN);
	myCircle = new Circle(200,150,50,-10,Color.RED);
	}

	public static void main(String args[])
	{
	
		M006App myM006App = new M006App();
		myM006App.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myM006App.setSize(400,400);
		myM006App.setVisible(true);		

	}
	
	// basic action performed method, it basically calls the methods to change the sizes and colors for both object
	// after every click on the JButton
	public void actionPerformed(ActionEvent ae)
	{
	if (ae.getSource() == changeButton);
		{
		mySquare.flipColor();
		mySquare.changeSize();
		myCircle.flipColor();
		myCircle.changeSize();
		}
		
	repaint ();
	
	}
	
	public void paint (Graphics gpx)
	{
	super.paint(gpx);
	mySquare.paint(gpx);  // I have to call this explicitly as I do not know how to trigger a draw event for everthing in one go
	myCircle.paint(gpx);
	}
	
}
