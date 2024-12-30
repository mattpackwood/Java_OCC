//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// DrawStringTest.java by Matt Packwood, OCC CIS 2151 Summer 2006, assignment M017											//
//																																						//
// This program creates a simple Swing object that has two sliders																//
//																																						//
// This class just creates the JFrame and instanstates the object inside it													//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

import javax.swing.JFrame;

public class DrawStringTest
{
	public static void main(String args[])
	{
		DrawString myDrawString = new DrawString();
		myDrawString.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		myDrawString.setSize(350,350);
		myDrawString.setVisible(true);
	}
}