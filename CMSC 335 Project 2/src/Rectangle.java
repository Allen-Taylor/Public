import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;

public class Rectangle extends TwoDimensionalShape {
	private Double area;
	private Integer height;
	private Integer width;

	/**
	 * Rectangle Constructor
	 * 
	 * @param height A variable type of Integer
	 * @param width  A variable type of Integer
	 */
	Rectangle(Integer height, Integer width) {
		this.height = height;
		this.width = width;
		this.area = (double) height * width;
		DecimalFormat df = new DecimalFormat("###.###");
		String areaStr = df.format(getArea());
		setSize(width + 100, height + 110);
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

		Color myColor = new Color(103, 139, 165);
		g.setColor(myColor);
		g.fillRect(
				x / 2 - width / 2,
				y / 2 - height / 2,
				width,
				height);
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
