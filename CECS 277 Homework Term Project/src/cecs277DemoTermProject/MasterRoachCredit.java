package cecs277DemoTermProject;
/**
 * The MasterRoach class to create a credit card for colony to use.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public class MasterRoachCredit implements PaymentStrategy {
    /** Name on Credit Card */
    private String name;
    /** Credit Card number */
    private String cardNumber;
    /** CVV number on Credit Card */
    private String cvv;
    /** Date of Expiration for Credit Card */
    private String dateOfExpiry;

    /**
     * Overloaded Constructor to create a Credit Card.
     * @param name          Name on the Credit Card
     * @param cardNumber    Credit Card number
     * @param cvv           CVV number on the Credit Card
     * @param dateOfExpiry  Date of expiration for Credit Card
     */
    public MasterRoachCredit(String name, String cardNumber, String cvv,
    		String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

	@Override
	public String pay(double price) {
        String temp = cardNumber.substring(cardNumber.length()-4);
    	String output = name + " have paid $" + price
    			+ " via credit/debit card: ********" + temp;
    	return output;
	}

	@Override
    public String toString() {
        String temp = cardNumber.substring(cardNumber.length() - 4);
        return "Card number: ********" + temp + "\nCard name: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
