
import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;

public class Circle extends TwoDimensionalShape {
	private Double area;
	private Integer radius;

	/**
	 * Circle Constructor
	 * 
	 * @param radius A variable type of Integer
	 */
	Circle(Integer radius) {
		this.radius = radius;
		this.area = Math.PI * radius * radius;

		DecimalFormat df = new DecimalFormat("###.###");
		String areaStr = df.format(getArea());
		setSize(radius * 2 + 100, radius * 2 + 110);
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

		int size = radius * 2;
		Color myColor = new Color(103, 139, 165);
		g.setColor(myColor);
		g.fillOval(
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
