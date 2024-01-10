/* Matt Packwood, Orchard Ridge Campus, Monday Evening Class, Fall Semester 2003
 * 
 * PA02: Complex figure display from base variables
 *
 * Demo the use of vars and expressions in constructing a complex 
 * display of a Computer.  The bottom left corner of the CPU
 * is defined by the 'bX' and 'bY' variables; the CPU height is
 * defined by the 'bS' variable. All component locations are derived
 * as ratios from the bX and bY and all component sizes are derived
 * as ratios of bS.
 * In order to reduce the coding complexity of the graphics
 * statements, a series of work variables are defined and calculated
 * as proportions of the sz; ie. the qS variable is 1/4 of bS,
 * hS is 1/2 of bS and dS is double bS. 
 * The bX, bY and bS vars are set to constants; all other var values
 * are computed. All graphic parameters are either vars or var
 * expressions. Consequently, the Computer size and location can
 * be easily modified by changing the bX, bY and bS constants; this is
 * the major advantage of using vars instead of constants or 'hard points'.
 * The pixel area of the computer is calculated as the sum of the monitor,
 * CPU, keyboard and mouse areas.
 */

import java.awt.*;
import java.applet.*;

public class CmptrL2 extends Applet {

int bX, bY, bS; // base vars
int qS, hS, dS; // work ratio vars 
float area; // approximate pixel area of computer

public void init ( ) {
	setBackground (Color.white);
	bX= 36; bY= 252; bS= 54; // init base values
	qS= Math.round (bS/4.0f); // calc ratio vals
	hS= Math.round (bS/2.0f); // calc ratio vals
	dS= Math.round (bS*2.0f); // calc ratio vals
	area= (float)(((dS+dS+bS)*bS)+ ((dS+dS) * (dS+bS)) + ((dS+dS) * bS) + (Math.PI*((hS/2)*(hS/2)))  );
}
public void paint (Graphics g) {
	g.setColor (Color.yellow);
	g.fillRect (bX, bY-bS, dS+dS+bS, bS); // CPU
	g.fillRect (bX+hS, bY-dS-dS, dS+dS, dS+bS); // Monitor
	g.fillRect (bX, bY, dS+dS, bS); // Keyboard
	g.fillOval (bX+dS+dS+qS, bY+qS, hS, hS); // Mouse
	g.setColor (Color.black);
	g.drawRect (bX, bY-bS, dS+dS+bS, bS); // CPU
	g.drawRect (bX+hS, bY-dS-dS, dS+dS, dS+bS); // Monitor
	g.drawRect (bX, bY, dS+dS, bS); // Keyboard
	g.drawOval (bX+dS+dS+qS, bY+qS, hS, hS); // Mouse
	g.drawLine (bX+dS+dS, bY+hS, bX+dS+dS+qS, bY+hS); // Mouse cord
	g.fillRect (bX+dS+hS, bY-hS-qS, dS, qS); // DVD slot
	g.fillRect (bX+qS, bY+qS, dS+bS, hS); // Keys
	g.fillArc (bX+dS+dS+qS, bY+qS, hS, hS, 45, 135); // Mouse 1
	g.fillArc (bX+dS+dS+qS, bY+qS, hS, hS, 225, 135); // Mouse 2
	g.drawString ("Base values: bX=" + bX + " bY=" + bY + " bS=" + bS, bX, bY+bS+18);
	g.drawString ("approx pixel area=" + area, bX, bY+bS+36);
	g.setColor (Color.lightGray);
	g.fillRect (bX+hS+qS, bY-dS-bS-hS-qS, dS+bS+hS, dS+hS); // Screen
	}
}
