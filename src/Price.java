	/**
 * 
 */

/**
 * @author Andy King
 * @apiNode Price stores the money amount of a LineItem paired with currency information.
 */

public class Price {
	public enum Currency {
		USD, EUR, GBP, CAD
	}
	private Currency currency;
	private double amount;
	
	/**
	 * Create instance of Price
	 * @param c Currency enum
	 * @param a Amount
	 */
	public Price(Currency c, double a) {
		currency = c;
		amount = a;
	}
	
	/**
	 * Get amount of Price.
	 * @return double amount
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Get currency enum of Price.
	 * @return currency enum
	 */
	public Currency getCurrency() {
		return currency;
	}
	
	public String toString() {
		return amount + " " + currency;
	}
}
