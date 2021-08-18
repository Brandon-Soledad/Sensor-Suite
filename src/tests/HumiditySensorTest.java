// package tests;
// import model.*;


// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.Test;
// /**
//  * JUnit test for HumiditySensor.
//  * NOTE: Cannot get full coverage because one branch in the if/else
//  * to ensure reading is in range won't be hit necessarily. 
//  * Since Proxy produces random values, this can't be hit on demand.
//  * @author Andrew Josten
//  */
// class HumiditySensorTest {
// 	static ProxyData ProxyData = new ProxyData();
		
// 	@Test
// 	void test() {
// 		//make new HS
// 		HumiditySensor hs = new HumiditySensor();
// 		assertEquals(hs.getSensorReading(), 1);
		
// 		//Test range
// 		hs.recalibrateData();		
// 		int h = hs.getSensorReading();
// 		assertTrue(h >= 1 && h <= 100);		
		
// 		//test toString();
// 		assertTrue(hs.toString().equals(hs.getSensorReading()+"%"));
// 	}
// }
