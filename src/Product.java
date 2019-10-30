/**
 * 
 */

/**
 * @author Andy King
 *
 */
public class Product {
	private String id;
	private String name;
	private Supplier supplier;
	
	private static long idCounter = 0;
	public static synchronized String createID() {
	    return String.valueOf(idCounter++);
	}   
	
	public Product(String n, Supplier s) {
		id = createID();
		name = n;
		supplier = s;
	}
	
	public String toString() {
		return "Product " + id + " (" + name + " from " + supplier + ")";
	}
}
