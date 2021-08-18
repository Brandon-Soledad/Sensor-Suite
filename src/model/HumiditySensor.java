package model;

/**
 * The sensor dedicated to the humidity provided by the device.
 * 
 * @author Andrew Josten
 */
public class HumiditySensor extends AbstractSensor{
	/**
	 * Holds the value of the humidity sensor
	 */
    private int humidity;

    /**
     * Constructor. Initializes humidity to 1.
     * To change humidity value, call recalibrateData()();
     */
    public HumiditySensor(){
        humidity = 1;
    }

    /**
     * Returns int representation of humidity in range of 1 to 100 %
     * 
     * @returns humidity as an int
     */
    public int getSensorReading(){
        return humidity;
    }

    /**
     * Returns string representation of humidity
     * in format of "1 %"
     * 
     * @return A string representation of humidity percentage
     */
    public String toString(){
        return humidity + "%";
    }

    /**
     * Sets the humidity in this class by pulling from raw data (in this case, the proxy class). 
     * If out of range (1 to 100 %) rounds to nearest edge value. 
     */
	@Override
	public void recalibrateData() {
        String binary = ProxyData.getHumidity();//gets binary val from proxy        
    	humidity = Integer.parseInt(binary, 2);
        
        //This techincally works. Removed to make use of getDecimal()
        //humidity = Integer.parseUnsignedInt(ProxyData.getHumidity(),2);

//    	if(humidity < 1) {
//    		humidity = 1;
//    	}
//    	else if(humidity > 100) {
//    		humidity = 100;
//    	}		
	}
}
