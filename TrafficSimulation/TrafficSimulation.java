import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TrafficSimulation {

	// Car Columns and Model
	private Object[][] emptyData = null;
	private String[] carTableColumns = new String[] { "Car", "X,Y [m]", "MPH" };
	private DefaultTableModel carModel = new DefaultTableModel(emptyData, carTableColumns) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int column) {
			// all cells false
			return false;
		}
	};

	// Traffic Light Columns and Model
	private String[] trafficLightTableColumns = new String[] { "Traffic Light", "X,Y [m]", "Color" };
	private DefaultTableModel trafficLightModel = new DefaultTableModel(emptyData, trafficLightTableColumns) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int column) {
			// all cells false
			return false;
		}
	};

	// Current Time Stamp
	private CurrentTimeStamp time;
	private Thread timeThread;
	private JTextField currentTimestampTextField = new JTextField();

	// Controls
	private boolean stopSimulation = false;
	private boolean pauseSimulation = false;

	// Counts
	private int carCount = 1;
	private int trafficLightCount = 1;

	// Distances
	private Double carStartDistance = 0.0;
	private int trafficLightDistance = 1000;

	// Speed
	private Double carStartSpeed = 75.0;

	// Lists
	private List<Car> carList = new ArrayList<>();
	private List<TrafficLight> trafficLightList = new ArrayList<>();

	private List<Thread> carThreads = new ArrayList<>();
	private List<Thread> trafficLightThreads = new ArrayList<>();

	private Object lock = new Object();

	// Constructor
	public TrafficSimulation() {
		// JFrame
		JFrame frame = new JFrame();
		frame.setTitle("Traffic Simulation");
		frame.setBounds(100, 100, 859, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// Main Label
		JLabel trafficSimulationLabel = new JLabel("Traffic Simulation");
		trafficSimulationLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		trafficSimulationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trafficSimulationLabel.setBounds(10, 15, 200, 14);
		frame.getContentPane().add(trafficSimulationLabel);

		// Car Table
		JTable carTable = new JTable(carModel);
		JScrollPane carTableScrollPane = new JScrollPane(carTable);
		carTableScrollPane.setBounds(220, 15, 250, 255);
		frame.getContentPane().add(carTableScrollPane);

		// Traffic Light Table
		JTable trafficLightTable = new JTable(trafficLightModel);
		JScrollPane trafficLightTableScrollPane = new JScrollPane(trafficLightTable);
		trafficLightTableScrollPane.setBounds(480, 15, 350, 255);
		frame.getContentPane().add(trafficLightTableScrollPane);

		// Current Time Stamp Label
		JLabel currentTimestampLabel = new JLabel("Current Timestamp:");
		currentTimestampLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentTimestampLabel.setBounds(10, 108, 200, 14);
		frame.getContentPane().add(currentTimestampLabel);

		// Current Time Stamp Text Field
		currentTimestampTextField.setBounds(10, 130, 200, 20);
		currentTimestampTextField.setEditable(false);
		frame.getContentPane().add(currentTimestampTextField);
		currentTimestampTextField.setColumns(10);
		currentTimestampTextField.setHorizontalAlignment(SwingConstants.CENTER);

		// Start Button
		JButton startButton = new JButton("Start Simulation");
		startButton.setBounds(10, 40, 200, 23);
		frame.getContentPane().add(startButton);

		// Stop Button
		JButton stopButton = new JButton("Stop Simulation");
		stopButton.setBounds(10, 74, 200, 23);
		frame.getContentPane().add(stopButton);
		stopButton.setEnabled(false);

		// Pause Button
		JButton pauseButton = new JButton("Pause/Continue");
		pauseButton.setBounds(10, 281, 200, 23);
		frame.getContentPane().add(pauseButton);
		pauseButton.setEnabled(false);

		// Add Car Button
		JButton addCarButton = new JButton("Add Car");
		addCarButton.setBounds(220, 281, 250, 23);
		frame.getContentPane().add(addCarButton);

		// Add Traffic Light Button
		JButton addTrafficLightButton = new JButton("Add Traffic Light");
		addTrafficLightButton.setBounds(480, 281, 350, 23);
		frame.getContentPane().add(addTrafficLightButton);

		// Set Frame Visible
		frame.setVisible(true);

		startButton.addActionListener((ActionEvent e) -> {

			if (carList.size() > 2 && trafficLightList.size() > 2) {
				// Set Button Flags
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				pauseButton.setEnabled(true);
				addCarButton.setEnabled(false);
				addTrafficLightButton.setEnabled(false);

				// Set Stop/Pause Flags
				stopSimulation = false;
				pauseSimulation = false;

				// Current Time Stamp
				time = new CurrentTimeStamp();
				timeThread = new Thread(time);
				timeThread.start();

				// Add Cars to Thread List then start threads
				carList.forEach(car -> carThreads.add(new Thread(car)));
				carThreads.forEach(thread -> thread.start());

				// Add Traffic Lights to Thread List then start threads
				trafficLightList.forEach(tl -> trafficLightThreads.add(new Thread(tl)));
				trafficLightThreads.forEach(thread -> thread.start());
			} else {
				// User message
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "There must be a minimum of 3 Cars and 3 Traffic Lights to Start the Simulation.");
			}

		});

		stopButton.addActionListener((ActionEvent e) -> {
			// Set Button Flags
			startButton.setEnabled(true);
			stopButton.setEnabled(false);
			pauseButton.setEnabled(false);
			addCarButton.setEnabled(true);
			addTrafficLightButton.setEnabled(true);

			// Set Stop/Pause Flags
			pauseSimulation = false;
			stopSimulation = true;

			// timeThread.interrupt();
			// carThreads.forEach(car -> car.interrupt());
			// trafficLightThreads.forEach(tl -> tl.interrupt());

			// Sleep so all threads can finish
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}

			// User message
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Simulation has ended. Thank you.");

			// Reset Simulation
			resetSimulation();

		});

		pauseButton.addActionListener((ActionEvent e) -> {

			if (pauseSimulation) {
				synchronized (lock) {
					lock.notifyAll();
				}

				pauseSimulation = false;

				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				pauseButton.setEnabled(true);
				addCarButton.setEnabled(false);
				addTrafficLightButton.setEnabled(false);

			} else {

				pauseSimulation = true;

				startButton.setEnabled(false);
				stopButton.setEnabled(false);
				pauseButton.setEnabled(true);
				addCarButton.setEnabled(false);
				addTrafficLightButton.setEnabled(false);
			}

		});

		addCarButton.addActionListener((ActionEvent e) -> {

			if (carCount < 6) {
				carList.add(new Car(carCount, carStartDistance, carStartSpeed));
				carStartDistance = carStartDistance + 250;
				carStartSpeed = carStartSpeed + 5;
				carCount++;
			} else {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Max Car Count Reached");
			}
		});

		addTrafficLightButton.addActionListener((ActionEvent e) -> {

			if (trafficLightCount < 6) {
				trafficLightList
						.add(new TrafficLight(trafficLightCount, trafficLightDistance, TrafficLightColor.GREEN));
				trafficLightDistance = trafficLightDistance + 1000;
				trafficLightCount++;
			} else {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Max Traffic Light Count Reached");
			}
		});

	}

	void resetSimulation() {

		while (carModel.getRowCount() > 0) {
			carModel.removeRow(0);
		}

		carList.clear();
		carThreads.clear();

		while (trafficLightModel.getRowCount() > 0) {
			trafficLightModel.removeRow(0);
		}

		trafficLightList.clear();
		trafficLightThreads.clear();

		currentTimestampTextField.setText("");

		carCount = 1;
		trafficLightCount = 1;

		carStartDistance = 0.0;
		trafficLightDistance = 1000;

		carStartSpeed = 75.0;
	}

	class CurrentTimeStamp implements Runnable {

		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a z");

		@Override
		public synchronized void run() {
			while (!stopSimulation) {

				SwingUtilities.invokeLater(() -> {
					currentTimestampTextField.setText(new String(timeFormat.format(new Date())));
				});

				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					System.out.println("Current Time Stamp ending...");
				}

				if (pauseSimulation) {
					synchronized (lock) {
						try {
							lock.wait();
						} catch (InterruptedException ex) {
							System.out.println("Current Time Stamp  waiting...");
						}
					}
				}
			}

		}
	}

	private class Car implements Runnable {
		private int number;
		private Double currentSpeed;
		private Double startSpeed;
		private Double distance;
		private int row;
		private DecimalFormat df = new DecimalFormat("###.##");
		private final Double metersPerSecond = 0.0044704;

		public Car(int num, Double carStartDistance, Double carStartSpeed) {
			this.number = num;
			this.currentSpeed = carStartSpeed;
			this.startSpeed = carStartSpeed;
			this.distance = carStartDistance;

			SwingUtilities.invokeLater(() -> {
				carModel.addRow(new Object[] { number, df.format(distance) + ",0", currentSpeed });
				row = carModel.getRowCount() - 1;
			});

		}

		@Override
		public synchronized void run() {
			while (!stopSimulation) {

				SwingUtilities.invokeLater(() -> {
					carModel.setValueAt(df.format(distance) + ",0", row, 1);
				});

				try {

					Thread.sleep(10);
					// 1 Mile per Hour = 0.44704 Meters per Second
					// 1 Mile per Hour = .0044704 Meters per 10 milliseconds
					distance += metersPerSecond * currentSpeed;
					distance = Math.round(distance * 100.0) / 100.0;

					for (TrafficLight tl : trafficLightList) {

						if (tl.getColor() == TrafficLightColor.RED) {
							if (distance > (tl.getDistance() - 1) && distance < tl.getDistance()) {
								currentSpeed = 0.0;
							}
						}

						if (tl.getColor() == TrafficLightColor.YELLOW || tl.getColor() == TrafficLightColor.GREEN) {

							currentSpeed = startSpeed;

						}
						try {
							SwingUtilities.invokeLater(() -> {
								carModel.setValueAt(currentSpeed, row, 2);

							});
						} catch (Exception e) {
							// Nothing
						}

					}

				} catch (InterruptedException e) {
					System.out.println("Car " + number + " ending...");
				}

				if (pauseSimulation) {
					synchronized (lock) {
						try {
							System.out.println("Car " + number + " paused...");
							lock.wait();
						} catch (InterruptedException ex) {
							System.out.println("Car " + number + " ending...");
						}
					}
				}

			}

		}

	}

	private class TrafficLight implements Runnable {
		private int number;
		private int row;
		private int distance;

		private TrafficLightColor trafficLightColor;
		DecimalFormat df = new DecimalFormat("###.#");

		public TrafficLight(int num, int trafficLightDistance, TrafficLightColor tlc) {
			this.number = num;
			this.distance = trafficLightDistance;
			this.trafficLightColor = tlc;
			SwingUtilities.invokeLater(() -> {
				trafficLightModel
						.addRow(new Object[] { number, df.format(distance) + ",0", trafficLightColor.toString() });
				row = trafficLightModel.getRowCount() - 1;
			});
		}

		@Override
		public void run() {
			while (!stopSimulation) {
				SwingUtilities.invokeLater(() -> {
					trafficLightModel.setValueAt(getColor().toString(), row, 2);
				});

				try {
					switch (trafficLightColor) {
					case GREEN:
						Thread.sleep(5000);
						break;
					case YELLOW:
						Thread.sleep(2000);
						break;
					case RED:
						Thread.sleep(20000);
						break;
					}

					if (pauseSimulation) {
						synchronized (lock) {
							try {
								System.out.println("Traffic Light " + number + " paused...");
								lock.wait();
							} catch (InterruptedException ex) {
								System.out.println("Traffic Light " + number + " ending...");
							}
						}
					}
				} catch (InterruptedException exc) {
					System.out.println("Traffic Light " + number + " ending...");
				}
				changeColor();
			}
		}

		private synchronized void changeColor() {
			switch (trafficLightColor) {
			case RED:
				trafficLightColor = TrafficLightColor.GREEN;
				break;
			case YELLOW:
				trafficLightColor = TrafficLightColor.RED;
				break;
			case GREEN:
				trafficLightColor = TrafficLightColor.YELLOW;
			}

			notify(); // signal that the light has changed
		}

		private synchronized TrafficLightColor getColor() {
			return trafficLightColor;
		}

		public int getDistance() {
			return distance;
		}

	}

	enum TrafficLightColor {
		RED, GREEN, YELLOW
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TrafficSimulation();
			}
		});
	}
}