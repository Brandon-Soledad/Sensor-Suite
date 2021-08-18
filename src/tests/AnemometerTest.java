/*package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Anemometer;

class AnemometerTest {
    
    Anemometer myTestAnemometer;
   

    @BeforeEach
    void setUp() throws Exception {
        myTestAnemometer = new Anemometer();
    }

    @Test
    void testRecalibrateData() {
        String prevDir = myTestAnemometer.getCurrentWindDirection();
        String prevSpeed = myTestAnemometer.getCurrentWindSpeed();
        myTestAnemometer.recalibrateData();
        assertNotEquals(prevDir, myTestAnemometer.getCurrentWindDirection(), "Failed to recalibrate wind direction");
        assertNotEquals(prevSpeed, myTestAnemometer.getCurrentWindSpeed(), "Failed to recalibrate wind speed");
    }

}*/
