	/**
 * 
 */

/**
 * @author Andy King
 *
 */

public class Price {
	public enum Currency {
		USD, EUR, GBP, CAD
	}
	private Currency currency;
	private double amount;
	
	public Price(Currency c, double a) {
		currency = c;
		amount = a;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public String toString() {
		return amount + " " + currency;
	}
}
