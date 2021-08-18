// package tests;

// import model.ProxyData;
// import model.RainCollectorSensor;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// class RainCollectorSensorTest {
	
// 	static ProxyData ProxyData = new ProxyData();
	
// 	@Test
// 	void test() {
// 		RainCollectorSensor rcs = new RainCollectorSensor();
// 		assertEquals(rcs.getReading(), 0.0);
		
// 		rcs.recalibrateData();		
// 		double r = rcs.getReading();
// 		assertTrue(r >= 0.0);
// 		assertTrue(r <= 65535.0);
		
// 		// Test toString() for mm;
// 		assertTrue(rcs.toString().equals(rcs.getReading()+" mm in the collector."));
		
// 		// Test toString() for inches
// 		rcs.setUnitsMetric(false);
// 		rcs.getReading();
// 		assertTrue(rcs.toString().equals(rcs.getReading()+" in. in the collector."));
// 	}
// }
