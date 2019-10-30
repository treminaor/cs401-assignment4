import java.util.Date;
import java.util.Scanner;

/**
 *  @todo Account billing address constructor confusion
 */

/**
 * @author Andy King
 *
 */
public class Customer extends Account {
	private Address address;
	private Phone phone;
	private String email;
	
	public Customer() {
		super();
		address = super.getBillingAddress();
	}
	
	public Customer(Phone p, String e) {
		super();
		address = super.getBillingAddress();
		phone = p;
		email = e;
	}
	
	public Customer(String webuser_login_id, Phone p, String e) {
		super(webuser_login_id);
		address = super.getBillingAddress();
		phone = p;
		email = e;
	}
	
	public void setShippingAddress(Address a) {
		address = a;
	}
	
	public WebUser registerAsWebUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println(this + ", please finish your registration by entering a password: ");
		String password = scan.nextLine();
		return new WebUser(this, password);
	}
	
	public String toString() {
		return "Customer " + super.getID();
	} 
	
	public String toStringFull() {
		return "Customer " + super.getID() + " (" + address + ", " + phone + ", " + email + ")";
	}
}

