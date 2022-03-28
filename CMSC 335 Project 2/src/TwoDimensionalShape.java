/**
 * TwoDimensionalShape.java - Abstract TwoDimensionalShape Class extends Shapes
 * 
 * @author Allen Taylor - CMIS 350 6382 - 3/26/2022
 */
import java.awt.Color;

abstract class TwoDimensionalShape extends Shapes {
	int numOfDimensions = 2;

	/**
	 * This method is used to get the area of a TwoDimensionalShape
	 */
	abstract Double getArea();
	
	/**
	 * This method is used to set JFrame parameters
	 */
	public void setParameters() {
		setVisible(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
	};
}