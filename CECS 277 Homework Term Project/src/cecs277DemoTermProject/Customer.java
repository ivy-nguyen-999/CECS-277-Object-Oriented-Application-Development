package cecs277DemoTermProject;
/**
 * Customer interface, which acts like a subject interface.
 * @author Vy Nguyen and Nicki Huynh
 * @date 12/09/2019
 */
public interface Customer {
    /**
     * Adds a new customer to a motel.
     * @param motel     Which motel the customer is going to.
     * @return          True if customer was added.
     *                  False otherwise.
     */
    boolean registerManagement (Management motel);

    /**
     * Removed existing customer from motel.
     * @param motel     Which motel the customer is leaving.
     * @return          True if found and removed. False otherwise.
     */
    boolean removeManagement (Management motel);

    /**
     * Pass along the newest updates to management.
     */
	void notifyManagement();
}
