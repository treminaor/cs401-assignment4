import java.util.Date;
import java.util.Scanner;

/**
 *  @todo Account billing address constructor confusion
 */

/**
 * @author Andy King
 * @apiNote Customer extends Account. Customer can own one instance of ShoppingCart or unlimited (100) of Order because of inheritance from Account.
 */
public class Customer extends Account {
	private Address address;
	private Phone phone;
	private String email;
	
	/**
	 * Create empty instance of Customer (uses parent Account billing_address as shipping adddress)
	 */
	public Customer() {
		super();
		address = super.getBillingAddress();
	}
	
	/**
	 * Create instance of Customer.
	 * @param p Phone
	 * @param e Email
	 */
	public Customer(Phone p, String e) {
		super();
		address = super.getBillingAddress();
		phone = p;
		email = e;
	}
	
	/**
	 * Create instance of Customer using WebUser login_id as unique id
	 * @param webuser_login_id
	 * @param p Phone
	 * @param e Email
	 */
	public Customer(String webuser_login_id, Phone p, String e) {
		super(webuser_login_id);
		address = super.getBillingAddress();
		phone = p;
		email = e;
	}
	
	/**
	 * Set shipping address for this Customer
	 * @param a Address
	 */
	public void setShippingAddress(Address a) {
		address = a;
	}
	
	/** 
	 * Register this Customer as a WebUser. Prompts user for password.
	 * @return WebUser
	 */
	public WebUser registerAsWebUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println(this + ", please choose a username: ");
		String username = scan.nextLine();
		System.out.println(this + ", please finish your registration by entering a password: ");
		String password = scan.nextLine();
		scan.close();
		return new WebUser(this, username, password);
	}
	
	public String toString() {
		return "Customer " + super.getID();
	} 
	
	public String toStringFull() {
		return "Customer " + super.getID() + " (" + address + ", " + phone + ", " + email + ")";
	}
}

