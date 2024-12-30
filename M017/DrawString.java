//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// DrawString.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M017												//
//																																						//
//	This is the actual Swing object class, see the notes in the code to explain how it works								//
//																																						//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DrawString extends JFrame
{
	private JTextField inputBox;
	private JButton changeText;
	private JPanel topPanel;
	private DisplayArea myDisplayArea;
	private JPanel centerPanel;
	private JSlider horizontalJSlider;
	private JSlider verticalJSlider;
	private String initialDisplayString = "Hello";

	public DrawString()
	{
		super ("CIS 2151 | M017 | Matt Packwood");
		inputBox = new JTextField (initialDisplayString,20);
		inputBox.addActionListener(
			new ActionListener ()
			{
				public void actionPerformed (ActionEvent event)
				{
					myDisplayArea.setDisplayedString (inputBox.getText() );
					repaint();
				}				
			}
		);

		changeText = new JButton ("Change Text");
		changeText.addActionListener(
			new ActionListener ()
			{
				public void actionPerformed (ActionEvent event)
				{
					myDisplayArea.setDisplayedString (inputBox.getText() );
					repaint();
				}				
			}
		);
				
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout() );
		topPanel.add (changeText);
		topPanel.add (inputBox);
		
		add(topPanel, BorderLayout.NORTH);
	
		centerPanel = new JPanel();
		
		myDisplayArea = new DisplayArea();
		
		myDisplayArea.setDisplayedString (initialDisplayString);
		
		centerPanel.add (myDisplayArea, BorderLayout.CENTER);
		add (centerPanel, BorderLayout.CENTER);
		
		horizontalJSlider = new JSlider( SwingConstants.HORIZONTAL, 0, 199, 50 );
		horizontalJSlider.setMajorTickSpacing( 10 );
		horizontalJSlider.setMinorTickSpacing( 2 );
		horizontalJSlider.putClientProperty("JSlider.isFilled", Boolean.TRUE);
		horizontalJSlider.setPaintLabels(true);
		horizontalJSlider.setPaintTicks( true );

		horizontalJSlider.addChangeListener(
			new ChangeListener()
			{
				public void stateChanged (ChangeEvent e)
				{
						myDisplayArea.setXLocation (horizontalJSlider.getValue() );
						repaint();
				}
			}
		);

		verticalJSlider = new JSlider( SwingConstants.VERTICAL, 0, 199, 50 );
		verticalJSlider.setMajorTickSpacing( 10 );
		verticalJSlider.setMinorTickSpacing( 2 );
		verticalJSlider.putClientProperty("JSlider.isFilled", Boolean.TRUE);
		verticalJSlider.setPaintLabels(true);
		verticalJSlider.setPaintTicks( true );
	verticalJSlider.setInverted(true);
		
		verticalJSlider.addChangeListener(
			new ChangeListener()
			{
				public void stateChanged (ChangeEvent e)
				{
						myDisplayArea.setYLocation (verticalJSlider.getValue() );
						repaint();
				}
			}
		);
		
		add (verticalJSlider, BorderLayout.EAST);
		add (horizontalJSlider, BorderLayout.SOUTH);

	}
}