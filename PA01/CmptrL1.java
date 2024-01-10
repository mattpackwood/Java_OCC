/* Matt Packwood, Orchard Ridge Campus, Monday Evening Class, Fall Semester 2003
 * 
 * PA01: Java code start; based on design diagram start
 * assumes 369x369 applet screen size 
 *
*/

import java.awt.*;
import java.applet.*;

public class CmptrL1 extends Applet {
public void init ( ) {
	setBackground (Color.white); // white BG
	}
public void paint (Graphics g) {
	g.setColor (Color.yellow);
	g.fillRect (36, 0, 288, 216); // monitor
	g.fillRect (0, 216, 360, 72); // CPU
	g.fillRect (0, 288, 288, 72); // keyboard
	g.fillOval (324, 306, 36, 36); // mouse
	g.setColor (Color.lightGray);
	g.fillRect (54, 18, 252, 180); // screen
	g.setColor (Color.black);
	g.drawRect (36, 0, 288, 216); // monitor outline
	g.drawRect (0, 216, 360, 72); // CPU
	g.drawRect (0, 288, 288, 72); // keyboard
	g.drawLine (288, 324, 324, 324); // mouse cable
	g.fillRect (18, 306, 252, 36); // keys
	g.fillRect (180, 234, 144, 18); // slot
	g.fillArc (324, 306, 36, 36, 135, 90); //mouse 1
	g.fillArc (324, 306, 36, 36, 315, 90); //mouse 2
	g.drawOval (324, 306, 36, 36); //mouse 3
	g.drawString ("SHAZAAM 2003", 18, 252); // label
	}
}

