
import java.awt.*;
import java.text.DecimalFormat;

public class Triangle extends TwoDimensionalShape {
	private Double area;
	private Integer side;

	/**
	 * Triangle Constructor
	 * 
	 * @param side A variable type of Integer
	 */
	Triangle(Integer side) {
		this.side = side;
		this.area = (Math.sqrt(3) / 4.0) * (side * side);

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
		g.fillPolygon(new int[] { x / 2 - size / 2 + (size / 2), x / 2 - size / 2 + size, x / 2 - size / 2 + 0 },
				new int[] { y / 2 - size / 2 + 0, y / 2 - size / 2 + size, y / 2 - size / 2 + size }, 3);

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