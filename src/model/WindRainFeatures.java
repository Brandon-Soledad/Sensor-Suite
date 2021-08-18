package model;//  Brandon Soledad

import java.io.File;
import java.util.ArrayList;
import application.Main;
import model.Anemometer;
import model.RainCollectorSensor;

/**
 * Represents the wind and rain features of the console receiver.
 * 
 * @author Jonathan Lee
 * @version 18 July 2020
 */
public class WindRainFeatures {
	
	/**
	 * Represents a record that keeps track of up to 24 rain records.
	 */
	private ArrayList<Double> myRainRecord;
	
	/**
	 * Represents a counter to keep track of the rain record capacity.
	 */
	private int myRainCt;
	
	/**
	 * Parameterless constructor used for creating the new wind and rain features.
	 */
	public WindRainFeatures() {
		myRainRecord = new ArrayList<Double>();
		myRainCt = 0;
	}

	/**
	 * Used to retrieve the data from the rain collector sensor. A new rain data
	 * is added to the rain record. If the rain record is currently at its
	 * maximum capacity then the head of the record is removed. 
	 * 
	 * @param theRainSensor is the rain collector sensor whose data will be
	 * processed by the console receiver.
	 * @return the data collected by the rain collector sensor.
	 */
	public double getRain(RainCollectorSensor theRainSensor) {
		theRainSensor.recalibrateData();
		double rain = theRainSensor.getReading();
		if (myRainCt == 24) {
			myRainRecord.remove(0);
		} else {
			myRainCt++;
		}
		myRainRecord.add(rain);
		return rain;
	}
	
	/**
	 * Getter method for the rain record for accessing all of the
	 * rain data collected.
	 * 
	 * @return a record for keeping track of rain data.
	 */
	public ArrayList<Double> getRainRecord() {
		return myRainRecord;
	}
	
	/**
	 * Getter method for retrieving the wind direction data collected by the anemometer.
	 * 
	 * @param theAnem1 is the anemometer whose data will be processed by
	 * the console receiver.
	 * @return the wind direction collected by the anemometer.
	 */
	public int getWindDirect(Anemometer theAnem1) {
		theAnem1.recalibrateData();
		String windStr = theAnem1.getCurrentWindDirection();
		String num = windStr.substring(0, windStr.length() - 1);
		int windNum = Integer.parseInt(num);
		return windNum;
	}
	
	/**
	 * Getter method for retrieving the wind speed data collected by the anemometer
	 * 
	 * @param theAnem2 is the anemometer whose data will be displayed by the
	 * console receiver.
	 * @return the wind speed collected by the anemometer.
	 */
	public int getWindSpeed(Anemometer theAnem2) {
		theAnem2.recalibrateData();
		String windStr2 = theAnem2.getCurrentWindSpeed();
		String num = windStr2.substring(0, windStr2.length() - 4);
		int speedNum = Integer.parseInt(num);
		return speedNum;
	}
	
	
}
