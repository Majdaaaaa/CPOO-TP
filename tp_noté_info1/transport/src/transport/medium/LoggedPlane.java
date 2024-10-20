package transport.medium;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import transport.exceptions.OutOfReachException;
import transport.exceptions.OverweightException;

public class LoggedPlane implements Plane {

	private static Logger LOGGER = Logger.getLogger(LoggedPlane.class.getName());

	private final Plane actual;
	private BufferedWriter writer;

	public LoggedPlane(Plane actual, BufferedWriter writer) {
		super();
		this.actual = actual;
		this.writer = writer;
	}

	public void load(int weight) {
		try {
			writer.append("Loading ");
			writer.append(Integer.toString(weight));
			writer.append("kg");
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
		try {
			actual.load(weight);
		} catch (Exception e) {
			try {
				writer.append("... FAILED\n");
				writer.flush();
			} catch (IOException e2) {
				LOGGER.log(Level.SEVERE, "Failed to write to file", e2);
			}
			throw e;
		}
		try {
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
	}

	public void unload(int weight) {
		try {
			writer.append("Unloading ");
			writer.append(Integer.toString(weight));
			writer.append("kg");
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
		try {
			actual.unload(weight);
		} catch (Exception e) {
			try {
				writer.append("... FAILED\n");
				writer.flush();
			} catch (IOException e2) {
				LOGGER.log(Level.SEVERE, "Failed to write to file", e2);
			}
			throw e;
		}
		try {
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
	}

	public void takeoff() throws OverweightException {
		try {
			writer.append("Taking off");
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
		try {
			actual.takeoff();
		} catch (Exception e) {
			try {
				writer.append("... FAILED\n");
				writer.flush();
			} catch (IOException e2) {
				LOGGER.log(Level.SEVERE, "Failed to write to file", e2);
			}
			throw e;
		}
		try {
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
	}

	public void land() {
		try {
			writer.append("Landing");
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
		try {
			actual.land();
		} catch (Exception e) {
			try {
				writer.append("... FAILED\n");
				writer.flush();
			} catch (IOException e2) {
				LOGGER.log(Level.SEVERE, "Failed to write to file", e2);
			}
			throw e;
		}
		try {
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
	}

	public boolean isFlying() {
		return actual.isFlying();
	}

	public void fly(int distance) throws OutOfReachException {
		try {
			writer.append("Flying ");
			writer.append(Integer.toString(distance));
			writer.append("km");
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
		try {
			actual.fly(distance);
		} catch (Exception e) {
			try {
				writer.append("... FAILED\n");
				writer.flush();
			} catch (IOException e2) {
				LOGGER.log(Level.SEVERE, "Failed to write to file", e2);
			}
			throw e;
		}
		try {
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Failed to write to file", e);
		}
	}

	public int currentLoad() {
		return actual.currentLoad();
	}

	public int maxLoad() {
		return actual.maxLoad();
	}

	public int maxReach() {
		return actual.maxReach();
	}

}
