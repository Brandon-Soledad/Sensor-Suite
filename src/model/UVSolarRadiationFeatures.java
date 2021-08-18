package model;

/**
 * Represents the UV and Solar Radiation features of the console receiver.
 * 
 * @version 26 July 2020
 */
public class UVSolarRadiationFeatures {
	/**
	 * Variable to hold the bit string version of solar radiation
	 */
	private String mySolarRadBitString;
	/**
	 * Variable to hold the bit string version of UV 
	 */
	private String myUVBitString;
	/**
	 * Variable to hold the UV index
	 */
	private Integer myUV;
	/**
	 * Variable to hold the Solar Radiation index
	 */
	private Integer mySolarRad;
	
	private ProxyData myPD;
	
	/**
	 * Parameterized constructor
	 * Collects the UV and Solar Radiation Bit Strings from the ProxyData class
	 * and converts it back into an Integer.
	 * @param theProxyData The instance of the ProxyData class being used
	 */
	public UVSolarRadiationFeatures(ProxyData theProxyData){
		myPD = theProxyData;
		myUVBitString = myPD.getUltravioletIndex();
		mySolarRadBitString = myPD.getRadiationLevel();
		myUV = Integer.parseInt(myUVBitString, 2);
		mySolarRad = Integer.parseInt(mySolarRadBitString, 2);
	}
	/**
	 * Getter for the UV index
	 * @return the current UV index
	 */
	public Integer getUV() {
		myUVBitString = myPD.getUltravioletIndex();
		myUV = Integer.parseInt(myUVBitString, 2);
		return myUV;
	}
	/**
	 * Getter for the Solar Radiation index
	 * @return the current Solar Radiation index
	 */
	public Integer getSolarRad() {
		mySolarRadBitString = myPD.getRadiationLevel();
		mySolarRad = Integer.parseInt(mySolarRadBitString, 2);
		return mySolarRad;
	}
}