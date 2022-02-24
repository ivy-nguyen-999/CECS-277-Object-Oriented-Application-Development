/**
 A class that contains information on what services the customers used.
 Homework Assignment: File I/O
 @author Vy Nguyen and Nicki Huynh
 @date 10/21/2019
 */

public class Service {
	
	private String mCustomer;
	private String mService;
	private double mAmount;
	private String mDate;
	
	// Default constructor of Service
	public Service() {
		mCustomer = "";
		mService = "";
		mAmount = 0;
		mDate = "";
	}

	/**
	 * Overloaded constructor of Service
	 * @param name String name of customer
	 * @param service String name of what service the customer is used
	 * @param amount Double value for the price of service
	 * @param date String date of when the service was charged
	 */
	public Service(String name, String service, double amount, String date) {
		mCustomer = name;
		mService = service;
		mAmount = amount;
		mDate = date;
	}

	/**
	 * A getter method for the Customer's name
	 * @return String of cCstomer's name
	 */
	public String getCustomerName() {
		return mCustomer;
	}

	/**
	 * A setter method for the Customer's name
	 * @param name String of the Customer's name
	 */
	public void setCustomerName(String name) {
		mCustomer = name;
	}

	/**
	 * A getter method of the service the customer used
	 * @return String of the service name
	 */
	public String getServiceName() {
		return mService;
	}

	/**
	 * A setter method of the service the customer used
	 * @param service String of teh service name
	 */
	public void setServiceName(String service) {
		mService = service;
	}

	/**
	 * A getter method of the amount of money the customer spent for the service
	 * @return Double value of the amount of money spent
	 */
	public double getPrice() {
		return mAmount;
	}

	/**
	 * A setter method of the amount of money the customer spent for the service
	 * @param amount Double value of the amount of money spent
	 */
	public void setPrice(double amount) {
		mAmount = amount;
	}

	/**
	 * A getter method of the date the service occurred
	 * @return String value of the date
	 */
	public String getDate() {
		return mDate;
	}

	/**
	 * A setter method of the date the service occurred
	 * @param date String value of the date
	 */
	public void setDate(String date) {
		mDate = date;
	}

	/**
	 * Overrided method of toString
	 * @return String of Customer, service, amount, and date in order and format
	 */
	@Override
	public String toString() {
		return mCustomer + ";" + mService + ";" + mAmount + ";" + mDate;
	}
}
