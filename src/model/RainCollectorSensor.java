package model;

import java.text.DecimalFormat;

/**
 * The sensor for monitoring the amount of rain that has fallen in a 
 * specified period of time measure in rain clicks. 1 click = 0.2mm
 * 
 * @author Sierra Counts
 */
public class RainCollectorSensor extends AbstractSensor {


	/** 
	 * Holds value for how many clicks are held in measuring cup 
	 */
	private int clicks;
	
	/**
	 * Tells whether measurements are in mm or inches.
	 */
	private boolean metric;
	
	/**
	 * the final result of clicks times the unit of measure.
	 */
	private double result; 
	
	/**
	 * The constructor for this class. Initializes the number of clicks measured to 0.
	 */
	public RainCollectorSensor() {
		clicks = 0;
		metric = true; 
	}
	
	/**
	 * This method collects the data from the new sensor reading. If the reading is below 0 it is
	 * up to 0. similarly it is rounded to 9999 if the reading is above that value.
	 */
	public void recalibrateData() {
		clicks = Integer.parseUnsignedInt(ProxyData.getRainCollector(),2);
//		if (clicks < 0) clicks = 0;
//		else if (clicks > 65535) clicks = 65535;
	}
	
	/**
	 * Returns the number of clicks measures from the most recent reading.
	 * Potentially could add functionality to return measurements in inches or mm.
	 * 
	 * @return The number of clicks multiplied by the units of measure.
	 */
	public double getReading() {
		result = clicks;
		if(metric) result *= 0.2;
		else result *= 0.01;
		return result;
		
	}
	
	/**
	 * Switches the units of measure between mm and inches.
	 * 
	 * @param b The boolean for if the units are metric.
	 */
	public void setUnitsMetric(boolean b) {
		metric = b;
	}
	
	//@Override
	public String toString() {
		if (metric) return result + " mm in the collector.";
		else return result + " in. in the collector.";
	}
}
