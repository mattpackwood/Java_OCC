//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// CalcExpTest.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M009												//
//																																						//
//	This program is a simple calculator to add and subtract integer values														//
//																																						//
// This class just creates the JFrame and instanstates the calulator inside it												//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import javax.swing.JFrame;

public class CalcExpTest
{
	public static void main(String args[])
	{
		CalcExp myCalc = new CalcExp();
		myCalc.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		myCalc.setSize(400,275);
		myCalc.setVisible(true);
	}
}