/**
 * 
 */

/**
 * @author Andy King
 * @apiNote WebUser extends Customer which extends Account. WebUser can own one instance of ShoppingCart or unlimited (100) of Order because of inheritance from Account. Customer can be converted to WebUser by using Customer.registerAsWebUser()
 */

public class WebUser extends Customer {
	private String login_id;
	private String password;
	private UserState state;
	
	enum UserState  { 
	    New, Active, Blocked, Banned; 
	} 

	
	/*public WebUser(String login, String p) {
		super(login, phone, p);
		login_id = super.getID();
		password = p;
		state = UserState.New;
	}
	*/
	
	/**
	 * Create instance of WebUser
	 * @param c Account to use as base.
	 * @param p Password to use for this WebUser.
	 */
	public WebUser(Account c, String p) {
		login_id = c.getID();
		password = p;
		state = UserState.New;
	}
	
	/**
	 * Set this WebUser as Active.
	 */
	public void setActive() {
		state = UserState.Active;
	}
	
	/**
	 * Set this WebUser as Blocked.
	 */
	public void setBlocked() {
		state = UserState.Blocked;
	}
	
	/**
	 * Set this WebUser as Banned.
	 */
	public void setBanned() {
		state = UserState.Banned;
	}
	
	public String toString() {
		return "Web User " + login_id + " (State: " + state + ")";
	} 
}
