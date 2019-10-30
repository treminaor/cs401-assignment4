/**
 * 
 */

/**
 * @author Andy King
 * @apiNote Phone stores phone numbers formatted as a two-part string. Area Code is separated from the line number.
 */
public class Phone {
	private String area;
	private String number;
	
	/**
	 * Create instance of Phone.
	 * @param a Area Code
	 * @param n Line Number
	 */
	public Phone(String a, String n) {
		area = a;
		number = n;
	}
	
	public String toString() {
		return area + " " + number;
	}
}
