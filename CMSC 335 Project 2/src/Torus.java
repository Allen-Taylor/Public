
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Torus extends ThreeDimensionalShape {
	private Double volume;
	private static final String IMAGE_URL = "./resources/torus.jpg";

	/**
	 * Torus Constructor
	 * 
	 * @param smallRadius A variable type of Double
	 * @param bigRadius   A variable type of Double
	 * @throws IOException
	 */
	Torus(Double smallRadius, Double bigRadius) throws IOException {
		this.volume = (1.0 / 4.0) * Math.pow(Math.PI, 2.0) * (smallRadius + bigRadius)
				* Math.pow((bigRadius - smallRadius), 2.0);
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