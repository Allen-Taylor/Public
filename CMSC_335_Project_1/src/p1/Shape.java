package p1;

abstract public class Shape {
	private NumberOfDimensions numOfDimensions;

	public NumberOfDimensions getNumOfDimensions() {
		return numOfDimensions;
	}

	public void setNumOfDimensions(NumberOfDimensions numOfDimensions) {
		this.numOfDimensions = numOfDimensions;
	}
}

abstract class TwoDimensionalShape extends Shape {

	TwoDimensionalShape() {
		setNumOfDimensions(NumberOfDimensions.TWO);
	}

	abstract Double getArea();
}

abstract class ThreeDimensionalShape extends Shape {
	ThreeDimensionalShape() {
		setNumOfDimensions(NumberOfDimensions.THREE);
	}

	abstract Double getVolume();
}

class Circle extends TwoDimensionalShape {
	Double radius;

	Circle(Double radius) {
		this.radius = radius;
	}

	@Override
	Double getArea() {
		return Math.PI * radius * radius;
	}

}

class Square extends TwoDimensionalShape {
	Double side;

	Square(Double side) {
		this.side = side;
	}

	@Override
	Double getArea() {
		return side * side;
	}

}

class Triangle extends TwoDimensionalShape {
	Double height;
	Double base;
	Double side;

	Triangle(Double height, Double base) { // Triangle
		this.height = height;
		this.base = base;
	}

	Triangle(Double side) { // EquilateralTriangle
		this.side = side;
	}

	@Override
	Double getArea() {
		if (side != null)
			return (Math.sqrt(3) / 4.0) * (side * side); // EquilateralTriangle
		return (height * base) / 2.0; // Triangle
	}

}

class Rectangle extends TwoDimensionalShape {
	Double length;
	Double width;

	Rectangle(Double length, Double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	Double getArea() {
		return length * width;
	}

}

class Sphere extends ThreeDimensionalShape {
	Double radius;

	Sphere(Double radius) {
		this.radius = radius;
	}

	@Override
	Double getVolume() {
		return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
	}

}

class Cube extends ThreeDimensionalShape {
	Double edgeLength;

	Cube(Double edgeLength) {
		this.edgeLength = edgeLength;
	}

	@Override
	Double getVolume() {
		return Math.pow(edgeLength, 3);
	}

}

class Cone extends ThreeDimensionalShape {
	Double radius;
	Double height;

	Cone(Double radius, Double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	Double getVolume() {
		return (1.0 / 3.0) * Math.PI * (radius * radius) * height;
	}

}

class Cylinder extends ThreeDimensionalShape {
	Double radius;
	Double height;

	Cylinder(Double radius, Double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	Double getVolume() {
		return Math.PI * (radius * radius) * height;
	}

}

class Torus extends ThreeDimensionalShape {
	Double smallRadius;
	Double bigRadius;

	Torus(Double smallRadius, Double bigRadius) {
		this.smallRadius = smallRadius;
		this.bigRadius = bigRadius;
	}

	@Override
	Double getVolume() {
		return (1.0 / 4.0) * Math.pow(Math.PI, 2.0) * (smallRadius + bigRadius)
				* Math.pow((bigRadius - smallRadius), 2.0);
	}

}