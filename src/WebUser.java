/**
 * 
 */

/**
 * @author Andy King
 *
 */

enum UserState 
{ 
    New, Active, Blocked, Banned; 
} 

public class WebUser extends Customer {
	private String login_id;
	private String password;
	private UserState state;
}
