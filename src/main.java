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
		blackBoxTest();
		
		System.out.println("\n\nWhite Box Testing of Account() class:");
		whitebox = true;
		//whiteBoxTest();
	}
	
	public static void whiteBoxTest() {
		System.out.println("\nCreating 3 accounts...");
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
		
	//2
		System.out.println("\n2. Account owns shopping cart and orders.");
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
		
		System.out.println("\n" + tester + " finalized an order.");
		Order order = tester.createOrder();
		System.out.println(tester + "'s order: ");
		System.out.println(tester.getOrders()[0]);
	
	//3
		System.out.println("\n3. Customer could register as a web user to be able to buy items online.");
		System.out.println("Registering " + tester + " as WebUser...");
		WebUser user = tester.registerAsWebUser();
		System.out.println(tester + " registered as " + user);
	
//		Customer is not required to be a web user because purchases could also be made by phone or by ordering from catalogues. 
//		Web user has login name which also serves as unique id. 
//		Web user could be in several states - new, active, temporary blocked, or banned, and be linked to a shopping cart. 
//		Shopping cart belongs to account. 
//		Account owns customer orders. 
//		Customer may have no orders. 
//		Customer orders are sorted and unique. 
//		Each order could refer to several payments, possibly none. 
//		Every payment has unique id and is related to exactly one account.
//		Each order has current order status. 
//		Both order and shopping cart have line items linked to a specific product. 
//		Each line item is related to exactly one product. 
//		A product could be associated to many line items or no item at all.

		
		
		
		
		
		
		
		
		
		
		tester.setBillingAddress(new Address("1234 Happy Street", "Hayward", "CA", "94565", "USA"));
		tester.setShippingAddress(tester.getBillingAddress());
		System.out.println(tester.toStringFull() + " set billing and shipping address");
		
		
		
		
		Payment payment1 = new Payment(tester, 600, "Payment 1 of 2");
		Payment payment2 = new Payment(tester, 509.97, "Payment 2 of 2");
		order.addPayment(payment1);
		order.addPayment(payment2);
		System.out.println(tester + " submitted payment: " + payment1);
		System.out.println(tester + " submitted payment: " + payment2);
		
		System.out.println(order);
	}
}
