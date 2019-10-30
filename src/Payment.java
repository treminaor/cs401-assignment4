import java.util.Date;

/**
 * 
 */

/**
 * @author Andy King
 * @apiNode Payment belongs to exactly one instance of Account and is applied towards the total amount within instance(s) of Order which are owned by Account.
 */
public class Payment {
	private String id;
	private Date paid;
	private double total;
	private String details;
	private Account account;
	
	private static long idCounter = 0;
	
	/**
	 * Create unique sequential ID
	 * @return String id
	 */
	private static synchronized String createID() {
	    return String.valueOf(idCounter++);
	}   
	
	/**
	 * Create instance of Payment.
	 * @param a Account which submitted the payment
	 * @param t Payment total
	 * @param d	Any details regarding the payment
	 */
	public Payment(Account a, double t, String d) {
		id = createID();
		paid = new Date();
		total = t;
		details = d;
		account = a;
	}
	
	public String toString() {
		return "ID: " + id + ", Paid: " + paid + ", Total: " + total + " by " + account + " (Details: " + details + ")";
	}
}
