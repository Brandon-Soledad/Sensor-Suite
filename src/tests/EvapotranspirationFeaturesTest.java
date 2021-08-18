// Noah Kehm, Jonathan Lee
// TCSS 360 A
// Project 2, Group 7

// package tests;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import model.EvapotranspirationFeatures;
// import model.ProxyData;
// import model.TemperatureSensor;

// /**
//  * A testing class used to test the evapotranspiration features of
//  * the console receiver.
//  * 
//  * @author Noah Kehm, Jonathan Lee
//  * @version 26 July 2020
//  *
//  */
// public class EvapotranspirationFeaturesTest {
	
// 	/**
// 	 * Represents proxy data that generates random values for sensors.
// 	 */
// 	private ProxyData myProxy;
	
// 	/**
// 	 * Represents the evapotranspiration features.
// 	 */
// 	private EvapotranspirationFeatures myEvap;
	
// 	/**
// 	 * Represents a temperature sensor.
// 	 */
// 	private TemperatureSensor myTemp;
	
// 	/**
// 	 * Used to set up the necessary components.
// 	 */
// 	@BeforeEach
// 	public void setUp() {
// 		myProxy = new ProxyData();
// 		myTemp = new TemperatureSensor();
// 		myTemp.recalibrateData();
// 		myEvap = new EvapotranspirationFeatures(myProxy, myTemp);
		
// 	}
	
// 	/**
// 	 * A testing class used to test getEvapotranspiration().
// 	 */
// 	@Test
// 	public void testGetEvapotranspiration() {
// 		int evData = myEvap.getEvapotranspiration(myTemp);
// 		for (int i = 0; i < 100; i++) {
// 			assertTrue(evData < 65374, "Out of bounds");
// 			myTemp.recalibrateData();
// 			evData = myEvap.getEvapotranspiration(myTemp);
// 		}
// 	}

// }
