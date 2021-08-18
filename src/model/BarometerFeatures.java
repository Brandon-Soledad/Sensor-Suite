package model;

import java.lang.Math;

/**
 * Calculates barometer pressure using Wind Speed
 * 
 * @author Brandon Soledad
 * @version 7/22/2020
 */

public class BarometerFeatures {
    // Wind pressure
    private double pressure;

    // Pressure value
    private final double VALUE = 0.00256;

    private double PREVIOUSPRESSURE = 0.0;

    private Direction pressureDirection;

    public BarometerFeatures() {

    }

    // Calculates the Wind pressure using pounds per square foot as the wind speed
    // is in mph.
    public double calculateWindPressure(final WindRainFeatures wrf, final Anemometer theAnem2) {
        this.pressure = (double) Math.round((VALUE * (wrf.getWindSpeed(theAnem2))) * 100 ) / 100;
        return this.pressure;
    }
    // Used the Direction enum to decide which way the arrow should be pointing
    public Direction direction() {
        if(this.pressure > PREVIOUSPRESSURE) {
            pressureDirection = Direction.RISING;
            PREVIOUSPRESSURE = this.pressure;
        } else if(this.pressure < PREVIOUSPRESSURE) {
            pressureDirection = Direction.DECREASING;
            PREVIOUSPRESSURE = this.pressure;
        } else if(this.pressure == PREVIOUSPRESSURE) {
            pressureDirection = Direction.STEADY;
            PREVIOUSPRESSURE = this.pressure;
        }

        return pressureDirection;
    }
}
