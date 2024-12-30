//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// CalcExp.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M009													//
//																																						//
//	This is the actual calulator class, see the notes in the code that eplain how it works									//
//																																						//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.StringTokenizer;

public class CalcExp extends JFrame implements ActionListener
{
	private JTextField inputBox;
	private JTextField outputBox;
	private JButton calculate;
	private String number;
	private String argument;
	private String number2;
	private int result;

	public CalcExp()
	{
		super ("M009 Simple Calculator - Matt Packwood");
		setLayout( new FlowLayout() );
		inputBox = new JTextField (" ",32);
		add(inputBox);
		calculate = new JButton("Calculate");
		add(calculate);
		calculate.addActionListener(this);
		outputBox = new JTextField (" ",14);
		outputBox.setEditable(false);
		add(outputBox);
	}
	
	public void actionPerformed (ActionEvent ae)
	{
		if (ae.getSource() == calculate)
		{
			// this is where all the work is done, I beak the input into a number of tokens
			StringTokenizer tokens = new StringTokenizer (inputBox.getText() );
			String number = tokens.nextToken();  // assuming the first think in the token pile is a number
			
			result = Integer.parseInt(number);  // make this the base number for all calculations
			
			while (tokens.hasMoreTokens() )  // this is true unless the user just typed in a single number
			{
				String argument = tokens.nextToken();  // this should be an argument (+ or -)
				String number2 = tokens.nextToken();  // this should be the next number to use with the argument on the result of the previous calculation

				if (argument.equals("+") )  // this runs if the argument is "+"
				result += Integer.parseInt(number2);  // add the next number to the result of the previous calculation

				if (argument.equals("-") )  // this runs if the argument is "-"
				result -= Integer.parseInt(number2);  // subtract the next number from the result of the previous calculation
			}

			outputBox.setText(String.format ("%2d", result));  // as there are no tokens left, print the result........
			
		}
	}
}