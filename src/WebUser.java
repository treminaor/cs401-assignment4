/**
 * 
 */

/**
 * @author Andy King
 *
 */

enum UserState  { 
    New, Active, Blocked, Banned; 
} 

public class WebUser extends Customer {
	private String login_id;
	private String password;
	private UserState state;
	
	/*public WebUser(String login, String p) {
		super(login, phone, p);
		login_id = super.getID();
		password = p;
		state = UserState.New;
	}
	*/
	public WebUser(Account c, String password) {
		login_id = c.getID();
		password = "changeme";
		state = UserState.Active;
	}
	
	public void setActive() {
		state = UserState.Active;
	}
	
	public void setBlocked() {
		state = UserState.Blocked;
	}
	
	public void setBanned() {
		state = UserState.Banned;
	}
	
	public String toString() {
		return "Web User " + login_id + " (" + state + ")";	// STUB: Remove this line.
	} 
}
