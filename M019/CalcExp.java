//****************************************************************
//
//						CalcExp
//
//	CIS 1730		July 13, 2005		Charles G. Myers III	
//
//****************************************************************
//
//		CalcExp manipulates the contents of a character string
//	to compute the numeric value represented by its contents.
//	The technique of String-Tokenizer is employed to sub-divide
//	the character string.
//
//***************************************************************

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

class OperatorException extends Exception
{
	public String toString()
	{
		return "Invalid Operand Or Operator";
	}
}

public class CalcExp extends JFrame implements ActionListener
{
	JButton calcBtn;
	JTextField   strInField, strOutField;
		
	public CalcExp()
	{
		super("M019 - Calculator w/Exceptions- Matt Packwood");
		
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
	
		strInField = new JTextField(20);
		c.add(strInField);
		strInField.requestFocus();
		strInField.addActionListener(this);
		
		calcBtn = new JButton("Calculate");
		c.add(calcBtn);
		calcBtn.addActionListener(this);
		
		strOutField = new JTextField(15);
		c.add(strOutField);
		strOutField.setEditable(false);
		
		addWindowListener(
		   new WindowAdapter()
		   {
		   	public void windowClosing( WindowEvent we )
			{
				System.exit(0);
			}
		   } ) ;
	} // end "CalcExp" constructor method.
	
	
	public void actionPerformed(ActionEvent event)
	{
	
		String total;
		
		if(event.getSource() == calcBtn ||
		   event.getSource() == strInField )
		{
			total = calcStrValue(strInField.getText() );
			
			strOutField.setText(total);
			
			strInField.requestFocus();

			
		} // End "if" Statement.
		
	} // End "actionPerformed" method.
	
	
	private String calcStrValue(String dataInStr)
	{
		String firstStrValue, nxtStrValue, signStr;
		int nbrTotal, nxtNbrVal;
		
		StringTokenizer strTokenData = 
				new StringTokenizer(dataInStr, "+-", true);
		
		try  // this will throw an NoSuchElementException exception if there are zero tokens 
			{
				firstStrValue = strTokenData.nextToken().trim();
				
				try  // this will throw an exception if the first token is not a number or if there are an even number of arguments
					{
						nbrTotal = Integer.parseInt(firstStrValue);  // this is the line that the NumberFormatException will be thrown from if the first argument is not a number
						while(strTokenData.hasMoreTokens() )
						{ 
							signStr = strTokenData.nextToken().trim();  // this is the NoSuchElementException will be thrown from if there are an even number of arguments
							try  // this will throw a NumberFormatException if the odd postion arguments are not a number
								{							
									nxtNbrVal = 
									    Integer.parseInt(strTokenData.nextToken().trim() );
									// this will fail if the operator is wrong, I used a custom exception for this
									// I decided to do this in a seperate method (just to try it)
									try
										{
											nbrTotal = addOrSubtract(signStr, nbrTotal, nxtNbrVal);										
										}
									catch (OperatorException myOperatorException)  // this catches the exception if + or - are not used
										{
											return myOperatorException.toString();
										}
								}

							catch (NumberFormatException myNumberFormatException)  // this catches if the odd number argument is not a number
								{
									return "Invalid Operand Or Operator";								
								}	
						}// End "while" loop.
				
						return Integer.toString(nbrTotal);
					}
				catch (NoSuchElementException myNoSuchElementException)  // this catches if the while loop ran out of aruments (there are a total number that are odd
					{
						return "Wrong Number of Elements";
					}	
					
				catch (NumberFormatException myNumberFormatException)  // this catches if the first argument is not a number
					{
						return "Invalid Operand Or Operator";								
					}	
									
			}
				
		catch ( NoSuchElementException myNoSuchElementException )  // this catches if there is nothing in the input box
					{
						nbrTotal = 0;
						strInField.setText("Enter An Expression");
						return "";
		}

		
	} // End "calcStrValue" method.

	public int addOrSubtract (String operator, int totalSoFar, int nextNumber) throws OperatorException
	{
			if(operator.equals("+") )
				totalSoFar += nextNumber;
			else
				if(operator.equals("-") )
					totalSoFar -= nextNumber;
				else
					throw new OperatorException();
			return totalSoFar;
	}




	
	public static void main(String [] args)
	{
	   CalcExp ce = new CalcExp();
	   ce.setSize ( 300, 150 );
	   ce.setVisible(true);
	}

	
} // End "CalcExp" Application Definition.
