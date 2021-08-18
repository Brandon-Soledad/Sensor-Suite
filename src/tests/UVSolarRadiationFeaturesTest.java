// // Noah Kehm, Jonathan Lee
// // TCSS 360 A
// // Project 2, Group 7

// package tests;

// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import model.ProxyData;
// import model.UVSolarRadiationFeatures;

// /**
//  * Testing class used to test the UV and solar radiation features
//  * of the console receiver.
//  * 
//  * @author Noah Kehm
//  * @author Jonathan Lee
//  * @version 26 July 2020
//  *
//  */
// public class UVSolarRadiationFeaturesTest {
	
// 	/**
// 	 * Represents a proxy data for the sensors.
// 	 */
// 	private ProxyData theData;
	
// 	/**
// 	 * Represents UV and solar radiation features.
// 	 */
// 	private UVSolarRadiationFeatures theFeatures;
	
// 	/**
// 	 * Represents the solar radiation.
// 	 */
// 	private int mySolarRad;
	
// 	/**
// 	 * Represents the UV index.
// 	 */
// 	private int myUV;
	
// 	/**
// 	 * Used to set up the necessary components for testing.
// 	 */
// 	@BeforeEach
// 	public void setUp() {
// 		theData = new ProxyData();
// 		theFeatures = new UVSolarRadiationFeatures(theData);
// 		myUV = theFeatures.getUV();
// 		mySolarRad = theFeatures.getSolarRad();
// 	}
	
// 	/**
// 	 * Used to test the getSolarRad() method.
// 	 */
// 	@Test
// 	public void testGetSolarRad() {		
// 		for (int i = 0; i < 99; i++) {
// 			assertTrue(mySolarRad < 65535, "Out of bounds");
// 			mySolarRad = theFeatures.getSolarRad();
// 		}		
// 	}
	
// 	/**
// 	 * Used to test the getUV() method.
// 	 */
// 	@Test
// 	public void testGetUV() {
// 		for (int j = 0; j < 99; j++) {
// 			assertTrue(myUV < 14, "Out of bounds");
// 			myUV = theFeatures.getUV();
// 		}		
// 	}

// }
