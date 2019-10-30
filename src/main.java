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
		whiteBoxTest();
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
		System.out.println("Creating 5 products...");
		Product[] products = new Product[5];
		products[0] = new Product("Legend of Zelda", new Supplier("Nintendo"));
		products[1] = new Product("Windex", new Supplier("SC Johnson"));
		products[2] = new Product("Laptop", new Supplier("Dell"));
		products[3] = new Product("S10 Plus", new Supplier("Samsung"));
		products[4] = new Product("Refridgerator", new Supplier("LG"));
		
		for(int i = 0; i<products.length;i++) {
			System.out.println(products[i]);
		}
		
		System.out.println("\nCreating 5 customers...");
		Customer[] customers = new Customer[5];

		for(int i = 0; i<customers.length;i++) {
			customers[i] = new Customer(new Phone("925", "872-1756"), "1andyking1@gmail.com");
			System.out.println(customers[i]);
		}
		
		Customer tester = customers[3];
		
		//System.out.println("\nRegistering " + tester + " as WebUser...");
		//tester = tester.registerAsWebUser();
		//System.out.println(tester);
		
		System.out.println("\nAdding items to ShoppingCart for " + tester);
		
		
		Product testerProduct1 = products[3];
		Product testerProduct2 = products[1];
		tester.getCart().addLineItem(new LineItem(2, testerProduct1, new Price(Price.Currency.USD, 549.99)));
		System.out.println(tester + " added 2x " + testerProduct1 + " to cart.");
		tester.getCart().addLineItem(new LineItem(1, testerProduct2, new Price(Price.Currency.USD, 9.99)));
		System.out.println(tester + " added 1x " + testerProduct2 + " to cart.");
		System.out.println(tester + "'s current Shopping Cart: ");
		System.out.println(tester.getCart());
		
		tester.setBillingAddress(new Address("1234 Happy Street", "Hayward", "CA", "94565", "USA"));
		tester.setShippingAddress(tester.getBillingAddress());
		System.out.println(tester.toStringFull() + " set billing and shipping address");
		
		
		System.out.println("\n" + tester + " finalized order.");
		Order order = tester.createOrder();
		System.out.println(order);
		
		Payment payment1 = new Payment(tester, 600, "Payment 1 of 2");
		Payment payment2 = new Payment(tester, 509.97, "Payment 2 of 2");
		order.addPayment(payment1);
		order.addPayment(payment2);
		System.out.println(tester + " submitted payment: " + payment1);
		System.out.println(tester + " submitted payment: " + payment2);
		
		System.out.println(order);
	}
}
