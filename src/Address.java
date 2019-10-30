/**
 * 
 */

/**
 * @author Andy King
 * @apiNote Address stores the full address with each part stored as a separate string.
 */
public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
	/** 
	 * Create empty instance of Address
	 */
	public Address() {
		street = ""; 
		city = ""; 
		state = ""; 
		zipcode = ""; 
		country = "";
	}
	
	/**
	 * Create instance of Address
	 * @param s1 Street
	 * @param s2 City
	 * @param s3 State
	 * @param s4 Zipcode
	 * @param s5 Country
	 */
	public Address(String s1, String s2, String s3, String s4, String s5) {
		street = s1;
		city = s2;
		state = s3; 
		zipcode = s4;
		country = s5;
	}
	
	public String toString() {
		if(street == "")
			return "[No Address]";
		return street + ", " + city + ", " + state + ", " + zipcode + ", " + country;
	}
}
