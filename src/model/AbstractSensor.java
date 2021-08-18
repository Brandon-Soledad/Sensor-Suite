package model;
/**
 * AbstractSensor includes behavior of a sensor within the Integrated Sensor Suite. A sensor provides data to the Vantage Pro2 Console.
 * @author chanteltrainer
 * @version 6/28/20
 */
public abstract class AbstractSensor {
    
    /** The degree symbol for use in formatted strings regarding temperature or angles. */
    final static char DEGREE_SYMBOL = 0x00B0;
    
    /** This method will reach out to ProxyData for the appropriate static method for the sensor to be to be set to its variable(s).
     */
    public abstract void recalibrateData();
    
    /** Converts from binary to int. */
    public static int getDecimal(int binary){  
        int decimal = 0;  
        int n = 0;  
        while(true){  
          if(binary == 0){  
            break;  
          } else {  
              int temp = binary%10;  
              decimal += temp*Math.pow(2, n);  
              binary = binary/10;  
              n++;  
           }  
        }  
        return decimal;  
    } 
    
  
}
