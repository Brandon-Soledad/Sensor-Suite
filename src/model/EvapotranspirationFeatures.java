package model;
/**
 * Represents the Evapotranspiration features of the console receiver.
 * 
 * @author Noah Kehm
 * @version 22 July 2020
 */
public class EvapotranspirationFeatures {
	
	/**
	 * Variable to hold the final evapotranspiration value
	 */
	private Integer evapotranspiration;
	
	/**
	 * Variable to hold the soil heat flux
	 */
	private Integer soil;
	
	/**
	 * Variable to hold the solar radiation
	 */
	private Integer rad;

	/**
	 * Variable to hold the current instance of the proxyData
	 */
	private ProxyData dat;
	
	/**
	 * Variable to hold the soilTemp bit String
	 */
	private String soilTemp;
	
	/**
	 *  Variable to hold the UV Solar Radiation instance used to gather
	 *  solar radiation data
	 */
	private UVSolarRadiationFeatures UV;
	
	/**
	 * Variable to hold the outer temperature.
	 */
	private int outerTemp;
	
	/**
	 * Parameterized constructor
	 * assigns the global variable to the parameter and calculates the
	 * current evapotranspiration
	 * @param theProxyData The instance of the ProxyData class being used
	 * @param theTemp is a temperature sensor.
	 */
	public EvapotranspirationFeatures(ProxyData theProxyData,
									TemperatureSensor theTemp){
		dat = theProxyData;
		theTemp.recalibrateData();
		calculateEV(theTemp);
	}
	
	/**
	 * getter for the evapotranspiration variable
	 * 
	 * @param theTemp is a temperature sensor.
	 * @return the evapotranspiration value
	 */
	public Integer getEvapotranspiration(TemperatureSensor theTemp) {
		calculateEV(theTemp);
		return evapotranspiration;
	}
	
	/**
	 * Collects the sensible heat flux, solar radiation, and soil heat flux,
	 * and uses them to calculate the evapotranspiration.
	 * NOTE: This uses the Energy balance formula, where
	 * Evapotranspiration = Net Radiation - soil heat flux - sensible heat flux
	 * 
	 * @param theTemp is a temperature sensor.
	 */
	private void calculateEV(TemperatureSensor theTemp) {
		soilTemp = dat.getSoilHeatFlux();
		soil = Integer.parseInt(soilTemp, 2);
		UV = new UVSolarRadiationFeatures(dat);
		rad = UV.getSolarRad();
		outerTemp = theTemp.getSensorReading();
		evapotranspiration = rad - soil - outerTemp;
	}
}