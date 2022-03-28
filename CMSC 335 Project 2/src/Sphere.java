
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sphere extends ThreeDimensionalShape {
	private Double volume;
	private static final String IMAGE_URL = "./resources/sphere.JPG";

	/**
	 * Sphere Constructor
	 * 
	 * @param radius A variable type of Double
	 * @throws IOException
	 */
	Sphere(Double radius) throws IOException {
		this.volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		DecimalFormat df = new DecimalFormat("###.###");
		String areaStr = df.format(getVolume());
		setTitle("Volume = " + areaStr);
		getContentPane().add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream(IMAGE_URL)))));
		setParameters();
	}

	/**
	 * This method is used to get the volume
	 * 
	 * @return Double Returns the volume
	 */
	@Override
	public Double getVolume() {
		return volume;
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
