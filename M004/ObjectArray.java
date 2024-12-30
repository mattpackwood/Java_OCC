import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ObjectArray extends JFrame implements ActionListener
{
	// Variables for vaious things, I will define each one
	private final int numberOfJTextField = 7;  // this is the number ot boxes (in total) that will appear
	JTextField[] boxArray = new JTextField[numberOfJTextField];	  // this defines but does not create the text boxes
	private int buttonCount [] = new int [numberOfJTextField]; // this sets up the array that holds the values for the boxes
	private JButton upButton = new JButton("Up");  // the "up button"
	private JButton downButton = new JButton("Down"); // the down button
	private int currentBox = 0; // sets the default box to start
	private int sumOfBoxes = 0; // sets the sum of the boxes to start
	
	public ObjectArray()
	{
	for (int i = 0; i <boxArray.length; i++) boxArray[i] = new JTextField(5); // instanstate the text boxes (has to be done in the constructor not in the variable definition section as it requires a for loop
	for (int i = 0; i <buttonCount.length; i++) buttonCount[i] = 0; // set up the original values for the buttonCount array
		Container container = getContentPane();  // these two lines set up the display and the layout in the Jframe
		container.setLayout( new FlowLayout() );
	for (int i = 0; i < boxArray.length - 2; i++)  // add the first 3 boxes to the display
		container.add(boxArray[i]);
		container.add(upButton);  // add the up button and down button, tie them to actionListener
		upButton.addActionListener(this);
		container.add(downButton);
		downButton.addActionListener(this);
		container.add(boxArray[numberOfJTextField-2]);  // add the "index box", set the text in it to "0" as defuult and add actionListener (note - defined as numberOfJTextField-2 in case I want to expand later)
		boxArray[numberOfJTextField-2].setText("0");
		boxArray[numberOfJTextField-2].addActionListener(this);
		container.add(boxArray[numberOfJTextField-1]);  // add the total box and make it un-editable
		boxArray[numberOfJTextField-1].setEditable(false);
		setSize(600,300);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == downButton)  // if this is the down button decrement the current box
		--buttonCount[currentBox];
		else
			if(ae.getSource() == upButton)  // if this is up button increment the current box
			++buttonCount[currentBox];
			else
				if(ae.getSource() == boxArray[numberOfJTextField-2])  // if the change is in the input box make sure this input is valid and if so change the box currently being worked on to be thindex entered
				currentBox = (Integer.parseInt (boxArray[numberOfJTextField-2].getText(),10) >=0 && Integer.parseInt (boxArray[numberOfJTextField-2].getText(),10) <=4 ? Integer.parseInt (boxArray[numberOfJTextField-2].getText(),10): currentBox);
		
		sumOfBoxes = 0;  // as this code is executed whenever an event occurs that would change the values in the boxes I chose to put the code that updates the total here
		for (int i = 0; i < boxArray.length - 2; i++)
			sumOfBoxes += buttonCount[i];
	
		repaint();
	}
	
	public void paint(Graphics gpx)
	{
		super.paint(gpx);
		
	for (int i = 0; i < boxArray.length - 2; i++)  // whenever we call repaint we redraw the values in the boxes
	boxArray[i].setText(Integer.toString(buttonCount[i]));
			
	boxArray[numberOfJTextField-1].setText(String.format ("Total %2d", sumOfBoxes)); // repaint the total if changed
	
	}
	
	public static void main(String args[])
	{
		// this is the main program
		ObjectArray testObjectArray = new ObjectArray(); // create the array of objects
		testObjectArray.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // frame admin
		testObjectArray.setSize(600,300);
		testObjectArray.setVisible(true);
	}
}