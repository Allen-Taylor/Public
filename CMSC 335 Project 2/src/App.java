/** 
 * App.java - Allows a user to select a shape from a list of available shapes, enter appropriate dimensional parameters and then display that shape.
 * 
 * @author Allen Taylor - CMIS 350 6382 - 3/26/2022
 */

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class App {
    
    // Main Method
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setTitle("CMSC 335 Project 2");
        frame.setBounds(100, 100, 450, 169);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);

        JLabel mainLabel = new JLabel("Select a shape:");
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainLabel.setBounds(10, 11, 396, 14);
        frame.getContentPane().add(mainLabel);

        String choices[] = { "Circle", "Square", "Triangle", "Rectangle", "Sphere", "Cube", "Cone", "Cylinder",
                "Torus" };
        JComboBox<String> comboBox = new JComboBox<>(choices);
        comboBox.setBounds(158, 36, 120, 25);
        frame.getContentPane().add(comboBox);

        JButton createButton = new JButton("Create Shape");
        createButton.setBounds(158, 69, 120, 25);
        frame.getContentPane().add(createButton);

        createButton.addActionListener(e -> {
            String selectedShape = comboBox.getSelectedItem().toString();
            switch (selectedShape) {
                case "Circle":

                    while (true) {
                        try {
                            String circleRadiusString = JOptionPane.showInputDialog("Enter the radius of the Circle: ");
                            if (circleRadiusString == null) {
                                break;
                            }
                            Integer circleRadius = Integer.parseInt(circleRadiusString);
                            new Circle(circleRadius);
                            break;

                        } catch (Exception err) {
                            System.out.println(err.toString());
                            JOptionPane.showMessageDialog(null, "Invalid Entry. Try again.");
                        }
                    }

                    break;
                case "Square":

                    while (true) {
                        try {
                            String squareLengthString = JOptionPane.showInputDialog("Enter the side of the Square: ");
                            if (squareLengthString == null) {
                                break;
                            }
                            Integer squareLength = Integer.parseInt(squareLengthString);
                            new Square(squareLength);
                            break;
                        } catch (Exception err) {
                            System.out.println(err.toString());
                            JOptionPane.showMessageDialog(null, "Invalid Entry. Try again.");
                        }
                    }
                    break;
                case "Triangle":

                    while (true) {
                        try {
                            String triangleLengthString = JOptionPane
                                    .showInputDialog("Enter the side of the Triangle: ");
                            if (triangleLengthString == null) {
                                break;
                            }
                            Integer triangleLength = Integer.parseInt(triangleLengthString);
                            new Triangle(triangleLength);
                            break;
                        } catch (Exception err) {
                            System.out.println(err.toString());
                            JOptionPane.showMessageDialog(null, "Invalid Entry. Try again.");
                        }
                    }
                    break;
                case "Rectangle":

                    while (true) {
                        try {
                            String rectangleHeightString = JOptionPane
                                    .showInputDialog("Enter the height of the Rectangle: ");
                            if (rectangleHeightString == null) {
                                break;
                            }
                            Integer rectangleHeight = Integer.parseInt(rectangleHeightString);
                            String rectangleWidthString = JOptionPane
                                    .showInputDialog("Enter the width of the Rectangle: ");
                            if (rectangleWidthString == null) {
                                break;
                            }
                            Integer rectangleWidth = Integer.parseInt(rectangleWidthString);
                            new Rectangle(rectangleHeight, rectangleWidth);
                            break;
                        } catch (Exception err) {
                            System.out.println(err.toString());
                            JOptionPane.showMessageDialog(null, "Invalid Entry. Try again.");
                        }
                    }
                    break;
                case "Sphere":

                    while (true) {
                        try {
                            String sphereRadiusString = JOptionPane.showInputDialog("Enter the radius of the Sphere: ");
                            if (sphereRadiusString == null) {
                                break;
                            }
                            Double sphereRadius = Double.parseDouble(sphereRadiusString);
                            new Sphere(sphereRadius);
                            break;
                        } catch (Exception err) {
                            System.out.println(err.toString());
                            JOptionPane.showMessageDialog(null, "Invalid Entry. Try again.");
                        }
                    }
                    break;
                case "Cube":

                    while (true) {
                        try {
                            String cubeEdgeLengthString = JOptionPane
                                    .showInputDialog("Enter the edge length of the Cube: ");
                            if (cubeEdgeLengthString == null) {
                                break;
                            }
                            Double cubeEdgeLength = Double.parseDouble(cubeEdgeLengthString);
                            new Cube(cubeEdgeLength);
                            break;
                        } catch (Exception err) {
                            System.out.println(err.toString());
                            JOptionPane.showMessageDialog(null, "Invalid Entry. Try again.");
                        }
                    }
                    break;
                case "Cone":

                    while (true) {
                        try {
                            String coneRadiusString = JOptionPane.showInputDialog("Enter the radius of the Cone: ");
                            if (coneRadiusString == null) {
                                break;
                            }
                            Double coneRadius = Double.parseDouble(coneRadiusString);
                            String coneHeightString = JOptionPane.showInputDialog("Enter the height of the Cone: ");
                            if (coneHeightString == null) {
                                break;
                            }
                            Double coneHeight = Double.parseDouble(coneHeightString);
                            new Cone(coneRadius, coneHeight);
                            break;
                        } catch (Exception err) {
                            System.out.println(err.toString());
                            JOptionPane.showMessageDialog(null, "Invalid Entry. Try again.");
                        }
                    }
                    break;
                case "Cylinder":

                    while (true) {
                        try {
                            String cylinderRadiusString = JOptionPane
                                    .showInputDialog("Enter the radius of the Cylinder: ");
                            if (cylinderRadiusString == null) {
                                break;
                            }
                            Double cylinderRadius = Double.parseDouble(cylinderRadiusString);
                            String cylinderHeightString = JOptionPane
                                    .showInputDialog("Enter the height of the Cylinder: ");
                            if (cylinderHeightString == null) {
                                break;
                            }
                            Double cylinderHeight = Double.parseDouble(cylinderHeightString);
                            new Cylinder(cylinderRadius, cylinderHeight);
                            break;
                        } catch (Exception err) {
                            System.out.println(err.toString());
                            JOptionPane.showMessageDialog(null, "Invalid Entry. Try again.");
                        }
                    }
                    break;
                case "Torus":

                    while (true) {
                        try {
                            String torusInnerRadiusString = JOptionPane
                                    .showInputDialog("Enter the inner radius of the Torus: ");
                            if (torusInnerRadiusString == null) {
                                break;
                            }
                            Double torusInnerRadius = Double.parseDouble(torusInnerRadiusString);
                            String torusOuterRadiusString = JOptionPane
                                    .showInputDialog("Enter the outer radius of the Torus: ");
                            if (torusOuterRadiusString == null) {
                                break;
                            }
                            Double torusOuterRadius = Double.parseDouble(torusOuterRadiusString);
                            new Torus(torusInnerRadius, torusOuterRadius);
                            break;
                        } catch (Exception err) {
                            System.out.println(err.toString());
                            JOptionPane.showMessageDialog(null, "Invalid Entry. Try again.");
                        }
                    }
                    break;
            }
        });

        frame.setResizable(false);
        frame.setVisible(true);
    };
}
