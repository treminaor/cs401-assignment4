import java.util.Date;

/**
 * 
 */

/**
 * @author Andy King
 *
 */

enum OrderStatus {
	New, Hold, Shipped, Delivered, Closed;
}

public class Order extends Account {
	private String number;
	private Date ordered;
	private Date shipped;
	private Address ship_to;
	private OrderStatus status;
	private Real total;
}
