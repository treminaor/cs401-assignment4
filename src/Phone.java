/**
 * 
 */

/**
 * @author Andy King
 *
 */
public class Phone {
	private String area;
	private String number;
	
	public Phone(String a, String n) {
		area = a;
		number = n;
	}
	
	public String toString() {
		return area + " " + number;
	}
}
