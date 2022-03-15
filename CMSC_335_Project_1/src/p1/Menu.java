package p1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Menu {
	// simple print statement
	public static void print(String string) {
		System.out.println(string);
	}

	public static void main(String[] args) {

		// Scanners
		Scanner menuScan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);

		// Formatter
		DecimalFormat df;

		// Integers, Booleans
		int menuInt = 0;
		boolean mainMenuFlag = false;

		// Start Menu
		while (mainMenuFlag == false) { // Menu Loop

			print("********* Welcome to the Java OO Shapes Program **********");
			print("Select from the menu below:");
			print("1: Construct a Circle");
			print("2: Construct a Rectangle");
			print("3: Construct a Square");
			print("4: Construct a Triangle");
			print("5: Construct a Sphere");
			print("6: Construct a Cube");
			print("7: Construct a Cone");
			print("8: Construct a Cylinder");
			print("9: Construct a Torus");
			print("10: Exit the program");

			while (true) { // Selection Loop

				try {
					print("======================");
					print("Enter your selection: ");
					print("======================");
					menuInt = menuScan.nextInt(); 
					break;
				} catch (Exception e) {
					print("Invalid selection... Try again...");
					menuScan.next();
				}
			}

			switch (menuInt) { // Menu Switch
			case 1:
				while (true) {
					try {
						print("You have selected Circle:");
						print("Enter the radius:");
						String inputString = scanString.nextLine();
						Double circleRadius = Double.parseDouble(inputString);
						Circle circle = new Circle(circleRadius);
						df = new DecimalFormat("###.###");
						print("The area of the Circle is " + df.format(circle.getArea()) + ".");
						break;
					} catch (Exception e) {
						print("Invalid input... Try again...\n");
					}
				}
				break;
			case 2:
				while (true) {
					try {
						print("You have selected Rectangle!");
						print("Enter the length:");
						String inputString = scanString.nextLine();
						Double recLength = Double.parseDouble(inputString);
						print("Enter the width:");
						String inputString2 = scanString.nextLine();
						Double recWidth = Double.parseDouble(inputString2);
						Rectangle rec = new Rectangle(recLength, recWidth);
						df = new DecimalFormat("###.###");
						print("The area of the Rectangle is " + df.format(rec.getArea()) + ".");
						break;
					} catch (Exception e) {
						print("Invalid input... Try again...\n");
					}
				}
				break;
			case 3:
				while (true) {
					try {
						print("You have selected Square!");
						print("Enter the length of a side:");
						String inputString = scanString.nextLine();
						Double squareSide = Double.parseDouble(inputString);
						Square square = new Square(squareSide);
						df = new DecimalFormat("###.###");
						print("The area of the Square is " + df.format(square.getArea()) + ".");
						break;
					} catch (Exception e) {
						print("Invalid input... Try again...\n");
					}
				}
				break;
			case 4:
				while (true) {
					try {
						print("You have selected Triangle!");
						print("Is the Triangle equilateral? (Y or N)");
						String inputString = scanString.nextLine();
						if (inputString.equals("Y")) {
							print("Enter the length of a side:");
							String inputString2 = scanString.nextLine();
							Double triSide = Double.parseDouble(inputString2);
							Triangle eqTriangle = new Triangle(triSide);
							df = new DecimalFormat("###.###");
							print("The area of the Equilateral Triangle is " + df.format(eqTriangle.getArea()) + ".");
							break;
						} else if (inputString.equals("N")) {
							print("Enter the base height:");
							String inputString2 = scanString.nextLine();
							Double triBaseHeight = Double.parseDouble(inputString2);
							print("Enter the base:");
							String inputString3 = scanString.nextLine();
							Double triBase = Double.parseDouble(inputString3);
							Triangle triangle = new Triangle(triBaseHeight, triBase);
							df = new DecimalFormat("###.###");
							print("The area of the Triangle is " + df.format(triangle.getArea()) + ".");
							break;
						} else {
							print("Invalid input... Try again...\n");
						}
					} catch (Exception e) {
						print("Invalid input... Try again...\n");
					}
				}
				break;
			case 5:
				while (true) {
					try {
						print("You have selected Sphere!");
						print("Enter the radius:");
						String inputString = scanString.nextLine();
						Double sphereRadius = Double.parseDouble(inputString);
						Sphere sphere = new Sphere(sphereRadius);
						df = new DecimalFormat("###.###");
						print("The volume of the Sphere is " + df.format(sphere.getVolume()) + ".");
						break;
					} catch (Exception e) {
						print("Invalid input... Try again...\n");
					}
				}
				break;
			case 6:
				while (true) {
					try {
						print("You have selected Cube!");
						print("Enter the edge length:");
						String inputString = scanString.nextLine();
						Double cubeEdge = Double.parseDouble(inputString);
						Cube cube = new Cube(cubeEdge);
						df = new DecimalFormat("###.###");
						print("The volume of the Cube is " + df.format(cube.getVolume()) + ".");
						break;
					} catch (Exception e) {
						print("Invalid input... Try again...\n");
					}
				}
				break;
			case 7:
				while (true) {
					try {
						print("You have selected Cone!");
						print("Enter the radius:");
						String inputString = scanString.nextLine();
						Double coneRadius = Double.parseDouble(inputString);
						print("Enter the height:");
						String inputString2 = scanString.nextLine();
						Double coneHeight = Double.parseDouble(inputString2);
						Cone cone = new Cone(coneRadius, coneHeight);
						df = new DecimalFormat("###.###");
						print("The volume of the Cone is " + df.format(cone.getVolume()) + ".");
						break;
					} catch (Exception e) {
						print("Invalid input... Try again...\n");
					}
				}
				break;
			case 8:
				while (true) {
					try {
						print("You have selected Cylinder!");
						print("Enter the radius:");
						String inputString = scanString.nextLine();
						Double cylRadius = Double.parseDouble(inputString);
						print("Enter the height:");
						String inputString2 = scanString.nextLine();
						Double cylHeight = Double.parseDouble(inputString2);
						Cylinder cylinder = new Cylinder(cylRadius, cylHeight);
						df = new DecimalFormat("###.###");
						print("The volume of the Cylinder is " + df.format(cylinder.getVolume()) + ".");
						break;
					} catch (Exception e) {
						print("Invalid input... Try again...\n");
					}
				}
				break;
			case 9:
				while (true) {
					try {
						print("You have selected Torus!");
						print("Enter the inner radius:");
						String inputString = scanString.nextLine();
						Double torusInner = Double.parseDouble(inputString);
						print("Enter the outer radius:");
						String inputString2 = scanString.nextLine();
						Double torusOuter = Double.parseDouble(inputString2);
						Torus torus = new Torus(torusInner, torusOuter);
						df = new DecimalFormat("###.###");
						print("The volume of the Torus is " + df.format(torus.getVolume()) + ".");
						break;
					} catch (Exception e) {
						print("Invalid input... Try again...\n");
					}
				}
				break;
			case 10:
				// Exit Program
			    java.util.Date date = new java.util.Date();
				print("********* Thanks for using the program. The date is: "+ date+" *********");
				mainMenuFlag = true;
				break;
			default:
				print("Invalid selection. Try again.\n");
			}
		}
		// Close out scanners
		menuScan.close();
		scanInt.close();
		scanString.close();
	}

}
