package cecs277DemoTermProject;
/**
 * RoachPal class to create a RoachPal for colony to use.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public class RoachPal implements PaymentStrategy {
    /** Email for RoachPal Account. */
    private String email;
    /** Name of the colony paying the bill. */
    private String name;
    
    /**
     * Overloaded Constructor to create a Paypal Account.
     * @param emailID       Email for RoachPal Account
     * @param name          Name for RoachPal Account
     */
    public RoachPal(String name, String emailID) {
        this.email = emailID;
        this.name = name;
    }

    @Override
    public String pay(double price) {
    	String output = name + " have paid $" + price
    			+ " via RoachPal email: " + email;
    	return output;
    }

    @Override
    public String toString() {
        return "RoachPal email: " + email + "\nName: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
