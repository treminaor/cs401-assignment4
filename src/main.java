/**
 * 
 */

/**
 * @author Andy King
 *
 */
public class main {

	/**
	 * @param args
	 */
	
	public static boolean whitebox = false;
	
	public static void main(String[] args) {
		System.out.println("Black Box Testing:");
		blackBoxTest();
		
		System.out.println("\n\nWhite Box Testing of Account() class:");
		whitebox = true;
		whiteBoxTest();
	}
	
	public static void whiteBoxTest() {
		System.out.println("\nCreating 3 accounts 3 different ways...");
		Account account = new Account();
		Account account1 = new Account("username1234");
		Account account2 = new Account(new Address("1234 Happy Street", "Hayward", "CA", "94565", "USA"));
		account2.getID();
		account2.getBillingAddress();
		account2.getCart();
		account2.toString();
		account2.createOrder();
		account2.closeAccount();
	}
	
	public static void blackBoxTest() {
	//1	
		System.out.println("\n1. Each customer has unique id and is linked to exactly one account.");
		System.out.println("Creating 5 customers...");
		Customer[] customers = new Customer[5];

		for(int i = 0; i<customers.length;i++) {
			customers[i] = new Customer(new Phone("925", "872-1756"), "1andyking1@gmail.com");
			System.out.println(customers[i] + " initalized.");
		}
		
	//2a
	//2b
	//2c
	//2d
		System.out.println("\n2a. Account owns shopping cart and orders.");
		System.out.println("2b. Customer is not required to be a web user because purchases could also be made by phone or by ordering from catalogues.");
		System.out.println("2c. Shopping cart belongs to account.");
		System.out.println("2d. Account owns customer orders.");
		Customer tester = customers[3];
		
		System.out.println("Creating 2 products...");
		Product[] products = new Product[2];
		products[0] = new Product("Windex", new Supplier("SC Johnson"));
		products[1] = new Product("S10 Plus", new Supplier("Samsung"));
		
		for(int i = 0; i<products.length;i++) {
			System.out.println(products[i]);
		}
		
		System.out.println("\nAdding items to ShoppingCart for " + tester);
		
		Product testerProduct1 = products[0];
		Product testerProduct2 = products[1];
		tester.getCart().addLineItem(new LineItem(2, testerProduct1, new Price(Price.Currency.USD, 549.99)));
		System.out.println(tester + " added 2x " + testerProduct1 + " to cart.");
		tester.getCart().addLineItem(new LineItem(1, testerProduct2, new Price(Price.Currency.USD, 9.99)));
		System.out.println(tester + " added 1x " + testerProduct2 + " to cart.");
		System.out.println("\n" + tester + "'s cart: ");
		System.out.println(tester.getCart());
		tester.setBillingAddress(new Address("1234 Happy Street", "Hayward", "CA", "94565", "USA"));
		tester.setShippingAddress(tester.getBillingAddress());
		System.out.println(tester.toStringFull() + " set billing and shipping address");
		System.out.println("\n" + tester + " finalized an order.");
		Order order = tester.createOrder();
		System.out.println(tester + "'s order: ");
		System.out.println(tester.getOrders()[0]);
	
	//3
		System.out.println("\n3. Customer could register as a web user to be able to buy items online.");
		System.out.println("Registering " + tester + " as WebUser...");
		WebUser user = tester.registerAsWebUser();
		System.out.println(tester + " registered as " + user);
	
	//4
		System.out.println("\n4. Web user has login name which also serves as unique id.");
		System.out.println(user + "'s id is now \"" + user.getID() + "\", old id was " + tester.getID());
		
	//5
		System.out.println("\n5. Web user could be in several states - new, active, temporary blocked, or banned, and be linked to a shopping cart.");
		System.out.println(user);
		user.setActive();
		System.out.println(user);
		user.setBlocked();
		System.out.println(user);
		user.setBanned();
		System.out.println(user);
		
	//6
		System.out.println("\n6. Customer may have no orders.");
		System.out.println(customers[0] + "'s orders: " + customers[0].getOrdersSize());
		
	//7
		System.out.println("\n7. Customer orders are sorted and unique.");
		tester.getCart().addLineItem(new LineItem(2, testerProduct1, new Price(Price.Currency.USD, 549.99)));
		System.out.println(tester + " added 2x " + testerProduct1 + " to cart.");
		tester.getCart().addLineItem(new LineItem(1, testerProduct2, new Price(Price.Currency.USD, 9.99)));
		System.out.println(tester + " added 1x " + testerProduct2 + " to cart.");
		System.out.println("\n" + tester + "'s cart: ");
		System.out.println(tester.getCart());
		
		System.out.println("\n" + tester + " finalized an order.");
		Order order2 = tester.createOrder();
		System.out.println(tester + "'s order history: ");
		for(int i=0; i<tester.getOrdersSize(); i++) {
			System.out.println(tester.getOrders()[i]);
		}
		
	//8a
	//8b
		System.out.println("\n8a. Each order could refer to several payments, possibly none.");
		System.out.println("8b. Every payment has unique id and is related to exactly one account.");
		System.out.println(order);
		Payment payment1 = new Payment(tester, 600, "Payment 1 of 2");
		Payment payment2 = new Payment(tester, 509.97, "Payment 2 of 2");
		order.addPayment(payment1);
		order.addPayment(payment2);
		System.out.println(tester + " submitted payment: " + payment1);
		System.out.println(tester + " submitted payment: " + payment2 + "\n");
		System.out.println(order);
		
	//9
		System.out.println("\n9. Each order has current order status.");
		System.out.println("Order Number " + order.getNumber() + " Status: " + order.getStatus());
		System.out.println("Shipping Order " + order.getNumber() + "... ");
		order.setShipped();
		System.out.println("Order Number " + order.getNumber() + " Status: " + order.getStatus());
	
	//10a
	//10b
	//10c
		System.out.println("\n10a. Both order and shopping cart have line items linked to a specific product.");
		System.out.println("10b. Each line item is related to exactly one product.");
		System.out.println("10c. A product could be associated to many line items or no item at all.");
		System.out.println("Product instance: " + testerProduct1);
		LineItem item1 = new LineItem(1, testerProduct1, new Price(Price.Currency.USD, 549.99));
		LineItem item2 = new LineItem(1, testerProduct1, new Price(Price.Currency.USD, 2.49));
		tester.getCart().addLineItem(item1);
		tester.getCart().addLineItem(item2);
		System.out.println(tester + "'s ShoppingCart instance (2 LineItems using same Product instance:");
		System.out.println(tester.getCart());
		Order newOrder = new Order();
		order.addLineItem(item1);
		order.addLineItem(item2);
		System.out.println(tester + "'s Order instance containing same LineItems referencing same Product:");
		System.out.println(order);
	}
}
