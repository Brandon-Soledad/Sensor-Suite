package model;

/**
 * The sensor dedicated to the temperature provided by the device.
 * 
 */
public class TemperatureSensor extends AbstractSensor{
	/**
	 * Holds the value of the temperature
	 */
    private int temp;

    /**
     * Constructor. Initializes temp to 0°.
     * To change temp value, call recalibrateData();
     */
    public TemperatureSensor(){
        temp = 0;
    }

    /**
     * Returns int representation of temperature in range of -40 to 150 F
     * 
     * @returns Temperature as an int
     */
    public int getSensorReading(){
        return temp;
    }

    /**
     * Returns string representation of temperature
     * in format of "0° F"
     * 
     * @return A string representation of temperature
     */
    public String toString() {
        return (temp + "° F");
    }

    /**
     * Sets the temp in this class by pulling from raw data (in this case, the proxy class). 
     * If out of range (-40 to 150 F) rounds to nearest edge value. 
     */
	@Override
	public void recalibrateData() {
        String binary = ProxyData.getTemperature();//gets binary val from proxy
    	temp = (int) Long.parseLong(binary, 2);

        //This technically works. Removed to make use of getDecimal()
		//temp = Integer.parseUnsignedInt(ProxyData.getTemperature(),2);
    	if(temp < -40) {
    		temp = -40;
    	}
    	else if(temp > 150) {
    		temp = 150;
    	}		
	}    
}
