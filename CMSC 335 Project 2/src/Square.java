import java.awt.*;
import java.text.DecimalFormat;

public class Square extends TwoDimensionalShape {
	private Double area;
	private Integer side;

	/**
	 * Square Constructor
	 * 
	 * @param side A variable type of Integer
	 */
	Square(Integer side) {
		this.side = side;
		this.area = (double) side * side;
		DecimalFormat df = new DecimalFormat("###.###");
		String areaStr = df.format(getArea());
		setSize(side + 100, side + 110);
		setTitle("Area = " + areaStr);
		setParameters();
	}

	/**
	 * This method is used to get the area
	 * 
	 * @return Double Returns the area
	 */
	@Override
	public Double getArea() {
		return area;
	}

	
	/**
	 * This method is used to paint a shape
	 * 
	 * @param g A variable type of Graphics
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int x = getWidth();
		int y = getHeight();

		int size = side;

		Color myColor = new Color(103, 139, 165);
		g.setColor(myColor);
		g.fillRect(
				x / 2 - size / 2,
				y / 2 - size / 2,
				size,
				size);
	}

	
	/**
	 * This method is used to get the number of dimensions
	 * 
	 * @return int Returns the number of dimensions
	 */
	@Override
	public int NumberOfDimensions() {
		return numOfDimensions;
	}

}
