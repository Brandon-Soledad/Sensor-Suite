// // Jonathan Lee
// // TCSS 360 A
// // Project 2, Group 7

// package tests;

// import model.MoonPhase;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.assertTrue;

// /**
//  * Testing class used to test the moon phase feature of the console receiver.
//  *
//  * @author Jonathan Lee
//  * @version 20 July 2020
//  *
//  */
// public class MoonPhaseTest {

// 	/**
// 	 * Represents the moon phase feature.
// 	 */
// 	private MoonPhase myMoonPhase;

// 	/**
// 	 * Represents the number of days since the New Moon.
// 	 */
// 	private double myDays;

// 	/**
// 	 * Set up method for testing.
// 	 */
// 	@BeforeEach
// 	public void setUp() {
// 		MoonPhase myMoonPhase = new MoonPhase();
// 		myDays = myMoonPhase.getMoonPhase();
// 	}

// 	/**
// 	 * Used to test the getMoonPhase() method.
// 	 */
// 	@Test
// 	public void testGetMoonPhase() {
// 		assertTrue(myDays <= 31.0, "Days out of bounds");
// 	}

// }
