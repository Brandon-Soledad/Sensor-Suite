package model;

/**
 * The anemometer is a sensor that provides readings on the wind speed and direction.
 * @author chanteltrainer
 * @version 6/28/2020
 */
public class Anemometer extends AbstractSensor {
    
    /** The wind direction being detected by the anemometer and any point in time. */
    private String myWindDirection;
    
    /** The wind speed being detected by the anemometer and any point in time. */
    private String myWindSpeed;
    
    public Anemometer() {
        recalibrateData();
    }
    
    /** Returns the current wind direction at the moment that the method is called. (Finds a random data since these sensors are
     * proxies. 
     * @return myWindDirection - a formatted string which reports the direction of the wind
     */
    public String getCurrentWindDirection() {
        myWindDirection += DEGREE_SYMBOL; //format string
        return myWindDirection;
    }
    
    /** Returns the current wind speed at the moment that the method is called. (Finds a random data since these sensors are
     * proxies. 
     * @return myWindSpeed - a formatted string which reports the speed of the wind
     */
    public String getCurrentWindSpeed() {
        myWindSpeed += " MPH"; //format string
        return myWindSpeed;
    }
    
    /** reinitializes both wind data variables. */
    public void recalibrateData() {
        
        String binary = ProxyData.getWindDirection(); //gets random value in binary string format
        myWindDirection = Integer.toString(getDecimal(Integer.parseInt(binary))); //convert to int from binary, then to string
        
        binary = ProxyData.getWindSpeed(); //gets random value in binary string format
        myWindSpeed = Integer.toString(getDecimal(Integer.parseInt(binary))); //convert to int from binary, then to string
    }
    
}
