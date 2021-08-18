// package tests;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import model.IntegratedSensorSuite;

// class IntegratedSensorSuiteTest {

//     /** The degree symbol for use in formatted strings regarding temperature or angles. */
//     final static char DEGREE_SYMBOL = 0x00B0;
    
//     IntegratedSensorSuite myTestISS;
    
//     @BeforeEach
//     void setUp() throws Exception {
//         myTestISS = new IntegratedSensorSuite(1);
//     }

//     @Test
//     void testReinitializeData() {
//         myTestISS.reinitializeData();
//         int prevHumidity = myTestISS.myCurrentHumidity;
//         int prevTemp = myTestISS.myCurrentTemperature;
//         String prevWindSpeed = myTestISS.myCurrentWindSpeed;
//         String prevWindDirection = myTestISS.myCurrentWindDirection;
//         double prevRainAmount = myTestISS.myCurrentRainAmount;
//         myTestISS.reinitializeData();
//         // Only way to test for randomness, may occasionally fail since it is random.
//         assertNotEquals(prevHumidity, myTestISS.myCurrentHumidity, "failed to reinitialize humidity");
//         assertNotEquals(prevTemp, myTestISS.myCurrentTemperature, "failed to reinitialize temperature");
//         assertNotEquals(prevWindSpeed, myTestISS.myCurrentWindSpeed, "failed to reinitialize wind speed");
//         assertNotEquals(prevWindDirection, myTestISS.myCurrentWindDirection, "failed to reinitialize wind direction");
//         assertNotEquals(prevRainAmount, myTestISS.myCurrentRainAmount, "failed to reinitialize rain amount");
//     }

//     @Test
//     void testGetTransmitterId() {
//         assertEquals(1, myTestISS.getTransmitterId(), "Error at getTransmitterId()");
//     }

//     @Test
//     void testSetTransmitterId() {
//         myTestISS.setTransmitterId(5);
//         assertEquals(5, myTestISS.getTransmitterId(), "Error at setting transmitterId()");
//         assertNotEquals(1, myTestISS.getTransmitterId());
//     }

    
//     @Test
//     void testSetSensorReadings() {
//         myTestISS.setSensorReadings(2, 3, 4, 5, 6);
//         assertEquals("2", myTestISS.myCurrentWindDirection, "failed to set wind direction");
//         assertEquals("3", myTestISS.myCurrentWindSpeed, "failed to set wind speed");
//         assertEquals(4, myTestISS.myCurrentHumidity, "failed to set humidity");
//         assertEquals(5, myTestISS.myCurrentTemperature, "failed to set temperature");
//         assertEquals(6, myTestISS.myCurrentRainAmount, "failed to set rain amount");
//     }
    
//     @Test
//     void testToString() {
//         myTestISS.setSensorReadings(1, 2, 3, 4, 5);
//         assertEquals("Wind Direction: 1. Wind Speed: 2. Humidity: 3%. Temperature: 4" + DEGREE_SYMBOL + "F. RainAmount: 5.0", myTestISS.toString());
//     }

// }
