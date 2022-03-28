/**
 * ThreeDimensionalShape.java - Abstract ThreeDimensionalShape Class extends Shapes
 * 
 * @author Allen Taylor - CMIS 350 6382 - 3/26/2022
 */
import java.awt.Color;

abstract class ThreeDimensionalShape extends Shapes {
	int numOfDimensions = 3;

	/**
	 * This method is used to get the volume of a ThreeDimensionalShape
	 */
	abstract Double getVolume();
	
	/**
	 * This method is used to set JFrame parameters
	 */
	public void setParameters() {
		pack();
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
	};
}
