package cecs277DemoTermProject;
/**
 * The PaymentStrategy interface for the Strategy Pattern,
 * 		which is used to figure out how much the colony
 * 		has to pay for motel.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public interface PaymentStrategy {
	/**
	 * Pays for the total price.
	 * @param price		The amount needing to be paid.
	 * @return String representation of the payment.
	 */
	String pay(double price);
}
